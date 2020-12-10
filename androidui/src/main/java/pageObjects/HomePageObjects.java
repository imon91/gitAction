package pageObjects;

import coreUtils.*;
import io.appium.java_client.*;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.*;
import services.commerceMethods.GetCommerceApiResponse;
import services.responseModels.commerceModels.MokamHomePageModel;
import testData.*;
import utils.*;
import io.appium.java_client.android.*;
import java.util.*;

public class HomePageObjects extends AndroidBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private MyActions myActions;
    private String packageName;
    private GetCommerceApiResponse getCommerceApiResponse;
    private ServiceRequestLayer serviceRequestLayer;
    private String app;
    private Random random;
    private ReadJSONFile readJSONFile;

    public HomePageObjects(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        myActions = new MyActions();
        packageName = getAppPackage();
        serviceRequestLayer = new ServiceRequestLayer();
        getCommerceApiResponse = serviceRequestLayer.getControlOverServices();
        app = System.getProperty(BuildParameterKeys.KEY_APP);
        random = new Random();
        readJSONFile = serviceRequestLayer.getControlOverReadJSONFile();
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

    public WebElement scrollToAddNewAddressButton()
    {      WebElement element = androidDriver.findElement(MobileBy.AndroidUIAutomator(
            "new UiScrollable(new UiSelector().resourceId(\""+packageName+":id/address_list_recycler_view\")).scrollToEnd(100)"));
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

    public void enterAddress(String address){
        WebElement addressElement = idSetter(packageName+":id/add_address_address");
        myActions.action_sendKeys(addressElement,address);

    }

    public void selectAddress(String addressName){
        WebElement firstAddressElement = xpathSetter("//android.widget.TextView[@text='"+ addressName +"']");
        myActions.action_click(firstAddressElement);
    }

    public void selectAddress(int index){
        WebElement firstAddressElement = xpathSetter("//androidx.cardview.widget.CardView[@index='"+index+"']/android.view.ViewGroup[@index='0']");
        myActions.action_click(firstAddressElement);
    }

    public void createNewAddress() throws Exception {
        switchFromWebToNative();
        WebElement addNewAddressButton;
        try {
            addNewAddressButton = scrollToAddNewAddressButton();
        } catch (Exception e) {
            addNewAddressButton = idSetter("com.mokam.app:id/action_add_address");
        }
        clickOnAddNewAddressButton();
        sleep(1000);
        clickAllowButton();
        sleep(1000);
        System.out.println("app name is "+app);
        int randomIndex = random.nextInt(readJSONFile.getLocationData(app, "locationTerm").size());
        String locationName = String.valueOf(readJSONFile.getLocationData(app, "locationTerm").get(randomIndex));
        enterLocation(locationName);
        sleep(2000);
        clickOnLocationNextButton();
        sleep(1000);
        enterShopName(locationName);
        enterArea();
        sleep(2000);
        enterAddress(""+random.nextInt(10)+",West Cross Street");
        enterMobileNumber("018"+ RandomStringUtils.randomNumeric(8));
        clickOnAddAddressButton();
        sleep(2000);
        selectAddress("Smoke Flow shop "+locationName);
        sleep(3500);
    }

    public void enterMobileNumber(String mobileNumber){
        WebElement mobileNumberElement = idSetter(packageName+":id/add_address_phone");
        if (mobileNumberElement.getText().equalsIgnoreCase("Mobile Number")){
            myActions.action_sendKeys(mobileNumberElement,mobileNumber);
        }
    }

    public String enterArea()
    {
        area = idSetter(packageName+":id/add_address_area");
        String randomArea = getCommerceApiResponse.getRandomArea();
        myActions.action_sendKeys(area, randomArea);
        return randomArea;
//        switch (areaName){
//            case "Dhaka" :
//                myActions.action_sendKeys(area,"Adabor, "+areaName);
//                break;
//            case "chittagong" :
//                myActions.action_sendKeys(area,"Anwara, "+areaName);
//                break;
//            case "mirpur" :
//                myActions.action_sendKeys(area,"Mirpur Cantonment, Dhaka");
//                break;
//            case "Khulna" :
//                myActions.action_sendKeys(area,"Dacope, "+areaName);
//                break;
//            case "Mymensingh" :
//                myActions.action_sendKeys(area,"Fulpur, "+areaName);
//                break;
//            case "Rangpur" :
//                myActions.action_sendKeys(area,"Kaunia, "+areaName);
//                break;
//            case "Rajshahi" :
//                myActions.action_sendKeys(area,"Bagha, "+areaName);
//                break;
//            case "Sylhet" :
//                myActions.action_sendKeys(area,"Balaganj, "+areaName);
//                break;
//        }
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

    public WebElement scrollToAElementWithIdInHomePage(String id){
        return androidDriver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\""+packageName+":id/recycler_home_fragment\")).scrollIntoView("
                        + "new UiSelector().resourceId(\""+id+"\"))"));
    }

    public int getAddressIdOfSelectedAddress(int index){
        return getCommerceApiResponse.getIdOfAddress(index);
    }

    public List<String> getNameAndAddress_Backend(int index, int count){
        return getCommerceApiResponse.getAddressDetails(getAddressIdOfSelectedAddress(index),count);
    }

    public int getCartItemCount(){
        WebElement cartItemCountElement = xpathSetter("//android.widget.TextView[@resource-id='com.mokam.app:id/cart_item_count']");
        return Integer.parseInt(myActions.action_getText(cartItemCountElement));
    }

    public double getTotalCredit(){
        return getCommerceApiResponse.getCreditAndDebitValue().get(0);
    }

    public double getTotalDebit(){
        return getCommerceApiResponse.getCreditAndDebitValue().get(1);
    }

    public int getBakiAmount(){
        return getCommerceApiResponse.getBakiAmount();
    }

    public List<MokamHomePageModel.CollectionsBean> getCollections(){
        return getCommerceApiResponse.getCollections();
    }



    /*------------------- List of HomePage Items And Their Functions--------------------------*/



}
