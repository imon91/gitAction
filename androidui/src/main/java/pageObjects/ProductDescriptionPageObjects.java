package pageObjects;

import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.*;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import utils.*;
import java.util.*;

public class ProductDescriptionPageObjects {

    private AndroidDriver<AndroidElement> androidDriver;
    private MyActions myActions;
    private ServiceRequestLayer serviceRequestLayer;

    public ProductDescriptionPageObjects(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
        serviceRequestLayer = new ServiceRequestLayer();
    }


    // Product Details ScrollView
    @AndroidFindBy(xpath = "//android.widget.ScrollView[@resource-id='com.shopup.reseller:id/product_details_scroll_view']")
    private AndroidElement productDetailsScrollView;

    // Product Details ScrollView Sub View : Parent -> productDetailsScrollView
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.shopup.reseller:id/product_details_scroll_view_sub_view']")
    private AndroidElement productDetailsScrollViewSubView;

    // Image PageHolder : Parent -> productDetailsScrollViewSubView
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.shopup.reseller:id/image_page_holder']")
    private AndroidElement imagePageHolder;

    /*-------ImagePageHolder Items starts Here--------*/

    // Image PageViewer
    @AndroidFindBy(xpath = "//androidx.viewpager.widget.ViewPager[@resource-id='com.shopup.reseller:id/pager']")
    private AndroidElement imagePageViewer;

    // Button CloseZoom
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id='com.shopup.reseller:id/btn_close_zoom']")
    private AndroidElement buttonCloseZoom;

    // Button LeftArrow
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id='com.shopup.reseller:id/btn_left_arrow']")
    private AndroidElement buttonLeftArrow;

    // Button RightArrow
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id='com.shopup.reseller:id/btn_right_arrow']")
    private AndroidElement buttonRightZoom;

    /*-------ImagePageHolder Items Ends Here--------*/

    // Product Price Details : Parent -> productDetailsScrollViewSubView
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.shopup.reseller:id/product_price_details']")
    private AndroidElement productPriceDetails;

    // Price Det Container : Parent -> productPriceDetails
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@resource-id='com.shopup.reseller:id/price_det_container']")
    private AndroidElement priceDetContainer;

    // Price Container : Parent -> priceDetContainer
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.shopup.reseller:id/priceContainer']")
    private AndroidElement priceContainer;

    /*-----priceContainer Items starts--------*/

    // Product Name
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/product_name']")
    private AndroidElement productName;

    // Price Jazz
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.shopup.reseller:id/price_jazz']")
    private AndroidElement priceJazz;

    /*-----priceJazz Items Starts--------*/

    // Price
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/price']")
    private AndroidElement finalPrice;

    // Original Price
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/original_price']")
    private AndroidElement originalPrice;

    // Discount Price
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/discount']")
    private AndroidElement discountPrice;

    /*-----priceJazz Items Ends--------*/


    // Set MinMax Product Price
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/minandmax']")
    private AndroidElement minMaxProductPrice;


    // Flex Box
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/flexBox']")
    private AndroidElement flexBox;

    /*-----FlexBox Items Starts--------*/

    // Text
    @AndroidFindBy(xpath = "//android.widget.TextView[@com.shopup.reseller:id/text']")
    private AndroidElement text;

    /*-----FlexBox Items Ends--------*/

    /*-----priceContainer Items Ends--------*/


    // Select Size Label
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/select_size_label']")
    private AndroidElement selectSizeLabel;

    /*---Size Guide Sheet Elements starts--*/

    // Select Size Cancel
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/size_guide_close']")
    private AndroidElement sizeGuideClose;

    /*---Size Guide Sheet Elements Ends--*/

    // SelectSize HorizontalScrollView
    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView[@resource-id='com.shopup.reseller:id/horizontalScrollView']")
    private AndroidElement selectSizeHorizontalScrollView;

    /*-----selectSizeHorizontalScrollView Items Starts Here--------*/

    // Size List
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@resource-id='com.shopup.reseller:id/size_list']")
    private AndroidElement sizeList;


    // Size Each Element
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@resource-id='com.shopup.reseller:id/size_each_element']")
    private AndroidElement sizeEachElement;

    /*-----sizeEachElement Items Starts Here--------*/

    // Size Each Element's Value
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/size_value']")
    private AndroidElement sizeEachValue;

    /*-----sizeEachElement Items Ends Here--------*/

    /*-----selectSizeHorizontalScrollView Items Ends Here--------*/


    // Size Guide Label
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/size_guide_label']")
    private AndroidElement sizeGuideLabel;

    // ShareContainer
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.shopup.reseller:id/shareContainer']")
    private AndroidElement shareContainer;

    /*-----ShareContainer Items Starts Here--------*/

    // Download Image
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/download_image']")
    private AndroidElement downloadImage;

    // Share Image
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/share']")
    private AndroidElement shareImage;

    // CopyDetails Image
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/copy_details']")
    private AndroidElement copyDetailsImage;

    /*-----ShareContainer Items Ends Here--------*/

    // Product Description Label;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/prod_desc_label']")
    private AndroidElement productDescriptionLabel;


    // Product Details Grid
    @AndroidFindBy(xpath = "//android.widget.TableLayout[@resource-id='com.shopup.reseller:id/prod_details_grid']")
    private AndroidElement descriptionDetailsGrid;


    public class DescriptionGridDetails{
        // Product Code Label
        @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/product_code_label']")
        private AndroidElement productCodeLabel;

        // Product Code
        @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/product_code']")
        private AndroidElement productCode;

        // Product Info Category Label
        @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/product_info_category_label']")
        private AndroidElement productInfoCategoryLabel;

        // Product Info Category
        @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/product_info_category']")
        private AndroidElement productInfoCategory;
    }

    public DescriptionGridDetails getDescriptionDetails(){
        return new DescriptionGridDetails();
    }

    // Product Info Description
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/product_info_description']")
    private AndroidElement productInfoDescription;

    // Recently Viewed By You Label
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/widget_id']")
    private AndroidElement recentlyViewedByYouLabel;


    // RecentlyViewedByYouRecyclerContainer Info Description
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/widget_recycler']")
    private AndroidElement recentlyViewedByYouRecyclerContainer;

    /*----RecentlyViewedByYouRecyclerContainer Items Are Pending---*/


    /*----RecentlyViewedByYouRecyclerContainer Items Are Pending---*/


    // Add To MyShop Button
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.shopup.reseller:id/add_to_my_shop']")
    private AndroidElement addToMyShopButton;


    // Place Order Button
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.shopup.reseller:id/buy_new']")
    private AndroidElement placeOrderButton;

    // Place Order By CallButton
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/order_by_call']")
    private AndroidElement placeOrderByCall;


    // Bottom Sheet CollectionItems
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/sort_text']")
    private AndroidElement bottomSheetCollectionItems;



    public class PDPTutorial{

        private AndroidDriver<AndroidElement> androidDriver;
        private MyActions myActions;

        public PDPTutorial(AndroidDriver<AndroidElement> androidDriver){
            this.androidDriver = androidDriver;
            PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
            myActions = new MyActions();
        }


        // Tutorial Parent Layout
        @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@resource-id='com.shopup.reseller:id/RLPDPTutorial']")
        private AndroidElement pdpTutorialHolder;

        // Swipe up Image
        @AndroidFindBy(xpath = "//android.widget.ImageView")
        private AndroidElement swipeUpImage;

        // Swipe Up For Product Information Text
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Swipe Up For Product Information']")
        private AndroidElement swipeUpForProductInfoText;

        // GotIt button
        @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/btnOKTutorial']")
        private AndroidElement gotItButton;


        public void clickOnGotItButton(){
            myActions.action_click(gotItButton);
        }

    }



    public class BottomSheetHolder{

        private AndroidDriver<AndroidElement> androidDriver;
        private MyActions myActions;

        public BottomSheetHolder(AndroidDriver<AndroidElement> androidDriver){
            this.androidDriver = androidDriver;
            PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
            myActions = new MyActions();
        }


        // Bottom Sheet Select Quantity Label
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Select Quantity']")
        private AndroidElement selectQuantityLabel;

        // Select Quantity Subtract button
        @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.shopup.reseller:id/subtract_btn']")
        private AndroidElement selectQuantitySubtractButton;

        // Select Quantity Number Counter
        @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.shopup.reseller:id/number_counter']")
        private AndroidElement selectQuantityNumberCounter;

        // Select Quantity Add button
        @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.shopup.reseller:id/add_btn']")
        private AndroidElement selectQuantityAddButton;

        // Enter your sale price text
        @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/enter_text']")
        private AndroidElement enterYourSalePriceLabel;

        // Your Earnings Label
        @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/totalEarningsHint']")
        private AndroidElement yourEarningsLabel;

        // Price Symbol
        @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/priceSymbol']")
        private AndroidElement priceSymbol;

        // Price Change EditText
        @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/price_change_edittext']")
        private AndroidElement priceChangeEditText;

        // Total Earnings Text
        @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/totalEarnings']")
        private AndroidElement totalEarnings;

//        // Price Min and Max
//        @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/minandmax']")
//        private AndroidElement priceMinAndMax;

        // Your Total Bag
        @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/yourTotalBag']")
        private AndroidElement yourTotalBag;

        // Total Price
        @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/totalPrice']")
        private AndroidElement totalPrice;

        // Add To Cart
        @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.shopup.reseller:id/add_to_cart_new']")
        private AndroidElement addToCartButton;

        // Place Order
        @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.shopup.reseller:id/buy_new']")
        private AndroidElement placeOrderButton;


        /*--------Actions--------*/

        public void enterSalePriceEditText(String salePrice){
            myActions.action_sendKeys(priceChangeEditText,salePrice);
        }

        public void clickOnAddToBagButton(){
            myActions.action_click(addToCartButton);
        }


        public void clickOnAddQuantityButton(){
            myActions.action_click(selectQuantityAddButton);
        }


        public void clickOnSubtractQuantityButton(){
            myActions.action_click(selectQuantitySubtractButton);
        }

        public String getTheQuantityCounterValue(){
            return myActions.action_getText(selectQuantityNumberCounter);
        }

        public String getEarning(){
            return myActions.action_getText(totalEarnings);
        }

        public String getTotalBagValue(){
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
        myActions.action_click(imagePageHolder);
    }

    public void clickOnZoomCancelButton(){
        myActions.action_click(buttonCloseZoom);
    }

    public void clickOnSizeGuide(){
        myActions.action_click(sizeGuideLabel);
    }



    /*------Functions--------*/

    public void selectRandomSizeFromSizeList(){
        List<AndroidElement> sizeListItems =
                androidDriver.findElements
                        (By.xpath("//android.widget.TextView[@resource-id='com.shopup.reseller:id/size_value']"));
        System.out.println("SizeListLength is : "+sizeListItems.size());
        Random random = new Random();
        int item = random.nextInt(sizeListItems.size());
        myActions.action_click(sizeListItems.get(item));
        System.out.println("Selected Size : "+sizeListItems.get(item).getText());
    }


    public void selectGivenSizeFromSizeList(int sizeIndex){
        List<AndroidElement> sizeListItems =
                androidDriver.findElements
                        (By.xpath("//android.widget.TextView[@resource-id='com.shopup.reseller:id/size_value']"));
        myActions.action_click(sizeListItems.get(sizeIndex));
        System.out.println("Selected Size : "+sizeListItems.get(sizeIndex).getText());
    }




    public void clickOnAddToMyShopButton(){
        myActions.action_click(addToMyShopButton);
    }


    public void selectCollectionToAddProduct(){
//        List<AndroidElement> collectionList =
//                androidDriver.findElements
//                        (By.xpath("//android.widget.TextView[@resource-id='com.shopup.reseller:id/sort_text']"));
//        System.out.println("CollectionList is : "+collectionList);
//        if(collectionList.size()==1){
//            System.out.println("No Collections Found to Add one : " +
//                    "Please add a functionality to add collection from here");
//        }else {
//            Random random = new Random();
//            int item = random.nextInt(collectionList.size());
//            if(item==0) {
//                item = item + 1;
//            }
//            myActions.action_click(collectionList.get(item));
//            System.out.println("Selected Collection is : "+collectionList.get(item).getText());
//        }

        androidDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.shopup.reseller:id/sort_text'][1]")).click();
    }

    public void clickOnPlaceOrderButton(){
        myActions.action_click(placeOrderButton);
    }




}
