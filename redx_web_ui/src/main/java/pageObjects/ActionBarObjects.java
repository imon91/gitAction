package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.*;



public class ActionBarObjects extends RedXWebBaseClass{

    private WebDriver driver;
    private MyActions myActions;
    private HomePageObjects homePageObjects;
    private MyShopsPageObjects myShopsPageObjects;

    public ActionBarObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
        homePageObjects = new HomePageObjects(driver);
        myShopsPageObjects = new MyShopsPageObjects(driver);
    }


    /*----------Elements----------*/


    private WebElement redxLogo;

    private WebElement searchFilterButton;
    private WebElement searchFilterArrowIcon;
    private WebElement searchBarEntry;
    private WebElement trackParcelButton;

    private WebElement dashboardLink;
    private WebElement parcelsLink;
    private WebElement couponLink;
    private WebElement paymentsLink;
    private WebElement createParcelLink;
    private WebElement shopName;

    private WebElement shopDropDownArrow;
    private WebElement myShopsDropDown;
    private WebElement myPaymentDetailsDropDown;
    private WebElement notificationSettingsDropDown;
    private WebElement coverageAreaDropDown;
    private WebElement changePasswordDropDown;
    private WebElement creditHistoryDropDown;
    private WebElement pickupLocationDropDown;
    private WebElement tutorialsDropDown;
    private WebElement logoutDropDown;

    private WebElement modalCloseButton;

    private WebElement shopDropDownButton;


    /*----------Actions----------*/


    public void clickOnRedXlogo()
    {
        redxLogo = xpathSetter("//img[@class='logo']");
        myActions.action_click(redxLogo);
    }

    public String getSearchFilterButtonValue()
    {
        searchFilterButton = xpathSetter("//div[@class='ant-select-selection-selected-value']");
        return myActions.action_getText(searchFilterButton);
    }

    public void clickSearchFilterArrowIcon()
    {
        searchFilterArrowIcon = xpathSetter("//div[@class='input-group']//i");
        myActions.action_click(searchFilterArrowIcon);
    }

    public void selectSearchFilter(int index)
    {
        myActions.action_click(xpathSetter("//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']/li["+index+"]"));
    }

    public void enterSearchBar(String ID)
    {
        searchBarEntry = xpathSetter("//div[@class='input-group']//input");
        searchBarEntry.clear();
        myActions.action_sendKeys(searchBarEntry,ID);
    }

    public String getSearchBarPlaceholderValue()
    {
        searchBarEntry = xpathSetter("//div[@class='input-group']//input");
        String placeholder = searchBarEntry.getAttribute("placeholder");
        return placeholder;
    }

    public void clickTrackParcelButton()
    {
        trackParcelButton = xpathSetter("//div[@class='input-group']//button");
        myActions.action_click(trackParcelButton);
    }

    public void clickOnDashboardLink()
    {
        dashboardLink = xpathSetter("//a[@href='/dashboard/']");
        myActions.action_click("//a[@href='/dashboard/']");
    }

    public void clickParcelsLink()
    {
        parcelsLink = xpathSetter("//div[@class='nav-links display-on-desktop']/a[2]");
        myActions.action_click("//div[@class='nav-links display-on-desktop']/a[2]");
        waitForLoading();
    }

    public void clickPaymentsLink()
    {
        paymentsLink = xpathSetter("//div[@class='nav-links display-on-desktop']/a[3]");
        myActions.action_click("//div[@class='nav-links display-on-desktop']/a[3]");
        waitForLoading();
    }

    public void clickCouponLink()
    {
        couponLink = xpathSetter("//div[@class='nav-links display-on-desktop']/a[4]");
        myActions.action_click("//div[@class='nav-links display-on-desktop']/a[4]");
        waitForLoading();
    }

    public void clickOnCreateParcelButton()
    {
        createParcelLink = xpathSetter("//div[@class='nav-links display-on-desktop']/a[5]");
        myActions.action_click("//div[@class='nav-links display-on-desktop']/a[5]");
        waitForLoading();
        myActions.action_click(xpathSetter("//span[@class='ant-notification-close-x']//i"));
        sleep(1000);
    }

    public String getShopName()
    {
        shopName = xpathSetter("//div[@class='nav-links display-on-desktop']/a[@class='ant-dropdown-trigger dropdown']/span");
        return myActions.action_getText("//div[@class='nav-links display-on-desktop']/a[@class='ant-dropdown-trigger dropdown']/span").toLowerCase();
    }

    public void clickOnShopDropDownArrow()
    {
        shopDropDownArrow = xpathSetter("//div[@class='nav-links display-on-desktop']//i[@class='anticon anticon-down']");
        myActions.action_click(shopDropDownArrow);
    }

    public void clickOnDropDownMyShopButton()
    {
        clickOnShopDropDownArrow();
        myShopsDropDown = xpathSetter("//ul[@class='ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-root ant-dropdown-menu-vertical']/li[1]");
        myActions.action_click(myShopsDropDown);
        waitForLoading();
    }

    public void clickOnPickupLocationDropDown()
    {
        clickOnShopDropDownArrow();
        pickupLocationDropDown = xpathSetter("//ul[@class='ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-root ant-dropdown-menu-vertical']/li[2]");
        myActions.action_click(pickupLocationDropDown);
        waitForLoading();
    }

    public void clickOnMyPaymentDetailsDropDown()
    {
        clickOnShopDropDownArrow();
        myPaymentDetailsDropDown = xpathSetter("//ul[@class='ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-root ant-dropdown-menu-vertical']/li[3]");
        myActions.action_click(myPaymentDetailsDropDown);
        waitForLoading();
    }

    public void clickOnNotificationSettingsDropDown()
    {
        clickOnShopDropDownArrow();
        notificationSettingsDropDown = xpathSetter("//ul[@class='ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-root ant-dropdown-menu-vertical']/li[4]");
        myActions.action_click(notificationSettingsDropDown);
        waitForLoading();
    }

    public void clickOnCoverageAreaDropDown()
    {
        clickOnShopDropDownArrow();
        coverageAreaDropDown = xpathSetter("//ul[@class='ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-root ant-dropdown-menu-vertical']/li[5]");
        myActions.action_click(coverageAreaDropDown);
        waitForLoading();
    }


    public void clickOnChangePasswordDropDown()
    {
        clickOnShopDropDownArrow();
        changePasswordDropDown = xpathSetter("//ul[@class='ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-root ant-dropdown-menu-vertical']/li[6]");
        myActions.action_click(changePasswordDropDown);
        waitForLoading();
    }


    public void clickOnCreditHistoryDropDown()
    {
        clickOnShopDropDownArrow();
        creditHistoryDropDown = xpathSetter("//ul[@class='ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-root ant-dropdown-menu-vertical']/li[7]");
        myActions.action_click(creditHistoryDropDown);
        waitForLoading();
    }


    public void clickOnTutorialsDropDown()
    {
        clickOnShopDropDownArrow();
        tutorialsDropDown = xpathSetter("//ul[@class='ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-root ant-dropdown-menu-vertical']/li[8]");
        myActions.action_click(tutorialsDropDown);
    }

    public void clickOnLogoutDropDown()
    {
        clickOnShopDropDownArrow();
        logoutDropDown = xpathSetter("//ul[@class='ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-root ant-dropdown-menu-vertical']/li[9]");
        myActions.action_click(logoutDropDown);
        waitForLoading();
    }


    public void clickOnDropDownButton()
    {
        shopDropDownButton = driver.findElement(By.xpath("//a[@class='ant-dropdown-trigger dropdown']"));
        myActions.action_click(shopDropDownButton);
    }

    public void clickModalCloseButton()
    {
        modalCloseButton = xpathSetter("//div[@class='ant-modal-body']//span[text()='Close']/..");
        myActions.action_click(modalCloseButton);
    }


    /*----------Functions----------*/

    public void waitForLoading()
    {
        while (driver.getCurrentUrl().equalsIgnoreCase(RedXWebUrlUtils.dashboardUrl))
            sleep(100);
    }

    public void changeShop(String name)
    {
        if(getShopName().equalsIgnoreCase(name))
            System.out.println("Given shop is Current Shop");
        else
        {
            clickOnDropDownMyShopButton();
            myShopsPageObjects.clickShopByName(name);
            System.out.println("Current Shop : " + getShopName());
        }
    }

    public void chooseSearchFilter(int index)
    {
//        System.out.println("Index : " + index);
       /* index Value
       1 - Parcel
       2 - Invoice
        */
        clickSearchFilterArrowIcon();
        selectSearchFilter(index);
    }

    public String searchParcels(String ID)
    {
        enterSearchBar(ID);
        clickTrackParcelButton();
        waitForLoading();
        return "";
//        return homePageObjects.getToastMessage();
    }
}
