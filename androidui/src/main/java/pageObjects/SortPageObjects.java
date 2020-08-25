package pageObjects;

import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.*;
import java.util.*;

public class SortPageObjects extends AndroidBaseClass{


    private AndroidDriver<WebElement> androidDriver;
    private MyActions myActions;
    private String packageName;
    private final String NEW_PLP_VIEW = "New";
    private final String OLD_PLP_VIEW = "Old";
    public String plpView,view_type;
    private ServiceRequestLayer serviceRequestLayer;


    public SortPageObjects(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
        packageName = getAppPackage();
        try{
            // Read from the properties file to decide plp_view
            view_type = PropertyReader.getValueOfKey(PropertyReader.Keys.PLP_VIEW_TYPE);
            if(view_type.equalsIgnoreCase("2")){
                plpView = NEW_PLP_VIEW;
            }else {
                plpView = OLD_PLP_VIEW;
            }
            System.out.println("PLPVIEW is : "+plpView);
        }catch (Exception e){
            System.out.println("Exception at CATEGORY_TYPE reader in SortPageObjects" + e);
        }
        serviceRequestLayer = new ServiceRequestLayer();
    }


    // Sort Items Container
    private WebElement sortRecycler;

    public void getSortRecycler(){
        sortRecycler =
                xpathSetter("//androidx.recyclerview.widget.RecyclerView[@resource-id='"+packageName+":id/sort_recycler']");
    }


    public List<WebElement> getSortTexts(){
        List<WebElement> sortTextList = null;
//        if(plpView.equalsIgnoreCase(NEW_PLP_VIEW)){
            sortTextList =
                    xpathListSetter("//android.widget.TextView[@resource-id='"+packageName+":id/sort_item_text']");
//        }else if(plpView.equalsIgnoreCase(OLD_PLP_VIEW)){
//            sortTextList =
//                    xpathListSetter("//android.widget.TextView[@resource-id='"+packageName+":id/sort_text']");
//        }
        return sortTextList;
    }


    public void clickOnSortElement(String sortText){
        WebElement sortElement = xpathSetter("//android.widget.TextView[@text='"+ sortText +"']");
        try{
            String sortIndex=null;
            myActions.action_click(sortElement);
            PropertyReader.setValue(PropertyReader.Keys.SORT_APPLIED,"True");
            PropertyReader.setValue(PropertyReader.Keys.SORT_VALUE,sortText);
            // Update SORT_VALUE Index

//            List<String> sortItems = serviceRequestLayer.getControlOverServices()
//                    .getListOfSortItems(
//                            PropertyReader.getValueOfKey(PropertyReader.Keys.SEARCH_TERM));

            switch (sortText){
                case "By Relevance" : sortIndex = "7";break;
                case "What’s New" : sortIndex = "4";break;
                case "Price: Low to High" : sortIndex = "3";break;
                case "Price: High to Low" : sortIndex = "2";break;
                case "Discount: High to Low" : sortIndex = "5";break;
                case "Discount: Low to High" : sortIndex = "6";break;
                case "Per Piece Price: Low to High" : sortIndex = "9";break;
                case "Per Piece Price: High to Low" : sortIndex = "10";break;
            }

            PropertyReader.setValue(PropertyReader.Keys.SORT_INDEX,sortIndex);

        }catch (Exception e){
            System.out.println("Exception At ClickOnSortButton : Updating SORT_DATA");
        }
    }
}
