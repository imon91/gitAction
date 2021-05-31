package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.*;
import utils.*;

public class DashboardPageObjects extends  SapBaseClass{

    private WebDriver driver;
    private MyActions myActions;
    private Actions actions;

    public DashboardPageObjects (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        myActions = new MyActions();
        actions = new Actions(driver);
    }

    /*----------Elements----------*/

    private WebElement shopUpLogo;
    private WebElement dashboardModule;
    private WebElement logisticsModule;
    private WebElement importParcelsModule;
    private WebElement pickupModule;
    private WebElement receiveModule;
    private WebElement dispatchModule;
    private WebElement downloadModule;
    private WebElement deliveryModule;

    /*----------Actions----------*/

    public void clickShopUpLogo()
    {
        shopUpLogo = xpathSetter("//a[@href='/dashboard']");
        myActions.action_click(shopUpLogo);
    }

    public void clickDashboardModule()
    {
        dashboardModule = xpathSetter("//li[@href='/dashboard']");
        myActions.action_click(dashboardModule);
    }

    public void clickLogisticsModule()
    {
        logisticsModule = xpathSetter("//ul/li[9]//a[contains(text(),'Logistics')]");
        myActions.action_click(logisticsModule);
    }

    public void clickImportParcelsModule()
    {
        importParcelsModule = xpathSetter("//a[@href='/logistics/import-parcel']");
        myActions.action_click(importParcelsModule);
    }

    public void clickPickupModule()
    {
        pickupModule = xpathSetter("//a[@href='/logistics/pickup']");
        myActions.action_click(pickupModule);
    }

    public void clickReceiveModule()
    {
        receiveModule = xpathSetter("//a[@href='/logistics/receive']");
        myActions.action_click(receiveModule);
        skipReconcileReminder();
    }

    public void clickDispatchModule()
    {
        dispatchModule = xpathSetter("//a[@href='/logistics/dispatch-station']");
        myActions.action_click(dispatchModule);
    }

    public void clickDownloadModule()
    {
        downloadModule = xpathSetter("//a[@href='/logistics/download']");
        myActions.action_click(downloadModule);
    }

    public void clickDeliveryModule()
    {
        deliveryModule = xpathSetter("//a[@href='/logistics/delivery']");
        myActions.action_click(deliveryModule);
    }

    public void skipReconcileReminder()
    {
        sleep(2000);
        actions.sendKeys(Keys.ESCAPE).build().perform();
        sleep(1000);
        actions.sendKeys(Keys.ESCAPE).build().perform();
    }
}