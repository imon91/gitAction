package pageObjects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import services.commerceMethods.GetSalesRepApiResponse;
import utils.*;

import java.util.*;

public class YourAccountPageObjects extends AndroidBaseClass {


    private AndroidDriver<WebElement> androidDriver;
    private MyActions myActions;
    private Random random;
    private GetSalesRepApiResponse getSalesRepApiResponse;
    private ServiceRequestLayer serviceRequestLayer;
    private String packageName;

    public YourAccountPageObjects(AndroidDriver<WebElement> androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
        random = new Random();
        serviceRequestLayer = new ServiceRequestLayer();
        getSalesRepApiResponse = serviceRequestLayer.getControlOverSalesRepApiResponse();
        packageName = getAppPackage();
    }

    public WebElement getBackButtonElement(){
        return xpathSetter("//android.widget.ImageView[@resource-id='"+packageName+":id/back_button_profile']");
    }

    public WebElement getEditBusinessInfoButtonElement(){
        return xpathSetter("//android.view.ViewGroup[@index='0']//android.widget.TextView[@resource-id='"+packageName+":id/action_edit']");
    }

    public List<WebElement> getEditButtonsInAddressList(){
        return xpathListSetter("//androidx.recyclerview.widget.RecyclerView//android.widget.TextView[@resource-id='"+packageName+":id/action_edit']");
    }

    public List<WebElement> getDeleteButtonsInAddressList(){
        return xpathListSetter("//androidx.recyclerview.widget.RecyclerView//android.widget.ImageView[@resource-id='"+packageName+":id/action_delete']");
    }

    public WebElement addNewAddressButtonElement(){
        return xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/action_add_address']");
    }

    public void clickBackButton(){
        WebElement backButtonElement = xpathSetter("//android.widget.ImageView[@resource-id='"+packageName+":id/back_button_profile']");
        myActions.action_click(backButtonElement);
    }

    public String getPageTitle(){
        WebElement pageTitleElement = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/title_profile_activity']");
        return myActions.action_getText(pageTitleElement);
    }

    public String getBusinessInfoText(){
        WebElement textElement = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/title_business_info']");
        return myActions.action_getText(textElement);
    }

    public void clickEditButton(){
        WebElement editButtonElement = xpathSetter("//android.view.ViewGroup[@index='0']//android.widget.TextView[@resource-id='"+packageName+":id/action_edit']");
        myActions.action_click(editButtonElement);
    }

    public String getShopNameHeadingText(){
        WebElement shopNameHeadingElement = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/heading_shop_name']");
        return myActions.action_getText(shopNameHeadingElement);
    }

    public String getShopName(){
        WebElement shopNameElement = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/shop_name']");
        return myActions.action_getText(shopNameElement);
    }

    public String getNameOfOwnerHeadingText(){
        WebElement nameOfOwnerHeadingElement = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/heading_shop_owner']");
        return myActions.action_getText(nameOfOwnerHeadingElement);
    }

    public String getNameOfOwner(){
        WebElement nameOfTheOwnerElement = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/shop_owner']");
        return myActions.action_getText(nameOfTheOwnerElement);
    }

    public String getRegisterMobileNumberHeadingText(){
        WebElement registeredMobileNumberHeadingElement = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/heading_phone_number']");
        return myActions.action_getText(registeredMobileNumberHeadingElement);
    }

    public String getRegisteredMobileNumber(){
        WebElement registeredMobileNumberElement = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/phone_number']");
        return myActions.action_getText(registeredMobileNumberElement);
    }

    public String getBusinessTypeHeadingText(){
        WebElement businessTypeHeadingElement = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/heading_business_type']");
        return myActions.action_getText(businessTypeHeadingElement);
    }

    public String getBusinessType(){
        WebElement businessTypeElement = xpathSetter("//android.widget.CompoundButton[@resource-id='"+packageName+":id/chip_business_type']");
        return myActions.action_getText(businessTypeElement);
    }

    public String getBusinessAddressHeadingText(){
        WebElement businessAddressHeadingElement = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/heading']");
        return myActions.action_getText(businessAddressHeadingElement);
    }

    public String getShopNameInAddress(int index){
        List<WebElement> shopNameElements = xpathListSetter("//androidx.recyclerview.widget.RecyclerView//android.widget.TextView[@resource-id='"+packageName+":id/address_number']");
        return myActions.action_getText(shopNameElements.get(index));
    }

    public void clickAddressEditButton(int index){
        List<WebElement> editButtonElementList = xpathListSetter("//androidx.recyclerview.widget.RecyclerView//android.widget.TextView[@resource-id='"+packageName+":id/action_edit']");
        myActions.action_click(editButtonElementList.get(index));
    }

    public void clickAddressDeleteButton(int index){
        List<WebElement> deleteButtonElementList = xpathListSetter("//androidx.recyclerview.widget.RecyclerView//android.widget.ImageView[@resource-id='"+packageName+":id/action_delete']");
        myActions.action_click(deleteButtonElementList.get(index));
    }

    public List<String> getShopDetails_BackEnd(){
        return getSalesRepApiResponse.getShopDetails_Backend();
    }

    public int sizeOfUserAddressList(){
        return getSalesRepApiResponse.getAddressesModel().getShipped_addresses().size();
    }

    public String getShopNameInAddress_Backend(int index){
        return getSalesRepApiResponse.getAddressesModel().getShipped_addresses().get(index).getFirstname();
    }

    public WebElement scrollToAddNewAddressButton(){
        WebElement element = androidDriver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\""+packageName+":id/address_list_recycler_view\")).scrollToEnd(100)"));
        return element;
    }

    public String getAddNewAddressButtonText(){
        WebElement buttonElement = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+":id/action_add_address']");
        return myActions.action_getText(buttonElement);
    }

}
