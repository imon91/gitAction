package pageObjects;

import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import utils.*;
import java.util.*;

public class SearchPageObjects extends AndroidBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private MyActions myActions;
    private String packageName;

    public SearchPageObjects(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
        packageName = getAppPackage();
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




    /*--------------Actions-------------------*/

    public void clickOnSearchBackButton(){
        searchBackButton = xpathSetter("//android.widget.ImageView[@resource-id='"+packageName+":id/btnBack']");
        myActions.action_click(searchBackButton);
    }

    public void enterProductName(String product){
        searchBarEditText = xpathSetter("//android.widget.EditText[@resource-id='"+packageName+":id/etSearch']");
        myActions.action_sendKeys(searchBarEditText,product);
    }

    public void clickOnSearchButton(){
        searchButton = xpathSetter("//android.widget.ImageView[@resource-id='"+packageName+":id/btnSearch']");
        myActions.action_click(searchButton);
    }

    public void clickOnSearchCancelButton(){
        searchCancelButton = xpathSetter("//android.widget.ImageView[@resource-id='"+packageName+":id/btnSearch']");
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


    /*----Functions*/

    public void searchForTheGivenProduct(String productName){
        enterProductName(productName);
        clickOnSearchButton();
    }

    public void enterTheProductNameAndCancel(String productName){
        enterProductName(productName);
        clickOnSearchCancelButton();
    }

    public void enterTheProductNameGoBack(String productName){
        enterProductName(productName);
        clickOnSearchBackButton();
    }

}
