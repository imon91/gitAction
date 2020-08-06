package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MyActions;
import utils.WmsBaseClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SuppliersPageObjects extends WmsBaseClass {
    private WebDriver driver;
    private MyActions myActions;
    private WebDriverWait wait;

    public SuppliersPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        myActions = new MyActions();
        wait = new WebDriverWait(driver,10);
    }

    //Migrate Seller Tab
    @FindBy(xpath = "//a[text()='Migrate Seller']")
    private WebElement migrateSellerTab;

    //Migrate Seller Tab
    @FindBy(xpath = "//a[text()='Suppliers List']")
    private WebElement suppliersListTab;

    //Sellers List Tab
    @FindBy(xpath = "//a[text()='Sellers List']")
    private WebElement sellersListTab;

    //Add Supplier Tab
    @FindBy(xpath = "//a[text()='Add Suppliers']")
    private WebElement addSupplierTab;


    /*--------------Actions-------------------*/
    public void clickMigrateSellerTab() {
        wait.until(ExpectedConditions.elementToBeClickable(migrateSellerTab));
        myActions.action_click(migrateSellerTab);
    }

    public void clickSuppliersListTab() {
        wait.until(ExpectedConditions.elementToBeClickable(suppliersListTab));
        myActions.action_click(suppliersListTab);
    }

    public void clickSellersListTab() {
        wait.until(ExpectedConditions.elementToBeClickable(sellersListTab));
        myActions.action_click(sellersListTab);
    }

    public void clickAddSupplierTab() {
        wait.until(ExpectedConditions.elementToBeClickable(addSupplierTab));
        myActions.action_click(addSupplierTab);
    }


    /*--------------Migrate Seller Tab-------------------*/
    public class MigrateSellerTab {
        private WebDriver driver;
        private MyActions myActions;

        public MigrateSellerTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }

        // Seller Code Entry Field
        @FindBy(xpath = "///div[@id='MigrateSeller']//input")
        private WebElement sellerCodeEntry;

        //Submit Seller Code Button
        @FindBy(xpath = "//div[@id='MigrateSeller']//button")
        private WebElement submitSellerCodeButton;


        /*--------------Actions-------------------*/
        public void setSellerCodeEntry(String sellerCode) {
            wait.until(ExpectedConditions.visibilityOf(sellerCodeEntry));
            myActions.action_sendKeys(sellerCodeEntry, sellerCode);
        }

        public void clickSubmitSellerCodeButton() {
            wait.until(ExpectedConditions.visibilityOf(submitSellerCodeButton));
            myActions.action_click(submitSellerCodeButton);
        }


        /*--------------Functions-------------------*/
        public void migrateSeller(String sellerCode) {
            setSellerCodeEntry(sellerCode);
            clickSubmitSellerCodeButton();
        }
    }


    /*--------------Suppliers List Tab-------------------*/
    public class SuppliersListTab {
        private WebDriver driver;
        private MyActions myActions;

        public SuppliersListTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }

        @FindBy(xpath = "//body/div/div/div/div/div/div/select[1]")
        private WebElement sellerDropDown;

        @FindBy(xpath = "//body//button[2]")
        private WebElement okButton;

        /*--------------Functions-------------------*/
        public int getTotalSuppliers() {
            List<WebElement> suppliers = driver.findElements(By.xpath("//div[@id='SuppliersList']//tbody/tr"));
            return suppliers.size();
        }

        public String getSupplierName(int index) {
            String nameXpath = "//div[@id='SuppliersList']//tbody/tr[" + index + "]/td[1]";
            WebElement name = driver.findElement(By.xpath(nameXpath));
            return myActions.action_getText(name);
        }

        public String getSupplierEmail(int index) {
            String emailXpath = "//div[@id='SuppliersList']//tbody/tr[" + index + "]/td[2]";
            WebElement email = driver.findElement(By.xpath(emailXpath));
            return myActions.action_getText(email);
        }

        public String getSupplierPhoneNo(int index) {
            String phoneNoXpath = "//div[@id='SuppliersList']//tbody/tr[" + index + "]/td[3]";
            WebElement phoneNo = driver.findElement(By.xpath(phoneNoXpath));
            return myActions.action_getText(phoneNo);
        }

        public void addSellerToSupplier(int index,String seller) {
            String addSellerXpath = "//div[@id='SuppliersList']//tbody/tr[" + index + "]/td[4]/button";
            WebElement addSeller = driver.findElement(By.xpath(addSellerXpath));
            myActions.action_click(addSeller);
            sleep(1000);
            myActions.action_select(sellerDropDown,seller);
            myActions.action_click(okButton);
        }

        public void displayAddressDetails(int index) {
            String addressDetailsXpath = "//div[@id='SuppliersList']//tbody/tr[" + index + "]/td[5]/a";
            WebElement addressDetails = driver.findElement(By.xpath(addressDetailsXpath));
            myActions.action_click(addressDetails);
        }
    }


    /*--------------Sellers List Tab-------------------*/
    public class SellersListTab {
        private WebDriver driver;
        private MyActions myActions;

        public SellersListTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }


        /*--------------Functions-------------------*/
        public String getSupplierName(int index) {
            String nameXpath = "//div[@id='SellersList']//thead/following-sibling::tbody/tr["+index+"]/td[1]";
            WebElement name = driver.findElement(By.xpath(nameXpath));
            return myActions.action_getText(name);
        }

        public String getUserId(int index) {
            String userIdXpath = "//div[@id='SellersList']//thead/following-sibling::tbody/tr["+index+"]/td[5]";
            WebElement userId = driver.findElement(By.xpath(userIdXpath));
            return myActions.action_getText(userId);
        }

        public String getMarketPlace(int index) {
            String marketPlaceXpath = "//div[@id='SellersList']//thead/following-sibling::tbody/tr["+index+"]/td[4]";
            WebElement marketPlace = driver.findElement(By.xpath(marketPlaceXpath));
            return myActions.action_getText(marketPlace);
        }

        public ArrayList<String> getWarehouseCode(int index) {
            String warehouseCodeXpath = "//div[@id='SellersList']//tbody/tr["+index+"]/td[2]//tr";
            List<WebElement> warehouseCode = driver.findElements(By.xpath(warehouseCodeXpath));
            ArrayList<String> warehouseCodes = new ArrayList<String>();
            for (WebElement element : warehouseCode)
                warehouseCodes.add(myActions.action_getText(element));
            return warehouseCodes;
        }

        public ArrayList<String> getGSTNo(int index) {
            String gSTNoXpath = "//div[@id='SellersList']//tbody/tr["+index+"]/td[3]//tr";
            List<WebElement> gSTNo = driver.findElements(By.xpath(gSTNoXpath));
            ArrayList<String> gSTNos = new ArrayList<String>();
            for (WebElement element : gSTNo)
                gSTNos.add(myActions.action_getText(element));
            return gSTNos;
        }

        public void syncNewVariants(int index){
            String syncNewVariantsXpath = "//div[@id='SellersList']//tbody/tr["+index+"]/td[7]//span";
            WebElement syncNewVariantsButton = driver.findElement(By.xpath(syncNewVariantsXpath));
            myActions.action_click(syncNewVariantsButton);
        }
    }


    /*--------------Add Supplier Tab-------------------*/
    public class AddSupplierTab {
        private WebDriver driver;
        private MyActions myActions;
        private Random random;

        public AddSupplierTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
            random = new Random();
        }

        //Enter Name
        @FindBy(xpath = "//div[@id='AddSupplier']//input[@id='name']")
        private WebElement supplierNameEntry;

        //Enter Email
        @FindBy(xpath = "//div[@id='AddSupplier']//input[@id='email']")
        private WebElement supplierEmail;

        //Enter Phone Number
        @FindBy(xpath = "//div[@id='AddSupplier']//input[@id='phone']")
        private WebElement supplierPhoneNumberEntry;

        //Enter Address Line 1
        @FindBy(xpath = "//div[@id='AddSupplier']//input[@id='address1']")
        private WebElement supplierAddressEntry1;

        //Enter Address Line 2
        @FindBy(xpath = "//div[@id='AddSupplier']//input[@id='address2']")
        private WebElement supplierAddressEntry2;

        //Enter Landmark
        @FindBy(xpath = "//div[@id='AddSupplier']//input[@id='land_mark']")
        private WebElement supplierLandmarkEntry;

        //Enter City
        @FindBy(xpath = "//div[@id='AddSupplier']//input[@id='city']")
        private WebElement supplierCityEntry;

        //Enter State
        @FindBy(xpath = "//div[@id='AddSupplier']//input[@id='state']")
        private WebElement supplierStateEntry;

        //Enter Zipcode
        @FindBy(xpath = "//div[@id='AddSupplier']//input[@id='Zipcode']")
        private WebElement supplierZipcodeEntry;

        //Enter GSTNo
        @FindBy(xpath = "//div[@id='AddSupplier']//input[@id='GstNumber']")
        private WebElement supplierGSTNoEntry;

        //Enter
        @FindBy(xpath = "//div[@id='AddSupplier']//button")
        private WebElement addSupplierButton;


        /*--------------Actions-------------------*/
        public void enterName(String name) {
            wait.until(ExpectedConditions.visibilityOf(supplierNameEntry));
            myActions.action_sendKeys(supplierNameEntry, name);
        }

        public void enterEmail(String name) {
            wait.until(ExpectedConditions.visibilityOf(supplierEmail));
            myActions.action_sendKeys(supplierEmail, name);
        }

        public void enterPhoneNo(String phone_no) {
            wait.until(ExpectedConditions.visibilityOf(supplierPhoneNumberEntry));
            myActions.action_sendKeys(supplierPhoneNumberEntry, phone_no);
        }

        public void enterAddress1(String address1) {
            wait.until(ExpectedConditions.visibilityOf(supplierAddressEntry1));
            myActions.action_sendKeys(supplierAddressEntry1, address1);
        }

        public void enterAddress2(String address2) {
            wait.until(ExpectedConditions.visibilityOf(supplierAddressEntry2));
            myActions.action_sendKeys(supplierAddressEntry2, address2);
        }

        public void enterLandmark(String landmark) {
            wait.until(ExpectedConditions.visibilityOf(supplierLandmarkEntry));
            myActions.action_sendKeys(supplierLandmarkEntry, landmark);
        }

        public void enterCity(String city) {
            wait.until(ExpectedConditions.visibilityOf(supplierCityEntry));
            myActions.action_sendKeys(supplierCityEntry, city);
        }

        public void enterState(String state) {
            wait.until(ExpectedConditions.visibilityOf(supplierStateEntry));
            myActions.action_sendKeys(supplierStateEntry, state);
        }

        public void enterZipcode(String zipcode) {
            wait.until(ExpectedConditions.visibilityOf(supplierZipcodeEntry));
            myActions.action_sendKeys(supplierZipcodeEntry, zipcode);
        }

        public void enterGSTNo(String gstNo) {
            wait.until(ExpectedConditions.visibilityOf(supplierGSTNoEntry));
            myActions.action_sendKeys(supplierGSTNoEntry, gstNo); }

        public void clickAddSupplierButton() {
            wait.until(ExpectedConditions.visibilityOf(addSupplierButton));
            myActions.action_click(addSupplierButton);
        }


        /*--------------Functions-------------------*/
        public String addNewSupplier() {
            int randomNum = random.nextInt(5000);
            String name = "TestName" + randomNum;
            enterName(name);
            enterEmail(name.toLowerCase() + "@gmail.com");
            enterPhoneNo("9442139828");
            enterAddress1("First Line Of Address");
            enterAddress2("Second Line Of Address");
            enterLandmark("Near Lank Mark");
            enterCity("Testing City");
            enterState("Testing State");
            enterZipcode("123456");
            enterGSTNo(randomNum + randomNum + randomNum + "GST");
            clickAddSupplierButton();
            return name;
        }
    }
}