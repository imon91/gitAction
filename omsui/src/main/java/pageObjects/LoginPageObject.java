package pageObjects;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;
import utils.OmsBaseClass;

public class LoginPageObject extends OmsBaseClass {
    private WebDriver driver;
    private MyActions myActions;
    private String ck;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
    }


    /*--------------Actions-------------------*/
    public void enterInternalPortal() {
        WebElement internalPortal = xpathSetter("//div[2]//a/img");
        myActions.action_click(internalPortal);
    }

    public void enterEmail(String email) {
        WebElement emailEntry = xpathSetter("//input[@id='identifierId']");
        myActions.action_sendKeys(emailEntry, email);
    }

    public void clickOnEmailNextButton() {
        WebElement submitButton = xpathSetter("//div[@id='identifierNext']//div[2]");
        myActions.action_click(submitButton);
    }

    public void enterPassword(String password) {
        WebElement passwordEntry = xpathSetter("//input[@name='password']");
        myActions.action_sendKeys(passwordEntry, password);
    }

    public void clickOnPWNextButton() {
        WebElement submitButton = xpathSetter("//div[@id='passwordNext']//div[2]");
        myActions.action_click(submitButton);
    }


    /*--------------Functions-------------------*/
    public void performLogin(String email, String password){
        enterInternalPortal();
        enterEmail(email);
        clickOnEmailNextButton();
        enterPassword(password);
        clickOnPWNextButton();
        sleep(2000);
        for(Cookie cookie : driver.manage().getCookies()){
            ck = cookie.getName() + "=" + cookie.getValue() + ";Path=/; HttpOnly" ;
            System.out.println(ck);
        }
    }
}
