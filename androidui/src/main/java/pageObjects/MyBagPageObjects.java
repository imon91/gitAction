package pageObjects;

import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MyActions;

import java.util.List;

import static utils.AndroidBaseClass.sleep;


public class MyBagPageObjects {

    // Cart/MyBag os completely a WebView

    private AndroidDriver<AndroidElement> androidDriver;
    private MyActions myActions;

    public MyBagPageObjects(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
    }


    // Cart Value Container
    @FindBy(xpath = "//div[@class='cart-value-right_header']")
    private WebElement cartValueContainer;

    // Cart Value Text
    @FindBy(xpath = "//div[@class='cart-value-right_header']/p/span[1]")
    private WebElement cartValueText;

    // Cart total Items Count
    @FindBy(xpath = "//div[@class='cart-value-right_header']/p/span[3]/span[2]")
    private WebElement cartItemsCount;

    // Cart Total Value
    @FindBy(xpath = "//div[@class='cart-value-right_header']/p/span[7]/span[2]")
    private WebElement cartTotalValue;

    // Item Container Path
    private String itemContainerPath = "//div[@class='lineItemContainer___DdZE9']";


    public class ItemContainer{

        private AndroidDriver<AndroidElement> androidDriver;
        private MyActions myActions;
        
        

        // Container Parent Path
        private String containerParentPath = "//div[@class='seller_info']/ancestor::div[2]/div";



        public int getListOfItemContainers(){
            List<AndroidElement> itemList =
                    androidDriver.findElements(By.xpath(containerParentPath));
            return itemList.size();
        }


        public ItemContainer(AndroidDriver<AndroidElement> androidDriver){
            this.androidDriver = androidDriver;
            PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
            myActions = new MyActions();
        }


        public List<AndroidElement> getListOfCancelIcons(){
            String cancelIconXpath = containerParentPath+"/div[2]//*[name()='g']";
            List<AndroidElement> cancelIconList = androidDriver.findElements(By.xpath(cancelIconXpath));
            return cancelIconList;
        }



        public void clickOnCancelItem(AndroidElement androidElement){
            myActions.action_click(androidElement);
        }

        public void clickOnCancelIcon(int containerId){
            String cancelIconXpath = containerParentPath + "[" + containerId + "]//*[name()='svg']";
            String newCancelIconXpath = "//div[@class='seller_info']/following-sibling::div[1]/div["+containerId+"]/*[name()='svg']";
            AndroidElement cancelElement = androidDriver.findElement(By.xpath(cancelIconXpath));
            myActions.action_click(cancelElement);
        }


        public String getImageLinkOfContainer(int containerId){
            String imageXpath = containerParentPath+"["+containerId+"]//div[@class='imageContainer___2xHLN']//img";
            return androidDriver.findElement(By.xpath(imageXpath)).getAttribute("src");
        }

        public void clickOnImageLinkOfContainer(int containerId){
            String imageXpath = containerParentPath+"["+containerId+"]//div[@class='imageContainer___2xHLN']//img";
            myActions.action_click(androidDriver.findElement(By.xpath(imageXpath)));
        }


        public String getItemTitleOfContainer(int containerId){
            String titleXpath = containerParentPath+"["+containerId+"]//p";
            return myActions.action_getText(androidDriver.findElement(By.xpath(titleXpath)));
        }


        public String getPrimaryAmountOnContainer(int containerId){
            String primaryAmount = containerParentPath+"["+containerId+"]//p/following-sibling::div/span";
            return myActions.action_getText(androidDriver.findElement(By.xpath(primaryAmount)));
        }

        public String getThePreSelectedSizeOfItemOnContainer(int containerId){
            String preSelectedSize = containerParentPath+"["+containerId+"]/div[2]/div[1]/div[2]/div[1]/span";
            return myActions.action_getText(androidDriver.findElement(By.xpath(preSelectedSize)));
        }

        public void clickOnSelectSizeOnContainer(int containerId){
            String selectSizeIcon = containerParentPath+"["+containerId+"]/div[2]/div[1]/div[2]/div[1]/div/*[name()='svg']";
            myActions.action_click(androidDriver.findElement(By.xpath(selectSizeIcon)));
        }

        public void clickOnIncreaseQtyButtonOnContainer(int containerId){
            String increaseQuantityButton = containerParentPath+"["+containerId+"]/div[2]//input[@class='qtyPlus___2ePjK']";
            myActions.action_click(androidDriver.findElement(By.xpath(increaseQuantityButton)));
        }

        public void clickOnDecreaseQtyButtonOnContainer(int containerId){
            String decreaseQuantityButton = containerParentPath+"["+containerId+"]/div[2]//input[@class='qtyMinus___2cf0a']";
            myActions.action_click(androidDriver.findElement(By.xpath(decreaseQuantityButton)));
        }

        public String getQuantityValueOnContainer(int containerId){
            String preSelectedSize = containerParentPath+"["+containerId+"]/div[2]//input[@class='qtyMinus___2cf0a']/following-sibling::span";
            return myActions.action_getText(androidDriver.findElement(By.xpath(preSelectedSize)));
        }

        public String getSalePriceIncomeLabelOnContainer(int containerId){
            String salePriceIncomeLabel = containerParentPath+"["+containerId+"]//div[@class='salePriceIncomeBox___2wV0g']/div[1]/span[1]";
            return myActions.action_getText(androidDriver.findElement(By.xpath(salePriceIncomeLabel)));
        }

        public void enterSalePriceOnContainer(int containerId,String salePrice){
            String salepriceinput = containerParentPath+"["+containerId+"]//div[@class='salePriceIncomeBox___2wV0g']//div[2]//div//input";
            myActions.action_sendKeys(androidDriver.findElement(By.xpath(salepriceinput)),salePrice);
        }

        int minPrice = Integer.parseInt(System.getProperty("minSalePrice"));
        int maxPrice = Integer.parseInt(System.getProperty("maxSalePrice"));
        String min = Integer.toString(minPrice);
        String max = Integer.toString(maxPrice);

        public void checkingLessThanMinPrice(int containerId){
            int min_Price = minPrice-5;
            String min_ = Integer.toString(min_Price);
            enterSalePriceOnContainer(containerId,min_);
            getSalePriceIncomeLabelOnContainer(containerId);
            WebDriverWait wait = new WebDriverWait(androidDriver,30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id = 'toastbar-header-basic']//div")));
            String original = myActions.action_getText(androidDriver.findElement(By.xpath("//div[@id = 'toastbar-header-basic']//div")));
            if(original.equalsIgnoreCase("Price Should be in between "+min+" and "+max)){
                System.out.println("Lesser Than Minimum Sale Price is Entered");
            }
        }

        public void checkingMinPrice(int containerId){
            enterSalePriceOnContainer(containerId,min);
            getSalePriceIncomeLabelOnContainer(containerId);
            WebDriverWait wait = new WebDriverWait(androidDriver,30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id = 'toastbar-header-basic']//div")));
            String original = myActions.action_getText(androidDriver.findElement(By.xpath("//div[@id = 'toastbar-header-basic']//div")));
            if(original.equalsIgnoreCase("Price updated to "+min)){
                System.out.println("Min Sale Price is Entered");
            }
        }

        public void checkingMaxPrice(int containerId){
            enterSalePriceOnContainer(containerId,max);
            getSalePriceIncomeLabelOnContainer(containerId);
            WebDriverWait wait = new WebDriverWait(androidDriver,30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id = 'toastbar-header-basic']//div")));
            String original = myActions.action_getText(androidDriver.findElement(By.xpath("//div[@id = 'toastbar-header-basic']//div")));
            if(original.equalsIgnoreCase("Price updated to "+max)){
                System.out.println("Max Sale Price is Entered");
            }
        }

        public void checkingMoreThanMaxPrice(int containerId){
            int max_Price = maxPrice+5;
            String max_ = Integer.toString(max_Price);
            enterSalePriceOnContainer(containerId,max_);
            getSalePriceIncomeLabelOnContainer(containerId);
            WebDriverWait wait = new WebDriverWait(androidDriver,30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id = 'toastbar-header-basic']//div")));
            String original = myActions.action_getText(androidDriver.findElement(By.xpath("//div[@id = 'toastbar-header-basic']//div")));
            if(original.equalsIgnoreCase("Price Should be in between "+min+" and "+max)){
                System.out.println("Greater Than Maximum Sale Price is Entered");
            }
        }

        public String getYourEarningsLabelOnContainer(int containerId){
            String yourEarningsLabel = containerParentPath+"["+containerId+"]//div[@class='salePriceIncomeBox___2wV0g']/div[1]/span[2]";
            return myActions.action_getText(androidDriver.findElement(By.xpath(yourEarningsLabel)));
        }

        public void clickOnAddQuantityButton(AndroidElement element){
            myActions.action_click(element);
        }

        public List<AndroidElement> getListOfAddQuantityButton(){
            List<AndroidElement> addButtonList = androidDriver.findElements(By.xpath("//input[@class='qtyPlus___2ePjK']"));
            return addButtonList;
        }


    }


    public class CreditsAndCoupons{

        // Cart/MyBag os completely a WebView

        private AndroidDriver<AndroidElement> androidDriver;
        private MyActions myActions;

        public CreditsAndCoupons(AndroidDriver<AndroidElement> androidDriver){
            this.androidDriver = androidDriver;
            PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
            myActions = new MyActions();
        }

        @FindBy(xpath = "//p[@class='number_of_available']/span[1]")
        private WebElement itemTotalLabel;

        @FindBy(xpath = "//p[@class='number_of_available']/span[2]")
        private WebElement itemTotalAmount;

        @FindBy(xpath = "//p[contains(text(),'Shipping Charges')]")
        private WebElement shippingChargesLabel;

        @FindBy(xpath = "//input[@id='deliveryCharge1']")
        private WebElement deliveryChargesEditText;

        @FindBy(xpath = "//input[@name='delivery_charge']/following-sibling::button")
        private WebElement deliveryChargesSaveButton;

        @FindBy(xpath = "//div[@class='available-coupon']/p/span[1]")
        private WebElement couponDiscountLabel;

        @FindBy(xpath = "//div[@class='available-coupon']/p/span[2]/a")
        private WebElement couponApplyNowButton;

        @FindBy(xpath = "//p[@class='you_save_text']/span")
        private WebElement yourTotalEarningLabel;

        @FindBy(xpath = "//p[@class='you_save_inner']/span/b")
        private WebElement yourTotalEarningsAmount;

        @FindBy(xpath = "//p[@class='you_save_text']/span/span[1]")
        private WebElement cartValueLabelText;

        @FindBy(xpath = "//p[@class='you_save_text']/span/span[3]")
        private WebElement cartValueCount;

        @FindBy(xpath = "//p[@class='you_save_inner']/span[@class='order_total_amount']/b")
        private WebElement orderTotalAmount;

        public String getItemTotalLabelText(){
            return myActions.action_getText(itemTotalLabel);
        }

        public String getItemTotalAmountText(){
            String withTakeSymbol = myActions.action_getText(itemTotalAmount);
            System.out.println(withTakeSymbol);
            String[] splitAmount = withTakeSymbol.split(" ");
            return splitAmount[1];
        }

        public String getShippingChargesLabelText(){
            return myActions.action_getText(shippingChargesLabel);
        }

        public void enterDeliveryCharges(String deliveryCharge){
            myActions.action_sendKeys(deliveryChargesEditText,deliveryCharge);
        }

        public void clickOnDeliveryChargeSaveButton(){
            myActions.action_click(deliveryChargesEditText);
        }

        public String getCouponDiscountLabelText(){
            return myActions.action_getText(couponDiscountLabel);
        }

        public void clickOnApplyCouponNowButton(){
            myActions.action_click(couponApplyNowButton);
        }

        public String getYourTotalSavingsLabelText(){
            return myActions.action_getText(yourTotalEarningLabel);
        }

        public String getYourTotalEarningsAmount(){
            String withTakeSymbol = myActions.action_getText(yourTotalEarningsAmount);
            String[] splitAmount = withTakeSymbol.split(" ");
            return splitAmount[1];
        }

        public String getCartValueLabelText(){
            return myActions.action_getText(cartValueLabelText);
        }

        public String getCartValueCount(){
            String withTakeSymbol = myActions.action_getText(cartTotalValue);
            String[] splitAmount = withTakeSymbol.split(" ");
            return splitAmount[1];
        }

        public String getOrderTotalAmountValue(){
            return myActions.action_getText(orderTotalAmount);
        }



        /*--Apply Shipping Charges--*/
        public void applyShippingCharges(String shippingCharge){
            enterDeliveryCharges(shippingCharge);
            clickOnDeliveryChargeSaveButton();
        }

    }

    @FindBy(xpath = "//div[@class='link___1RSLm']/span[2]")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "(//a[@href='/checkout/address']/button)[2]")
    private WebElement placeOrderButton;


    public void clickOnContinueShoppingButton(){
        myActions.action_click(continueShoppingButton);
    }

    public void clickOnPlaceOrderButton(){
        myActions.action_click(placeOrderButton);
    }




}
