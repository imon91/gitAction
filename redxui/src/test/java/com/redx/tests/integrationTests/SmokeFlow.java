package com.redx.tests.integrationTests;

import com.redx.tests.*;
import coreUtils.*;
import io.appium.java_client.android.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import utils.*;

public class SmokeFlow extends RedXBaseClass {

    private Authentication authentication;
    private AndroidDriver<WebElement> androidDriver;
    private ShopName shopName;
    private ChangeLanguage changeLanguage;
    private CreateParcel createParcel;
    private EditParcel editParcel;
    private DeleteParcel deleteParcel;
    private ParcelDetails parcelDetails;
    private PaymentInvoice paymentInvoice;
    private Settings settings;
    private Logout logout;

    @BeforeSuite(alwaysRun = true)
    public void redXAndroidBeforeSuite()
    {
        System.out.println("redXAndroidBeforeSuite is called");
        androidDriver = getBaseDriver();
    }

    @DataProvider(name = "getUserAuthenticationData")
    public Object[][] getUserAuthenticationData(){
        return new Object[][]{
                {"01401122188","6666"}
        };
    }

    @DataProvider(name = "getEditParcelData")
    public Object[][] getEditParcelData(){
        return new Object[][]{
                {"Name","01401122188","300","500","Address","Kalabagan","Invoice","Instruction"}
        };
    }

    @BeforeClass(alwaysRun = true)
    public void authenticationSetUp() throws Exception
    {
        System.out.println("SmokeFlow SetUp is called");
        authentication = new Authentication();
        shopName = new ShopName();
        changeLanguage = new ChangeLanguage();
        createParcel = new CreateParcel();
        editParcel = new EditParcel();
        deleteParcel = new DeleteParcel();
        parcelDetails = new ParcelDetails();
        paymentInvoice = new PaymentInvoice();
        settings = new Settings();
        logout = new Logout();
        setImplicitWait(15);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod()
    {
        System.out.println("/**************************************************/");
    }

    @Test(groups = {"Authentication.verifyAuthenticationWithValidCredentials",
            CoreConstants.GROUP_SMOKE},
            description = "Verifies Authentication With Valid Credentials",
            dataProvider = "getUserAuthenticationData"
            ,priority = 1)
    public void verifyAuthenticationWithValidCredential(String mobileNo,String otp) throws Exception {
        System.out.println("verify authentication with valid credential was called");
        authentication.authenticationSetUp();
        authentication.verifyAuthenticationWithValidCredentials(mobileNo,otp);
    }

    @Test(groups = {"ShopSelection.verifyShopName",
            CoreConstants.GROUP_SMOKE},
            description = "Verifies Selected shopName",
            priority = 2)
    public void verifyShopName() throws Exception {
        System.out.println("verify shopName was called");
        shopName.shopNameBeforeClass();
        shopName.verifyShopName();
    }

    @Test(groups = {"Settings.verifyChangeLanguage",
            CoreConstants.GROUP_SMOKE},
            description = "Verifies changing language",
            priority = 3)
    public void verifyChangeLanguage() throws Exception {
        changeLanguage.beforeChangeLanguageClass();
        changeLanguage.changeToEnglishLanguage();
    }

    @Test(groups = {"DeliverParcelModule.verifyCreateParcel",
            CoreConstants.GROUP_SMOKE},
            description = "Verifies create parcel",
            priority = 4)
    public void verifyCreateParcel() throws Exception {
        createParcel.beforeCreateParcelClass();
        createParcel.createNewParcel();
    }

    @Test(groups = {"ParcelUpdateModule.verifyEditProfile",
            CoreConstants.GROUP_SMOKE},
            description = "Verifies edit profile",
            dataProvider = "getEditParcelData",
            priority = 5)
    public void verifyEditParcel(String name, String phone, String cash, String sellingPrice, String address, String area,
                                 String invoiceNumber, String instruction){
        editParcel.editParcelBeforeClass();
        editParcel.verifyEditParcelModule(name,phone,cash,sellingPrice,address,area,invoiceNumber,instruction);
    }

    @Test(groups = {"ParcelUpdateModule.verifyDeleteParcel",
            CoreConstants.GROUP_SMOKE},
            description = "Verifies Delete parcel",
            priority = 6)
    public void verifyDeleteParcel()
    {
        deleteParcel.deleteParcelBeforeClass();
        deleteParcel.verifyDeleteParcelModule();
    }

    @Test(groups = {"ParcelUpdateModule.verifyParcelDetails",
            CoreConstants.GROUP_SMOKE},
            description = "Verifies Parcel details",
            priority = 7)
    public void verifyParcelDetails(){
        parcelDetails.parcelDetailsBeforeClass();
        parcelDetails.verifyParcelDetailsModule();
    }

    @Test(groups = {"PaymentUpdates.verifyPaymentInvoice",
            CoreConstants.GROUP_SMOKE},
            description = "Verifies Payment Invoice",
            priority = 8)
    public void verifyPaymentInvoice()
    {
        paymentInvoice.paymentInvoiceBeforeClass();
        paymentInvoice.verifyParcelInvoiceModule();
    }

    @Test(groups = {"Settings.verifyPaymentDetails",
            CoreConstants.GROUP_SMOKE},
            description = "Verifies Payment Details",
            priority = 9)
    public void verifyPaymentDetails() throws Exception {
        settings.settingsBeforeClass();
        settings.verifyPaymentDetails();
    }

    @Test(groups = {"Settings.verifyPickUpArea",
            CoreConstants.GROUP_SMOKE},
            description = "Verifies PickUp Area",
            priority = 10)
    public void verifyPickUpArea() throws Exception {
        settings.verifyPickupArea();
    }

    @Test(groups = {"Settings.verifyOtherSettings",
            CoreConstants.GROUP_SMOKE},
            description = "Verifies OtherSettings",
            priority = 11)
    public void verifyOtherSettings()
    {
        settings.verifyOtherSettings();
    }

    @Test(groups = {"Settings.verifyTermsOfDelivery",
            CoreConstants.GROUP_SMOKE},
            description = "Verifies TermsOfDelivery",
            priority = 12)
    public void verifyTermsOfDelivery()
    {
        settings.verifyTermsOfDelivery();
    }


    @Test(groups = {"Settings.verifyLogout",
            CoreConstants.GROUP_SMOKE},
            description = "Verifies Logout",
            priority = 13)
    public void verifyLogout() throws Exception {
        logout.beforeLogoutClass();
        logout.verifyConfirmLogout();
    }

    @AfterClass(alwaysRun = true)
    public void afterLogoutClass()
    {
        System.out.println("SmokeFlow After Class was called");
    }

    @AfterSuite(alwaysRun = true)
    public void redXAndroidAfterSuite(){

        System.out.println("redXAndroidAfterSuite Is Called");
        quitBaseDriver();

    }


}
