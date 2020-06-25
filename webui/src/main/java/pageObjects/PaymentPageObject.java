package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

public class PaymentPageObject {
    private WebDriver driver;
    private MyActions myActions;

    public PaymentPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
    }

    //Cash on delivery
    @FindBy(xpath = "//a[text()='CASH ON DELIVERY']")
    private WebElement cashOnDeliveryOption;

    //change address
    @FindBy(xpath = "//a[text()='CHANGE ADDRESS']")
    private WebElement changeAddressOption;

    //make payment button
    @FindBy(xpath = "//div[@class='proceed-checkout text-center'][1]/button")
    private WebElement makePaymentButton;

    //delivery charge
    @FindBy(xpath = "//input[@type='number'][@name='delivery_charge']")
    private WebElement deliveryChargeTextBar;

    //save button
    @FindBy(xpath = "//button[text()='SAVE']")
    private WebElement saveButton;

    //apply promocode
    @FindBy(xpath = "//a[text()='APPLY NOW']")
    private WebElement applyNowOption;

    //promocode entry
    @FindBy(xpath = "//input[@type='text'][@name='coupon_code']")
    private WebElement promocodeEntryText;

    //apply button
    @FindBy(xpath = "//button[text()='APPLY']")
    private WebElement applyButton;

    /*------------ORDER NUMBER (ordersuccessful page-------*/

    //unique ordernumber
    @FindBy(xpath = "//div[@class='col-sm-4 succeed_order_number text-center']/p[2]/span[2]")
    private WebElement yourOrderNumber;

    //Start shopping Button
    @FindBy(xpath = "//div[@class='col-sm-4 succeed_order_number text-center']/div/div/div/div[1]/a")
    private WebElement startShoppingButton;



    public void clickOnCashOnDelivery() {
        myActions.action_click(cashOnDeliveryOption);
    }

    public void clickOnChangeAddressOption() {
        myActions.action_click(changeAddressOption);
    }

    public void clickOnMakePaymentButton() {
        myActions.action_click(makePaymentButton);
    }

    public void enterDeliveryCharge(String deliverycharge) {
        myActions.action_sendKeys(deliveryChargeTextBar,deliverycharge);
    }

    public void clickOnSaveButton() {
        myActions.action_click(saveButton);
    }

    public void clickOnApplyPromocode() {
        myActions.action_click(makePaymentButton);
    }

    public void entrePromocodeText() {
        myActions.action_click(promocodeEntryText);
    }

    public void clickOnApplyButton() {
        myActions.action_click(applyButton);
    }

    public void clickOnStartShopping() {
        myActions.action_click(startShoppingButton);}





    /*-----Function------*/

    public String getOrderNumber() {
        String orderNumber = ("ORDER DETAILS: "+ myActions.action_getText(yourOrderNumber));
        return orderNumber;
    }
}
