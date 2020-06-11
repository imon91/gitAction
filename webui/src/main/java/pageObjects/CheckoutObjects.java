package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

public class CheckoutObjects {
    private WebDriver driver;
    private MyActions myActions;

    public CheckoutObjects(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements( (driver), this);
        myActions = new MyActions();

    }

    //Place Order button
    @FindBy(xpath = "//button[text()='PLACE ORDER']")
    private WebElement placeOrderButton;

    //Quantity + button
    @FindBy(xpath = "//input[@value='+']")
    private WebElement quantityPlus;

    //Quantity - button
    @FindBy(xpath = "//input[@value='-']")
    private WebElement quantityMinus;

    //Custom Price Entry
    @FindBy(xpath = "//input[@name='custom_price']")
    private WebElement customPriceEntry;

    //Custom Price Save Button
    @FindBy(xpath = "//button[@data-reactid='.1jl2mcsy89u.1.3.0.1.0.1:$1.0.1.$cart_item_0.0.1.0.1.1.1.1']")
    private WebElement customPriceSaveButton;

    //Delivery Charge
    @FindBy(xpath = "//input[@id='deliveryCharge']")
    private WebElement deliveryChargeEntry;

    //Delivery Charge Save Button
    @FindBy(xpath = "//button[@data-reactid='.1jl2mcsy89u.1.3.0.1.1.1.0.0.2.2']")
    private WebElement deliveryChargeSaveButton;

    //Continue Shopping
    @FindBy(xpath = "//span[text()='CONTINUE SHOPPING']")
    private WebElement continueShopping;

    /*--------------Actions-------------------*/

    private void clickQuantityPlus(){
        myActions.action_click(quantityPlus);
    }

    private void clickQuantityMinus(){
        myActions.action_click(quantityMinus);
    }

    private void enterCustomPrice(String customPrice){ myActions.action_sendKeys(customPriceEntry,customPrice); }

    private void saveCustomPrice(){ myActions.action_click(customPriceSaveButton);}

    private void enterDeliveryCharge(String deliveryCharge){ myActions.action_sendKeys(deliveryChargeEntry,deliveryCharge); }

    private void saveDeliveryCharge(){ myActions.action_click(deliveryChargeSaveButton);}

    private void clickContinueShopping(){ myActions.action_click(continueShopping);}

    private void clickPlaceOrder(){ myActions.action_click(placeOrderButton);}
}
