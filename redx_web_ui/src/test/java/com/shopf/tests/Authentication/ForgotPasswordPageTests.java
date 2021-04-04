package com.shopf.tests.Authentication;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;

import java.util.*;

public class ForgotPasswordPageTests extends RedXWebBaseClass {

    private WebDriver driver;
    private LoginPageObjects loginPageObjects;
    private ActionBarObjects actionBarObjects;
    private ChangePasswordPageObjects changePasswordPageObjects;
    private ForgotPasswordPageObjects forgotPasswordPageObjects;
    private ForgotPasswordPageObjects.ResetPasswordPageObjects resetPasswordPageObjects;
    private ForgotPasswordPageObjects.ResetPasswordSuccessPageObjects resetPasswordSuccessPageObjects;

    private String cookie;
    private String shopName = "Password Page Sanity Test Shop";
    private String[] validInput;
    private String[] invalidInput;

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
    public void forgotPasswordPageTestsBeforeClass() throws Exception
    {
        System.out.println("Forgot Password Page Tests Before Class");
        loginPageObjects = new LoginPageObjects(driver);
        actionBarObjects = new ActionBarObjects(driver);
        changePasswordPageObjects =  new ChangePasswordPageObjects(driver);
        forgotPasswordPageObjects = new ForgotPasswordPageObjects(driver);
        resetPasswordPageObjects = forgotPasswordPageObjects.new ResetPasswordPageObjects();
        resetPasswordSuccessPageObjects = forgotPasswordPageObjects.new ResetPasswordSuccessPageObjects();

        System.out.println("Verify Authentication with valid credentials was called");
        cookie = loginPageObjects.performAuthentication("0140112218","6666","8");
        setImplicitWait(10000);

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
    public void forgotPasswordPageTestsBeforeMethod()
    {
        System.out.println("\n /****************************************************************************************************/ \n");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Phone Error Msg Value",
            priority = 1 )
    public void verifyPhoneErrorMsgValue()
    {
        System.out.println("Verifying Phone Error Msg Value");
        forgotPasswordPageObjects.enterPhoneNumberInput(invalidInput[0]);
        String errorMsg = forgotPasswordPageObjects.getPhoneNumberErrorMsg();
        System.out.println("Error Messages" + errorMsg);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify LoginWithOtp Button Functionality",
            priority = 2 )
    public void verifyLoginWithOtpButtonFunctionality()
    {
        System.out.println("Verifying LoginWithOtp Button Functionality");
        forgotPasswordPageObjects.clickLoginWithOtp();
        String  currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL : " + currentUrl);
        Assert.assertEquals(currentUrl,"https://redx.shopups1.xyz/login/");
        driver.navigate().back();
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Continue Button Functionality",
            priority = 3 )
    public void verifyContinueButtonFunctionality()
    {
        System.out.println("Verifying Continue Button Functionality");
        forgotPasswordPageObjects.enterPhoneNumberInput(validInput[0]);
        forgotPasswordPageObjects.clickContinueButton();
        String title = resetPasswordPageObjects.getTitleValue();
        System.out.println("Title : " + title);
        Assert.assertEquals(title,"Verify and reset password");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Reset Password Error Msg Values",
            priority = 4 )
    public void verifyResetPasswordErrorMsgValues()
    {
        System.out.println("Verifying Reset Password Error Msg Values");
        resetPasswordPageObjects.performVerifyFunctionality(invalidInput[1],invalidInput[2],invalidInput[3]);
        List<String> errorMsgs = resetPasswordPageObjects.getAllErrorMsg();
        System.out.println("Error Messages" + errorMsgs);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Edit Button Functionality",
            priority = 5 )
    public void verifyEditButtonFunctionality()
    {
        System.out.println("Verifying Edit Button Functionality");
        resetPasswordPageObjects.clickEditIcon();
        forgotPasswordPageObjects.clickContinueButton();
        String title = resetPasswordPageObjects.getTitleValue();
        System.out.println("Title : " + title);
        Assert.assertEquals(title,"Forgot password");
    }

    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Password Eye Icon Functionality",
            priority = 6 )
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

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Confirm Password Eye Icon Functionality",
            priority = 7 )
    public void verifyConfirmPasswordEyeIconFunctionality()
    {
        System.out.println("Verifying Confirm Password Eye Icon Functionality");
        resetPasswordPageObjects.clickConfirmPasswordEyeIcon();
        String type = resetPasswordPageObjects.getConfirmPasswordInputType();
        resetPasswordPageObjects.clickConfirmPasswordEyeIcon();
        System.out.println("Type : " + type);
        Assert.assertEquals(type,"text");
    }

    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Verify Button Functionality",
            priority = 8 )
    public void verifyVerifyButtonFunctionality()
    {
        System.out.println("Verifying Verify Button Functionality");
        resetPasswordPageObjects.clickVerifyButton();
        String header =  resetPasswordSuccessPageObjects.getHeaderValue();
        System.out.println("Header : " + header);
        Assert.assertEquals(header,"Password updated");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify ReturnToLogin Button Functionality",
            priority = 9 )
    public void verifyReturnToLoginButtonFunctionality()
    {
        System.out.println("Verifying ReturnToLogin Button Functionality");
        resetPasswordSuccessPageObjects.clickReturnToLoginButton();
        String  currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL : " + currentUrl);
        Assert.assertEquals(currentUrl,"https://redx.shopups1.xyz/login/?password=true");
    }

    @AfterClass(alwaysRun = true)
    public void changePasswordPageTestsAfterClass()
    {
        System.out.println("Change Password Page Tests After Class");
    }

    @AfterSuite(alwaysRun = true)
    public void changePasswordPageTestsAfterSuite()
    {
        System.out.println("Change Password Page Tests After Suite");
        driver.quit();
    }
}
