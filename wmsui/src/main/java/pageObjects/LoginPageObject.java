package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MyActions;

public class LoginPageObject {

    private WebDriver driver;
    private MyActions myActions;
    private WebDriverWait wait;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
        wait = new WebDriverWait(driver,10);
    }


    //Email Entry Text
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailEntry;

    //Password Entry Text
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordEntry;

    //Submit Button
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;


    /*--------------Actions-------------------*/
    private void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailEntry));
        myActions.action_sendKeys(emailEntry, email);
    }

    private void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordEntry));
        myActions.action_sendKeys(passwordEntry, password);
    }

    private void clickOnSubmitButton() {
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        myActions.action_click(submitButton);
    }


    /*--------------Functions-------------------*/
    public void performLogin(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickOnSubmitButton();
    }

    public String getPopUpMessage(){
        String popUpMessage = "//div[@id='toastbar-text']";
        WebElement popUpMessageElement = driver.findElement(By.xpath(popUpMessage));
        return myActions.action_getText(popUpMessageElement);
    }
}
