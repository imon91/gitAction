package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.*;

import java.util.*;

public class WarehousesPageObjects extends WmsBaseClass {

    private WebDriver driver;
    private MyActions myActions;

    public WarehousesPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        myActions = new MyActions();
    }


    /*--------------Actions-------------------*/
    public void clickAddWarehouseTab() {
        WebElement addWarehouseTab = xpathSetterClick("//a[text()='Add Warehouse']");
        myActions.action_click(addWarehouseTab);
    }

    public void clickWarehouseListTab() {
        WebElement warehousesListTab = xpathSetterClick("//a[text()='Warehouses List']");
        myActions.action_click(warehousesListTab);
    }

    public void clickUpdateBinCapacityTab() {
        WebElement updateBinCapacityTab = xpathSetterClick("//a[text()='Update Bin Capacity']");
        myActions.action_click(updateBinCapacityTab);
    }

    public void clickBinDetailsTab() {
        WebElement binDetailsTab = xpathSetterClick("//a[text()='Warehouse Bin Details']");
        myActions.action_click(binDetailsTab);}

    public void clickWarehouseBinsCreateTab() {
        WebElement warehouseBinsCreateTab = xpathSetterClick("//a[text()='Warehouse Bins create']");
        myActions.action_click(warehouseBinsCreateTab); }


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


        /*--------------Actions-------------------*/
        public void enterWarehouseCode(String binCode) {
            WebElement warehouseCodeEntry = xpathSetter("//input[@id='warehouseCode']");
            myActions.action_sendKeys(warehouseCodeEntry, binCode);
        }

        public void enterName(String name) {
            WebElement warehouseNameEntry = xpathSetter("//input[@id='firstname']");
            myActions.action_sendKeys(warehouseNameEntry, name);
        }

        public void enterAddress1(String address1) {
            WebElement warehouseAddressEntry1 = xpathSetter("//input[@id='warehouseAddress']");
            myActions.action_sendKeys(warehouseAddressEntry1, address1);
        }

        public void enterAddress2(String address2) {
            WebElement warehouseAddressEntry2 = xpathSetter("//input[@id='warehouseAddress2']");
            myActions.action_sendKeys(warehouseAddressEntry2, address2);
        }

        public void enterLandmark(String landmark) {
            WebElement warehouseLandmarkEntry = xpathSetter("//input[@id='warehouseLandmark']");
            myActions.action_sendKeys(warehouseLandmarkEntry, landmark);
        }

        public void enterCity(String city) {
            WebElement warehouseCityEntry = xpathSetter("//input[@id='warehouseCity']");
            myActions.action_sendKeys(warehouseCityEntry, city);
        }

        public void enterState(String state) {
            WebElement warehouseStateEntry = xpathSetter("//input[@id='warehouseState']");
            myActions.action_sendKeys(warehouseStateEntry, state);
        }

        public void enterCountry(String country) {
            WebElement warehouseCountryEntry = xpathSetter("//input[@id='warehouseCountry']");
            myActions.action_sendKeys(warehouseCountryEntry, country);
        }

        public void enterZipcode(String zipcode) {
            WebElement warehouseZipcodeEntry = xpathSetter("//input[@id='Zipcode']");
            myActions.action_sendKeys(warehouseZipcodeEntry, zipcode);
        }

        public void enterPhoneNo(String phone_no) {
            WebElement warehousePhoneNumberEntry = xpathSetter("//input[@id='phone']");
            myActions.action_sendKeys(warehousePhoneNumberEntry, phone_no);
        }

        public void enterAlterPhoneNo(String alter_phone_no) {
            WebElement warehouseAlternativePhoneEntry = xpathSetter("//input[@id='alternative_phone']");
            myActions.action_sendKeys(warehouseAlternativePhoneEntry, alter_phone_no);
        }

        public void clickAddWarehouseButton() {
            WebElement addWarehouseButton = xpathSetter("//button[text()='Add Warehouse']");
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


        /*--------------Actions-------------------*/
        public void enterBinCodeUpdateCapacity(String binCode) {
            WebElement binCodeUpdateCapacity = xpathSetter("//input[@id='binCapacityBincode']");
            myActions.action_sendKeys(binCodeUpdateCapacity, binCode);
        }

        public void enterCapacity(String capacity) {
            WebElement binCapacityUpdateCapacity = xpathSetter("//input[@id='binCapacity']");
            myActions.action_sendKeys(binCapacityUpdateCapacity, capacity);
        }

        public void clickUpdateCapacityButton() {
            WebElement updateCapacityButton = xpathSetter("//button[text()='Update Bin Capacity']");
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


        /*--------------Actions-------------------*/
        public void enterBinCodeBinDetails(String binCode) {
            WebElement binCodeBinDetails = xpathSetter("//input[@id='BinDetailBinCode']");
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
            WebElement binDetails = xpathSetter(binDetailsXpath);
            myActions.action_click(binDetails);
        }

        public void printBinLabels(int index) {
            String printLabelXpath = "//div[@id='WarehousesList']//tr[" + index + "]/td[10]/a";
            WebElement printLabel = xpathSetter(printLabelXpath);
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


        /*--------------Actions-------------------*/
        public void clickBinCreateSection() {
            WebElement binCreateSection = xpathSetter("//div[@id='WarehouseBinCreate']//div[text()='Bin Create']");
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