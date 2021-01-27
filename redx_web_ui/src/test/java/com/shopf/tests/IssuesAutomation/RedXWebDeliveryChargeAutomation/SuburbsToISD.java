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

public class SuburbsToISD extends RedXWebBaseClass {

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
            description = "Verifies Delivery charge of Suburbs to ISD(SameDistricts)",
            priority = 2)
    public void verifySuburbsToISDSameDistricts() throws Exception {
        System.out.println("Verification of SUBURBS to ISD same districts was called");
        sleep(3000);

        actionBarObjects.clickOnDropDownButton();
        sleep(500);
        homePageObjects.clickOnDropDownMyShopButton();
        System.out.println("The Suburb shop location was set as SAVAR which was in Dhaka district");
        myShopsPageObjects.clickOnShop(1);
        sleep(1000);


        System.out.println("The size of the divisions in a ISD zones " + readJSONFileRedX.getDeliveryDivisionsUnderZones("ISD").size());
        //Select only Division Dhaka in ISD
        division = readJSONFileRedX.getDeliveryDivisionsUnderZones("ISD").get(0);

        for (int a = 0; a < readJSONFileRedX.getISD(division).size(); a++) {

            district = readJSONFileRedX.getISD(division).get(a);

            //same district condition
            if (district.equals("Dhaka")) {

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
                        Assert.assertEquals(deliveryCharge, Integer.parseInt(hundred));
                        softAssert.assertEquals(deliveryCharge, Integer.parseInt(hundred));
                    } catch (AssertionError e) {
                        System.out.println("The DeliveryCharge issue occur while Suburb(SAVAR) to ISD(Same district)");
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


    @Test(groups = CoreConstants.GROUP_SANITY,
            description = "Verifies Delivery charge Suburbs to ISD(Different Districts)",
            priority = 3)
    public void verifySuburbsToISDDifferentDistricts() throws Exception {
        System.out.println("Verification of SUBURBS to ISD different districts was called");

        //Verify Dhaka,Gazipur,Narayanganj Districts(Suburbs) with different district ISD
        for (int SuburbDiv =0 ; SuburbDiv<readJSONFileRedX.getDeliveryDivisionsUnderZones("Suburbs").size(); SuburbDiv++) {

            System.out.println("The size of the divisions in a SuburbsZones " + readJSONFileRedX.getDeliveryDivisionsUnderZones("Suburbs").size());
            division = readJSONFileRedX.getDeliveryDivisionsUnderZones("Suburbs").get(SuburbDiv);

            //Get districts of suburb divisions for change shopLocation
            for (int a = 0; a < readJSONFileRedX.getSuburbs(division).size(); a++) {

                String SuburbDistrict = readJSONFileRedX.getSuburbs(division).get(a);
                //Get random area form single district
                String SuburbArea = String.valueOf(readJSONFileRedX.getSuburbs(SuburbDistrict).get(random.nextInt(readJSONFileRedX.getSuburbs(SuburbDistrict).size())));

                //Navigate to myShop page
                sleep(3000);
                actionBarObjects.clickOnDropDownButton();
                sleep(500);
                homePageObjects.clickOnDropDownMyShopButton();

                //Edit the shop with required location and deliveryZone
                myShopsPageObjects.editShopDetails(14, division,SuburbDistrict,SuburbArea,"customer Name" );
                myShopsPageObjects.clickOnShop(14);
                sleep(1000);


                for (int ISDDivision = 0; ISDDivision < readJSONFileRedX.getDeliveryDivisionsUnderZones("ISD").size(); ISDDivision++) {
                    System.out.println("The size of the divisions in a zones " + readJSONFileRedX.getDeliveryDivisionsUnderZones("ISD").size());
                    division = readJSONFileRedX.getDeliveryDivisionsUnderZones("ISD").get(ISDDivision);



                    //Verification of area of different district
                    for (int b = 0; b < readJSONFileRedX.getISD(division).size(); b++) {

                        district = readJSONFileRedX.getISD(division).get(b);

                        //different district condition
                        if (!district.equals(SuburbDistrict)) {

                            for (int i = 0; i < readJSONFileRedX.getISD(district).size(); i++) {
                                area = String.valueOf(readJSONFileRedX.getISD(district).get(i));

                                if (i == 0) {
                                    System.out.println("Total size of area located in differentDistrict :" + readJSONFileRedX.getISD(district).size());
                                    createParcelPageObjects.createNewParcel(division, district, area, 0, "");
                                }
                                //enter and apply address
                                createParcelPageObjects.enterAndApplyAddress(division, district, area, 0);

                                //Get DeliveryCharge and convert to Integer
                                DeliveryText = myActions.action_getText(createParcelPageObjects.deliveryCharge());
                                DeliveryAmount = DeliveryText.replaceAll("[^0-9]", "");
                                deliveryCharge = Integer.parseInt(DeliveryAmount) / 100;
                                try {
                                    Assert.assertEquals(deliveryCharge, Integer.parseInt(hundred));
                                    softAssert.assertEquals(deliveryCharge, Integer.parseInt(hundred));
                                } catch (AssertionError e) {
                                    System.out.println("The DeliveryCharge issue occur while Suburb(SAVAR) to ISD(Different district)");
                                    System.out.println("The delivery charge was mismatched while from:" + SuburbArea + " to " + area);
                                }
                                sleep(1000);
                            }
                        }
                    }
                }
            }
        }softAssert.assertAll();
    }
}
