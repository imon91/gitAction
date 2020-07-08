package pageObjects;

import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidBaseClass;
import utils.MyActions;

import java.util.List;

public class ProductFilterPageObjects extends AndroidBaseClass {

    private final AndroidDriver<WebElement> androidDriver;
    private final MyActions myActions;
    private final String packageName;

    public ProductFilterPageObjects(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
        packageName = getAppPackage();
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
        List<WebElement> listOfFilterNames =
                xpathListSetter("//android.widget.TextView[@resource-id='"+packageName+":id/filter_name_text']");
        return listOfFilterNames;
    }


    public List<WebElement> getListOfFilterItemCheckBoxes(){
        List<WebElement> listOfFilterItemCheckBoxes =
                xpathListSetter("//android.widget.CheckBox[@resource-id='"+packageName+":id/filter_item_check']");
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
        myActions.action_click(filterName);
    }

    public void clickOnFilterNameByValue(String filterName){
        WebElement element =
                xpathSetter("//android.widget.TextView[@text='"+filterName+"']");
        myActions.action_click(element);
    }

    public void selectFilterItemCheckBox(WebElement filterItemCheckBox){
        myActions.action_click(filterItemCheckBox);
    }

    public void clickOnFilterItemByIndex(WebElement filterItem){
        myActions.action_click(filterItem);
    }

    public void clickOnFilterItemByValue(String filterValue){
        WebElement element =
                xpathSetter("//android.widget.TextView[@text='"+filterValue+"']");
        myActions.action_click(element);

    }

    public void clickOnApplyFilter(){
        applyFilterButton = xpathSetter("//android.widget.Button[@resource-id='"+packageName+":id/apply_filter']");
        myActions.action_click(applyFilterButton);
    }

    public void clickOnClearFilter(){
        clearFilterButton = xpathSetter("//android.widget.Button[@resource-id='"+packageName+":id/clear_filter']");
        myActions.action_click(clearFilterButton);
    }

    public String getCountOnFilterCountText(WebElement filterCountTextElement){
        return myActions.action_getText(filterCountTextElement);
    }

    public Boolean isFilterItemSelected(WebElement filterItemCheckBox){
        return myActions.action_is_selected(filterItemCheckBox);
    }
}
