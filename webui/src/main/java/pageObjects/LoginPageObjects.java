package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

public class LoginPageObjects {

    private WebDriver driver;
    private MyActions myActions;

    public LoginPageObjects(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        myActions = new MyActions();
    }

    // SignUp Label
    @FindBy(id = "com.shopup.reseller:id/text_login_label")
    private WebElement loginLabelTextView;


    // Mobile Number Edit text
    @FindBy(id = "com.shopup.reseller:id/et_mobile_number")
    private WebElement mobileNumberEditTextView;

    // otp verify button
    @FindBy(id = "com.shopup.reseller:id/text_button_verify")
    private WebElement verifyOTPButton;

    // OTP Label
    @FindBy(id = "com.shopup.reseller:id/text_otp_label")
    private WebElement otpLabelTextView;

    // OTP Edit text
    @FindBy(id = "com.shopup.reseller:id/et_otp")
    private WebElement otpNumberEditTextView;

    // Proceed button
    @FindBy(id = "com.shopup.reseller:id/text_button_proceed")
    private WebElement proceedButton;

    // Edit Mobile Number button
    @FindBy(id = "com.shopup.reseller:id/text_change_mobile")
    private WebElement editMobileNumberButton;

    // Resend OTP button
    @FindBy(id = "com.shopup.reseller:id/text_resend_otp")
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
