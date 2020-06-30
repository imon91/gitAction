package pageObjects;

import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import services.commerceMethods.GetCommerceApiResponse;
import services.responseModels.commerceModels.ProductListingResultsModel;
import utils.*;

import java.util.List;

public class ProductListingPageObjects extends AndroidBaseClass{

    private AndroidDriver<AndroidElement> androidDriver;
    private MyActions myActions;
    private ServiceRequestLayer serviceRequestLayer;
    private String packageName;
    public ProductListingPageObjects(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
        serviceRequestLayer = new ServiceRequestLayer();
        packageName = getAppPackage();
    }


    // Filter LinearLayout
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.shopup.reseller:id/filter_with_sort']")
    private AndroidElement filterButton;

    // Filter Text
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Filter']")
    private AndroidElement filterText;

    // Sort LinearLayout
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.shopup.reseller:id/sort_app']")
    private AndroidElement sortButton;

    // Filter Text
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sort']")
    private AndroidElement sortText;

    // Recycler Feed Items
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.shopup.reseller:id/recycler_feed_item']")
    private AndroidElement recyclerFeedItem;

    // HeaderContainer RelativeLayout
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@resource-id='com.shopup.reseller:id/header_container']")
    private AndroidElement headerContainer;

    // Header Text
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/title_header_text']")
    private AndroidElement headerText;



    public List<AndroidElement> getItemContainers(){

        List<AndroidElement> itemContainerList =
                androidDriver. findElements(By.
                        xpath("//android.widget.RelativeLayout[@resource-id='com.shopup.reseller:id/item_container']"));
        return itemContainerList;
    }

    public List<AndroidElement>  getItemImages(){
        List<AndroidElement> itemImages =
                androidDriver. findElements(By.
                        xpath("//android.widget.ImageView[@resource-id='com.shopup.reseller:id/image']"));
        return itemImages;
    }

    public List<AndroidElement> getItemBrands(){
        List<AndroidElement> itemBrands =
                androidDriver. findElements(By.
                        xpath("//android.widget.TextView[@resource-id='com.shopup.reseller:id/brand']"));
        return itemBrands;
    }

    public List<AndroidElement> getItemPriceContainers(){
        List<AndroidElement> itemPriceContainers =
                androidDriver. findElements(By.
                        xpath("//android.widget.LinearLayout[@resource-id='com.shopup.reseller:id/price_container']"));
        return itemPriceContainers;
    }

    public List<AndroidElement> getItemPrices(){
        List<AndroidElement> itemPrice =
                androidDriver. findElements(By.
                        xpath("//android.widget.TextView[@resource-id='com.shopup.reseller:id/price']"));
        return itemPrice;
    }

    public List<AndroidElement> getItemOriginalPrices(){
        List<AndroidElement> itemOriginalPrice =
                androidDriver. findElements(By.
                        xpath("//android.widget.TextView[@resource-id='com.shopup.reseller:id/original_price']"));
        return itemOriginalPrice;
    }

    public List<AndroidElement> getItemDiscountPrices(){
        List<AndroidElement> itemDiscountPrice =
                androidDriver. findElements(By.
                        xpath("//android.widget.TextView[@resource-id='com.shopup.reseller:id/discount']"));
        return itemDiscountPrice;
    }

    public List<AndroidElement> getListOfStockOutItems(){
        List<AndroidElement> itemDiscountPrice =
                androidDriver. findElements(By.
                        xpath("//android.widget.TextView[@resource-id='com.shopup.reseller:id/discount']"));
        for(AndroidElement item : itemDiscountPrice){

        }
        return itemDiscountPrice;
    }


    /*-------Actions---------*/

    public void clickOnFilterButton(){
        myActions.action_click(filterButton);
    }

    public void clickOnSortButton(){
        myActions.action_click(sortButton);
    }

    public String getTextOnFilterButton(){
        return myActions.action_getText(filterText);
    }

    public String getTextOnSortButton(){
        return myActions.action_getText(sortText);
    }

    public String getTextOnTitleHeader(){
        return myActions.action_getText(headerText);
    }

    public String getBrandTextForItem(AndroidElement brandContainer){
        return myActions.action_getText(brandContainer);
    }

    public String getPriceForItem(AndroidElement priceContainer){
        return myActions.action_getText(priceContainer);
    }

    public String getOriginalPriceForItem(AndroidElement originalPriceContainer){
        return myActions.action_getText(originalPriceContainer);
    }

    public String getDiscountForItem(AndroidElement discountContainer){
        return myActions.action_getText(discountContainer);
    }

    public void clickOnProductItem(AndroidElement productItem){
        myActions.action_click(productItem);
        System.out.println("Element Clicked");
    }

    /*-------Functions-----------*/

    public void selectValidSizeProduct(String searchTerm){
        GetCommerceApiResponse getCommerceApiResponse =
                serviceRequestLayer.getControlOverServices();
        List productDetails =
                getCommerceApiResponse.getProductWithValidSize(searchTerm);
        int productIndex = (int)productDetails.get(0);
        ProductListingResultsModel.ResultsBean productResult =
                (ProductListingResultsModel.ResultsBean)productDetails.get(1); // Returns the Whole Product
        int sizeIndex = (int)productDetails.get(2); // Returns the Valid Size-Id
        System.out.println("Product Index is : "+productIndex);
        System.out.println("Product Name : "+productResult.getName());
        System.out.println("Valid Product Size Index : "+sizeIndex);
        System.setProperty("validProductSizeIndex",""+sizeIndex+"");
        System.out.println("validProductSizeIndex : "+sizeIndex);
        // Scroll into View that product by its name and perform click on that
//        System.out.println(androidDriver.findElementByAndroidUIAutomator(
//                "new UiScrollable(new UiSelector().resourceId(\"com.shopup.reseller:id/recycler_feed_item\")).scrollIntoView("
//                        + "new UiSelector().text(\""+productResult.getName()+"\"))").getText());
        // Click on that Item
        clickOnProductItem(getItemImages().get(productIndex));
        sleep(5000);
    }

}
