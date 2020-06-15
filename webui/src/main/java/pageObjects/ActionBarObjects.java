package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

public class ActionBarObjects {
    private WebDriver driver;
    private MyActions myActions;
    //Shopup icon
    @FindBy(xpath = "//img[@alt='logo']")
    private WebElement shopupIcon;
    //Search bar text
    @FindBy(xpath = "//input[@type='text'][@id='searchTag']")
    private WebElement searchBarText;
    //Search Icon
    @FindBy(xpath = "//i[text()='search']")
    private WebElement searchIcon;
    //login icon
    @FindBy(xpath = "//p[text()='Login']")
    private WebElement loginButton;
    //Track order icon
    @FindBy(xpath = "//p[text()='Track order']")
    private WebElement trackOrderButton;
    //Myshop icon
    @FindBy(xpath = "//p[text()='My Shop']")
    private WebElement myshopButton;
    //Bag icon
    @FindBy(xpath = "//p[text()='bag']")
    private WebElement bagButton;

    public ActionBarObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
    }

    public void clickOnShopupIcon() {
        myActions.action_click(shopupIcon);
    }

    public void clickOnSearchBarText(String Object) {
        myActions.action_click(searchBarText);
        myActions.action_sendKeys(searchBarText, Object);
    }

    public void clickOnSearchIcon() {
        myActions.action_click(searchIcon);
    }

    public void clickOnLoginButton() {
        myActions.action_click(loginButton);
    }

    public void clickOnTrackOrder() {
        myActions.action_click(trackOrderButton);
    }

    public void clickOnMyshopButton() {
        myActions.action_click(myshopButton);
    }

    public void clickOnBagButton() {
        myActions.action_click(bagButton);
    }


    /*------FUNCTION-----*/
    public void searchToObject(String Object) {
        clickOnSearchBarText(Object);
        clickOnSearchIcon();
    }

}
