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

public class DeliveryDetailsPageObjects{

    private AndroidDriver<WebElement> androidDriver;
    private StoreWapActions storeWapActions;

    private Random random;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-13awgt0 r-1d5kdc7']//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][3]//div[contains(@data-testid,'navback')]")
    private WebElement backButton_DeliveryTab;

    @FindBy(xpath= "//div[@class='css-1dbjc4n r-13awgt0 r-1d5kdc7']//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][3]//div[contains(@data-testid,'headerTitle')]")
    private WebElement pageTitle_DeliveryTab;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-13awgt0 r-1d5kdc7']//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][3]//div[@class='css-1dbjc4n r-1awozwy r-13awgt0 r-18u37iz r-1wtj0ep']/div[2]")
    private WebElement sideNavButton_DeliveryTab;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-13awgt0 r-1d5kdc7']//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][5]//div[contains(@data-testid,'navback')]")
    private WebElement backButton_QuickOrderFlow;

    @FindBy(xpath= "//div[text()='Send to Delivery']//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//div[contains(@data-testid,'headerTitle')]")
    private WebElement pageTitle_QuickOrderFlow;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-13awgt0 r-1d5kdc7']//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][5]//div[@class='css-1dbjc4n r-1awozwy r-13awgt0 r-18u37iz r-1wtj0ep']/div[2]")
    private WebElement sideNavButton_QuickOrderFlow;

    @FindBy(xpath = "//div[text()='Customer Name']/following-sibling::input")
    private WebElement customerNameText;

    @FindBy(xpath = "//div[text()='Customer Phone Number']/following-sibling::input")
    private WebElement customerMobileNumberText;

    @FindBy(xpath = "//div[text()='Customer Address']/following-sibling::input")
    private WebElement customerAddressText;

    @FindBy(xpath = "//div[text()='Area Name']//parent::div/div[2]/div")   //
    private WebElement areaNameDropDownButton_DeliveryTab;

    @FindBy(xpath = "//div[text()='Enter cash collection amount']/following-sibling::div//input")
    private WebElement collectionAmountText;

    @FindBy(xpath = "//div[text()='Parcel Weight (in gram)']//parent::div/input")
    private WebElement parcelWeightText;

    @FindBy(xpath = "//div[text()=' Delivery Charge']/following-sibling::div")
    private WebElement deliveryChargeText;

    @FindBy(xpath = "//div[text()='Any Other Instructions']//following-sibling::input")  //
    private WebElement anyOtherInstructionText;

    @FindBy(xpath = "//div[text()='Pickup Address']//parent::div//parent::div/div[7]/div/div/div")
    private WebElement sellerNameText;

    @FindBy(xpath = "//div[text()='Pickup Address']//parent::div//parent::div/div[7]/div/div/div[2]")
    private WebElement pickupAddress;

    @FindBy(xpath = "//div[text()='Pickup Address']//parent::div//parent::div/div[7]/div/div/div[3]")
    private WebElement pickupArea1;

    @FindBy(xpath = "//div[text()='Pickup Address']//parent::div//parent::div/div[7]/div/div/div[4]")
    private WebElement pickupArea2;

    @FindBy(xpath = "//div[text()='Change Address']")
    private WebElement changePickupAddressButton;


    @FindBy(xpath = "//div[text()='Collectable Amount']//parent::div/div/span")
    private WebElement totalAmountText_DeliveryTab;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-13awgt0 r-1d5kdc7']//div[@class='css-1dbjc4n r-1p0dtai r-1d2f490 r-12vffkv r-u8s1d r-zchlnj r-ipm5af'][5]//span[@class='css-901oao css-16my406 r-jwli3a r-1fap712 r-ubezar r-vw2c0b']")
    private WebElement totalAmountText_QuickOrderFlow;

    @FindBy(xpath = "//div[text()='Delivery Instructions']//parent::div//parent::div//parent::div//parent::div//parent::div//div[text()='Send to Delivery']")
    private WebElement sendToDeliveryButton;

    @FindBy(xpath = "//input[contains(@placeholder,'Search')]")
    private WebElement searchAreaNameText;

    @FindBy(xpath = "//div[text()='View All Delivery']")
    private WebElement viewAllDeliveryButton;

    @FindBy(xpath = "//div[text()='Customer / Shipment Details']//parent::div//parent::div//parent::div//parent::div//parent::div/div/div/div[2]/div[1]")
    private WebElement shipmentDetails;

    @FindBy(xpath = "//div[@class='css-901oao r-jwli3a r-1fap712 r-1i10wst r-vw2c0b'][1]")
    private WebElement successfullySentForText;

    @FindBy(xpath = "//div[@class='css-901oao r-jwli3a r-1fap712 r-1i10wst r-vw2c0b'][2]")
    private WebElement deliveryText;

    public DeliveryDetailsPageObjects(AndroidDriver<WebElement> androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements((androidDriver), this);
        storeWapActions = new StoreWapActions();
    }

    /*------------------------------------------------Actions---------------------------------------------------------*/


    public void clickBackButton_DeliveryTab(){ storeWapActions.action_click(backButton_DeliveryTab);}

    public void clickSideNavButton_DeliveryTab(){ storeWapActions.action_click(sideNavButton_DeliveryTab);}

    public void clickBackButton_QuickOrderFlow(){ storeWapActions.action_click(backButton_QuickOrderFlow);}

    public void clickSideNavButton_QuickOrderFlow(){ storeWapActions.action_click(sideNavButton_QuickOrderFlow);}

    public void clickAreaDropdownButton(){ storeWapActions.action_click(areaNameDropDownButton_DeliveryTab);}

    public void clickChangePickUpAddressButton(){ storeWapActions.action_click(changePickupAddressButton);}

    public void clickSendToDeliveryButton(){ storeWapActions.action_click(sendToDeliveryButton);}



    /*-----------------------------------------------Functions--------------------------------------------------------*/

    public void enterCustomerName(String name){ storeWapActions.action_sendKeys(customerNameText,name);}

    public void enterCustomerMobileNumber(String mobileNumber){ storeWapActions.action_sendKeys(customerMobileNumberText,mobileNumber);}

    public void enterCustomerAddress(String address){ storeWapActions.action_sendKeys(customerAddressText,address);}

    public void enterCollectionAmount(String amount){ storeWapActions.action_sendKeys(collectionAmountText,amount);}

    public void enterParcelWeight(String weight){ storeWapActions.action_sendKeys(parcelWeightText,weight);}

    public void enterAnyOtherInstruction(String instruction){ storeWapActions.action_sendKeys(anyOtherInstructionText,instruction);}

    /*----------------------------------------------------------*/

    public void editCustomerName(String name){
        new Actions(androidDriver).click(customerNameText).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(name).perform();
        }

    public void editCustomerMobileNumber(String mobileNumber){
        new Actions(androidDriver).click(customerMobileNumberText).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(mobileNumber).perform();
        }

    public void editCustomerAddress(String address){
        new Actions(androidDriver).click(customerAddressText).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(address).perform();
        }

    public void editCollectionAmount(String amount){
        new Actions(androidDriver).click(collectionAmountText).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(amount).perform();
        }

    public void editParcelWeight(String weight){
        new Actions(androidDriver).click(parcelWeightText).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(weight).perform();
        }

    public void editAnyOtherInstruction(String instruction){
        new Actions(androidDriver).click(anyOtherInstructionText).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(instruction).perform();
        }

    /*-------------------------------------------------------------*/

    public  void enterInValidCustomerName(){
        String name = "@#$";
        enterCustomerName(name);
    }

    public void enterInValidMobileNumber(){
        String number = "12345678922" ;
        enterCustomerMobileNumber(number);
    }

    public void enterInValidCustomerAddress(){
        String address = "      ";
        enterCustomerAddress(address);
    }

    public void enterValidName(){
        String newCustomerName = "AutomatioN - test'ing "+ RandomStringUtils.randomAlphabetic(5) ;
        enterCustomerName(newCustomerName);
    }

    public void enterValidMobileNumber(){
        String newMobileNumber = "018"+ RandomStringUtils.randomNumeric(8);
        enterCustomerMobileNumber(newMobileNumber);
    }

    public void enterValidAddress(){
        String newAddress = random.nextInt(99) + " " + RandomStringUtils.randomAlphabetic(5) + ", "+random.nextInt(99) + " " + RandomStringUtils.randomAlphabetic(5) + ".";
        enterCustomerAddress(newAddress);
    }

    /*-------------------------------------------------------------*/

    public  void editNameWithInValidCustomerName(){
        String name = "@#$";
        editCustomerName(name);
    }

    public void editMobileNumberWithInValidMobileNumber(){
        String number = "12345678922" ;
        editCustomerMobileNumber(number);
    }

    public void editAddressWithInValidCustomerAddress(){
        String address = "      ";
        editCustomerAddress(address);
    }

    public void editNameWithValidName(){
        String newCustomerName = "AutomatioN - test'ing "+ RandomStringUtils.randomAlphabetic(5) ;
        editCustomerName(newCustomerName);
    }

    public void editMobileNumberWithValidMobileNumber(){
        String newMobileNumber = "018"+ RandomStringUtils.randomNumeric(8);
        editCustomerMobileNumber(newMobileNumber);
    }

    public void editAddressWithValidAddress(){
        String newAddress = random.nextInt(99) + " " + RandomStringUtils.randomAlphabetic(5) + ", "+random.nextInt(99) + " " + RandomStringUtils.randomAlphabetic(5) + ".";
        editCustomerAddress(newAddress);
    }


    /*-------------------------------------------------------------*/


    public void chooseAreaName(int areaIndex){
        storeWapActions.action_click(areaNameDropDownButton_DeliveryTab);
        String xpath = "//input[contains(@placeholder,'Search')]//parent::div//parent::div/div["+areaIndex+"]/div/div/div/div";
        WebElement area = androidDriver.findElement(By.xpath(xpath));
        storeWapActions.action_click(area);
    }

    public void selectCourier(int courierIndex){
        String xpath = "//div[text()='Select Courier']//parent::div/div[2]/select/option["+courierIndex+"]" ;
        storeWapActions.action_click(androidDriver.findElement(By.xpath(xpath)));
    }

    public void selectPreferredDeliveryDay(int index){
        String xpath = "//div[text()='Preferred Delivery Day']//parent::div//parent::div/div[2]/div/div/div["+index+"]" ;
        storeWapActions.action_click(androidDriver.findElement(By.xpath(xpath)));
    }

    public void selectPreferredDeliveryTime(int index){
        String xpath = "//div[text()='Preferred Delivery Day']//parent::div//parent::div/div[5]/div/div/div/div/div["+index+"]";
        storeWapActions.action_click(androidDriver.findElement(By.xpath(xpath)));
    }

    public void searchAreaNameInAreaDropdown(String areaName){
        storeWapActions.action_sendKeys(searchAreaNameText,areaName);
        chooseAreaName(1);
    }


    public String  getPageTitle_DeliveryTab(){
        return storeWapActions.action_getText(pageTitle_DeliveryTab);
    }

    public String getPageTitle_QuickOrderFlow(){
        return storeWapActions.action_getText(pageTitle_QuickOrderFlow);
    }

    public String getDeliveryCharge(){
        return storeWapActions.action_getText(deliveryChargeText);
    }

    public String getSellerName(){
        return storeWapActions.action_getText(sellerNameText);
    }

    public String getPickUpAddress(){
        return storeWapActions.action_getText(pickupAddress);
    }

    public String getPickUpArea(){
        String area1 = storeWapActions.action_getText(pickupArea1);
        String area2 = storeWapActions.action_getText(pickupArea2);
        String area = area1+area2;
        return area;
    }

    public String getTotalAmount_DeliveryTab(){
        String total = storeWapActions.action_getText(totalAmountText_DeliveryTab);
        return total;
    }

    public String getTotalAmount_QuickOrderFlow(){
        String total = storeWapActions.action_getText(totalAmountText_QuickOrderFlow);
        return total;
    }


    public String getCustomerNameErrorMessage(){
        try{
            WebDriverWait wait = new WebDriverWait(getBaseDriver(),30);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Pickup Address']//parent::div//parent::div/div/div[2]/div[2]/div"))).getText();
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public String getCustomerMobileNumberErrorMessage(){
        try{
            WebDriverWait wait = new WebDriverWait(getBaseDriver(),30);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Pickup Address']//parent::div//parent::div/div/div[3]/div[2]/div"))).getText();
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public String getCustomerAddressErrorMessage(){
        try{
            WebDriverWait wait = new WebDriverWait(getBaseDriver(),30);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Pickup Address']//parent::div//parent::div/div/div[4]/div[2]/div"))).getText();
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public String getParcelWeightErrorMessage(){
        try{
            WebDriverWait wait = new WebDriverWait(getBaseDriver(),30);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Pickup Address']//parent::div//parent::div/div/div[8]/div[2]/div"))).getText();
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public String getCollectionAmountErrorMessage(){
        try{
            WebDriverWait wait = new WebDriverWait(getBaseDriver(),30);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Pickup Address']//parent::div//parent::div/div/div[6]/div[2]/div"))).getText();
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public String getPreferredDeliveryDayErrorMessage(){
        try{
            WebDriverWait wait = new WebDriverWait(getBaseDriver(),30);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Pickup Address']//parent::div//parent::div/div[4]/div[3]"))).getText();
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public String getPreferredDeliveryTimeErrorMessage(){
        try{
            WebDriverWait wait = new WebDriverWait(getBaseDriver(),30);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Pickup Address']//parent::div//parent::div/div[4]/div[6]"))).getText();
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public String getSuccessfullySentForDeliveryText(){
        return storeWapActions.action_getText(successfullySentForText)+" "+storeWapActions.action_getText(deliveryText);
    }

    public String getShipmentDetails(){
        return storeWapActions.action_getText(shipmentDetails);
    }


}