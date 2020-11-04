package pageObjects;


import coreUtils.*;
import io.appium.java_client.*;
import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.*;
import io.appium.java_client.touch.offset.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import services.commerceMethods.*;
import services.responseModels.commerceModels.*;
import utils.*;
import java.util.*;



public class ProductListingPageObjects extends AndroidBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private MyActions myActions;
    private ServiceRequestLayer serviceRequestLayer;
    private String packageName;
    private final String NEW_PLP_VIEW = "New";
    private final String OLD_PLP_VIEW = "Old";
    public String plpView, view_type;
    private GetCommerceApiResponse getCommerceApiResponse;
    private GetPLPModuleApiResponse getPLPModuleApiResponse;
    private String host;


    public ProductListingPageObjects(AndroidDriver<WebElement> androidDriver) {
        this.androidDriver = androidDriver;
        switchFromWebToNative();
        myActions = new MyActions();
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
        serviceRequestLayer = new ServiceRequestLayer();
        getCommerceApiResponse = serviceRequestLayer.getControlOverServices();
        getPLPModuleApiResponse = serviceRequestLayer.getControlOverPLPModuleApiResponse();
        host = System.getProperty(BuildParameterKeys.KEY_HOST);

        packageName = getAppPackage();
        try {
            // Read from the properties file to decide plp_view
            view_type = PropertyReader.getValueOfKey(PropertyReader.Keys.PLP_VIEW_TYPE);
            if (view_type.equalsIgnoreCase("2")) {
                plpView = NEW_PLP_VIEW;
            } else {
                plpView = OLD_PLP_VIEW;
            }
            System.out.println("PLPVIEW is : " + plpView);
        } catch (Exception e) {
            System.out.println("Exception at CATEGORY_TYPE reader in ProductListingPageObjects" + e);
        }
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

    // Variant Selector Spinner(NEW_PLP)
    private WebElement variantSpinner;

    // Margin Value
    private WebElement marginValue;

    // View Items In Cart Button
    private WebElement viewItemsInCartButton;

    // View Items In Cart Text
    private WebElement viewItemsInCartText;

    // PLP BackButton
    private WebElement plpBackButton;


    public void getFeedItemRecyclerView() {

        if (plpView.equalsIgnoreCase(OLD_PLP_VIEW)) {
            recyclerFeedItem =
                    xpathSetter("//androidx.recyclerview.widget.RecyclerView[@resource-id='" + packageName + ":id/recycler_feed_item']");
        } else if (plpView.equalsIgnoreCase(NEW_PLP_VIEW)) {
            recyclerFeedItem =
                    xpathSetter("//androidx.recyclerview.widget.RecyclerView[@resource-id='" + packageName + ":id/recycler_feed_fragment']");
        }

    }

    public void getHeaderContainerRelativeLayout() {
        recyclerFeedItem =
                xpathSetter("//android.widget.RelativeLayout[@resource-id='" + packageName + ":id/header_container']");
    }


    public List<WebElement> getItemContainers() {
        List<WebElement> itemContainerList = null;
        if (plpView.equalsIgnoreCase(OLD_PLP_VIEW)) {
            itemContainerList =
                    xpathListSetter("//android.widget.RelativeLayout[@resource-id='" + packageName + ":id/item_container']");
        } else if (plpView.equalsIgnoreCase(NEW_PLP_VIEW)) {
            itemContainerList =
                    classListSetter("android.view.ViewGroup");
        }
        return itemContainerList;
    }

    public List<WebElement> getItemImages() {
        List<WebElement> itemImages = null;
        if (plpView.equalsIgnoreCase(OLD_PLP_VIEW)) {
            itemImages =
                    xpathListSetter("//android.widget.ImageView[@resource-id='" + packageName + ":id/ecommerce_image']");
        } else if (plpView.equalsIgnoreCase(NEW_PLP_VIEW)) {
            itemImages =
                    xpathListSetter("//android.widget.ImageView[@resource-id='" + packageName + ":id/list_product_image']");
        }
        return itemImages;
    }

    public List<WebElement> getItemBrands() {
        List<WebElement> itemBrands = null;
        if (plpView.equalsIgnoreCase(OLD_PLP_VIEW)) {
            itemBrands = xpathListSetter("//android.widget.TextView[@resource-id='" + packageName + ":id/brand']");
        } else if (plpView.equalsIgnoreCase(NEW_PLP_VIEW)) {
            itemBrands = xpathListSetter("//android.widget.TextView[@resource-id='" + packageName + ":id/list_product_title']");
        }
        return itemBrands;
    }

    public List<WebElement> getItemPriceContainers() {
        List<WebElement> itemPriceContainers =
                xpathListSetter("//android.widget.LinearLayout[@resource-id='" + packageName + ":id/price_container']");
        return itemPriceContainers;
    }

    public List<WebElement> getItemPrices() {
        List<WebElement> itemPrice = null;
        if (plpView.equalsIgnoreCase(OLD_PLP_VIEW)) {
            itemPrice = xpathListSetter("//android.widget.TextView[@resource-id='" + packageName + ":id/price']");
        } else if (plpView.equalsIgnoreCase(NEW_PLP_VIEW)) {
            itemPrice = xpathListSetter("//android.widget.TextView[@resource-id='" + packageName + ":id/list_product_price']");
        }
        return itemPrice;
    }

    public List<WebElement> getItemOriginalPrices() {
        List<WebElement> itemOriginalPrice =
                xpathListSetter("//android.widget.TextView[@resource-id='" + packageName + ":id/original_price']");
        return itemOriginalPrice;
    }

    public List<WebElement> getItemDiscountPrices() {
        List<WebElement> itemDiscountPrice =
                xpathListSetter("//android.widget.TextView[@resource-id='" + packageName + ":id/discount']");
        return itemDiscountPrice;
    }

    public List<WebElement> getListOfStockOutItems() {
        List<WebElement> itemDiscountPrice =
                xpathListSetter("//android.widget.TextView[@resource-id='" + packageName + ":id/discount']");
        for (WebElement item : itemDiscountPrice) {

        }
        return itemDiscountPrice;
    }


    public List<WebElement> getListOfVariantSelectors() {
        // Only New_PLP_View Type has the variant selector
        List<WebElement> variantSelectorList =
                xpathListSetter("//android.widget.TextView[@resource-id='" + packageName + ":id/spinner_variant']");
        return variantSelectorList;
    }


    public List<WebElement> getListOfMarginValues() {
        // Only New_PLP_View Type has the margin value
        List<WebElement> marginValueList =
                xpathListSetter("//android.widget.TextView[@resource-id='" + packageName + ":id/list_product_margin']");
        return marginValueList;
    }


    public List<WebElement> getListOfAddButtons() {
        // Only New_PLP_View Type has the Add Button
        List<WebElement> addButtonList =
                xpathListSetter("//android.widget.TextView[@resource-id='" + packageName + ":id/button_add']");
        return addButtonList;
    }


    public List<WebElement> getListOfAddToCartButtons() {
        // Only New_PLP_View Type has the Add to Cart Button
        List<WebElement> addToCartButtonList =
                xpathListSetter("//android.widget.TextView[@resource-id='" + packageName + ":id/add_to_cart']");
        return addToCartButtonList;
    }


    public List<WebElement> getListOfRemoveFromCartButtons() {
        // Only New_PLP_View Type has the Add to Cart Button
        List<WebElement> addToCartButtonList =
                xpathListSetter("//android.widget.TextView[@resource-id='" + packageName + ":id/remove_from_cart']");
        return addToCartButtonList;
    }


    public List<WebElement> getListOfEditItemCount() {
        // Only New_PLP_View Type has the Add to Cart Button
        List<WebElement> editItemCountList =
                xpathListSetter("//android.widget.EditText[@resource-id='" + packageName + ":id/item_count']");
        return editItemCountList;
    }


    /*-------Actions---------*/

    public void clickOnPLPBackButton(){
        plpBackButton = idSetter(packageName+":id/back_button_feed");
        myActions.action_click(plpBackButton);
    }

    public void clickOnFilterButton() {
        sleep(3000);
        if (plpView.equalsIgnoreCase(OLD_PLP_VIEW)) {
            filterButton = xpathSetter("//android.widget.TextView[@text='Filter']");
        } else if (plpView.equalsIgnoreCase(NEW_PLP_VIEW)) {
            filterButton = xpathSetter("//android.widget.TextView[@text='Filter']");
        }
        myActions.action_click(filterButton);
        System.out.println("Element Clicked");
    }

    public void clickOnSortButton() {
        sleep(3000);
        if (plpView.equalsIgnoreCase(OLD_PLP_VIEW)) {
            sortButton = xpathSetter("//android.widget.TextView[@text='Sort']");
        } else if (plpView.equalsIgnoreCase(NEW_PLP_VIEW)) {
            sortButton = xpathSetter("//android.widget.TextView[@text='Sort']");
        }
        myActions.action_click(sortButton);
    }

    public String getTextOnFilterButton() {
        filterText = xpathSetter("//android.widget.TextView[@text='Filter']");
        return myActions.action_getText(filterText);
    }

    public String getTextOnSortButton() {
        sortText = xpathSetter("//android.widget.TextView[@text='Sort']");
        return myActions.action_getText(sortText);
    }

    public String getTextOnTitleHeader() {
        headerText = xpathSetter("//android.widget.TextView[@resource-id='" + packageName + ":id/title_header_text']");
        return myActions.action_getText(headerText);
    }

    public String getBrandTextForItem(WebElement brandContainer) {
        return myActions.action_getText(brandContainer);
    }

    public String getPriceForItem(WebElement priceContainer) {
        return myActions.action_getText(priceContainer);
    }

    public String getOriginalPriceForItem(WebElement originalPriceContainer) {
        return myActions.action_getText(originalPriceContainer);
    }

    public String getDiscountForItem(WebElement discountContainer) {
        return myActions.action_getText(discountContainer);
    }

    public void clickOnProductItem(WebElement productItem) {
        myActions.action_click(productItem);
        System.out.println("Element Clicked");
    }


    public void clickOnVariantSelector(WebElement variant) {
        myActions.action_click(variant);
    }


    public String getMarginValueOfItem(WebElement variant) {
        return myActions.action_getText(variant);
    }


    public void clickOnAddToCartButton(WebElement addToCartButton) {
        myActions.action_click(addToCartButton);
    }


    public void clickOnRemoveFromCartButton(WebElement removeFromCartButton) {
        myActions.action_click(removeFromCartButton);
    }


    public void enterItemCount(WebElement itemCount, int count) {
        myActions.action_sendKeys(itemCount, Integer.toString(count));
    }

    public void clickOnViewItemsInCartButton() {
        viewItemsInCartButton =
                xpathSetter("//android.widget.FrameLayout[@resource-id='" + packageName + ":id/action_goto_cart']");
        myActions.action_click(viewItemsInCartButton);
    }

    public String getTextOnGoToCartButton() {
        return myActions.action_getText(viewItemsInCartText);
    }



    /*-------Functions-----------*/

    public void selectValidProductToPDP(String searchTerm) {
        Map<String, Object> responseData = null;
        try {
            String filterValueId = PropertyReader.getValueOfKey(PropertyReader.Keys.FILTER_VALUE_ID);
            String sortIndex = PropertyReader.getValueOfKey(PropertyReader.Keys.SORT_INDEX);
            String filterKey = PropertyReader.getValueOfKey(PropertyReader.Keys.FILTER_KEY);

            if (PropertyReader.getValueOfKey(PropertyReader.Keys.FILTER_APPLIED)
                    .equalsIgnoreCase("True")
                    && PropertyReader.getValueOfKey(PropertyReader.Keys.SORT_APPLIED)
                    .equalsIgnoreCase("True")) {
                // Construct Data for params using filterMap and sortIndex
                // FilterMap : <String(Filter_Key),List<String(FilterValues)>>
                //Map<String,List<String>> filterMap = new HashMap<>();
                //List<String> filtersDataList = new ArrayList<>();
                //filterMap.put(filterKey,new ArrayList<>().add())
                responseData = getCommerceApiResponse
                        .getValidProductWithFilterAndSortApplied(searchTerm, filterKey, filterValueId, sortIndex);

            } else if (PropertyReader.getValueOfKey(PropertyReader.Keys.FILTER_APPLIED)
                    .equalsIgnoreCase("False")
                    && PropertyReader.getValueOfKey(PropertyReader.Keys.SORT_APPLIED)
                    .equalsIgnoreCase("False")) {
                // Here both filter and sort aren't applied
                responseData = getCommerceApiResponse.getProductWithValidSize(searchTerm);

            }

            else if(PropertyReader.getValueOfKey(PropertyReader.Keys.FILTER_APPLIED).equalsIgnoreCase("True")&&
                    PropertyReader.getValueOfKey(PropertyReader.Keys.SORT_APPLIED).equalsIgnoreCase("False"))
            {
                //Here Filter applied Only
                responseData = getPLPModuleApiResponse.getValidProductWithFilterOnly(searchTerm,filterKey,filterValueId,1);
            }

            else if(PropertyReader.getValueOfKey(PropertyReader.Keys.FILTER_APPLIED).equalsIgnoreCase("False")&&
                    PropertyReader.getValueOfKey(PropertyReader.Keys.SORT_APPLIED).equalsIgnoreCase("True"))
            {
                //Here sort applied Only
                responseData = getPLPModuleApiResponse.getValidProductWithSortOnly(searchTerm,sortIndex,1);
            }

            PropertyReader.setValue(PropertyReader.Keys.VALID_PRODUCT_INDEX,
                    Integer.toString((int) responseData.get("ValidProductIndex")));
            ProductListingResultsModel.ResultsBean resultsModel =
                    (ProductListingResultsModel.ResultsBean) responseData.get("ValidProductDetails");
            PropertyReader.setValue(PropertyReader.Keys.VALID_PRODUCT_NAME, resultsModel.getName());
            PropertyReader.setValue(PropertyReader.Keys.VALID_PRODUCT_SLUG, resultsModel.getSlug());
            PropertyReader.setValue(PropertyReader.Keys.VALID_SIZE_INDEX,
                    Integer.toString((int) responseData.get("ValidSizeIndex")));

            int productIndex = (int) responseData.get("ValidProductIndex"); // Returns product Index
            ProductListingResultsModel.ResultsBean productResult =
                    (ProductListingResultsModel.ResultsBean) responseData.get("ValidProductDetails"); // Returns the Whole Product
            int sizeIndex = (int) responseData.get("ValidSizeIndex"); // Returns the Valid Size-Id
            System.out.println("Product Index is : " + productIndex);
            System.out.println("Product Name : " + productResult.getName());
            System.out.println("Valid Product Size Index : " + sizeIndex);
            System.setProperty("validProductSizeIndex", "" + sizeIndex + "");
            System.setProperty("minSalePrice",
                    Float.toString(productResult.getSizes().get(sizeIndex).getMin_selling_price()));
            System.setProperty("maxSalePrice",
                    Float.toString(productResult.getSizes().get(sizeIndex).getMax_selling_price()));

            // Update Min and Max sale price to Properties file
            PropertyReader.setValue(PropertyReader.Keys.PRODUCT_MIN_QUANTITY,
                    Float.toString(productResult.getSizes().get(sizeIndex).getMin_selling_price()));
            PropertyReader.setValue(PropertyReader.Keys.PRODUCT_MAX_QUANTITY,
                    Float.toString(productResult.getSizes().get(sizeIndex).getMax_selling_price()));


            // Scroll into View that product by its name and perform click on that
            if(host.equalsIgnoreCase("Local")){
            if (plpView.equalsIgnoreCase(OLD_PLP_VIEW)) {
                System.out.println(androidDriver.findElementByAndroidUIAutomator(
                        "new UiScrollable(new UiSelector().resourceId(\"" + packageName + ":id/recycler_feed_item\")).scrollIntoView("
                                + "new UiSelector().text(\"" + productResult.getName() + "\"))").getText());
            } else if (plpView.equalsIgnoreCase(NEW_PLP_VIEW)) {
                System.out.println(androidDriver.findElementByAndroidUIAutomator(
                        "new UiScrollable(new UiSelector().resourceId(\"" + packageName + ":id/recycler_feed_fragment\")).scrollIntoView("
                                + "new UiSelector().text(\"" + productResult.getName() + "\"))").getText());
            }
            }
                // Click on that Item
                clickOnProductItem(getItemImages().get(productIndex));

        } catch (Exception e) {
            System.out.println("Exception At SelectValidProductToPDP : Updating ProductDetails to DynamicData");
            System.out.println(e);
        }


//        responseData =
//                getCommerceApiResponse.getProductWithValidSize(searchTerm);
//        int productIndex = (int)responseData.get("ValidProductIndex"); // Returns product Index
//        ProductListingResultsModel.ResultsBean productResult =
//                (ProductListingResultsModel.ResultsBean)responseData.get("ValidProductDetails"); // Returns the Whole Product
//        int sizeIndex = (int)responseData.get("ValidSizeIndex"); // Returns the Valid Size-Id
//        System.out.println("Product Index is : "+productIndex);
//        System.out.println("Product Name : "+productResult.getName());
//        System.out.println("Valid Product Size Index : "+sizeIndex);
//        System.setProperty("validProductSizeIndex",""+sizeIndex+"");
//        System.setProperty("minSalePrice",
//                Integer.toString(productResult.getSizes().get(sizeIndex).getMin_selling_price()));
//        System.setProperty("maxSalePrice",
//                Integer.toString(productResult.getSizes().get(sizeIndex).getMax_selling_price()));
//        // Scroll into View that product by its name and perform click on that
//        if(plpView.equalsIgnoreCase(OLD_PLP_VIEW)){
//            System.out.println(androidDriver.findElementByAndroidUIAutomator(
//                    "new UiScrollable(new UiSelector().resourceId(\""+packageName+":id/recycler_feed_item\")).scrollIntoView("
//                            + "new UiSelector().text(\""+productResult.getName()+"\"))").getText());
//            // Click on that Item
//            clickOnProductItem(getItemImages().get(productIndex));
//        }else if(plpView.equalsIgnoreCase(NEW_PLP_VIEW)){
//            System.out.println(androidDriver.findElementByAndroidUIAutomator(
//                    "new UiScrollable(new UiSelector().resourceId(\""+packageName+":id/recycler_feed_fragment\")).scrollIntoView("
//                            + "new UiSelector().text(\""+productResult.getName()+"\"))").getText());
//            // Click on that Item
//            clickOnProductItem(getItemImages().get(productIndex));
//        }
    }

    public void addItemToCartThroughAddQtyPLPMain(int index, int quantity) {
        for (int i = 0; i < quantity; i++) {
            myActions.action_click(getListOfAddToCartButtons().get(index));
        }
    }


    public void addItemToCartThroughEditQtyPLPMain(int index, int quantity) {
        myActions.action_click(getListOfEditItemCount().get(index));
    }


    public void removeItemFromCartThroughSubQtyPLPMain(int index, int quantity) {
        for (int i = 0; i < quantity; i++) {
            myActions.action_click(getListOfRemoveFromCartButtons().get(index));
        }
    }

    public void viewCartThroughNewPlpMain() {

    }


    public class VariantSelectorBottomSheetPageObjects {

        private AndroidDriver<WebElement> androidDriver;
        private MyActions myActions;
        private String packageName;

        public VariantSelectorBottomSheetPageObjects(AndroidDriver<WebElement> androidDriver) {
            this.androidDriver = androidDriver;
            myActions = new MyActions();
            PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
        }

        // newPlpBottomSheetContainer
        private WebElement newPlpBottomSheetContainer;

        // Variant Sheet
        private WebElement variantSheet;

        // Variant Selection pop-up title
        private WebElement variantSelectionPopIpTitle;

        // Variant Selection Name
        private WebElement variantSelectionName;

        // Product Image
        private WebElement productImage;

        // Variant Title
        private WebElement variantTitle;

        // Variant Price
        private WebElement variantPrice;

        // Variant Margin
        private WebElement variantMargin;

        // Button Add
        private WebElement buttonAdd;

        // Button Add to cart
        private WebElement buttonAddToCart;

        // Button Remove from cart
        private WebElement buttonRemoveFromCart;

        // Quantity EditText
        private WebElement enterQuantityEditText;

        // Go to Cart Button
        private WebElement goToCartButton;

        // Continue Shopping Button
        private WebElement continueShoppingButton;


        /*------Actions------*/

        public String getVariantSelectionPopIpTitle() {
            variantSelectionPopIpTitle =
                    xpathSetter("//android.widget.TextView[@resource-id='" + packageName + ":id/variant_selection_popup_title']");
            return myActions.action_getText(variantSelectionPopIpTitle);
        }

        public String getVariantSelectionName() {
            variantSelectionName =
                    xpathSetter("//android.widget.TextView[@resource-id='" + packageName + ":id/variant_selection_name']");
            return myActions.action_getText(variantSelectionName);
        }

        public String getVariantTitle() {
            variantTitle =
                    xpathSetter("//android.widget.TextView[@resource-id='" + packageName + ":id/text_variant_title']");
            return myActions.action_getText(variantTitle);
        }

        public String getVariantPrice() {
            variantPrice =
                    xpathSetter("//android.widget.TextView[@resource-id='" + packageName + ":id/text_variant_price']");
            return myActions.action_getText(variantPrice);
        }

        public String getVariantMargin() {
            variantMargin =
                    xpathSetter("//android.widget.TextView[@resource-id='" + packageName + ":id/text_variant_margin']");
            return myActions.action_getText(variantMargin);
        }

        public void clickOnAddButton() {
            buttonAdd =
                    xpathSetter("//android.widget.TextView[@resource-id='" + packageName + ":id/action_goto_cart']");
            myActions.action_click(buttonAdd);
        }

        public void clickOnIncreaseQtyButton() {
            buttonAddToCart =
                    xpathSetter("//android.widget.TextView[@resource-id='" + packageName + ":id/button_add']");
            myActions.action_click(buttonAddToCart);
        }

        public void clickOnDecreaseQtyButton() {
            buttonRemoveFromCart =
                    xpathSetter("//android.widget.TextView[@resource-id='" + packageName + ":id/remove_from_cart']");
            myActions.action_click(buttonRemoveFromCart);
        }

        public void enterItemQuantity(int qty) {
            enterQuantityEditText =
                    xpathSetter("//android.widget.EditText[@resource-id='" + packageName + ":id/item_count']");
            myActions.action_sendKeys(enterQuantityEditText, Integer.toString(qty));
        }

        public void clickOnGoToCartButton() {
            goToCartButton =
                    xpathSetter("//android.widget.Button[@resource-id='" + packageName + ":id/action_goto_cart_variants']");
            myActions.action_click(goToCartButton);
        }

        public void clickOnContinueShoppingButton() {
            continueShoppingButton =
                    xpathSetter("//android.widget.Button[@resource-id='" + packageName + ":id/action_continue_shopping_variants']");
            myActions.action_click(continueShoppingButton);
        }


        /*--------functions-------*/

        public void addItemToCartInMainThroughPLPBottomSheet() {

        }

        public void addItemToCartThroughPLPBottomSheet(int quantity) {

        }

        public void selectItemAndGoToCartThroughPLPBottomSheet() {

        }

        public void verifyItemAndContinueShoppingThroughPLPBottomSheet() {

        }


    }

    public List<WebElement> productPropertiesListUI(String name_or_price_or_originalPrice_or_discount_or_deliveryTag) {
        List<WebElement> productProperties = null;
        switch (name_or_price_or_originalPrice_or_discount_or_deliveryTag) {
            case ("name"):
                productProperties = idListSetter("com.shopup.reseller:id/brand");
                break;
            case ("price"):
                productProperties = idListSetter("com.shopup.reseller:id/price");
                break;
            case ("originalPrice"):
                productProperties = idListSetter("com.shopup.reseller:id/original_price");
                break;
            case ("discount"):
                productProperties = idListSetter("com.shopup.reseller:id/discount");
                break;
            case ("deliveryTag"):
                productProperties = idListSetter("com.shopup.reseller:id/tags_stock_out");
                break;
        }
        return productProperties;

    }


    public ProductListingResultsModel productResultsPLPApi(String searchTerm, int k,String null_or_filter_or_sort_or_filterSort) throws Exception {
      ProductListingResultsModel productListingResultsModel=null;
        switch (null_or_filter_or_sort_or_filterSort) {
            case ("null"):
                productListingResultsModel = getPLPModuleApiResponse.getProductListingPageResults(searchTerm, k);
            break;
            case ("filter"):
                if (PropertyReader.getValueOfKey(PropertyReader.Keys.FILTER_APPLIED).equalsIgnoreCase("True")) {
                    productListingResultsModel = getPLPModuleApiResponse.getProductResultsWithFilterOnly(searchTerm, PropertyReader.getValueOfKey(PropertyReader.Keys.FILTER_KEY), PropertyReader.getValueOfKey(PropertyReader.Keys.FILTER_VALUE_ID), k);
                    break;
                }
                break;
            case ("sort"):
                if (PropertyReader.getValueOfKey(PropertyReader.Keys.SORT_APPLIED).equalsIgnoreCase("true")) {
                    productListingResultsModel = getPLPModuleApiResponse.getProductResultsWithSortOnly(searchTerm, PropertyReader.getValueOfKey(PropertyReader.Keys.SORT_INDEX), k);
                    break;
                }
                break;
            case ("filterSort"):
                if (PropertyReader.getValueOfKey(PropertyReader.Keys.SORT_APPLIED).equalsIgnoreCase("true") && PropertyReader.getValueOfKey(PropertyReader.Keys.FILTER_APPLIED).equalsIgnoreCase("true")) {
                    productListingResultsModel = getPLPModuleApiResponse.getProductResultsWithFilterAndSortApplied(searchTerm, PropertyReader.getValueOfKey(PropertyReader.Keys.FILTER_KEY), PropertyReader.getValueOfKey(PropertyReader.Keys.FILTER_VALUE_ID), PropertyReader.getValueOfKey(PropertyReader.Keys.SORT_INDEX), k);
                    break;
                }
        }
        return productListingResultsModel;
    }


    public String namesListOfProduct(int index) {
        String names = myActions.action_getText(productPropertiesListUI("name").get(index));
        return names;
    }

    public List<String> getDetailsOfProductContainerUI(int productIndex) {
        List<String> productDataContainer = new ArrayList<>(5);
        String productPrice = myActions.action_getText(productPropertiesListUI("price").get(productIndex));
        productDataContainer.add(0,productPrice);
        String productOriginalPrice = myActions.action_getText(productPropertiesListUI("originalPrice").get(productIndex));
        productDataContainer.add(1,productOriginalPrice);

        if(productIndex<productPropertiesListUI("discount").size()){
            String productDiscount = myActions.action_getText(productPropertiesListUI("discount").get(productIndex));
            String discountNumberOnly = productDiscount.replaceAll("[^0-9]", "");
            productDataContainer.add(2,discountNumberOnly);
        }

        if(productIndex < productPropertiesListUI("deliveryTag").size()){
            String productDeliveryTag = myActions.action_getText(productPropertiesListUI("deliveryTag").get(productIndex));
            productDataContainer.add(3,productDeliveryTag);
        }


        return productDataContainer;
    }

    public void verifyScroll() {

        WebElement ele1 = xpathSetter("//android.widget.RelativeLayout[@resource-id='com.shopup.reseller:id/item_container']");
        WebElement ele2 = xpathSetter("//android.widget.LinearLayout[@resource-id='com.shopup.reseller:id/filter_with_sort']");
        int startX = ele1.getLocation().getX() + (ele1.getSize().getWidth() / 2);
        int startY = ele1.getLocation().getY() + (ele1.getSize().getHeight());
        int endX = ele2.getLocation().getX() + (ele2.getSize().getWidth() / 2);
        int endY = ele2.getLocation().getY() + (ele2.getSize().getHeight() / 2);
        // Take the parent Element : 1st container
        new TouchAction(androidDriver).press(PointOption.point(startX, startY))
                .moveTo(PointOption.point(endX, endY))
                .perform().release();
    }

    public int totalNumberOfPages(String searchTerm,String null_or_filter_or_sort_or_filterSort) throws Exception {
        int productCount=0;

        switch (null_or_filter_or_sort_or_filterSort) {
            case ("null"):
                productCount = productResultsPLPApi(searchTerm, 1,"null").getProducts_count();
                break;
            case ("filter"):
                if (PropertyReader.getValueOfKey(PropertyReader.Keys.FILTER_APPLIED).equalsIgnoreCase("True")) {
                    productCount = getPLPModuleApiResponse.getProductResultsWithFilterOnly(searchTerm,PropertyReader.getValueOfKey(PropertyReader.Keys.FILTER_KEY),PropertyReader.getValueOfKey(PropertyReader.Keys.FILTER_VALUE_ID),1).getProducts_count();
                    break;
                }
                break;
            case ("sort"):
                if (PropertyReader.getValueOfKey(PropertyReader.Keys.SORT_APPLIED).equalsIgnoreCase("true")) {
                    productCount = getPLPModuleApiResponse.getProductResultsWithSortOnly(searchTerm,PropertyReader.getValueOfKey(PropertyReader.Keys.SORT_INDEX),1).getProducts_count();
                    break;
                }
                break;
            case ("filterSort"):
                if (PropertyReader.getValueOfKey(PropertyReader.Keys.SORT_APPLIED).equalsIgnoreCase("true") && PropertyReader.getValueOfKey(PropertyReader.Keys.FILTER_APPLIED).equalsIgnoreCase("true")) {
                    productCount = getPLPModuleApiResponse.getProductResultsWithFilterAndSortApplied(searchTerm,PropertyReader.getValueOfKey(PropertyReader.Keys.FILTER_KEY),PropertyReader.getValueOfKey(PropertyReader.Keys.FILTER_VALUE_ID),PropertyReader.getValueOfKey(PropertyReader.Keys.SORT_INDEX),1).getProducts_count();
                    break;
                }
        }

        double total = Math.ceil(productCount / 12.0);
        int totalPages = (int) total;
        return totalPages;
    }



    public void selectValidProductToPDPAfterFilterOnly(String searchTerm, int k) {
        Map<String, Object> responseData = null;
        try {
            String filterValueId = PropertyReader.getValueOfKey(PropertyReader.Keys.FILTER_VALUE_ID);
            String filterKey = PropertyReader.getValueOfKey(PropertyReader.Keys.FILTER_KEY);

            if (PropertyReader.getValueOfKey(PropertyReader.Keys.FILTER_APPLIED)
                    .equalsIgnoreCase("True")&&PropertyReader.getValueOfKey(PropertyReader.Keys.SORT_APPLIED).equalsIgnoreCase("False")) {
                responseData = getPLPModuleApiResponse.getValidProductWithFilterOnly(searchTerm, filterKey, filterValueId, k);

            } else if (PropertyReader.getValueOfKey(PropertyReader.Keys.FILTER_APPLIED)
                    .equalsIgnoreCase("False")&&PropertyReader.getValueOfKey(PropertyReader.Keys.SORT_APPLIED).equalsIgnoreCase("False")) {
                // Here both filter and sort aren't applied
                responseData = getCommerceApiResponse.getProductWithValidSize(searchTerm);
            }

            PropertyReader.setValue(PropertyReader.Keys.VALID_PRODUCT_INDEX,
                    Integer.toString((int) responseData.get("ValidProductIndex")));
            ProductListingResultsModel.ResultsBean resultsModel =
                    (ProductListingResultsModel.ResultsBean) responseData.get("ValidProductDetails");
            PropertyReader.setValue(PropertyReader.Keys.VALID_PRODUCT_NAME, resultsModel.getName());
            PropertyReader.setValue(PropertyReader.Keys.VALID_PRODUCT_SLUG, resultsModel.getSlug());
            PropertyReader.setValue(PropertyReader.Keys.VALID_SIZE_INDEX,
                    Integer.toString((int) responseData.get("ValidSizeIndex")));

            int productIndex = (int) responseData.get("ValidProductIndex"); // Returns product Index
            ProductListingResultsModel.ResultsBean productResult =
                    (ProductListingResultsModel.ResultsBean) responseData.get("ValidProductDetails"); // Returns the Whole Product
            int sizeIndex = (int) responseData.get("ValidSizeIndex"); // Returns the Valid Size-Id
            System.out.println("Product Index is : " + productIndex);
            System.out.println("Product Name : " + productResult.getName());
            System.out.println("Valid Product Size Index : " + sizeIndex);
            System.setProperty("validProductSizeIndex", "" + sizeIndex + "");
            System.setProperty("minSalePrice",
                    Float.toString(productResult.getSizes().get(sizeIndex).getMin_selling_price()));
            System.setProperty("maxSalePrice",
                    Float.toString(productResult.getSizes().get(sizeIndex).getMax_selling_price()));

            // Update Min and Max sale price to Properties file
            PropertyReader.setValue(PropertyReader.Keys.PRODUCT_MIN_QUANTITY,
                    Float.toString(productResult.getSizes().get(sizeIndex).getMin_selling_price()));
            PropertyReader.setValue(PropertyReader.Keys.PRODUCT_MAX_QUANTITY,
                    Float.toString(productResult.getSizes().get(sizeIndex).getMax_selling_price()));
            clickOnProductItem(getItemImages().get(productIndex));

        } catch (Exception e) {
            System.out.println("Exception At SelectValidProductToPDP : Updating ProductDetails to DynamicData");
            System.out.println(e);

        }

    }





}


