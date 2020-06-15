package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

public class AddressPageObject {
    private WebDriver driver;
    private MyActions myActions;
    /*-------click  on existing address--------*/
    //click old address
    @FindBy(xpath = "//button[text()='ADD NEW ADDRESS']")
    private WebElement OldAddressICon;
    //Proceed to payment button
    @FindBy(xpath = "//button[text()='PROCEED TO PAYMENT']")
    private WebElement proceedToPaymentButton;
    //ADD NEW ADDRESS BUTTON
    @FindBy(xpath = "//button[text()='ADD NEW ADDRESS']")
    private WebElement addNewAddressButton;


    /*---------click on new address--------*/
    //name
    @FindBy(xpath = "//button[text()='ADD NEW ADDRESS']")
    private WebElement nameBarText;
    @FindBy(xpath = "//input[@type='text'][@name='address1']")
    private WebElement addressBarText;

    //address
    //Locality
    @FindBy(xpath = "//input[@type='text'][@name='address2']")
    private WebElement localityBarText;
    //Landmark
    @FindBy(xpath = "//input[@type='text'][@name='landmark']")
    private WebElement landmarkBarText;
    //Mobile Number
    @FindBy(xpath = "//input[@type='text'][@name='phone']")
    private WebElement mobilenumberBarText;
    //Choose area
    @FindBy(xpath = "//input[@type='text'][@name='zipcode']")
    private WebElement chooseAreaIcon;
    //Alternate mobile number
    @FindBy(xpath = "//input[@type='text'][@name='alternative_phone']")
    private WebElement alternateMobileNumberBarText;
    //Select Adobe Dhaka
    @FindBy(xpath = "//div[text()='Adabor, Dhaka']")
    private WebElement adobeDhakaOption;
    //Save Address Option
    @FindBy(xpath = "//span[contains(text(),'Save Address')]")
    private WebElement saveAddressOption;
    //Save button
    @FindBy(xpath = "//button[text()='SAVE']")
    private WebElement saveButton;
    //back to address option
    @FindBy(xpath = "//button[contains(text(),'BACK TO ADDRESSES')]")
    private WebElement backToAddressIcon;
    //Home Icon
    @FindBy(xpath = "//span[text()='HOME']")
    private WebElement homeIcon;
    //Office Icon
    @FindBy(xpath = "//span[text()='OFFICE']")
    private WebElement officeIcon;
    //Delete product option
    @FindBy(xpath = "//span[text()='DELETE']")
    private WebElement deleteProductIcon;

    public AddressPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
    }

    /*----------actions-------*/
    public void enterName(String name) {
        myActions.action_sendKeys(nameBarText, name);
    }

    public void enterAddress(String address) {
        myActions.action_sendKeys(addressBarText, address);
    }

    public void enterLocality(String locality) {
        myActions.action_sendKeys(localityBarText, locality);
    }


    public void enterLandmark(String landmark) {
        myActions.action_sendKeys(landmarkBarText, landmark);
    }

    public void enterMobileNumber(String mobilenumber) {
        myActions.action_sendKeys(mobilenumberBarText, mobilenumber);
    }

    public void enterAlternateMobile(String alternatemobilenumber) {
        myActions.action_sendKeys(alternateMobileNumberBarText, alternatemobilenumber);
    }
}
