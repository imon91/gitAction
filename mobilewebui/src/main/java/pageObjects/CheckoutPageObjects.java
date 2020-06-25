package pageObjects;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

import static utils.WebAppBaseClass.sleep;

public class CheckoutPageObjects {
    private AndroidDriver<WebElement> driver;
    private MyActions myActions;
    TouchAction touch;

    public CheckoutPageObjects(AndroidDriver<WebElement> androidDriver) {
        this.driver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        myActions = new MyActions();
        touch = new TouchAction(driver);
    }


    //sizeOptions
    @FindBy(xpath = "//div/span[contains(text(),'option')]")
    private WebElement SizeOptionsButton;

    //increaseQuantity
    @FindBy(xpath = "//input[@value='+']")
    private WebElement IncreaseQuantityButton;

    //decreaseQuantity
    @FindBy(xpath = "//input[@value='-']")
    private WebElement DecreaseQuantityButton;

    //changeOfCustomPrice
    @FindBy(xpath = "//input[@name='custom_price']")
    private WebElement ChangeOfCustomPriceValue;

    //delivery_charge
    @FindBy(xpath = "//input[@name='delivery_charge']")
    private WebElement Delivery_Charge;

    //savedelivery_charge
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    private WebElement SaveDelivery_Charge;

    //couponApply
    @FindBy(xpath = "//a[contains(text(),'Apply Now')]")
    private WebElement CouponApplyButton;

    //Continue Shopping
    @FindBy(xpath = "//span[contains(text(),'Continue Shopping')]")
    private WebElement ContinueShoppingButton;

    //Place Order
    @FindBy(xpath = "//div[@class='proceed-checkout text-center place-order']")
    private WebElement PlaceOrderButton;



/*-----------Actions------------*/


    public void clickOnSizeOptions(){myActions.action_click(SizeOptionsButton);};

    public void clickOnIncreaseQuantity(){myActions.action_click(IncreaseQuantityButton);};

    public void clickOnDecreaseQuantity(){myActions.action_click(DecreaseQuantityButton);};

    public void EnterChangeofCustomPrice(String price){myActions.action_sendKeys(ChangeOfCustomPriceValue,price);};

    public void EnterDeliveryCharge(String Delivery){myActions.action_sendKeys(Delivery_Charge,Delivery);};

    public void clickOnSaveDeliveryCharge(){myActions.action_click(SaveDelivery_Charge);};

    public void clickOnCouponApply(){myActions.action_click(CouponApplyButton);};

    public void clickOnContinueShopping(){myActions.action_click(ContinueShoppingButton);};

    public void clickOnPlaceOrder(){myActions.action_click(PlaceOrderButton);};



/*-------Functions---------*/

 public void confirmingOrder(){
     clickOnIncreaseQuantity();
     sleep(2000);
     clickOnIncreaseQuantity();
     sleep(2000);
     clickOnDecreaseQuantity();
     sleep(2000);
     EnterChangeofCustomPrice("500");
     EnterDeliveryCharge("60");
     sleep(2000);
     clickOnSaveDeliveryCharge();
     sleep(2000);
     touch.press(PointOption.point(0,400)).waitAction().moveTo(PointOption.point(0,200)).release().perform();
     clickOnPlaceOrder();
 }



 /*-------dynamicfunctions-----------*/



}



