package pageObejcts;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import utils.StoreWapActions;

import java.util.Random;

public class RecordPaymentsPageObjects {


    private AndroidDriver<WebElement> androidDriver;
    private StoreWapActions storeWapActions;


    @FindBy(xpath = "//div[text()='Order ID']//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div/div[@data-testid='navback']")
    private WebElement backButton;

    @FindBy(xpath = "//div[text()='Order ID']//parent::div//parent::div//parent::div//parent::div//div[@class='css-1dbjc4n r-1loqt21 r-1otgn73 r-eafdt9 r-1i6wzkk r-lrvibr']")
    private WebElement sideNavButton;

    @FindBy(xpath = "//div[text()='Order ID']//parent::div/div[@class='css-901oao r-14iuakf r-pz5f6p r-ubezar r-1jkjb']")
    private WebElement pageTitleText;

    @FindBy(xpath = "//div[text()='Order ID']")
    private WebElement orderIDText;

    @FindBy(xpath = "//div[text()='Due']//parent::div/div[3]/div")
    private WebElement dueAmountText;

    @FindBy(xpath = "//div[text()='+ Add']//parent::Div//parent::Div//input")
    private WebElement payAmountTabText;

    @FindBy(xpath = "//div[text()='+ Add']")
    private WebElement addButton;

    @FindBy(xpath = "//div[text()='No payments received yet.']")
    private WebElement noPaymentsReceivedText1;

    @FindBy(xpath = "//div[text()='No payments received yet.']//following-sibling::div")
    private WebElement noPaymentsReceivedText2;

    @FindBy(xpath = "//div[text()='Debit & Credit Card/Mobile Banking']//parent::div//parent::div/div[@class='css-1dbjc4n r-eqz5dr r-1777fci r-1jkjb']/div")
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

    @FindBy(xpath = "//div[text()='Copy']")
    private WebElement copyButton;

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
        return storeWapActions.action_getText(pageTitleText);
    }

    public String getOrderID(){
        return storeWapActions.action_getText(orderIDText);
    }

    public String getDueAmount(){
        return storeWapActions.action_getText(dueAmountText);
    }

    public void editPayingAmount(String amount){
        new Actions(androidDriver).click(payAmountTabText).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(amount).perform();
    }

    public String getNoPaymentMadeTextDisplayed(){
        String text1= storeWapActions.action_getText(noPaymentsReceivedText1);
        String text2= storeWapActions.action_getText(noPaymentsReceivedText2);
        return text1+""+text2;
    }

    public String copyPaymentLink(int linkIndex){
        if (linkIndex == 0) {
            int totalLinksPresent = androidDriver.findElements(By.xpath("//div[text()='Copy']")).size();
            Random random = new Random();
            linkIndex = random.nextInt(totalLinksPresent)+1;
        } linkIndex += 3;
        WebElement copyElement = androidDriver.findElement(By.xpath("//div[text()='Payment Links']//parent::div//parent::div//parent::div/div["+linkIndex+"]/div/div/div[2]/div"));
        return storeWapActions.action_getText(copyElement);
    }

    public String getTotalPaymentsMade(){
        return storeWapActions.action_getText(paymentsReceived_AmountText);
    }

    public String getFullyPaidText(){
        return storeWapActions.action_getText(fullyPaidText);
    }

}
