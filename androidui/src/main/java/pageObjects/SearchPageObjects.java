package pageObjects;

import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

public class SearchPageObjects {

    private AndroidDriver<AndroidElement> androidDriver;
    private MyActions myActions;

    public SearchPageObjects(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
    }



    // Back Button
    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.shopup.reseller:id/btnBack']")
    private AndroidElement searchBackButton;

    // Search EditText
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.shopup.reseller:id/etSearch']")
    private AndroidElement searchBarEditText;

    // Search Button
    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.shopup.reseller:id/btnSearch']")
    private AndroidElement searchButton;

    // Search Cancel Button
    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.shopup.reseller:id/btnSearch']")
    private AndroidElement searchCancelButton;

    // Recent Searches TextView
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/trending']")
    private AndroidElement recentSearchesText;

    // Recent Suggestions RecyclerView
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.shopup.reseller:id/suggestions_recycler_recent']")
    private AndroidElement recentSuggestionsRecycler;


    public class RecentSuggestionsRecycler{

    }


    /*--------------Actions-------------------*/

    public void clickOnSearchBackButton(){
        myActions.action_click(searchBackButton);
    }

    public void enterProductName(String product){
        myActions.action_sendKeys(searchBarEditText,product);
    }

    public void clickOnSearchButton(){
        myActions.action_click(searchButton);
    }

    public void clickOnSearchCancelButton(){
        myActions.action_click(searchCancelButton);
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
