package pageObjects;

import coreUtils.BuildParameterKeys;
import coreUtils.CoreConstants;
import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import services.commerceMethods.GetCommerceApiResponse;
import services.responseModels.commerceModels.ShoppingCartResponseModel;
import utils.*;
import java.util.*;


public class MyBagPageObjects extends AndroidBaseClass {

    // Cart/MyBag is completely a WebView

    private AndroidDriver<WebElement> androidDriver;
    private MyActions myActions;
    private Random random;
    private ProductListingPageObjects productListingPageObjects;
    private String plp_view;
    private String app;
    private String NEW_PLP = "New";
    private String OLD_PLP = "Old";
    private GetCommerceApiResponse getCommerceApiResponse;
    private ServiceRequestLayer serviceRequestLayer;

    public MyBagPageObjects(AndroidDriver<WebElement> androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
        myActions = new MyActions();
        random = new Random();
        productListingPageObjects = new ProductListingPageObjects(androidDriver);
        serviceRequestLayer = new ServiceRequestLayer();
        getCommerceApiResponse = serviceRequestLayer.getControlOverServices();
        plp_view = productListingPageObjects.plpView;
        if (plp_view.equalsIgnoreCase(NEW_PLP)) {
//        plp_view = productListingPageObjects.plpView;
            app = System.getProperty(BuildParameterKeys.KEY_APP);
            if (app.equalsIgnoreCase(CoreConstants.APP_MOKAM)) {
                switchFromNativeToWeb(CoreConstants.SHOP_UP_MOKAM_WEB_VIEW);
            } else if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
                switchFromNativeToWeb(CoreConstants.SHOP_UP_RESELLER_WEB_VIEW);
            }
        }
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
    private final String itemContainerPath = "//div[@class='lineItemContainer___DdZE9']";


    public class ItemContainer{

        private final AndroidDriver<WebElement> androidDriver;
        private final MyActions myActions;
        private final int minSalePrice;
        private final int maxSalePrice;
        
        

        // Container Parent Path
        private final String containerParentPath = "//div[@class='seller_info']/ancestor::div[2]/div";



        public int getListOfItemContainers(){
            List<WebElement> itemList = xpathListSetter(itemContainerPath);
            return itemList.size();
        }


        public ItemContainer(AndroidDriver<WebElement> androidDriver){
            this.androidDriver = androidDriver;
            PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
            myActions = new MyActions();
            try{
                minSalePrice = Integer.parseInt(PropertyReader.getValueOfKey(PropertyReader.Keys.PRODUCT_MIN_QUANTITY));
                maxSalePrice = Integer.parseInt(PropertyReader.getValueOfKey(PropertyReader.Keys.PRODUCT_MAX_QUANTITY));
                System.out.println(minSalePrice+" , "+maxSalePrice);
            }catch (Exception e){
                System.out.println("Exception At ItemContainer Constructor : Reading min and max");
            }
        }


        public List<WebElement> getListOfCancelIcons(){
            String cancelIconXpath = containerParentPath+"/div[2]//*[name()='g']";
            List<WebElement> cancelIconList = androidDriver.findElements(By.xpath(cancelIconXpath));
            return cancelIconList;
        }


        public List<WebElement> getListOfItemImages(){
            String productImageXpath = itemContainerPath+"//div[@class='imageContainer___2xHLN']//img";
            List<WebElement> productImagesList = androidDriver.findElements(By.xpath(productImageXpath));
            return productImagesList;
        }


        public List<WebElement> getListOfItemTitles(){
            String productTitleXpath = itemContainerPath+"//div[@class='titieVariantPriceBox___G3fSm']/p";
            List<WebElement> productTitlesList = androidDriver.findElements(By.xpath(productTitleXpath));
            return productTitlesList;
        }


        public List<WebElement> getListOfItemPrices(){
            String productPriceXpath = itemContainerPath+"//div[@class='titieVariantPriceBox___G3fSm']/div/span";
            List<WebElement> productPriceList = androidDriver.findElements(By.xpath(productPriceXpath));
            return productPriceList;
        }


        public String getItemPriceText(int index){
            String withTakeSymbol = myActions.action_getText(getListOfItemPrices().get(index-1));
            System.out.println(withTakeSymbol);
            String[] splitAmount = withTakeSymbol.split(" ");
            return splitAmount[1];
        }


        public List<WebElement> getListOfSizeSelectors(){
            String sizeSelectorXpath = itemContainerPath+"/div[2]/div[1]";
            List<WebElement> sizeSelectorList = androidDriver.findElements(By.xpath(sizeSelectorXpath));
            return sizeSelectorList;
        }


        public List<WebElement> getDropDownOfSizes(){
            String sizeSelectorXpath = itemContainerPath+"/div[2]/div[1]//div";
            List<WebElement> sizeSelectorDropDown = androidDriver.findElements(By.xpath(sizeSelectorXpath));
            return sizeSelectorDropDown;
        }


        public List<WebElement> getListOfSizes(){
            String sizeXpath = "//div[@class='modal-body']//p";
            List<WebElement> sizeList = androidDriver.findElements(By.xpath(sizeXpath));
            return sizeList;
        }


        public String selectedSize(int sizeIndex){
            String sizeXpath = "//div[@class='modal-body']//p["+ ++sizeIndex +"]";
            WebElement sizeSelectedElement = xpathSetter(sizeXpath);
            String sizeSelected = myActions.action_getText(sizeSelectedElement);
            return sizeSelected;
        }


        public List<WebElement> getListOfSubQuantityButton(){
            String subQuantityXpath = itemContainerPath+"//input[@class='qtyMinus___2cf0a']";
            List<WebElement> subButtonList = androidDriver.findElements(By.xpath(subQuantityXpath));
            return subButtonList;
        }


        public List<WebElement> getListOfItemQuantityValues(){
            String itemQuantityXpath = itemContainerPath+"//input[@class='qtyMinus___2cf0a']/following-sibling::span";
            List<WebElement> itemQuantityList = androidDriver.findElements(By.xpath(itemQuantityXpath));
            return itemQuantityList;
        }


        public List<WebElement> getListOfAddQuantityButton(){
            String addQuantityXpath = containerParentPath+"//input[@class='qtyPlus___2ePjK']";
            List<WebElement> addButtonList = androidDriver.findElements(By.xpath(addQuantityXpath));
            return addButtonList;
        }


        public List<WebElement> getListOfSalePriceLabel(){
            String salePriceLabelXPath = containerParentPath+"/div[3]/div[1]/span[1]";
            List<WebElement> salePriceLabelList = androidDriver.findElements(By.xpath(salePriceLabelXPath));
            return salePriceLabelList;
        }


        public List<WebElement> getListOfCurrencyPlaceHolders(){
            String currencyPlaceHoldersXPath = containerParentPath+"/div[3]/div[2]/div[1]/p";
            List<WebElement> currencyPlaceHoldersList = androidDriver.findElements(By.xpath(currencyPlaceHoldersXPath));
            return currencyPlaceHoldersList;
        }


        public List<WebElement> getListOfSalePriceEditTexts(){
            String salePriceEditTextXPath = containerParentPath+"/div[2]//div[3]//div[2]/div//input";
            List<WebElement> salePriceEditTextList = androidDriver.findElements(By.xpath(salePriceEditTextXPath));
            return salePriceEditTextList;
        }


        public List<WebElement> getListOfYourEarningsLabel(){
            String yourEarningsLabelXPath = containerParentPath+"/div[3]/div[1]/span[2]";
            List<WebElement> yourEarningsLabelList = androidDriver.findElements(By.xpath(yourEarningsLabelXPath));
            return yourEarningsLabelList;
        }


        public List<WebElement> getListOfEarningsPerItem(){
            String yourEarningsLabelXPath = containerParentPath+"/div[2]//div[3]/div[2]//span";
            List<WebElement> yourEarningsPerItemList = androidDriver.findElements(By.xpath(yourEarningsLabelXPath));
            return yourEarningsPerItemList;
        }


        public String getEaringsPerItemAmountText(int index){
            String withTakeSymbol = myActions.action_getText(getListOfEarningsPerItem().get(index-1));
            System.out.println(withTakeSymbol);
            String[] splitAmount = withTakeSymbol.split(" ");
            return splitAmount[1];
        }


        public List<WebElement> getListOfYourOrderValueLabel(){
            String yourOrderValueLabelXPath = containerParentPath+"/div[4]/span[1]";
            List<WebElement> yourOrderValueLabelList = androidDriver.findElements(By.xpath(yourOrderValueLabelXPath));
            return yourOrderValueLabelList;
        }


        public List<WebElement> getListOfOrderValuePerItem(){
            String yourOrderValuePerItemXPath = containerParentPath+"/div[2]//div[4]/span[2]";
            List<WebElement> yourOrderValuePerItemList = androidDriver.findElements(By.xpath(yourOrderValuePerItemXPath));
            return yourOrderValuePerItemList;
        }


        public String getOrderValuePerItemAmountText(int index){
            String withTakeSymbol = myActions.action_getText(getListOfOrderValuePerItem().get(index-1));
            System.out.println(withTakeSymbol);
            String[] splitAmount = withTakeSymbol.split(" ");
            return splitAmount[1];
        }





        public void clickOnCancelItem(WebElement webElement){
            myActions.action_click(webElement);
        }

        public void clickOnCancelIcon(int containerId){
            String cancelIconXpath = containerParentPath + "[" + containerId + "]//*[name()='svg']";
            WebElement cancelElement = androidDriver.findElement(By.xpath(cancelIconXpath));
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

        public void enterSalePriceOnContainer(int containerId,int Price){
            String salepriceinput = containerParentPath+"["+containerId+"]//div[@class='salePriceIncomeBox___2wV0g']//div[2]//div//input";
            String salePrice = ""+Price+"";
            myActions.action_sendKeys(androidDriver.findElement(By.xpath(salepriceinput)),salePrice);
        }

        public String getYourEarningsLabelOnContainer(int containerId){
            String yourEarningsLabel = containerParentPath+"["+containerId+"]//div[@class='salePriceIncomeBox___2wV0g']/div[1]/span[2]";
            return myActions.action_getText(androidDriver.findElement(By.xpath(yourEarningsLabel)));
        }

        public void clickOnAddQuantityButton(WebElement element){
            myActions.action_click(element);
        }

        public void clickOnSubQuantityButton(WebElement element) {myActions.action_click(element);}

        public void closeSizeListInMyBag(){
            String closeButton = "//div[@class='modal-footer']/button";
            myActions.action_click(xpathSetter(closeButton));
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
            //Assert.assertEquals(original.equalsIgnoreCase("Price should be in between "+minSalePrice+" and "+maxSalePrice),true);
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
            //Assert.assertEquals(original.equalsIgnoreCase("Price updated to "+minSalePrice),true);
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
            //Assert.assertEquals(original.equalsIgnoreCase("Price updated to "+maxSalePrice),true);
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
            //Assert.assertEquals(original.equalsIgnoreCase("Price should be in between "+minSalePrice+" and "+maxSalePrice),true);
            System.out.println("Greater Than Maximum Sale Price is Entered");
        }



    }

    public class CreditsAndCoupons{

        // Cart/MyBag os completely a WebView

        private final AndroidDriver<WebElement> androidDriver;
        private final MyActions myActions;

        public CreditsAndCoupons(AndroidDriver<WebElement> androidDriver){
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

        @FindBy(xpath = "")
        private WebElement enterCoupon;

        @FindBy(xpath = "")
        private WebElement couponApplyButton;

        @FindBy(xpath = "")
        private WebElement couponCloseButton;

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

        public String getDeliveryChargesText(){
            String withTakeSymbol = myActions.action_getText(deliveryChargesEditText);
            System.out.println(withTakeSymbol);
            String[] splitAmount = withTakeSymbol.split(" ");
            return splitAmount[1];
        }

        public void clickOnDeliveryChargeSaveButton(){
            myActions.action_click(deliveryChargesSaveButton);
        }

        public String getCouponDiscountLabelText(){
            return myActions.action_getText(couponDiscountLabel);
        }

        public void clickOnApplyCouponNowButton(){
            myActions.action_click(couponApplyNowButton);
        }

        public void enterCoupon(String coupon){myActions.action_sendKeys(enterCoupon,coupon);}

        public void clickOnCouponApplyButton(){myActions.action_click(couponApplyButton);}

        public void clickOnCouponCloseButton(){myActions.action_click(couponCloseButton);}

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
            return myActions.action_getText(cartValueCount);
        }

        public String getCartTotalValue(){
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

        public void applyCoupon(String coupon){
            clickOnApplyCouponNowButton();
            enterCoupon(coupon);
            clickOnCouponApplyButton();
        }

    }

    @FindBy(xpath = "//div[@class='link___1RSLm']/span[2]")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "(//a[@href='/checkout/address']/button)[2]")
    private WebElement placeOrderButtonReseller;

    @FindBy(xpath = "//div[@class='unicornButton___G3iNs']//button")
    private WebElement placeOrderButtonUnicorn;


    public void clickOnContinueShoppingButton(){
        myActions.action_click(continueShoppingButton);
    }

    public void clickOnPlaceOrderButton(){
        if(app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
            myActions.action_click(placeOrderButtonUnicorn);
        }else if(app.equalsIgnoreCase(CoreConstants.APP_RESELLER)){
            myActions.action_click(placeOrderButtonReseller);
        }
    }


/*-------Data-----*/


    public int getPriceDetails(int index, String price){
        List<ShoppingCartResponseModel.CartItemsBean> priceDetails = getCommerceApiResponse.getListOfCartItems();
        int value = 0;
        String withTakeSymbol;
        String[] splitAmount;
        switch (price){
            case "Earnings" :
                withTakeSymbol = priceDetails.get(index).getFormatted_income();;
                splitAmount = withTakeSymbol.split(" ");
                value = Integer.parseInt(String.valueOf(splitAmount));
                break;

            case "OrderValue" :
                withTakeSymbol = priceDetails.get(index).getFormatted_per_item_total();
                splitAmount = withTakeSymbol.split(" ");
                value = Integer.parseInt(String.valueOf(splitAmount));
                break;

            case "SalePrice" :
                withTakeSymbol = priceDetails.get(index).getFormatted_sale_price();
                splitAmount = withTakeSymbol.split(" ");
                value = Integer.parseInt(String.valueOf(splitAmount));
                break;

            case "VariantPrice" :
                value = priceDetails.get(index).getVariant_price();
                break;

            case "Quantity" :
                value = priceDetails.get(index).getQuantity();
                break;

            case "MinSalePrice" :
                value = priceDetails.get(index).getMin_selling_price();
                break;

            case "MaxSalePrice" :
                value = priceDetails.get(index).getMax_selling_price();
                break;
        }
        return value;
    }


    public int getChargeandTotalValue(String data){
        Map<String,Object> productDetailsMap = getCommerceApiResponse.getCharges();
        String withTakeSymbol = String.valueOf(productDetailsMap.get(data));
        String[] splitAmount = withTakeSymbol.split(" ");
        return Integer.parseInt(String.valueOf(splitAmount));
    }


}
