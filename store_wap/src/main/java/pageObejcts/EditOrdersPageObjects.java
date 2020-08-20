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
import static utils.StoreWapBaseClass.sleep;


public class  EditOrdersPageObjects{



    private AndroidDriver<WebElement> androidDriver;
    private StoreWapActions storeWapActions;

    private Random random;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][3]//div[contains(@data-testid,'navback')]")
    private WebElement backButton;

    @FindBy(xpath= "//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][3]//div[contains(@data-testid,'headerTitle')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][3]//div[@class='css-1dbjc4n r-1awozwy r-13awgt0 r-18u37iz r-1wtj0ep']/div[2]")
    private WebElement sideNavButton;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-eqz5dr r-nsbfu8 r-1ygmrgt']//input[@class='css-1cwyjr8 r-ymttw5 r-1f1sjgu r-fdjqy7']")
    private WebElement customerNameText;

    @FindBy(xpath = "//div[text()='Discount']//parent::div//parent::div/div[2]/div/div[2]/input")
    private WebElement discountText;

    @FindBy(xpath = "//div[text()='Delivery Charge']//parent::div//parent::div/div[2]/div/div[2]/input")
    private WebElement deliveryChargeText;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-1m4hqb0 r-18u37iz r-1wtj0ep r-ymttw5 r-5njf8e']//div[text()='Create Order']")
    private WebElement createOrderButton;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][3]//span[@class='css-901oao css-16my406 r-jwli3a r-1fap712 r-ubezar r-vw2c0b']")
    private WebElement totalAmountText;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][3]//div[@class='css-901oao r-jwli3a r-pz5f6p r-1b43r93'][2]")
    private WebElement totalNumberOFItems;

    @FindBy(xpath = "//div[@class='css-901oao r-1loqt21 r-ubezar']")
    private WebElement removeCustomerNameButton;

    @FindBy(xpath = "//div[text()='Select Customer']/following-sibling::div")
    private WebElement customerListButton;

    @FindBy(xpath = "//input[contains(@placeholder,'Search or Add New customer')]")
    private WebElement searchOrAddNewCustomerTabText;

    @FindBy(xpath = "//div[text()='+ New']")
    private WebElement newButton;

    public EditOrdersPageObjects(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements((androidDriver), this);
        storeWapActions = new StoreWapActions();
        random = new Random();
    }


    /*------------------------------------------Actions---------------------------------------------*/


    public void clickCreateOrderButton(){ storeWapActions.action_click(createOrderButton);}

    public void clickBackButton(){ storeWapActions.action_click(backButton);}

    public void clickSideNavButton(){ storeWapActions.action_click(sideNavButton);}

    public void clickCustomerListButton(){ storeWapActions.action_click(customerListButton);}

    public void removeCustomerName(){ storeWapActions.action_click(removeCustomerNameButton); }

    public void searchOrAddNewCustomer(String customerName){ storeWapActions.action_sendKeys(searchOrAddNewCustomerTabText,customerName);}

    /*------------------------------------------Functions---------------------------------------------*/
    public void selectExistingCustomerFrmCustomerList(int customerNameIndex){
        clickCustomerListButton();
        String xpath = "//input[contains(@placeholder,'Search or Add New customer')]//parent::div//parent::div//following-sibling::div/div/div/div[" + customerNameIndex + "]/div/div/div/div" ;
        WebElement customer = androidDriver.findElement(By.xpath(xpath));
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        storeWapActions.action_click(customer);
    }

    public void enterValidCustomerName(){
        clickCustomerListButton();
        String customerName = "Automation - Testin'G " + RandomStringUtils.randomAlphabetic(5) ;
        searchOrAddNewCustomer(customerName+"\n");
        storeWapActions.action_click(newButton);
    }

    public void enterInvalidCustomerName(){
        clickCustomerListButton();
        searchOrAddNewCustomer(" #$% " + "\n");
        storeWapActions.action_click(newButton);
    }


    public void enterValidDiscount(){
        String discount = String.valueOf(random.nextInt(99))+"\n";
        storeWapActions.action_sendKeys(discountText,discount);
    }

    public void enterValidDeliveryCharge(){
        String deliveryCharge = String.valueOf(random.nextInt(99))+"\n";
        storeWapActions.action_sendKeys(deliveryChargeText,deliveryCharge);
    }

    public void editDiscount(String newDiscount){
        new Actions(androidDriver).click(discountText).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(newDiscount).perform();
    }

    public void editDeliveryCharge(String newDeliveryCharge){
        new Actions(androidDriver).click(deliveryChargeText).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(newDeliveryCharge).perform();
    }


    public void editDiscountWithValidDiscount(){
        String newDiscount = String.valueOf(random.nextInt(99)) ;
        new Actions(androidDriver).click(discountText).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(newDiscount).perform();
    }

    public void editDeliveryChargeWithValidDeliveryCharge(){
        String newDeliveryCharge = String.valueOf(random.nextInt(99)) ;
        new Actions(androidDriver).click(deliveryChargeText).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(newDeliveryCharge).perform();
    }


    public void editCustomerNameWithInValidName(){
        String newCustomerName = "   " ;
        new Actions(androidDriver).click(customerNameText).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(newCustomerName).perform();
    }

    public void editDiscountWithInValidDiscount(){
        String newDiscount = "0";
        new Actions(androidDriver).click(discountText).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(newDiscount).perform();
    }

    public void editDeliveryChargeWithInValidDeliveryCharge(){
        String newDeliveryCharge = "0";
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
        String baseXpath = "//div[text()='Product Details']//parent::div//parent::div//parent::div/div[2]/div/div[2]/div/div/div["+productIndex+"]/div[1]//input";
        WebElement productName = androidDriver.findElement(By.xpath(baseXpath));
        new Actions(androidDriver).click(productName).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(newName).perform();
    }

    public void editProductQuantity(int productIndex,String newQty){
        String baseXpath = "//div[text()='Product Details']//parent::div//parent::div//parent::div/div[2]/div/div[2]/div/div/div["+productIndex+"]/div/div[2]//input";
        WebElement productQuantity = androidDriver.findElement(By.xpath(baseXpath));
        new Actions(androidDriver).click(productQuantity).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(newQty).perform();
    }

    public void editProductAmount(int productIndex,String newAmount){
        String baseXpath = "//div[text()='Product Details']//parent::div//parent::div//parent::div/div[2]/div/div[2]/div/div/div["+productIndex+"]/div/div[3]//input";
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


    public void editProductNameWithValidName(int productIndex){
        String newName = "productname " + random.nextInt(100) + " " + RandomStringUtils.randomAlphabetic(5) ;
        editProductName(productIndex,newName);
    }

    public void editProductQuantityWithValidQuantity(int productIndex){
        String newQty = String.valueOf(random.nextInt(10)+1) ;
        editProductQuantity(productIndex,newQty);
    }

    public void editProductAmountWithValidAmount(int productIndex){
        String newAmount = String.valueOf(random.nextInt(2000)+1) ;
        editProductAmount(productIndex,newAmount);
    }


    public void editProductNameWithInValidName(int productIndex){
        String newName = "  " ;
        editProductName(productIndex,newName);
    }

    public void editProductQuantityWithInValidQuantity(int productIndex){
        String newQty = "0" ;
        editProductQuantity(productIndex,newQty);
    }

    public void editProductAmountWithInValidAmount(int productIndex){
        String newAmount = "0" ;
        editProductAmount(productIndex,newAmount);
    }


    public void deleteProduct(int productIndex){
        String baseXpath = "//div[text()='Product Details']//parent::div//parent::div//parent::div/div[2]/div/div[2]/div/div/div["+productIndex+"]//div[contains(@role,'button')]";
        storeWapActions.action_click(androidDriver.findElement(By.xpath(baseXpath)));
    }

    public String getErrorMessage(){
        try {
            WebDriverWait wait = new WebDriverWait(getBaseDriver(), 30);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='css-1dbjc4n r-qur06v r-18u37iz r-1wtj0ep r-1e081e0 r-1f1sjgu']/div[1]"))).getText();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public String getSuccessMessage(){
        try {
            WebDriverWait wait = new WebDriverWait(getBaseDriver(), 30);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='successfully created']"))).getText();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}

