package pageObjects;

import org.openqa.selenium.*;
import utils.*;
import io.appium.java_client.android.*;


public class LoginPageObjects extends AndroidBaseClass{

    private AndroidDriver<AndroidElement> androidDriver;
    private MyActions myActions;
    private String packageName;

    public LoginPageObjects(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
        myActions = new MyActions();
        packageName = AndroidBaseClass.getAppPackage();
    }


    /*--------------Actions-------------------*/

    private void enterMobileNumber(String mobileNumber){
        myActions.action_sendKeys(androidDriver.
                findElement(By.xpath("//android.widget.EditText[@resource-id='"+packageName+":id/et_mobile_number']")),mobileNumber);
    }

    private void clickOnVerifyOtpButton(){
        myActions.action_click(androidDriver.
                findElement(By.xpath("//android.widget.TextView[@resource-id='"+packageName+":id/text_button_verify']")));
    }

    private void enterOtp(String otp){
        myActions.action_sendKeys(androidDriver.
                findElement(By.xpath("//android.widget.EditText[@resource-id='"+packageName+":id/et_otp']")),otp);
    }

    private void clickOnProceedButton(){
        myActions.action_click(androidDriver.
                findElement(By.xpath("//android.widget.TextView[@resource-id='"+packageName+":id/text_button_proceed']")));
    }

    private void clickOnEditMobileNumberButton(){
        myActions.action_click(androidDriver.
                findElement(By.xpath("//android.widget.TextView[@resource-id='"+packageName+":id/text_change_mobile']")));
    }

    private void clickOnResendOtpButton(){
        myActions.action_click(androidDriver.
                findElement(By.xpath("//android.widget.TextView[@resource-id='"+packageName+":id/text_resend_otp']")));
    }

    public String getLoginLabelText(){
        return myActions.action_getText(androidDriver.
                findElement(By.xpath("//android.widget.TextView[@resource-id='"+packageName+":id/text_login_label']")));

    }

    private String getOTPLabelText(){
        return myActions.action_getText(androidDriver.
                findElement(By.xpath("//android.widget.TextView[@resource-id='"+packageName+":id/text_otp_label']")));
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
    public void performEditMobileNumberFunctionality(String mobileNumber1,String mobileNumber2,String otp){
        enterMobileNumber(mobileNumber1);
        clickOnVerifyOtpButton();
        clickOnEditMobileNumberButton();
        enterMobileNumber(mobileNumber2);
        enterOtp(otp);
        clickOnProceedButton();
    }

    // 4 : Wrong OTP Function
    public void performWrongOTPFunctionality(String mobileNumber,String otp){
        enterMobileNumber(mobileNumber);
        clickOnVerifyOtpButton();
        enterOtp(otp);
        clickOnProceedButton();
    }

}
