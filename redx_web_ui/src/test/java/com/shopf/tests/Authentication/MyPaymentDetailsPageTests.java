package com.shopf.tests.Authentication;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import services.redxMethods.GetRedxApiResponse;
import utils.RedXWebBaseClass;

import java.util.*;

public class MyPaymentDetailsPageTests extends RedXWebBaseClass {

    private WebDriver driver;
    private LoginPageObjects loginPageObjects;
    private ActionBarObjects actionBarObjects;
    private MyPaymentDetailsPageObjects myPaymentDetailsPageObjects;
    private MyPaymentDetailsPageObjects.UpdatePaymentDetailsPageObjects updatePaymentDetailsPageObjects;

    private GetRedxApiResponse getRedxApiResponse;
    private String cookie;
    private String shopName = "Ram Shops";
    private String otp = "1234";
    int shopId;

    @BeforeSuite(alwaysRun = true)
    public void redXWebBeforeSuite() throws  Exception
    {
        System.out.println("RedX Web Before Suite");
        driver = getBaseDriver();
        setImplicitWait(10000);
        driver.get(getWebBaseUrl());
        driver.manage().window().maximize();
    }

    @BeforeClass(alwaysRun = true)
    public void myPaymentDetailsTestsBeforeClass() throws Exception
    {
        System.out.println("My Payment Details Page Tests Before Class");
        loginPageObjects = new LoginPageObjects(driver);
        actionBarObjects = new ActionBarObjects(driver);
        myPaymentDetailsPageObjects = new MyPaymentDetailsPageObjects(driver);
        updatePaymentDetailsPageObjects = myPaymentDetailsPageObjects.new UpdatePaymentDetailsPageObjects();

        getRedxApiResponse = new GetRedxApiResponse("redxweb");

        System.out.println("Verify Authentication with valid credentials was called");
        cookie = loginPageObjects.performAuthentication("0140112218","6666","8");
        setImplicitWait(10000);

        shopId = getRedxApiResponse.getShopId(shopName);

        actionBarObjects.changeShop(shopName);
        setImplicitWait(10000);

        actionBarObjects.clickOnMyPaymentDetailsDropDown();
    }

    @BeforeMethod(alwaysRun = true)
    public void myPaymentDetailsPageTestsBeforeMethod()
    {
        System.out.println("\n /****************************************************************************************************/ \n");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Payment Method Value",
            priority = 1 )
    public void verifyPaymentMethodValue()
    {
        System.out.println("Verifying Payment Method Value");
        String method = myPaymentDetailsPageObjects.getPaymentMethod();
        int elements = myPaymentDetailsPageObjects.getCardTextElements();
        System.out.println("Payment Method : " + method);
        switch (method)
        {
            case "Bank":
                Assert.assertEquals(elements,4);
                break;
            case "Bkash":
                Assert.assertEquals(elements,1);
                break;
        }
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Payment Details Value",
            priority = 2 )
    public void verifyPaymentDetailsValue()
    {
        System.out.println("Verifying Payment Details Value");
        String method = myPaymentDetailsPageObjects.getPaymentMethod();
        List<String> detailsUiValue = myPaymentDetailsPageObjects.getPaymentDetails();
        List<String> detailsApiValue = getRedxApiResponse.getMyPaymentDetails(shopId,method);
        System.out.println("Details Ui Value : " + detailsUiValue.toString());
        System.out.println("Details Api Value : " + detailsApiValue.toString());
        Assert.assertEquals(detailsUiValue,detailsApiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Change Payment Method Link",
            priority = 3 )
    public void verifyChangePaymentMethodLink()
    {
        System.out.println("Verifying Change Payment Method Link");
        myPaymentDetailsPageObjects.clickChangePaymentLink();
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URl : " + currentUrl);
        Assert.assertEquals(currentUrl,"https://redx.shopups1.xyz/update-shop-payment/");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Payment Method Input Functionality",
            priority = 4 )
    public void verifyPaymentMethodInputFunctionality()
    {
        System.out.println("Verifying Payment Method Input Functionality");
        String method = updatePaymentDetailsPageObjects.choosePaymentMethod();
        String checkedPaymentMethod = updatePaymentDetailsPageObjects.getCheckedPaymentMethod();
        System.out.println("Selected Payment Method : " + checkedPaymentMethod);
        Assert.assertEquals(checkedPaymentMethod,method);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Payment Details Error Msg Values",
            priority = 5 )
    public void verifyPaymentDetailsErrorMsgValues()
    {
        System.out.println("Verifying Payment Details Error Msg Values");
        List<String> data = updatePaymentDetailsPageObjects.getDataFromCsv("MPD03");
        updatePaymentDetailsPageObjects.addPaymentMethod(data);
        List<String> errorMsgs = updatePaymentDetailsPageObjects.getAllErrorMessages();
        System.out.println("Error Msgs : " + errorMsgs.toString());
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Payment Details Error Msg Values",
            priority = 6 )
    public void verifyConfirmButtonFunctionality()
    {
        System.out.println("Verifying Change Payment Method Functionality");
        List<String> data = new ArrayList<>();
        String method = updatePaymentDetailsPageObjects.getCheckedPaymentMethod();

        switch (method)
        {
            case "Bank Account":
                data = updatePaymentDetailsPageObjects.getDataFromCsv("MPD01");
                break;
            case "BKash":
                data = updatePaymentDetailsPageObjects.getDataFromCsv("MPD02");
                break;
        }

        updatePaymentDetailsPageObjects.addPaymentMethod(data);
        updatePaymentDetailsPageObjects.clickConfirmButton();

        String title = updatePaymentDetailsPageObjects.getTitle();
        updatePaymentDetailsPageObjects.clickCloseIcon();
        System.out.println("Title : " + title);
        Assert.assertEquals(title,"Authenticate with OTP");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Payment Details Error Msg Values",
            priority = 7 )
    public void verifyResendOtpButtonFunctionality()
    {
        System.out.println("Verifying Resend Otp Button Functionality");

        updatePaymentDetailsPageObjects.clickConfirmButton();
        sleep(60000);
        updatePaymentDetailsPageObjects.clickResendOtpButton();
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Payment Details Error Msg Values",
            priority = 8 )
    public void verifyAuthenticateFunctionality()
    {
        System.out.println("Verifying Resend Otp Button Functionality");

        updatePaymentDetailsPageObjects.enterOtpInput(otp);
        updatePaymentDetailsPageObjects.clickAuthenticateButton();
        String toastMsg = myPaymentDetailsPageObjects.getToastMsg();
        System.out.println("Toast Msg : " + toastMsg);
        Assert.assertEquals(toastMsg,"Saved!");
    }

    @AfterClass(alwaysRun = true)
    public void myPaymentDetailsPageTestsAfterClass()
    {
        System.out.println("My Payment Details Page Tests After Class");
    }

    @AfterSuite(alwaysRun = true)
    public void myPaymentDetailsPageTestsAfterSuite()
    {
        System.out.println("My Payment Details Page Tests After Suite");
        driver.quit();
    }

}
