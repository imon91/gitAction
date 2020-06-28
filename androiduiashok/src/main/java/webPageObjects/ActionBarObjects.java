package webPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

public class ActionBarObjects {
    private WebDriver driver;
    private MyActions myActions;


    public ActionBarObjects(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new (driver), this);
        myActions = new MyActions();
    }
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
    @FindBy(xpath = "//li[starts-with(@data-reactid,\".2tilrlk2ns.1.1.0.0.1.0\")]")
    private WebElement loginButton;

    //Track order icon
    @FindBy(xpath = "//li[starts-with(@data-reactid,\".2tilrlk2ns.1.1.0.0.1.2\")]")
    private WebElement trackOrderButton;

    //Myshop icon
    @FindBy(xpath = "//li[starts-with(@data-reactid,\".2tilrlk2ns.1.1.0.0.1.3\")]")
    private WebElement myshopButton;

    //Bag icon
    @FindBy(xpath = "//li[starts-with(@class,\"cart-icon mrvoonik-cart-icon\")]")
    private WebElement bagButton;

    public void clickOnShopupIcon{myActions.action_click(shopupIcon);}

    public void clickOnSearchBarText{myActions.action_click(searchBarText);}

    public void clickOnSearchIcon{myActions.action_click(searchIcon);}

    public void clickOnLoginButton{myActions.action_click(loginButton);}

    public void clickOnTrackOrder{myActions.action_click(trackOrderButton);}

    public void clickOnMyshopButton{myActions.action_click(myshopButton);}

    public void clickOnBagButton{myActions.action_click(bagButton);}

}
