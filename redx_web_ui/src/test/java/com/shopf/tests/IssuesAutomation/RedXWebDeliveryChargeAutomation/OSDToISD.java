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

public class OSDToISD extends RedXWebBaseClass {

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

    @Test(groups = CoreConstants.GROUP_SMOKE,
            description = "Verifies Authentication With Valid Credentials",
            priority = 1)
    public void verifyAuthenticationWithValidCredentials() throws InterruptedException {
        System.out.println("Verify Authentication with valid credentials was called");
        loginPageObjects.performAuthentication("0140112217","6666","7");

    }

    @Test(groups = CoreConstants.GROUP_SANITY,
            description = "Verifies Delivery charge OSD to ISD(SameDistrict)",
            priority = 2)
    public void verifyOSDToISDSameDistricts() throws Exception {
        System.out.println("Verification of OSD to ISD Same District was called");

        //Verify Dhaka District(OSD) with same district ISD
        System.out.println("The size of the divisions in a OSDZones " + readJSONFileRedX.getDeliveryDivisionsUnderZones("OSD").size());
        division = readJSONFileRedX.getDeliveryDivisionsUnderZones("OSD").get(0);

        //Get Dhaka districts of OSD divisions for change shopLocation
        String OSDDistrict = readJSONFileRedX.getOSD(division).get(0);
        //Get random area form single district
        String OSDArea = String.valueOf(readJSONFileRedX.getOSD(OSDDistrict).get(random.nextInt(readJSONFileRedX.getOSD(OSDDistrict).size())));

        //Navigate to myShop page
        sleep(3000);
        actionBarObjects.clickOnDropDownButton();
        sleep(500);
        homePageObjects.clickOnDropDownMyShopButton();

        //Edit the shop with required location and deliveryZone
        myShopsPageObjects.editShopDetails(14, division,OSDDistrict,OSDArea,"customer Name" );
        myShopsPageObjects.clickOnShop(14);
        sleep(1000);


        for (int ISDDivision = 0; ISDDivision < readJSONFileRedX.getDeliveryDivisionsUnderZones("ISD").size(); ISDDivision++) {
            System.out.println("The size of the divisions in a zones " + readJSONFileRedX.getDeliveryDivisionsUnderZones("ISD").size());
            division = readJSONFileRedX.getDeliveryDivisionsUnderZones("ISD").get(ISDDivision);

            //Verification of area of different district
            for (int b = 0; b < readJSONFileRedX.getISD(division).size(); b++) {

                district = readJSONFileRedX.getISD(division).get(b);

                //same district condition
                if (district.equals(OSDDistrict)) {

                    for (int i = 0; i < readJSONFileRedX.getISD(district).size(); i++) {
                        area = String.valueOf(readJSONFileRedX.getISD(district).get(i));

                        if (i == 0) {
                            System.out.println("Total size of area located in same Dhaka District :" + readJSONFileRedX.getISD(district).size());
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
                            System.out.println("The DeliveryCharge issue occur while OSD(same district) to ISD");
                            System.out.println("The delivery charge was mismatched while from:" + OSDArea + " to " + area);
                        }
                        sleep(1000);
                    }
                }
            }
        }softAssert.assertAll();
    }

    @Test(groups = CoreConstants.GROUP_SANITY,
            description = "Verifies Delivery charge OSD to ISD(DifferentDistrict)",
            priority = 3)
    public void verifyOSDToISDDifferentDistricts() throws Exception {
        System.out.println("Verification of OSD to ISD Different District was called");

        //Verify Dhaka, Districts(OSD) with same district ISD
        System.out.println("The size of the divisions in a OSDZones " + readJSONFileRedX.getDeliveryDivisionsUnderZones("OSD").size());
        division = readJSONFileRedX.getDeliveryDivisionsUnderZones("OSD").get(0);

        //select Dhaka districts of OSD divisions for change shopLocation
        String OSDDistrict = readJSONFileRedX.getOSD(division).get(0);
        //Get random area form single district
        String OSDArea = String.valueOf(readJSONFileRedX.getOSD(OSDDistrict).get(random.nextInt(readJSONFileRedX.getOSD(OSDDistrict).size())));

        //Navigate to myShop page
        sleep(3000);
        actionBarObjects.clickOnDropDownButton();
        sleep(500);
        homePageObjects.clickOnDropDownMyShopButton();

        //Edit the shop with required location and deliveryZone
        myShopsPageObjects.editShopDetails(14, division,OSDDistrict,OSDArea,"customer Name" );
        myShopsPageObjects.clickOnShop(14);
        sleep(1000);


        for (int ISDDivision = 0; ISDDivision < readJSONFileRedX.getDeliveryDivisionsUnderZones("ISD").size(); ISDDivision++) {
            System.out.println("The size of the divisions in a zones " + readJSONFileRedX.getDeliveryDivisionsUnderZones("ISD").size());
            division = readJSONFileRedX.getDeliveryDivisionsUnderZones("ISD").get(ISDDivision);

            //Verification of area of different district
            for (int b = 0; b < readJSONFileRedX.getISD(division).size(); b++) {

                district = readJSONFileRedX.getISD(division).get(b);

                //different district condition
                if (!district.equals(OSDDistrict)) {

                    for (int i = 0; i < readJSONFileRedX.getISD(district).size(); i++) {
                        area = String.valueOf(readJSONFileRedX.getISD(district).get(i));

                        if (i == 0) {
                            System.out.println("Total size of area located in different Dhaka District :" + readJSONFileRedX.getISD(district).size());
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
                            System.out.println("The DeliveryCharge issue occur while OSD(different district) to ISD");
                            System.out.println("The delivery charge was mismatched while from:" + OSDArea + " to " + area);
                        }
                        sleep(1000);
                    }
                }
            }
        }softAssert.assertAll();
    }
}
