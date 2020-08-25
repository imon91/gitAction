package pageObejcts;

import coreUtils.CoreConstants;
import dataBase.DataBaseCore;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import utils.StoreWapActions;
import utils.StoreWapBaseClass;
import java.util.List;
import java.util.Random;

import static utils.StoreWapBaseClass.getBaseDriver;



public class MyOrdersPageObjects {



    private AndroidDriver<WebElement> androidDriver;
    private StoreWapActions storeWapActions;


    @FindBy(xpath = "//div[contains(@data-testid,'navback')]")
    private WebElement backButton;

    @FindBy(xpath= "//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][2]//div[contains(@data-testid,'headerTitle')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-12vffkv']//div[@class='css-1dbjc4n r-12vffkv']//div[@class='css-1dbjc4n r-1awozwy r-13awgt0 r-18u37iz r-1wtj0ep']/div[2]")
    private WebElement sideNavButton;

    @FindBy(xpath = "//div[@class='css-901oao r-14iuakf r-1fap712 r-ubezar r-vw2c0b']")
    private WebElement totalOrders;

    @FindBy(xpath = "//div[contains(@role,'button')]//div[@class='css-1dbjc4n r-6dt33c']")
    private WebElement filtersButton;

    @FindBy(xpath = "//div[text()='Create New Order']")
    private WebElement createNewOrderButton;

    @FindBy(xpath = "//div[text()='Apply Filter']")
    private WebElement applyFilterButton;

    public MyOrdersPageObjects(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements((androidDriver), this);
        storeWapActions = new StoreWapActions();
    }


    /*-----------------------------------------------Actions----------------------------------------------------*/


    public void clickBackButton(){ storeWapActions.action_click(backButton);}

    public void clickSideNavButton(){ storeWapActions.action_click(sideNavButton);}

    public void clickFiltersButton(){ storeWapActions.action_click(filtersButton);}

    public void clickCreateNewOrderButton(){ storeWapActions.action_click(createNewOrderButton);}

    public void clickOnApplyFilterButton(){ storeWapActions.action_click(applyFilterButton);}

    public void clickOnOrderStatusTab(int orderIndex){
        String xpath = "//div[@class='css-1dbjc4n']//div[@class='css-1dbjc4n']["+orderIndex+"]//div[@class='css-901oao r-jwli3a r-ubezar r-1jkjb']";;
        WebElement orderStatus = androidDriver.findElement(By.xpath(xpath));
        storeWapActions.action_click(orderStatus);
    }

    public void clickOnAddCustomerInfoButton(int orderIndex){
        String xpath = "//div[@class='css-1dbjc4n']//div[@class='css-1dbjc4n']["+orderIndex+"]//div[text()='Add Customer Info']";
        WebElement addCustomerInfoButton = androidDriver.findElement(By.xpath(xpath));
        storeWapActions.action_click(addCustomerInfoButton);
    }


    /*----------------------------------------------Functions----------------------------------------------------*/


    public String getTotalOrdersString(){
        String totalOrdersString = storeWapActions.action_getText(totalOrders);
        return totalOrdersString;
    }

    public String getPageTitleText(){
        String pageTitleText = storeWapActions.action_getText(pageTitle);
        return pageTitleText;
    }

    public void clickRandomOrder(int x){
        String xpath = "//div[@class='css-1dbjc4n']//div[@class='css-1dbjc4n']["+"]//div[@class='css-1dbjc4n r-13awgt0 r-eqz5dr']";
        storeWapActions.action_click(androidDriver.findElement(By.xpath(xpath)));
    }

    public String getOrderDetailsOrderID(int orderIndex){
        String xpath = "//div[@class='css-1dbjc4n']//div[@class='css-1dbjc4n']["+orderIndex+"]//div[text()='ID: ']/following-sibling::div";
        String orderID = storeWapActions.action_getText(androidDriver.findElement(By.xpath(xpath)));
        return orderID;
    }

    public String getOrderDetailsOrderDate(int orderIndex){
        String xpath = "//div[@class='css-1dbjc4n']//div[@class='css-1dbjc4n']["+orderIndex+"]//div[@class='css-901oao r-12g4ri r-pz5f6p r-1b43r93 r-1ff274t']";
        String orderDate = storeWapActions.action_getText(androidDriver.findElement(By.xpath(xpath)));
        return orderDate;
    }

    public String getOrderDetailsCustomerName(int orderIndex){
        String xpath = "//div[@class='css-1dbjc4n']//div[@class='css-1dbjc4n']["+orderIndex+"]//div[@class='css-901oao r-14iuakf r-pz5f6p r-1b43r93 r-5oul0u r-1ydw1k6']";
        String orderDate = storeWapActions.action_getText(androidDriver.findElement(By.xpath(xpath)));
        return orderDate;
    }

    public String getOrderDetailsDueAmount(int orderIndex){
        String xpath = "//div[@class='css-1dbjc4n']//div[@class='css-1dbjc4n']["+orderIndex+"]//div[@class='css-901oao r-1nt4q7q r-pz5f6p r-1b43r93 r-1ff274t']";
        String dueAmount = storeWapActions.action_getText(androidDriver.findElement(By.xpath(xpath)));
        return dueAmount;
    }

    public String getOrderDetailsTotalAmount(int orderIndex){
        String xpath =  "//div[@class='css-1dbjc4n']//div[@class='css-1dbjc4n']["+orderIndex+"]//div[@class='css-901oao r-14iuakf r-1fap712 r-ubezar r-vw2c0b']";
        String totalAmount = storeWapActions.action_getText(androidDriver.findElement(By.xpath(xpath)));
        return totalAmount;
    }

    public String getOrderDetailsOrderStatus(int orderIndex){
        String xpath =  "//div[@class='css-1dbjc4n']//div[@class='css-1dbjc4n']["+orderIndex+"]//div[@class='css-901oao r-jwli3a r-pz5f6p r-1b43r93 r-1ozqkpa']";
        String orderStatus = storeWapActions.action_getText(androidDriver.findElement(By.xpath(xpath)));
        return orderStatus;
    }

    public String selectAnOrderStatusInOrderStatusTab(int statusIndex){
        String orderStatusNameXpath = "//div[@class='css-1dbjc4n r-1awozwy r-14lw9ot r-z2wwpe r-eqz5dr r-1777fci r-nsbfu8 r-f11aaj']/div["+statusIndex+"]/div";
        WebElement statusName = androidDriver.findElement(By.xpath(orderStatusNameXpath));
        String name = storeWapActions.action_getText(statusName);
        String xpath = "//div[@class='css-1dbjc4n r-1awozwy r-14lw9ot r-z2wwpe r-eqz5dr r-1777fci r-nsbfu8 r-f11aaj']/div["+statusIndex+"]" ;
        WebElement orderStatus = androidDriver.findElement(By.xpath(xpath));
        storeWapActions.action_click(orderStatus);
        return name;
    }

    public String getSuccessfulOrderStatusUpdateMessage(){
        try {
            WebDriverWait wait = new WebDriverWait(getBaseDriver(), 30);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='css-901oao r-75nptz r-pz5f6p r-1b43r93 r-5njf8e']"))).getText();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public String selectOrderStatusInFiltersTab(int statusIndex){
        String orderStatusNameXpath = "//div[@class='css-1dbjc4n r-18u37iz r-1w6e6rj r-zd98yo r-1ydw1k6 r-knv0ih']/div["+statusIndex+"]/div";
        WebElement statusName = androidDriver.findElement(By.xpath(orderStatusNameXpath));
        String name = storeWapActions.action_getText(statusName);
        String xpath = "//div[@class='css-1dbjc4n r-18u37iz r-1w6e6rj r-zd98yo r-1ydw1k6 r-knv0ih']/div["+statusIndex+"]" ;
        WebElement orderStatus = androidDriver.findElement(By.xpath(xpath));
        storeWapActions.action_click(orderStatus);
        return name;
    }



}
