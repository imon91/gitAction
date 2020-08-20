package pageObejcts;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.StoreWapActions;

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

    @FindBy(xpath = "//div[text()='Income']//parent::div/div/div/div[2]")
    private WebElement getIncome;

    @FindBy(xpath = "//div[text()='Sales']//parent::div/div/div/div[2]")
    private WebElement getSales;

    @FindBy(xpath = "//div[text()='Orders']//parent::div/div/div/div")
    private WebElement getOrders;

    @FindBy(xpath = "//option[text()='Today']")
    private WebElement todayButtonInReport;

    @FindBy(xpath = "//option[text()='Last 7 Days']")
    private WebElement last7DaysButtonInReport;

    @FindBy(xpath = "//option[text()='Last 30 Days']")
    private WebElement last30DaysButtonInReport;

    @FindBy(xpath= "//div[contains(@data-testid,'headerTitle')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[text()='Home']//parent::div//parent::div//parent::div//parent::div/div[2]")
    private WebElement sideNavButton;

    @FindBy(xpath = "//div[text()='Inbox']")
    private WebElement inboxButton;

    @FindBy(xpath = "//div[text()='Boost']")
    private WebElement boostButton;

    public DashBoardPageObjects(AndroidDriver<WebElement> androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements((androidDriver), this);
        storeWapActions = new StoreWapActions();
    }


    /*-----------------------------------------------Actions--------------------------------------------------------- */


    public void clickMyOrdersButton(){ storeWapActions.action_click(myOrdersButton);}

    public void clickDeliveryButton(){ storeWapActions.action_click(deliveryButton);}

    public void clickPaymentsButton(){ storeWapActions.action_click(paymentsButton);}

    public void clickCustomersListButton(){ storeWapActions.action_click(customerListButton);}

    public void clickTodayReport(){ storeWapActions.action_click(todayButtonInReport);}

    public void clickLast7DaysInReport(){ storeWapActions.action_click(last7DaysButtonInReport);}

    public void clickLAt30DaysInReport(){ storeWapActions.action_click(last30DaysButtonInReport);}

    public void clickSideNavButton(){ storeWapActions.action_click(sideNavButton);}

    public void clickInboxButton(){ storeWapActions.action_click(inboxButton);}

    public void clickBoostButton(){ storeWapActions.action_click(boostButton);}


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
