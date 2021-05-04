package com.shopf.tests.Authentication;

import com.gurock.testrail.*;
import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

public class ForgotPasswordPageTests extends RedXWebBaseClass {

    private WebDriver driver;
    private ActionBarObjects actionBarObjects;
    private ChangePasswordPageObjects changePasswordPageObjects;
    private ForgotPasswordPageObjects forgotPasswordPageObjects;
    private ForgotPasswordPageObjects.ResetPasswordPageObjects resetPasswordPageObjects;
    private ForgotPasswordPageObjects.ResetPasswordSuccessPageObjects resetPasswordSuccessPageObjects;

    private String shopName = "Password Page Sanity Test Shop";
    private String[] validInput;
    private String[] invalidInput;

    private TestRailDataBuilder testRailDataBuilder = TestRailDataBuilder.getInstance();

    @BeforeClass(alwaysRun = true)
    public void forgotPasswordPageTestsBeforeClass() throws Exception
    {
        System.out.println("Forgot Password Page Tests Before Class");
        driver = getBaseDriver();
        actionBarObjects = new ActionBarObjects(driver);
        changePasswordPageObjects =  new ChangePasswordPageObjects(driver);
        forgotPasswordPageObjects = new ForgotPasswordPageObjects(driver);
        resetPasswordPageObjects = forgotPasswordPageObjects.new ResetPasswordPageObjects();
        resetPasswordSuccessPageObjects = forgotPasswordPageObjects.new ResetPasswordSuccessPageObjects();

        actionBarObjects.changeShop(shopName);
        setImplicitWait(10000);

        actionBarObjects.clickOnChangePasswordDropDown();
        changePasswordPageObjects.clickResetButton();

        validInput = forgotPasswordPageObjects.getDataFromCsv("RP01");
        System.out.println("Valid Input Data : " + Arrays.asList(validInput));
        invalidInput = forgotPasswordPageObjects.getDataFromCsv("RP02");
        System.out.println("Invalid Input Data : " + Arrays.asList(invalidInput));
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(ITestContext iTestContext, Method method) throws NoSuchMethodException {
        System.out.println("\n /****************************************************************************************************/ \n");
        System.out.println("BeforeMethod is called");
        testRailDataBuilder.beforeMethodForTestRail(iTestContext,method, ForgotPasswordPageTests.class);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result, ITestContext ctx) throws IOException, APIException {
        System.out.println("AfterMethod is called");
        testRailDataBuilder.afterMethodForTestRail(result,ctx);
    }

    @TestRails(caseId = "369")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Phone Error Msg Value",
            priority = 1401 )
    public void verifyPhoneErrorMsgValue()
    {
        System.out.println("Verifying Phone Error Msg Value");
        forgotPasswordPageObjects.enterPhoneNumberInput(invalidInput[0]);
        String errorMsg = forgotPasswordPageObjects.getPhoneNumberErrorMsg();
        System.out.println("Error Messages" + errorMsg);
    }

    @TestRails(caseId = "370")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify LoginWithOtp Button Functionality",
            priority = 1402 )
    public void verifyLoginWithOtpButtonFunctionality()
    {
        System.out.println("Verifying LoginWithOtp Button Functionality");
        forgotPasswordPageObjects.clickLoginWithOtp();
        String  currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL : " + currentUrl);
        Assert.assertEquals(currentUrl,"https://redx.shopups1.xyz/login/");
        driver.navigate().back();
    }

    @TestRails(caseId = "371")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Continue Button Functionality",
            priority = 1403 )
    public void verifyContinueButtonFunctionality()
    {
        System.out.println("Verifying Continue Button Functionality");
        forgotPasswordPageObjects.enterPhoneNumberInput(validInput[0]);
        forgotPasswordPageObjects.clickContinueButton();
        String title = resetPasswordPageObjects.getTitleValue();
        System.out.println("Title : " + title);
        Assert.assertEquals(title,"Verify and reset password");
    }

    @TestRails(caseId = "372")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Reset Password Error Msg Values",
            priority = 1404 )
    public void verifyResetPasswordErrorMsgValues()
    {
        System.out.println("Verifying Reset Password Error Msg Values");
        resetPasswordPageObjects.performVerifyFunctionality(invalidInput[1],invalidInput[2],invalidInput[3]);
        List<String> errorMsgs = resetPasswordPageObjects.getAllErrorMsg();
        System.out.println("Error Messages" + errorMsgs);
    }

    @TestRails(caseId = "929")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Resend Otp Button Functionality",
            priority = 1405 )
    public void verifyResendOtpButtonFunctionality()
    {
        System.out.println("Verifying Resend Otp Button Functionality");
        resetPasswordPageObjects.clickResendOtpIcon();
        String toastMsg = resetPasswordPageObjects.getToastMsg();
        System.out.println("Toast Msg : " + toastMsg);
        Assert.assertEquals(toastMsg,"Otp is sent successfully");
    }


    @TestRails(caseId = "373")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Edit Button Functionality",
            priority = 1406 )
    public void verifyEditButtonFunctionality()
    {
        System.out.println("Verifying Edit Button Functionality");
        resetPasswordPageObjects.clickEditIcon();
        forgotPasswordPageObjects.clickContinueButton();
        String title = resetPasswordPageObjects.getTitleValue();
        System.out.println("Title : " + title);
        Assert.assertEquals(title,"Forgot password");
    }

    @TestRails(caseId = "374")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Password Eye Icon Functionality",
            priority = 1407 )
    public void verifyPasswordEyeIconFunctionality()
    {
        System.out.println("Verifying Password Eye Icon Functionality");
        forgotPasswordPageObjects.enterPhoneNumberInput(validInput[0]);
        forgotPasswordPageObjects.clickContinueButton();
        resetPasswordPageObjects.performVerifyFunctionality(validInput[1],validInput[2],validInput[3]);
        resetPasswordPageObjects.clickPasswordEyeIcon();
        String type = resetPasswordPageObjects.getPasswordInputType();
        resetPasswordPageObjects.clickPasswordEyeIcon();
        System.out.println("Type : " + type);
        Assert.assertEquals(type,"text");
    }

    @TestRails(caseId = "375")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Confirm Password Eye Icon Functionality",
            priority = 1408 )
    public void verifyConfirmPasswordEyeIconFunctionality()
    {
        System.out.println("Verifying Confirm Password Eye Icon Functionality");
        resetPasswordPageObjects.clickConfirmPasswordEyeIcon();
        String type = resetPasswordPageObjects.getConfirmPasswordInputType();
        resetPasswordPageObjects.clickConfirmPasswordEyeIcon();
        System.out.println("Type : " + type);
        Assert.assertEquals(type,"text");
    }

    @TestRails(caseId = "376")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Verify Button Functionality",
            priority = 1409 )
    public void verifyVerifyButtonFunctionality()
    {
        System.out.println("Verifying Verify Button Functionality");
        resetPasswordPageObjects.clickVerifyButton();
        String header =  resetPasswordSuccessPageObjects.getHeaderValue();
        System.out.println("Header : " + header);
        Assert.assertEquals(header,"Password updated");
    }

    @TestRails(caseId = "377")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify ReturnToLogin Button Functionality",
            priority = 1410 )
    public void verifyReturnToLoginButtonFunctionality()
    {
        System.out.println("Verifying ReturnToLogin Button Functionality");
        resetPasswordSuccessPageObjects.clickReturnToLoginButton();
        String  currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL : " + currentUrl);
        Assert.assertEquals(currentUrl,"https://redx.shopups1.xyz/login/?password=true");
    }
}
