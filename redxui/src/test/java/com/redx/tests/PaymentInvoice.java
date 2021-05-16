package com.redx.tests;

import coreUtils.*;
import io.appium.java_client.android.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;
import java.util.*;

public class PaymentInvoice extends RedXBaseClass
{
    private AndroidDriver<WebElement> androidDriver;
    private HomePageObjects homePageObjects;
    private PaymentUpdatesPageObjects paymentUpdatesPageObjects;
    private PaymentUpdatesPageObjects.ActionBarPageObjects actionBarPageObjects;
    private PaymentUpdatesPageObjects.ViewInvoice viewInvoice;
    private Random random;
    private SettingsPageObjects settingsPageObjects;
    private Authentication authentication;
    private ChangeLanguage changeLanguage;

    private List<String> paymentValue;

    public void pageInitializer()
    {
        homePageObjects = new HomePageObjects();
        paymentUpdatesPageObjects = new PaymentUpdatesPageObjects();
        actionBarPageObjects = paymentUpdatesPageObjects.new ActionBarPageObjects();
        viewInvoice = paymentUpdatesPageObjects.new ViewInvoice();
        random = new Random();
        settingsPageObjects = new SettingsPageObjects();
        authentication = new Authentication();
        changeLanguage = new ChangeLanguage();
    }

    @BeforeSuite(alwaysRun = true)
    public void redXAndroidBeforeSuite()
    {
        System.out.println("redXAndroidBeforeSuite is called");
        androidDriver = getBaseDriver();
    }


    @BeforeClass(alwaysRun = true)
    public void paymentInvoiceBeforeClass()
    {
        System.out.println("Before Payment Invoice Class");
        androidDriver = getBaseDriver();
        pageInitializer();
        refreshPage();
    }

    @DataProvider(name = "getUserAuthenticationData")
    public Object[][] getUserAuthenticationData(){
        return new Object[][]{
                {"01401122188","6666"}
        };
    }

    @Test(  groups = {"Authentication.verifyAuthenticationWithWrongOTP",
            CoreConstants.GROUP_SANITY},
            description = "Verifies Authentication With Wrong OTP",
            priority = 1,
            dataProvider = "getUserAuthenticationData")
    public void verifyAuthenticationWithWrongOTP(String mobileNumber,String otp) throws Exception {
        System.out.println("Verify authentication with Wrong OTP was called");
        authentication.authenticationSetUp();
        authentication.verifyAuthenticationWithValidCredentials(mobileNumber,otp);}

    @Test(  groups = {"Settings.verifyChangeLanguageToENGLISH",
            CoreConstants.GROUP_SANITY},
            description = "Change Language To English",
            priority = 2)
    public void changeToEnglishLanguage() throws Exception {
        System.out.println("Changing to English Language");
        changeLanguage.beforeChangeLanguageClass();
        changeLanguage.changeToEnglishLanguage();
    }


    @Test(  groups = {CoreConstants.GROUP_SMOKE,CoreConstants.GROUP_REGRESSION},
            dependsOnGroups = {"Authentication.verifyAuthenticationWithValidCredentials"},
            description = "Verifies Payment Invoice Functionality in Delivered Tab")
    public void verifyParcelInvoiceModule()
    {
        int index;
        String assertVariable = null;
        List<WebElement> parcelsList;

        System.out.println("Verify Parcel Invoice");
        homePageObjects.clickViewPaymentUpdatesModule();
        sleep(1000);
        Assert.assertEquals(actionBarPageObjects.getPageTitle(),"Payment updates");

        paymentUpdatesPageObjects.clickPaidAmountTab();
        sleep(1000);
        parcelsList = paymentUpdatesPageObjects.setParcelsList();
        if(parcelsList.size()!=0) {
            index = random.nextInt(parcelsList.size());
            paymentUpdatesPageObjects.clickViewInvoiceByIndex(index);
            try
            {
                assertVariable = PropertyReader.getValueOfKey("PARCEL_DATE");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Parcel Date cannot be read from Properties");
            }
            Assert.assertEquals(actionBarPageObjects.getPageTitle(), "Parcels");

            viewInvoice.clickDeliveredTab();
            parcelsList = viewInvoice.setPackagesList();
            if (parcelsList.size() != 0)
            {
                viewInvoice.getParcelDetails();
                index = random.nextInt(parcelsList.size());
                viewInvoice.clickDetailsByIndex(index);
                sleep(1000);
                try
                {
                    assertVariable = PropertyReader.getValueOfKey(PropertyReader.Keys.PARCEL_ID);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Parcel ID cannot be read from Properties");
                }
                Assert.assertEquals(actionBarPageObjects.getParcelDetailsTitle(), assertVariable);
                viewInvoice.getInvoiceDetails();
                actionBarPageObjects.clickBackButton();
                sleep(500);
                actionBarPageObjects.clickBackButton();
            } else {
                System.out.println("No Parcels Found");
                actionBarPageObjects.clickBackButton();
            }
            actionBarPageObjects.clickBackButton();
        }
        else {
            System.out.println("No Parcels Found");
            actionBarPageObjects.clickBackButton();
        }
    }

    @Test(groups = {CoreConstants.GROUP_SLACK_BUG},priority = 4)
    public void verifyPaymentValue()
    {
        System.out.println("Verifying Payment Value");
        homePageObjects.clickViewPaymentUpdatesModule();
        sleep(1000);
        paymentValue = paymentUpdatesPageObjects.getPaymentValue();
        System.out.println("Payment Value : " + paymentValue.toString());
    }

    @Test(groups = {CoreConstants.GROUP_SLACK_BUG},priority = 5)
    public void verifyPaidAmountTabFunctionality()
    {
        System.out.println("Verifying Paid Amount Tab Functionality");
        paymentUpdatesPageObjects.clickPaidAmountTab();
        System.out.println("Payment Value : " + paymentUpdatesPageObjects.getPaymentValue());
        Assert.assertEquals(paymentUpdatesPageObjects.getPaymentValue(),paymentValue);
    }

    @Test(groups = {CoreConstants.GROUP_SLACK_BUG},priority = 6)
    public void verifyProcessingAmountTabFunctionality()
    {
        System.out.println("Verifying Processing Amount Tab Functionality");
        paymentUpdatesPageObjects.clickProcessingTab();
        System.out.println("Payment Value : " + paymentUpdatesPageObjects.getPaymentValue());
        Assert.assertEquals(paymentUpdatesPageObjects.getPaymentValue(),paymentValue);
    }

    @AfterSuite(alwaysRun = true)
    public void redXAndroidAfterSuite(){
        System.out.println("redXAndroidAfterSuite Is Called");
        quitBaseDriver();
    }
}
