package pageObejcts;

import com.sun.webkit.BackForwardList;
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



public class DashBoardPageObjects {



    private AndroidDriver<WebElement> androidDriver;
    private StoreWapActions storeWapActions;


    @FindBy(xpath = "//div[text()='My Orders']")
    private WebElement myOrdersButton;

    @FindBy(xpath = "//div[text()='Delivery']")
    private WebElement deliveryButton;

    @FindBy(xpath = "//div[text()='Payments']")
    private WebElement paymentsButton;

    @FindBy(xpath = "//div[text()='Customer List']")
    private WebElement customerListButton;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-1fn3lry r-qklmqi r-eqz5dr r-1777fci r-5njf8e'][1]//div[@class='css-901oao r-14iuakf r-1fap712 r-1b43r93 r-vw2c0b']")
    private WebElement getIncome;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-1fn3lry r-qklmqi r-eqz5dr r-1777fci r-5njf8e'][2]//div[@class='css-901oao r-14iuakf r-1fap712 r-1b43r93 r-vw2c0b']")
    private WebElement getSales;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-eqz5dr r-1777fci r-5njf8e']//div[@class='css-901oao r-14iuakf r-1fap712 r-1b43r93 r-vw2c0b']")
    private WebElement getOrders;

    @FindBy(xpath = "//option[text()='Today']")
    private WebElement todayButtonInReport;

    @FindBy(xpath = "//option[text()='Last 7 Days']")
    private WebElement last7DaysButtonInReport;

    @FindBy(xpath = "//option[text()='Last 30 Days']")
    private WebElement last30DaysButtonInReport;

    @FindBy(xpath= "//div[contains(@data-testid,'headerTitle')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-14lw9ot r-1m93428 r-qklmqi r-13awgt0 r-18u37iz r-ymttw5 r-c2syf2']/div[2]/div/div[2]")
    private WebElement sideNavButton;

    public DashBoardPageObjects(AndroidDriver<WebElement> androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements((androidDriver), this);
        storeWapActions = new StoreWapActions();
    }


    /*-----------------------------------------------Actions--------------------------------------------------------- */


    public void clickMyOrdersButton(){ storeWapActions.action_click(myOrdersButton);}

    public void clickDeliveryButton(){ storeWapActions.action_click(deliveryButton);}

    public void clickPaymentsButton(){ storeWapActions.action_click(paymentsButton);}

    public void clickCustomersList(){ storeWapActions.action_click(customerListButton);}

    public void clickTodayReport(){ storeWapActions.action_click(todayButtonInReport);}

    public void clickLast7DaysInReport(){ storeWapActions.action_click(last7DaysButtonInReport);}

    public void clickLAt30DaysInReport(){ storeWapActions.action_click(last30DaysButtonInReport);}

    public void clickSideNavButton(){ storeWapActions.action_click(sideNavButton);}


    /*----------------------------------------------Functions-------------------------------------------------------- */


    public String totalIncome(){
        String income = storeWapActions.action_getText(getIncome);
        return income;
    }

    public String totalSales(){
        String sales = storeWapActions.action_getText(getSales);
        return sales;
    }

    public String totalOrders(){
        String orders = storeWapActions.action_getText(getOrders);
        return orders;
    }

    public String getPageTitleText(){
        String pageTitleText = storeWapActions.action_getText(pageTitle);
        return pageTitleText;
    }



}
