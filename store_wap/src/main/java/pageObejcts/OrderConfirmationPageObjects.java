package pageObejcts;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.testng.Assert;
import utils.StoreWapActions;



public class OrderConfirmationPageObjects {



    private AndroidDriver<WebElement> androidDriver;
    private StoreWapActions storeWapActions;


    @FindBy(xpath = "//div[text()='Order Confirmation']//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div/div[1]")
    private WebElement backButton;

    @FindBy(xpath= "//div[contains(text(),'Successfully Created')]//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//div[@class='css-901oao r-14iuakf r-pz5f6p r-ubezar r-1jkjb']")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[text()='Order Confirmation']//parent::div//parent::div//parent::div//following-sibling::div")
    private WebElement sideNavButton;

    @FindBy(xpath = "//div[text()='Successfully Created']//following-sibling::div")
    private WebElement orderIDxpath;

    @FindBy(xpath = "//div[text()='Successfully Created']//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//div[text()='Create New Order']")
    private WebElement createNewOrderButton;

    @FindBy(xpath = "//div[text()='View My Order']")
    private WebElement viewMyOrderButton;

    @FindBy(xpath = "//div[text()='Enter Customer Details']")
    private WebElement enterCustomerDetailsButton;

    @FindBy(xpath = "//div[text()='Send to Delivery']")
    private WebElement sendToDeliveryButton;

    @FindBy(xpath = "//div[text()='Record Payments']")
    private WebElement recordPaymentsButton;

    @FindBy(xpath = "//div[text()='Go Back to Chat']")
    private WebElement goBackToChatButton;

    public OrderConfirmationPageObjects(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements((androidDriver), this);
        storeWapActions = new StoreWapActions();
    }


    /*------------------------------------------Actions---------------------------------------------*/


    public void clickBackButton(){ storeWapActions.action_click(backButton);}

    public void clickSideNavButton(){ storeWapActions.action_click(sideNavButton);}

    public void clickCreateNewOrderButton(){ storeWapActions.action_click(createNewOrderButton);}

    public void clickViewMyOrderButton(){
        try{
            storeWapActions.action_click(viewMyOrderButton);
            Assert.assertEquals(storeWapActions.action_getText(androidDriver.findElement(By.xpath("//div[text()='Order ID']//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//div[@data-testid='headerTitle']"))),"Order Details");
        } catch (NoSuchElementException e){
            clickViewMyOrderButton();
        }
    }

    public void clickEnterCustomerDetailsButton(){ storeWapActions.action_click(enterCustomerDetailsButton);}

    public void clickSendToDeliveryButton(){ storeWapActions.action_click(sendToDeliveryButton);}

    public void clickRecordPaymentsButton(){ storeWapActions.action_click(recordPaymentsButton);}

    public void clickOnGoBackToChatButton(){storeWapActions.action_click(goBackToChatButton);}


    /*------------------------------------------Functions---------------------------------------------*/


    public String getOrderID(){
        return storeWapActions.action_getText(orderIDxpath);
    }

    public String getPageTitleText(){
        return storeWapActions.action_getText(pageTitle);
    }



}
