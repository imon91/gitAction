
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

    @FindBy(xpath = "//div[text()='Payment Settings']")
    private WebElement paymentSettingsButton;

    @FindBy(xpath = "//div[text()='Delivery Settings']")
    private WebElement deliverySettingsButton;

    @FindBy(xpath = "//div[text()='Change Page']")
    private WebElement changePageButton;

    @FindBy(xpath = "//div[text()='Logout']")
    private WebElement logoutButton;

    @FindBy(xpath = "//div[text()='Help']")
    private WebElement helpButton;

    @FindBy(xpath = "//div[text()='Tutorial']")
    private WebElement tutorialButton;

    @FindBy(xpath = "//div[text()='Policy']")
    private WebElement policyButton;

    @FindBy(xpath = "//div[text()='Business Info']//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div/div/div/div/div[2]/div/div")
    private WebElement closeButton;

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

    public void clickPaymentSettingsButton(){storeWapActions.action_click(paymentSettingsButton);}

    public void clickDeliverySettingsButton(){ storeWapActions.action_click(deliverySettingsButton);}

    public void clickChangePageButton(){ storeWapActions.action_click(changePageButton);}

    public void clickLogoutButton(){ storeWapActions.action_click(logoutButton);}

    public void clickHelpButton(){ storeWapActions.action_click(helpButton);}

    public void clickTutorialButton(){ storeWapActions.action_click(tutorialButton);}

    public void clickPolicyButton(){ storeWapActions.action_click(policyButton);}

    public void clickOnCloseButton(){ storeWapActions.action_click(closeButton);}


    /*-----------------------------------------------Functions------------------------------------------------*/


    public String getBusinessName(){
        return storeWapActions.action_getText(businessName);
    }

    public String getBusinessMobileNumber(){
        return storeWapActions.action_getText(businessMobileNumber);
    }



}