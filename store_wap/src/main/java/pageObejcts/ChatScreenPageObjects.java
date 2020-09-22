package pageObejcts;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.StoreWapActions;

public class ChatScreenPageObjects {


    private AndroidDriver<WebElement> androidDriver;
    private StoreWapActions storeWapActions;


    @FindBy(xpath = "//div[2]/div[2]/div[2]/div/div/div/div[2]/div/div/div[3]/div/div[1]/div/div/div")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[2]/div[2]/div[2]/div/div/div/div[2]/div/div/div[1]")
    private WebElement backButton;

    @FindBy(xpath = "//div[2]/div[2]/div[2]/div/div/div/div[2]/div/div/div[3]/div/div[2]")
    private WebElement navButton;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-170w6zn r-18u37iz r-u8s1d r-3mc0re r-10ahfku']")
    private WebElement closeButton;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-14lw9ot r-jft4b4 r-5kkj8d r-18u37iz r-edyy15']/div[1]")
    private WebElement bottomPanelIcon;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-mqqhkj r-18u37iz r-1wtj0ep r-1ygmrgt']/div[1]/div[1]")
    private WebElement shareProductsIcon;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-mqqhkj r-18u37iz r-1wtj0ep r-1ygmrgt']/div[2]/div[1]")
    private WebElement createOrderIcon;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-mqqhkj r-18u37iz r-1wtj0ep r-1ygmrgt']/div[3]/div[1]")
    private WebElement recordPaymentsIcon;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-mqqhkj r-18u37iz r-1wtj0ep r-1ygmrgt']/div[4]/div[1]")
    private WebElement trackOrderIcon;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-14lw9ot r-jft4b4 r-5kkj8d r-18u37iz r-edyy15']/div[2]//input")
    private WebElement messageInputBox;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-14lw9ot r-jft4b4 r-5kkj8d r-18u37iz r-edyy15']/div[2]/div")
    private WebElement messageSendButton;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-jft4b4 r-5kkj8d r-18u37iz r-1wtj0ep r-1pn2ns4 r-tskmnb']/div[2]/div")
    private WebElement imageSendButton;

    @FindBy(xpath = "//div[text()='Total sales']//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div/div/div/div/div")
    private WebElement noOfOrders;

    @FindBy(xpath = "//div[text()='Share Tracking Link']")
    private WebElement shareTrackingLinkButton;

    public ChatScreenPageObjects(AndroidDriver<WebElement> androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements((androidDriver), this);
        storeWapActions = new StoreWapActions();
    }

    /*------------------------------------Actions---------------------------------------------------------------------*/

    public void clickOnBackButton(){storeWapActions.action_click(backButton);}

    public void clickOnNavButton(){storeWapActions.action_click(navButton);}

    public void clickOnCloseButton(){storeWapActions.action_click(closeButton);}

    public void clickOnBottomPanelIcon(){storeWapActions.action_click(bottomPanelIcon);}

    public void clickOnShareProductsIcon(){ storeWapActions.action_click(shareProductsIcon);}

    public void clickOnCreateOrderIcon(){storeWapActions.action_click(createOrderIcon);}

    public void clickOnRecordPaymentsIcon(){storeWapActions.action_click(recordPaymentsIcon);}

    public void clickOnTrackOrderIcon(){storeWapActions.action_click(trackOrderIcon);}

    public void enterMessage(String message){storeWapActions.action_sendKeys(messageInputBox,message);}

    public void clickOnMessageSendButton(){storeWapActions.action_click(messageSendButton);}

    public void clickOnImageSendButton(){storeWapActions.action_click(imageSendButton);}

    public void clickOnShareTrackingLinkButton(){ storeWapActions.action_click(shareTrackingLinkButton);}

    /*-----------------------------------Functions--------------------------------------------------------------------*/

    public String getCustomerName(){ return storeWapActions.action_getText(pageTitle);}

    public void sendMessage(String message){
        enterMessage(message);
        clickOnMessageSendButton();
    }

    public void shareImage(int row, int column){
        clickOnBottomPanelIcon();
        clickOnShareProductsIcon();
        String xpath = "//div[@class='css-1dbjc4n r-150rngu r-eqz5dr r-16y2uox r-1wbh5a2 r-11yh6sk r-1rnoaur r-ymttw5 r-1sncvnh']/div/div["+row+"]/div/div["+column+"]";
        WebElement imageElement = androidDriver.findElement(By.xpath(xpath));
        storeWapActions.action_click(imageElement);
        clickOnImageSendButton();
    }

    public void selectOrderForPayments(){
        int total = Integer.parseInt(storeWapActions.action_getText(noOfOrders).replace("You have ", "").replace(" Orders",""));
        int i = 1;
        while (i<total){
            String paymentStatusXpath = "//div[text()='Total sales']//parent::div//parent::div//parent::div//following-sibling::div["+i+"]/div/div/div/div[3]/div/div[2]/div/div/div/div/div";
            String paymentStatus = storeWapActions.action_getText(androidDriver.findElement(By.xpath(paymentStatusXpath)));
            if (!paymentStatus.equalsIgnoreCase("No Dues")){
                String xpath = "//div[text()='Total sales']//parent::div//parent::div//parent::div//following-sibling::div["+i+"]/div/div/div";
                WebElement orderElement = androidDriver.findElement(By.xpath(xpath));
                storeWapActions.action_click(orderElement);
                break;
            }
            else {
                i++;
            }
        }
    }

    public void selectOrderForTrackOrder(){
        int total = Integer.parseInt(storeWapActions.action_getText(noOfOrders).replace("You have ", "").replace(" Orders",""));
        int i = 1;
        while (i<total){
            String orderStatusXpath = "//div[text()='Total sales']//parent::div//parent::div//parent::div//following-sibling::div["+i+"]/div/div/div/div[5]/div/div/div/div[1]";
            String orderStatus = storeWapActions.action_getText(androidDriver.findElement(By.xpath(orderStatusXpath)));
            if (!orderStatus.equalsIgnoreCase("Order Verification Pending")){
                String xpath = "//div[text()='Total sales']//parent::div//parent::div//parent::div//following-sibling::div["+i+"]/div/div/div";
                WebElement orderElement = androidDriver.findElement(By.xpath(xpath));
                storeWapActions.action_click(orderElement);
                break;
            }
            else {
                i++;
            }
        }
    }


}
