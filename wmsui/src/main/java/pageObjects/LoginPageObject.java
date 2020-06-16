package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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



    //Email Entry Text
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailTextView;

    //Password Entry Text
    @FindBy(xpath = "//input[@id='password']")
    private  WebElement passwordTextView;

    //Submit Button
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;



    /*--------------Actions-------------------*/
    private void enterEmail(String email){myActions.action_sendKeys(emailTextView,email);}

    private void enterPassword(String password){myActions.action_sendKeys(passwordTextView,password);}

    private void clickOnSubmitButton(){myActions.action_click(submitButton);}



    /*--------------Functions-------------------*/
    public void performLogin(String email,String password){
        enterEmail(email);
        enterPassword(password);
        clickOnSubmitButton();
    }
}
