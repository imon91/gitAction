package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.*;

import java.util.*;

public class CoverageAreaPageObjects extends RedXWebBaseClass {

    private WebDriver driver;
    private MyActions myActions;
    private Random random;

    public CoverageAreaPageObjects(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        myActions = new MyActions();
        random = new Random();
    }

    /*----------Elements----------*/

    private WebElement zoneTitle;

    private WebElement zoneDropDown;
    private WebElement zoneDropDownOption;
    private WebElement areaInput;

    private WebElement downloadButton;

    private WebElement districtValue;
    private WebElement areaValue;
    private WebElement postCodeValue;
    private WebElement homeDeliveryValue;

    private WebElement lockdownValue;
    private WebElement chargeOneKgValue;
    private WebElement chargeTwoKgValue;
    private WebElement chargeThreeKgValue;
    private WebElement codChargeValue;

    private List<WebElement> paginationElements;
    private WebElement previousPageIcon;
    private WebElement nextPageIcon;
    private WebElement nextFivePageIcon;
    private WebElement pageIcon;
    private WebElement lastPage;
    private WebElement activePage;

    private String[] zones = {"Dhaka City","Dhaka Suburbs","Outside Dhaka"};

    /*----------Actions----------*/

    public String getZoneTitle()
    {
        zoneTitle = xpathSetter("//div[@class='title']/p");
        return myActions.action_getText(zoneTitle);
    }

    public void clickZoneDropDown()
    {
        zoneDropDown = xpathSetter("//div[@class='zone']//span[@class='ant-select-arrow']/i");
        myActions.action_click(zoneDropDown);
    }

    public void chooseDropDownOption(String zone)
    {
        clickZoneDropDown();
        zoneDropDownOption = xpathSetter("//ul[contains(@class,'ant-select-dropdown-menu')]/li[@title='" + zone + "']");
        myActions.action_click(zoneDropDownOption);
    }

    public String chooseDropDownOption()
    {
        int index = random.nextInt(3);
        String zone = zones[index];
        chooseDropDownOption(zone);
        return zone;
    }

    public void enterAreaInput(String area)
    {
        areaInput = xpathSetter("//div[@class='zone']/input");
        myActions.action_sendKeys(areaInput,area);
    }

    public void clearAreaInput()
    {
        areaInput = xpathSetter("//div[@class='zone']/input");
        areaInput.clear();
        myActions.action_sendKeys(areaInput,"");
    }

    public void clickDownloadButton()
    {
        downloadButton = xpathSetter("//div[@class='download']/button");
        myActions.action_click(downloadButton);
    }

    public String getDistrictValue(int index) {
        districtValue = xpathSetter("//tbody/tr[" + index + "]/td[1]/p");
        return myActions.action_getText(districtValue);
    }

    public String getAreaValue(int index) {
        areaValue = xpathSetter("//tbody/tr[" + index + "]/td[2]/p");
        return myActions.action_getText(areaValue);
    }

    public String getPostCodeValue(int index) {
        postCodeValue = xpathSetter("//tbody/tr[" + index + "]/td[3]/p");
        return myActions.action_getText(postCodeValue);
    }

    public String getHomeDeliveryValue(int index) {
        homeDeliveryValue = xpathSetter("//tbody/tr[" + index + "]/td[4]/p");
        return myActions.action_getText(homeDeliveryValue);
    }

    public String getLockdownValue(int index) {
        lockdownValue = xpathSetter("//tbody/tr[" + index + "]/td[5]/p");
        return myActions.action_getText(lockdownValue);
    }

    public String getChargeOneKgValue(int index) {
        chargeOneKgValue = xpathSetter("//tbody/tr[" + index + "]/td[6]/p");
        return myActions.action_getText(chargeOneKgValue);
    }

    public String getChargeTwoKgValue(int index) {
        chargeTwoKgValue = xpathSetter("//tbody/tr[" + index + "]/td[7]/p");
        return myActions.action_getText(chargeTwoKgValue);
    }

    public String getChargeThreeKgValue(int index) {
        chargeThreeKgValue = xpathSetter("//tbody/tr[" + index + "]/td[8]/p");
        return myActions.action_getText(chargeThreeKgValue);
    }

    public String getCodChargeValue(int index) {
        codChargeValue = xpathSetter("//tbody/tr[" + index + "]/td[9]/p");
        String value = myActions.action_getText(codChargeValue);
        return value.substring(0,value.length()-1);
    }

    public void clickPreviousPageIcon()
    {
        previousPageIcon = xpathSetter("//ul[1]/li[@title='Previous Page']");
        myActions.action_click(previousPageIcon);
        waitForLoading();
    }

    public int getActivePage()
    {
        waitForLoading();
        activePage = xpathSetter("//ul[1]/li[contains(@class,'ant-pagination-item-active')]");
        int page = Integer.parseInt(activePage.getAttribute("title"));
        return page;
    }

    public int getLastPage()
    {
        paginationElements = xpathListSetter("//ul[contains(@class,'pagination')]/li[@title]");
        if(paginationElements.size()==9)
            lastPage = xpathSetter("//ul[1]/li[@title][8]");
        else lastPage = xpathSetter("//ul[1]/li[@title][" + (paginationElements.size()-1) + "]");
        return Integer.parseInt(lastPage.getAttribute("title"));
    }

    public void clickPageIcon(int page,int pages)
    {
        System.out.println("Page : " + page);
        int activePage = getActivePage();
        while((page!=1)&&((page>activePage+2)||(page<activePage-2))&&(page!=pages))
        {
            clickNextFivePageIcon();
            activePage = getActivePage();
        }
        pageIcon = xpathSetter("//ul[1]/li[@title='" + page + "']");
        myActions.action_click(pageIcon);
        waitForLoading();
    }

    public int[] clickPageIcon()
    {
        int page[] = new int[2];
        int pages = getLastPage();
        System.out.println("Total Pages : " + pages);
        page[0] = random.nextInt(pages)+1;
        clickPageIcon(page[0],pages);
        page[1] = getActivePage();
        System.out.println("Active Page : " + page[1]);
        clickPageIcon(1,pages);
        return page;
    }

    public void clickNextFivePageIcon()
    {
        nextFivePageIcon = xpathSetter("//ul[1]/li[@title='Next 5 Pages']");
        myActions.action_click(nextFivePageIcon);
        waitForLoading();
    }

    public void clickNextPageIcon()
    {
        nextPageIcon = xpathSetter("//ul[1]/li[@title='Next Page']");
        myActions.action_click(nextPageIcon);
        waitForLoading();
    }

    public void waitForLoading()
    {
        try {
            new WebDriverWait(getBaseDriver(),30)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-spin-nested-loading']/div[@class='ant-spin-container']")));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
