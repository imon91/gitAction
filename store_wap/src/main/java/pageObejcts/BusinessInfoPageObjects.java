
package pageObejcts;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import utils.StoreWapActions;



public class BusinessInfoPageObjects {



    private AndroidDriver<WebElement> androidDriver;
    private StoreWapActions storeWapActions;


    @FindBy(xpath = "//div[text()='Business Name']//parent::div//input")
    private WebElement businessNameText;

    @FindBy(xpath = "//div[text()='Phone Number']//parent::div//input")
    private WebElement businessMobileNumberText;

    @FindBy(xpath = "//div[text()='Merchant Name']//parent::div//input")
    private WebElement merchantNameText;

    @FindBy(xpath = "//div[text()='Enter your Bkash Number']//parent::div//input")
    private WebElement bkashNumberText;

    @FindBy(xpath = "//div[contains(@data-testid,'navback')]")
    private WebElement backButton;

    @FindBy(xpath= "//div[contains(@data-testid,'headerTitle')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-14lw9ot r-1m93428 r-qklmqi r-13awgt0 r-18u37iz r-ymttw5 r-c2syf2']/div[2]/div/div[2]")
    private WebElement sideNavButton;

    @FindBy(xpath = "//div[text()='Save']")
    private WebElement saveButton;

    public BusinessInfoPageObjects(AndroidDriver<WebElement> androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements((androidDriver), this);
        storeWapActions = new StoreWapActions();
    }

    /*-----------------------------------------------Actions--------------------------------------------------------*/


    public void clickBackButton(){ storeWapActions.action_click(backButton);}

    public void clickSideNavButton(){ storeWapActions.action_click(sideNavButton);}

    public void clickOnSaveButton(){ storeWapActions.action_click(saveButton);}

    public void clearBusinessNameField() { businessNameText.clear();}

    public void clearMerchantNameField() { merchantNameText.clear(); }


    /*-----------------------------------------------Functions--------------------------------------------------------*/


    public String getTextInBusinessNameField() {
        return storeWapActions.action_getText(businessNameText);
    }

    public String getTextInMobileNumberField() {
        return storeWapActions.action_getText(businessMobileNumberText);
    }

    public String getTextInMerchantNameField() {
        return storeWapActions.action_getText(merchantNameText);
    }

    public void enterTextInBusinessName(String businessName) {
        storeWapActions.action_sendKeys(businessNameText, businessName);
    }

    public void enterTextInMerchantName(String merchantName) {
        storeWapActions.action_sendKeys(merchantNameText, merchantName);
    }

    public String getPageTitleText(){
        return storeWapActions.action_getText(pageTitle);
    }



}