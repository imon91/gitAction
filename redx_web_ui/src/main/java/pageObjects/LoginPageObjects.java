package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.*;

import java.util.List;


public class LoginPageObjects extends RedXWebBaseClass{

    private WebDriver driver;
    private MyActions myActions;

    public LoginPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
    }

    private WebElement loginWithMobileNoButton;
    private WebElement merchantLoginButton;
    private WebElement editMobileNoText;
    private WebElement sendOTPButton;
    private List<WebElement> editOTPText;
    private WebElement submitOTPButton;
    private WebElement loginWithPasswordIcon;


    /*****************Actions***************/

    public void clickOnMerchantLoginButton()
    {
        merchantLoginButton = xpathSetter("//div[@class='nav-links flex-end display-on-desktop']/button");
        myActions.action_click(merchantLoginButton);
    }

    public void enterMobileNo(String mobileNo)
    {
        editMobileNoText = xpathSetter("//div[@class='signup-phone-field']/input");
        myActions.action_sendKeys(editMobileNoText,mobileNo);
    }

    public void clickOnContinueButton()
    {
        sendOTPButton = driver.findElement(By.xpath("//text()[.='Continue']/ancestor::button[1]"));
        myActions.action_click(sendOTPButton);
    }

    public void enterOTPButton(String mobileNo)
    {
        editOTPText = xpathListSetter("//div[@class='login-form-wrapper']/div/input");
        sleep(1000);
        for(int i=0;i<4;i++){
        myActions.action_sendKeys(editOTPText.get(i),mobileNo);}
    }

    public void clickOnLoginWithPasswordIcon(String mobileNo)
    {
        loginWithPasswordIcon = driver.findElement(By.xpath("//div[@class='password-action-wrapper']/button"));
        myActions.action_click(loginWithPasswordIcon);
    }

    public void clickSubmitButton()
    {
        submitOTPButton = driver.findElement(By.xpath("//div[@class='login-form-wrapper']/button"));
        myActions.action_click(submitOTPButton);
    }





    /*****************Functions***************/

    public void performAuthentication(String mobileNo,String otp,String lastMobileNo) throws InterruptedException {
        clickOnMerchantLoginButton();
        enterMobileNo(mobileNo);
        enterMobileNo(lastMobileNo);
        Thread.sleep(1000);
        clickOnContinueButton();
        enterOTPButton(otp);
        clickSubmitButton();

    }


}
