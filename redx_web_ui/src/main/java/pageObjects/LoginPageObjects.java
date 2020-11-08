package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.*;


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
    private WebElement editOTPText;
    private WebElement submitOTPButton;
    private WebElement loginWithPasswordIcon;


    /*****************Actions***************/

    public void clickOnMerchantLoginButton()
    {
        merchantLoginButton = driver.findElement(By.xpath("//div[@class='nav-links flex-end display-on-desktop']/button"));
        myActions.action_click(merchantLoginButton);
    }

    public void enterMobileNo(String mobileNo)
    {
        editMobileNoText = driver.findElement(By.xpath("//div[@class='signup-phone-field']/input"));
        myActions.action_sendKeys(editMobileNoText,mobileNo);
    }

    public void clickOnSendOTPButton()
    {
        sendOTPButton = driver.findElement(By.xpath("//div[@class='signup-phone-field']/button"));
        myActions.action_click(sendOTPButton);
    }

    public void enterOTPButton(String mobileNo)
    {
        editOTPText = driver.findElement(By.xpath("//div[@class='login-form-wrapper']/div[3]/input"));
        sleep(1000);
        myActions.action_sendKeys(editOTPText,mobileNo);
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

    public void performAuthentication(String mobileNo,String otp) throws InterruptedException {
        clickOnMerchantLoginButton();
        enterMobileNo(mobileNo);
        enterMobileNo("7");
        enterMobileNo("7");
        Thread.sleep(1000);
        clickOnSendOTPButton();
        enterOTPButton(otp);
        clickSubmitButton();

    }


}
