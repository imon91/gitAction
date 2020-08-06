package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MyActions;
import utils.WmsBaseClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WarehousesPageObjects extends WmsBaseClass {
    private WebDriver driver;
    private MyActions myActions;
    private WebDriverWait wait;

    public WarehousesPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        myActions = new MyActions();
        wait = new WebDriverWait(driver,10);
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

    //Warehouse Bin Details Tab
    @FindBy(xpath = "//a[text()='Warehouse Bins create']")
    private WebElement warehouseBinsCreateTab;

    //Warehouse Select
    @FindBy(xpath = "//div[@id='root']//form//select")
    private WebElement selectWarehouseDropDown;


    /*--------------Actions-------------------*/
    public void clickAddWarehouseTab() {
        wait.until(ExpectedConditions.elementToBeClickable(addWarehouseTab));
        myActions.action_click(addWarehouseTab);
    }

    public void clickWarehouseListTab() {
        wait.until(ExpectedConditions.elementToBeClickable(warehousesListTab));
        myActions.action_click(warehousesListTab);
    }

    public void clickUpdateBinCapacityTab() {
        wait.until(ExpectedConditions.elementToBeClickable(updateBinCapacityTab));
        myActions.action_click(updateBinCapacityTab);
    }

    public void clickBinDetailsTab() {
        wait.until(ExpectedConditions.elementToBeClickable(binDetailsTab));
        myActions.action_click(binDetailsTab);}

    public void clickWarehouseBinsCreateTab() {
        wait.until(ExpectedConditions.elementToBeClickable(warehouseBinsCreateTab));
        myActions.action_click(warehouseBinsCreateTab); }

    public void selectWarehouse(String warehouse) {
        wait.until(ExpectedConditions.elementToBeClickable(selectWarehouseDropDown));
        myActions.action_select(selectWarehouseDropDown,warehouse); }


    /*--------------Add Warehouse Tab-------------------*/
    public class AddWarehouseTab {
        private WebDriver driver;
        private MyActions myActions;
        private Random random;

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
            wait.until(ExpectedConditions.visibilityOf(warehouseCodeEntry));
            myActions.action_sendKeys(warehouseCodeEntry, binCode);
        }

        public void enterName(String name) {
            wait.until(ExpectedConditions.visibilityOf(warehouseNameEntry));
            myActions.action_sendKeys(warehouseNameEntry, name);
        }

        public void enterAddress1(String address1) {
            wait.until(ExpectedConditions.visibilityOf(warehouseAddressEntry1));
            myActions.action_sendKeys(warehouseAddressEntry1, address1);
        }

        public void enterAddress2(String address2) {
            wait.until(ExpectedConditions.visibilityOf(warehouseAddressEntry2));
            myActions.action_sendKeys(warehouseAddressEntry2, address2);
        }

        public void enterLandmark(String landmark) {
            wait.until(ExpectedConditions.visibilityOf(warehouseLandmarkEntry));
            myActions.action_sendKeys(warehouseLandmarkEntry, landmark);
        }

        public void enterCity(String city) {
            wait.until(ExpectedConditions.visibilityOf(warehouseCityEntry));
            myActions.action_sendKeys(warehouseCityEntry, city);
        }

        public void enterState(String state) {
            wait.until(ExpectedConditions.visibilityOf(warehouseStateEntry));
            myActions.action_sendKeys(warehouseStateEntry, state);
        }

        public void enterCountry(String country) {
            wait.until(ExpectedConditions.visibilityOf(warehouseNameEntry));
            myActions.action_sendKeys(warehouseCountryEntry, country);
        }

        public void enterZipcode(String zipcode) {
            wait.until(ExpectedConditions.visibilityOf(warehouseZipcodeEntry));
            myActions.action_sendKeys(warehouseZipcodeEntry, zipcode);
        }

        public void enterPhoneNo(String phone_no) {
            wait.until(ExpectedConditions.visibilityOf(warehousePhoneNumberEntry));
            myActions.action_sendKeys(warehousePhoneNumberEntry, phone_no);
        }

        public void enterAlterPhoneNo(String alter_phone_no) {
            wait.until(ExpectedConditions.visibilityOf(warehouseAlternativePhoneEntry));
            myActions.action_sendKeys(warehouseAlternativePhoneEntry, alter_phone_no);
        }

        public void clickAddWarehouseButton() {
            wait.until(ExpectedConditions.visibilityOf(addWarehouseButton));
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

        private WebDriver driver;
        private MyActions myActions;

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
            wait.until(ExpectedConditions.visibilityOf(binCodeUpdateCapacity));
            myActions.action_sendKeys(binCodeUpdateCapacity, binCode);
        }

        public void enterCapacity(String capacity) {
            wait.until(ExpectedConditions.visibilityOf(binCapacityUpdateCapacity));
            myActions.action_sendKeys(binCapacityUpdateCapacity, capacity);
        }

        public void clickUpdateCapacityButton() {
            wait.until(ExpectedConditions.visibilityOf(updateCapacityButton));
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
        private WebDriver driver;
        private MyActions myActions;

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
            wait.until(ExpectedConditions.visibilityOf(binCodeBinDetails));
            myActions.action_sendKeys(binCodeBinDetails, binCode);
            myActions.action_enter(binCodeBinDetails);
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
        private WebDriver driver;
        private MyActions myActions;

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


    /*--------------Warehouse Bins Create Tab-------------------*/
    public class WarehouseBinsCreateTab {
        private WebDriver driver;
        private MyActions myActions;

        public WarehouseBinsCreateTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }


        /*--------------Bin Create Section-------------------*/
        // Bin Create Section
        @FindBy(xpath = "//div[@id='WarehouseBinCreate']//div[text()='Bin Create']")
        private WebElement binCreateSection;


        /*--------------Actions-------------------*/
        public void clickBinCreateSection() {
            myActions.action_click(binCreateSection);
        }


        /*--------------Pickup Agents Section-------------------*/
        // Pickup Agents Section
        @FindBy(xpath = "//div[@id='WarehouseBinCreate']//div[text()='Pickup Agents']")
        private WebElement pickupAgentsSection;

        // Pickup Agents Entry
        @FindBy(xpath = "//div[@id='WarehouseBinCreate']//input[@placeholder='Enter Name']")
        private WebElement pickupAgentsEntry;

        // Pickup Agent Add Button
        @FindBy(xpath = "//div[@id='WarehouseBinCreate']//div[2]//div[2]//div[1]//div[1]//button[1]")
        private WebElement addPickupAgentButton;


        /*--------------Actions-------------------*/
        public void clickPickupAgentsSection() {
            myActions.action_click(pickupAgentsSection);
        }

        public void enterPickupAgents(String pickupAgent){
            myActions.action_sendKeys(pickupAgentsEntry,pickupAgent);
            myActions.action_click(addPickupAgentButton);
        }


        /*--------------Functions-------------------*/
        public ArrayList<String> getPickupAgents() {
            String pickupAgentXpath = "//div[@id='WarehouseBinCreate']//div[2]//div[2]//div[1]//tr[@id]";
            List<WebElement> pickupAgent = driver.findElements(By.xpath(pickupAgentXpath));
            ArrayList<String> pickupAgents = new ArrayList<String>();
            for (WebElement element : pickupAgent)
                pickupAgents.add(myActions.action_getText(element));
            return pickupAgents;
        }


        /*--------------Warehouse Users Section-------------------*/
        // Warehouse Users Section
        @FindBy(xpath = "//div[@id='WarehouseBinCreate']//div[text()='Warehouse users']")
        private WebElement warehouseUsersSection;

        // Warehouse Users Entry
        @FindBy(xpath = "//div[@id='WarehouseBinCreate']//div[3]//div[2]//div[1]//div[1]//select[1]")
        private WebElement selectUserDropDown;

        // Add User To Warehouse Button
        @FindBy(xpath = "//div[@id='WarehouseBinCreate']//div[3]//div[2]//div[1]//div[1]//button[1]")
        private WebElement addUserToWarehouseButton;


        /*--------------Actions-------------------*/
        public void clickWarehouseUsersSection() {
            myActions.action_click(warehouseUsersSection);
        }

        public void enterWarehouseUser(String user){
            myActions.action_select(selectUserDropDown,user);
            myActions.action_click(addUserToWarehouseButton);
        }


        /*--------------Functions-------------------*/
        public ArrayList<String> getWarehouseUsers() {
            String warehouseUserXpath = "//div[@id='WarehouseBinCreate']//div[3]//div[2]//div[1]//tr[@id]";
            List<WebElement> warehouseUser = driver.findElements(By.xpath(warehouseUserXpath));
            ArrayList<String> warehouseUsers = new ArrayList<String>();
            for (WebElement element : warehouseUser)
                warehouseUsers.add(myActions.action_getText(element));
            return warehouseUsers;
        }

        /*--------------Sellers Section-------------------*/
        // Sellers Section
        @FindBy(xpath = "//div[@id='WarehouseBinCreate']//div[text()='Sellers']")
        private WebElement sellersSection;

        // Sellers Entry
        @FindBy(xpath = "//div[@id='WarehouseBinCreate']//div[4]//div[2]//div[1]//div[1]//select[1]")
        private WebElement selectSellerDropDown;

        // Add Seller Button
        @FindBy(xpath = "//div[@id='WarehouseBinCreate']//div[4]//div[2]//div[1]//div[1]//button[1]")
        private WebElement addSellerButton;


        /*--------------Actions-------------------*/
        public void clickSellersSection() {
            myActions.action_click(sellersSection);
        }

        public void enterSeller(String seller){
            myActions.action_select(selectSellerDropDown,seller);
            myActions.action_click(addSellerButton);
        }


        /*--------------Functions-------------------*/
        public ArrayList<String> getSellers() {
            String sellerXpath = "//div[@id='WarehouseBinCreate']//div[4]//div[2]//div[1]//tr[@id]";
            List<WebElement> seller = driver.findElements(By.xpath(sellerXpath));
            ArrayList<String> sellers = new ArrayList<String>();
            for (WebElement element : seller)
                sellers.add(myActions.action_getText(element));
            return sellers;
        }
    }
}