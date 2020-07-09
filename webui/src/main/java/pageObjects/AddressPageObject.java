package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

import java.util.List;
import java.util.Random;

import static utils.WebBaseClass.sleep;

public class AddressPageObject {
    private WebDriver driver;
    private MyActions myActions;
    private Random random;


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

    public void clickOnOldAddress() {
        myActions.action_click(oldAddressICon);
    }

    public void clickOnProceedToPayment() {
        myActions.action_click(proceedToPaymentButton);
    }

    private void clickOnAddNewAddressIcon() {
        myActions.action_click(addNewAddressButton);
    }

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

    private void enterAlternateMobile(String alternatemobilenumber) {
        myActions.action_sendKeys(alternateMobileNumberBarText, alternatemobilenumber);
    }






    /*---------Function-----*/

    public void createNewAddress(String name) {
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


    ////////////////////////////*Dynamic Xpath function*//////////////////////////////
    public String editAddress(int addressIndex) {
        String addressXpath = "//ul[@class='list-inline select_address_radio_list flex']/li";
        List<WebElement> addressList = driver.findElements(By.xpath(addressXpath));
        String address, addressName, addressname;
        if (addressIndex != 0) {
            address = addressXpath + "[" + addressIndex + "]//input";
            addressname = addressXpath + "[" + addressIndex + "]/label/p[1]";
        } else {
            int index = random.nextInt(addressList.size());
            address = addressXpath + "[" + ++index + "]//input";
            addressname = addressXpath + "[" + ++index + "]/label/p[1]";
        }
        WebElement clickaddress = driver.findElement(By.xpath(address));
        WebElement addressnam = driver.findElement(By.xpath(addressname));
        addressName = myActions.action_getText(addressnam);
        myActions.action_click(clickaddress);
        return addressName;
    }


    //Click edit address Button
    public String editAddress(int addressIndex, String address_Name) {
        String addressXpath = "//ul[@class='list-inline select_address_radio_list flex']/li";
        List<WebElement> addressList = driver.findElements(By.xpath(addressXpath));
        String addressName, addressname, edit;
        if (addressIndex != 0) {
            edit = addressXpath + "[" + addressIndex + "]//p[@class='edit-delete']/span[1]";
            addressname = addressXpath + "[" + addressIndex + "]/label/p[1]";
        } else {
            int index = random.nextInt(addressList.size());
            edit = addressXpath + "[" + ++index + "]//p[@class='edit-delete']/span[1]";
            addressname = addressXpath + "[" + ++index + "]/label/p[1]";
        }
        WebElement clickedit = driver.findElement(By.xpath(edit));
        WebElement addressnam = driver.findElement(By.xpath(addressname));
        addressName = myActions.action_getText(addressnam);
        myActions.action_click(clickedit);
        return addressName;
    }

    //Click on delete Button
    public String deleteAddress(int addressIndex) {
        String addressXpath = "//ul[@class='list-inline select_address_radio_list flex']/li";
        List<WebElement> addressList = driver.findElements(By.xpath(addressXpath));
        String addressName, addressname, delete;
        if (addressIndex != 0) {
            delete = addressXpath + "[" + addressIndex + "]//p[@class='edit-delete']/span[2]";
            addressname = addressXpath + "[" + addressIndex + "]/label/p[1]";
        } else {
            int index = random.nextInt(addressList.size());
            delete = addressXpath + "[" + ++index + "]//p[@class='edit-delete']/span[2]";
            addressname = addressXpath + "[" + ++index + "]/label/p[1]";
        }
        WebElement clickdelete = driver.findElement(By.xpath(delete));
        WebElement addressnam = driver.findElement(By.xpath(addressname));
        addressName = myActions.action_getText(addressnam);
        myActions.action_click(clickdelete);
        return addressName;
    }

    //delete product in address page
    //Click on delete product at address page
    public void deleteProduct(int productIndex) {
        String addressname, delete;
        if (productIndex != 0) {
            String productXpath = "//div[@class='text-left']/ul/li";
            List<WebElement> productList = driver.findElements(By.xpath(productXpath));
            delete = productXpath + "[" + productIndex + "]//p[2]/span";
        } else {
            String productXpath = "//div[@class='text-left']/ul/li";
            List<WebElement> productList = driver.findElements(By.xpath(productXpath));
            int index = random.nextInt(productList.size());
            delete = productXpath + "[" + ++index + "]//p[2]/span";
        }
        WebElement clickdelete = driver.findElement(By.xpath(delete));
        myActions.action_click(clickdelete);
    }

    //total item in address page
    public String getTotalQuantityInAddressPage() {
        String quantitypath = "//div[@class='cart-value-right_header']/p/span[2]";
        WebElement totQuantity = driver.findElement(By.xpath(quantitypath));
        String totalQuantity = myActions.action_getText(totQuantity);
        return totalQuantity;
    }

    //total cost or value at addresspage
    public String getTotalCostInAddressPage() {
        String costpath = "//div[@class='cart-value-right_header']/h2/span[2]";
        WebElement totCost = driver.findElement(By.xpath(costpath));
        String totalCost = myActions.action_getText(totCost);
        return totalCost;
    }


    //Delete the product which COD was not available
}

