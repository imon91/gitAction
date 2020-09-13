package pageObejcts;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.StoreWapActions;

import java.util.Random;

import static utils.StoreWapBaseClass.getBaseDriver;

public class CustomerDetailsPageObjects {

    private AndroidDriver<WebElement> androidDriver;
    private StoreWapActions storeWapActions;

    private Random random;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-13awgt0 r-1d5kdc7']//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][2]//div[contains(@data-testid,'navback')]")
    private WebElement backButton_IfThroughCustomerList;

    @FindBy(xpath= "//div[text()='Add Customer Tags']//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//div[contains(@data-testid,'headerTitle')]")
    private WebElement pageTitle_IfThroughCustomerList;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-13awgt0 r-1d5kdc7']//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][2]//div[@class='css-1dbjc4n r-1awozwy r-13awgt0 r-18u37iz r-1wtj0ep']/div[2]")
    private WebElement sideNavButton_IfThroughCustomerList;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-13awgt0 r-1d5kdc7']//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][5]//div[contains(@data-testid,'navback')]")
    private WebElement backButton_QuickOrderFlow;

    @FindBy(xpath= "//div[text()='Add Customer Tags']//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//div[contains(@data-testid,'headerTitle')]")
    private WebElement pageTitle_QuickOrderFlow;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-13awgt0 r-1d5kdc7']//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][5]//div[@class='css-1dbjc4n r-1awozwy r-13awgt0 r-18u37iz r-1wtj0ep']/div[2]")
    private WebElement sideNavButton_QuickOrderFlow;

    @FindBy(xpath = "//div[text()='Customer Name']/following-sibling::input")
    private WebElement customerNameText;

    @FindBy(xpath = "//div[text()='Customer Phone Number']/following-sibling::input")
    private WebElement customerMobileNumberText;

    @FindBy(xpath = "//div[text()='Customer Address']/following-sibling::input")
    private WebElement customerAddressText;

    @FindBy(xpath = "//div[text()='Area Name']//parent::div//parent::div/div[2]/div")
    private WebElement areaNameDropdown;

    @FindBy(xpath = "//div[text()='Add Customer Tags']//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//div[@class='css-1dbjc4n r-19fu0aa r-eqz5dr r-1rks9hb']/div/div/div[1]//input")
    private WebElement customerTagText;

    @FindBy(xpath = "//div[text()='Add Customer Tags']//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//div[@class='css-1dbjc4n r-19fu0aa r-eqz5dr r-1rks9hb']/div/div/div[2]")
    private WebElement addCustomerTagButton;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-eqz5dr r-1hbzrj0 r-1s2bzr4']/div/div/div/div/div")
    private WebElement removeTagButton;

    @FindBy(xpath = "//div[text()='Save']")
    private WebElement saveButton;

    @FindBy(xpath = "//input[contains(@placeholder,'Search')]")
    private WebElement searchAreaNameText;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-13awgt0']/div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][5]//div[text()='View My Order']")
    private WebElement viewMyOrder;


    public CustomerDetailsPageObjects(AndroidDriver<WebElement> androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements((androidDriver), this);
        storeWapActions = new StoreWapActions();
        random = new Random();
    }


    /*------------------------------------------------Actions---------------------------------------------------------*/


    public void clickOnBackButton_IfThroughCustomerList(){ storeWapActions.action_click(backButton_IfThroughCustomerList);}

    public void clickOnSideNavButton_IfThroughCustomerList(){ storeWapActions.action_click(sideNavButton_IfThroughCustomerList);}

    public void clickOnBackButton_QuickOrderFlow(){ storeWapActions.action_click(backButton_QuickOrderFlow);}

    public void clickOnSideNavButton_QuickOrderFlow(){ storeWapActions.action_click(sideNavButton_QuickOrderFlow);}

    public void clickOnSaveButton(){ storeWapActions.action_click(saveButton);}

    public void enterCustomerNameText(String name){ storeWapActions.action_sendKeys(customerNameText,name);}

    public void enterCustomerMobileNumber(String mobileNumber){ storeWapActions.action_sendKeys(customerMobileNumberText,mobileNumber);}

    public void enterCustomerAddress(String address){ storeWapActions.action_sendKeys(customerAddressText,address);}

    public void removeTag(){ storeWapActions.action_click(removeTagButton);}


    /*-----------------------------------------------Functions--------------------------------------------------------*/

    public String getTitleName_IfThroughCustomerList(){
        return storeWapActions.action_getText(pageTitle_IfThroughCustomerList);
    }

    public String getTitleName_QuickOrderFlow(){
        return storeWapActions.action_getText(pageTitle_QuickOrderFlow);
    }

    public void searchAreaNameInAreaDropdown_IfThroughCustomerList(String areaName){
        storeWapActions.action_sendKeys(searchAreaNameText,areaName);
        chooseAreaName(1);
    }

    public void chooseAreaName(int areaIndex){
        storeWapActions.action_click(areaNameDropdown);
        if(areaIndex==0 || areaIndex>1075){
            areaIndex = random.nextInt(1074) +1 ;
        }
        String xpath = "//div[@class='css-1dbjc4n']["+areaIndex+"]//div[@class='css-901oao r-auirdp r-qklmqi r-1az3528 r-pz5f6p r-1b43r93 r-ymttw5 r-5njf8e']";
        WebElement area = androidDriver.findElement(By.xpath(xpath));
        storeWapActions.action_click(area);
    }

    public void chooseRatingForCustomer(int rating){
        if(rating == 0 || rating>5){
            rating = random.nextInt(4)+1;
        }
        String xpath = "//div[@class='css-1dbjc4n r-18u37iz r-11yq8vr r-7e3msg']/div["+rating+"]/div/div";
        storeWapActions.action_click(androidDriver.findElement(By.xpath(xpath)));
    }

    /* ----------------------------enter valid fields-----------------------------------------*/

    public void enterValidCustomerName(){
        String newCustomerName = "AutomatioN - test'ing "+ RandomStringUtils.randomAlphabetic(5) ;
        storeWapActions.action_sendKeys(customerNameText,newCustomerName);
    }

    public void enterValidMobileNumber(){
        String newMobileNumber = "018"+ RandomStringUtils.randomNumeric(8);
        storeWapActions.action_sendKeys(customerMobileNumberText,newMobileNumber);
    }

    public void enterAddress(){
        String newAddress = random.nextInt(99) + " " + RandomStringUtils.randomAlphabetic(5) + ", "+random.nextInt(99) + " " + RandomStringUtils.randomAlphabetic(5) + ".";
        storeWapActions.action_sendKeys(customerAddressText,newAddress);
    }

    public void enterCustomerTags(){
        String tag = RandomStringUtils.randomAlphabetic(5);
        storeWapActions.action_sendKeys(customerTagText,tag);
        storeWapActions.action_click(addCustomerTagButton);
    }



    /* ----------------------------enter invalid fields---------------------------------------*/

    public void enterInvalidCustomerName(){
        storeWapActions.action_sendKeys(customerNameText,"     @@#  ");
    }

    public void enterInvalidMobileNumber(){
        String newMobileNumber = "023"+ RandomStringUtils.randomNumeric(8);
        storeWapActions.action_sendKeys(customerMobileNumberText,newMobileNumber);
    }

    /*------------------------------edit with valid fields--------------------------------------*/


    public void editCustomerNameWithValidName(){
        String newCustomerName = "AutomatioN - test'ing "+ RandomStringUtils.randomAlphabetic(5) ;
        new Actions(androidDriver).click(customerNameText).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(newCustomerName).perform();
    }

    public void editMobileNumberWithValidMobileNumber(){
        String newMobileNumber = "018"+ RandomStringUtils.randomNumeric(8);
        new Actions(androidDriver).click(customerMobileNumberText).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(newMobileNumber).perform();
    }

    public void editAddress(){
        String newAddress = random.nextInt(99) + " " + RandomStringUtils.randomAlphabetic(5) + ", "+random.nextInt(99) + " " + RandomStringUtils.randomAlphabetic(5) + ".";
        new Actions(androidDriver).click(customerAddressText).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(newAddress).perform();
    }

    /*------------------------------edit with invalid fields--------------------------------------*/

    public void editCustomerNameWithInvalidName(){
        String newCustomerName = "    " ;
        new Actions(androidDriver).click(customerNameText).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(newCustomerName).perform();
    }

    public void editMobileNumberWithInValidMobileNumber(){
        String newMobileNumber = "123"+ RandomStringUtils.randomNumeric(8);
        new Actions(androidDriver).click(customerMobileNumberText).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(newMobileNumber).perform();
    }

    /*---------------------------------------get popup messages -----------------------------------*/

    public String getSuccessMessage(){
        try{
            WebDriverWait wait = new WebDriverWait(getBaseDriver(),30);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='css-901oao r-75nptz r-pz5f6p r-1b43r93 r-5njf8e']"))).getText();
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }


    public String customerNameErrorMessage(){
        try{
            WebDriverWait wait = new WebDriverWait(getBaseDriver(),30);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Customer Name']//parent::Div//parent::div/div[2]/div"))).getText();
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public String customerMobileNumberErrorMessage(){
        try{
            WebDriverWait wait = new WebDriverWait(getBaseDriver(),30);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Customer Phone Number']//parent::Div//parent::div/div[2]/div"))).getText();
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }


    public String customerAddressErrorMessage(){
        try{
            WebDriverWait wait = new WebDriverWait(getBaseDriver(),30);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Customer Address']//parent::Div//parent::div/div[2]/div"))).getText();
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public String customerAreaErrorMessage(){
        try{
            WebDriverWait wait = new WebDriverWait(getBaseDriver(),30);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Area Name']//parent::Div//parent::div/div[2]/div"))).getText();
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }



}
