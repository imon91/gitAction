package com.shopup.shopUpAndroid.pageObjects;

import com.shopup.utils.MyActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {

    private AndroidDriver androidDriver;
    private MyActions myActions;

    public LoginPageObjects(AndroidDriver androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(androidDriver,this);
        myActions = new MyActions();
    }

    // SignUp Label
    @AndroidFindBy(id = "com.shopup.reseller:id/text_login_label")
    private WebElement loginLabelTextView;

    // Mobile Number Edit text
    @AndroidFindBy(id = "com.shopup.reseller:id/et_mobile_number")
    private WebElement mobileNumberEditTextView;

    // otp verify button
    @AndroidFindBy(id = "com.shopup.reseller:id/text_button_verify")
    private WebElement verifyOTPButton;

    // OTP Label
    @AndroidFindBy(id = "com.shopup.reseller:id/text_otp_label")
    private WebElement otpLabelTextView;

    // OTP Edit text
    @AndroidFindBy(id = "com.shopup.reseller:id/et_otp")
    private WebElement otpNumberEditTextView;

    // Proceed button
    @AndroidFindBy(id = "com.shopup.reseller:id/text_button_proceed")
    private WebElement proceedButton;

    // Edit Mobile Number button
    @AndroidFindBy(id = "com.shopup.reseller:id/text_change_mobile")
    private WebElement editMobileNumberButton;

    // Resend OTP button
    @AndroidFindBy(id = "com.shopup.reseller:id/text_resend_otp")
    private WebElement resendOtpButton;





    /*--------------Actions-------------------*/

    private void enterMobileNumber(String mobileNumber){
        myActions.action_sendKeys(mobileNumberEditTextView,mobileNumber);
    }

    private void clickOnVerifyOtpButton(){
        myActions.action_click(verifyOTPButton);
    }

    private void enterOtp(String otp){
        myActions.action_sendKeys(otpNumberEditTextView,otp);
    }

    private void clickOnProceedButton(){
        myActions.action_click(proceedButton);
    }

    private void clickOnEditMobileNumberButton(){
        myActions.action_click(editMobileNumberButton);
    }

    private void clickOnResendOtpButton(){
        myActions.action_click(resendOtpButton);
    }



    /*----Functions*/

    // 1 : Normal Authentication Function
    public void performAuthentication(String mobileNumber, String otp){
        enterMobileNumber(mobileNumber);
        clickOnVerifyOtpButton();
        enterOtp(otp);
        clickOnVerifyOtpButton();
        clickOnProceedButton();
    }

    // 2 : Resend Otp Function

    // 3 : Edit Mobile Number Function

    // 4 : Wrong OTP Function

}
