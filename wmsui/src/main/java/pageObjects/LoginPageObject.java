package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

public class LoginPageObject {

    private WebDriver driver;
    private MyActions myActions;

    public LoginPageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
    }
}
