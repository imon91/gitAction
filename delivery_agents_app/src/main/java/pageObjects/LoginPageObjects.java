package pageObjects;

import org.openqa.selenium.WebElement;
import utils.*;

import java.util.List;

public class LoginPageObjects extends DeliveryAgentsBaseClass {

    private MyActions myActions;

    public LoginPageObjects()
    {
        myActions = new MyActions();
    }

    /*----------Elements----------*/

    private WebElement mobileNumberInput;
    private WebElement nextButton;
    private List<WebElement> otpInputFields;
    private WebElement otpNextButton;
    private WebElement allowButton;

    /*----------Actions----------*/

    public void enterMobileNumberInput(String mobileNumber)
    {
        mobileNumberInput = xpathSetter("//android.widget.EditText");
        myActions.action_sendKeys(mobileNumberInput,mobileNumber);
    }

    public void clickNextButton()
    {
        nextButton = xpathSetter("//android.widget.TextView[@text='NEXT']");//index[0]
        myActions.action_click(nextButton);
    }

    public void enterOtpInputFields(String otp)
    {
        otpInputFields = xpathListSetter("//android.view.ViewGroup[@index='2']/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText");
        for(int i=0;i<4;i++){
            myActions.action_sendKeys(otpInputFields.get(i),String.valueOf(otp.charAt(i)));}
    }

    public void clickOtpNextButton()
    {
        otpNextButton = xpathSetter("//android.widget.Button");
        myActions.action_click(otpNextButton);
    }

    public void clickAllowButton()
    {
        allowButton = xpathSetter("//android.widget.Button[contains(@text,'Allow')]");
        myActions.action_click(allowButton);
    }

    /*----------Functions----------*/

    public void performAuthentication(String mobileNumber,String otp)
    {
        enterMobileNumberInput(mobileNumber);
        clickNextButton();
        enterOtpInputFields(otp);
        clickOtpNextButton();
        clickAllowButton();
    }
}
