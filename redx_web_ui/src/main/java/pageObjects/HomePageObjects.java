package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.*;

public class HomePageObjects {

    private WebDriver driver;
    private MyActions myActions;

    public HomePageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
    }

    private WebElement myShopButton;
    private WebElement newParcelButton ;
    private WebElement startDate;
    private WebElement endDate;
    private WebElement paymentDetails;
    private WebElement notificationSettings;
    private WebElement coverageArea;
    private WebElement changePassword;
    private WebElement creditHistory;
    private WebElement tutorial;
    private WebElement logout;



    public void clickOnDropDownMyShopButton()
    {
        myShopButton = driver.findElement(By.xpath("//ul[@class='ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-root ant-dropdown-menu-vertical']/li[1]"));
        myActions.action_click(myShopButton);
    }

    public void clickOnCreateParcelButton()
    {
        newParcelButton = driver.findElement(By.xpath("//div[@class='nav-links display-on-desktop']/a[5]"));
        myActions.action_click(newParcelButton);
    }

    public void clickOnStartDate()
    {
        startDate = driver.findElement(By.xpath("//form[@class='ant-form ant-form-inline dateRange']/div[1]"));
        myActions.action_click(startDate);
    }

    public void clickOnEndDate()
    {
        endDate = driver.findElement(By.xpath("//form[@class='ant-form ant-form-inline dateRange']/div[2]"));
        myActions.action_click(endDate);
    }

    public void clickOnDropDownMyPaymentDetails()
    {
        paymentDetails = driver.findElement(By.xpath("//ul[@class='ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-root ant-dropdown-menu-vertical']/li[2]"));
        myActions.action_click(paymentDetails);
    }

    public void clickOnDropDownNotificationSettings()
    {
        notificationSettings = driver.findElement(By.xpath("//ul[@class='ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-root ant-dropdown-menu-vertical']/li[3]"));
        myActions.action_click(notificationSettings);
    }

    public void clickOnDropDownCoverageArea()
    {
        coverageArea = driver.findElement(By.xpath("//ul[@class='ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-root ant-dropdown-menu-vertical']/li[4]"));
        myActions.action_click(coverageArea);
    }


    public void clickOnDropDownChangePassword()
    {
        changePassword = driver.findElement(By.xpath("//ul[@class='ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-root ant-dropdown-menu-vertical']/li[5]"));
        myActions.action_click(changePassword);
    }


    public void clickOnDropDownCreditHistory()
    {
        creditHistory = driver.findElement(By.xpath("//ul[@class='ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-root ant-dropdown-menu-vertical']/li[6]"));
        myActions.action_click(creditHistory);
    }


    public void clickOnDropDownTutorials()
    {
        tutorial = driver.findElement(By.xpath("//ul[@class='ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-root ant-dropdown-menu-vertical']/li[7]"));
        myActions.action_click(tutorial);
    }

    public void clickOnDropDownLogout()
    {
        logout = driver.findElement(By.xpath("//ul[@class='ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-root ant-dropdown-menu-vertical']/li[8]"));
        myActions.action_click(logout);
    }







}
