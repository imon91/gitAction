package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

public class LoginPageObjects {

    private AndroidDriver<AndroidElement> androidDriver;
    private MyActions myActions;

    public LoginPageObjects(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
    }

    // SignUp Label
    @AndroidFindBy(id = "com.shopup.reseller:id/text_login_label")
    private AndroidElement loginLabelTextView;


    // Mobile Number Edit text
    @AndroidFindBy(id = "com.shopup.reseller:id/et_mobile_number")
    private AndroidElement mobileNumberEditTextView;

    // otp verify button
    @AndroidFindBy(id = "com.shopup.reseller:id/text_button_verify")
    private AndroidElement verifyOTPButton;

    // OTP Label
    @AndroidFindBy(id = "com.shopup.reseller:id/text_otp_label")
    private AndroidElement otpLabelTextView;

    // OTP Edit text
    @AndroidFindBy(id = "com.shopup.reseller:id/et_otp")
    private AndroidElement otpNumberEditTextView;

    // Proceed button
    @AndroidFindBy(id = "com.shopup.reseller:id/text_button_proceed")
    private AndroidElement proceedButton;

    // Edit Mobile Number button
    @AndroidFindBy(id = "com.shopup.reseller:id/text_change_mobile")
    private AndroidElement editMobileNumberButton;

    // Resend OTP button
    @AndroidFindBy(id = "com.shopup.reseller:id/text_resend_otp")
    private AndroidElement resendOtpButton;





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

    public String getLoginLabelText(){
        return myActions.action_getText(loginLabelTextView);

    }

    private void getOTPLabelText(){
        myActions.action_getText(otpLabelTextView);
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

    // 3 : Edit Mobile Number Function

    // 4 : Wrong OTP Function

}
