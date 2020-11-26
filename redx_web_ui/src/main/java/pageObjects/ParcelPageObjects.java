package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.*;
import java.util.*;

public class ParcelPageObjects extends RedXWebBaseClass{

    private WebDriver driver;
    private MyActions myActions;
    private HomePageObjects homePageObjects;

    public ParcelPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
        homePageObjects = new HomePageObjects(driver);
    }

    private WebElement trackingIDText;
    private WebElement shopInvoiceIDText;
    private WebElement phoneNumberText;
    private WebElement dateFromText;
    private WebElement dateToText;
    private WebElement dateFilterDropDownIcon;
    private List<WebElement> dateFilterDropDownOptions;
    private WebElement searchIcon;
    private WebElement statusFilterDropDownIcon;
    private WebElement parcelSelectAllIcon;
    private List<WebElement> parcelSelectIcons;
    private WebElement previousPageIcon;
    private WebElement nextPageIcon;
    private WebElement downloadParcelHistory;


    public void enterTrackingIDText(String trackingID)
    {
        trackingIDText = driver.findElement(By.xpath("//div[@class='search_input_row']/input[1]"));
        myActions.action_sendKeys(trackingIDText,trackingID);
    }

    public void enterShopInvoiceIDText(String shopInvoice)
    {
        shopInvoiceIDText = driver.findElement(By.xpath("//div[@class='search_input_row']/input[2]"));
        myActions.action_sendKeys(shopInvoiceIDText,shopInvoice);
    }

    public void enterPhoneNumberText(String phoneNumber)
    {
        phoneNumberText = driver.findElement(By.xpath("//div[@class='search_input_row']/input[3]"));
        myActions.action_sendKeys(phoneNumberText,phoneNumber);
    }

    public void clickFromDate(String year,String month,String date)
    {
        dateFromText = driver.findElement(By.xpath("//div[@class='search_input_row']/span[1]"));
        myActions.action_click(dateFromText);

    }

    public void clickToDate(String year,String month,String date)
    {
        dateToText = driver.findElement(By.xpath("//div[@class='search_input_row']/span[2]"));
        myActions.action_click(dateToText);
        WebElement yearIcon = xpathSetter("");
        try{
        myActions.action_click(yearIcon);
        WebElement requiredYear = xpathSetter("");
        myActions.action_click(requiredYear);}
        catch (NullPointerException e){
            WebElement previousButton = xpathSetter("");
            myActions.action_click(previousButton);
        WebElement requiredYear = xpathSetter("");
        myActions.action_click(requiredYear);}



    }

    public void clickOnDateFilter(int FilterIndex)
    {
        dateFilterDropDownIcon = driver.findElement(By.xpath("//div[@class='ant-select-selection__rendered']/div"));
        myActions.action_click(dateFilterDropDownIcon);

        dateFilterDropDownOptions = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
        myActions.action_click(dateFilterDropDownOptions.get(FilterIndex));
    }

    public void clickOnSearchIcon()
    {
        searchIcon = driver.findElement(By.xpath("//div[@class='search_input_row']/button"));
        myActions.action_click(searchIcon);
    }

    public void clickStatusFilterDropDownIcon()
    {
        statusFilterDropDownIcon = driver.findElement(By.xpath("//th[@class='ant-table-column-has-actions ant-table-column-has-filters ant-table-row-cell-break-word']/i/*"));
        myActions.action_click(statusFilterDropDownIcon);
    }

    public void selectAllParcelIcon()
    {
        parcelSelectAllIcon = driver.findElement(By.xpath("//th[@class='ant-table-selection-column']//input"));
        myActions.action_click(parcelSelectAllIcon);
    }

    public void clickOnParcelSelectionIcon(int index)
    {
        parcelSelectIcons = xpathListSetter("//tbody[@class='ant-table-tbody']/tr//input");
        myActions.action_click(parcelSelectIcons.get(index));
    }

    public void clickOnPreviousPageIcon()
    {
        previousPageIcon = xpathSetter("//ul[@class='ant-pagination parcel_tbl_pagination ant-table-pagination mini'][1]/li[1]");
        myActions.action_click(previousPageIcon);
    }

    public void clickOnNextPageIcon()
    {
        nextPageIcon = xpathSetter("//ul[@class='ant-pagination parcel_tbl_pagination ant-table-pagination mini'][1]/li[9]");
        myActions.action_click(nextPageIcon);
    }

    public void clickOnDownloadParcelHistory(int index)
    {
        downloadParcelHistory = xpathSetter("//div[@class='css-19f5lyp']/div[2]/button[2]");
        myActions.action_click(downloadParcelHistory);
    }



}
