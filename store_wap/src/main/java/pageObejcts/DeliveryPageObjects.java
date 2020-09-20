package pageObejcts;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.StoreWapActions;

public class DeliveryPageObjects {

    private AndroidDriver<WebElement> androidDriver;
    private StoreWapActions storeWapActions;


    @FindBy(xpath = "//div[contains(@data-testid,'navback')]")
    private WebElement backButton;

    @FindBy(xpath= "//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][2]//div[contains(@data-testid,'headerTitle')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-12vffkv']//div[@class='css-1dbjc4n r-12vffkv']//div[@class='css-1dbjc4n r-1awozwy r-13awgt0 r-18u37iz r-1wtj0ep']/div[2]")
    private WebElement sideNavButton;

    @FindBy(xpath = "//div[text()='Pending']//parent::div//parent::div//parent::div//parent::div")
    private WebElement delivery_pending;

    @FindBy(xpath = "//div[text()='Sent to Delivery']//parent::div//parent::div//parent::div//parent::div")
    private WebElement delivery_sentToDelivery;

    @FindBy(xpath = "//div[text()='Orders Sent to Delivery']")
    private WebElement totalOrdersSentToDelivery;

    @FindBy(xpath = "//div[text()='Orders Sent to Delivery']//parent::div/div[2]")
    private WebElement filterButtonSentToDelivery;

    @FindBy(xpath = "//div[text()='Apply Filter']")
    private WebElement applyFilterButton;

    @FindBy(xpath = "//div[text()='Filters']//parent::div/div[2]")
    private WebElement cancelFilterButton;

    @FindBy(xpath = "//div[text()='Select orders for Delivery']//parent::div//parent::div//parent::div/div[3]/div/div")
    private WebElement sendOrdersForDeliveryButton;


    public DeliveryPageObjects(AndroidDriver<WebElement> androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements((androidDriver), this);
        storeWapActions = new StoreWapActions();
    }


    /*-----------------------------------------------Actions--------------------------------------------------------- */


    public void clickOnBackButton(){ storeWapActions.action_click(backButton);}

    public void clickOnSideNavButton(){ storeWapActions.action_click(sideNavButton);}

    public void clickOnFilterButton(){ storeWapActions.action_click(filterButtonSentToDelivery);}

    public void clickOnApplyFilterButton(){ storeWapActions.action_click(applyFilterButton);}

    public void clickOnCancelFilterButton(){ storeWapActions.action_click(cancelFilterButton);}

    public void clickOnSendOrdersForDelivery(){ storeWapActions.action_click(sendOrdersForDeliveryButton);}


    /*-----------------------------------------------Functions--------------------------------------------------------*/


    public String getPageTitle(){
        return storeWapActions.action_getText(pageTitle);
    }

    public String getOrdersSentToDelivery(){
        return storeWapActions.action_getText(totalOrdersSentToDelivery);
    }

    public String getOrderDetailsOrderID(int orderIndex){
        String xpath = "//div[text()='Orders Sent to Delivery']//parent::div//parent::div//parent::div/div[2]/div/div/div["+orderIndex+"]/div/div/div/div/div/div";
        WebElement orderIDElement = androidDriver.findElement(By.xpath(xpath));
        String orderID = storeWapActions.action_getText(orderIDElement);
        return orderID;
    }

    public String getOrderDetailsCustomerName(int orderIndex){
        String xpath = "//div[text()='Orders Sent to Delivery']//parent::div//parent::div//parent::div/div[2]/div/div/div["+orderIndex+"]/div/div/div/div/div/div[2]";
        WebElement customerNameElement = androidDriver.findElement(By.xpath(xpath));
        String customerName = storeWapActions.action_getText(customerNameElement);
        return customerName;
    }

    public String getOrderDetailsOrderDate(int orderIndex){
        String xpath = "//div[text()='Orders Sent to Delivery']//parent::div//parent::div//parent::div/div[2]/div/div/div["+orderIndex+"]/div/div/div/div[2]/div/div/div";
        WebElement orderDateElement = androidDriver.findElement(By.xpath(xpath));
        String orderDate = storeWapActions.action_getText(orderDateElement);
        return orderDate;
    }

    public String getOrderDetailsOrderStatus(int orderIndex){
        String xpath = "//div[text()='Orders Sent to Delivery']//parent::div//parent::div//parent::div/div[2]/div/div/div["+orderIndex+"]/div/div/div/div[2]/div/div[2]/div";
        WebElement orderStatusElement = androidDriver.findElement(By.xpath(xpath));
        String orderStatus = storeWapActions.action_getText(orderStatusElement);
        return orderStatus;
    }


    //1  -  confirmed ; 2 - in process ; 3 - in transit; 4 - Delivered; 5 - cnacelled
    public void selectFilterConstrains_OrderStatus(int filterIndex){
        String xpath = "//div[text()='Status']//parent::div//parent::div/div[3]/div/div["+filterIndex+"]" ;
        WebElement filterConstrains = androidDriver.findElement(By.xpath(xpath));
        storeWapActions.action_click(filterConstrains);
    }


    public void selectOrderForSendToDelivery(int orderIndex){
        String xpath = "//div[text()='Select orders for Delivery']//parent::div//parent::div//parent::div/div[2]/div/div/div["+orderIndex+"]/div/div/div/div[1]/div";
        WebElement selectOrder = androidDriver.findElement(By.xpath(xpath));
        storeWapActions.action_click(selectOrder);
    }

    public void selectFirstEligibleOrderForSendToDelivery(){
        int i =1;
        while (i >= 1) {
            String incompleteProfileText = storeWapActions.action_getText(androidDriver.findElement(By.xpath("//div[text()='Select orders for Delivery']/parent::div//parent::div//parent::div/div[2]/div/div/div["+i+"]/div/div/div/div[2]/div[2]")));
            if (!incompleteProfileText.equalsIgnoreCase("Incomplete Profile")){
                selectOrderForSendToDelivery(i);
                break;
            }
            else {
                i++;
            }
        }
    }


}
