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
    @FindBy(xpath = "//div[@class='search-container']/i")
    private WebElement searchIcon;
    //login icon
    @FindBy(xpath = "//ul[@class='right-items text-right']/li[1]/a")
    private WebElement loginButton;
    //Track order icon
    @FindBy(xpath = "//p[text()='Track order']")
    private WebElement trackOrderButton;
    //Myshop icon
    @FindBy(xpath = "//ul[@class='right-items text-right']/li[3]/a")
    private WebElement myshopButton;
    //Bag icon
    @FindBy(xpath = "//p[text()='bag']")
    private WebElement bagButton;
    //Dropdown Myorder
    @FindBy(xpath = "//div[@class='my-account-dropdown text-left']/a[3]")
    private WebElement dropdownmyorder;
    //Dropdown Logout
    @FindBy(xpath = "//div[@class='my-account-dropdown text-left']/a[4]")
    private WebElement dropdownlogout;

    //myorder page product -1
    @FindBy(xpath = "//div[@class='myorders-list-main']/div[1]/ul/li/div/div[1]/div/p[1]/b")
    private WebElement ordernumber_myorder;



    public ActionBarObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
    }

    public void clickOnShopupIcon() {
        myActions.action_click(shopupIcon);
    }

    public void clickOnSearchBarText(String Object) {
        //myActions.action_click(searchBarText);
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

    public void dropDownMyOrder() {
        myActions.action_click(dropdownmyorder);
    }

    public void dropDownLogout(){
        myActions.action_click(dropdownlogout);
    }

    public void dropDown(){
        myActions.action_click(dropdownlogout);
    }


    /*------FUNCTION-----*/
    public void searchToObject(String Object) throws InterruptedException {
        clickOnSearchBarText(Object);
        Thread.sleep(1000);
        clickOnSearchIcon();
    }

    //get ordenumber at myorder
    public String getOrderNumberAtMyorder() {
        String orderNumber=myActions.action_getText(ordernumber_myorder);
        return orderNumber ;
    }


}
