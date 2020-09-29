package pageObejcts;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import utils.StoreWapActions;

import java.util.Random;
import static utils.StoreWapBaseClass.getBaseDriver;

public class OrderDetailsPageObjects {



    private AndroidDriver<WebElement> androidDriver;
    private StoreWapActions storeWapActions;

    private Random random;


    @FindBy(xpath = "//div[text()='Order ID']//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//div[@data-testid='navback']")
    private WebElement backButton;

    @FindBy(xpath = "//div[text()='Order ID']//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//div[@data-testid='headerTitle']")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[text()='Edit Details']")
    private WebElement editDetailsButton;

    @FindBy(xpath = "//div[text()='My Income Calculations']//parent::div//parent::div//parent::div/div[text()='Total Product Value']//parent::div//following-sibling::div")
    private WebElement totalProductValue;

    @FindBy(xpath = "//div[text()='Edit']")
    private WebElement editTotalCostButton;

    @FindBy(xpath = "//div[text()='Total Cost of Product (s)']//parent::div//parent::div//parent::div//input")
    private WebElement editTotalCostInput;

    @FindBy(xpath = "//div[text()='Total Cost of Product (s)']//parent::div//parent::div//parent::div/div[4]")
    private WebElement saveTotalCostButton;

    @FindBy(xpath = "//div[text()='Order Details']//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//div[text()='Enter Customer Details']")
    private WebElement enterCustomerDetailsButton;

    @FindBy(xpath = "//div[text()='Order Details']//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//div[text()='Send to Delivery']")
    private WebElement sendToDeliveryButton;

    @FindBy(xpath = "//div[text()='Order Details']//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//div[text()='Record Payments']")
    private WebElement recordPaymentsButton;

    public OrderDetailsPageObjects(AndroidDriver<WebElement> androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements((androidDriver), this);
        storeWapActions = new StoreWapActions();
        random = new Random();
    }


    /*-----------------------------------------------Actions--------------------------------------------------------- */


    public void clickBackButton(){ storeWapActions.action_click(backButton);}

    public void clickOnEditDetailsButton(){
        try{
            storeWapActions.action_click(editDetailsButton);
            Assert.assertEquals(storeWapActions.action_getText(androidDriver.findElement(By.xpath("//div[text()='Enter Customer Name']//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//div[@data-testid='headerTitle']"))),"Edit Products");
        }catch (NoSuchElementException e){
            clickOnEditDetailsButton();
        }
    }

    public void clickOnEditTotalCostButton(){
        try{
            storeWapActions.action_click(editTotalCostButton);
            WebDriverWait wait = new WebDriverWait(getBaseDriver(),30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Total Cost of Product (s)']//parent::div//parent::div//parent::div//input")));
        } catch (Exception e){
            clickOnEditTotalCostButton();
        }
    }

    public void clickOnSaveTotalCostButton(){storeWapActions.action_click(saveTotalCostButton);}

    public void enterTotalCost(String cost){
        new Actions(androidDriver).click(editTotalCostInput).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(cost).perform();
    }

    public void clickOnEnterCustomerDetailsButton(){ storeWapActions.action_click(enterCustomerDetailsButton);}

    public void clickOnSendToDeliveryButton(){ storeWapActions.action_click(sendToDeliveryButton);}

    public void clickOnRecordPaymentsButton(){ storeWapActions.action_click(recordPaymentsButton);}

    /*-----------------------------------------------Functions--------------------------------------------------------*/


    public String getPageTitle(){return storeWapActions.action_getText(pageTitle);}

    public int getTotalProductValue(){return Integer.parseInt(editTotalCostInput.getAttribute("value"));}

}
