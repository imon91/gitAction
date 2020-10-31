package pageObjects;

import io.appium.java_client.*;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.*;
import io.appium.java_client.android.*;
import java.util.*;

public class HomePageObjects extends AndroidBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private MyActions myActions;
    private String packageName;

    public HomePageObjects(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        myActions = new MyActions();
        packageName = getAppPackage();
    }

    //--------------------Address/GeoLocation at homePage ------------------//

    //add new address button
    private WebElement addNewAddressButton;

    //address Search bar
    private WebElement addressSearchBar;

    //NextButton
    private WebElement nextButton;

    //ShopName
    private WebElement shopName;

    //Area
    private WebElement area;

    //+AddressButton
    private WebElement addAddressButton;

    //locationAllowButton
    private WebElement allowButton;

    //okButtonForLocation
    private WebElement okButtonForLocation;

    //locationSuggestionList
    private List<WebElement> locationSuggestionList;

    //addressNameFromList
    private List<WebElement> addressNameFromList;

    //areaSuggestionList
    private List<WebElement> areaSuggestionList;

    public WebElement scrollOnAddressList(String text)
    {      WebElement element = androidDriver.findElement(MobileBy.AndroidUIAutomator(
            "new UiScrollable(new UiSelector().resourceId(\""+packageName+":id/address_list_recycler_view\")).scrollIntoView("
                    + "new UiSelector().text(\""+text+"\"))"));
         return element;
    }

    public void clickOnAddNewAddressButton()
    {
        addNewAddressButton = idSetter(packageName+":id/action_add_address");
        myActions.action_click(addNewAddressButton);
    }

    public void enterLocation(String location)
    {
        addressSearchBar = idSetter(packageName+":id/location_input");
        myActions.action_sendKeys(addressSearchBar,location);

    }

    public void clickOnLocationNextButton()
    {
        nextButton = idSetter(packageName+":id/action_next");
        myActions.action_click(nextButton);
    }

    public List<WebElement> getLocationSuggestionList()
    {
        locationSuggestionList = idListSetter(packageName+":id/address_title");
        return locationSuggestionList;
    }

    public void enterShopName(String ShopName)
    {
        shopName = idSetter(packageName+":id/add_address_name");
        myActions.action_sendKeys(shopName,"Smoke Flow shop "+ShopName);
    }

    public void enterArea(String areaName)
    {
        area = idSetter(packageName+":id/add_address_area");
        myActions.action_sendKeys(area,areaName);
    }

    public List<WebElement> getAreaList()
    {
        areaSuggestionList = idListSetter("");
        return areaSuggestionList;
    }

    public List<WebElement> addressNameFromAddressList()
    {
        addressNameFromList = idListSetter(packageName+":id/address_number");
        return addressNameFromList;
    }

    public void clickAllowButton()
    {
        allowButton = idSetter("com.android.packageinstaller:id/permission_allow_button");
        myActions.action_click(allowButton);
    }

    public void clickOnOkButton()
    {
        okButtonForLocation = idSetter("android:id/button1");
        myActions.action_click(okButtonForLocation);
    }

    public void clickOnAddAddressButton()
    {
        addAddressButton = idSetter(packageName+":id/action_next_container");
        myActions.action_click(addAddressButton);
    }

    public void clickOnMobileNumber()
    {
        WebElement mobileNumber = idSetter("com.mokam.app:id/add_address_phone");
        myActions.action_click(mobileNumber);
    }



    /*------------------- List of HomePage Items And Their Functions--------------------------*/



}
