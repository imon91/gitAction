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

    public WebElement getHomePageWebElement(){
        return idSetter(packageName+":id/recycler_home_fragment");
    }

    public List<WebElement> getLedgerTextsListElement(){
        List<WebElement> elementList = new ArrayList<>();
        elementList.add(0,idSetter(packageName+":id/ledger_widget_give_title"));
        elementList.add(1,idSetter(packageName+":id/ledger_widget_get_title"));
        return elementList;
    }

    public List<WebElement> getLedgerValuesListElement(){
        List<WebElement> elementList = new ArrayList<>();
        elementList.add(0,idSetter(packageName+":id/ledger_widget_give_money"));
        elementList.add(1,idSetter(packageName+":id/ledger_widget_get_money"));
        return elementList;
    }

    public WebElement getLedgerElement(){
        return xpathSetter("//android.view.ViewGroup[@index='0']//androidx.cardview.widget.CardView[@index='0']");
    }

    public WebElement getHorizontalBannerElement(){
        return idSetter(packageName+":id/recycler_icon_widget");
    }

    public WebElement getBakiTextElement(){
        return idSetter(packageName+":id/credit_widget_title");
    }

    public WebElement getBakiAmountElement(){
        return idSetter(packageName+":id/credit_widget_amount");
    }

    public WebElement getBakiSummaryButtonElement(){
        return idSetter(packageName+":id/action_view_credits");
    }

    public WebElement editAddressBackButtonElement(){
        return xpathSetter("//android.widget.ImageView[@resource-id='"+packageName+":id/back_button_profile']");
    }

    public WebElement editAddressPageTitleElement(){
        return xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/title_profile_activity']");
    }

    public WebElement editAddressShopNameEditText(){
        return xpathSetter("//android.widget.EditText[@resource-id='"+packageName+":id/add_address_name']");
    }

    public WebElement editAddressAddressEditText(){
        return xpathSetter("//android.widget.EditText[@resource-id='"+packageName+":id/add_address_address']");
    }

    public WebElement editAddressAreaEditText(){
        return xpathSetter("//android.widget.EditText[@resource-id='"+packageName+":id/add_address_area']");
    }

    public WebElement editAddressLocalityEditText(){
        return xpathSetter("//android.widget.EditText[@resource-id='"+packageName+":id/add_address_locality']");
    }

    public WebElement editAddressMobileNumberEditText(){
        return xpathSetter("//android.widget.EditText[@resource-id='"+packageName+":id/add_address_phone']");
    }

    public WebElement editAddressAlternateMobileNumberEditText(){
        return xpathSetter("//android.widget.EditText[@resource-id='"+packageName+":id/add_address_alternate_phone']");
    }

    public WebElement editAddressSaveButtonTextElement(){
        return xpathSetter("//android.widget.FrameLayout[@resource-id='"+packageName+":id/action_next_container']/android.widget.TextView");
    }

    public WebElement editAddressSaveButtonElement(){
        return xpathSetter("//android.widget.FrameLayout[@resource-id='"+packageName+":id/action_next_container']");
    }

    public WebElement getBackButtonInLocationPageElement(){
        return xpathSetter("//android.widget.ImageView[@resource-id='"+packageName+":id/action_back_gmaps']");
    }

    public WebElement getLocationInputEditText(){
        return xpathSetter("//android.widget.EditText[@resource-id='"+packageName+":id/location_input']");
    }

    public WebElement getLocateMeTextElement(){
        return idSetter(packageName+":id/action_locate_me");
    }

    public WebElement getNextButtonInLocationPageElement(){
        return idSetter(packageName+":id/action_next");
    }

    public WebElement getBackButtonInAddressSelectionPageElement(){
        return xpathSetter("//android.widget.ImageView[@resource-id='"+packageName+":id/back_button_profile']");
    }

    public WebElement getPageTitleElementOfAddressSelection(){
        return xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/title_profile_activity']");
    }

    public WebElement getNoAddressesFoundTextElement(){
        return xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/text_no_address']");
    }

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

    public void clickFirstSuggestionInLocationList(){
        WebElement firstSuggestionElement = xpathSetter("//androidx.recyclerview.widget.RecyclerView[@resource-id='"+packageName+":id/address_list_recycler_view']/android.view.ViewGroup[@index='0']");
        myActions.action_click(firstSuggestionElement);
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
        if (idSetter(packageName + ":id/address_list_recycler_view").isDisplayed()) {
            switchFromWebToNative();
            WebElement addNewAddressButton;
            try {
                addNewAddressButton = scrollToAddNewAddressButton();
            } catch (Exception e) {
                addNewAddressButton = idSetter(packageName + ":id/action_add_address");
            }
            clickOnAddNewAddressButton();
            sleep(1000);
            clickAllowButton();
            sleep(1000);
            int randomIndex = random.nextInt(readJSONFile.getLocationData(app, "locationTerm").size());
            String locationName = String.valueOf(readJSONFile.getLocationData(app, "locationTerm").get(randomIndex));
            enterLocation(locationName);
            sleep(2000);
            clickOnLocationNextButton();
            sleep(1000);
            enterShopName(locationName);
            enterArea();
            sleep(2000);
            enterAddress("" + random.nextInt(10) + ",West Cross Street");
            enterMobileNumber("018" + RandomStringUtils.randomNumeric(8));
            clickOnAddAddressButton();
            sleep(2000);
            selectAddress("Smoke Flow shop " + locationName);
            sleep(3500);
        }
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
//        try {
//            allowButton = xpathSetter("//android.widget.Button[@resource-id='com.android.packageinstaller:id/permission_allow_button']");
//        } catch (NoSuchElementException e) {
            allowButton = xpathSetter("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']");
//        }
        myActions.action_click(allowButton);
        try {
            clickOnOkButton();
        }catch (Exception e){
            // DO NOT DO ANYTHING
        }
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
        WebElement mobileNumber = idSetter(packageName+":id/add_address_phone");
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
        WebElement cartItemCountElement = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/cart_item_count']");
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

    public void deleteExistingAddress(int index){
        WebElement path = xpathSetter("//androidx.cardview.widget.CardView[@index='"+index+"']/android.view.ViewGroup/android.widget.ImageView[@index='4']");
        myActions.action_click(path);
    }

    public String getShopNameAndAddress(int index){
        WebElement shopNameXpath = xpathSetter("//androidx.cardview.widget.CardView[@index='"+index+"']//android.widget.TextView[@resource-id='"+packageName+":id/address_number']");
        String shopName = myActions.action_getText(shopNameXpath);
        WebElement shopAddressXpath = xpathSetter("//androidx.cardview.widget.CardView[@index='"+index+"']//android.widget.TextView[@resource-id='"+packageName+":id/address_body']");
        String shopAddress = myActions.action_getText(shopAddressXpath);
        return shopName+shopAddress ;
    }

    public String getAddNewAddressText(){
        try{
            addNewAddressButton = scrollToAddNewAddressButton();
        }
        catch(Exception e){
            addNewAddressButton = idSetter(packageName+":id/action_add_address");
        }
        return myActions.action_getText(addNewAddressButton);
    }

    public void clickEditAddress(int index){
        WebElement xpath = xpathSetter("//androidx.cardview.widget.CardView[@index='"+index+"']//android.widget.TextView[@resource-id='"+packageName+":id/action_edit']");
        myActions.action_click(xpath);
    }

    public void editMobileNumber(String number){
        WebElement mobileNumberElement = idSetter(packageName+":id/add_address_phone");
        myActions.action_sendKeys(mobileNumberElement,number);
    }



    /*------------------- List of HomePage Items And Their Functions--------------------------*/



}
