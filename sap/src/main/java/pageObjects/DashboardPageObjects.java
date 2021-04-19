package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;
import utils.SapBaseClass;

public class DashboardPageObjects extends  SapBaseClass{

    private WebDriver driver;
    private MyActions myActions;

    public DashboardPageObjects (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        myActions = new MyActions();
    }

    /*----------Elements----------*/

    private WebElement shopUpLogo;
    private WebElement dashboardModule;
    private WebElement logisticsModule;
    private WebElement importParcelsModule;
    private WebElement receiveModule;
    private WebElement dispatchModule;
    private WebElement downloadModule;

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
//        logisticsModule = xpathSetter("//ul/li[10]//a[contains(text(),'Logistics')]");
        logisticsModule = xpathSetter(driver,"//ul/li[9]//a[contains(text(),'Logistics')]");
//        logisticsModule = driver.findElement(By.xpath("//ul/li[10]//a[contains(text(),'Logistics')]"));
        myActions.action_click(logisticsModule);
    }

    public void clickImportParcelsModule()
    {
//        importParcelsModule = xpathSetter("//a[@href='/logistics/import-parcel']");
        importParcelsModule = xpathSetter(driver,"//a[@href='/logistics/import-parcel']");
//        importParcelsModule = driver.findElement(By.xpath("//a[@href='/logistics/import-parcel']"));
        myActions.action_click(importParcelsModule);
    }

    public void clickRecieveModule()
    {
//        receiveModule = xpathSetter("//a[@href='/logistics/receive']");
        receiveModule = xpathSetter(driver,"//a[@href='/logistics/receive']");
//        receiveModule = driver.findElement(By.xpath("//a[@href='/logistics/receive']"));
        myActions.action_click(receiveModule);
    }

    public void clickDispatchModule()
    {
//        dispatchModule = xpathSetter("//a[@href='/logistics/dispatch-station']");
        dispatchModule = xpathSetter(driver,"//a[@href='/logistics/dispatch-station']");
//        dispatchModule = driver.findElement(By.xpath("//a[@href='/logistics/dispatch-station']"));
        myActions.action_click(dispatchModule);
    }

    public void clickDownloadModule()
    {
//        downloadModule = xpathSetter("//a[@href='/logistics/download']");
        downloadModule = xpathSetter(driver,"//a[@href='/logistics/download']");
//        downloadModule = driver.findElement(By.xpath("//a[@href='/logistics/download']"));
        myActions.action_click(downloadModule);
    }
}

