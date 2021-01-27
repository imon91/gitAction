package com.shopf.tests.IssuesAutomation.RedXWebDeliveryChargeAutomation;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.*;
import pageObjects.*;
import testData.*;
import utils.*;
import videoRecorder.*;
import java.util.*;

public class OSDToSuburbs extends RedXWebBaseClass {

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
            description = "Verifies Delivery charge Suburbs to OSD SameDistrict",
            priority = 2)
    public void verifyOSDToSuburbsSameDistricts() throws Exception {
        System.out.println("Verification of OSD to SUBURBS different districts was called");
        sleep(3000);

        actionBarObjects.clickOnDropDownButton();
        sleep(500);
        homePageObjects.clickOnDropDownMyShopButton();
        System.out.println("The OSD shop location was set as Dohar which was in Dhaka district");
        //Choosing Dohar Shop
        sleep(1000);
//        myShopsPageObjects.editShopDetails(8, "dha","Dhaka","Dohar","customer Name" );
        myShopsPageObjects.clickOnShop(8);
        sleep(1000);


        System.out.println("The size of the divisions in a Suburb zones " + readJSONFileRedX.getDeliveryDivisionsUnderZones("Suburbs").size());
        //Selecting only division Dhaka
        division = readJSONFileRedX.getDeliveryDivisionsUnderZones("Suburbs").get(0);

        for (int a = 0; a < readJSONFileRedX.getSuburbs(division).size(); a++) {

            district = readJSONFileRedX.getSuburbs(division).get(a);

            //same district condition
            if (district.equals("Dhaka")) {

                for (int i = 0; i < readJSONFileRedX.getSuburbs(district).size(); i++) {
                    area = String.valueOf(readJSONFileRedX.getSuburbs(district).get(i));

                    if (i == 0) {
                        System.out.println("Total size of area located in same Dhaka District:" + readJSONFileRedX.getSuburbs(district).size());
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
                        System.out.println("The DeliveryCharge issue occur while OSD(Same district to Suburb)");
                        System.out.println("The delivery charge was mismatched on Area : " + area);
                    }

                    //Get COD charge and verify it
                    codChargeText = myActions.action_getText(createParcelPageObjects.CODCharge());
                    codAmount = codChargeText.replaceAll("[^0-9]", "");
                    codCharge = Integer.parseInt(codAmount) / 100;
                    softAssert.assertEquals(codCharge, 40);//need clarification
                    sleep(1000);
                }
            }
        }softAssert.assertAll();
    }

    @Test(groups = CoreConstants.GROUP_SANITY,
            description = "Verifies Delivery charge Suburbs to OSD Different District",
            priority = 3)
    public void verifyOSDToSuburbDifferentDistricts() throws Exception {
        System.out.println("Verification of OSD to Suburbs Different District was called");
        sleep(3000);

        actionBarObjects.clickOnDropDownButton();
        sleep(500);
        homePageObjects.clickOnDropDownMyShopButton();

        //Select shop which located in Dohar(OSD)
//        myShopsPageObjects.editShopDetails(8, "dha","Dhaka","Dohar","customer Name" );
        myShopsPageObjects.clickOnShop(8);
        sleep(1000);

        System.out.println("The size of the divisions in a Suburb zones " + readJSONFileRedX.getDeliveryDivisionsUnderZones("Suburbs").size());
        division = readJSONFileRedX.getDeliveryDivisionsUnderZones("Suburbs").get(0);

        for (int a = 0; a < readJSONFileRedX.getSuburbs(division).size(); a++) {
            district = readJSONFileRedX.getSuburbs(division).get(a);

            //different district condition
            if (!district.equals("Dhaka")) {

                for (int i = 0; i < readJSONFileRedX.getSuburbs(district).size(); i++) {
                    area = String.valueOf(readJSONFileRedX.getSuburbs(district).get(i));

                    if (i == 0) {
                        System.out.println("Total size of area located in different Dhaka District :" + readJSONFileRedX.getSuburbs(district).size());
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
                        System.out.println("The DeliveryCharge issue occur while OSD(Different district to Suburb)");
                        System.out.println("The delivery charge was mismatched on Area : " + area);
                    }

                    //Get COD charge and verify it
                    codChargeText = myActions.action_getText(createParcelPageObjects.CODCharge());
                    codAmount = codChargeText.replaceAll("[^0-9]", "");
                    codCharge = Integer.parseInt(codAmount) / 100;
                    softAssert.assertEquals(codCharge, 40);
                    sleep(1000);
                }
            }
        }softAssert.assertAll();
    }
}
