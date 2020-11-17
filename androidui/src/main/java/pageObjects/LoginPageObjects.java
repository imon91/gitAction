package pageObjects;

import coreUtils.*;
import org.openqa.selenium.*;
import utils.*;
import io.appium.java_client.android.*;


public class LoginPageObjects extends AndroidBaseClass{

    private AndroidDriver<WebElement> androidDriver;
    private MyActions myActions;
    private String packageName;
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

    private WebElement enterMobileNumberText;

    private WebElement enterOTPText;


    /*--------------Actions-------------------*/

    public void closePopup(){
        if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
            WebElement closeButtonElement = xpathSetter("//android.widget.ImageView[@index='1']");
            myActions.action_click(closeButtonElement);
        }
    }

    public void enterMobileNumber(String mobileNumber){
      enterMobileNumberEditText = xpathSetter("//android.widget.EditText[@resource-id='"+ packageName +":id/phone_edit']");
        myActions.action_sendKeys(enterMobileNumberEditText,mobileNumber);
    }

    public void clickOnVerifyOtpButton(){
       if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
           verifyOtpButton = xpathSetter("//android.widget.TextView[@resource-id='"+ packageName +":id/action_verify_otp']");
       } else if(app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
           verifyOtpButton = xpathSetter("//android.widget.TextView[@resource-id='"+ packageName +":id/action_verify_otp']");
       }
        myActions.action_click(verifyOtpButton);
    }


    public void enterOtp(String otp){
       if(app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
           enterOtpEditText = xpathSetter("//android.widget.EditText[@resource-id='"+ packageName +":id/otp_edit']");
       }else if (app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
           enterOtpEditText = xpathSetter("//android.widget.EditText[@resource-id='"+ packageName +":id/otp_edit']");
        }
        myActions.action_sendKeys(enterOtpEditText,otp);
    }

    public void clickOnProceedButton(){
       if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
           proceedButton = xpathSetter("//android.widget.TextView[@resource-id='" + packageName +":id/action_verify_otp']");
       }else if(app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
            proceedButton = xpathSetter("//android.widget.TextView[@resource-id='"+ packageName +":id/action_verify_otp']");
       }
        myActions.action_click(proceedButton);
    }

    public void clickOnEditMobileNumberButton(){
       if(app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
           editMobileNumberButton = xpathSetter("//android.widget.TextView[@resource-id='" + packageName +":id/action_change_mobile']");
       } else if (app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
           editMobileNumberButton = xpathSetter("//android.widget.TextView[@resource-id='"+ packageName +":id/action_change_mobile']");
       }
        myActions.action_click(editMobileNumberButton);
    }

    public void clickOnResendOtpButton(){
       if(app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
           resendOtpButton = xpathSetter("//android.widget.TextView[@resource-id='"+ packageName +":id/action_resend_otp']");
       } else if (app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
           resendOtpButton = xpathSetter("//android.widget.TextView[@resource-id='"+ packageName +":id/action_resend_otp']");
       }
        myActions.action_click(resendOtpButton);
    }

    public String getLoginLabelText(){
        loginLabelText = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/text_login_label']");
        return myActions.action_getText(loginLabelText);

    }

    public String getEnterMobileNumberText(){
        enterMobileNumberText = xpathSetter("//android.widget.EditText[@resource-id='"+ packageName +":id/phone_edit']");
        return myActions.action_getText(enterMobileNumberText);
    }

    public String getOTPLabelText(){
        otpLabelText = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/text_otp_label']");
        return myActions.action_getText(otpLabelText);
    }

    public String getEnterOTPText(){
        enterOTPText = xpathSetter("//android.widget.EditText[@resource-id='"+ packageName +":id/otp_edit']");
        return myActions.action_getText(enterOTPText);
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
