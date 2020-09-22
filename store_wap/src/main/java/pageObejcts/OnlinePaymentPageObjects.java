package pageObejcts;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.StoreWapActions;
import utils.StoreWapBaseClass;

public class OnlinePaymentPageObjects extends StoreWapBaseClass {


    private AndroidDriver<WebElement> androidDriver;
    private StoreWapActions storeWapActions;

    @FindBy(xpath = "//div[@class='adjustmentContainer___352h3']/div[5]/span[2]/span[3]")
    private WebElement requestedAmount;

    @FindBy(xpath = "//button[text()='Pay Now']")
    private WebElement payNowButton;

    @FindBy(xpath = "//button[text()='PAY NOW']")
    private WebElement payNowButton_PortWallet;

    @FindBy(xpath = "//div[@class='input-groups onchange-control']/div[1]/input")
    private WebElement cardNumberField;

    @FindBy(xpath = "//div[@class='input-groups onchange-control']/div[2]/div[1]/input")
    private WebElement expiryDateField;

    @FindBy(xpath = "//div[@class='input-groups onchange-control']/div[2]/div[2]/input")
    private WebElement cvvField;

    @FindBy(xpath = "//div[@class='input-groups onchange-control']/div[2]/div[4]/input")
    private WebElement customerNameField;

    @FindBy(xpath = "//input[@class='submit']")
    private WebElement submitButton;

    public OnlinePaymentPageObjects(AndroidDriver<WebElement> androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements((androidDriver), this);
        storeWapActions = new StoreWapActions();
    }

    /*-----------------------------Actions-----------------------------------*/

    public String requestedAmount(){return storeWapActions.action_getText(requestedAmount);}

    public void clickPayNowButton(){ storeWapActions.action_click(payNowButton);}

    public void clickPayNowButtonPortWallet(){ storeWapActions.action_click(payNowButton_PortWallet);}

    public void enterCardNumber(String number){ storeWapActions.action_sendKeys(cardNumberField,number);}

    public void enterExpiryDate(String date){ storeWapActions.action_sendKeys(expiryDateField, date);}

    public void entercvv(String cvv){ storeWapActions.action_sendKeys(cvvField,cvv);}

    public void enterCustomerName(String name){ storeWapActions.action_sendKeys(customerNameField,name);}

    public void clickSubmitButton(){ storeWapActions.action_click(submitButton);}

    /*------------------------------Functions---------------------------------*/

    //1-VISA card, 2-Mastercard
    public void selectCardType(int cardIndex){
        String cardType = "//form[@class='new new-cardarea simple-submit']/ul/li["+cardIndex+"]/span";
        storeWapActions.action_click(androidDriver.findElement(By.xpath(cardType)));
    }

    public void payWithVisaCard(){
        selectCardType(1);
        clickPayNowButtonPortWallet();
        enterCardNumber("4111111111111111");
        enterExpiryDate("1228");
        entercvv("100");
        enterCustomerName("Siva");
        clickPayNowButtonPortWallet();
        sleep(4000);
        clickSubmitButton();
    }



}
