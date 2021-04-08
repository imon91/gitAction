package pageObjects;

import coreUtils.*;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    private WebElement unableToVerifyOTPText;

    private WebElement wrongOTPEnteredText;

    private WebElement otpErrorPopUpDismissButtonElement;

    private WebElement otpErrorPopUpRetryButtonElement;


    /*--------------Actions-------------------*/

    public void closePopup(){
        if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
            try {
                WebElement closeButtonElement = xpathSetter("//android.widget.ImageView[@index='0']");
                myActions.action_click(closeButtonElement);
            } catch (Exception e){
                System.out.println("Popup is not closeable");
            }
        }
    }

    public void enterMobileNumber(String mobileNumber){
        System.out.println("Control in enterMobileNumber : "+mobileNumber);
      enterMobileNumberEditText = xpathSetter("//android.widget.EditText[@resource-id='"+ packageName +":id/phone_edit']");
        myActions.action_sendKeys(enterMobileNumberEditText,mobileNumber);
    }

    public WebElement getEnterMobileNumberEditText(){
        return enterMobileNumberEditText = xpathSetter("//android.widget.EditText[@resource-id='"+ packageName +":id/phone_edit']");
    }

    public void clickOnVerifyOtpButton(){
       if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
           verifyOtpButton = xpathSetter("//android.widget.TextView[@resource-id='"+ packageName +":id/action_verify_otp']");
       } else if(app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
           verifyOtpButton = xpathSetter("//android.widget.TextView[@resource-id='"+ packageName +":id/action_verify_otp']");
       }
        myActions.action_click(verifyOtpButton);
    }

    public WebElement getVerifyOtpButtonElement(){
        if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
            return verifyOtpButton = xpathSetter("//android.widget.TextView[@resource-id='"+ packageName +":id/action_verify_otp']");
        } else if(app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
            return verifyOtpButton = xpathSetter("//android.widget.TextView[@resource-id='"+ packageName +":id/action_verify_otp']");
        }
        return null;
    }


    public void enterOtp(String otp){
       if(app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
           enterOtpEditText = xpathSetter("//android.widget.EditText[@resource-id='"+ packageName +":id/otp_edit']");
       }else if (app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
           enterOtpEditText = xpathSetter("//android.widget.EditText[@resource-id='"+ packageName +":id/otp_edit']");
        }
        myActions.action_sendKeys(enterOtpEditText,otp);
    }

    public WebElement getEnterOtpEditText(){
        if(app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
            return enterOtpEditText = xpathSetter("//android.widget.EditText[@resource-id='"+ packageName +":id/otp_edit']");
        }else if (app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
            return enterOtpEditText = xpathSetter("//android.widget.EditText[@resource-id='"+ packageName +":id/otp_edit']");
        }
        return null;
    }

    public void clickOnProceedButton(){
       if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
           proceedButton = xpathSetter("//android.widget.TextView[@resource-id='" + packageName +":id/action_verify_otp']");
       }else if(app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
            proceedButton = xpathSetter("//android.widget.TextView[@resource-id='"+ packageName +":id/action_verify_otp']");
       }
        myActions.action_click(proceedButton);
    }

    public WebElement getProceedButtonElement(){
        if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
            return proceedButton = xpathSetter("//android.widget.TextView[@resource-id='" + packageName +":id/action_verify_otp']");
        }else if(app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
            return proceedButton = xpathSetter("//android.widget.TextView[@resource-id='"+ packageName +":id/action_verify_otp']");
        }
        return null;
    }

    public void clickOnEditMobileNumberButton(){
       if(app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
           editMobileNumberButton = xpathSetter("//android.widget.TextView[@resource-id='" + packageName +":id/action_change_mobile']");
       } else if (app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
           editMobileNumberButton = xpathSetter("//android.widget.TextView[@resource-id='"+ packageName +":id/action_change_mobile']");
       }
        myActions.action_click(editMobileNumberButton);
    }

    public WebElement getEditMobileNumberButtonElement(){
        if(app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
            return editMobileNumberButton = xpathSetter("//android.widget.TextView[@resource-id='" + packageName +":id/action_change_mobile']");
        } else if (app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
            return editMobileNumberButton = xpathSetter("//android.widget.TextView[@resource-id='"+ packageName +":id/action_change_mobile']");
        }
        return null;
    }

    public void clickOnResendOtpButton(){
       if(app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
           resendOtpButton = xpathSetter("//android.widget.TextView[@resource-id='"+ packageName +":id/action_resend_otp']");
       } else if (app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
           resendOtpButton = xpathSetter("//android.widget.TextView[@resource-id='"+ packageName +":id/action_resend_otp']");
       }
        myActions.action_click(resendOtpButton);
    }

    public WebElement getResendOtpButtonElement(){
        if(app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
            return resendOtpButton = xpathSetter("//android.widget.TextView[@resource-id='"+ packageName +":id/action_resend_otp']");
        } else if (app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
            return resendOtpButton = xpathSetter("//android.widget.TextView[@resource-id='"+ packageName +":id/action_resend_otp']");
        }
        return null;
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

    public String getUnableToVerifyOTPText(){
        unableToVerifyOTPText = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/title_custom_dialog']");
        return myActions.action_getText(unableToVerifyOTPText);
    }

    public String getWrongOTPEnteredText(){
        wrongOTPEnteredText = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/description_custom_dialog']");
        return myActions.action_getText(wrongOTPEnteredText);
    }

    public String getDismissButtonText(){
        if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
            otpErrorPopUpDismissButtonElement = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/button_negative_custom_dialog']");
        } else if(app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
            otpErrorPopUpDismissButtonElement = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/button_negative_custom_dialog']");
        }
        return myActions.action_getText(otpErrorPopUpDismissButtonElement);
    }

    public String getRetryButtonText(){
        otpErrorPopUpRetryButtonElement = xpathSetter("//android.widget.TextView[@index=1][@resource-id='"+packageName+":id/button_positive_custom_dialog']");
        return myActions.action_getText(otpErrorPopUpRetryButtonElement);
    }

    public void clickOnOtpErrorPopupMessageRetryButton(){
        if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
            otpErrorPopUpRetryButtonElement = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/button_positive_custom_dialog']");
        } else if(app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
            otpErrorPopUpRetryButtonElement = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/button_positive_custom_dialog']");
        }
        myActions.action_click(otpErrorPopUpRetryButtonElement);
    }

    public void clickOnOtpErrorPopupMessageDismissButton(){
        if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
            otpErrorPopUpDismissButtonElement = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/button_negative_custom_dialog']");
        } else if(app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
            otpErrorPopUpDismissButtonElement = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/button_negative_custom_dialog']");
        }
        myActions.action_click(otpErrorPopUpDismissButtonElement);
    }

    public WebElement dismissButtonElement(){
        if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
            otpErrorPopUpDismissButtonElement = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/button_negative_custom_dialog']");
        } else if(app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
            otpErrorPopUpDismissButtonElement = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/button_negative_custom_dialog']");
        }
        return dismissButtonElement();
    }

    /*public String getOtpStatusMessage() {
        try {
            WebDriverWait wait = new WebDriverWait(getBaseDriver(), 30);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.ByAndroidUIAutomator.("Ui ")));
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
     */

    /*----Functions*/

    // 1 : Normal Authentication Function
    public void performAuthentication(String mobileNumber, String otp){
        System.out.println("Control in performAuthentication : "+mobileNumber);
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
