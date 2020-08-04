package pageObejcts;


import coreUtils.CoreConstants;
import dataBase.DataBaseCore;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import sun.awt.windows.WEmbeddedFrame;
import utils.StoreWapActions;
import utils.StoreWapBaseClass;
import java.util.List;
import java.util.Random;



public class  EditOrdersPageObjects{



    private AndroidDriver<WebElement> androidDriver;
    private StoreWapActions storeWapActions;


    @FindBy(xpath = "//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][3]//div[contains(@data-testid,'navback')]")
    private WebElement backButton;

    @FindBy(xpath= "//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][3]//div[contains(@data-testid,'headerTitle')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][3]//div[@class='css-1dbjc4n r-1awozwy r-13awgt0 r-18u37iz r-1wtj0ep']/div[2]")
    private WebElement sideNavButton;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-eqz5dr r-nsbfu8 r-1ygmrgt']//input[@class='css-1cwyjr8 r-ymttw5 r-1f1sjgu r-fdjqy7']")
    private WebElement customerNameText;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-19fu0aa r-eqz5dr r-ymttw5 r-5njf8e']//input[@class='css-1cwyjr8 r-ymttw5 r-1f1sjgu r-fdjqy7']")
    private WebElement discountText;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-19fu0aa r-eqz5dr r-ymttw5 r-5njf8e']/div[2]//input[@class='css-1cwyjr8 r-ymttw5 r-1f1sjgu r-fdjqy7']")
    private WebElement deliveryChargeText;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-1m4hqb0 r-18u37iz r-1wtj0ep r-ymttw5 r-5njf8e']//div[text()='Create Order']")
    private WebElement createOrderButton;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][3]//span[@class='css-901oao css-16my406 r-jwli3a r-1fap712 r-ubezar r-vw2c0b']")
    private WebElement totalAmountText;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][3]//div[@class='css-901oao r-jwli3a r-pz5f6p r-1b43r93'][2]")
    private WebElement totalNumberOFItems;

    public EditOrdersPageObjects(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements((androidDriver), this);
        storeWapActions = new StoreWapActions();
    }


    /*------------------------------------------Actions---------------------------------------------*/


    public void clickCreateOrderButton(){ storeWapActions.action_click(createOrderButton);}

    public void clickBackButton(){ storeWapActions.action_click(backButton);}

    public void clickSideNavButton(){ storeWapActions.action_click(sideNavButton);}


    /*------------------------------------------Functions---------------------------------------------*/


    public void enterCustomerName(String customerName){
        storeWapActions.action_sendKeys(customerNameText,customerName);
    }

    public void enterDiscount(String discount){
        storeWapActions.action_sendKeys(discountText,discount);
    }

    public void enterDeliveryCharge(String deliveryCharge){
        storeWapActions.action_sendKeys(deliveryChargeText,deliveryCharge);
    }

    public void editCustomerName(String newCustomerName){
        new Actions(androidDriver).click(customerNameText).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(newCustomerName).perform();
    }

    public void editDiscount(String newDiscount){
        new Actions(androidDriver).click(discountText).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(newDiscount).perform();
    }

    public void editDeliveryCharge(String newDeliveryCharge){
        new Actions(androidDriver).click(deliveryChargeText).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(newDeliveryCharge).perform();
    }

    public String getTotalAmount(){
        String totalAmount = storeWapActions.action_getText(totalAmountText);
        return totalAmount;
    }

    public String getNumberOfProducts(){
        String numberOfProducts = storeWapActions.action_getText(totalNumberOFItems);
        return numberOfProducts;
    }

    public String getPageTitleText(){
        String pageTitleText = storeWapActions.action_getText(pageTitle);
        return pageTitleText;
    }

    public void editProductName(int productIndex,String newName){
        String baseXpath = "//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][3]//div[@class='css-1dbjc4n']["+productIndex+"]/div/div[1]//input";
        WebElement productName = androidDriver.findElement(By.xpath(baseXpath));
        new Actions(androidDriver).click(productName).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(newName).perform();
    }

    public void editProductQuantity(int productIndex,String newQty){
        String baseXpath = "//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][3]//div[@class='css-1dbjc4n']["+productIndex+"]/div/div[2]//input";
        WebElement productQuantity = androidDriver.findElement(By.xpath(baseXpath));
        new Actions(androidDriver).click(productQuantity).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(newQty).perform();
    }

    public void editProductAmount(int productIndex,String newAmount){
        String baseXpath = "//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][3]//div[@class='css-1dbjc4n']["+productIndex+"]/div/div[3]//input";
        WebElement productAmount = androidDriver.findElement(By.xpath(baseXpath));
        new Actions(androidDriver).click(productAmount).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(newAmount).perform();
    }

    public String getProductName(int productIndex){
        String baseXpath = "//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][3]//div[@class='css-1dbjc4n']["+productIndex+"]/div/div[1]//input";
        WebElement productName = androidDriver.findElement(By.xpath(baseXpath));
        String name = storeWapActions.action_getText(productName);
        return name;
    }

    public String getProductQuantity(int productIndex){
        String baseXpath = "//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][3]//div[@class='css-1dbjc4n']["+productIndex+"]/div/div[2]//input";
        WebElement productQuantity = androidDriver.findElement(By.xpath(baseXpath));
        String quantity = storeWapActions.action_getText(productQuantity);
        return quantity;
    }

    public String getProductAmount(int productIndex){
        String baseXpath = "//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][3]//div[@class='css-1dbjc4n']["+productIndex+"]/div/div[3]//input";
        WebElement productAmount = androidDriver.findElement(By.xpath(baseXpath));
        String amount = storeWapActions.action_getText(productAmount);
        return amount;
    }

    public void deleteProduct(int productIndex){
        String baseXpath = "//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][3]//div[@class='css-1dbjc4n']["+productIndex+"]//div[@class='css-1dbjc4n r-c8eef1']";
        storeWapActions.action_click(androidDriver.findElement(By.xpath(baseXpath)));
    }



}

