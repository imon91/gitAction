package pageObjects;

import coreUtils.BuildParameterKeys;
import org.openqa.selenium.*;
import utils.*;
import io.appium.java_client.android.*;


public class LoginPageObjects extends AndroidBaseClass{

    private final AndroidDriver<WebElement> androidDriver;
    private final MyActions myActions;
    private final String packageName;
    private String app;

    public LoginPageObjects(AndroidDriver<WebElement> androidDriver){
        switchFromWebToNative();
        this.androidDriver = androidDriver;
        myActions = new MyActions();
        packageName = getAppPackage();
        app = System.getProperty(BuildParameterKeys.KEY_APP);
    }

    private WebElement enterMobileNumberEditText;

    private WebElement verifyOtpButton;

    private WebElement enterOtpEditText;

    private WebElement proceedButton;

    private WebElement editMobileNumberButton;

    private WebElement resendOtpButton;

    private WebElement loginLabelText;

    private WebElement otpLabelText;


    /*--------------Actions-------------------*/

    private void enterMobileNumber(String mobileNumber){
        enterMobileNumberEditText = xpathSetter("//android.widget.EditText[@resource-id='"+ packageName +":id/phone_edit']");
        myActions.action_sendKeys(enterMobileNumberEditText, mobileNumber);
    }

    private void clickOnVerifyOtpButton(){
        verifyOtpButton = xpathSetter("//android.widget.TextView[@resource-id='"+ packageName +":id/action_verify_otp']");
        myActions.action_click(verifyOtpButton);
    }

    private void enterOtp(String otp){
        enterOtpEditText = xpathSetter("//android.widget.EditText[@resource-id='"+ packageName +":id/otp_edit']");
        myActions.action_sendKeys(enterOtpEditText,otp);
    }

    private void clickOnProceedButton(){
        proceedButton = xpathSetter("//android.widget.TextView[@resource-id='"+ packageName +":id/action_verify_otp']");
        myActions.action_click(proceedButton);
    }

    private void clickOnEditMobileNumberButton(){
        editMobileNumberButton = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/text_change_mobile']");
        myActions.action_click(editMobileNumberButton);
    }

    private void clickOnResendOtpButton(){
        resendOtpButton = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/text_resend_otp']");
        myActions.action_click(resendOtpButton);
    }

    public String getLoginLabelText(){
        loginLabelText = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/text_login_label']");
        return myActions.action_getText(loginLabelText);

    }

    private String getOTPLabelText(){
        otpLabelText = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/text_otp_label']");
        return myActions.action_getText(otpLabelText);
    }



    /*----Functions*/

    // 1 : Normal Authentication Function
    public void performAuthentication(String mobileNumber, String otp){
        enterMobileNumber(mobileNumber);
        clickOnVerifyOtpButton();
        enterOtp(otp);
        clickOnProceedButton();
    }

    // 2 : Resend Otp Function
    public void performResendOTPFunction(String mobileNumber,String otp){
        enterMobileNumber(mobileNumber);
        clickOnVerifyOtpButton();
        sleep(30000); // Sleep for 30 seconds to get the Resend OPT button get activated
        clickOnResendOtpButton();
        enterOtp(otp);
        clickOnProceedButton();
    }

    // 3 : Edit Mobile Number Function
    public void performEditMobileNumberFunctionality(String mobileNumber1,String otp){
        enterMobileNumber(mobileNumber1);
        clickOnVerifyOtpButton();
        clickOnEditMobileNumberButton();
        myActions.action_clearText(enterMobileNumberEditText);
        enterMobileNumber(mobileNumber1);
        clickOnVerifyOtpButton();
        enterOtp(otp);
        clickOnProceedButton();
    }

    // 4 : Wrong OTP Function
    public void performWrongOTPFunctionality(String mobileNumber,String otp1){
        enterMobileNumber(mobileNumber);
        clickOnVerifyOtpButton();
        enterOtp("777777");
        clickOnProceedButton();
        enterOtp(otp1);
        clickOnProceedButton();
    }

}
