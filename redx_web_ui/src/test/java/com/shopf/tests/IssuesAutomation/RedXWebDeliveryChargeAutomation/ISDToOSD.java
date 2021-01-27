package com.shopf.tests.IssuesAutomation.RedXWebDeliveryChargeAutomation;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;
import org.testng.asserts.*;
import pageObjects.*;
import testData.*;
import utils.*;
import videoRecorder.*;
import java.util.*;

public class ISDToOSD extends RedXWebBaseClass {

    private WebDriver driver;
    private LoginPageObjects loginPageObjects;
    private HomePageObjects homePageObjects;
    private ActionBarObjects actionBarObjects;
    private MyActions myActions;
    private MyShopsPageObjects myShopsPageObjects;
    private CreateParcelPageObjects createParcelPageObjects;
    String codChargeText;
    String DeliveryText;
    String DeliveryAmount;
    String codAmount;
    String division;
    String district ;
    String area;
    String amount;
    String hundred;
    String sixty;
    String oneThirty;
    int deliveryCharge;
    int codCharge;
    private ReadJSONFileRedX readJSONFileRedX;
    private Random random;
    private RedXServiceRequestLayer redXServiceRequestLayer;
    private SoftAssert softAssert;

    @BeforeSuite(alwaysRun = true)
    public void redxBeforeSuite() throws Exception{
        System.out.println("RedX issue automation BeforeSuite is called");
        driver = getBaseDriver();
        browserMaximize();
        setImplicitWait(10);
        driver.get(getWebBaseUrl());
        System.setProperty("selling price","400");
        System.setProperty("sixty","60");
        System.setProperty("hundred","100");
        System.setProperty("oneThirty","130");
        ScreenRecorder.startRecording("");
    }

    @BeforeClass(alwaysRun = true)
    public void authenticationTestsBeforeClass(){
        System.out.println("RedX DeliveryChargeMismatchAutomation before class was called");
        loginPageObjects = new LoginPageObjects(driver);
        myActions = new MyActions();
        homePageObjects = new HomePageObjects(driver);
        actionBarObjects = new ActionBarObjects(driver);
        myShopsPageObjects = new MyShopsPageObjects(driver);
        createParcelPageObjects = new CreateParcelPageObjects(driver);
        amount = System.getProperty("selling price");
        sixty = System.getProperty("sixty");
        hundred = System.getProperty("hundred");
        oneThirty = System.getProperty("oneThirty");
        redXServiceRequestLayer = new RedXServiceRequestLayer();
        readJSONFileRedX = redXServiceRequestLayer.getControlOverReadJSONFileRedX();
        random = new Random();
        softAssert = new SoftAssert();
    }

    @Test(groups = CoreConstants.GROUP_SANITY,
            description = "Verifies Authentication With Valid Credentials",
            priority = 1)
    public void verifyAuthenticationWithValidCredentials() throws InterruptedException {
        System.out.println("Verify Authentication with valid credentials was called");
        loginPageObjects.performAuthentication("0140112216","6666","6");

    }

    @Test(groups = CoreConstants.GROUP_SANITY,
            description = "Verifies Delivery charge ISD to OSD(SameDistrict)",
            priority = 2)
    public void verifyISDToOSDSameDistricts() throws Exception {
        System.out.println("Verification of ISD to OSD Same District was called");

        //Verify Dhaka(ISD) with same district OSD
        System.out.println("The size of the divisions in a ISDZones " + readJSONFileRedX.getDeliveryDivisionsUnderZones("ISD").size());
        division = readJSONFileRedX.getDeliveryDivisionsUnderZones("ISD").get(0);

        //Get Dhaka district of ISD divisions for change shopLocation
        String ISDDistrict = readJSONFileRedX.getISD(division).get(0);
        //Get random area from single district
        String ISDArea = String.valueOf(readJSONFileRedX.getISD(ISDDistrict).get(random.nextInt(readJSONFileRedX.getISD(ISDDistrict).size())));

        //Navigate to myShop page
        sleep(3000);
        actionBarObjects.clickOnDropDownButton();
        sleep(500);
        homePageObjects.clickOnDropDownMyShopButton();

        //Edit the shop with required location and deliveryZone
        myShopsPageObjects.editShopDetails(14, division,ISDDistrict,ISDArea,"customer Name" );
        myShopsPageObjects.clickOnShop(14);
        sleep(1000);


        for (int OSDDivision = 0; OSDDivision < readJSONFileRedX.getDeliveryDivisionsUnderZones("OSD").size(); OSDDivision++) {
            System.out.println("The size of the divisions in a OSD zones " + readJSONFileRedX.getDeliveryDivisionsUnderZones("OSD").size());
            division = readJSONFileRedX.getDeliveryDivisionsUnderZones("OSD").get(OSDDivision);

            //Verification of area of different district
            for (int b = 0; b < readJSONFileRedX.getOSD(division).size(); b++) {

                district = readJSONFileRedX.getOSD(division).get(b);

                //same district condition
                if (district.equals(ISDDistrict)) {

                    for (int i = 0; i < readJSONFileRedX.getOSD(district).size(); i++) {
                        area = String.valueOf(readJSONFileRedX.getOSD(district).get(i));

                        if (i == 0) {
                            System.out.println("Total size of area located in sameDistrict :" + readJSONFileRedX.getOSD(district).size());
                            createParcelPageObjects.createNewParcel(division, district, area, 0, "");
                        }
                        //enter and apply address
                        createParcelPageObjects.enterAndApplyAddress(division, district, area, 0);

                        //Get DeliveryCharge and convert to Integer
                        DeliveryText = myActions.action_getText(createParcelPageObjects.deliveryCharge());
                        DeliveryAmount = DeliveryText.replaceAll("[^0-9]", "");
                        deliveryCharge = Integer.parseInt(DeliveryAmount) / 100;
                        try {
                            Assert.assertEquals(deliveryCharge, Integer.parseInt(oneThirty));
                            softAssert.assertEquals(deliveryCharge, Integer.parseInt(oneThirty));
                        } catch (AssertionError e) {
                            System.out.println("The DeliveryCharge issue occur while ISD(same district) to OSD");
                            System.out.println("The delivery charge was mismatched while from:" + ISDArea + " to " + area);
                        }
                        sleep(1000);
                    }
                }
            }
        }
        softAssert.assertAll();}

    @Test(groups = CoreConstants.GROUP_SANITY,
            description = "Verifies Delivery charge ISD to OSD(DifferentDistrict)",
            priority = 3)
    public void verifyISDToOSDDifferentDistricts() throws Exception {
        System.out.println("Verification of ISD to OSD Different District was called");

        //Verify Dhaka Districts(ISD) with same district OSD
        System.out.println("The size of the divisions in a ISDZones " + readJSONFileRedX.getDeliveryDivisionsUnderZones("ISD").size());
        division = readJSONFileRedX.getDeliveryDivisionsUnderZones("ISD").get(0);

        //Get Dhaka districts of ISD divisions for change shopLocation
        String ISDDistrict = readJSONFileRedX.getISD(division).get(0);
        //Get random area form single district
        String ISDArea = String.valueOf(readJSONFileRedX.getISD(ISDDistrict).get(random.nextInt(readJSONFileRedX.getISD(ISDDistrict).size())));

        //Navigate to myShop page
        sleep(3000);
        actionBarObjects.clickOnDropDownButton();
        sleep(500);
        homePageObjects.clickOnDropDownMyShopButton();

        //Edit the shop with required location and deliveryZone
        myShopsPageObjects.editShopDetails(14, division,ISDDistrict,ISDArea,"customer Name" );
        myShopsPageObjects.clickOnShop(14);
        sleep(1000);


        for (int OSDDivision = 0; OSDDivision < readJSONFileRedX.getDeliveryDivisionsUnderZones("OSD").size(); OSDDivision++) {
            System.out.println("The size of the divisions in a zones " + readJSONFileRedX.getDeliveryDivisionsUnderZones("OSD").size());
            division = readJSONFileRedX.getDeliveryDivisionsUnderZones("OSD").get(OSDDivision);

            //Verification of area of different district
            for (int b = 0; b < readJSONFileRedX.getOSD(division).size(); b++) {

                district = readJSONFileRedX.getOSD(division).get(b);

                //different district condition
                if (!district.equals(ISDDistrict)) {

                    for (int i = 0; i < readJSONFileRedX.getOSD(district).size(); i++) {
                        area = String.valueOf(readJSONFileRedX.getOSD(district).get(i));

                        if (i == 0) {
                            System.out.println("Total size of area located in differentDistrict :" + readJSONFileRedX.getOSD(district).size());
                            createParcelPageObjects.createNewParcel(division, district, area, 0, "");
                        }
                        //enter and apply address
                        createParcelPageObjects.enterAndApplyAddress(division, district, area, 0);

                        //Get DeliveryCharge and convert to Integer
                        DeliveryText = myActions.action_getText(createParcelPageObjects.deliveryCharge());
                        DeliveryAmount = DeliveryText.replaceAll("[^0-9]", "");
                        deliveryCharge = Integer.parseInt(DeliveryAmount) / 100;
                        try {
                            Assert.assertEquals(deliveryCharge, Integer.parseInt(oneThirty));
                            softAssert.assertEquals(deliveryCharge, Integer.parseInt(oneThirty));
                        } catch (AssertionError e) {
                            System.out.println("The DeliveryCharge issue occur while ISD(different district) to OSD");
                            System.out.println("The delivery charge was mismatched while from:" + ISDArea + " to " + area);
                        }
                        sleep(1000);
                    }
                }
            }
        }softAssert.assertAll();
    }
}
