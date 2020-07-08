package pageObjects;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MyActions;

import java.awt.geom.Area;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static utils.WebAppBaseClass.*;

public class AddressPageObjects {
    private AndroidDriver<WebElement> driver = getBaseDriver();
    private final MyActions myActions;
    private final Random random;
    TouchAction touch;

    public AddressPageObjects(AndroidDriver<WebElement> androidDriver) throws Exception {
        this.driver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        myActions = new MyActions();
        random = new Random();
        touch = new TouchAction(driver);
    }

    //movetohome
    @FindBy(xpath = "//div[@class='text-center']/a/img")
    private WebElement home;

    //ProceedToPayment
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement ProceedToPaymentButton;

    //selectAddress
    @FindBy(xpath = "//input[@id='address_select_inner0']")
    private WebElement selectAddress;

    //Show More Addresses
    @FindBy(xpath = "//span[contains(text(),'Show More Addresses')]")
    private WebElement ShowMoreAddressesButton;

    //Add New Address
    @FindBy(xpath = "//span[contains(text(),'Add New Address')]")
    private WebElement AddNewAddressButton;

    //firstName
    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement FirstName;

    //phonenumber
    @FindBy(xpath = "//input[@name='phone']")
    private WebElement PhoneNumber;

    //alternativePhoneNumber
    @FindBy(xpath = "//input[@name='alternative_phone']")
    private WebElement AlternativePhoneNumber;

    //address
    @FindBy(xpath = "//input[@name='address1']")
    private WebElement Address_S;

    //fromDropDown
    @FindBy(xpath = "//div[@id='react-autowhatever-1']/ul/li[1]")
    private WebElement chooseFromDropDown;

    //locality
    @FindBy(xpath = "//input[@name='address2']")
    private WebElement Locality_S;

    //landmark
    @FindBy(xpath = "//input[@name='landmark']")
    private WebElement Landmark_S;

    //Area
    @FindBy(xpath = "//div[@class='inputsearch inputSearch___13R7q']")
    private WebElement Area_s;

    //TemporarySave
    @FindBy(xpath = "//button[@class='flat___n-myg primary___OLr69 button___3btga ripple___1U_Uk contain___ux0BW next']")
    private WebElement TemporarySave;

    //permanentSave
    @FindBy(xpath = "//span[contains(text(),'Save Address')]")
    private WebElement PermanentSave;

    //Back to Addresses
    @FindBy(xpath = "//span[contains(text(),'Back to Addresses')]")
    private WebElement BacktoAddressesButton;

    //change-address-text
    @FindBy(xpath = "//a[@class='change-address-text']")
    private WebElement ChangeAddress;

    //Click for Payment Breakup
    @FindBy(xpath = "//p[contains(text(),'Click for Payment Breakup')]")
    private WebElement PaymentBreakup;

    //closepaymentbreakup
    @FindBy(xpath = "//div[@class='modal-footer']/p")
    private WebElement close;

    //selectCashonDelivery
    @FindBy(xpath = "//a[@class='collapsed']")
    private WebElement CashOnDelivery;

    //makepayment
    @FindBy(xpath = "//div[@class='proceed-checkout text-center']")
    private WebElement MakePayment;

/*----------Actions---------*/

    public void moveToHome(){myActions.action_click(home);}

    public void clickOnProceedToPaymentButton(){myActions.action_click(ProceedToPaymentButton);}

    public void clickOnAddress(){myActions.action_click(selectAddress);}

    public void clickOnShowMoreAddressesButton(){myActions.action_click(ShowMoreAddressesButton);}

    public void clickOnAddNewAddressButton(){myActions.action_click(AddNewAddressButton);}

    public void EnterFirstName(String Name){myActions.action_sendKeys(FirstName,Name);}

    public void EnterPhoneNumber(String Number){myActions.action_sendKeys(PhoneNumber,Number);}

    public void EnterAlternativePhoneNumber(String Alternative){myActions.action_sendKeys(AlternativePhoneNumber,Alternative);}

    public void EnterAddress(String Address){myActions.action_sendKeys(Address_S,Address);}

    public void chooseArea(){myActions.action_click(chooseFromDropDown);}

    public void EnterLocality(String Locality){myActions.action_sendKeys(Locality_S,Locality);}

    public void EnterLandmark(String Landmark){myActions.action_sendKeys(Landmark_S,Landmark);}

    public void ChooseArea(){myActions.action_click(Area_s);}

    public void EnterArea(String Area){myActions.action_sendKeys(Area_s,Area);}

    public void clickOnSaveAddress(){myActions.action_click(TemporarySave);}

    public void clickOnSave(){myActions.action_click(PermanentSave);}

    public void clickOnbackToAddress(){myActions.action_click(BacktoAddressesButton);}

    public void clickOnChangeAddress(){myActions.action_click(ChangeAddress);}

    public void clickOnPaymentBreakup(){myActions.action_click(PaymentBreakup);}

    public void closePaymentBreakup(){myActions.action_click(close);}

    public void clickOnCashOnDelivery(){myActions.action_click(CashOnDelivery);}

    public void clickOnMakePayment(){myActions.action_click(MakePayment);}

    /*-------Functions----------*/

     public void placingOrderwithExistingAddress() throws Exception {
         clickOnShowMoreAddressesButton();
         selectaddress(0);
         clickOnProceedToPaymentButton();
     }

     public void placingOrderwithNewAddress(String name,String address,String locality,String number) throws InterruptedException {
         clickOnAddNewAddressButton();
         EnterFirstName(name);
         driver.hideKeyboard();
         ChooseArea();
         chooseArea();
         EnterAddress(address);
         driver.hideKeyboard();
         EnterLocality(locality);
         driver.hideKeyboard();
         EnterPhoneNumber(number);
         driver.hideKeyboard();
         touch.press(PointOption.point(0,800)).waitAction().moveTo(PointOption.point(0,100)).release().perform();
         clickOnSaveAddress();
         sleep(3500);
         clickOnCashOnDelivery();
         sleep(2000);
         clickOnMakePayment();
     }


   /*-------dynamicfunctions-------*/

    String addressXpath ="//div[@class='address_select_inner']//div[@class='select_address_inputs']/ul/li";
    List<WebElement> addresslist = driver.findElements(By.xpath(addressXpath));

    public int selectaddress(int addressid) throws Exception {
        String address;
        int Address;
        if(addressid != 0){
            address = addressXpath+"["+addressid+"]/label";
            Address = addressid;
        } else {
            int id = random.nextInt(addresslist.size());
            address = addressXpath+"["+ ++id +"]/label";
            Address = id;
        }
        WebElement addresselement = driver.findElement(By.xpath(address));
        myActions.action_click(addresselement);
        sleep(2000);
        for(int i = Address; i < addresslist.size(); i+=4){
            myActions.swipe(1,0);
        }
        return Address;
    }

    public void editaddress(int addressid){
        String address;
        if(addressid != 0){
            address = addressXpath+"["+addressid+"]//div[@class='edit-delete-address editAddress']/p/span";
        } else {
            int id = random.nextInt(addresslist.size());
            address = addressXpath+"["+ ++id +"]//div[@class='edit-delete-address editAddress']/p/span";
        }
        WebElement addresselement = driver.findElement(By.xpath(address));
        myActions.action_click(addresselement);
    }

    public void deleteaddress(int addressid){
        String address;
        if(addressid != 0){
            address = addressXpath+"["+addressid+"]//div[@class='edit-delete-address']/span";
        } else {
            int id = random.nextInt(addresslist.size());
            address = addressXpath+"["+ ++id +"]//div[@class='edit-delete-address']/span";
        }
        WebElement addresselement = driver.findElement(By.xpath(address));
        myActions.action_click(addresselement);
    }

    String productXpath = "//div[@class='text-left']/ul/li";
    List<WebElement> productslist = driver.findElements(By.xpath(productXpath));

    public String getEstimatedDeliverytime(int productid){
        String product;
        if(productid != 0){
            product = productXpath+"["+productid+"]//div[@class='col-xs-9 dates_no_item_left text-left']/p[1]/span";
        }else {
            int id = random.nextInt(productslist.size());
            product = productXpath+"["+ ++id +"]//div[@class='col-xs-9 dates_no_item_left text-left']/p[1]/span";
        }
        WebElement productElement = driver.findElement(By.xpath(product));
        return myActions.action_getText(productElement);
    }

    public void deleteProduct(int productid){
        String product;
        if(productid != 0){
            product = productXpath+"["+productid+"]//div[@class='col-xs-9 dates_no_item_left text-left']/p[2]/span";
        }else {
            int id = random.nextInt(productslist.size());
            product = productXpath+"["+ ++id +"]//div[@class='col-xs-9 dates_no_item_left text-left']/p[2]/span";
        }
        WebElement productElement = driver.findElement(By.xpath(product));
        myActions.action_click(productElement);
    }



}