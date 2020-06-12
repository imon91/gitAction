package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

public class AddressPageObjects {
    private AndroidDriver<WebElement> driver;
    private MyActions myActions;

    public AddressPageObjects(AndroidDriver<WebElement> androidDriver) {
        this.driver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        myActions = new MyActions();
    }

    //ProceedToPayment
    @FindBy(xpath = "//div[@class='summary_checkout text-center place-order ']")
    private WebElement ProceedToPaymentButton;

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
    @FindBy(xpath = "/input[@name='address1']")
    private WebElement Address_S;

    //locality
    @FindBy(xpath = "//input[@name='address2']")
    private WebElement Locality_S;

    //landmark
    @FindBy(xpath = "//input[@name='landmark']")
    private WebElement Landmark_S;

    //Area
    @FindBy(xpath = "//input[@name='zipcode']")
    private WebElement Area_s;

    //TemporarySave
    @FindBy(xpath = "//button[@type='submit']")
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

    //selectCashonDelivery
    @FindBy(xpath = "//a[contains(text(),'CASH ON DELIVERY')]")
    private WebElement CashOnDelivery;

    //makepayment
    @FindBy(xpath = "//div[@class='proceed-checkout text-center']")
    private WebElement MakePayment;

/*----------Actions---------*/

    public void clickOnProceedToPaymentButton(){myActions.action_click(ProceedToPaymentButton);};

    public void clickOnShowMoreAddressesButton(){myActions.action_click(ShowMoreAddressesButton);};

    public void clickOnAddNewAddressButton(){myActions.action_click(AddNewAddressButton);};

    public void EnterFirstName(String Name){myActions.action_sendKeys(FirstName,Name);};

    public void EnterPhoneNumber(String Number){myActions.action_sendKeys(PhoneNumber,Number);};

    public void EnterAlternativePhoneNumber(String Alternative){myActions.action_sendKeys(AlternativePhoneNumber,Alternative);};

    public void EnterAddress(String Address){myActions.action_sendKeys(Address_S,Address);};

    public void EnterLocality(String Locality){myActions.action_sendKeys(Locality_S,Locality);};

    public void EnterLandmark(String Landmark){myActions.action_sendKeys(Landmark_S,Landmark);};

    public void EnterArea(String Area){myActions.action_sendKeys(Area_s,Area);};

    public void clickOnSaveAddress(){myActions.action_click(TemporarySave);};

    public void clickOnSave(){myActions.action_click(PermanentSave);};

    public void clickOnbackToAddress(){myActions.action_click(BacktoAddressesButton);};

    public void clickOnChangeAddress(){myActions.action_click(ChangeAddress);};

    public void clickOnPaymentBreakup(){myActions.action_click(PaymentBreakup);};

    public void clickOnCashOnDelivery(){myActions.action_click(CashOnDelivery);};

    public void clickOnMakePayment(){myActions.action_click(MakePayment);};

}