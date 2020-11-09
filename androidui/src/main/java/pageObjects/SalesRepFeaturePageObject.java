package pageObjects;

import coreUtils.*;
import io.appium.java_client.*;
import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import services.commerceMethods.*;
import services.responseModels.commerceModels.*;
import utils.*;
import java.util.*;


public class SalesRepFeaturePageObject extends AndroidBaseClass{

    private AndroidDriver<WebElement> androidDriver;
    private MyActions myActions;
    private String packageName;
    private ServiceRequestLayer serviceRequestLayer;
    private GetSalesRepApiResponse getSalesRepApiResponse;
    private String app;
    TouchAction touchActions;


    public SalesRepFeaturePageObject(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
        packageName = getAppPackage();
        serviceRequestLayer = new ServiceRequestLayer();
        touchActions = new TouchAction(androidDriver);
        getSalesRepApiResponse = serviceRequestLayer.getControlOverSalesRepApiResponse();
        app = System.getProperty(BuildParameterKeys.KEY_APP);
    }


    //add new ShopIcon
    private WebElement addNewShopIcon;

    //NextButton at ShopList
    private WebElement nextButtonAtShopList;

    //shopName button
    private WebElement shopNameText;

    //OwnerName Text bar
    private WebElement ownerNameText;

    //SkipButton
    private WebElement skipButton;

    //Retailer Icon at business type
    private WebElement retailerIcon;

    //WholeSale icon at business type
    private WebElement wholeSaleIcon;

    //Both icon at business type
    private WebElement bothIcon;

    //Next Button at Onboarding Screen
    private WebElement nextButtonAtOnboardingScreen;

    //EnterMobileNumberText
    private WebElement mobileNumberText;

    //Otp text
    private WebElement otpText;

    //Verify with otp button
    private WebElement verifyWithOtpButton;

    //Continue Button
    private WebElement continueButton;

    //OwnerName at RetailerList
    private WebElement ownerName;

    //Phone number at RetailerList
    private WebElement mobileName;

    private WebElement almostThereText;

    private WebElement subText;

    private WebElement businessTypeTitleText;

    private WebElement businessTypeOptionText;

    private WebElement nextButtonText;

    private WebElement skipButtonText;



    public void clickOnAddNewShopIcon()
    {
        addNewShopIcon = idSetter("com.mokam.app:id/action_add_retailer");
        myActions.action_click(addNewShopIcon);
    }

    public void clickOnNextButtonAtShopList()
    {
        nextButtonAtShopList = idSetter("com.mokam.app:id/action_next");
        myActions.action_click(nextButtonAtShopList);
    }

    public void enterShopNameText(String shopName)
    {
        shopNameText = xpathSetter("//android.widget.EditText[@resource-id='"+packageName+":id/add_retailer_edit_shop_name']");
        myActions.action_sendKeys(shopNameText,shopName);
    }

    public void enterOwnerNameText(String ownerName)
    {
        ownerNameText = xpathSetter("//android.widget.EditText[@resource-id='com.mokam.app:id/add_retailer_owner_name']");
        myActions.action_sendKeys(ownerNameText,ownerName);
    }

    public void clickOnRetailerIcon()
    {
        retailerIcon = idSetter("com.mokam.app:id/chip_retailer");
        myActions.action_click(retailerIcon);
    }

    public void clickOnWholeSaleIcon()
    {
        wholeSaleIcon = idSetter("com.mokam.app:id/chip_wholesaler");
        myActions.action_click(wholeSaleIcon);
    }

    public void clickOnBothIconInBusinessType()
    {
        bothIcon = idSetter("com.mokam.app:id/chip_both");
        myActions.action_click(bothIcon);
    }

    public void clickOnNextButtonAtOnboardingScreen()
    {
        nextButtonAtOnboardingScreen = xpathSetter("//android.widget.TextView[@resource-id='com.mokam.app:id/action_next_on_boarding']");
        myActions.action_click(nextButtonAtOnboardingScreen);
    }

    public void clickOnSkipButton()
    {
        skipButton = xpathSetter("//android.widget.TextView[@resource-id='com.mokam.app:id/add_retailer_action_skip']");
        myActions.action_click(skipButton);
    }

    public String getAlmostThereText(){
        almostThereText = xpathSetter("//android.widget.TextView[@resource-id='com.mokam.app:id/add_retailer_title']");
        return myActions.action_getText(almostThereText);
    }

    public String getSubText(){
        subText = xpathSetter("//android.widget.TextView[@resource-id='com.mokam.app:id/add_retailer_message']");
        return myActions.action_getText(subText);
    }

    public String getBusinessTypeTitleText(){
        businessTypeTitleText = xpathSetter("//android.view.ViewGroup[@resource-id='com.mokam.app:id/add_retailer_chipgroup']//android.widget.TextView");
        return myActions.action_getText(businessTypeTitleText);
    }

    public String getTextInBusinessTypeOption(int optionNo){
        businessTypeOptionText = xpathSetter("//android.widget.CompoundButton[@index='"+ optionNo +"']");
        return myActions.action_getText(businessTypeOptionText);
    }

    public String getSkipButtonText(){
        skipButtonText = xpathSetter("//android.widget.TextView[@resource-id='com.mokam.app:id/add_retailer_action_skip']");
        return myActions.action_getText(skipButtonText);
    }

    public String getNextButtonText(){
        nextButtonText = xpathSetter("//android.widget.TextView[@resource-id='com.mokam.app:id/action_next_on_boarding']");
        return myActions.action_getText(nextButtonText);
    }

    public void sentMobileNumberText(String mobileNumber)
    {
        mobileNumberText = xpathSetter("//android.widget.EditText[@resource-id='"+ packageName +":id/phone_edit']");
        myActions.action_sendKeys(mobileNumberText,mobileNumber);
    }

    public void sentOtp(String otp)
    {
        otpText = xpathSetter("//android.widget.EditText[@resource-id='"+ packageName +":id/otp_edit']");
        myActions.action_sendKeys(otpText,otp);
    }

    public void clickOnVerifyWithOtpButton()
    {
        verifyWithOtpButton  = xpathSetter("//android.widget.TextView[@resource-id='"+ packageName +":id/action_verify_otp']");
        myActions.action_click(verifyWithOtpButton);
    }

    public void  clickOnContinueButton()
    {
        continueButton = xpathSetter("//android.widget.TextView[@resource-id='"+ packageName +":id/action_verify_otp']");
        myActions.action_click(continueButton);
    }

    public WebElement scrollAtSalesRepList(String textToScroll)
    {
        WebElement element = androidDriver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\"com.mokam.app:id/list_retailer_recycler\")).scrollIntoView("
                        + "new UiSelector().text(\""+textToScroll+ "\"))"));
        return element;
    }

    public WebElement ownerNameText(int index)
    {
        ownerName = idListSetter("com.mokam.app:id/retailer_name").get(index);
        return ownerName;
    }


    public List<String> getRetailerDataUI(int index)
    {
        List<String> container = new ArrayList<>();
        String OwnerName=myActions.action_getText(xpathListSetter("com.mokam.app:id/retailer_name").get(index));
        String MobileNumber = myActions.action_getText(xpathListSetter("com.mokam.app:id/retailer_phone").get(index));
        container.add(OwnerName);
        container.add(MobileNumber);
        return container;
    }


    public MokamRetailerListModel salesRepResultsApi()
    {
        return getSalesRepApiResponse.salesRepRetailerListApi();
    }


    //authentication of retailer
    public void performAuthentication(String mobileNumber,String otp){
        sentMobileNumberText(mobileNumber);
        clickOnVerifyWithOtpButton();
        sentOtp(otp);
        clickOnContinueButton();
    }
    
}
