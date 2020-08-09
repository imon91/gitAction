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



public class OrderConfirmationPageObjects {



    private AndroidDriver<WebElement> androidDriver;
    private StoreWapActions storeWapActions;


    @FindBy(xpath = "//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][4]//div[contains(@data-testid,'navback')]")
    private WebElement backButton;

    @FindBy(xpath= "//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][4]//div[contains(@data-testid,'headerTitle')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][4]//div[@class='css-1dbjc4n r-1awozwy r-13awgt0 r-18u37iz r-1wtj0ep']/div[2]")
    private WebElement sideNavButton;

    @FindBy(xpath = "//div[@class='css-901oao r-jwli3a r-pz5f6p r-ubezar']")
    private WebElement orderIDxpath;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][4]//div[text()='Create New Order']")
    private WebElement createNewOrderButton;

    @FindBy(xpath = "//div[text()='View My Order']")
    private WebElement viewMyOrderButton;

    @FindBy(xpath = "//div[text()='Enter Customer Details']")
    private WebElement enterCustomerDetailsButton;

    @FindBy(xpath = "//div[text()='Send to Delivery']")
    private WebElement sendToDeliveryButton;

    @FindBy(xpath = "//div[text()='Record Payments']")
    private WebElement recordPaymentsButton;

    public OrderConfirmationPageObjects(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements((androidDriver), this);
        storeWapActions = new StoreWapActions();
    }


    /*------------------------------------------Actions---------------------------------------------*/


    public void clickBackButton(){ storeWapActions.action_click(backButton);}

    public void clickSideNavButton(){ storeWapActions.action_click(sideNavButton);}

    public void clickCreateNewOrderButton(){ storeWapActions.action_click(createNewOrderButton);}

    public void clickViewMyOrderButton(){ storeWapActions.action_click(viewMyOrderButton);}

    public void clickEnterCustomerDetailsButton(){ storeWapActions.action_click(enterCustomerDetailsButton);}

    public void clickSendToDeliveryButton(){ storeWapActions.action_click(sendToDeliveryButton);}

    public void clickRecordPaymentsButton(){ storeWapActions.action_click(recordPaymentsButton);}


    /*------------------------------------------Functions---------------------------------------------*/


    public String getOrderID(){
        String orderID = storeWapActions.action_getText(orderIDxpath);
        return orderID;
    }

    public String getPageTitleText(){
        String pageTitleText = storeWapActions.action_getText(pageTitle);
        return pageTitleText;
    }



}
