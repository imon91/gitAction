package pageObjects;

import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

import java.util.List;

public class ProductFilterPageObjects {

    private AndroidDriver<AndroidElement> androidDriver;
    private MyActions myActions;

    public ProductFilterPageObjects(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
    }


    // FilterNames RecyclerView
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.shopup.reseller:id/filter_names_recycler']")
    private AndroidElement filterNamesContainer;

    // FilterNames RecyclerView
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.shopup.reseller:id/filter_items_recycler']")
    private AndroidElement filterItemsContainer;

    // Clear Filter Button
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.shopup.reseller:id/clear_filter']")
    private AndroidElement clearFilterButton;

    // Apply Filter Button
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.shopup.reseller:id/apply_filter']")
    private AndroidElement applyFilterButton;


    public List<AndroidElement> getListOfFilterNames(){
        List<AndroidElement> listOfFilterNames =
                androidDriver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.shopup.reseller:id/filter_name_text']"));
        return listOfFilterNames;
    }


    public List<AndroidElement> getListOfFilterItemCheckBoxes(){
        List<AndroidElement> listOfFilterItemCheckBoxes =
                androidDriver.findElements(By.xpath("//android.widget.CheckBox[@resource-id='com.shopup.reseller:id/filter_item_check']"));
        return listOfFilterItemCheckBoxes;
    }

    public List<AndroidElement> getListOfFilterItems(){
        List<AndroidElement> listOfFilterItemTexts =
                androidDriver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.shopup.reseller:id/filter_item_text']"));
        return listOfFilterItemTexts;
    }

    public List<AndroidElement> getListOfFilterCountText(){
        List<AndroidElement> listOfFilterCountTexts =
                androidDriver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.shopup.reseller:id/filter_count_text']"));
        return listOfFilterCountTexts;
    }

    public List<AndroidElement> getListOfOutStockElements(){
        List<AndroidElement> listOfFilterCountTexts =
                androidDriver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.shopup.reseller:id/tags_stock_out']"));
        return listOfFilterCountTexts;
    }



    /*------------Actions-----------*/

    public void clickOnFilterName(AndroidElement filterName){
        myActions.action_click(filterName);
    }

    public void selectFilterItemCheckBox(AndroidElement filterItemCheckBox){
        myActions.action_click(filterItemCheckBox);
    }

    public void clickOnFilterItemByIndex(AndroidElement filterItem){
        myActions.action_click(filterItem);
    }

    public void clickOnFilterItemByValue(String filterValue){
        AndroidElement element =
                androidDriver.findElementByXPath("//android.widget.TextView[@text='"+filterValue+"']");
        myActions.action_click(element);

    }

    public void clickOnApplyFilter(){
        myActions.action_click(applyFilterButton);
    }

    public void clickOnClearFilter(){
        myActions.action_click(clearFilterButton);
    }

    public String getCountOnFilterCountText(AndroidElement filterCountTextElement){
        return myActions.action_getText(filterCountTextElement);
    }

    public Boolean isFilterItemSelected(AndroidElement filterItemCheckBox){
        return myActions.action_is_selected(filterItemCheckBox);
    }
}
