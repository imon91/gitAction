package pageObjects;

import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import services.commerceMethods.GetCommerceApiResponse;
import services.responseModels.commerceModels.ProductListingResultsModel;
import utils.*;
import java.util.*;

public class ProductListingPageObjects extends AndroidBaseClass{

    private final AndroidDriver<WebElement> androidDriver;
    private final MyActions myActions;
    private final ServiceRequestLayer serviceRequestLayer;
    private final String packageName;

    public ProductListingPageObjects(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        myActions = new MyActions();
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        serviceRequestLayer = new ServiceRequestLayer();
        packageName = getAppPackage();
    }


    // Filter LinearLayout
    private WebElement filterButton;

    // Filter Text
    private WebElement filterText;

    // Sort LinearLayout
    private WebElement sortButton;

    // Filter Text
    private WebElement sortText;

    // Recycler Feed Items
    private WebElement recyclerFeedItem;

    // HeaderContainer RelativeLayout
    private WebElement headerContainer;

    // Header Text
    private WebElement headerText;

    public void getFeedItemRecyclerView(){
        recyclerFeedItem =
                xpathSetter("//androidx.recyclerview.widget.RecyclerView[@resource-id='"+packageName+":id/recycler_feed_item']");
    }

    public void getHeaderContainerRelativeLayout(){
        recyclerFeedItem =
                xpathSetter("//android.widget.RelativeLayout[@resource-id='"+packageName+":id/header_container']");
    }


    public List<WebElement> getItemContainers(){

        List<WebElement> itemContainerList =
                xpathListSetter("//android.widget.RelativeLayout[@resource-id='"+packageName+":id/item_container']");
        return itemContainerList;
    }

    public List<WebElement>  getItemImages(){
        List<WebElement> itemImages =
                xpathListSetter("//android.widget.ImageView[@resource-id='"+packageName+":id/image']");
        return itemImages;
    }

    public List<WebElement> getItemBrands(){
        List<WebElement> itemBrands =
                xpathListSetter("//android.widget.TextView[@resource-id='"+packageName+":id/brand']");
        return itemBrands;
    }

    public List<WebElement> getItemPriceContainers(){
        List<WebElement> itemPriceContainers =
                xpathListSetter("//android.widget.LinearLayout[@resource-id='"+packageName+":id/price_container']");
        return itemPriceContainers;
    }

    public List<WebElement> getItemPrices(){
        List<WebElement> itemPrice =
                xpathListSetter("//android.widget.TextView[@resource-id='"+packageName+":id/price']");
        return itemPrice;
    }

    public List<WebElement> getItemOriginalPrices(){
        List<WebElement> itemOriginalPrice =
                xpathListSetter("//android.widget.TextView[@resource-id='"+packageName+":id/original_price']");
        return itemOriginalPrice;
    }

    public List<WebElement> getItemDiscountPrices(){
        List<WebElement> itemDiscountPrice =
                xpathListSetter("//android.widget.TextView[@resource-id='"+packageName+":id/discount']");
        return itemDiscountPrice;
    }

    public List<WebElement> getListOfStockOutItems(){
        List<WebElement> itemDiscountPrice =
                xpathListSetter("//android.widget.TextView[@resource-id='"+packageName+":id/discount']");
        for(WebElement item : itemDiscountPrice){

        }
        return itemDiscountPrice;
    }


    /*-------Actions---------*/

    public void clickOnFilterButton(){
        filterButton = xpathSetter("//android.widget.LinearLayout[@resource-id='"+packageName+":id/filter_with_sort']");
        myActions.action_click(filterButton);
    }

    public void clickOnSortButton(){
        sortButton = xpathSetter("//android.widget.LinearLayout[@resource-id='"+packageName+":id/sort_app']");
        myActions.action_click(sortButton);
    }

    public String getTextOnFilterButton(){
        filterText = xpathSetter("//android.widget.TextView[@text='Filter']");
        return myActions.action_getText(filterText);
    }

    public String getTextOnSortButton(){
        sortText = xpathSetter("//android.widget.TextView[@text='Sort']");
        return myActions.action_getText(sortText);
    }

    public String getTextOnTitleHeader(){
        headerText = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/title_header_text']");
        return myActions.action_getText(headerText);
    }

    public String getBrandTextForItem(WebElement brandContainer){
        return myActions.action_getText(brandContainer);
    }

    public String getPriceForItem(WebElement priceContainer){
        return myActions.action_getText(priceContainer);
    }

    public String getOriginalPriceForItem(WebElement originalPriceContainer){
        return myActions.action_getText(originalPriceContainer);
    }

    public String getDiscountForItem(WebElement discountContainer){
        return myActions.action_getText(discountContainer);
    }

    public void clickOnProductItem(WebElement productItem){
        myActions.action_click(productItem);
        System.out.println("Element Clicked");
    }

    /*-------Functions-----------*/

    public void selectValidProduct(String searchTerm){
        GetCommerceApiResponse getCommerceApiResponse =
                serviceRequestLayer.getControlOverServices();
        Map<String,Object> productDetails =
                getCommerceApiResponse.getProductWithValidSize(searchTerm);
        int productIndex = (int)productDetails.get("ValidProductIndex"); // Returns product Index
        ProductListingResultsModel.ResultsBean productResult =
                (ProductListingResultsModel.ResultsBean)productDetails.get("ValidProductDetails"); // Returns the Whole Product
        int sizeIndex = (int)productDetails.get("ValidSizeIndex"); // Returns the Valid Size-Id
        System.out.println("Product Index is : "+productIndex);
        System.out.println("Product Name : "+productResult.getName());
        System.out.println("Valid Product Size Index : "+sizeIndex);
        System.setProperty("validProductSizeIndex",""+sizeIndex+"");
        System.setProperty("minSalePrice",
                Integer.toString(productResult.getSizes().get(sizeIndex).getMin_selling_price()));
        System.setProperty("maxSalePrice",
                Integer.toString(productResult.getSizes().get(sizeIndex).getMax_selling_price()));
        // Scroll into View that product by its name and perform click on that
//        System.out.println(androidDriver.findElementByAndroidUIAutomator(
//                "new UiScrollable(new UiSelector().resourceId(\""+packageName+":id/recycler_feed_item\")).scrollIntoView("
//                        + "new UiSelector().text(\""+productResult.getName()+"\"))").getText());
        // Click on that Item
        clickOnProductItem(getItemImages().get(productIndex));
        sleep(2000);
    }


}
