package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

public class WarehousesPageObjects {
    private WebDriver driver;
    private MyActions myActions;

    public WarehousesPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        myActions = new MyActions();
    }

    //Add Warehouse Tab
    @FindBy(xpath = "//a[text()='Add Warehouse']")
    private WebElement addWarehouseTab;

    //Warehouse List Tab
    @FindBy(xpath = "//a[text()='Warehouses List']")
    private WebElement warehousesListTab;

    //Update Bin Capacity
    @FindBy(xpath = "//a[text()='Update Bin Capacity']")
    private WebElement updateBinCapacityTab;

    //Warehouse Bin Details
    @FindBy(xpath = "//a[text()='Warehouse Bin Details']")
    private WebElement binDetailsTab;

    //Enter Warehouse Code
    @FindBy(xpath = "//input[@id='warehouseCode']")
    private WebElement warehouseCodeEntry;

    //Enter Name
    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement warehouseNameEntry;

    //Enter Address Line 1
    @FindBy(xpath = "//input[@id='warehouseAddress']")
    private WebElement warehouseAddressEntry1;

    //Enter Address Line 2
    @FindBy(xpath = "//input[@id='warehouseAddress2']")
    private WebElement warehouseAddressEntry2;

    //Enter Landmark
    @FindBy(xpath = "//input[@id='warehouseLandmark']")
    private WebElement warehouseLandmarkEntry;

    //Enter City
    @FindBy(xpath = "//input[@id='warehouseCity']")
    private WebElement warehouseCityEntry;

    //Enter State
    @FindBy(xpath = "//input[@id='warehouseState']")
    private WebElement warehouseStateEntry;

    //Enter Country
    @FindBy(xpath = "//input[@id='warehouseCountry']")
    private WebElement warehouseCountryEntry;

    //Enter Zipcode
    @FindBy(xpath = "//input[@id='Zipcode']")
    private WebElement warehouseZipcodeEntry;

    //Enter Phone Number
    @FindBy(xpath = "//input[@id='phone']")
    private WebElement warehousePhoneNumberEntry;

    //Enter
    @FindBy(xpath = "//input[@id='alternative_phone']")
    private WebElement warehouseAlternativePhoneEntry;

    //Enter
    @FindBy(xpath = "//button[text()='Add Warehouse']")
    private WebElement addWarehouseButton;

    //Enter Bin Code Update Bin Capacity
    @FindBy(xpath = "//input[@id='binCapacityBincode']")
    private WebElement binCodeUpdateCapacity;

    //Enter Bin Capacity
    @FindBy(xpath = "//input[@id='binCapacity']")
    private WebElement binCapacityUpdateCapacity;

    //Enter Bin Code
    @FindBy(xpath = "//input[@id='BinDetailBinCode']")
    private WebElement binCodeBinDetails;

    //Update Capacity Button
    @FindBy(xpath = "//button[text()='Update Bin Capacity']")
    private WebElement updateCapacityButton;



    /*--------------Actions-------------------*/
    public void clickAddWarehouse() {myActions.action_click(addWarehouseTab);}

    public void clickWarehouseListTab(){myActions.action_click(warehousesListTab);}

    public void clickUpdateBinCapacityTab(){myActions.action_click(updateBinCapacityTab);}

    public void clickBinDetailsTab(){myActions.action_click(binDetailsTab);}



    /*--------------Functions-------------------*/
    public void addNewWarehouse(String binCode, String name, String address1, String address2,
                                String landmark, String city, String state, String country,
                                String zipcode, String phone_no, String alter_phone_no) {
        myActions.action_sendKeys(warehouseCodeEntry, binCode);
        myActions.action_sendKeys(warehouseNameEntry, name);
        myActions.action_sendKeys(warehouseAddressEntry1, address1);
        myActions.action_sendKeys(warehouseAddressEntry2, address2);
        myActions.action_sendKeys(warehouseLandmarkEntry, landmark);
        myActions.action_sendKeys(warehouseCityEntry, city);
        myActions.action_sendKeys(warehouseStateEntry, state);
        myActions.action_sendKeys(warehouseCountryEntry, country);
        myActions.action_sendKeys(warehouseZipcodeEntry,zipcode);
        myActions.action_sendKeys(warehousePhoneNumberEntry, phone_no);
        myActions.action_sendKeys(warehouseAlternativePhoneEntry, alter_phone_no);
        myActions.action_click(addWarehouseButton);
    }

    public void updateBinCapacity(String binCode, String capacity){
        myActions.action_sendKeys(binCodeUpdateCapacity,binCode);
        myActions.action_sendKeys(binCapacityUpdateCapacity,capacity);
        myActions.action_click(updateCapacityButton);
    }

    public void getBinDetails(String binCode){myActions.action_sendKeys(binCodeBinDetails,binCode);}
}
