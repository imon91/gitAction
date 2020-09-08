package pageObjects;

import io.appium.java_client.*;
import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import services.commerceMethods.*;
import services.responseModels.commerceModels.*;
import utils.*;
import java.time.*;
import java.util.*;
import java.util.NoSuchElementException;


public class ProductDescriptionPageObjects extends AndroidBaseClass{

    private AndroidDriver<WebElement> androidDriver;
    private MyActions myActions;
    private ServiceRequestLayer serviceRequestLayer;
    private GetPLPModuleApiResponse getPLPModuleApiResponse;
    private String packageName;
    private int minSalePrice;
    private int maxSalePrice;

    public ProductDescriptionPageObjects(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
        packageName = getAppPackage();
        serviceRequestLayer = new ServiceRequestLayer();
        getPLPModuleApiResponse = serviceRequestLayer.getControlOverPLPModuleApiResponse();
        try{minSalePrice = Integer.parseInt(System.getProperty("minSalePrice"));
        maxSalePrice = Integer.parseInt(System.getProperty("maxSalePrice"));}catch(Exception e){System.out.println("min and max salePrice was null");}
        System.out.println(minSalePrice+" , "+maxSalePrice);
    }


    // Product Details ScrollView
    private WebElement productDetailsScrollView;

    // Product Details ScrollView Sub View : Parent -> productDetailsScrollView
    private WebElement productDetailsScrollViewSubView;

    // Image PageHolder : Parent -> productDetailsScrollViewSubView
    private WebElement imagePageHolder;


    public void getProductDetailsScrollView(){
        productDetailsScrollView =
                xpathSetter("//android.widget.ScrollView[@resource-id='"+packageName+":id/product_details_scroll_view']");
    }


    public void getProductDetailsScrollViewSubView(){
        productDetailsScrollViewSubView =
                xpathSetter("//android.widget.LinearLayout[@resource-id='"+packageName+":id/product_details_scroll_view_sub_view']");
    }


    /*-------ImagePageHolder Items starts Here--------*/

    // Image PageViewer
    private WebElement imagePageViewer;

    // Button CloseZoom
    private WebElement buttonCloseZoom;

    // Button LeftArrow
    private WebElement buttonLeftArrow;

    // Button RightArrow
    private WebElement buttonRightZoom;


    public void getImagePageViewer(){
        productDetailsScrollViewSubView =
                xpathSetter("//androidx.viewpager.widget.ViewPager[@resource-id='"+packageName+":id/pager']");
    }


    public void clickOnButtonLeftArrow(){
        buttonLeftArrow = xpathSetter("//android.widget.ImageButton[@resource-id='"+packageName+":id/btn_left_arrow']");
        myActions.action_click(buttonLeftArrow);
    }


    public void clickOnButtonRightArrow(){
        buttonLeftArrow = xpathSetter("//android.widget.ImageButton[@resource-id='"+packageName+":id/btn_right_arrow']");
        myActions.action_click(buttonLeftArrow);
    }

    /*-------ImagePageHolder Items Ends Here--------*/

    // Product Price Details : Parent -> productDetailsScrollViewSubView
    private WebElement productPriceDetails;

    // Price Det Container : Parent -> productPriceDetails
    private WebElement priceDetContainer;

    // Price Container : Parent -> priceDetContainer
    private WebElement priceContainer;


    public void getProductPriceDetailsLinearLayout(){
        productPriceDetails =
                xpathSetter("//android.widget.LinearLayout[@resource-id='"+packageName+":id/product_price_details']");
    }


    public void getPriceDetContainer(){
        priceDetContainer =
                xpathSetter("//android.widget.RelativeLayout[@resource-id='"+packageName+":id/price_det_container']");
    }


    public void getPriceContainer(){
        priceContainer =
                xpathSetter("//android.widget.LinearLayout[@resource-id='"+packageName+":id/priceContainer']");
    }

    /*-----priceContainer Items starts--------*/

    // Product Name
    private WebElement productName;

    // Price Jazz
    private WebElement priceJazz;


    public String getProductName(){
        productName =
                xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/product_name']");
        return myActions.action_getText(productName);
    }

    public void getPriceJazzContainer(){
        priceJazz =
                xpathSetter("//android.widget.LinearLayout[@resource-id='"+packageName+":id/price_jazz']");
    }

    /*-----priceJazz Items Starts--------*/

    // Price
    private WebElement finalPrice;

    // Original Price
    private WebElement originalPrice;

    // Discount Price
    private WebElement discountPrice;


    public String getFinalPrice(){
        finalPrice =
                xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/price']");
        return myActions.action_getText(finalPrice);
    }


    public String getOriginalPrice(){
        originalPrice =
                xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/original_price']");
        return myActions.action_getText(originalPrice);
    }

    public String getDiscountPrice(){
        discountPrice =
                xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/discount']");
        return myActions.action_getText(discountPrice);
    }

    /*-----priceJazz Items Ends--------*/


    // Set MinMax Product Price
    private WebElement minMaxProductPrice;

    // Flex Box
    private WebElement flexBox;


    public String getMinMaxPriceText(){
        minMaxProductPrice =
                xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/minandmax']");
        return myActions.action_getText(minMaxProductPrice);
    }


    public void getFlexBoxContainer(){
        flexBox = xpathSetter("//android.view.ViewGroup[@resource-id='"+packageName+":id/flexBox']");
    }

    /*-----FlexBox Items Starts--------*/

    // Text
    private WebElement textTag;


    public String getItemFlexTag(){
        textTag =
                xpathSetter("//android.widget.TextView[@"+packageName+":id/text']");
        return myActions.action_getText(textTag);
    }

    /*-----FlexBox Items Ends--------*/

    /*-----priceContainer Items Ends--------*/


    // Select Size Label
    private WebElement selectSizeLabel;

    public String getSelectSizeLabel(){
        selectSizeLabel =
                xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/select_size_label']");
        return myActions.action_getText(selectSizeLabel);
    }

    /*---Size Guide Sheet Elements starts--*/

    // Select Size Cancel
    private WebElement sizeGuideClose;


    public void clickOnSizeGuideCloseButton(){
        sizeGuideClose =
                xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/size_guide_close']");
        myActions.action_click(sizeGuideClose);
    }

    /*---Size Guide Sheet Elements Ends--*/

    // SelectSize HorizontalScrollView
    private WebElement selectSizeHorizontalScrollView;

    public void getSelectSizeHorizontalScrollView(){
        selectSizeHorizontalScrollView =
                xpathSetter("//android.widget.HorizontalScrollView[@resource-id='"+packageName+":id/horizontalScrollView']");
    }

    /*-----selectSizeHorizontalScrollView Items Starts Here--------*/

    // Size List
    private WebElement sizeList;

    public void getSizeListRelativeLayout(){
        sizeList = xpathSetter("//android.widget.RelativeLayout[@resource-id='"+packageName+":id/size_list']");
    }

    // Size Each Element
    private List<WebElement> sizeEachElementList;

    public List<WebElement> getSizeEachElementList(){
        sizeEachElementList =
                xpathListSetter("//android.widget.RelativeLayout[@resource-id='"+packageName+":id/size_each_element']");
        return sizeEachElementList;
    }

    /*-----sizeEachElement Items Starts Here--------*/

    // Size Each Element's Value
    private List<WebElement> sizeEachValueList;

    public List<WebElement> getSizeEachValueList(){
        sizeEachValueList =
                xpathListSetter("//android.widget.TextView[@resource-id='"+packageName+":id/size_value']");
        return sizeEachValueList;
    }

    /*-----sizeEachElement Items Ends Here--------*/

    /*-----selectSizeHorizontalScrollView Items Ends Here--------*/


    // Size Guide Label
    private WebElement sizeGuideLabel;

    // ShareContainer
    private WebElement shareContainer;

    public void getShareContainer(){
        shareContainer =
                xpathSetter("//android.widget.LinearLayout[@resource-id='"+packageName+":id/shareContainer']");
    }

    /*-----ShareContainer Items Starts Here--------*/

    // Download Image
    private WebElement downloadImage;

    public void clickOnDownloadImageButton(){
        downloadImage =
                xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/download_image']");
        myActions.action_click(downloadImage);
    }

    // Share Image
    private WebElement shareImage;

    public void clickOnShareImageButton(){
        shareImage =
                xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/share']");
        myActions.action_click(shareImage);
    }

    // CopyDetails Image
    private WebElement copyDetailsImage;

    public void clickOnCopyDetailsImage(){
        copyDetailsImage =
                xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/copy_details']");
        myActions.action_click(copyDetailsImage);
    }

    /*-----ShareContainer Items Ends Here--------*/

    // Product Description Label;
    private WebElement productDescriptionLabel;

    public String getProductDescriptionLabel(){
        productDescriptionLabel =
                xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/prod_desc_label']");
        return myActions.action_getText(productDescriptionLabel);
    }

    // Product Details Grid
    private WebElement descriptionDetailsGrid;

    public void getProductGridDetailsGrid(){
        descriptionDetailsGrid =
                xpathSetter("//android.widget.TableLayout[@resource-id='"+packageName+":id/prod_details_grid']");
    }


    public class DescriptionGridDetails{

        // Product Code Label
        private WebElement productCodeLabel;

        // Product Code
        private WebElement productCode;

        // Product Info Category Label
        private WebElement productInfoCategoryLabel;

        // Product Info Category
        private WebElement productInfoCategoryName;

        public String getProductCodeLabel(){
            productCodeLabel =
                    xpathSetter("");
            return myActions.action_getText(productCodeLabel);
        }


        public String getProductCode(){
            productCode =
                    xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/product_code']");
            return myActions.action_getText(productCode);
        }


        public String getProductInfoCategoryLabel(){
            productInfoCategoryLabel =
                    xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/product_info_category_label']");
            return myActions.action_getText(productInfoCategoryLabel);
        }


        public String getProductInfoCategory(){
            productInfoCategoryName =
                    xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/product_info_category']");
            return myActions.action_getText(productInfoCategoryName);
        }
    }

    public DescriptionGridDetails getDescriptionDetails(){
        return new DescriptionGridDetails();
    }

    // Product Info Description
    private WebElement productInfoDescription;

    public String geProductInfoDescription(){
        productInfoDescription =
                xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/product_info_description']");
        return myActions.action_getText(productInfoDescription);
    }

    // Recently Viewed By You Label
    private WebElement recentlyViewedByYouLabel;

    public String recentlyViewedByYouLabel(){
        recentlyViewedByYouLabel =
                xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/widget_id']");
        return myActions.action_getText(recentlyViewedByYouLabel);
    }


    // RecentlyViewedByYouRecyclerContainer Info Description
    private WebElement recentlyViewedByYouRecyclerContainer;

    public void getRecentlyViewedByYouRecyclerContainer(){
        recentlyViewedByYouRecyclerContainer =
                xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/widget_recycler']");
    }

    /*----RecentlyViewedByYouRecyclerContainer Items Are Pending---*/

    // A New Class is being created to make it as a modular component

    /*----RecentlyViewedByYouRecyclerContainer Items Are Pending---*/


    // Add To MyShop Button
    private WebElement addToMyShopButton;

    // Place Order Button
    @AndroidFindBy(xpath = "//android.widget.Button[@text='PLACE ORDER']")
    private AndroidElement placeOrderButton;

    // Place Order By CallButton
    private WebElement placeOrderByCall;

    // Bottom Sheet CollectionItems
    private WebElement bottomSheetCollectionItems;


    public void clickOnPlaceOrderByCall(){
        placeOrderByCall = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/order_by_call']");
        myActions.action_click(placeOrderByCall);
    }


    public String getBottomSheetCollectionItems(){
        bottomSheetCollectionItems =
                xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/sort_text']");
        return myActions.action_getText(bottomSheetCollectionItems);
    }




    public class PDPTutorial{

        private AndroidDriver<WebElement> androidDriver;
        private MyActions myActions;

        public PDPTutorial(AndroidDriver<WebElement> androidDriver){
            this.androidDriver = getBaseDriver();
            myActions = new MyActions();
        }


        // Tutorial Parent Layout
        private WebElement pdpTutorialHolder;

        // Swipe up Image
        private WebElement swipeUpImage;

        // Swipe Up For Product Information Text
        private WebElement swipeUpForProductInfoText;

        // GotIt button
        private WebElement gotItButton;


        public void getPDPTutorialHolderRelativeLayout(){
            pdpTutorialHolder =
                    xpathSetter("//android.widget.RelativeLayout[@resource-id='"+packageName+":id/RLPDPTutorial']");
        }


        public void clickOnSwipeUpImage(){
            swipeUpImage =
                    xpathSetter("//android.widget.ImageView");
            myActions.action_click(swipeUpImage);
        }


        public String getOnSwipeUpForProductInfoText(){
            swipeUpForProductInfoText =
                    xpathSetter("//android.widget.TextView[@text='Swipe Up For Product Information']");
            return myActions.action_getText(swipeUpForProductInfoText);
        }


        public void clickOnGotItButton(){
            gotItButton = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/btnOKTutorial']");
            myActions.action_click(gotItButton);
        }

    }



    public class BottomSheetHolder{

        private AndroidDriver<WebElement> androidDriver;
        private MyActions myActions;

        public BottomSheetHolder(AndroidDriver<WebElement> androidDriver){
            this.androidDriver = androidDriver;
            PageFactory.initElements(new AppiumFieldDecorator(androidDriver,
                    Duration.ofMillis(10000)),30);
            myActions = new MyActions();
        }


        // Bottom Sheet Select Quantity Label
        private WebElement selectQuantityLabel;

        public String getSelectQuantityLabel(){
            selectQuantityLabel =
                    xpathSetter("//android.widget.TextView[@text='Select Quantity']");
            return myActions.action_getText(selectQuantityLabel);
        }

        // Select Quantity Subtract button
        private WebElement selectQuantitySubtractButton;

        // Select Quantity Number Counter
        private WebElement selectQuantityNumberCounter;

        // Select Quantity Add button
        private WebElement selectQuantityAddButton;

        // Enter your sale price text
        private WebElement enterYourSalePriceLabel;

        // Your Earnings Label
        private WebElement yourEarningsLabel;

        // Price Symbol
        private WebElement priceSymbol;

        // Price Change EditText
        private WebElement priceChangeEditText;

        // Total Earnings Text
        private WebElement totalEarnings;

        // Your Total Bag
        private WebElement yourTotalBag;

        // Total Price
        private WebElement totalPrice;

        // Add To Cart
        private WebElement addToCartButton;

        // Price Min and Max
        private WebElement priceMinAndMax;



        public String getEnterYourSalePriceText(){
            enterYourSalePriceLabel =
                    xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/enter_text']");
            return myActions.action_getText(enterYourSalePriceLabel);
        }


        public String getYourEarningsLabel(){
            yourEarningsLabel =
                    xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/totalEarningsHint']");
            return myActions.action_getText(yourEarningsLabel);
        }


        public String getPriceSymbolText(){
            priceSymbol =
                    xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/priceSymbol']");
            return myActions.action_getText(priceSymbol);
        }


        public String getPriceMinAndMaxText(){
            priceMinAndMax =
                    xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/minandmax']");
            return myActions.action_getText(priceMinAndMax);
        }


        public String getYourTotalBagValueText(){
            yourTotalBag =
                    xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/yourTotalBag']");
            return myActions.action_getText(yourTotalBag);
        }


        /*--------Actions--------*/

        public void enterSalePriceEditText(String salePrice){
            priceChangeEditText = xpathSetter("//android.widget.EditText[@resource-id='"+packageName+":id/price_change_edittext']");
            myActions.action_clearText(priceChangeEditText);
            myActions.action_sendKeys(priceChangeEditText,salePrice);
        }

        public void clickOnAddToBagButton(){
            addToCartButton = xpathSetter("//android.widget.Button[@resource-id='"+packageName+":id/add_to_cart_new']");
            myActions.action_click(addToCartButton);
        }


        public void clickOnAddQuantityButton(){
            selectQuantityAddButton = xpathSetter("//android.widget.Button[@resource-id='"+packageName+":id/add_btn']");
            myActions.action_click(selectQuantityAddButton);
        }


        public void clickOnSubtractQuantityButton(){
            selectQuantitySubtractButton = xpathSetter("//android.widget.Button[@resource-id='"+packageName+":id/subtract_btn']");
            myActions.action_click(selectQuantitySubtractButton);
        }

        public String getTheQuantityCounterValue(){
            selectQuantityNumberCounter = xpathSetter("//android.widget.Button[@resource-id='"+packageName+":id/number_counter']");
            return myActions.action_getText(selectQuantityNumberCounter);
        }

        public String getEarning(){
            totalEarnings = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/totalEarnings']");
            return myActions.action_getText(totalEarnings);
        }

        public String getTotalBagValue(){
            totalPrice = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/totalPrice']");
            return myActions.action_getText(totalPrice);
        }


        /*--------Functions---------*/

        public void enterProductQuantity(int count){
            if(count!=0 || count!=1){
                for(int i=0;i<count;i++){
                    clickOnAddQuantityButton();
                }
            }else {
                System.out.println("Count is : "+count);
            }
        }

        public void selectValidQuantity(){

        }

        public void enterValidSalePrice(){

        }

    }




    /*------------Actions-------------*/


    public void clickOnImagePageHolder(){
        imagePageHolder = xpathSetter("//android.widget.LinearLayout[@resource-id='"+packageName+":id/image_page_holder']");
        myActions.action_click(imagePageHolder);
    }

    public void clickOnImagePageViewer(){ myActions.action_click(imagePageViewer);}

    public void clickOnZoomCancelButton(){
        buttonCloseZoom = xpathSetter("//android.widget.ImageButton[@resource-id='"+packageName+":id/btn_close_zoom']");
        myActions.action_click(buttonCloseZoom);
    }

    public void clickOnSizeGuide(){
        sizeGuideLabel = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/size_guide_label']");
        myActions.action_click(sizeGuideLabel);
    }



    /*------Functions--------*/

    public void selectRandomSizeFromSizeList(){
        List<WebElement> sizeListItems =
                xpathListSetter("//android.widget.TextView[@resource-id='"+packageName+":id/size_value']");
        System.out.println("SizeListLength is : "+sizeListItems.size());
        Random random = new Random();
        int item = random.nextInt(sizeListItems.size());
        myActions.action_click(sizeListItems.get(item));
        System.out.println("Selected Size : "+sizeListItems.get(item).getText());
    }


    public void selectGivenSizeFromSizeList(int sizeIndex){
        List<WebElement> sizeListItems =
                idListSetter(""+packageName+":id/size_value");
        System.out.println("Product Size List is : "+sizeListItems.size());
        myActions.action_click(sizeListItems.get(sizeIndex));
        System.out.println("Selected Size : "+sizeListItems.get(sizeIndex).getText());
    }



    public void clickOnAddToMyShopButton(){
        addToMyShopButton = xpathSetter("//android.widget.Button[@resource-id='"+packageName+":id/add_to_my_shop']");
        myActions.action_click(addToMyShopButton);
    }



    public void selectCollectionToAddProduct(){
        List<WebElement> collectionList =
                xpathListSetter("//android.widget.TextView[@resource-id='"+packageName+":id/sort_text']");
        System.out.println("CollectionList is : "+collectionList);
        if(collectionList.size()==1){
            System.out.println("No Collections Found to Add one : " +
                    "Please add a functionality to add collection from here");
        }else {
            Random random = new Random();
            int item = random.nextInt(collectionList.size());
            if(item==0) {
                item = item + 1;
            }
            myActions.action_click(collectionList.get(item));
            System.out.println("Selected Collection is : "+collectionList.get(item).getText());
        }
    }

    public void clickOnPlaceOrderButton(){
        //placeOrderButton = xpathSetter("//android.widget.Button[@text='PLACE ORDER']");
        myActions.action_click(placeOrderButton);
    }


    public class NewProductDescriptionObjects{

        private MyActions myActions;
        private AndroidDriver<WebElement> androidDriver;

        public NewProductDescriptionObjects(AndroidDriver<WebElement> androidDriver){
            this.myActions = new MyActions();
            this.androidDriver = androidDriver;
        }

        // Pager Image

        // Details Product Brand

        // Details Product title
        private WebElement detailsProductTitle;

        // Details Product Price

        // Details Product Margin

        // Detail Title Variants

        // Text Variant Title

        // Text Variant Price

        // Text Variant Margin

        // Remove From Cart Button

        // Item Count EditText
        private WebElement itemCountEditText;

        // Add To Cart Button
        private WebElement addToCartButton;

        // Action Go To Cart Details Button
        private WebElement actionGoToCartButton;

        // Action Continue Shopping Details


        /*--------Actions--------*/

        public String getDetailsProductTitle(){
            detailsProductTitle =
                    xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/details_product_title']");
            return myActions.action_getText(detailsProductTitle);
        }


        public String getItemCount(){
            itemCountEditText =
                    xpathSetter("//android.widget.EditText[@resource-id='"+packageName+":id/item_count']");
            return myActions.action_getText(itemCountEditText);
        }


        public void clickOnAddTOCartButton(int qty){
            addToCartButton =
                    xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/add_to_cart']");
            for(int i=0;i<qty;i++){
                myActions.action_click(addToCartButton);
            }
        }


        public void clickOnActionGotToCartButton(){
            actionGoToCartButton =
                    xpathSetter("//android.widget.Button[@resource-id='"+packageName+":id/action_goto_cart_details']");
            myActions.action_click(actionGoToCartButton);
        }


        /*-------Functions--------*/

        public void placeOrderWithOnlyMinimumQuantity(int qty){
            try {
                System.out.println("Item Count : "+getItemCount());
                if(Integer.parseInt(getItemCount())>=1){
                    clickOnActionGotToCartButton();
                }
            }catch (NullPointerException | NoSuchElementException e){
                clickOnAddTOCartButton(qty);
            }
        }

    }

    public ProductDescriptionModel productDescriptionModelResults(String slug)
    {
        return getPLPModuleApiResponse.getProductDescriptionPageResults(slug);
    }

    public boolean scrollToText(String textToScroll)
    {
        WebElement element = androidDriver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\""+packageName+":id/product_price_details\")).scrollIntoView("
                        + "new UiSelector().text(\""+textToScroll+ "\"))"));
        return true;
    }

    public String getListOfSizes(int SizeIndex)
    {
        List<WebElement> collectionList =
                xpathListSetter("//android.widget.TextView[@resource-id='"+packageName+":id/size_value']");
        return myActions.action_getText(collectionList.get(SizeIndex));
    }

    public boolean clearAllNotifications()
    {
        androidDriver.openNotifications();
        try {
        WebElement clearButton = androidDriver.findElement(By.xpath("//android.widget.Button[@content-desc='Clear all notifications.']"));
        myActions.action_click(clearButton);
    }
        catch(Exception e) {
        WebElement clearAllNotification= androidDriver.findElementById("com.android.systemui:id/delete");
        myActions.action_click(clearAllNotification);
    }
        return true;
    }

    public WebElement elementPopupPermissionALLOW()
    {
        return xpathSetter("//android.widget.Button[@text='ALLOW']");
    }

    public boolean scrollToNotificationText(String textToScroll)
    {
        WebElement element = androidDriver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\"com.android.systemui:id/notification_stack_scroller\")).scrollIntoView("
                        + "new UiSelector().text(\""+textToScroll+ "\"))"));
        return true;
    }

    public boolean scrollToPopupText(String textToScroll)
    {
        WebElement element = androidDriver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\"android:id/resolver_list\")).setAsHorizontalList().scrollIntoView("
                        + "new UiSelector().text(\""+textToScroll+ "\"))"));
        return true;
    }



}
