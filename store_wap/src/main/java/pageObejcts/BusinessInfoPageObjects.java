
package pageObejcts;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.StoreWapActions;



public class BusinessInfoPageObjects {



    private AndroidDriver<WebElement> androidDriver;
    private StoreWapActions storeWapActions;


    @FindBy(xpath = "//input[contains(@placeholder,'Business Name')]")
    private WebElement businessNameText;

    @FindBy(xpath = "//input[contains(@placeholder,'Phone Number')]")
    private WebElement businessMobileNumberText;

    @FindBy(xpath = "//input[contains(@placeholder,'Merchant Name')]")
    private WebElement merchantNameText;

    @FindBy(xpath = "//div[contains(@data-testid,'navback')]")
    private WebElement backButton;

    @FindBy(xpath= "//div[contains(@data-testid,'headerTitle')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-14lw9ot r-1m93428 r-qklmqi r-13awgt0 r-18u37iz r-ymttw5 r-c2syf2']/div[2]/div/div[2]")
    private WebElement sideNavButton;


    /*-----------------------------------------------Actions--------------------------------------------------------*/


    public void clickBackButton(){ storeWapActions.action_click(backButton);}

    public void clickSideNavButton(){ storeWapActions.action_click(sideNavButton);}

    public void clearBusinessNameField() { businessNameText.clear();}

    public void clearMerchantNameField() { merchantNameText.clear(); }


    /*-----------------------------------------------Functions--------------------------------------------------------*/


    public String getTextInBusinessNameField() {
        String businessName = storeWapActions.action_getText(businessNameText);
        return businessName;
    }

    public String getTextInMobileNumberField() {
        String mobileNumber = storeWapActions.action_getText(businessMobileNumberText);
        return mobileNumber;
    }

    public String getTextInMerchantNameField() {
        String merchantName = storeWapActions.action_getText(merchantNameText);
        return merchantName;
    }

    public void enterTextInBusinessName(String businessName) {
        storeWapActions.action_sendKeys(businessNameText, businessName);
    }

    public void enterTextInMerchantName(String merchantName) {
        storeWapActions.action_sendKeys(merchantNameText, merchantName);
    }

    public String getPageTitleText(){
        String pageTitleText = storeWapActions.action_getText(pageTitle);
        return pageTitleText;
    }



}