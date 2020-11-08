package com.shopf.tests.IssuesAutomation;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;



public class DeliveryChargeMismatchIssues extends RedXWebBaseClass {

    private WebDriver driver;
    private LoginPageObjects loginPageObjects;
    private HomePageObjects homePageObjects;
    private ActionBarObjects actionBarObjects;
    private MyActions myActions;
    private MyShopsPageObjects myShopsPageObjects;
    private ParcelPageObjects parcelPageObjects;
    String codChargeText;
    String DeliveryText;
    String DeliveryAmount;
    String codAmount;
    String deliveryChargeTextParcelPage;
    String deliveryAmountParcelPage;
    String amount;
    String hundred;
    String sixty;
    String oneThirty;
    int deliveryCharge;
    int codCharge;
    int totalDeliveryCharge;
    int deliveryChargeParcelPage;




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
        parcelPageObjects = new ParcelPageObjects(driver);
        amount = System.getProperty("selling price");
        sixty = System.getProperty("sixty");
        hundred = System.getProperty("hundred");
        oneThirty = System.getProperty("oneThirty");
    }

    @Test(groups = CoreConstants.GROUP_SMOKE,
            description = "Verifies Authentication With Valid Credentials",
            priority = 1)
    public void verifyAuthenticationWithValidCredentials() throws InterruptedException {
        System.out.println("Verify Authentication with valid credentials was called");
        loginPageObjects.performAuthentication("014011221","6666");

    }

    @Test(groups = CoreConstants.GROUP_SMOKE,
            description = "Verifies Delivery charge SAVAR to SAVAR",
            priority = 2)
    public void verifySAVARToSAVAR()
    {
        System.out.println("Verification of SAVAR tp SAVAR was called");
        sleep(3000);
        actionBarObjects.clickOnDropDownButton();
        homePageObjects.clickOnDropDownMyShopButton();
        myShopsPageObjects.clickOnShop3SAVAR();
        sleep(1000);
        parcelPageObjects.createNewParcel("Sa","va",0);
        //Get DeliveryCharge and convert to Integer(Assert to 60)
        DeliveryText = myActions.action_getText(parcelPageObjects.deliveryCharge());
        DeliveryAmount = DeliveryText.replaceAll("[^0-9]", "");
        deliveryCharge = Integer.parseInt(DeliveryAmount)/100;
        Assert.assertEquals(deliveryCharge,Integer.parseInt(sixty));

        //Get COD charge and convert to Integer
        codChargeText = myActions.action_getText(parcelPageObjects.CODCharge());
        codAmount = codChargeText.replaceAll("[^0-9]", "");
        codCharge = Integer.parseInt(codAmount)/100;
        System.out.println("COD charge Double :"+codCharge);
        totalDeliveryCharge = (deliveryCharge+codCharge);
        System.out.println("Total delivery charge  :"+totalDeliveryCharge);
        parcelPageObjects.clickOnSubmitNewParcelButton();
        sleep(2000);
        //Click parcel popup
        parcelPageObjects.clickOnParcelPopupOkButton();
        sleep(1000);
        //Verification of Delivery charge in parcelPage
        actionBarObjects.clickOnParcelPage();
        deliveryChargeTextParcelPage = myActions.action_getText(parcelPageObjects.deliveryChargeParcelPage());
        deliveryAmountParcelPage = deliveryChargeTextParcelPage.replaceAll("[^0-9]", "");
        deliveryChargeParcelPage = Integer.parseInt(deliveryAmountParcelPage)%Integer.parseInt(amount);
        sleep(1000);
        System.out.println(totalDeliveryCharge+"   "+deliveryChargeParcelPage);
        Assert.assertEquals(totalDeliveryCharge,deliveryChargeParcelPage);
    }

    @Test(groups = CoreConstants.GROUP_SMOKE,
            description = "Verifies Delivery charge SAVAR to KALABAGAN",
            priority = 3)
    public void verifySAVARToKALABAGAN()
    {
        sleep(3000);
        actionBarObjects.clickOnDropDownButton();
        homePageObjects.clickOnDropDownMyShopButton();
        myShopsPageObjects.clickOnShop3SAVAR();
        sleep(1000);
        parcelPageObjects.createNewParcel("Ka","la",0);
        //Get DeliveryCharge and convert to Integer
        DeliveryText = myActions.action_getText(parcelPageObjects.deliveryCharge());
        DeliveryAmount = DeliveryText.replaceAll("[^0-9]", "");
        deliveryCharge = Integer.parseInt(DeliveryAmount)/100;
        Assert.assertEquals(deliveryCharge,Integer.parseInt(hundred));

        //Get COD charge and convert to Integer
        codChargeText = myActions.action_getText(parcelPageObjects.CODCharge());
        codAmount = codChargeText.replaceAll("[^0-9]", "");
        codCharge = Integer.parseInt(codAmount)/100;
        System.out.println("COD charge Double :"+codCharge);
        totalDeliveryCharge = (deliveryCharge+codCharge);
        System.out.println("Total delivery charge  :"+totalDeliveryCharge);
        parcelPageObjects.clickOnSubmitNewParcelButton();
        sleep(2000);
        //Click parcel popup
        parcelPageObjects.clickOnParcelPopupOkButton();
        sleep(1000);
        //Verification of Delivery charge in parcelPage
        actionBarObjects.clickOnParcelPage();
        sleep(2000);
        deliveryChargeTextParcelPage = myActions.action_getText(parcelPageObjects.deliveryChargeParcelPage());
         deliveryAmountParcelPage = deliveryChargeTextParcelPage.replaceAll("[^0-9]", "");
        deliveryChargeParcelPage = Integer.parseInt(deliveryAmountParcelPage)%Integer.parseInt(amount);
        sleep(2000);
        System.out.println(totalDeliveryCharge+"   "+deliveryChargeParcelPage);
        Assert.assertEquals(totalDeliveryCharge,deliveryChargeParcelPage);

    }

    @Test(groups = CoreConstants.GROUP_SMOKE,
            description = "Verifies Delivery charge SAVAR to NATORE",
            priority = 4)
    public void verifySAVARToNATORE()
    {
        System.out.println("Verification of SAVAR tp NATORE was called");
        sleep(3000);
        actionBarObjects.clickOnDropDownButton();
        homePageObjects.clickOnDropDownMyShopButton();
        myShopsPageObjects.clickOnShop3SAVAR();
        sleep(1000);
        parcelPageObjects.createNewParcel("Na","to",1);
        //Get DeliveryCharge and convert to Integer
        DeliveryText = myActions.action_getText(parcelPageObjects.deliveryCharge());
        DeliveryAmount = DeliveryText.replaceAll("[^0-9]", "");
        deliveryCharge = Integer.parseInt(DeliveryAmount)/100;
        Assert.assertEquals(deliveryCharge,Integer.parseInt(oneThirty));


        //Get COD charge and convert to Integer
        codChargeText = myActions.action_getText(parcelPageObjects.CODCharge());
        codAmount = codChargeText.replaceAll("[^0-9]", "");
        codCharge = Integer.parseInt(codAmount)/100;
        System.out.println("COD charge Double :"+codCharge);
        totalDeliveryCharge = (deliveryCharge+codCharge);
        System.out.println("Total delivery charge  :"+totalDeliveryCharge);
        parcelPageObjects.clickOnSubmitNewParcelButton();
        sleep(2000);
        //Click parcel popup
        parcelPageObjects.clickOnParcelPopupOkButton();
        sleep(1000);
        //Verification of Delivery charge in parcelPage
        actionBarObjects.clickOnParcelPage();
        sleep(2000);
        deliveryChargeTextParcelPage = myActions.action_getText(parcelPageObjects.deliveryChargeParcelPage());
        deliveryAmountParcelPage = deliveryChargeTextParcelPage.replaceAll("[^0-9]", "");
        System.out.println("Delivery string :"  +deliveryAmountParcelPage);
        deliveryChargeParcelPage = Integer.parseInt(deliveryAmountParcelPage)%Integer.parseInt(amount);
        System.out.println("Delivery integer :"  +deliveryChargeParcelPage);
        sleep(1000);
        System.out.println(totalDeliveryCharge+"   "+deliveryChargeParcelPage);
        Assert.assertEquals(totalDeliveryCharge,deliveryChargeParcelPage);

    }

    @Test(groups = CoreConstants.GROUP_SMOKE,
            description = "Verifies Delivery charge NATORE to NATORE",
            priority = 5)
    public void verifyNATOREToNATORE()
    {
        System.out.println("Verification of NATORE tp NATORE was called");
        sleep(3000);
        actionBarObjects.clickOnDropDownButton();
        homePageObjects.clickOnDropDownMyShopButton();
        myShopsPageObjects.clickOnShop2NARORE();
        sleep(1000);
        parcelPageObjects.createNewParcel("Na","to",1);
        //Get DeliveryCharge and convert to Integer
        DeliveryText = myActions.action_getText(parcelPageObjects.deliveryCharge());
        DeliveryAmount = DeliveryText.replaceAll("[^0-9]", "");
        deliveryCharge = Integer.parseInt(DeliveryAmount)/100;
        Assert.assertEquals(deliveryCharge,Integer.parseInt(sixty));

        //Get COD charge and convert to Integer
        codChargeText = myActions.action_getText(parcelPageObjects.CODCharge());
        codAmount = codChargeText.replaceAll("[^0-9]", "");
        codCharge = Integer.parseInt(codAmount)/100;
        System.out.println("COD charge Double :"+codCharge);
        totalDeliveryCharge = (deliveryCharge+codCharge);
        System.out.println("Total delivery charge  :"+totalDeliveryCharge);
        parcelPageObjects.clickOnSubmitNewParcelButton();
        sleep(2000);
        //Click parcel popup
        parcelPageObjects.clickOnParcelPopupOkButton();
        sleep(1000);
        actionBarObjects.clickOnParcelPage();
        sleep(2000);
        //Verification of Delivery charge in parcelPage
        deliveryChargeTextParcelPage = myActions.action_getText(parcelPageObjects.deliveryChargeParcelPage());
        deliveryAmountParcelPage = deliveryChargeTextParcelPage.replaceAll("[^0-9]", "");
        System.out.println("Delivery string :"  +deliveryAmountParcelPage);
        deliveryChargeParcelPage = Integer.parseInt(deliveryAmountParcelPage)%Integer.parseInt(amount);
        System.out.println("Delivery integer :"  +deliveryChargeParcelPage);
        sleep(1000);
        System.out.println(totalDeliveryCharge+"   "+deliveryChargeParcelPage);
        Assert.assertEquals(totalDeliveryCharge,deliveryChargeParcelPage);

    }

    @Test(groups = CoreConstants.GROUP_SMOKE,
            description = "Verifies Delivery charge NATORE to KALABAGAN",
            priority = 6)
    public void verifyNATOREToKALABAGAN()
    {
        System.out.println("Verification of NATORE tp KALABAGAN was called");
        sleep(3000);
        actionBarObjects.clickOnDropDownButton();
        homePageObjects.clickOnDropDownMyShopButton();
        myShopsPageObjects.clickOnShop2NARORE();
        sleep(1000);
        parcelPageObjects.createNewParcel("Ka","la",0);
        //Get DeliveryCharge and convert to Integer
        DeliveryText = myActions.action_getText(parcelPageObjects.deliveryCharge());
        DeliveryAmount = DeliveryText.replaceAll("[^0-9]", "");
        deliveryCharge = Integer.parseInt(DeliveryAmount)/100;
        Assert.assertEquals(deliveryCharge,Integer.parseInt(oneThirty));

        //Get COD charge and convert to Integer
        codChargeText = myActions.action_getText(parcelPageObjects.CODCharge());
        codAmount = codChargeText.replaceAll("[^0-9]", "");
        codCharge = Integer.parseInt(codAmount)/100;
        System.out.println("COD charge Double :"+codCharge);
        totalDeliveryCharge = (deliveryCharge+codCharge);
        System.out.println("Total delivery charge  :"+totalDeliveryCharge);
        parcelPageObjects.clickOnSubmitNewParcelButton();
        sleep(2000);
        //Click parcel popup
        parcelPageObjects.clickOnParcelPopupOkButton();
        sleep(1000);
        //Verification of Delivery charge in parcelPage
        actionBarObjects.clickOnParcelPage();
        sleep(2000);
        deliveryChargeTextParcelPage = myActions.action_getText(parcelPageObjects.deliveryChargeParcelPage());
        deliveryAmountParcelPage = deliveryChargeTextParcelPage.replaceAll("[^0-9]", "");
        System.out.println("Delivery string :"  +deliveryAmountParcelPage);
        deliveryChargeParcelPage = Integer.parseInt(deliveryAmountParcelPage)%Integer.parseInt(amount);
        System.out.println("Delivery integer :"  +deliveryChargeParcelPage);
        sleep(1000);
        System.out.println(totalDeliveryCharge+"   "+deliveryChargeParcelPage);
        Assert.assertEquals(totalDeliveryCharge,deliveryChargeParcelPage);

    }

    @Test(groups = CoreConstants.GROUP_SMOKE,
            description = "Verifies Delivery charge NATORE to SAVAR",
            priority = 7)
    public void verifyNATOREToSAVAR()
    {
        System.out.println("Verification of NATORE tp SAVAR was called");
        sleep(3000);
        actionBarObjects.clickOnDropDownButton();
        homePageObjects.clickOnDropDownMyShopButton();
        myShopsPageObjects.clickOnShop2NARORE();
        sleep(1000);
        parcelPageObjects.createNewParcel("Sa","va",0);
        //Get DeliveryCharge and convert to Integer
        DeliveryText = myActions.action_getText(parcelPageObjects.deliveryCharge());
        DeliveryAmount = DeliveryText.replaceAll("[^0-9]", "");
        deliveryCharge = Integer.parseInt(DeliveryAmount)/100;
        Assert.assertEquals(deliveryCharge,Integer.parseInt(oneThirty));

        //Get COD charge and convert to Integer
        codChargeText = myActions.action_getText(parcelPageObjects.CODCharge());
        codAmount = codChargeText.replaceAll("[^0-9]", "");
        codCharge = Integer.parseInt(codAmount)/100;
        System.out.println("COD charge Double :"+codCharge);
        totalDeliveryCharge = (deliveryCharge+codCharge);
        System.out.println("Total delivery charge  :"+totalDeliveryCharge);
        parcelPageObjects.clickOnSubmitNewParcelButton();
        sleep(2000);
        //Click parcel popup
        parcelPageObjects.clickOnParcelPopupOkButton();
        sleep(1000);
        //Verification of Delivery charge in parcelPage
        actionBarObjects.clickOnParcelPage();
        sleep(2000);
        deliveryChargeTextParcelPage = myActions.action_getText(parcelPageObjects.deliveryChargeParcelPage());
        deliveryAmountParcelPage = deliveryChargeTextParcelPage.replaceAll("[^0-9]", "");
        System.out.println("Delivery string :"  +deliveryAmountParcelPage);
        deliveryChargeParcelPage = Integer.parseInt(deliveryAmountParcelPage)%Integer.parseInt(amount);
        System.out.println("Delivery integer :"  +deliveryChargeParcelPage);
        sleep(1000);
        System.out.println(totalDeliveryCharge+"   "+deliveryChargeParcelPage);
        Assert.assertEquals(totalDeliveryCharge,deliveryChargeParcelPage);

    }

    @Test(groups = CoreConstants.GROUP_SMOKE,
            description = "Verifies Delivery charge KALABAGAN to KALABAGAN",
            priority = 8)
    public void verifyKALABAGANToKALABAGAN()
    {
        System.out.println("Verification of KALABAGAN tp KALABAGAN was called");
        sleep(3000);
        actionBarObjects.clickOnDropDownButton();
        homePageObjects.clickOnDropDownMyShopButton();
        myShopsPageObjects.clickOnShop1KALABAGAN();
        sleep(1000);
        parcelPageObjects.createNewParcel("Ka","la",0);
        //Get DeliveryCharge and convert to Integer
        DeliveryText = myActions.action_getText(parcelPageObjects.deliveryCharge());
        DeliveryAmount = DeliveryText.replaceAll("[^0-9]", "");
        deliveryCharge = Integer.parseInt(DeliveryAmount)/100;
        Assert.assertEquals(deliveryCharge,Integer.parseInt(sixty));

        //Get COD charge and convert to Integer
        codChargeText = myActions.action_getText(parcelPageObjects.CODCharge());
        codAmount = codChargeText.replaceAll("[^0-9]", "");
        codCharge = Integer.parseInt(codAmount)/100;
        System.out.println("COD charge Double :"+codCharge);
        totalDeliveryCharge = (deliveryCharge+codCharge);
        System.out.println("Total delivery charge  :"+totalDeliveryCharge);
        parcelPageObjects.clickOnSubmitNewParcelButton();
        sleep(2000);
        //Click parcel popup
        parcelPageObjects.clickOnParcelPopupOkButton();
        sleep(1000);
        //Verification of Delivery charge in parcelPage
        actionBarObjects.clickOnParcelPage();
        sleep(2000);
        deliveryChargeTextParcelPage = myActions.action_getText(parcelPageObjects.deliveryChargeParcelPage());
        deliveryAmountParcelPage = deliveryChargeTextParcelPage.replaceAll("[^0-9]", "");
        System.out.println("Delivery string :"  +deliveryAmountParcelPage);
        deliveryChargeParcelPage = Integer.parseInt(deliveryAmountParcelPage)%Integer.parseInt(amount);
        System.out.println("Delivery integer :"  +deliveryChargeParcelPage);
        sleep(1000);
        System.out.println(totalDeliveryCharge+"   "+deliveryChargeParcelPage);
        Assert.assertEquals(totalDeliveryCharge,deliveryChargeParcelPage);

    }

    @Test(groups = CoreConstants.GROUP_SMOKE,
            description = "Verifies Delivery charge KALABAGAN to SAVAR",
            priority = 9)
    public void verifyKALABAGANToSAVAR()
    {
        System.out.println("Verification of KALABAGAN tp SAVAR was called");
        sleep(3000);
        actionBarObjects.clickOnDropDownButton();
        homePageObjects.clickOnDropDownMyShopButton();
        myShopsPageObjects.clickOnShop1KALABAGAN();
        sleep(1000);
        parcelPageObjects.createNewParcel("Sa","va",0);
        //Get DeliveryCharge and convert to Integer
        DeliveryText = myActions.action_getText(parcelPageObjects.deliveryCharge());
        DeliveryAmount = DeliveryText.replaceAll("[^0-9]", "");
        deliveryCharge = Integer.parseInt(DeliveryAmount)/100;
        Assert.assertEquals(deliveryCharge,Integer.parseInt(hundred));

        //Get COD charge and convert to Integer
        codChargeText = myActions.action_getText(parcelPageObjects.CODCharge());
        codAmount = codChargeText.replaceAll("[^0-9]", "");
        codCharge = Integer.parseInt(codAmount)/100;
        System.out.println("COD charge Double :"+codCharge);
        totalDeliveryCharge = (deliveryCharge+codCharge);
        System.out.println("Total delivery charge  :"+totalDeliveryCharge);
        parcelPageObjects.clickOnSubmitNewParcelButton();
        sleep(2000);
        //Click parcel popup
        parcelPageObjects.clickOnParcelPopupOkButton();
        sleep(1000);
        //Verification of Delivery charge in parcelPage
        actionBarObjects.clickOnParcelPage();
        sleep(2000);
        deliveryChargeTextParcelPage = myActions.action_getText(parcelPageObjects.deliveryChargeParcelPage());
        deliveryAmountParcelPage = deliveryChargeTextParcelPage.replaceAll("[^0-9]", "");
        System.out.println("Delivery string :"  +deliveryAmountParcelPage);
        deliveryChargeParcelPage = Integer.parseInt(deliveryAmountParcelPage)%Integer.parseInt(amount);
        System.out.println("Delivery integer :"  +deliveryChargeParcelPage);
        sleep(1000);
        System.out.println(totalDeliveryCharge+"   "+deliveryChargeParcelPage);
        Assert.assertEquals(totalDeliveryCharge,deliveryChargeParcelPage);

    }

    @Test(groups = CoreConstants.GROUP_SMOKE,
            description = "Verifies Delivery charge KALABAGAN to NATORE",
            priority = 10)
    public void verifyKALABAGANToNATORE()
    {
        System.out.println("Verification of KALABAGAN tp NATORE was called");
        sleep(3000);

        actionBarObjects.clickOnDropDownButton();
        homePageObjects.clickOnDropDownMyShopButton();
        myShopsPageObjects.clickOnShop1KALABAGAN();
        sleep(1000);
        parcelPageObjects.createNewParcel("Na","to",1);
        //Get DeliveryCharge and convert to Integer
        DeliveryText = myActions.action_getText(parcelPageObjects.deliveryCharge());
        DeliveryAmount = DeliveryText.replaceAll("[^0-9]", "");
        deliveryCharge = Integer.parseInt(DeliveryAmount)/100;
        Assert.assertEquals(deliveryCharge,Integer.parseInt(oneThirty));

        //Get COD charge and convert to Integer
        codChargeText = myActions.action_getText(parcelPageObjects.CODCharge());
        codAmount = codChargeText.replaceAll("[^0-9]", "");
        codCharge = Integer.parseInt(codAmount)/100;
        System.out.println("COD charge Double :"+codCharge);
        totalDeliveryCharge = (deliveryCharge+codCharge);
        System.out.println("Total delivery charge  :"+totalDeliveryCharge);
        parcelPageObjects.clickOnSubmitNewParcelButton();
        sleep(2000);
        //Click parcel popup
        parcelPageObjects.clickOnParcelPopupOkButton();
        sleep(1000);
        //Verification of Delivery charge in parcelPage
        actionBarObjects.clickOnParcelPage();
        sleep(2000);
        deliveryChargeTextParcelPage = myActions.action_getText(parcelPageObjects.deliveryChargeParcelPage());
        deliveryAmountParcelPage = deliveryChargeTextParcelPage.replaceAll("[^0-9]", "");
        System.out.println("Delivery string :"  +deliveryAmountParcelPage);
        deliveryChargeParcelPage = Integer.parseInt(deliveryAmountParcelPage)%Integer.parseInt(amount);
        System.out.println("Delivery integer :"  +deliveryChargeParcelPage);
        sleep(1000);
        System.out.println(totalDeliveryCharge+"   "+deliveryChargeParcelPage);
        Assert.assertEquals(totalDeliveryCharge,deliveryChargeParcelPage);
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
