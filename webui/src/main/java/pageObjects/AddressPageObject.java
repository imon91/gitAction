package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

public class AddressPageObject {
    private WebDriver driver;
    private MyActions myActions;


    public AddressPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
    }

    /*-------click  on existing address--------*/
    //click old address
    @FindBy(xpath = "//div[@class='select_address_inputs']/ul/li[1]/label")
    private WebElement oldAddressICon;

    //Proceed to payment button
    @FindBy(xpath = "//button[text()='PROCEED TO PAYMENT']")
    private WebElement proceedToPaymentButton;

    //ADD NEW ADDRESS BUTTON
    @FindBy(xpath = "//button[text()='ADD NEW ADDRESS']")
    private WebElement addNewAddressButton;


    /*---------click on new address--------*/
    //name
    @FindBy(xpath = "//input[@type='text'][@name='firstname']")
    private WebElement nameBarText;

    //address
    @FindBy(xpath = "//input[@type='text'][@name='address1']")
    private WebElement addressBarText;

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



    /*----------actions-------*/

    public void clickOnOldAddress() { myActions.action_click(oldAddressICon); }

    public void clickOnProceedToPayment() { myActions.action_click(proceedToPaymentButton); }

    private void clickOnAddNewAddressIcon() { myActions.action_click(addNewAddressButton); }

    private void clickHome() {
        myActions.action_click(homeIcon);
    }

    private void enterName(String name) {
        myActions.action_sendKeys(nameBarText, name);
    }

    private void enterAddress(String address) {
        myActions.action_sendKeys(addressBarText, address);
    }

    private void enterLocality(String locality) {
        myActions.action_sendKeys(localityBarText, locality);
    }

    private void clickChooseArea() {
        myActions.action_click(chooseAreaIcon);
    }

    private void clickAdobeDhaka() {
        myActions.action_click(adobeDhakaOption);
    }

    private void enterLandmark(String landmark) {
        myActions.action_sendKeys(landmarkBarText, landmark);
    }

    private void clickOnSaveButton() {
        myActions.action_click(saveButton);
    }

    private void enterMobileNumber(String mobilenumber) {
        myActions.action_sendKeys(mobilenumberBarText, mobilenumber);
    }

    private void enterAlternateMobile(String alternatemobilenumber) { myActions.action_sendKeys(alternateMobileNumberBarText, alternatemobilenumber);}






    /*---------Function-----*/

    public void createNewAddress(String name){
        clickOnAddNewAddressIcon();
        clickHome();
        enterName(name);
        enterAddress("Shopup street");
        enterLocality("dhaka");
        clickChooseArea();
        clickAdobeDhaka();
        enterMobileNumber("01877755590");
        clickOnSaveButton();
    }

}
