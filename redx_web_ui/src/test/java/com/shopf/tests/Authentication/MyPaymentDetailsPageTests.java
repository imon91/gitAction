package com.shopf.tests.Authentication;

import com.gurock.testrail.*;
import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;
import pageObjects.*;
import services.redxMethods.*;
import utils.*;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

public class MyPaymentDetailsPageTests extends RedXWebBaseClass {

    private WebDriver driver;
    private ActionBarObjects actionBarObjects;
    private MyPaymentDetailsPageObjects myPaymentDetailsPageObjects;
    private MyPaymentDetailsPageObjects.UpdatePaymentDetailsPageObjects updatePaymentDetailsPageObjects;

    private GetRedxApiResponse getRedxApiResponse;
    private TestRailDataBuilder testRailDataBuilder = TestRailDataBuilder.getInstance();
    private String shopName = "Ram Shops";
    private String otp = "1234";
    int shopId;

    @BeforeClass(alwaysRun = true)
    public void myPaymentDetailsTestsBeforeClass() throws Exception
    {
        System.out.println("My Payment Details Page Tests Before Class");
        driver = getBaseDriver();
        actionBarObjects = new ActionBarObjects(driver);
        myPaymentDetailsPageObjects = new MyPaymentDetailsPageObjects(driver);
        updatePaymentDetailsPageObjects = myPaymentDetailsPageObjects.new UpdatePaymentDetailsPageObjects();

        getRedxApiResponse = new GetRedxApiResponse("redxweb");

        shopId = getRedxApiResponse.getShopId(shopName);

        actionBarObjects.changeShop(shopName);
        setImplicitWait(10000);

        actionBarObjects.clickOnMyPaymentDetailsDropDown();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(ITestContext iTestContext, Method method) throws NoSuchMethodException {
        System.out.println("\n /****************************************************************************************************/ \n");
        System.out.println("BeforeMethod is called");
        testRailDataBuilder.beforeMethodForTestRail(iTestContext,method, MyPaymentDetailsPageTests.class);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result, ITestContext ctx) throws IOException, APIException {
        System.out.println("AfterMethod is called");
        testRailDataBuilder.afterMethodForTestRail(result,ctx);
    }

    @TestRails(caseId = "335")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Payment Method Value",
            priority = 1001 )
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

    @TestRails(caseId = "336")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Payment Details Value",
            priority = 1002 )
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

    @TestRails(caseId = "337")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Change Payment Method Link",
            priority = 1003 )
    public void verifyChangePaymentMethodLink()
    {
        System.out.println("Verifying Change Payment Method Link");
        myPaymentDetailsPageObjects.clickChangePaymentLink();
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URl : " + currentUrl);
        Assert.assertEquals(currentUrl,"https://redx.shopups1.xyz/update-shop-payment/");
    }

    @TestRails(caseId = "338")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Payment Method Input Functionality",
            priority = 1004 )
    public void verifyPaymentMethodInputFunctionality()
    {
        System.out.println("Verifying Payment Method Input Functionality");
        String method = updatePaymentDetailsPageObjects.choosePaymentMethod();
        String checkedPaymentMethod = updatePaymentDetailsPageObjects.getCheckedPaymentMethod();
        System.out.println("Selected Payment Method : " + checkedPaymentMethod);
        Assert.assertEquals(checkedPaymentMethod,method);
    }

    @TestRails(caseId = "339")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Payment Details Error Msg Values",
            priority = 1005 )
    public void verifyPaymentDetailsErrorMsgValues()
    {
        System.out.println("Verifying Payment Details Error Msg Values");
        List<String> data = updatePaymentDetailsPageObjects.getDataFromCsv("MPD03");
        updatePaymentDetailsPageObjects.addPaymentMethod(data);
        List<String> errorMsgs = updatePaymentDetailsPageObjects.getAllErrorMessages();
        System.out.println("Error Msgs : " + errorMsgs.toString());
    }

    @TestRails(caseId = "340")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Payment Details Error Msg Values",
            priority = 1006 )
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

    @TestRails(caseId = "341")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Payment Details Error Msg Values",
            priority = 1007 )
    public void verifyResendOtpButtonFunctionality()
    {
        System.out.println("Verifying Resend Otp Button Functionality");

        updatePaymentDetailsPageObjects.clickConfirmButton();
        sleep(60000);
        updatePaymentDetailsPageObjects.clickResendOtpButton();
    }

    @TestRails(caseId = "342")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Payment Details Error Msg Values",
            priority = 1008 )
    public void verifyAuthenticateFunctionality()
    {
        System.out.println("Verifying Resend Otp Button Functionality");

        updatePaymentDetailsPageObjects.enterOtpInput(otp);
        updatePaymentDetailsPageObjects.clickAuthenticateButton();
        String toastMsg = myPaymentDetailsPageObjects.getToastMsg();
        System.out.println("Toast Msg : " + toastMsg);
        Assert.assertEquals(toastMsg,"Saved!");
    }
}
