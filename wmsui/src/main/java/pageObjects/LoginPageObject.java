package pageObjects;

import auth.CookieManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.*;

public class LoginPageObject extends WmsBaseClass {

    private WebDriver driver;
    private MyActions myActions;
    private String ck;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
    }


    /*--------------Actions-------------------*/
    private void enterEmail(String email) {
        WebElement emailEntry = xpathSetter("//input[@id='email']");
        myActions.action_sendKeys(emailEntry, email);
    }

    private void enterPassword(String password) {
        WebElement passwordEntry = xpathSetter("//input[@id='password']");
        myActions.action_sendKeys(passwordEntry, password);
    }

    private void clickOnSubmitButton() {
        WebElement submitButton = xpathSetter("//button[@type='submit']");
        myActions.action_click(submitButton);
    }


    /*--------------Functions-------------------*/
    public void performLogin(String email, String password) throws Exception {
        enterEmail(email);
        enterPassword(password);
        clickOnSubmitButton();
        sleep(2000);
        for(Cookie cookie : driver.manage().getCookies()){
            ck = cookie.getName() + "=" + cookie.getValue() + ";Path=/; HttpOnly" ;
            System.out.println(ck);
        }
        CookieManager.setValue(CookieManager.Keys.WMS_COOKIE,ck);
    }
}
