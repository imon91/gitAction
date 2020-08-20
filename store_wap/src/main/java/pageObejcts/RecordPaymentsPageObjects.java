package pageObejcts;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.StoreWapActions;

public class RecordPaymentsPageObjects {


    private AndroidDriver<WebElement> androidDriver;
    private StoreWapActions storeWapActions;


    @FindBy(xpath = "//div[text()='Order ID']//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div/div")
    private WebElement backButton;

    @FindBy(xpath = "//div[text()='Order ID']//parent::div//parent::div//parent::div//parent::div//div[@class='css-1dbjc4n r-1loqt21 r-1otgn73 r-eafdt9 r-1i6wzkk r-lrvibr']")
    private WebElement sideNavButton;

    @FindBy(xpath = "//div[text()='Order ID']//parent::div/div")
    private WebElement pageTitleText;

    @FindBy(xpath = "//div[text()='Order ID']//parent::div//parent::div//parent::div//parent::div/div[2]")
    private WebElement orderIDText;

    @FindBy(xpath = "//div[text()='Due']//parent::div/div[3]/div")
    private WebElement dueAmountText;

    @FindBy(xpath = "//div[text()='+ Add']//parent::Div//parent::Div/input")
    private WebElement payAmountTabText;

    @FindBy(xpath = "//div[text()='+ Add']")
    private WebElement addButton;

    @FindBy(xpath = "//div[text()='No payments received yet.']")
    private WebElement noPaymentsReceivedText1;

    @FindBy(xpath = "//div[text()='No payments received yet.']//following-sibling::div")
    private WebElement noPaymentsReceivedText2;

    @FindBy(xpath = "//div[text()='Debit & Credit Card/Mobile Bankings']//parent::div//following-sibling::div/div")
    private WebElement debitCardOptionButton;

    @FindBy(xpath = "//div[text()='Received as Cash']//parent::div//following-sibling::div/div")
    private WebElement cashOptionButton;

    @FindBy(xpath = "//div[text()='Confirm']")
    private WebElement confirmButton;

    @FindBy(xpath = "//div[text()='Payments Received']//parent::div/div[2]")
    private WebElement paymentsReceived_AmountText;

    @FindBy(xpath = "//div[text()='How this works?']")
    private WebElement howThisWorksButton;

    @FindBy(xpath = "//div[text()='Fully Paid']")
    private WebElement fullyPaidText;

    //div[text()='Payments Received']//parent::div//parent::div/div[2]/div/div/div/div/div[2]/

    public RecordPaymentsPageObjects(AndroidDriver<WebElement> androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements((androidDriver), this);
        storeWapActions = new StoreWapActions();
    }


    /*-----------------------------------------------Actions--------------------------------------------------------- */


    public void clickBackButton(){ storeWapActions.action_click(backButton);}

    public void clickSideNavButton(){ storeWapActions.action_click(sideNavButton);}

    public void clickAddButton(){ storeWapActions.action_click(addButton);}

    public void clickDebitCardOption(){ storeWapActions.action_click(debitCardOptionButton);}

    public void clickCashOption(){ storeWapActions.action_click(cashOptionButton);}

    public void clickConfirmButton(){ storeWapActions.action_click(confirmButton);}

    public void clickHowThisWorksButton(){ storeWapActions.action_click(howThisWorksButton);}


    /*-----------------------------------------------Functions--------------------------------------------------------*/

    public String getPageTitle(){
        String pageTitle = storeWapActions.action_getText(pageTitleText);
        return pageTitle;
    }

    public String getOrderID(){
        String orderID = storeWapActions.action_getText(orderIDText);
        return orderID;
    }

    public String getDueAmount(){
        String due = storeWapActions.action_getText(dueAmountText);
        return due;
    }

    public void editPayingAmount(String amount){
        new Actions(androidDriver).click(payAmountTabText).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(amount).perform();
    }

    public String getNoPaymentMadeTextDisplayed(){
        String text1= storeWapActions.action_getText(noPaymentsReceivedText1);
        String text2= storeWapActions.action_getText(noPaymentsReceivedText2);
        return text1+""+text2;
    }

    public String getTotalPaymentsMade(){
        String details = storeWapActions.action_getText(paymentsReceived_AmountText);
        return details;
    }

    public String getFullyPaidText(){
        String text = storeWapActions.action_getText(fullyPaidText);
        return text;
    }

}
