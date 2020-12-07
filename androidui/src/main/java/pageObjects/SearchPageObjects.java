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




public class SearchPageObjects extends AndroidBaseClass {


    private AndroidDriver<WebElement> androidDriver;
    private MyActions myActions;
    private String packageName;
    private ServiceRequestLayer serviceRequestLayer;
    private GetSearchSuggestionsApiResponse getSearchSuggestionsApiResponse;
    private String app;
    TouchAction touchActions;
    private Random random;


    public SearchPageObjects(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
        packageName = getAppPackage();
        serviceRequestLayer = new ServiceRequestLayer();
        touchActions = new TouchAction(androidDriver);
        getSearchSuggestionsApiResponse = serviceRequestLayer.getControlOverSearchSuggestionsApi();
        app = System.getProperty(BuildParameterKeys.KEY_APP);
        random = new Random();
    }




    // Back Button
    private WebElement searchBackButton;

    // Search EditText
    private WebElement searchBarEditText;

    // Search Button
    private WebElement searchButton;

    // Search Cancel Button
    private WebElement searchCancelButton;

    // Recent Searches TextView
    private List<WebElement> recentSearchesText;

    // Recent Suggestions RecyclerView
    private WebElement recentSuggestionsRecycler;

    //recent Viewed Container
    private WebElement recentlyViewedContainer;




    /*--------------Actions-------------------*/

    public void clickOnSearchBackButton(){
        searchBackButton = xpathSetter("//android.widget.ImageView[@resource-id='"+packageName+":id/btnBack']");
        myActions.action_click(searchBackButton);
    }

    public WebElement getSearchBackButtonElement(){
        return xpathSetter("//android.widget.ImageView[@resource-id='"+packageName+":id/btnBack']");
    }

    public WebElement getSearchButtonElement(){
        return xpathSetter("//android.widget.ImageView[@resource-id='"+packageName+":id/btnSearch']");
    }

    public WebElement searchBarEditText()
    {
        return searchBarEditText = xpathSetter("//android.widget.EditText[@resource-id='"+packageName+":id/etSearch']");
    }

    public void enterProductName(String product){
        myActions.action_sendKeys(searchBarEditText(),product);
    }

    public void clickOnSearchButton(String product){
        searchButton = xpathSetter("//android.widget.ImageView[@resource-id='"+packageName+":id/btnSearch']");
        myActions.action_click(searchButton);
        // search_for_users_call to update DynamicData
        try {
            PropertyReader.setValue(PropertyReader.Keys.SEARCH_TERM,product);
            Map<String,Object> responseData = serviceRequestLayer.getControlOverServices()
                    .getProductWithValidSize(product);
            ProductListingResultsModel.ResultsBean resultsModel =
                    (ProductListingResultsModel.ResultsBean)responseData.get("ValidProductDetails");
            System.out.println("PLP VIEW TYPE : "+resultsModel.getPlp_view_type());
            if(resultsModel.getPlp_view_type()==2) {
                PropertyReader.setValue(PropertyReader.Keys.CATEGORY_TYPE, AndroidAppConstants.CATEGORY_TYPE_ESSENTIAL);
                PropertyReader.setValue(PropertyReader.Keys.PLP_VIEW_TYPE, "2");
            }
            else {
                PropertyReader.setValue(PropertyReader.Keys.CATEGORY_TYPE, AndroidAppConstants.CATEGORY_TYPE_NON_ESSENTIAL);
                PropertyReader.setValue(PropertyReader.Keys.PLP_VIEW_TYPE, "1");
            }
        }catch (Exception e){
            System.out.println("Exception At EnterProductName : Adding SEARCH_TERM to DynamicData");
        }
//        try{
//            Map<String,Object> responseData = serviceRequestLayer.getControlOverServices()
//                    .getProductWithValidSize(PropertyReader.getValueOfKey(PropertyReader.Keys.SEARCH_TERM));
////            PropertyReader.setValue(PropertyReader.Keys.VALID_PRODUCT_INDEX,
////                    Integer.toString((int)responseData.get("ValidProductIndex")));
//            ProductListingResultsModel.ResultsBean resultsModel =
//                    (ProductListingResultsModel.ResultsBean)responseData.get("ValidProductDetails");
//            if(resultsModel.getPlp_view_type()==2)
//                PropertyReader.setValue(PropertyReader.Keys.CATEGORY_TYPE,AndroidAppConstants.CATEGORY_TYPE_ESSENTIAL);
//            else
//                PropertyReader.setValue(PropertyReader.Keys.CATEGORY_TYPE,AndroidAppConstants.CATEGORY_TYPE_NON_ESSENTIAL);
//            PropertyReader.setValue(PropertyReader.Keys.VALID_PRODUCT_NAME,resultsModel.getName());
//            PropertyReader.setValue(PropertyReader.Keys.VALID_PRODUCT_SLUG,resultsModel.getSlug());
//            PropertyReader.setValue(PropertyReader.Keys.VALID_SIZE_INDEX,
//                    Integer.toString((int)responseData.get("ValidSizeIndex")));
//        }catch (Exception e){
//            System.out.println("Exception At ClickOnSearchButton : Updating SEARCH_RESULT to DynamicData");
//            System.out.println(e);
//        }
    }

    public void clickOnSearchCancelButton(){
        searchCancelButton = xpathSetter("//android.widget.ImageView[@resource-id='"+packageName+":id/imgClear']");
        myActions.action_click(searchCancelButton);
    }

    public List<WebElement> getListOfRecentSearchesText(){
        recentSearchesText =
                xpathListSetter("//android.widget.TextView[@resource-id='"+packageName+":id/trending']");
        return recentSearchesText;
    }

    public void getSuggestionsRecycler(){
        recentSuggestionsRecycler =
                xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/suggestions_recycler_recent']");
    }

    public String getRecentlyViewedText(){
        WebElement element = idSetter("com.mokam.app:id/title_widget");
        return myActions.action_getText(element);
    }

    /*----Functions*/


    public void searchForTheGivenProduct(String productName){
        enterProductName(productName);
        clickOnSearchButton(productName);
    }

    public void enterTheProductNameAndCancel(String productName){
        enterProductName(productName);
        clickOnSearchCancelButton();
    }

    public void enterTheProductNameGoBack(String productName){
        enterProductName(productName);
        int randomFunction = random.nextInt(2);
        if (randomFunction == 0) {
            androidDriver.navigate().back();
        } else
        { clickOnSearchBackButton(); }}

    public String clickOnSearchSuggestion(int suggestionIndex)
    {
        List<WebElement> suggestionTitleList = androidDriver.findElements(By.id(packageName+":id/text"));
        String suggestionText = null;
        if(suggestionIndex>=0) {
            suggestionText = myActions.action_getText(suggestionTitleList.get(suggestionIndex));
            myActions.action_click(suggestionTitleList.get(suggestionIndex));
        }
        return suggestionText;
    }

    //_____________*API Responses Handling*__________________//

    public List<SearchSuggestionsModel.ResultsBean.SuggestionsBean> searchSuggestionListFromApi(String searchTerm)
    {
        return getSearchSuggestionsApiResponse.searchSuggestionsList(searchTerm);
    }


    public List<SearchRecentProductsModel.ResultsBean> getResultsOfRecentProductsFromApiList()
    {
        return getSearchSuggestionsApiResponse.getResultsOfRecentProducts();
    }



    //------------*lists getting function*---------------//

    public List<WebElement> searchSuggestionTitleListUI()
    {
        List<WebElement> suggestionTitleList = androidDriver.findElements(By.id(packageName+":id/text"));
        return suggestionTitleList;
    }

    public List<WebElement> searchSuggestionInLineLabelListUI()
    {
        List<WebElement> suggestionTitleList = androidDriver.findElements(By.id(packageName+":id/inlineLabel"));
        return suggestionTitleList;
    }

    public List<WebElement> searchRecentProductsNameListUI()
    {
        List<WebElement> nameList = androidDriver.findElements(By.id(packageName+":id/tvName"));
        return nameList;
    }

    public List<WebElement> getListOfRecentProductsPropertiesUI(String price_or_originalPrice_or_deliveryTag_or_discount)
    {
        List<WebElement> propertiesList = null;
        switch (price_or_originalPrice_or_deliveryTag_or_discount)
        {
            case ("price") :
                propertiesList = androidDriver.findElements(By.id(packageName+":id/tvSellingPrice"));
            break;
            case ("originalPrice") :
                propertiesList = androidDriver.findElements(By.id(packageName+":id/tvRealPrice"));
                break;
            case ("deliveryTag") :
                propertiesList =   androidDriver.findElements(By.id(packageName+":id/tvTag"));
                break;
            case ("discount") :
                propertiesList = androidDriver.findElements(By.id(packageName+":id/tvDiscount"));
                break;
        }
        return propertiesList;
    }



    //*-------------Getting data part---------------*//

    public String getSearchSuggestionDataFromUI(int suggestionIndex,String title_or_inline) {
        String suggestionText = null;
        System.out.println("the size of list was :"+searchSuggestionTitleListUI().size());
        if(suggestionIndex>=0&&title_or_inline.equalsIgnoreCase("title")) {
            suggestionText = myActions.action_getText(searchSuggestionTitleListUI().get(suggestionIndex));
            return suggestionText;
        }
        else if(suggestionIndex>=0&&title_or_inline.equalsIgnoreCase("inLineLabel"))
        {
            suggestionText = myActions.action_getText(searchSuggestionInLineLabelListUI().get(suggestionIndex));
            return suggestionText;
        }
        else {
            System.out.println("Please specify the proper litter 'title'_or_'inLineLabel'");
        return null;
        }

    }

    public List<String> recentProductContainerDataFromUI(int indexOfUIContainer) {

        List<String> listOfStringsOfContainer = new ArrayList<>();
        String priceFromUI = myActions.action_getText(getListOfRecentProductsPropertiesUI("price").get(indexOfUIContainer));
        String originalPriceFromUI = myActions.action_getText(getListOfRecentProductsPropertiesUI("originalPrice").get(indexOfUIContainer));
        String deliveryTagFromUI = myActions.action_getText(getListOfRecentProductsPropertiesUI("deliveryTag").get(indexOfUIContainer));
        String productDiscount = myActions.action_getText(getListOfRecentProductsPropertiesUI("discount").get(indexOfUIContainer));
        String discountNumberOnly = productDiscount.replaceAll("[^0-9]","");

        listOfStringsOfContainer.add(0, priceFromUI);
        listOfStringsOfContainer.add(1, originalPriceFromUI);
        listOfStringsOfContainer.add(2, deliveryTagFromUI);
        listOfStringsOfContainer.add(discountNumberOnly);
        return listOfStringsOfContainer;
    }


    public boolean scrollToElement(String productName)
    {

        WebElement element = androidDriver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\""+packageName+":id/recyclerRecentlyViewed\")).setAsHorizontalList().scrollIntoView("
                        + "new UiSelector().text(\""+productName+ "\"))"));
        String text =element.getText();
        return true;
    }

    public boolean scrollToElementSearchBar(String productName)
    {
        WebElement element = androidDriver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\""+packageName+":id/etSearch\")).setAsHorizontalList().scrollIntoView("
                        + "new UiSelector().text(\""+productName+ "\"))"));
        String text =element.getText();
        return true;
    }

    public boolean scrollToElementSearchSuggestion(String productName)
    {

        WebElement element = androidDriver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\""+packageName+":id/suggestions_recycler\")).scrollIntoView("
                        + "new UiSelector().text(\""+productName+ "\"))"));
        String text =element.getText();
        return true;
    }

    public boolean verifyScroll() {

            WebElement ele1 = xpathSetter("//android.widget.LinearLayout[@resource-id='com.shopup.reseller:id/item']");
            WebElement ele2 = xpathSetter("//android.widget.LinearLayout[@resource-id='com.shopup.reseller:id/search_recently_viewed_container']");
            int startX = ele1.getLocation().getX() + (ele1.getSize().getWidth()/2);
            int startY = ele1.getLocation().getY() + (ele1.getSize().getHeight()/2);
            int endX = ele2.getLocation().getX();
            int endY = ele2.getLocation().getY() + (ele2.getSize().getHeight()/2);
            // Take the parent Element : 1st container
            new TouchAction(androidDriver).press(PointOption.point(startX, startY))
                    .moveTo(PointOption.point(endX, endY))
                    .perform().release();
            return true;

    }

    public boolean recentlyViewedContainerVisibility()
    {
        try{
        recentlyViewedContainer = xpathSetter("//android.widget.TextView[@text='RECENTLY VIEWED']");
        myActions.action_getText(recentlyViewedContainer);
        System.out.print("Recently viewed container was visible successfully");
        return true;
        }
        catch (Exception e){
            System.out.print("Verification of recently viewed container non visibility");
        return false;
        }
    }


}
