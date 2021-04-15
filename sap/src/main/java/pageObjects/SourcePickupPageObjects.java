package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;
import utils.SapBaseClass;

import java.util.List;

public class SourcePickupPageObjects extends SapBaseClass {

    private WebDriver driver;
    private MyActions myActions;

    public SourcePickupPageObjects(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        myActions = new MyActions();
    }

    /*----------Elements----------*/

    private WebElement hubFilter;
    private WebElement agentFilter;
    private WebElement statusFilter;
    private WebElement fromDateFilter;
    private WebElement toDateFilter;
    private WebElement orderIdFilter;

    private WebElement downloadButton;
    private WebElement refreshButton;
    private WebElement resetFiltersButton;

    private List<WebElement> parcels;
    private WebElement parcelIdValue;
    private WebElement invoiceIdValue;
    private WebElement areaValue;


    /*----------Actions----------*/

    public int getParcelsSize()
    {
        parcels = xpathListSetter("//tbody/tr");
        return (parcels.size()-1);
    }

    public void enterHubFilter(String hubName)
    {
        hubFilter = xpathSetter("//input[@placeholder='Hub']");
        myActions.action_sendKeys(hubFilter,hubName);
        hubFilter.sendKeys(Keys.ENTER);
        sleep(1000);
    }

    public void clickAgentFilter()
    {
        agentFilter = xpathSetter("//select[@placeholder='Agent']");
        myActions.action_click(agentFilter);
    }

    public void chooseAgentFilter(String agentName)
    {
        clickAgentFilter();
        agentFilter = xpathSetter("//select[@placeholder='Agent']/option[text()='" + agentName + "']");
        myActions.action_click(agentFilter);
    }

    public void clickStatusFilter()
    {
        statusFilter = xpathSetter("//select[@placeholder='Status']");
        myActions.action_click(statusFilter);
    }

    public void chooseStatusFilter(String status)
    {
        clickStatusFilter();
        statusFilter = xpathSetter("//select[@placeholder='Status']/option[@label='" + status + "']");
        myActions.action_click(statusFilter);
    }

    public void clickFromDateFilter()
    {
        fromDateFilter = xpathSetter("//input[contains(@placeholder,'Date from')]");
        myActions.action_click(fromDateFilter);
    }

    public void clickToDateFilter()
    {
        toDateFilter = xpathSetter("//input[contains(@placeholder,'Date until')]");
        myActions.action_click(toDateFilter);
    }

    public void enterOrderIdFilter(String orderId)
    {
        orderIdFilter = xpathSetter("//input[contains(@placeholder,'order id')]");
        myActions.action_sendKeys(orderIdFilter,orderId);
        orderIdFilter.sendKeys(Keys.ENTER);
        sleep(1000);
    }

    public void clickDownloadButton()
    {
        downloadButton = xpathSetter("//div/a[contains(text(),'Download')]");
        myActions.action_click(downloadButton);
    }

    public void clickRefreshButton()
    {
        refreshButton = xpathSetter("//button[contains(text(),'Refresh')]");
        myActions.action_click(refreshButton);
    }

    public void clickResetFiltersButton()
    {
        resetFiltersButton = xpathSetter("//button[contains(text(),'Reset Filters')]");
        myActions.action_click(resetFiltersButton);
    }

    public String getParcelIdValue(int index)
    {
        parcelIdValue = xpathSetter("//tbody/tr[" + index + "]//div[contains(text(),'Parcel Id')]/a");
        String value = myActions.action_getText(parcelIdValue);
        return value;
    }

    public String getInvoiceIdValue(int index)
    {
        invoiceIdValue = xpathSetter("//tbody/tr[" + index + "]//div[contains(text(),'Invoice')]");
        String value = myActions.action_getText(invoiceIdValue);
        return value.substring(9);
    }

    public String getAreaValue(int index)
    {
        areaValue = xpathSetter("//div[text()='Area: ']/b");
        return myActions.action_getText(areaValue);
    }
}
