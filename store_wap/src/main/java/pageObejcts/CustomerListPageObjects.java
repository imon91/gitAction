package pageObejcts;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.StoreWapActions;

import java.util.List;

public class CustomerListPageObjects {

    private AndroidDriver<WebElement> androidDriver;
    private StoreWapActions storeWapActions;


    @FindBy(xpath = "//div[contains(@data-testid,'navback')]")
    private WebElement backButton;

    @FindBy(xpath= "//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][2]//div[contains(@data-testid,'headerTitle')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-12vffkv']//div[@class='css-1dbjc4n r-12vffkv']//div[@class='css-1dbjc4n r-1awozwy r-13awgt0 r-18u37iz r-1wtj0ep']/div[2]")
    private WebElement sideNavButton;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-14lw9ot r-1nor036 r-qklmqi r-13awgt0 r-18u37iz r-1wtj0ep r-ymttw5 r-1ag2gil']/div[2]")
    private WebElement filterButton;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-14lw9ot r-1p0dtai r-eqz5dr r-rxcuwo r-u8s1d r-13qz1uu r-136ojw6']/div/div/div[2]")
    private WebElement cancelFilterButton;

    @FindBy(xpath = "//div[text()='Apply Filter']")
    private WebElement applyFilterButton;

    @FindBy(xpath = "//div[text()='Add New Customer']")
    private WebElement addNewCustomerButton;

    @FindBy(xpath = "//div[@class='css-901oao r-14iuakf r-1fap712 r-ubezar r-vw2c0b']")
    private WebElement totalNumberOfCustomers;


    public CustomerListPageObjects(AndroidDriver<WebElement> androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements((androidDriver), this);
        storeWapActions = new StoreWapActions();
    }


    /*------------------------------------------------Actions---------------------------------------------------------*/


    public void clickOnBackButton(){ storeWapActions.action_click(backButton);}

    public void clickOnSideNavButton(){ storeWapActions.action_click(sideNavButton);}

    public void clickOnFilterButton(){ storeWapActions.action_click(filterButton);}

    public void clickOnApplyFilterButton(){ storeWapActions.action_click(applyFilterButton);}

    public void clickOnCancelFilterButton(){ storeWapActions.action_click(cancelFilterButton);}

    public void clickOnAddNewCustomerButton(){ storeWapActions.action_click(addNewCustomerButton);}

    public void clickACustomerFromCustomerList(int customerIndex){
        String xpath = "//div[text()='You have ']//parent::div//parent::div//parent::div/div[2]/div/div/div["+customerIndex+"]/div/div/div/div";
        storeWapActions.action_click(androidDriver.findElement(By.xpath(xpath)));
    }


    /*-----------------------------------------------Functions--------------------------------------------------------*/


    public String getTitleName(){
        String titleName = storeWapActions.action_getText(pageTitle);
        return titleName;
    }

    public String getCustomerName(int customerIndex){
        String xpath = "//div[text()='You have ']//parent::div//parent::div//parent::div/div[2]/div/div/div["+customerIndex+"]//div[2]/div/div";
        WebElement customerNameElement = androidDriver.findElement(By.xpath(xpath));
        String customerName = storeWapActions.action_getText(customerNameElement);
        return customerName;
    }

    public String getNumberOFCustomers(){
        String numberOfCustomers = storeWapActions.action_getText(totalNumberOfCustomers);
        return numberOfCustomers;
    }

    public String getCustomerMobileNumber(int customerIndex){
        String xpath = "//div[text()='You have ']//parent::div//parent::div//parent::div/div[2]/div/div/div["+customerIndex+"]//div[2]/div[2]/div/div";
        WebElement customerMobileNumber = androidDriver.findElement(By.xpath(xpath));
        String mobileNumber = storeWapActions.action_getText(customerMobileNumber);
        return mobileNumber;
    }

    public String getCustomerRating(int customerIndex){
        String xpath = "//div[text()='You have ']//parent::div//parent::div//parent::div/div[2]/div/div/div["+customerIndex+"]//div[3]/div[2]/div/div" ;
        List<WebElement> ratingElement = androidDriver.findElements(By.xpath(xpath));
        String rating = ratingElement.size()+"";
        return rating;
    }


}
