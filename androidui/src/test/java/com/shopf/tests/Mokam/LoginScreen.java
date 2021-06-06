package com.shopf.tests.Mokam;

import com.shopf.tests.*;
import coreUtils.*;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageObjects.*;
import utils.*;

public class LoginScreen extends AndroidBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private LoginPageObjects loginPageObjects;
    private ActionBarObjects actionBarObjects;
    private RightNavigationDrawer rightNavigationDrawer;
    private HomePageObjects homePageObjects;
    private ServiceRequestLayer serviceRequestLayer;
    private Address address;
    private Logout logout;
    private SoftAssert softAssert;
    private WebElement mobileNumberEditText;
    private WebElement verifyOtpButton;
    private WebElement otpEditText;
    private WebElement submitButton;
    private WebElement resendOTPButton;
    private WebElement editMobileNumber;
    String loginText_English = "LOGIN / SIGNUP USING MOBILE NUMBER";
    String enterMobileNumberText_English = "Enter your phone number";
    String otpText_English = "ONE TIME PASSWORD";
    String enterOTPText_English = "Enter OTP";


    @BeforeSuite(alwaysRun = true)
    public void loginScreenBeforeSuite() throws Exception {
        System.out.println("loginScreenBeforeSuite is called");
        androidDriver = getBaseDriver();
        try{
            PropertyReader.flushDynamicData();
        }catch (Exception e){
            System.out.println("Exception at ResellerAndroidBeforeSuite : flushDynamicData");
        }
        serviceRequestLayer = new ServiceRequestLayer();
        serviceRequestLayer.getControlOverAuthentication()
                .performAuthentication();
        pageInitializer();
        softAssert = new SoftAssert();
        loginPageObjects.performAuthentication("1877755530","666666");
        sleep(4000);
        try {
            if (androidDriver.currentActivity().equalsIgnoreCase(CoreConstants.ANDROID_PROFILE_ACTIVITY)) {
                homePageObjects.selectAddress(0);
            }
        } catch (Exception e){
//            homePageObjects.createNewAddress();
            System.out.println("User has only 1 address");
        }
//        xpathSetter("//androidx.cardview.widget.CardView[@index='0']/android.view.ViewGroup[@index='0']").click();
//        address.addressBeforeClass();
//        address.createAddressUsingGeoLocation();
        switchFromWebToNative();
        actionBarObjects.clickOnUserProfileImageButton();
        rightNavigationDrawer.clickOnItemChangeLanguage();
        rightNavigationDrawer.selectEnglish();
        rightNavigationDrawer.saveLanguage();
        sleep(5000);
        actionBarObjects.clickOnUserProfileImageButton();
        rightNavigationDrawer.clickOnItemLogout();
//        logout.logoutBeforeClass();
//        logout.verifyLogoutFunctionality();
    }

    public void pageInitializer(){
        loginPageObjects = new LoginPageObjects(androidDriver);
        actionBarObjects = new ActionBarObjects(androidDriver);
        rightNavigationDrawer = new RightNavigationDrawer(androidDriver);
        homePageObjects = new HomePageObjects(androidDriver);
        address = new Address();
        logout = new Logout();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 1)
    public void verifyActivityOfLoginPage(){
        String activity = androidDriver.currentActivity();
        Assert.assertEquals(activity,CoreConstants.ANDROID_REGISTRATION_PAGE_ACTIVITY);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 2)
    public void verifyLoginText_English(){
        String loginText = loginPageObjects.getLoginLabelText();
        Assert.assertEquals(loginText,loginText_English);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 3)
    public void verifyEnterMobileNumberText_English(){
        String enterMobileNumberText = loginPageObjects.getEnterMobileNumberText();
        Assert.assertEquals(enterMobileNumberText,enterMobileNumberText_English);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 4)
    public void verifyEnteringOtherThanNumberInMobileNumberEditText(){
        verifyOtpButton = loginPageObjects.getVerifyOtpButtonElement();
        loginPageObjects.enterMobileNumber("@mobileNumber*");
        Assert.assertFalse(verifyOtpButton.isEnabled());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 5)
    public void checkVerifyOtpButtonEnabledOrNot(){
        mobileNumberEditText = loginPageObjects.getEnterMobileNumberEditText();
        verifyOtpButton = loginPageObjects.getVerifyOtpButtonElement();
        loginPageObjects.enterMobileNumber("880187775590");
        softAssert.assertFalse(verifyOtpButton.isEnabled());
        mobileNumberEditText.clear();
        loginPageObjects.enterMobileNumber("18777");
        softAssert.assertFalse(verifyOtpButton.isEnabled());
        softAssert.assertAll();
        mobileNumberEditText.clear();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 6)
    public void verifyEntering13DigitMobileNumber(){
        loginPageObjects.enterMobileNumber("8801877755590");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 7)
    public void verifyOtpButtonClickableOrNot(){
        verifyOtpButton = loginPageObjects.getVerifyOtpButtonElement();
        softAssert.assertTrue(verifyOtpButton.isEnabled());
        mobileNumberEditText = loginPageObjects.getEnterMobileNumberEditText();
        mobileNumberEditText.clear();
        loginPageObjects.enterMobileNumber("1877755590");
        softAssert.assertTrue(verifyOtpButton.isEnabled());
        softAssert.assertAll();
        loginPageObjects.clickOnVerifyOtpButton();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 8)
    public void verifyOneTimePasswordText(){
        String otpText = loginPageObjects.getOTPLabelText();
        Assert.assertEquals(otpText,otpText_English);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 9)
    public void verifyEnterOTPText(){
        String enterOtpText = loginPageObjects.getEnterOTPText();
        Assert.assertEquals(enterOtpText,enterOTPText_English);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 10)
    public void enteringOtherThanNumberInOTPEditText(){
        submitButton = loginPageObjects.getProceedButtonElement();
        loginPageObjects.enterOtp("&OTP#");
        Assert.assertFalse(submitButton.isEnabled());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 11)
    public void checkSubmitButtonIsEnabledOrNot(){
        otpEditText = loginPageObjects.getEnterOtpEditText();
        submitButton = loginPageObjects.getProceedButtonElement();
        loginPageObjects.enterOtp("1234");
        Assert.assertFalse(submitButton.isEnabled());
        otpEditText.clear();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 12)
    public void verifyClickingResendOtpButton(){
        sleep(30000);
        resendOTPButton = loginPageObjects.getResendOtpButtonElement();
        Assert.assertTrue(resendOTPButton.isEnabled());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 13)
    public void verifyClickingEditMobileNumberButton(){
        editMobileNumber = loginPageObjects.getEditMobileNumberButtonElement();
        Assert.assertTrue(editMobileNumber.isEnabled());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 14)
    public void verifyEntering6DigitOTP(){
        loginPageObjects.enterOtp("666666");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 15)
    public void verifyOTPButtonClickableOrNot(){
        submitButton = loginPageObjects.getProceedButtonElement();
        Assert.assertTrue(submitButton.isEnabled());
    }

    @AfterSuite(alwaysRun = true)
    public void loginScreenAfterSuite(){
        System.out.println("loginScreenAfterSuite is called");
        quitBaseDriver();
    }


}
