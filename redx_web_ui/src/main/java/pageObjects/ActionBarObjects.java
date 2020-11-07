package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.*;



public class ActionBarObjects {

    private WebDriver driver;
    private MyActions myActions;

    public ActionBarObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
    }

    private WebElement redXLogo;
    private WebElement trackingIdText;
    private WebElement trackParcelButton;
    private WebElement dashBoardIcon;
    private WebElement parcelPageIcon;
    private WebElement couponIcon;
    private WebElement paymentIcon;
    private WebElement createParcelIcon;
    private WebElement shopDropDownButton;



    public void clickOnRedXLogo()
    {
        redXLogo = driver.findElement(By.xpath("//div[@class='navbar']/div[1]//img[@class='logo']"));
        myActions.action_click(redXLogo);
    }

    public void enterTrackingIdText(String trackingID)
    {
        trackingIdText = driver.findElement(By.xpath("//div[@class='navbar']/div[1]/div[@class='input-group']//input"));
        myActions.action_sendKeys(trackingIdText,trackingID);
    }

    public void clickOnTrackParcelButton()
    {
        trackParcelButton = driver.findElement(By.xpath("//div[@class='navbar']/div[1]/div[@class='input-group']//button"));
        myActions.action_click(trackParcelButton);
    }

    public void clickOnDashBoardIcon()
    {
        dashBoardIcon = driver.findElement(By.xpath("//div[@class='nav-links display-on-desktop']/a[1]"));
        myActions.action_click(dashBoardIcon);
    }

    public void clickOnParcelPage()
    {
        parcelPageIcon = driver.findElement(By.xpath("//div[@class='nav-links display-on-desktop']/a[2]"));
        myActions.action_click(parcelPageIcon);
    }

    public void clickOnCouponIcon()
    {
        couponIcon = driver.findElement(By.xpath("//div[@class='nav-links display-on-desktop']/a[3]"));
        myActions.action_click(couponIcon);
    }

    public void clickOnPaymentIcon()
    {
        paymentIcon = driver.findElement(By.xpath("//div[@class='nav-links display-on-desktop']/a[4]"));
        myActions.action_click(paymentIcon);
    }

    public void clickOnCreateParcelIcon()
    {
        createParcelIcon = driver.findElement(By.xpath("//div[@class='nav-links display-on-desktop']/a[5]"));
        myActions.action_click(createParcelIcon);
    }

    public void clickOnDropDownButton()
    {
        shopDropDownButton = driver.findElement(By.xpath("//a[@class='ant-dropdown-trigger dropdown']"));
        myActions.action_click(shopDropDownButton);
    }




}
