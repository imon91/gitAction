package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

public class BagPageObjects {


    private WebDriver driver;
    private MyActions myActions;



    public BagPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
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

    //Get text from custom price
    @FindBy(xpath = "//input[@name='custom_price']")
    private WebElement minimumCustomprice;

    //Custom Price Save Button
    @FindBy(xpath = "//div[@class='prize-offer-zone col-sm-6 flex text-right']/div[2]/button")
    private WebElement customPriceSaveButton;

    //Delivery Charge
    @FindBy(xpath = "//input[@id='deliveryCharge']")
    private WebElement deliveryChargeEntry;

    //Delivery Charge Save Button
    @FindBy(xpath = "//div[@class='sub-total border_bottom']/div/button")
    private WebElement deliveryChargeSaveButton;

    //Continue Shopping
    @FindBy(xpath = "//span[text()='CONTINUE SHOPPING']")
    private WebElement continueShopping;

    //coupon button
    @FindBy(xpath = "//a[text()='APPLY NOW']")
    private WebElement couponButton;

    //enter coupon text
    @FindBy(xpath = "//input[@type='text'][@name='coupon_code']")
    private WebElement couponText;

    //coupon apply
    @FindBy(xpath = "//button[text()='APPLY']")
    private WebElement applycoupon;

    //click on product_1  (change ul in xpath to shift second product)
    @FindBy(xpath = "//div[@class='col-sm-8 items-in-cart']/ul[1]/li/ul/li/div/div[2]/div/p/a")
    private WebElement product1;

    //click on product_2
    @FindBy(xpath = "//div[@class='col-sm-8 items-in-cart']/ul[2]/li/div")
      private WebElement product2;



    /*--------------Actions-------------------*/

    public void clickQuantityPlus() {
        myActions.action_click(quantityPlus);
    }

    public void clickQuantityMinus() {
        myActions.action_click(quantityMinus);
    }

    public void enterCustomPrice(String customprice) {
        myActions.action_sendKeys(customPriceEntry,customprice);
    }


    public void saveCustomPrice() {
        myActions.action_click(customPriceSaveButton);
    }

    public void enterDeliveryCharge(String deliveryCharge) {
        myActions.action_sendKeys(deliveryChargeEntry, deliveryCharge);
    }

    public void saveDeliveryCharge() {
        myActions.action_click(deliveryChargeSaveButton);
    }

    public void clickOnCouponButton() {
        myActions.action_click(couponButton);
    }

    public void enterCouponText(String coupon) {
        myActions.action_sendKeys(couponText,coupon);
    }

    public void clickOnApplyCoupon() { myActions.action_click(applycoupon);
    }

    public void clickContinueShopping() {
        myActions.action_click(continueShopping);
    }

    public void clickOnPlaceOrder() {
        myActions.action_click(placeOrderButton);
    }

    public void clickProduct1() {
        myActions.action_click(product1); }




    /*------Function-------*/

    public void enterQuantity(int qunatity) throws InterruptedException {
        int i;
        for (i = 1; i <= qunatity; i++) {
            clickQuantityPlus();
        Thread.sleep(500);} }


}
