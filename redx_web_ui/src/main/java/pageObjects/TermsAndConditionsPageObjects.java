package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;
import utils.RedXWebBaseClass;

public class TermsAndConditionsPageObjects extends RedXWebBaseClass {

    private WebDriver driver;
    private MyActions myActions;

    public TermsAndConditionsPageObjects(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
    }

    /*----------Elements----------*/

    private WebElement acceptTermsButton;

    /*----------Actions----------*/

    public void clickAcceptTermsButton()
    {
        acceptTermsButton = xpathSetter("//span[text()='Accepts Terms']/..");
        myActions.action_click(acceptTermsButton);
    }
}
