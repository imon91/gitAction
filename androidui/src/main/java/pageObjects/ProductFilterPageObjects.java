package pageObjects;

import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.*;
import java.util.*;

import static services.serviceUtils.ApiKeyConstants.FiltersNewKeys.*;

public class ProductFilterPageObjects extends AndroidBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private MyActions myActions;
    private String packageName;
    private String plp_view;
    private final String NEW_PLP_VIEW = "New";
    private final String OLD_PLP_VIEW = "Old";
    private ServiceRequestLayer serviceRequestLayer;

    public ProductFilterPageObjects(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
        packageName = getAppPackage();
        plp_view = new ProductListingPageObjects(androidDriver).plpView;
        serviceRequestLayer = new ServiceRequestLayer();
    }


    // FilterNames RecyclerView
    private WebElement filterNamesContainer;

    // FilterNames RecyclerView
    private WebElement filterItemsContainer;

    // Clear Filter Button
    private WebElement clearFilterButton;

    // Apply Filter Button
    private WebElement applyFilterButton;


    public List<WebElement> getListOfFilterNames(){
        List<WebElement> listOfFilterNames = null;
        if(plp_view.equalsIgnoreCase(OLD_PLP_VIEW)) {
            listOfFilterNames =
                    xpathListSetter("//android.widget.TextView[@resource-id='" + packageName + ":id/filter_name']");
        }else if(plp_view.equalsIgnoreCase(NEW_PLP_VIEW)){
            listOfFilterNames  =
                    xpathListSetter("//android.widget.TextView[@resource-id='"+packageName+":id/filter_name']");
        }
        return listOfFilterNames;
    }


    public List<WebElement> getListOfFilterItemCheckBoxes(){
        List<WebElement> listOfFilterItemCheckBoxes = null;
        if(plp_view.equalsIgnoreCase(NEW_PLP_VIEW)){
            listOfFilterItemCheckBoxes  =
                    xpathListSetter("//android.widget.CheckBox[@resource-id='"+packageName+":id/checkbox_sub_filter']");
        }else if(plp_view.equalsIgnoreCase(OLD_PLP_VIEW)){
            listOfFilterItemCheckBoxes  =
                    xpathListSetter("//android.widget.CheckBox[@resource-id='"+packageName+":id/checkbox_sub_filter']");
        }
        return listOfFilterItemCheckBoxes;
    }

    public List<WebElement> getListOfFilterItems(){
        List<WebElement> listOfFilterItemTexts =
                xpathListSetter("//android.widget.TextView[@resource-id='"+packageName+":id/filter_item_text']");
        return listOfFilterItemTexts;
    }

    public List<WebElement> getListOfFilterCountText(){
        List<WebElement> listOfFilterCountTexts =
                xpathListSetter("//android.widget.TextView[@resource-id='"+packageName+":id/filter_count_text']");
        return listOfFilterCountTexts;
    }

    public List<WebElement> getListOfOutStockElements(){
        List<WebElement> listOfFilterCountTexts =
                xpathListSetter("//android.widget.TextView[@resource-id='"+packageName+":id/tags_stock_out']");
        return listOfFilterCountTexts;
    }



    /*------------Actions-----------*/

    public void getFilterNamesContainer(){
        filterNamesContainer =
                xpathSetter("//androidx.recyclerview.widget.RecyclerView[@resource-id='"+packageName+":id/filter_names_recycler']");
    }


    public void getFilterItemsContainer(){
        filterItemsContainer =
                xpathSetter("//androidx.recyclerview.widget.RecyclerView[@resource-id='"+packageName+":id/filter_items_recycler']");
    }

    public void clickOnFilterName(WebElement filterName){
        try{
            PropertyReader.setValue(PropertyReader.Keys.FILTER_KEY,filterName.getText());
            myActions.action_click(filterName);
        }catch (Exception e){
            System.out.println("Exception At ClickOnFilterName : While updating FILTER_KEY Property");
        }
    }

    public void clickOnFilterNameByValue(String filterName){
        WebElement element =
                xpathSetter("//android.widget.CheckBox[@text='"+filterName+"']");
            myActions.action_click(element);
    }

    public void selectFilterItemCheckBox(WebElement filterItemCheckBox){
        myActions.action_click(filterItemCheckBox);
    }

    public void clickOnFilterItemByIndex(WebElement filterItem){
        try{
            String filterValue = filterItem.getText();
            PropertyReader.setValue(PropertyReader.Keys.FILTER_VALUE,filterValue);
            System.out.println("Filter Value is : " + filterValue);
            // Get Filter_Category_Id
            HashMap<String, HashMap<String,List<String>>> productDetails =
                    serviceRequestLayer.getControlOverServices().getFiltersDataMap(
                            PropertyReader.getValueOfKey(PropertyReader.Keys.SEARCH_TERM));
            System.out.println("Filter Key : "+ PropertyReader.getValueOfKey(PropertyReader.Keys.FILTER_KEY));
            List<String> filterLabelList = productDetails
                    .get(PropertyReader.getValueOfKey(PropertyReader.Keys.FILTER_KEY).toLowerCase())
                    .get(KEY_LABEL);
            System.out.println("Filters Label List : "+filterLabelList);
            for(int i=0;i<filterLabelList.size();i++){
                if(filterLabelList.get(i).equalsIgnoreCase(filterValue)){
                    // Here we got the filter label index
                    // With the filter label index, find out filter id
                    String filterId =
                            productDetails.get(PropertyReader.getValueOfKey(PropertyReader.Keys.FILTER_KEY).toLowerCase()).get(KEY_ID).get(i);
                    System.out.println("FilterId : "+filterId);
                    try{
                        PropertyReader.setValue(PropertyReader.Keys.FILTER_VALUE_ID,filterId);
                    }catch (Exception e){
                        System.out.println("Exception At ClickOnFilterItemByIndex : While updating FILTER_VALUE_ID Property");
                    }
                    break;
                }else {
                    //System.out.println(filterLabelList.get(i)+" : Did not match with : "+filterValue);
                }
            }
            myActions.action_click(filterItem);
        }catch (Exception e){
            System.out.println("Exception At ClickOnFilterItemByIndex : While updating FILTER_VALUE Property");
        }
    }


    public void clickOnFilterItemByValue(String filterValue){
        WebElement element =
                xpathSetter("//android.widget.TextView[@text='"+filterValue+"']");
        myActions.action_click(element);

    }

    public void clickOnApplyFilter(){
        applyFilterButton = xpathSetter("//android.widget.Button[@text='APPLY']");
        try{
            PropertyReader.setValue(PropertyReader.Keys.FILTER_APPLIED,"True");
            myActions.action_click(applyFilterButton);
        }catch (Exception e) {
            System.out.println("Exception At ClickOnApplyFilter : While updating FILTER_APPLIED Property");
        }
    }

    public void clickOnClearFilter(){
        clearFilterButton = xpathSetter("//android.widget.Button[@text='CLEAR']");
        myActions.action_click(clearFilterButton);
    }

    public String getCountOnFilterCountText(WebElement filterCountTextElement){
        return myActions.action_getText(filterCountTextElement);
    }

    public Boolean isFilterItemSelected(WebElement filterItemCheckBox){
        return myActions.action_is_selected(filterItemCheckBox);
    }
}
