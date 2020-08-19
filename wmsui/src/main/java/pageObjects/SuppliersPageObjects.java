package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.*;

import java.util.*;


public class SuppliersPageObjects extends WmsBaseClass {
  
    private WebDriver driver;
    private MyActions myActions;

    public SuppliersPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        myActions = new MyActions();
    }


    /*--------------Actions-------------------*/
    public void clickMigrateSellerTab() {
        WebElement migrateSellerTab = xpathSetterClick("//a[text()='Migrate Seller']");
        myActions.action_click(migrateSellerTab);
    }

    public void clickSuppliersListTab() {
        WebElement suppliersListTab = xpathSetterClick("//a[text()='Suppliers List']");
        myActions.action_click(suppliersListTab);
    }

    public void clickSellersListTab() {
        WebElement sellersListTab = xpathSetterClick("//a[text()='Sellers List']");
        myActions.action_click(sellersListTab);
    }

    public void clickAddSupplierTab() {
        WebElement addSupplierTab = xpathSetterClick("//a[text()='Add Suppliers']");
        myActions.action_click(addSupplierTab);
    }


    /*--------------Migrate Seller Tab-------------------*/
    public class MigrateSellerTab {
        private final WebDriver driver;
        private final MyActions myActions;

        public MigrateSellerTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }


        /*--------------Actions-------------------*/
        public void setSellerCodeEntry(String sellerCode) {
            WebElement sellerCodeEntry = xpathSetter("///div[@id='MigrateSeller']//input");
            myActions.action_sendKeys(sellerCodeEntry, sellerCode);
        }

        public void clickSubmitSellerCodeButton() {
            WebElement submitSellerCodeButton = xpathSetter("//div[@id='MigrateSeller']//button");
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
        private final WebDriver driver;
        private final MyActions myActions;

        public SuppliersListTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }


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
            WebElement addSeller = xpathSetter("//div[@id='SuppliersList']//tbody/tr[" + index + "]/td[4]/button");
            myActions.action_click(addSeller);
            WebElement sellerDropDown = xpathSetter("//body/div/div/div/div/div/div/select[1]");
            WebElement okButton = xpathSetter("//body//button[2]");
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


        /*--------------Actions-------------------*/
        public void enterName(String name) {
            WebElement supplierNameEntry = xpathSetter("//div[@id='AddSupplier']//input[@id='name']");
            myActions.action_sendKeys(supplierNameEntry, name);
        }

        public void enterEmail(String name) {
            WebElement supplierEmail = xpathSetter("//div[@id='AddSupplier']//input[@id='email']");
            myActions.action_sendKeys(supplierEmail, name);
        }

        public void enterPhoneNo(String phone_no) {
            WebElement supplierPhoneNumberEntry = xpathSetter("//div[@id='AddSupplier']//input[@id='phone']");
            myActions.action_sendKeys(supplierPhoneNumberEntry, phone_no);
        }

        public void enterAddress1(String address1) {
            WebElement supplierAddressEntry1 = xpathSetter("//div[@id='AddSupplier']//input[@id='address1']");
            myActions.action_sendKeys(supplierAddressEntry1, address1);
        }

        public void enterAddress2(String address2) {
            WebElement supplierAddressEntry2 = xpathSetter("//div[@id='AddSupplier']//input[@id='address2']");
            myActions.action_sendKeys(supplierAddressEntry2, address2);
        }

        public void enterLandmark(String landmark) {
            WebElement supplierLandmarkEntry = xpathSetter("//div[@id='AddSupplier']//input[@id='land_mark']");
            myActions.action_sendKeys(supplierLandmarkEntry, landmark);
        }

        public void enterCity(String city) {
            WebElement supplierCityEntry = xpathSetter("//div[@id='AddSupplier']//input[@id='city']");
            myActions.action_sendKeys(supplierCityEntry, city);
        }

        public void enterState(String state) {
            WebElement supplierStateEntry = xpathSetter("//div[@id='AddSupplier']//input[@id='state']");
            myActions.action_sendKeys(supplierStateEntry, state);
        }

        public void enterZipcode(String zipcode) {
            WebElement supplierZipcodeEntry = xpathSetter("//div[@id='AddSupplier']//input[@id='Zipcode']");
            myActions.action_sendKeys(supplierZipcodeEntry, zipcode);
        }

        public void enterGSTNo(String gstNo) {
            WebElement supplierGSTNoEntry = xpathSetter("//div[@id='AddSupplier']//input[@id='GstNumber']");
            myActions.action_sendKeys(supplierGSTNoEntry, gstNo); }

        public void clickAddSupplierButton() {
            WebElement addSupplierButton = xpathSetter("//div[@id='AddSupplier']//button");
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