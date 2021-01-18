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

    public WebElement getShopNameEditText(){
        return xpathSetter("//android.widget.EditText[@resource-id='"+packageName+":id/add_retailer_edit_shop_name']");
    }

    public WebElement getOwnerNameEditText(){
        return xpathSetter("//android.widget.EditText[@resource-id='"+packageName+":id/add_retailer_owner_name']");
    }

    public List<WebElement> getIconsElementList(){
        List<WebElement> iconList = new ArrayList<>();
        iconList.add(0,idSetter(packageName+":id/chip_retailer"));
        iconList.add(1,idSetter(packageName+":id/chip_wholesaler"));
        iconList.add(2,idSetter(packageName+":id/chip_both"));
        return iconList;
    }

    public WebElement getNextButtonAtOnBoardingScreenElement(){
        return xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/action_next_on_boarding']");
    }

    public WebElement getSkipButtonElement(){
        return xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/add_retailer_action_skip']");
    }

    public void clickOnAddNewShopIcon()
    {
        addNewShopIcon = idSetter(packageName+":id/action_add_retailer");
        myActions.action_click(addNewShopIcon);
    }

    public void clickOnNextButtonAtShopList()
    {
        nextButtonAtShopList = idSetter(packageName+":id/action_next");
        myActions.action_click(nextButtonAtShopList);
    }

    public void enterShopNameText(String shopName)
    {
        shopNameText = xpathSetter("//android.widget.EditText[@resource-id='"+packageName+":id/add_retailer_edit_shop_name']");
        myActions.action_sendKeys(shopNameText,shopName);
    }

    public void enterOwnerNameText(String ownerName)
    {
        ownerNameText = xpathSetter("//android.widget.EditText[@resource-id='"+packageName+":id/add_retailer_owner_name']");
        myActions.action_sendKeys(ownerNameText,ownerName);
    }

    public void clickOnRetailerIcon()
    {
        retailerIcon = idSetter(packageName+":id/chip_retailer");
        myActions.action_click(retailerIcon);
    }

    public void clickOnWholeSaleIcon()
    {
        wholeSaleIcon = idSetter(packageName+":id/chip_wholesaler");
        myActions.action_click(wholeSaleIcon);
    }

    public void clickOnBothIconInBusinessType()
    {
        bothIcon = idSetter(packageName+":id/chip_both");
        myActions.action_click(bothIcon);
    }

    public void clickOnNextButtonAtOnboardingScreen()
    {
        nextButtonAtOnboardingScreen = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/action_next_on_boarding']");
        myActions.action_click(nextButtonAtOnboardingScreen);
    }

    public void clickOnSkipButton()
    {
        skipButton = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/add_retailer_action_skip']");
        myActions.action_click(skipButton);
    }

    public String getAlmostThereText(){
        almostThereText = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/add_retailer_title']");
        return myActions.action_getText(almostThereText);
    }

    public String getSubText(){
        subText = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/add_retailer_message']");
        return myActions.action_getText(subText);
    }

    public String getBusinessTypeTitleText(){
        businessTypeTitleText = xpathSetter("//android.view.ViewGroup[@resource-id='"+packageName+":id/add_retailer_chipgroup']//android.widget.TextView");
        return myActions.action_getText(businessTypeTitleText);
    }

    public String getTextInBusinessTypeOption(int optionNo){
        businessTypeOptionText = xpathSetter("//android.widget.CompoundButton[@index='"+ optionNo +"']");
        return myActions.action_getText(businessTypeOptionText);
    }

    public String getSkipButtonText(){
        skipButtonText = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/add_retailer_action_skip']");
        return myActions.action_getText(skipButtonText);
    }

    public String getNextButtonText(){
        nextButtonText = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/action_next_on_boarding']");
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

    public String getSelectARetailerText(){
        WebElement textElement = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/retailer_title']");
        return myActions.action_getText(textElement);
    }

    public String getTextInSearchInputBox(){
        WebElement textElement = xpathSetter("//android.widget.EditText[@resource-id='"+packageName+":id/retailer_search']");
        return myActions.action_getText(textElement);
    }

    public void enterTextInSearchInputBox(String shopNameOrPhoneNumber){
        WebElement inputBoxElement = xpathSetter("//android.widget.EditText[@resource-id='"+packageName+":id/retailer_search']");
        myActions.action_sendKeys(inputBoxElement,shopNameOrPhoneNumber);
    }

    public WebElement getSearchInputBoxElement(){
        return xpathSetter("//android.widget.EditText[@resource-id='"+packageName+":id/retailer_search']");
    }

    public String getAddNewRetailerButtonText(){
        WebElement addNewRetailerButtonText = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/action_add_retailer']");
        return myActions.action_getText(addNewRetailerButtonText);
    }

    public WebElement getAddNewRetailerButtonElement(){
        return xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/action_add_retailer']");
    }

    public String getNextButtonTextInRetailerListPage(){
        WebElement nextButtonText = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/action_next']");
        return myActions.action_getText(nextButtonText);
    }

    public WebElement getNextButtonInRetailerListPageElement(){
        return xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/action_next']");
    }

    public WebElement scrollAtSalesRepList(String textToScroll)
    {
        WebElement element = androidDriver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\""+packageName+":id/list_retailer_recycler\")).scrollIntoView("
                        + "new UiSelector().text(\""+textToScroll+ "\"))"));
        return element;
    }

    public WebElement scrollToEndAtSalesRepList(){
        WebElement element = androidDriver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\""+packageName+":id/list_retailer_recycler\")).scrollToEnd(500)"));
        return element;
    }

    public WebElement ownerNameText(int index)
    {
        ownerName = idListSetter(packageName+":id/retailer_name").get(index);
        return ownerName;
    }


    public List<String> getRetailerDataUI(int index)
    {
        List<String> container = new ArrayList<>();
        String OwnerName=myActions.action_getText(xpathSetter("//android.view.ViewGroup[@index='"+index+"']/android.widget.TextView[@resource-id='"+packageName+":id/retailer_name']"));
        String MobileNumber = myActions.action_getText(xpathSetter("//android.view.ViewGroup[@index='"+index+"']/android.widget.TextView[@resource-id='"+packageName+":id/retailer_phone']"));
        container.add(OwnerName);
        container.add(MobileNumber);
        return container;
    }

    public WebElement getARetailerElement(int index){
        return xpathSetter("//android.view.ViewGroup[@resource-id='"+packageName+":id/retailer_constraint_layout' and @index='"+index+"']");
    }

    public void clickARetailer(int index){
        WebElement retailerElement = getARetailerElement(index);
        myActions.action_click(retailerElement);
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

    public void clickOnAddANewRetailer(){
        scrollToEndAtSalesRepList();
        myActions.action_click(getAddNewRetailerButtonElement());
    }

    public String getRegisterRetailerPhoneText(){
        WebElement xpath = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/text_login_label']");
        return myActions.action_getText(xpath);
    }

    public String getAddRetailersPhoneNumberText(){
        WebElement xpath = xpathSetter("//android.widget.EditText[@resource-id='"+packageName+":id/phone_edit']");
        return myActions.action_getText(xpath);
    }

    public String getVerifyWithOtpText(){
        WebElement xpath = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/action_verify_otp']");
        return myActions.action_getText(xpath);
    }

    public void clickOnRetailerLoginPageBackButton(){
        WebElement xpath = xpathSetter("//android.widget.ImageView[@resource-id='"+packageName+":id/action_back_registration']");
        myActions.action_click(xpath);
    }

    public String getPageTitleOfRetailerListPage(){
        String text = myActions.action_getText(xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/retailer_title']"));
        return text;
    }

    public String getOneTimePasswordText(){
        String text = myActions.action_getText(xpathSetter("//"));
        return text;
    }

    public String getEnterOTPText(){
        String text = myActions.action_getText(xpathSetter("//"));
        return text;
    }

    public String getResendOTPInText(){
        String text = myActions.action_getText(xpathSetter("//"));
        return text;
    }

    public String getProceedText(){
        String text = myActions.action_getText(xpathSetter("//"));
        return text;
    }



}
