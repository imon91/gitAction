
package pageObejcts;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.StoreWapActions;



public class SideNavPageObjects {



    private AndroidDriver<WebElement> androidDriver;
    private StoreWapActions storeWapActions;


    @FindBy(xpath = "//div[text()='Business Info']")
    private WebElement businessInfoButton;

    @FindBy(xpath = "//div[text()='Delivery Pickup Address']")
    private WebElement deliveryPickupAddressButton;

    @FindBy(xpath = "//div[text()='Facebook Shop']")
    private WebElement facebookShopButton;

    @FindBy(xpath = "//div[text()='Logout']")
    private WebElement logoutButton;

    @FindBy(xpath = "//div[text()='Help']")
    private WebElement helpButton;

    @FindBy(xpath = "//div[text()='Tutorial']")
    private WebElement tutorialButton;

    @FindBy(xpath = "//div[text()='Policy']")
    private WebElement policyButton;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-6dt33c']")
    private WebElement backToPreviousPage;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-eqz5dr r-17s6mgv r-1peese0 r-1kqp4h8']/div[1]")
    private WebElement businessName;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-eqz5dr r-17s6mgv r-1peese0 r-1kqp4h8']/div[2]")
    private WebElement businessMobileNumber;


    public SideNavPageObjects(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements((androidDriver), this);
        storeWapActions = new StoreWapActions();
    }


    /*----------------------------------------------- Actions ------------------------------------------------*/


    public void clickBusinessInfoButton(){ storeWapActions.action_click(businessInfoButton);}

    public void clickDeliveryPickupAddressButton(){ storeWapActions.action_click(deliveryPickupAddressButton);}

    public void clickFacebookShopButton(){ storeWapActions.action_click(facebookShopButton);}

    public void clickLogoutButton(){ storeWapActions.action_click(logoutButton);}

    public void clickHelpButton(){ storeWapActions.action_click(helpButton);}

    public void clickTutorialButton(){ storeWapActions.action_click(tutorialButton);}

    public void clickPolicyButton(){ storeWapActions.action_click(policyButton);}

    public void clickBackToPreviousPage(){ storeWapActions.action_click(backToPreviousPage);}


    /*-----------------------------------------------Functions------------------------------------------------*/


    public String getBusinessName(){
        String name = storeWapActions.action_getText(businessName);
        return name;
    }

    public String getBusinessMobileNumber(){
        String mobileNumber = storeWapActions.action_getText(businessMobileNumber);
        return mobileNumber;
    }



}