package pageObjects;

import auth.CookieManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import utils.*;

import java.util.List;


public class LoginPageObjects extends RedXWebBaseClass {

    private WebDriver driver;
    private MyActions myActions;
    private Actions actions;
    private String ck;

    public LoginPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
        actions = new Actions(driver);
    }

    private WebElement merchantLoginButton;
    private WebElement editMobileNoText;
    private WebElement sendOTPButton;
    private List<WebElement> editOTPText;
    private WebElement submitOTPButton;
    private WebElement loginWithPasswordIcon;
    private WebElement modalCloseButton;

    private WebElement signUpPhoneNumber;
    private WebElement joinAsMerchantButton;

    /*****************Actions***************/

    public void clickOnMerchantLoginButton()
    {
        merchantLoginButton = xpathSetter("//div[@class='nav-links flex-end display-on-desktop']/button");
        myActions.action_click(merchantLoginButton);
    }

    public void enterMobileNo(String mobileNo)
    {
        editMobileNoText = xpathSetter("//div[@class='login-form-wrapper']//input");
        myActions.action_sendKeys(editMobileNoText,mobileNo);
    }

    public void clickOnContinueButton()
    {
        sendOTPButton = xpathSetter("//text()[.='Continue']/ancestor::button[1]");
        myActions.action_click(sendOTPButton);
    }

    public void enterOTPButton(String otp)
    {
        editOTPText = xpathListSetter("//div[@class='otp']/input");
        for(int i=0;i<4;i++){
        myActions.action_sendKeys(editOTPText.get(i),String.valueOf(otp.charAt(i)));}
    }

    public void clickOnLoginWithPasswordIcon(String mobileNo)
    {
        loginWithPasswordIcon = driver.findElement(By.xpath("//div[@class='password-action-wrapper']/button"));
        myActions.action_click(loginWithPasswordIcon);
    }

    public void clickSubmitButton()
    {
        submitOTPButton = xpathSetter("//button[@type='submit']");
        myActions.action_click(submitOTPButton);
    }

    public void enterSignUpPhoneNumber(String phoneNumber)
    {
        signUpPhoneNumber = xpathSetter("//div[@class='signup-phone-field']//input");
        myActions.action_sendKeys(signUpPhoneNumber,phoneNumber);
    }

    public void clickJoinAsMerchantButton()
    {
        joinAsMerchantButton = xpathSetter("//form/button");
        myActions.action_click(joinAsMerchantButton);
    }

    public void clickCloseModalButton()
    {
        try {
            sleep(2000);
            actions.sendKeys(Keys.ESCAPE).build().perform();
        } catch (Exception e)
        {
            System.out.println("Modal Not Found : " + e);
        }
    }





    /*****************Functions***************/

    public String performAuthentication(String mobileNo,String otp,String lastMobileNo)
    {
        clickOnMerchantLoginButton();
        enterMobileNo(mobileNo);
        enterMobileNo(lastMobileNo);
        clickOnContinueButton();
        enterOTPButton(otp);
        clickSubmitButton();
        sleep(2000);
        waitForLoading();
        ck = null;
        for(Cookie cookie : driver.manage().getCookies()){
            ck = cookie.getName();
            if(ck.equalsIgnoreCase("__ti__"))
            {
                ck = cookie.getName() + "=" + cookie.getValue();
//                System.out.println("Cookie Value : " + ck);
                try {
                    CookieManager.setValue(CookieManager.Keys.RED_X_COOKIE,ck);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return ck;
            }
        }
        return null;
    }

    public String signUpMerchant(String phoneNumber,String otp)
    {
        enterSignUpPhoneNumber(phoneNumber);
        clickJoinAsMerchantButton();
        enterOTPButton(otp);
        clickSubmitButton();
        sleep(2000);
        ck = null;
        for(Cookie cookie : driver.manage().getCookies()){
            ck = cookie.getName();
            if(ck.equalsIgnoreCase("__ti__"))
            {
                ck = cookie.getName() + "=" + cookie.getValue();
//                System.out.println("Cookie Value : " + ck);
                try {
                    CookieManager.setValue(CookieManager.Keys.RED_X_COOKIE,ck);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return ck;
            }
        }
        return null;
    }

    public void waitForLoading()
    {
        int count =0;
        while(!driver.getCurrentUrl().equalsIgnoreCase(RedXWebUrlUtils.dashboardUrl))
        {
            sleep(100);
            count++;
            if(count>100)
            {
                System.out.println("Waited For 10 Seconds");
                break;
            }
        }
    }
}
