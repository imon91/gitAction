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
    private WebElement mobileNumberMessage;
    private WebElement enterOtpCode;
    private WebElement submitOtpCodeButton;
    private WebElement resendOtpButton;
    private WebElement confirmResendOtpButton;
    private WebElement changeMobileNumberButton;
    private WebElement otpMessage;
    private  WebElement popUpMessage;
    private WebElement popUpButton;
    private WebElement popUpTitle;

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
        submitMobileNumberButton = xpathSetter("//android.widget.TextView[@text='NEXT']");
        myActions.action_click(submitMobileNumberButton);
        myActions.action_click(submitMobileNumberButton);
    }

    public String  verifyMobileNumber()
    {
        mobileNumberMessage = xpathSetter("//android.widget.TextView[3]");
        if(mobileNumberMessage.isDisplayed())
        {
            return myActions.action_getText(mobileNumberMessage);
        }
        else
            return "Valid Mobile Number";
    }

    public void enterOtpCode(String otp)
    {
        enterOtpCode = xpathSetter("//android.widget.EditText[@text='4-digit code']");
        myActions.action_sendKeys(enterOtpCode,otp);
    }

    public void clickSubmitOtp()
    {
        submitOtpCodeButton = xpathSetter("//android.widget.TextView[@text='NEXT']");
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

    public String getPopUpTitle()
    {
        popUpTitle = xpathSetter("//android.widget.LinearLayout[@resource-id='android:id/title_template']/android.widget.TextView");
        return myActions.action_getText(popUpTitle);
    }

    public String getPopUpMessage()
    {
        popUpMessage = idSetter("android:id/message");
        return myActions.action_getText(popUpMessage);
    }

    public void clickPopUpButton()
    {
        popUpButton = idSetter("android:id/button1");
        myActions.action_click(popUpButton);
    }

    public String verifyOtp()
    {
        otpMessage = xpathSetter("//android.widget.TextView[2]");
        if(otpMessage.isDisplayed())
        {
            return myActions.action_getText(otpMessage);
        }
        else return "Valid Otp";
    }

    /*----------Functions----------*/

    public void performAuthentication(String mobileNumber,String otp1)
    {
        System.out.println("Performing Authentication");
        clickLoginButton();
        enterMobileNumber(mobileNumber);
//        System.out.println(verifyMobileNumber());
//        if (verifyMobileNumber() == "Valid Mobile Number")
//        {
//            clickSubmitMobileNumber();
//            popUpBox();
//            enterOtpCode(otp1);
//            clickSubmitOtp();
//            System.out.println(verifyOtp());
//        }
        clickSubmitMobileNumber();
        enterOtpCode(otp1);
        clickSubmitOtp();
    }

    public void performResendOtp(String otp)
    {
        System.out.println("Performing Resend Otp");
        clickResendOtpButton();
        clickConfirmButton();
        enterOtpCode(otp);
        clickSubmitOtp();
    }

    public void performChangeNumber(String mobileNumber, String otp)
    {
        System.out.println("Performing Change Mobile Number");
        clickChangeMobileNumberButton();
        myActions.action_clearText(enterMobileNumber);
        enterMobileNumber(mobileNumber);
        clickSubmitMobileNumber();
        enterOtpCode(otp);
        clickSubmitOtp();
    }

    public void popUpBox()
    {
        if(popUpTitle.isDisplayed())
        {
            System.out.println("PopUp Title :" + getPopUpTitle());
            System.out.println("PopUp Message :" + getPopUpMessage());
            clickPopUpButton();
        }
    }

}
