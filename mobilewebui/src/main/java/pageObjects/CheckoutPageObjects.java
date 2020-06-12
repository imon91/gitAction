package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

public class CheckoutPageObjects {
    private AndroidDriver<WebElement> driver;
    private MyActions myActions;

    public CheckoutPageObjects(AndroidDriver<WebElement> androidDriver) {
        this.driver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        myActions = new MyActions();
    }

    //list1object
    @FindBy(xpath = "//button[@class='twoview']")
    private WebElement ListOneButton;

    //list2Object
    @FindBy(xpath = "//button[@class='threeview']")
    private WebElement ListTwoButton;

    //filterTab
    @FindBy(xpath = "//p[contains(text(),'FILTER')]")
    private WebElement FilterTab;

    //sortTab
    @FindBy(xpath = "//p[contains(text(),'SORT')]")
    private WebElement SortTab;

    //filterByCategory
    @FindBy(xpath = "//button[contains(text(),'category')]")
    private WebElement ByCategory;

    //fileterbyprice
    @FindBy(xpath = "//button[contains(text(),'price')]")
    private WebElement ByPrice;

    //filterbydiscount
    @FindBy(xpath = "//button[contains(text(),'discount')]")
    private WebElement ByDiscount;

    //MenShirtsCheckbox
    @FindBy(xpath = "//label[contains(text(),'Men Shirts')]")
    private WebElement MenShirtsCheckbox;

    //MenT_ShirtsCheckbox
    @FindBy(xpath = "//label[contains(text(),'Men T-Shirts')]")
    private WebElement MenT_ShirtsCheckbox;

    //Dress Materials
    @FindBy(xpath = "//label[contains(text(),'Dress Materials')]")
    private WebElement DressMaterialsCheckbox;

    //Men Sweaters & Sweatshirts
    @FindBy(xpath = "//label[contains(text(),'Men Sweaters & Sweatshirts')]")
    private WebElement SweatersCheckbox;

    //T-Shirts
    @FindBy(xpath = "//label[contains(text(),'T-Shirts')]")
    private WebElement T_ShirtsCheckbox;

    //Jackets
    @FindBy(xpath = "//label[contains(text(),'Jackets')]")
    private WebElement JacketsCheckbox;

    //Dresses
    @FindBy(xpath = "//label[contains(text(),'Dresses')]")
    private WebElement DressesCheckbox;

    //Kids T-Shirts
    @FindBy(xpath = "//label[contains(text(),'Kids T-Shirts')]")
    private WebElement KidsT_ShirtsCheckbox;

    //Men Jackets
    @FindBy(xpath = "//label[contains(text(),'Men Jackets')]")
    private WebElement MenJacketsCheckbox;

    //Men Watches
    @FindBy(xpath = "//label[contains(text(),'Men Watches')]")
    private WebElement MenWatchesCheckbox;

    //Below 500 Tk
    @FindBy(xpath = "//label[contains(text(),'Below 500 Tk')]")
    private WebElement Below500TkCheckbox;

    //500 - 1000 Tk
    @FindBy(xpath = "//label[contains(text(),'500 - 1000 Tk')]")
    private WebElement r500_1000TkCheckbox;

    //1000 - 1500 Tk
    @FindBy(xpath = "//label[contains(text(),'1000 - 1500 Tk')]")
    private WebElement r1000_1500TkCheckbox;

    //1500 - 2000 Tk
    @FindBy(xpath = "//label[contains(text(),'1500 - 2000 Tk')]")
    private WebElement r1500_2000TkCheckbox;

    //Above 2000 Tk
    @FindBy(xpath = "//label[contains(text(),'Above 2000 Tk')]")
    private WebElement Above2000TkCheckbox;

    //70+discount
    @FindBy(xpath = "//label[contains(text(),'70% and above')]")
    private WebElement Above70Checkbox;

    //60+discount
    @FindBy(xpath = "//label[contains(text(),'60% and above')]")
    private WebElement Above60Checkbox;

    //50+discount
    @FindBy(xpath = "//label[contains(text(),'50% and above')]")
    private WebElement Above50Checkbox;

    //40+discount
    @FindBy(xpath = "//label[contains(text(),'40% and above')]")
    private WebElement Above40Checkbox;

    //30+discount
    @FindBy(xpath = "//label[contains(text(),'30% and above')]")
    private WebElement Above30Checkbox;

    //20+discount
    @FindBy(xpath = "//label[contains(text(),'20% and above')]")
    private WebElement Above20Checkbox;

    //10+discount
    @FindBy(xpath = "//label[contains(text(),'10% and above')]")
    private WebElement Above10Checkbox;

    //ClearallFilters
    @FindBy(xpath = "//button[contains(text(),'clear all')]")
    private WebElement ClearallFiltersButton;

    //apply
    @FindBy(xpath = "//button[contains(text(),'apply')]")
    private WebElement ApplyFiltersButton;

    //closeFilters
    @FindBy(xpath = "//*[@id=\"content\"]/div/div[3]/div[2]/div/div/div/div/div[2]/div/div/div/div[1]/div/button/div/svg")
    private WebElement closeFiltersButton;

    //addtomyshop
    @FindBy(xpath = "//button[contains(text(),'Add to My Shop')]")
    private WebElement AddToMyShopButton;

    //BuyNowButton
    @FindBy(xpath = "//button[contains(text(),'Buy Now')]")
    private WebElement BuyNowButton;

    //ImageofProduct
    @FindBy(xpath = "//div[@class='item']")
    private WebElement ImageofProduct;

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


    public void clickToListOneProduct(){myActions.action_click(ListOneButton);};

    public void clickToListTwoProduct(){myActions.action_click(ListTwoButton);};

    public void clickOnFilterTab(){myActions.action_click(FilterTab);};

    public void clickOnSortTab(){myActions.action_click(SortTab);};

    public void clickOnFilterByCategory(){myActions.action_click(ByCategory);};

    public void clickOnFilterByPrice(){myActions.action_click(ByPrice);};

    public void clickOnFilterByDiscount(){myActions.action_click(ByDiscount);};

    public void clickOnMenShirtsCheckBox(){myActions.action_click(MenShirtsCheckbox);};

    public void clickOnMenT_ShirtsCheckBox(){myActions.action_click(MenT_ShirtsCheckbox);};

    public void clickOnDressMaterialsCheckBox(){myActions.action_click(DressMaterialsCheckbox);};

    public void clickOnSweatersCheckBox(){myActions.action_click(SweatersCheckbox);};

    public void clickOnJacketsCheckbox(){myActions.action_click(JacketsCheckbox);};

    public void clickOnKidsT_ShirtsCheckBox(){myActions.action_click(KidsT_ShirtsCheckbox);};

    public void clickOnT_ShirtsCheckBox(){myActions.action_click(T_ShirtsCheckbox);};

    public void clickOnJacketsCheckBox(){myActions.action_click(JacketsCheckbox);};

    public void clickOnMenJacketsCheckBox(){myActions.action_click(MenJacketsCheckbox);};

    public void clickOnMenWatchesCheckBox(){myActions.action_click(MenWatchesCheckbox);};

    public void clickOnBelow500TkCheckBox(){myActions.action_click(Below500TkCheckbox);};

    public void clickOn500_1000TkCheckBox(){myActions.action_click(r500_1000TkCheckbox);};

    public void clickOn1000_1500TkCheckBox(){myActions.action_click(r1000_1500TkCheckbox);};

    public void clickOn1500_2000CheckBox(){myActions.action_click(r1500_2000TkCheckbox);};

    public void clickOnAbove2000TkCheckbox(){myActions.action_click(Above2000TkCheckbox);};

    public void clickOnAbove70Checkbox(){myActions.action_click(Above70Checkbox);};

    public void clickOnAbove60CheckBox(){myActions.action_click(Above60Checkbox);};

    public void clickOnAbove50CheckBox(){myActions.action_click(Above50Checkbox);};

    public void clickOnAbove40CheckBox(){myActions.action_click(Above40Checkbox);};

    public void clickOnAbove30CheckBox(){myActions.action_click(Above30Checkbox);};

    public void clickOnAbove20CheckBox(){myActions.action_click(Above20Checkbox);};

    public void clickOnAbove10CheckBox(){myActions.action_click(Above10Checkbox);};

    public void clickOnCancelFilters(){myActions.action_click(ClearallFiltersButton);};

    public void clickOnApplyFilters(){myActions.action_click(ApplyFiltersButton);};

    public void clickOnCloseFilterTab(){myActions.action_click(closeFiltersButton);};

    public void clickOnAddToMyShop(){myActions.action_click(AddToMyShopButton);};

    public void clickOnBuyNow(){myActions.action_click(BuyNowButton);};

    public void clickOnImageOfProduct(){myActions.action_click(ImageofProduct);};

    public void clickOnSizeOptions(){myActions.action_click(SizeOptionsButton);};

    public void clickOnIncreaseQuantity(){myActions.action_click(IncreaseQuantityButton);};

    public void clickOnDecreaseQuantity(){myActions.action_click(DecreaseQuantityButton);};

    public void EnterChangeofCustomPrice(String price){myActions.action_sendKeys(ChangeOfCustomPriceValue,price);};

    public void EnterDeliveryCharge(String Delivery){myActions.action_sendKeys(Delivery_Charge,Delivery);};

    public void clickOnSaveDeliveryCharge(){myActions.action_click(SaveDelivery_Charge);};

    public void clickOnCouponApply(){myActions.action_click(CouponApplyButton);};

    public void clickOnContinueShopping(){myActions.action_click(ContinueShoppingButton);};

    public void clickOnPlaceOrder(){myActions.action_click(PlaceOrderButton);};

}



