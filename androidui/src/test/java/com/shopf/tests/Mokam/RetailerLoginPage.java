package com.shopf.tests.Mokam;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.*;
import utils.AndroidBaseClass;
import utils.MyActions;
import utils.PropertyReader;
import utils.ServiceRequestLayer;

import java.util.Random;

public class RetailerLoginPage extends AndroidBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private ServiceRequestLayer serviceRequestLayer;
    private LoginPageObjects loginPageObjects;
    private HomePageObjects homePageObjects;
    private ActionBarObjects actionBarObjects;
    private SalesRepFeaturePageObject salesRepFeaturePageObject;
    private RightNavigationDrawer rightNavigationDrawer;
    private SoftAssert softAssert;
    private MyActions myActions;
    private WebElement verifyWithOtpButton;
    public String registrationRetailerPhoneText = "REGISTER RETAILER PHONE";
    public String addRetailerPhoneNumberText = "Add retailer's phone number";
    public String verifyWithOtpText = "VERIFY WITH OTP";
    public String selectARetailerText = "Select a Retailer";
    public String oneTimePasswordText = "ONE TIME PASSWORD";
    public String enterOTPText = "Enter OTP";
    public String resendOTPText = "Resend OTP";
    public String proceedButtonText = "PROCEED";
    public String editMobileNumberText = "EDIT MOBILE NUMBER" ;
    public String validMobileNumber = "8801877755590";
    public String validSRMobileNumber = "1877775590";
    public String validOTP = "666666";
    public String invalidMobileNumber = "187775590";
    public String invalidOTP = "66666";
    public String unableToVerifyOTPText = "Unable to verify OTP";
    public String wrongOTPEnteredText = "Wrong OTP entered. ";
    public String attemptsRemainingText = " attempts remaining.";
    public String dismissButtonText = "DISMISS";
    public String retryButtonText = "RETRY";
    public String maximumNumberOfAttemptsReachedText = "Maximum number of attempts reached. Please generate and OTP again to continue";
    public String noOTPFoundText = "No OTP found for ";
    public String pleaseGenerateOTPToContinueText = ". Please generate OTP to continue.";
    public String selectAnAddressText = "Select an Address";
    public String addNewAddress = "Add New Address";
    private String newShopName;
    private String newAddress;
    private String newMobileNumber;
    private String newArea;
    private String displayedNameAndAddress;
    private String beforeNameAndAddress;
    private String newNameAndAddress;

    @BeforeSuite(alwaysRun = true)
    public void loginScreenBeforeSuite() throws Exception {
        System.out.println("RetailerLoginPageBeforeSuite is called");
        androidDriver = getBaseDriver();
        try{
            PropertyReader.flushDynamicData();
        }catch (Exception e){
            System.out.println("Exception at ResellerAndroidBeforeSuite : flushDynamicData");
        }
        serviceRequestLayer = new ServiceRequestLayer();
        myActions = new MyActions();
        serviceRequestLayer.getControlOverAuthentication().performAuthentication();
        pageInitializer();
        loginPageObjects.performAuthentication(validMobileNumber,validOTP);
        sleep(4000);
//        homePageObjects.deleteExistingAddress(0);
        sleep(4000);
        try {
            if (androidDriver.currentActivity().equalsIgnoreCase(CoreConstants.ANDROID_PROFILE_ACTIVITY)) {
                homePageObjects.selectAddress(0);
            }
        } catch (Exception e){
//            homePageObjects.createNewAddress();
            System.out.println("User has only 1 address");
        }
        sleep(4000);
        actionBarObjects.clickOnUserProfileImageButton();
        rightNavigationDrawer.clickOnItemChangeLanguage();
        rightNavigationDrawer.selectEnglish();
        rightNavigationDrawer.saveLanguage();
        sleep(5000);
        actionBarObjects.clickOnUserProfileImageButton();
        rightNavigationDrawer.clickOnItemLogout();
        serviceRequestLayer.getControlOverAuthentication().performAuthentication();
        loginPageObjects.performAuthentication(validSRMobileNumber,validOTP);
        sleep(4000);
        salesRepFeaturePageObject.clickOnAddANewRetailer();
    }

    public void pageInitializer(){
        System.out.println("PageInitializer is Called");
        loginPageObjects = new LoginPageObjects(androidDriver);
        actionBarObjects = new ActionBarObjects(androidDriver);
        salesRepFeaturePageObject = new SalesRepFeaturePageObject(androidDriver);
        homePageObjects = new HomePageObjects(androidDriver);
        rightNavigationDrawer = new RightNavigationDrawer(androidDriver);
        softAssert = new SoftAssert();
    }

    private void invalidOTPPopup(){
        loginPageObjects.enterOtp("555555");
        sleep(2000);
        loginPageObjects.clickOnProceedButton();
        sleep(5000);
    }

    private void initiateNewShopNameAndAddress(){
        newShopName = RandomStringUtils.randomAlphabetic(7) ;
        newAddress = RandomStringUtils.randomAlphanumeric(10);
        newMobileNumber = "18"+RandomStringUtils.randomNumeric(8);
    }

    private void enterNewShopNameAndAddress(){
        homePageObjects.enterShopName(newShopName);
        homePageObjects.enterAddress(newAddress);
        homePageObjects.editMobileNumber(newMobileNumber);
        newArea = homePageObjects.enterArea();
        newNameAndAddress = "Smoke Flow shop "+newShopName+newAddress+"\n"+newArea+"\nMobile: 880"+newMobileNumber;
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 1)
    public void verifyActivityOfLoginPage(){
        System.out.println("verifyActivityOfLoginPage is called");
        String activity = androidDriver.currentActivity();
        System.out.println(activity);
        Assert.assertEquals(activity,CoreConstants.ANDROID_REGISTRATION_PAGE_ACTIVITY);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 2)
    public void verifyRegistrationRetailerPhoneText(){
        System.out.println("verifyRegistrationRetailerPhoneText is called");
        String text = salesRepFeaturePageObject.getRegisterRetailerPhoneText();
        Assert.assertEquals(text,registrationRetailerPhoneText);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 3)
    public void verifyAddRetailerPhoneNumberText(){
        System.out.println("verifyAddRetailerPhoneNumberText is called");
        String text = salesRepFeaturePageObject.getAddRetailersPhoneNumberText();
        Assert.assertEquals(text,addRetailerPhoneNumberText);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 4)
    public void verifyVerifyWithOtpText(){
        System.out.println("verifyVerifyWithOtpText is called");
        String text = salesRepFeaturePageObject.getVerifyWithOtpText();
        Assert.assertEquals(text,verifyWithOtpText);
        sleep(5000);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 5)
    public void verifyHardKeyBackButtonFunctionality() throws Exception {
        System.out.println("verifyHardKeyBackButtonFunctionality is called");
        myActions.clickOnHardKeyBack();
        sleep(5000);
        String text = salesRepFeaturePageObject.getPageTitleOfRetailerListPage();
        Assert.assertEquals(text,selectARetailerText);
        salesRepFeaturePageObject.clickOnAddANewRetailer();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 6)
    public void verifyBackButtonFunctionality() throws Exception {
        System.out.println("verifyBackButtonFunctionality is called");
        salesRepFeaturePageObject.clickOnRetailerLoginPageBackButton();
        String text = salesRepFeaturePageObject.getPageTitleOfRetailerListPage();
        Assert.assertEquals(text,selectARetailerText);
        salesRepFeaturePageObject.clickOnAddANewRetailer();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 7)
    public void verifyLoginWithInvalidNumber(){
        loginPageObjects.enterMobileNumber(invalidMobileNumber);
        verifyWithOtpButton = loginPageObjects.getVerifyOtpButtonElement();
        Assert.assertFalse(verifyWithOtpButton.isEnabled());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 8)
    public void verifyLoginWithValidNumber(){
        loginPageObjects.enterMobileNumber(validMobileNumber);
        verifyWithOtpButton = loginPageObjects.getVerifyOtpButtonElement();
        Assert.assertTrue(verifyWithOtpButton.isEnabled());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 9)
    public void verifyVerifyWithOtpButtonFunctionality(){
        loginPageObjects.clickOnVerifyOtpButton();
    }


    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 10)
    public void verifyOneTimePasswordText(){
        String text = loginPageObjects.getOTPLabelText();
        Assert.assertEquals(text,oneTimePasswordText);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 11)
    public void verifyEnterOTPText(){
        String text = loginPageObjects.getEnterOTPText();
        Assert.assertEquals(text,enterOTPText);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 12)
    public void verifyProceedButtonText(){
        String text = loginPageObjects.getProceedButtonElement().getText();
        Assert.assertEquals(text,proceedButtonText);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 13)
    public void verifyEditMobileNumberText(){
        String text = loginPageObjects.getEditMobileNumberButtonElement().getText();
        Assert.assertEquals(text,editMobileNumberText);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 14)
    public void verifyHardKeyBackButtonFunctionalityOtpPage() throws Exception {
        myActions.clickOnHardKeyBack();
        sleep(4000);
        loginPageObjects.clickOnVerifyOtpButton();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 15)
    public void verifyEditMobileNumberButtonFunctionality(){
        loginPageObjects.getEditMobileNumberButtonElement().click();
        loginPageObjects.clickOnVerifyOtpButton();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 16)
    public void verifyLoginWithInvalidOTP(){
        loginPageObjects.enterOtp(invalidOTP);
        Assert.assertFalse(loginPageObjects.getProceedButtonElement().isEnabled());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 17)
    public void verifyDismissButtonText(){
        invalidOTPPopup();
        Assert.assertEquals(dismissButtonText,loginPageObjects.getDismissButtonText());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 18)
    public void verifyRetryButtonText(){
        Assert.assertEquals(retryButtonText,loginPageObjects.getRetryButtonText());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 19)
    public void verifyUnableToVerifyOTPText(){
        Assert.assertEquals(unableToVerifyOTPText,loginPageObjects.getUnableToVerifyOTPText());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 20)
    public void verify3AttemptsRemainingText(){
        Assert.assertEquals(wrongOTPEnteredText+"3"+attemptsRemainingText,loginPageObjects.getWrongOTPEnteredText());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 21)
    public void verify2AttemptsRemainingText(){
        loginPageObjects.clickOnOtpErrorPopupMessageRetryButton();
        Assert.assertEquals(wrongOTPEnteredText+"2"+attemptsRemainingText,loginPageObjects.getWrongOTPEnteredText());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 22)
    public void verify1AttemptsRemainingText(){
        loginPageObjects.clickOnOtpErrorPopupMessageRetryButton();
        Assert.assertEquals(wrongOTPEnteredText+"1"+attemptsRemainingText,loginPageObjects.getWrongOTPEnteredText());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 23)
    public void verifyMaximumNumberOfAttemptsReachedText(){
        loginPageObjects.clickOnOtpErrorPopupMessageRetryButton();
        Assert.assertEquals(maximumNumberOfAttemptsReachedText,loginPageObjects.getWrongOTPEnteredText());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 24)
    public void verifyNoOTPFoundText(){
        loginPageObjects.clickOnOtpErrorPopupMessageRetryButton();
        Assert.assertEquals(noOTPFoundText+validMobileNumber+pleaseGenerateOTPToContinueText,loginPageObjects.getWrongOTPEnteredText());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 25)
    public void verifyDismissButtonFunctionality() {
        //Assert.assertTrue(loginPageObjects.dismissButtonElement().isEnabled());
        loginPageObjects.clickOnOtpErrorPopupMessageDismissButton();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 26)
    public void verifyProceedButtonFunctionality(){
        loginPageObjects.clickOnResendOtpButton();
        loginPageObjects.enterOtp(validOTP);
        Assert.assertTrue(loginPageObjects.getProceedButtonElement().isEnabled());
        loginPageObjects.clickOnProceedButton();
    }


    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority =27)
    public void verifyPageTitleOfAddressListPage(){
        Assert.assertEquals(selectAnAddressText,homePageObjects.getPageTitleElementOfAddressSelection().getText());
        System.out.println(homePageObjects.getPageTitleElementOfAddressSelection().getText());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 28)
    public void verifyDeleteAddressButtonFunctionality(){
        String thirdAddress = null;
        try {
            thirdAddress = homePageObjects.getShopNameAndAddress(2);
        }catch (Exception e){
            System.out.println("Address List has less than 2 addresses");
        }
        if (thirdAddress != null) {
            String beforeAddress = homePageObjects.getShopNameAndAddress(0);
            homePageObjects.deleteExistingAddress(0);
            sleep(4000);
            String afterAddress = homePageObjects.getShopNameAndAddress(0);
            Assert.assertNotEquals(beforeAddress, afterAddress);
        }
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 29)
    public void verifyEditAddressButtonFunctionality(){
        beforeNameAndAddress = homePageObjects.getShopNameAndAddress(0);
        homePageObjects.clickEditAddress(0);
        initiateNewShopNameAndAddress();
        enterNewShopNameAndAddress();
        homePageObjects.editAddressSaveButtonElement().click();
        //homePageObjects.addressUpdatedSuccessfully;
        sleep(5000);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 30)
    public void verifyEditedAddressIsNotSameAsPreviousAddressInAddressListPage(){
        displayedNameAndAddress = homePageObjects.getShopNameAndAddress(0);
        Assert.assertNotEquals(beforeNameAndAddress,displayedNameAndAddress);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 31)
    public void verifyEditedAddressMatchesNewlyDisplayedAddressInAddressListPage(){
        System.out.println(newNameAndAddress);
        System.out.println(displayedNameAndAddress);
        softAssert.assertEquals(newNameAndAddress,displayedNameAndAddress);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 32)
    public void verifyAddNewAddressElementButtonText(){
//        System.out.println(homePageObjects.getAddNewAddressText());
//        softAssert.assertEquals(addNewAddress,homePageObjects.getAddNewAddressText());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 33)
    public void verifyCreateNewAddressFunctionality() throws Exception {
//        homePageObjects.createNewAddress();
    }


    @AfterSuite(alwaysRun = true)
    public void retailerLoginPageAfterSuite(){
        System.out.println("retailerLoginPageAfterSuite is called");
        quitBaseDriver();
    }

}
