package pageObjects;

import org.openqa.selenium.*;
import utils.*;


public class LoginPageObjects extends RedXBaseClass
{

    private MyActions myActions;

    public LoginPageObjects()
    {
        myActions = new MyActions();
    }

    /*----------Elements----------*/

    private WebElement loginButton;
    private WebElement enterMobileNumber;
    private WebElement submitMobileNumberButton;
    private WebElement enterOtpCode;
    private WebElement submitOtpCodeButton;
    private WebElement resendOtpButton;
    private WebElement confirmResendOtpButton;
    private WebElement changeMobileNumberButton;

    /*----------Actions----------*/

    public void clickLoginButton()
    {
        loginButton = xpathSetter("//android.widget.TextView[@text='LOGIN WITH PHONE NUMBER']");
        myActions.action_click(loginButton);
    }

    public void enterMobileNumber(String mobileNumber)
    {
        enterMobileNumber = xpathSetter("//android.widget.EditText[@text='01XXXXXXXXX']");
        myActions.action_sendKeys(enterMobileNumber,mobileNumber);
    }

    public void clickSubmitMobileNumber()
    {
        submitMobileNumberButton = xpathSetter("//android.view.ViewGroup/android.view.ViewGroup[3]");
        myActions.action_click(submitMobileNumberButton);
        myActions.action_click(submitMobileNumberButton);
    }

    public void enterOtpCode(String otp)
    {
        enterOtpCode = xpathSetter("//android.view.ViewGroup/android.widget.EditText");
        myActions.action_sendKeys(enterOtpCode,otp);
    }

    public void clickSubmitOtp()
    {
        submitOtpCodeButton = xpathSetter("//android.view.ViewGroup/android.view.ViewGroup[2]");
        myActions.action_click(submitOtpCodeButton);
    }

    public void clickResendOtpButton()
    {
        resendOtpButton = xpathSetter("//android.view.ViewGroup/android.widget.TextView[2]");
        myActions.action_click(resendOtpButton);

    }

    public void clickConfirmButton()
    {
        confirmResendOtpButton = idSetter("android:id/button1");
        myActions.action_click(confirmResendOtpButton);
    }

    public void clickChangeMobileNumberButton()
    {
        changeMobileNumberButton = xpathSetter("//android.view.ViewGroup/android.widget.TextView[@index='2']");
        myActions.action_click(changeMobileNumberButton);
    }

    /*----------Functions----------*/
    public void performAuthentication(String mobileNumber,String otp)
    {

        clickLoginButton();
        sleep(1000);
        enterMobileNumber(mobileNumber);
        clickSubmitMobileNumber();
        sleep(3000);
        enterOtpCode(otp);
        clickSubmitOtp();
    }

    public void performResendOtp(String mobileNumber, String otp)
    {
        clickLoginButton();
        sleep(1000);
        enterMobileNumber(mobileNumber);
        clickSubmitMobileNumber();
        sleep(3000);
        clickResendOtpButton();
        sleep(1000);
        clickConfirmButton();
        enterOtpCode(otp);
        clickSubmitOtp();
    }

    public void performChangeNumber(String mobileNumber, String otp)
    {
        clickLoginButton();
        sleep(1000);
        enterMobileNumber(mobileNumber);
        clickSubmitMobileNumber();
        sleep(3000);
        clickChangeMobileNumberButton();
        sleep(2000);
        myActions.action_clearText(enterMobileNumber);
        enterMobileNumber(mobileNumber);
        clickSubmitMobileNumber();
        sleep(2000);
        enterOtpCode(otp);
        clickSubmitOtp();
    }

}
