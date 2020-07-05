package pageObjects;

import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.MyActions;

import java.util.List;
import java.util.Random;

import static utils.AndroidBaseClass.sleep;


public class MyBagPageObjects {

    // Cart/MyBag os completely a WebView

    private AndroidDriver<AndroidElement> androidDriver;
    private MyActions myActions;
    private Random random;

    public MyBagPageObjects(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
        random = new Random();
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
        private int minSalePrice,maxSalePrice;
        
        

        // Container Parent Path
        private String containerParentPath = "//div[@class='seller_info']/ancestor::div[2]/div";



        public int getListOfItemContainers(){
            List<AndroidElement> itemList =
                    androidDriver.findElements(By.xpath(itemContainerPath));
            return itemList.size();
        }


        public ItemContainer(AndroidDriver<AndroidElement> androidDriver){
            this.androidDriver = androidDriver;
            PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
            myActions = new MyActions();
            minSalePrice = Integer.parseInt(System.getProperty("minSalePrice"));
            maxSalePrice = Integer.parseInt(System.getProperty("maxSalePrice"));
            System.out.println(minSalePrice+" , "+maxSalePrice);
        }


        public List<AndroidElement> getListOfCancelIcons(){
            String cancelIconXpath = containerParentPath+"/div[2]//*[name()='g']";
            List<AndroidElement> cancelIconList = androidDriver.findElements(By.xpath(cancelIconXpath));
            return cancelIconList;
        }


        public List<AndroidElement> getListOfItemImages(){
            String productImageXpath = itemContainerPath+"//div[@class='imageContainer___2xHLN']//img";
            List<AndroidElement> productImagesList = androidDriver.findElements(By.xpath(productImageXpath));
            return productImagesList;
        }


        public List<AndroidElement> getListOfItemTitles(){
            String productTitleXpath = itemContainerPath+"//div[@class='titieVariantPriceBox___G3fSm']/p";
            List<AndroidElement> productTitlesList = androidDriver.findElements(By.xpath(productTitleXpath));
            return productTitlesList;
        }


        public List<AndroidElement> getListOfItemPrices(){
            String productPriceXpath = itemContainerPath+"//div[@class='titieVariantPriceBox___G3fSm']/div/span";
            List<AndroidElement> productPriceList = androidDriver.findElements(By.xpath(productPriceXpath));
            return productPriceList;
        }


        public List<AndroidElement> getListOfSizeSelectors(){
            String sizeSelectorXpath = itemContainerPath+"/div[2]/div[1]";
            List<AndroidElement> sizeSelectorList = androidDriver.findElements(By.xpath(sizeSelectorXpath));
            return sizeSelectorList;
        }


        public List<AndroidElement> getListOfSubQuantityButton(){
            String subQuantityXpath = itemContainerPath+"//input[@class='qtyMinus___2cf0a']";
            List<AndroidElement> subButtonList = androidDriver.findElements(By.xpath(subQuantityXpath));
            return subButtonList;
        }


        public List<AndroidElement> getListOfItemQuantityValues(){
            String itemQuantityXpath = itemContainerPath+"//input[@class='qtyMinus___2cf0a']/following-sibling::span";
            List<AndroidElement> itemQuantityList = androidDriver.findElements(By.xpath(itemQuantityXpath));
            return itemQuantityList;
        }


        public List<AndroidElement> getListOfAddQuantityButton(){
            String addQuantityXpath = containerParentPath+"//input[@class='qtyPlus___2ePjK']";
            List<AndroidElement> addButtonList = androidDriver.findElements(By.xpath(addQuantityXpath));
            return addButtonList;
        }


        public List<AndroidElement> getListOfSalePriceLabel(){
            String salePriceLabelXPath = containerParentPath+"/div[3]/div[1]/span[1]";
            List<AndroidElement> salePriceLabelList = androidDriver.findElements(By.xpath(salePriceLabelXPath));
            return salePriceLabelList;
        }


        public List<AndroidElement> getListOfCurrencyPlaceHolders(){
            String currencyPlaceHoldersXPath = containerParentPath+"/div[3]/div[2]/div[1]/p";
            List<AndroidElement> currencyPlaceHoldersList = androidDriver.findElements(By.xpath(currencyPlaceHoldersXPath));
            return currencyPlaceHoldersList;
        }


        public List<AndroidElement> getListOfSalePriceEditTexts(){
            String salePriceEditTextXPath = containerParentPath+"/div[3]/div[2]/div[1]/input[@class='customPrice___3YhPU']";
            List<AndroidElement> salePriceEditTextList = androidDriver.findElements(By.xpath(salePriceEditTextXPath));
            return salePriceEditTextList;
        }


        public List<AndroidElement> getListOfYourEarningsLabel(){
            String yourEarningsLabelXPath = containerParentPath+"/div[3]/div[1]/span[2]";
            List<AndroidElement> yourEarningsLabelList = androidDriver.findElements(By.xpath(yourEarningsLabelXPath));
            return yourEarningsLabelList;
        }


        public List<AndroidElement> getListOfEarningsPerItem(){
            String yourEarningsLabelXPath = containerParentPath+"/div[3]/div[2]/span";
            List<AndroidElement> yourEarningsPerItemList = androidDriver.findElements(By.xpath(yourEarningsLabelXPath));
            return yourEarningsPerItemList;
        }


        public List<AndroidElement> getListOfYourOrderValueLabel(){
            String yourOrderValueLabelXPath = containerParentPath+"/div[4]/span[1]";
            List<AndroidElement> yourOrderValueLabelList = androidDriver.findElements(By.xpath(yourOrderValueLabelXPath));
            return yourOrderValueLabelList;
        }


        public List<AndroidElement> getListOfOrderValuePerItem(){
            String yourOrderValuePerItemXPath = containerParentPath+"/div[4]/span[2]";
            List<AndroidElement> yourOrderValuePerItemList = androidDriver.findElements(By.xpath(yourOrderValuePerItemXPath));
            return yourOrderValuePerItemList;
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

        public String enterSalePriceOnContainer(int containerId){
            String salePriceIncomeLabel = containerParentPath+"["+containerId+"]//div[@class='salePriceIncomeBox___2wV0g']/div[1]/span[1]";
            return myActions.action_getText(androidDriver.findElement(By.xpath(salePriceIncomeLabel)));
        }

        public String getYourEarningsLabelOnContainer(int containerId){
            String yourEarningsLabel = containerParentPath+"["+containerId+"]//div[@class='salePriceIncomeBox___2wV0g']/div[1]/span[2]";
            return myActions.action_getText(androidDriver.findElement(By.xpath(yourEarningsLabel)));
        }

        public void clickOnAddQuantityButton(AndroidElement element){
            myActions.action_click(element);
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


    public class ItemContainer{

        private AndroidDriver<AndroidElement> androidDriver;
        private MyActions myActions;
        private int minSalePrice,maxSalePrice;



        // Container Parent Path
        private String containerParentPath = "//div[@class='seller_info']/ancestor::div[2]/div";



        public int getListOfItemContainers(){
            List<AndroidElement> itemList =
                    androidDriver.findElements(By.xpath(itemContainerPath));
            return itemList.size();
        }


        public ItemContainer(AndroidDriver<AndroidElement> androidDriver){
            this.androidDriver = androidDriver;
            PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
            myActions = new MyActions();
            minSalePrice = Integer.parseInt(System.getProperty("minSalePrice"));
            maxSalePrice = Integer.parseInt(System.getProperty("maxSalePrice"));
            System.out.println(minSalePrice+" , "+maxSalePrice);
        }


        public List<AndroidElement> getListOfCancelIcons(){
            String cancelIconXpath = containerParentPath+"/div[2]//*[name()='g']";
            List<AndroidElement> cancelIconList = androidDriver.findElements(By.xpath(cancelIconXpath));
            return cancelIconList;
        }


        public List<AndroidElement> getListOfItemImages(){
            String productImageXpath = itemContainerPath+"//div[@class='imageContainer___2xHLN']//img";
            List<AndroidElement> productImagesList = androidDriver.findElements(By.xpath(productImageXpath));
            return productImagesList;
        }


        public List<AndroidElement> getListOfItemTitles(){
            String productTitleXpath = itemContainerPath+"//div[@class='titieVariantPriceBox___G3fSm']/p";
            List<AndroidElement> productTitlesList = androidDriver.findElements(By.xpath(productTitleXpath));
            return productTitlesList;
        }


        public List<AndroidElement> getListOfItemPrices(){
            String productPriceXpath = itemContainerPath+"//div[@class='titieVariantPriceBox___G3fSm']/div/span";
            List<AndroidElement> productPriceList = androidDriver.findElements(By.xpath(productPriceXpath));
            return productPriceList;
        }


        public List<AndroidElement> getListOfSizeSelectors(){
            String sizeSelectorXpath = itemContainerPath+"/div[2]/div[1]";
            List<AndroidElement> sizeSelectorList = androidDriver.findElements(By.xpath(sizeSelectorXpath));
            return sizeSelectorList;
        }


        public List<AndroidElement> getListOfSubQuantityButton(){
            String subQuantityXpath = itemContainerPath+"//input[@class='qtyMinus___2cf0a']";
            List<AndroidElement> subButtonList = androidDriver.findElements(By.xpath(subQuantityXpath));
            return subButtonList;
        }


        public List<AndroidElement> getListOfItemQuantityValues(){
            String itemQuantityXpath = itemContainerPath+"//input[@class='qtyMinus___2cf0a']/following-sibling::span";
            List<AndroidElement> itemQuantityList = androidDriver.findElements(By.xpath(itemQuantityXpath));
            return itemQuantityList;
        }


        public List<AndroidElement> getListOfAddQuantityButton(){
            String addQuantityXpath = containerParentPath+"//input[@class='qtyPlus___2ePjK']";
            List<AndroidElement> addButtonList = androidDriver.findElements(By.xpath(addQuantityXpath));
            return addButtonList;
        }


        public List<AndroidElement> getListOfSalePriceLabel(){
            String salePriceLabelXPath = containerParentPath+"/div[3]/div[1]/span[1]";
            List<AndroidElement> salePriceLabelList = androidDriver.findElements(By.xpath(salePriceLabelXPath));
            return salePriceLabelList;
        }


        public List<AndroidElement> getListOfCurrencyPlaceHolders(){
            String currencyPlaceHoldersXPath = containerParentPath+"/div[3]/div[2]/div[1]/p";
            List<AndroidElement> currencyPlaceHoldersList = androidDriver.findElements(By.xpath(currencyPlaceHoldersXPath));
            return currencyPlaceHoldersList;
        }


        public List<AndroidElement> getListOfSalePriceEditTexts(){
            String salePriceEditTextXPath = containerParentPath+"/div[3]/div[2]/div[1]/input[@class='customPrice___3YhPU']";
            List<AndroidElement> salePriceEditTextList = androidDriver.findElements(By.xpath(salePriceEditTextXPath));
            return salePriceEditTextList;
        }


        public List<AndroidElement> getListOfYourEarningsLabel(){
            String yourEarningsLabelXPath = containerParentPath+"/div[3]/div[1]/span[2]";
            List<AndroidElement> yourEarningsLabelList = androidDriver.findElements(By.xpath(yourEarningsLabelXPath));
            return yourEarningsLabelList;
        }


        public List<AndroidElement> getListOfEarningsPerItem(){
            String yourEarningsLabelXPath = containerParentPath+"/div[3]/div[2]/span";
            List<AndroidElement> yourEarningsPerItemList = androidDriver.findElements(By.xpath(yourEarningsLabelXPath));
            return yourEarningsPerItemList;
        }


        public List<AndroidElement> getListOfYourOrderValueLabel(){
            String yourOrderValueLabelXPath = containerParentPath+"/div[4]/span[1]";
            List<AndroidElement> yourOrderValueLabelList = androidDriver.findElements(By.xpath(yourOrderValueLabelXPath));
            return yourOrderValueLabelList;
        }


        public List<AndroidElement> getListOfOrderValuePerItem(){
            String yourOrderValuePerItemXPath = containerParentPath+"/div[4]/span[2]";
            List<AndroidElement> yourOrderValuePerItemList = androidDriver.findElements(By.xpath(yourOrderValuePerItemXPath));
            return yourOrderValuePerItemList;
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

        public void getSalePriceIncomeLabelOnContainer(int containerId){
            String salePriceIncomeLabel = containerParentPath+"["+containerId+"]//div[@class='salePriceIncomeBox___2wV0g']/div[1]/span[1]";
            myActions.action_click(androidDriver.findElement(By.xpath(salePriceIncomeLabel)));
        }

        public String enterSalePriceOnContainer(int containerId){
            String salePriceIncomeLabel = containerParentPath+"["+containerId+"]//div[@class='salePriceIncomeBox___2wV0g']/div[1]/span[1]";
            return myActions.action_getText(androidDriver.findElement(By.xpath(salePriceIncomeLabel)));
        }

        public void enterSalePriceOnContainer(int containerId,int Price){
            String salepriceinput = containerParentPath+"["+containerId+"]//div[@class='salePriceIncomeBox___2wV0g']//div[2]//div//input";
            String salePrice = ""+Price+"";
            myActions.action_sendKeys(androidDriver.findElement(By.xpath(salepriceinput)),salePrice);
        }

        public String getYourEarningsLabelOnContainer(int containerId){
            String yourEarningsLabel = containerParentPath+"["+containerId+"]//div[@class='salePriceIncomeBox___2wV0g']/div[1]/span[2]";
            return myActions.action_getText(androidDriver.findElement(By.xpath(yourEarningsLabel)));
        }

        public void clickOnAddQuantityButton(AndroidElement element){
            myActions.action_click(element);
        }


        public void givingRandomSalePrice(int containerId){
            int salePrice = random.nextInt((maxSalePrice-minSalePrice))+minSalePrice;
            androidDriver.findElement(By.xpath(containerParentPath+"["+containerId+"]//div[@class='salePriceIncomeBox___2wV0g']//div[2]//div//input")).clear();
            enterSalePriceOnContainer(containerId,salePrice);
            sleep(3000);
            getSalePriceIncomeLabelOnContainer(containerId);
        }


        public void checkingLessThanMinPrice(int containerId){
            androidDriver.findElement(By.xpath(containerParentPath+"["+containerId+"]//div[@class='salePriceIncomeBox___2wV0g']//div[2]//div//input")).clear();
            enterSalePriceOnContainer(containerId,(minSalePrice-1));
            sleep(3000);
            getSalePriceIncomeLabelOnContainer(containerId);
            WebDriverWait wait = new WebDriverWait(androidDriver,30);
            String original =myActions.action_getText(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id = 'toastbar-header-basic']//div"))));
            System.out.println(original);
            Assert.assertEquals(original.equalsIgnoreCase("Price should be in between "+minSalePrice+" and "+maxSalePrice),true);
            System.out.println("Lesser Than Minimum Sale Price is Entered");
        }

        public void checkingMinPrice(int containerId){
            androidDriver.findElement(By.xpath(containerParentPath+"["+containerId+"]//div[@class='salePriceIncomeBox___2wV0g']//div[2]//div//input")).clear();
            enterSalePriceOnContainer(containerId,minSalePrice);
            sleep(3000);
            getSalePriceIncomeLabelOnContainer(containerId);
            WebDriverWait wait = new WebDriverWait(androidDriver,30);
            String original = myActions.action_getText(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id = 'toastbar-header-basic']//div"))));
            System.out.println(original);
            Assert.assertEquals(original.equalsIgnoreCase("Price updated to "+minSalePrice),true);
            System.out.println("Min Sale Price is Entered");
        }

        public void checkingMaxPrice(int containerId){
            androidDriver.findElement(By.xpath(containerParentPath+"["+containerId+"]//div[@class='salePriceIncomeBox___2wV0g']//div[2]//div//input")).clear();
            enterSalePriceOnContainer(containerId,maxSalePrice);
            sleep(3000);
            getSalePriceIncomeLabelOnContainer(containerId);
            WebDriverWait wait = new WebDriverWait(androidDriver,30);
            String original = myActions.action_getText(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id = 'toastbar-header-basic']//div"))));
            System.out.println(original);
            Assert.assertEquals(original.equalsIgnoreCase("Price updated to "+maxSalePrice),true);
            System.out.println("Max Sale Price is Entered");
        }

        public void checkingMoreThanMaxPrice(int containerId){
            androidDriver.findElement(By.xpath(containerParentPath+"["+containerId+"]//div[@class='salePriceIncomeBox___2wV0g']//div[2]//div//input")).clear();
            enterSalePriceOnContainer(containerId,(maxSalePrice+1));
            sleep(3000);
            getSalePriceIncomeLabelOnContainer(containerId);
            WebDriverWait wait = new WebDriverWait(androidDriver,30);
            String original = myActions.action_getText(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id = 'toastbar-header-basic']//div"))));
            System.out.println(original);
            Assert.assertEquals(original.equalsIgnoreCase("Price should be in between "+minSalePrice+" and "+maxSalePrice),true);
            System.out.println("Greater Than Maximum Sale Price is Entered");
        }

    }



}
