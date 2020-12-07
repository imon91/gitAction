package com.shopf.tests.IssuesAutomation;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;
import pageObjects.*;
import testData.*;
import utils.*;
import java.util.*;


public class DeliveryChargeMismatchIssues extends RedXWebBaseClass {

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
    String deliveryChargeTextParcelPage;
    String deliveryAmountParcelPage;
    String division;
    String district ;
    String area;
    String amount;
    String hundred;
    String sixty;
    String oneThirty;
    int deliveryCharge;
    int codCharge;
    int totalDeliveryCharge;
    int deliveryChargeParcelPage;
    private ReadJSONFileRedX readJSONFileRedX;
    private Random random;
    private RedXServiceRequestLayer redXServiceRequestLayer;





    @BeforeSuite(alwaysRun = true)
    public void redxBeforeSuite() throws Exception{
        System.out.println("RedX issue automation BeforeSuite is called");
        driver = getBaseDriver();
        browserMaximize();
        setImplicitWait(10);
        driver.get(getWebBaseUrl());
        System.setProperty("selling price","4000");
        System.setProperty("sixty","60");
        System.setProperty("hundred","100");
        System.setProperty("oneThirty","130");
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
    }

    @Test(groups = CoreConstants.GROUP_SMOKE,
            description = "Verifies Authentication With Valid Credentials",
            priority = 1)
    public void verifyAuthenticationWithValidCredentials() throws InterruptedException {
        System.out.println("Verify Authentication with valid credentials was called");
        loginPageObjects.performAuthentication("0140112217","6666","7");

    }

    @Test(groups = CoreConstants.GROUP_SANITY,
            description = "Verifies Authentication With Valid Credentials",
            priority = 1)
    public void verifyAuthenticationValidCredentials() throws InterruptedException {
        System.out.println("Verify Authentication with valid credentials was called");
        loginPageObjects.performAuthentication("0140112216","6666","6");

    }

//    @Test(groups = CoreConstants.GROUP_SMOKE,
//            description = "Verifies Delivery charge SAVAR to SAVAR",
//            priority = 2)
//    public void verifySAVARToSAVAR()
//    {
//        System.out.println("Verification of SAVAR tp SAVAR was called");
//        sleep(3000);
//        actionBarObjects.clickOnDropDownButton();
//        homePageObjects.clickOnDropDownMyShopButton();
//        myShopsPageObjects.clickOnShop3SAVAR();
//        sleep(1000);
//        parcelPageObjects.createNewParcel("Sa","va",0);
//        //Get DeliveryCharge and convert to Integer(Assert to 60)
//        DeliveryText = myActions.action_getText(parcelPageObjects.deliveryCharge());
//        DeliveryAmount = DeliveryText.replaceAll("[^0-9]", "");
//        deliveryCharge = Integer.parseInt(DeliveryAmount)/100;
//        Assert.assertEquals(deliveryCharge,Integer.parseInt(sixty));
//
//        //Get COD charge and convert to Integer
//        codChargeText = myActions.action_getText(parcelPageObjects.CODCharge());
//        codAmount = codChargeText.replaceAll("[^0-9]", "");
//        codCharge = Integer.parseInt(codAmount)/100;
//        System.out.println("COD charge Double :"+codCharge);
//        totalDeliveryCharge = (deliveryCharge+codCharge);
//        System.out.println("Total delivery charge  :"+totalDeliveryCharge);
//        parcelPageObjects.clickOnSubmitNewParcelButton();
//        sleep(2000);
//        //Click parcel popup
//        parcelPageObjects.clickOnParcelPopupOkButton();
//        sleep(1000);
//        //Verification of Delivery charge in parcelPage
//        actionBarObjects.clickOnParcelPage();
//        deliveryChargeTextParcelPage = myActions.action_getText(parcelPageObjects.deliveryChargeParcelPage());
//        deliveryAmountParcelPage = deliveryChargeTextParcelPage.replaceAll("[^0-9]", "");
//        deliveryChargeParcelPage = Integer.parseInt(deliveryAmountParcelPage)%Integer.parseInt(amount);
//        sleep(1000);
//        System.out.println(totalDeliveryCharge+"   "+deliveryChargeParcelPage);
//        Assert.assertEquals(totalDeliveryCharge,deliveryChargeParcelPage);
//    }

//    @Test(groups = CoreConstants.GROUP_SMOKE,
//            description = "Verifies Delivery charge SAVAR to KALABAGAN",
//            priority = 3)
//    public void verifySAVARToKALABAGAN()
//    {
//        sleep(3000);
//        actionBarObjects.clickOnDropDownButton();
//        homePageObjects.clickOnDropDownMyShopButton();
//        myShopsPageObjects.clickOnShop3SAVAR();
//        sleep(1000);
//        parcelPageObjects.createNewParcel("Ka","la",0);
//        //Get DeliveryCharge and convert to Integer
//        DeliveryText = myActions.action_getText(parcelPageObjects.deliveryCharge());
//        DeliveryAmount = DeliveryText.replaceAll("[^0-9]", "");
//        deliveryCharge = Integer.parseInt(DeliveryAmount)/100;
//        Assert.assertEquals(deliveryCharge,Integer.parseInt(hundred));
//
//        //Get COD charge and convert to Integer
//        codChargeText = myActions.action_getText(parcelPageObjects.CODCharge());
//        codAmount = codChargeText.replaceAll("[^0-9]", "");
//        codCharge = Integer.parseInt(codAmount)/100;
//        System.out.println("COD charge Double :"+codCharge);
//        totalDeliveryCharge = (deliveryCharge+codCharge);
//        System.out.println("Total delivery charge  :"+totalDeliveryCharge);
//        parcelPageObjects.clickOnSubmitNewParcelButton();
//        sleep(2000);
//        //Click parcel popup
//        parcelPageObjects.clickOnParcelPopupOkButton();
//        sleep(1000);
//        //Verification of Delivery charge in parcelPage
//        actionBarObjects.clickOnParcelPage();
//        sleep(2000);
//        deliveryChargeTextParcelPage = myActions.action_getText(parcelPageObjects.deliveryChargeParcelPage());
//         deliveryAmountParcelPage = deliveryChargeTextParcelPage.replaceAll("[^0-9]", "");
//        deliveryChargeParcelPage = Integer.parseInt(deliveryAmountParcelPage)%Integer.parseInt(amount);
//        sleep(2000);
//        System.out.println(totalDeliveryCharge+"   "+deliveryChargeParcelPage);
//        Assert.assertEquals(totalDeliveryCharge,deliveryChargeParcelPage);
//
//    }
//
//    @Test(groups = CoreConstants.GROUP_SMOKE,
//            description = "Verifies Delivery charge SAVAR to NATORE",
//            priority = 4)
//    public void verifySAVARToNATORE()
//    {
//        System.out.println("Verification of SAVAR tp NATORE was called");
//        sleep(3000);
//        actionBarObjects.clickOnDropDownButton();
//        homePageObjects.clickOnDropDownMyShopButton();
//        myShopsPageObjects.clickOnShop3SAVAR();
//        sleep(1000);
//        parcelPageObjects.createNewParcel("Na","to",1);
//        //Get DeliveryCharge and convert to Integer
//        DeliveryText = myActions.action_getText(parcelPageObjects.deliveryCharge());
//        DeliveryAmount = DeliveryText.replaceAll("[^0-9]", "");
//        deliveryCharge = Integer.parseInt(DeliveryAmount)/100;
//        Assert.assertEquals(deliveryCharge,Integer.parseInt(oneThirty));
//
//
//        //Get COD charge and convert to Integer
//        codChargeText = myActions.action_getText(parcelPageObjects.CODCharge());
//        codAmount = codChargeText.replaceAll("[^0-9]", "");
//        codCharge = Integer.parseInt(codAmount)/100;
//        System.out.println("COD charge Double :"+codCharge);
//        totalDeliveryCharge = (deliveryCharge+codCharge);
//        System.out.println("Total delivery charge  :"+totalDeliveryCharge);
//        parcelPageObjects.clickOnSubmitNewParcelButton();
//        sleep(2000);
//        //Click parcel popup
//        parcelPageObjects.clickOnParcelPopupOkButton();
//        sleep(1000);
//        //Verification of Delivery charge in parcelPage
//        actionBarObjects.clickOnParcelPage();
//        sleep(2000);
//        deliveryChargeTextParcelPage = myActions.action_getText(parcelPageObjects.deliveryChargeParcelPage());
//        deliveryAmountParcelPage = deliveryChargeTextParcelPage.replaceAll("[^0-9]", "");
//        System.out.println("Delivery string :"  +deliveryAmountParcelPage);
//        deliveryChargeParcelPage = Integer.parseInt(deliveryAmountParcelPage)%Integer.parseInt(amount);
//        System.out.println("Delivery integer :"  +deliveryChargeParcelPage);
//        sleep(1000);
//        System.out.println(totalDeliveryCharge+"   "+deliveryChargeParcelPage);
//        Assert.assertEquals(totalDeliveryCharge,deliveryChargeParcelPage);
//
//    }
//
//    @Test(groups = CoreConstants.GROUP_SMOKE,
//            description = "Verifies Delivery charge NATORE to NATORE",
//            priority = 5)
//    public void verifyNATOREToNATORE()
//    {
//        System.out.println("Verification of NATORE tp NATORE was called");
//        sleep(3000);
//        actionBarObjects.clickOnDropDownButton();
//        homePageObjects.clickOnDropDownMyShopButton();
//        myShopsPageObjects.clickOnShop2NARORE();
//        sleep(1000);
//        parcelPageObjects.createNewParcel("Na","to",1);
//        //Get DeliveryCharge and convert to Integer
//        DeliveryText = myActions.action_getText(parcelPageObjects.deliveryCharge());
//        DeliveryAmount = DeliveryText.replaceAll("[^0-9]", "");
//        deliveryCharge = Integer.parseInt(DeliveryAmount)/100;
//        Assert.assertEquals(deliveryCharge,Integer.parseInt(sixty));
//
//        //Get COD charge and convert to Integer
//        codChargeText = myActions.action_getText(parcelPageObjects.CODCharge());
//        codAmount = codChargeText.replaceAll("[^0-9]", "");
//        codCharge = Integer.parseInt(codAmount)/100;
//        System.out.println("COD charge Double :"+codCharge);
//        totalDeliveryCharge = (deliveryCharge+codCharge);
//        System.out.println("Total delivery charge  :"+totalDeliveryCharge);
//        parcelPageObjects.clickOnSubmitNewParcelButton();
//        sleep(2000);
//        //Click parcel popup
//        parcelPageObjects.clickOnParcelPopupOkButton();
//        sleep(1000);
//        actionBarObjects.clickOnParcelPage();
//        sleep(2000);
//        //Verification of Delivery charge in parcelPage
//        deliveryChargeTextParcelPage = myActions.action_getText(parcelPageObjects.deliveryChargeParcelPage());
//        deliveryAmountParcelPage = deliveryChargeTextParcelPage.replaceAll("[^0-9]", "");
//        System.out.println("Delivery string :"  +deliveryAmountParcelPage);
//        deliveryChargeParcelPage = Integer.parseInt(deliveryAmountParcelPage)%Integer.parseInt(amount);
//        System.out.println("Delivery integer :"  +deliveryChargeParcelPage);
//        sleep(1000);
//        System.out.println(totalDeliveryCharge+"   "+deliveryChargeParcelPage);
//        Assert.assertEquals(totalDeliveryCharge,deliveryChargeParcelPage);
//
//    }
//
//    @Test(groups = CoreConstants.GROUP_SMOKE,
//            description = "Verifies Delivery charge NATORE to KALABAGAN",
//            priority = 6)
//    public void verifyNATOREToKALABAGAN()
//    {
//        System.out.println("Verification of NATORE tp KALABAGAN was called");
//        sleep(3000);
//        actionBarObjects.clickOnDropDownButton();
//        homePageObjects.clickOnDropDownMyShopButton();
//        myShopsPageObjects.clickOnShop2NARORE();
//        sleep(1000);
//        parcelPageObjects.createNewParcel("Ka","la",0);
//        //Get DeliveryCharge and convert to Integer
//        DeliveryText = myActions.action_getText(parcelPageObjects.deliveryCharge());
//        DeliveryAmount = DeliveryText.replaceAll("[^0-9]", "");
//        deliveryCharge = Integer.parseInt(DeliveryAmount)/100;
//        Assert.assertEquals(deliveryCharge,Integer.parseInt(oneThirty));
//
//        //Get COD charge and convert to Integer
//        codChargeText = myActions.action_getText(parcelPageObjects.CODCharge());
//        codAmount = codChargeText.replaceAll("[^0-9]", "");
//        codCharge = Integer.parseInt(codAmount)/100;
//        System.out.println("COD charge Double :"+codCharge);
//        totalDeliveryCharge = (deliveryCharge+codCharge);
//        System.out.println("Total delivery charge  :"+totalDeliveryCharge);
//        parcelPageObjects.clickOnSubmitNewParcelButton();
//        sleep(2000);
//        //Click parcel popup
//        parcelPageObjects.clickOnParcelPopupOkButton();
//        sleep(1000);
//        //Verification of Delivery charge in parcelPage
//        actionBarObjects.clickOnParcelPage();
//        sleep(2000);
//        deliveryChargeTextParcelPage = myActions.action_getText(parcelPageObjects.deliveryChargeParcelPage());
//        deliveryAmountParcelPage = deliveryChargeTextParcelPage.replaceAll("[^0-9]", "");
//        System.out.println("Delivery string :"  +deliveryAmountParcelPage);
//        deliveryChargeParcelPage = Integer.parseInt(deliveryAmountParcelPage)%Integer.parseInt(amount);
//        System.out.println("Delivery integer :"  +deliveryChargeParcelPage);
//        sleep(1000);
//        System.out.println(totalDeliveryCharge+"   "+deliveryChargeParcelPage);
//        Assert.assertEquals(totalDeliveryCharge,deliveryChargeParcelPage);
//
//    }
//
//    @Test(groups = CoreConstants.GROUP_SMOKE,
//            description = "Verifies Delivery charge NATORE to SAVAR",
//            priority = 7)
//    public void verifyNATOREToSAVAR()
//    {
//        System.out.println("Verification of NATORE tp SAVAR was called");
//        sleep(3000);
//        actionBarObjects.clickOnDropDownButton();
//        homePageObjects.clickOnDropDownMyShopButton();
//        myShopsPageObjects.clickOnShop2NARORE();
//        sleep(1000);
//        parcelPageObjects.createNewParcel("Sa","va",0);
//        //Get DeliveryCharge and convert to Integer
//        DeliveryText = myActions.action_getText(parcelPageObjects.deliveryCharge());
//        DeliveryAmount = DeliveryText.replaceAll("[^0-9]", "");
//        deliveryCharge = Integer.parseInt(DeliveryAmount)/100;
//        Assert.assertEquals(deliveryCharge,Integer.parseInt(oneThirty));
//
//        //Get COD charge and convert to Integer
//        codChargeText = myActions.action_getText(parcelPageObjects.CODCharge());
//        codAmount = codChargeText.replaceAll("[^0-9]", "");
//        codCharge = Integer.parseInt(codAmount)/100;
//        System.out.println("COD charge Double :"+codCharge);
//        totalDeliveryCharge = (deliveryCharge+codCharge);
//        System.out.println("Total delivery charge  :"+totalDeliveryCharge);
//        parcelPageObjects.clickOnSubmitNewParcelButton();
//        sleep(2000);
//        //Click parcel popup
//        parcelPageObjects.clickOnParcelPopupOkButton();
//        sleep(1000);
//        //Verification of Delivery charge in parcelPage
//        actionBarObjects.clickOnParcelPage();
//        sleep(2000);
//        deliveryChargeTextParcelPage = myActions.action_getText(parcelPageObjects.deliveryChargeParcelPage());
//        deliveryAmountParcelPage = deliveryChargeTextParcelPage.replaceAll("[^0-9]", "");
//        System.out.println("Delivery string :"  +deliveryAmountParcelPage);
//        deliveryChargeParcelPage = Integer.parseInt(deliveryAmountParcelPage)%Integer.parseInt(amount);
//        System.out.println("Delivery integer :"  +deliveryChargeParcelPage);
//        sleep(1000);
//        System.out.println(totalDeliveryCharge+"   "+deliveryChargeParcelPage);
//        Assert.assertEquals(totalDeliveryCharge,deliveryChargeParcelPage);
//
//    }
//
//    @Test(groups = CoreConstants.GROUP_SMOKE,
//            description = "Verifies Delivery charge KALABAGAN to KALABAGAN",
//            priority = 8)
//    public void verifyKALABAGANToKALABAGAN()
//    {
//        System.out.println("Verification of KALABAGAN tp KALABAGAN was called");
//        sleep(3000);
//        actionBarObjects.clickOnDropDownButton();
//        homePageObjects.clickOnDropDownMyShopButton();
//        myShopsPageObjects.clickOnShop1KALABAGAN();
//        sleep(1000);
//        parcelPageObjects.createNewParcel("Ka","la",0);
//        //Get DeliveryCharge and convert to Integer
//        DeliveryText = myActions.action_getText(parcelPageObjects.deliveryCharge());
//        DeliveryAmount = DeliveryText.replaceAll("[^0-9]", "");
//        deliveryCharge = Integer.parseInt(DeliveryAmount)/100;
//        Assert.assertEquals(deliveryCharge,Integer.parseInt(sixty));
//
//        //Get COD charge and convert to Integer
//        codChargeText = myActions.action_getText(parcelPageObjects.CODCharge());
//        codAmount = codChargeText.replaceAll("[^0-9]", "");
//        codCharge = Integer.parseInt(codAmount)/100;
//        System.out.println("COD charge Double :"+codCharge);
//        totalDeliveryCharge = (deliveryCharge+codCharge);
//        System.out.println("Total delivery charge  :"+totalDeliveryCharge);
//        parcelPageObjects.clickOnSubmitNewParcelButton();
//        sleep(2000);
//        //Click parcel popup
//        parcelPageObjects.clickOnParcelPopupOkButton();
//        sleep(1000);
//        //Verification of Delivery charge in parcelPage
//        actionBarObjects.clickOnParcelPage();
//        sleep(2000);
//        deliveryChargeTextParcelPage = myActions.action_getText(parcelPageObjects.deliveryChargeParcelPage());
//        deliveryAmountParcelPage = deliveryChargeTextParcelPage.replaceAll("[^0-9]", "");
//        System.out.println("Delivery string :"  +deliveryAmountParcelPage);
//        deliveryChargeParcelPage = Integer.parseInt(deliveryAmountParcelPage)%Integer.parseInt(amount);
//        System.out.println("Delivery integer :"  +deliveryChargeParcelPage);
//        sleep(1000);
//        System.out.println(totalDeliveryCharge+"   "+deliveryChargeParcelPage);
//        Assert.assertEquals(totalDeliveryCharge,deliveryChargeParcelPage);
//
//    }
//
//    @Test(groups = CoreConstants.GROUP_SMOKE,
//            description = "Verifies Delivery charge KALABAGAN to SAVAR",
//            priority = 9)
//    public void verifyKALABAGANToSAVAR()
//    {
//        System.out.println("Verification of KALABAGAN tp SAVAR was called");
//        sleep(3000);
//        actionBarObjects.clickOnDropDownButton();
//        homePageObjects.clickOnDropDownMyShopButton();
//        myShopsPageObjects.clickOnShop1KALABAGAN();
//        sleep(1000);
//        parcelPageObjects.createNewParcel("Sa","va",0);
//        //Get DeliveryCharge and convert to Integer
//        DeliveryText = myActions.action_getText(parcelPageObjects.deliveryCharge());
//        DeliveryAmount = DeliveryText.replaceAll("[^0-9]", "");
//        deliveryCharge = Integer.parseInt(DeliveryAmount)/100;
//        Assert.assertEquals(deliveryCharge,Integer.parseInt(hundred));
//
//        //Get COD charge and convert to Integer
//        codChargeText = myActions.action_getText(parcelPageObjects.CODCharge());
//        codAmount = codChargeText.replaceAll("[^0-9]", "");
//        codCharge = Integer.parseInt(codAmount)/100;
//        System.out.println("COD charge Double :"+codCharge);
//        totalDeliveryCharge = (deliveryCharge+codCharge);
//        System.out.println("Total delivery charge  :"+totalDeliveryCharge);
//        parcelPageObjects.clickOnSubmitNewParcelButton();
//        sleep(2000);
//        //Click parcel popup
//        parcelPageObjects.clickOnParcelPopupOkButton();
//        sleep(1000);
//        //Verification of Delivery charge in parcelPage
//        actionBarObjects.clickOnParcelPage();
//        sleep(2000);
//        deliveryChargeTextParcelPage = myActions.action_getText(parcelPageObjects.deliveryChargeParcelPage());
//        deliveryAmountParcelPage = deliveryChargeTextParcelPage.replaceAll("[^0-9]", "");
//        System.out.println("Delivery string :"  +deliveryAmountParcelPage);
//        deliveryChargeParcelPage = Integer.parseInt(deliveryAmountParcelPage)%Integer.parseInt(amount);
//        System.out.println("Delivery integer :"  +deliveryChargeParcelPage);
//        sleep(1000);
//        System.out.println(totalDeliveryCharge+"   "+deliveryChargeParcelPage);
//        Assert.assertEquals(totalDeliveryCharge,deliveryChargeParcelPage);
//
//    }
//
//    @Test(groups = CoreConstants.GROUP_SMOKE,
//            description = "Verifies Delivery charge KALABAGAN to NATORE",
//            priority = 10)
//    public void verifyKALABAGANToNATORE()
//    {
//        System.out.println("Verification of KALABAGAN tp NATORE was called");
//        sleep(3000);
//
//        actionBarObjects.clickOnDropDownButton();
//        homePageObjects.clickOnDropDownMyShopButton();
//        myShopsPageObjects.clickOnShop1KALABAGAN();
//        sleep(1000);
//        parcelPageObjects.createNewParcel("Na","to",1);
//        //Get DeliveryCharge and convert to Integer
//        DeliveryText = myActions.action_getText(parcelPageObjects.deliveryCharge());
//        DeliveryAmount = DeliveryText.replaceAll("[^0-9]", "");
//        deliveryCharge = Integer.parseInt(DeliveryAmount)/100;
//        Assert.assertEquals(deliveryCharge,Integer.parseInt(oneThirty));
//
//        //Get COD charge and convert to Integer
//        codChargeText = myActions.action_getText(parcelPageObjects.CODCharge());
//        codAmount = codChargeText.replaceAll("[^0-9]", "");
//        codCharge = Integer.parseInt(codAmount)/100;
//        System.out.println("COD charge Double :"+codCharge);
//        totalDeliveryCharge = (deliveryCharge+codCharge);
//        System.out.println("Total delivery charge  :"+totalDeliveryCharge);
//        parcelPageObjects.clickOnSubmitNewParcelButton();
//        sleep(2000);
//        //Click parcel popup
//        parcelPageObjects.clickOnParcelPopupOkButton();
//        sleep(1000);
//        //Verification of Delivery charge in parcelPage
//        actionBarObjects.clickOnParcelPage();
//        sleep(2000);
//        deliveryChargeTextParcelPage = myActions.action_getText(parcelPageObjects.deliveryChargeParcelPage());
//        deliveryAmountParcelPage = deliveryChargeTextParcelPage.replaceAll("[^0-9]", "");
//        System.out.println("Delivery string :"  +deliveryAmountParcelPage);
//        deliveryChargeParcelPage = Integer.parseInt(deliveryAmountParcelPage)%Integer.parseInt(amount);
//        System.out.println("Delivery integer :"  +deliveryChargeParcelPage);
//        sleep(1000);
//        System.out.println(totalDeliveryCharge+"   "+deliveryChargeParcelPage);
//        Assert.assertEquals(totalDeliveryCharge,deliveryChargeParcelPage);
//    }

    @Test(groups = CoreConstants.GROUP_SANITY,
            description = "Verifies Delivery charge of suburbs to suburbs(Same district)",
            priority = 11)
    public void verifySuburbsToSuburbsSameDistricts() throws Exception {
        System.out.println("Verification of SUBURBS to SUBURBS(same district) was called");
        sleep(3000);
        actionBarObjects.clickOnDropDownButton();
        sleep(500);
        homePageObjects.clickOnDropDownMyShopButton();

    //The location set as suburb was Narayanganj sadar
    System.out.println("The Suburb shop location was Narayanganj district");
        myShopsPageObjects.clickOnShop(0);
        sleep(1000);
        System.out.println("The size of the divisions in a Suburb zones " +readJSONFileRedX.getDeliveryDivisionsUnderZones("Suburbs").size());
        //Select only Suburb division Dhaka
        division = readJSONFileRedX.getDeliveryDivisionsUnderZones("Suburbs").get(0);

        for(int a=0 ;a<readJSONFileRedX.getSuburbs(division).size();a++) {
            district = readJSONFileRedX.getSuburbs(division).get(a);

            if(district.equals("Narayanganj")) {

                for (int i = 0; i < readJSONFileRedX.getSuburbs(district).size(); i++) {
                    area = String.valueOf(readJSONFileRedX.getSuburbs(district).get(i));
                    //Enters All term only for firstTime
                    if(i==0){System.out.println("Total size of area located in sameDistrict :" +readJSONFileRedX.getSuburbs(district).size());
                    createParcelPageObjects.createNewParcel(division,district,area,0,"");}

                    createParcelPageObjects.enterAndApplyAddress(division,district,area,0);

                    //Get DeliveryCharge and convert to Integer
                    DeliveryText = myActions.action_getText(createParcelPageObjects.deliveryCharge());
                    DeliveryAmount = DeliveryText.replaceAll("[^0-9]", "");
                    deliveryCharge = Integer.parseInt(DeliveryAmount) / 100;
                    try{
                    Assert.assertEquals(deliveryCharge, Integer.parseInt(sixty));
                    }catch (AssertionError e)
                    {
                        System.out.println("The DeliveryCharge issue occur while Suburb(SAVAR) to Suburb(Same district)");
                        System.out.println("The delivery charge was mismatched From 'Narayanganj Sadar' to Area : '"+area+"'");
                    }

                    //Get COD charge and verify it
                    codChargeText = myActions.action_getText(createParcelPageObjects.CODCharge());
                    codAmount = codChargeText.replaceAll("[^0-9]", "");
                    codCharge = Integer.parseInt(codAmount) / 100;
                    Assert.assertEquals(codCharge, 0);
                    sleep(1000);
                }
            }
        }
    }

    @Test(groups = CoreConstants.GROUP_SANITY,
            description = "Verifies Delivery charge of Suburbs to suburbs(Different Districts)",
            priority = 12)
    public void verifySuburbsToSuburbsDifferentDistricts() throws Exception {
        System.out.println("Verification of SUBURBS to SUBURBS(Different district) was called");
        sleep(3000);

        actionBarObjects.clickOnDropDownButton();
        sleep(500);
        homePageObjects.clickOnDropDownMyShopButton();

        //The location set as suburb was Narayanganj sadar
        System.out.println("The Suburb shop location was Narayanganj district");
        myShopsPageObjects.clickOnShop(0);
        sleep(1000);

        //Select Only Division of Suburb Dhaka
        System.out.println("The size of the divisions in a Suburb zones " + readJSONFileRedX.getDeliveryDivisionsUnderZones("Suburbs").size());
        division = readJSONFileRedX.getDeliveryDivisionsUnderZones("Suburbs").get(0);

        for (int a = 0; a < readJSONFileRedX.getSuburbs(division).size(); a++) {

            district = readJSONFileRedX.getSuburbs(division).get(a);

            if (!district.equals("Narayanganj")) {

                for (int i = 0; i < readJSONFileRedX.getSuburbs(district).size(); i++) {
                    area = String.valueOf(readJSONFileRedX.getSuburbs(district).get(i));

                    if (i == 0) {
                        System.out.println("Total size of area located in differentDistrict :"+district+"was"+ readJSONFileRedX.getSuburbs(district).size());
                        createParcelPageObjects.createNewParcel(division, district, area, 0, "");
                    }
                    createParcelPageObjects.enterAndApplyAddress(division, district, area, 0);

                    //Get DeliveryCharge and convert to Integer
                    DeliveryText = myActions.action_getText(createParcelPageObjects.deliveryCharge());
                    DeliveryAmount = DeliveryText.replaceAll("[^0-9]", "");
                    deliveryCharge = Integer.parseInt(DeliveryAmount) / 100;
                    try{
                    Assert.assertEquals(deliveryCharge, Integer.parseInt(oneThirty));
                }catch (AssertionError e)
                {
                    System.out.println("The DeliveryCharge issue occur while Suburb(SAVAR) to Suburb(Different district)");
                    System.out.println("The delivery charge was mismatched from 'Narayanganj Sadar' to Area : "+area);
                }

                    //Get COD charge and verify it
                    codChargeText = myActions.action_getText(createParcelPageObjects.CODCharge());
                    codAmount = codChargeText.replaceAll("[^0-9]", "");
                    codCharge = Integer.parseInt(codAmount) / 100;
                    Assert.assertNotEquals(codCharge, 0);
                    sleep(1000);
                }
            }
        }
    }

    @Test(groups = CoreConstants.GROUP_SANITY,
            description = "Verifies Delivery charge of Suburbs to ISD(SameDistricts)",
            priority = 13)
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
                    } catch (AssertionError e) {
                        System.out.println("The DeliveryCharge issue occur while Suburb(SAVAR) to ISD(Same district)");
                        System.out.println("The delivery charge was mismatched on Area : " + area);
                    }


                    //Get COD charge and verify it
                    codChargeText = myActions.action_getText(createParcelPageObjects.CODCharge());
                    codAmount = codChargeText.replaceAll("[^0-9]", "");
                    codCharge = Integer.parseInt(codAmount) / 100;
                    Assert.assertEquals(codCharge, 40);
                    sleep(1000);
                }
            }
        }
    }


    @Test(groups = CoreConstants.GROUP_SANITY,
            description = "Verifies Delivery charge Suburbs to ISD(Different Districts)",
            priority = 14)
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
                myShopsPageObjects.editShopDetails(14, SuburbArea, 0, 0);
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
        }
    }


    @Test(groups = CoreConstants.GROUP_SANITY,
            description = "Verifies Delivery charge of Suburbs to OSD(Same district)",
            priority = 15)
    public void verifySuburbsToOSDSameDistricts() throws Exception {
        System.out.println("Verification of SUBURBS to OSD same districts was called");
        sleep(3000);

        actionBarObjects.clickOnDropDownButton();
        sleep(500);
        homePageObjects.clickOnDropDownMyShopButton();
        System.out.println("The Suburb shop location was set as SAVAR which was in Dhaka district");

        //Choosing Savar Shop which was located in Dhaka district
        myShopsPageObjects.clickOnShop(4);
        sleep(1000);


        System.out.println("The size of the divisions in a OSD zones " + readJSONFileRedX.getDeliveryDivisionsUnderZones("OSD").size());
        division = readJSONFileRedX.getDeliveryDivisionsUnderZones("OSD").get(0);

        for (int a = 0; a < readJSONFileRedX.getOSD(division).size(); a++) {

            district = readJSONFileRedX.getOSD(division).get(a);

            //same district condition
            if (district.equals("Dhaka")) {

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
                        Assert.assertEquals(deliveryCharge, Integer.parseInt(hundred));
                    } catch (AssertionError e) {
                        System.out.println("The DeliveryCharge issue occur while Suburb(SAVAR) to OSD(Same district)");
                        System.out.println("The delivery charge was mismatched from Dhaka to  Area : " + area);
                    }

                    //Get COD charge and verify it
                    codChargeText = myActions.action_getText(createParcelPageObjects.CODCharge());
                    codAmount = codChargeText.replaceAll("[^0-9]", "");
                    codCharge = Integer.parseInt(codAmount) / 100;
                    Assert.assertEquals(codCharge, 40);
                    sleep(1000);
                }
            }
        }
    }

    @Test(groups = CoreConstants.GROUP_SANITY,
            description = "Verifies Delivery charge Suburbs to OSD(Different District)",
            priority = 16)
    public void verifySuburbsToOSDDifferentDistricts() throws Exception {
        System.out.println("Verification of SUBURBS to OSD Different District was called");
        sleep(3000);

        actionBarObjects.clickOnDropDownButton();
        sleep(500);
        homePageObjects.clickOnDropDownMyShopButton();

        //Select shop which located in savar(suburb) Dhaka district
        myShopsPageObjects.clickOnShop(4);
        sleep(1000);

        System.out.println("The size of the divisions in a OSD zones " + readJSONFileRedX.getDeliveryDivisionsUnderZones("OSD").size());
        division = readJSONFileRedX.getDeliveryDivisionsUnderZones("OSD").get(0);

        for (int a = 0; a < readJSONFileRedX.getOSD(division).size(); a++) {

            district = readJSONFileRedX.getOSD(division).get(a);

            //different district condition
            if (!district.equals("Dhaka")) {

                for (int i = 0; i < readJSONFileRedX.getOSD(district).size(); i++) {
                    area = String.valueOf(readJSONFileRedX.getOSD(district).get(i));

                    if (i == 0) {
                        System.out.println("Total size of area located in different District :" + readJSONFileRedX.getOSD(district).size());
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
                    } catch (AssertionError e) {
                        System.out.println("The DeliveryCharge issue occur while Suburb(SAVAR) to OSD(Different district)");
                        System.out.println("The delivery charge was mismatched on Area : " + area);
                    }

                    //Get COD charge and verify it
                    codChargeText = myActions.action_getText(createParcelPageObjects.CODCharge());
                    codAmount = codChargeText.replaceAll("[^0-9]", "");
                    codCharge = Integer.parseInt(codAmount) / 100;
                    Assert.assertEquals(codCharge, 40);
                    sleep(1000);
                }
            }
        }
    }

    @Test(groups = CoreConstants.GROUP_SANITY,
            description = "Verifies Delivery charge Suburbs to OSD SameDistrict",
            priority = 17)
    public void verifyOSDToSuburbsSameDistricts() throws Exception {
        System.out.println("Verification of OSD to SUBURBS different districts was called");
        sleep(3000);

        actionBarObjects.clickOnDropDownButton();
        sleep(500);
        homePageObjects.clickOnDropDownMyShopButton();
        System.out.println("The OSD shop location was set as Dohar which was in Dhaka district");
        //Choosing Dohar Shop
        myShopsPageObjects.editShopDetails(8, "Dohar", 0, 1);
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
                    } catch (AssertionError e) {
                        System.out.println("The DeliveryCharge issue occur while OSD(Same district to Suburb)");
                        System.out.println("The delivery charge was mismatched on Area : " + area);
                    }

                    //Get COD charge and verify it
                    codChargeText = myActions.action_getText(createParcelPageObjects.CODCharge());
                    codAmount = codChargeText.replaceAll("[^0-9]", "");
                    codCharge = Integer.parseInt(codAmount) / 100;
                    Assert.assertEquals(codCharge, 0);
                    sleep(1000);
                }
            }
        }
    }

    @Test(groups = CoreConstants.GROUP_SANITY,
            description = "Verifies Delivery charge Suburbs to OSD Different District",
            priority = 18)
    public void verifyOSDToSuburbDifferentDistricts() throws Exception {
        System.out.println("Verification of OSD to Suburbs Different District was called");
        sleep(3000);

        actionBarObjects.clickOnDropDownButton();
        sleep(500);
        homePageObjects.clickOnDropDownMyShopButton();

        //Select shop which located in Dohar(OSD)
        myShopsPageObjects.editShopDetails(8, "Dohar", 0, 1);
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
                    } catch (AssertionError e) {
                        System.out.println("The DeliveryCharge issue occur while OSD(Different district to Suburb)");
                        System.out.println("The delivery charge was mismatched on Area : " + area);
                    }

                    //Get COD charge and verify it
                    codChargeText = myActions.action_getText(createParcelPageObjects.CODCharge());
                    codAmount = codChargeText.replaceAll("[^0-9]", "");
                    codCharge = Integer.parseInt(codAmount) / 100;
                    Assert.assertEquals(codCharge, 40);
                    sleep(1000);
                }
            }
        }
    }


    @Test(groups = CoreConstants.GROUP_SANITY,
            description = "Verifies Delivery charge ISD to Suburb(Same District) ",
            priority = 19)
    public void verifyISDToSuburbsSameDistricts() throws Exception {
        System.out.println("Verification of ISD to SUBURBS same districts was called");
        sleep(3000);

        actionBarObjects.clickOnDropDownButton();
        sleep(500);
        homePageObjects.clickOnDropDownMyShopButton();
        System.out.println("The ISD shop location was set as Dhanmondi which was in Dhaka district");
        //Choosing Dhanmondi(Dhaka) Shop
        myShopsPageObjects.editShopDetails(9, "Dhanmondi", 0, 1);
        myShopsPageObjects.clickOnShop(9);
        sleep(1000);
        System.out.println("The size of the divisions in a Suburb zones " + readJSONFileRedX.getDeliveryDivisionsUnderZones("Suburbs").size());
        //Select only division Dhaka
        division = readJSONFileRedX.getDeliveryDivisionsUnderZones("Suburbs").get(0);

        for (int a = 0; a < readJSONFileRedX.getSuburbs(division).size(); a++) {

            district = readJSONFileRedX.getSuburbs(division).get(a);

            //same district condition
            if (district.equals("Dhaka")) {

                for (int i = 0; i < readJSONFileRedX.getSuburbs(district).size(); i++) {
                    area = String.valueOf(readJSONFileRedX.getSuburbs(district).get(i));

                    if (i == 0) {
                        System.out.println("Total size of area located in same Dhaka District  :" + readJSONFileRedX.getSuburbs(district).size());
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
                    } catch (AssertionError e) {
                        System.out.println("The DeliveryCharge issue occur while ISD(Same district) to Suburb");
                        System.out.println("The delivery charge was mismatched From Dhanmondi to Area : " + area);
                    }

                    //Get COD charge and verify it
                    codChargeText = myActions.action_getText(createParcelPageObjects.CODCharge());
                    codAmount = codChargeText.replaceAll("[^0-9]", "");
                    codCharge = Integer.parseInt(codAmount) / 100;
                    Assert.assertEquals(codCharge, 0);
                    sleep(1000);
                }
            }
        }
    }


    @Test(groups = CoreConstants.GROUP_SANITY,
            description = "Verifies Delivery charge Of ISD to Suburb(Different District)",
            priority = 20)
    public void verifyISDToSuburbDifferentDistricts() throws Exception {
        System.out.println("Verification of ISD to SUBURBS Different District was called");
        sleep(3000);

        actionBarObjects.clickOnDropDownButton();
        sleep(500);
        homePageObjects.clickOnDropDownMyShopButton();
        //Select shop which located in Chittagong road(Narayanganj)(ISD)
        myShopsPageObjects.editShopDetails(9, "Chittagong Road", 0, 1);
        myShopsPageObjects.clickOnShop(9);
        sleep(1000);
        System.out.println("The size of the divisions in a Suburb zones " + readJSONFileRedX.getDeliveryDivisionsUnderZones("Suburbs").size());
        division = readJSONFileRedX.getDeliveryDivisionsUnderZones("Suburbs").get(0);

        for (int a = 0; a < readJSONFileRedX.getSuburbs(division).size(); a++) {

            district = readJSONFileRedX.getSuburbs(division).get(a);

            //same district condition
            if (!district.equals("Narayanganj")) {

                for (int i = 0; i < readJSONFileRedX.getSuburbs(district).size(); i++) {
                    area = String.valueOf(readJSONFileRedX.getSuburbs(district).get(i));

                    if (i == 0) {
                        System.out.println("Total size of area located in different District :" + readJSONFileRedX.getSuburbs(district).size());
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
                    } catch (AssertionError e) {
                        System.out.println("The DeliveryCharge issue occur while ISD(Different district) to Suburb");
                        System.out.println("The delivery charge was mismatched from Chittagong road to Area : " + area);
                    }

                    //Get COD charge and verify it
                    codChargeText = myActions.action_getText(createParcelPageObjects.CODCharge());
                    codAmount = codChargeText.replaceAll("[^0-9]", "");
                    codCharge = Integer.parseInt(codAmount) / 100;
                    Assert.assertEquals(codCharge, 40);
                    sleep(1000);

                }
            }
        }
    }

    @Test(groups = CoreConstants.GROUP_SANITY,
            description = "Verifies Delivery charge ISD to OSD(SameDistrict)",
            priority = 21)
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
                myShopsPageObjects.editShopDetails(14, ISDArea, 0, 0);
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
                                } catch (AssertionError e) {
                                    System.out.println("The DeliveryCharge issue occur while ISD(same district) to OSD");
                                    System.out.println("The delivery charge was mismatched while from:" + ISDArea + " to " + area);
                                }
                                sleep(1000);
                            }
                        }
                    }
                }
        }

    @Test(groups = CoreConstants.GROUP_SANITY,
            description = "Verifies Delivery charge ISD to OSD(DifferentDistrict)",
            priority = 22)
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
            myShopsPageObjects.editShopDetails(14, ISDArea, 0, 0);
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
                            } catch (AssertionError e) {
                                System.out.println("The DeliveryCharge issue occur while ISD(different district) to OSD");
                                System.out.println("The delivery charge was mismatched while from:" + ISDArea + " to " + area);
                            }
                            sleep(1000);
                        }
                    }
                }
            }
        }


    @Test(groups = CoreConstants.GROUP_SANITY,
            description = "Verifies Delivery charge OSD to ISD(SameDistrict)",
            priority = 23)
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
            myShopsPageObjects.editShopDetails(14, OSDArea, 0, 0);
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
                            } catch (AssertionError e) {
                                System.out.println("The DeliveryCharge issue occur while OSD(same district) to ISD");
                                System.out.println("The delivery charge was mismatched while from:" + OSDArea + " to " + area);
                            }
                            sleep(1000);
                        }
                    }
                }
            }
        }

    @Test(groups = CoreConstants.GROUP_SANITY,
            description = "Verifies Delivery charge OSD to ISD(DifferentDistrict)",
            priority = 24)
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
        myShopsPageObjects.editShopDetails(14, OSDArea, 0, 0);
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
                        } catch (AssertionError e) {
                            System.out.println("The DeliveryCharge issue occur while OSD(different district) to ISD");
                            System.out.println("The delivery charge was mismatched while from:" + OSDArea + " to " + area);
                        }
                        sleep(1000);
                    }
                }
            }
        }
    }


    @AfterClass(alwaysRun = true)
    public void authenticationTestsAfterClass(){
        System.out.println("DeliveryCharge mismatch issues afterClass was called");
    }

    @AfterSuite(alwaysRun = true)
    public void redxAfterSuite(){
        System.out.println("Stores AfterSuite is called");
        quitBaseDriver();
    }



}
