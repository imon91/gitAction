package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

import java.util.ArrayList;
import java.util.List;

public class SuppliersPageObjects {
    private final WebDriver driver;
    private final MyActions myActions;

    public SuppliersPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        myActions = new MyActions();
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


    /*--------------Actions-------------------*/
    public void clickMigrateSellerTab() {
        myActions.action_click(migrateSellerTab);
    }

    public void clickSuppliersListTab() {
        myActions.action_click(suppliersListTab);
    }

    public void clickSellersListTab() {
        myActions.action_click(sellersListTab);
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

        // Seller Code Entry Field
        @FindBy(xpath = "///div[@id='MigrateSeller']//input")
        private WebElement sellerCodeEntry;

        //Submit Seller Code Button
        @FindBy(xpath = "//div[@id='MigrateSeller']//button")
        private WebElement submitSellerCodeButton;


        /*--------------Actions-------------------*/
        public void setSellerCodeEntry(String sellerCode) {
            myActions.action_sendKeys(sellerCodeEntry, sellerCode);
        }

        public void clickSubmitSellerCodeButton() {
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

        public void displayAddressDetails(int index) {
            String addressDetailsXpath = "//div[@id='SuppliersList']//tbody/tr[" + index + "]/td[4]/a";
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
}

