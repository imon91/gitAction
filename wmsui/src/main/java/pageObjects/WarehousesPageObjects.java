package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;
import utils.WmsBaseClass;

import java.util.List;
import java.util.Random;

public class WarehousesPageObjects extends WmsBaseClass {
    private final WebDriver driver;
    private final MyActions myActions;

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

    //Update Bin Capacity Tab
    @FindBy(xpath = "//a[text()='Update Bin Capacity']")
    private WebElement updateBinCapacityTab;

    //Warehouse Bin Details Tab
    @FindBy(xpath = "//a[text()='Warehouse Bin Details']")
    private WebElement binDetailsTab;


    /*--------------Actions-------------------*/
    public void clickAddWarehouseTab() {
        myActions.action_click(addWarehouseTab);
    }

    public void clickWarehouseListTab() {
        myActions.action_click(warehousesListTab);
    }

    public void clickUpdateBinCapacityTab() {
        myActions.action_click(updateBinCapacityTab);
    }

    public void clickBinDetailsTab() {
        myActions.action_click(binDetailsTab);
    }


    /*--------------Add Warehouse Tab-------------------*/
    public class AddWarehouseTab {
        private final WebDriver driver;
        private final MyActions myActions;
        private final Random random;

        public AddWarehouseTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
            random = new Random();
        }

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


        /*--------------Actions-------------------*/
        public void enterWarehouseCode(String binCode) {
            myActions.action_sendKeys(warehouseCodeEntry, binCode);
        }

        public void enterName(String name) {
            myActions.action_sendKeys(warehouseNameEntry, name);
        }

        public void enterAddress1(String address1) {
            myActions.action_sendKeys(warehouseAddressEntry1, address1);
        }

        public void enterAddress2(String address2) {
            myActions.action_sendKeys(warehouseAddressEntry2, address2);
        }

        public void enterLandmark(String landmark) {
            myActions.action_sendKeys(warehouseLandmarkEntry, landmark);
        }

        public void enterCity(String city) {
            myActions.action_sendKeys(warehouseCityEntry, city);
        }

        public void enterState(String state) {
            myActions.action_sendKeys(warehouseStateEntry, state);
        }

        public void enterCountry(String country) {
            myActions.action_sendKeys(warehouseCountryEntry, country);
        }

        public void enterZipcode(String zipcode) {
            myActions.action_sendKeys(warehouseZipcodeEntry, zipcode);
        }

        public void enterPhoneNo(String phone_no) {
            myActions.action_sendKeys(warehousePhoneNumberEntry, phone_no);
        }

        public void enterAlterPhoneNo(String alter_phone_no) {
            myActions.action_sendKeys(warehouseAlternativePhoneEntry, alter_phone_no);
        }

        public void clickAddWarehouseButton() {
            myActions.action_click(addWarehouseButton);
        }


        /*--------------Functions-------------------*/
        public String addNewWarehouse() {
            int randomNum = random.nextInt(5000);
            String binCode = "WMSTesting" + randomNum;
            String name = "TestName" + randomNum;
            enterWarehouseCode(binCode);
            enterName(name);
            enterAddress1("First Line Of Address");
            enterAddress2("Second Line Of Address");
            enterLandmark("Near Lank Mark");
            enterCity("Testing City");
            enterState("Testing State");
            //enterCountry("India");
            enterZipcode("123456");
            enterPhoneNo("9442139828");
            enterAlterPhoneNo("9943225871");
            clickAddWarehouseButton();
            return binCode;
        }
    }


    /*--------------Update Bin Capacity Tab-------------------*/
    public class UpdateBinCapacityTab {

        private final WebDriver driver;
        private final MyActions myActions;

        public UpdateBinCapacityTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }

        //Enter Bin Code Update Bin Capacity
        @FindBy(xpath = "//input[@id='binCapacityBincode']")
        private WebElement binCodeUpdateCapacity;

        //Enter Bin Capacity
        @FindBy(xpath = "//input[@id='binCapacity']")
        private WebElement binCapacityUpdateCapacity;

        //Update Capacity Button
        @FindBy(xpath = "//button[text()='Update Bin Capacity']")
        private WebElement updateCapacityButton;


        /*--------------Actions-------------------*/
        public void enterBinCodeUpdateCapacity(String binCode) {
            myActions.action_sendKeys(binCodeUpdateCapacity, binCode);
        }

        public void enterCapacity(String capacity) {
            myActions.action_sendKeys(binCapacityUpdateCapacity, capacity);
        }

        public void clickUpdateCapacityButton() {
            myActions.action_click(updateCapacityButton);
        }


        /*--------------Functions-------------------*/
        public void updateBinCapacity(String binCode, String capacity) {
            enterBinCodeUpdateCapacity(binCode);
            enterCapacity(capacity);
            clickUpdateCapacityButton();
        }
    }


    /*--------------Warehouse Bin Details Tab-------------------*/
    public class WarehouseBinDetailsTab {
        private final WebDriver driver;
        private final MyActions myActions;

        public WarehouseBinDetailsTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }

        //Enter Bin Code
        @FindBy(xpath = "//input[@id='BinDetailBinCode']")
        private WebElement binCodeBinDetails;


        /*--------------Actions-------------------*/
        public void enterBinCodeBinDetails(String binCode) {
            myActions.action_sendKeys(binCodeBinDetails, binCode);
            myActions.action_enter(binCodeBinDetails);
            sleep(2000);
        }


        /*--------------Functions-------------------*/
        public void binCodeEntry(String binCode) {
            enterBinCodeBinDetails(binCode);
        }

        public int getTotalProducts() {
            List<WebElement> products = driver.findElements(By.xpath("//div[@id='WarehouseBinDetail']//tbody/tr"));
            return products.size();
        }

        public String getSkuCode(int index) {
            String skuCodeXpath = "//div[@id='WarehouseBinDetail']//tbody/tr[" + index + "]/td[1]";
            WebElement skuCode = driver.findElement(By.xpath(skuCodeXpath));
            return myActions.action_getText(skuCode);
        }

        public String getQuantity(int index) {
            String quantityXpath = "//div[@id='WarehouseBinDetail']//tbody/tr[" + index + "]/td[2]";
            WebElement quantity = driver.findElement(By.xpath(quantityXpath));
            return myActions.action_getText(quantity);
        }

        public String getPackageIds(int index) {
            String packageIdsXpath = "//div[@id='WarehouseBinDetail']//tbody/tr[" + index + "]/td[3]";
            WebElement packageIds = driver.findElement(By.xpath(packageIdsXpath));
            return myActions.action_getText(packageIds);
        }

        public String getScannedCount(int index) {
            String scannedCountXpath = "//div[@id='WarehouseBinDetail']//tbody/tr[" + index + "]/td[4]";
            WebElement scannedCount = driver.findElement(By.xpath(scannedCountXpath));
            return myActions.action_getText(scannedCount);
        }

        public String getScannedPackageIds(int index) {
            String scannedPackageIdsXpath = "//div[@id='WarehouseBinDetail']//tbody/tr[" + index + "]/td[5]";
            WebElement scannedPackageIds = driver.findElement(By.xpath(scannedPackageIdsXpath));
            return myActions.action_getText(scannedPackageIds);
        }

    }


    /*--------------Warehouse List Tab-------------------*/
    public class WarehouseListTab {
        private final WebDriver driver;
        private final MyActions myActions;

        public WarehouseListTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }

        public int getTotalWarehouses() {
            List<WebElement> warehouses = driver.findElements(By.xpath("//div[@id='WarehousesList']//tr/td[1]"));
            return warehouses.size();
        }

        public String getWarehouseCode(int index) {
            String warehouseCodeXpath = "//div[@id='WarehousesList']//tr[" + index + "]/td[1]";
            WebElement warehouseCode = driver.findElement(By.xpath(warehouseCodeXpath));
            return myActions.action_getText(warehouseCode);
        }

        public String getAddress1(int index) {
            String address1Xpath = "//div[@id='WarehousesList']//tr[" + index + "]/td[2]";
            WebElement address1 = driver.findElement(By.xpath(address1Xpath));
            return myActions.action_getText(address1);
        }

        public String getAddress2(int index) {
            String address2Xpath = "//div[@id='WarehousesList']//tr[" + index + "]/td[3]";
            WebElement address2 = driver.findElement(By.xpath(address2Xpath));
            return myActions.action_getText(address2);
        }

        public String getLandmark(int index) {
            String landmarkXpath = "//div[@id='WarehousesList']//tr[" + index + "]/td[4]";
            WebElement landmark = driver.findElement(By.xpath(landmarkXpath));
            return myActions.action_getText(landmark);
        }

        public String getCity(int index) {
            String cityXpath = "//div[@id='WarehousesList']//tr[" + index + "]/td[5]";
            WebElement city = driver.findElement(By.xpath(cityXpath));
            return myActions.action_getText(city);
        }

        public String getState(int index) {
            String stateXpath = "//div[@id='WarehousesList']//tr[" + index + "]/td[6]";
            WebElement state = driver.findElement(By.xpath(stateXpath));
            return myActions.action_getText(state);
        }

        public String getCountry(int index) {
            String countryXpath = "//div[@id='WarehousesList']//tr[" + index + "]/td[7]";
            WebElement country = driver.findElement(By.xpath(countryXpath));
            return myActions.action_getText(country);
        }

        public String getZipCode(int index) {
            String zipcodeXpath = "//div[@id='WarehousesList']//tr[" + index + "]/td[8]";
            WebElement zipcode = driver.findElement(By.xpath(zipcodeXpath));
            return myActions.action_getText(zipcode);
        }

        public void displayBinDetails(int index) {
            String binDetailsXpath = "//div[@id='WarehousesList']//tr[" + index + "]/td[9]/a";
            WebElement binDetails = driver.findElement(By.xpath(binDetailsXpath));
            myActions.action_click(binDetails);
        }

        public void printBinLabels(int index) {
            String printLabelXpath = "//div[@id='WarehousesList']//tr[" + index + "]/td[10]/a";
            WebElement printLabel = driver.findElement(By.xpath(printLabelXpath));
            myActions.action_click(printLabel);
        }
    }
}

