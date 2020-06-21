package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;
import utils.WmsBaseClass;

import java.util.List;

public class PurchaseOrdersPageObjects extends WmsBaseClass {
    private WebDriver driver;
    private MyActions myActions;
    @FindBy(xpath = "//a[text()='Create Purchase Order']")
    private WebElement createPurchaseOrderTab;
    @FindBy(xpath = "//a[text()='Create Bulk PO']")
    private WebElement createBulkPOTab;
    @FindBy(xpath = "//a[text()='Create TO']")
    private WebElement createTOTab;
    @FindBy(xpath = "//a[text()='Qc Scan']")
    private WebElement qcScanTab;
    @FindBy(xpath = "//a[text()='Edit PurchaseOrder']")
    private WebElement editPurchaseOrderTab;
    @FindBy(xpath = "//a[text()='Purchase Order List']")
    private WebElement purchaseOrderListTab;
    @FindBy(xpath = "//a[text()='TO List']")
    private WebElement tOListTab;
    @FindBy(xpath = "//a[text()='Create GRN']")
    private WebElement createGRNTab;

    public PurchaseOrdersPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        myActions = new MyActions();
    }

    /*--------------Actions-------------------*/
    public void clickCreatePurchaseOrderTab() {
        myActions.action_click(createPurchaseOrderTab);
    }

    public void clickCreateBulkPOTab() {
        myActions.action_click(createBulkPOTab);
    }

    public void clickCreateTOTab() {
        myActions.action_click(createTOTab);
    }

    public void clickQcScanTab() {
        myActions.action_click(qcScanTab);
    }

    public void clickEditPurchaseOrderTab() {
        myActions.action_click(editPurchaseOrderTab);
    }

    public void clickPurchaseOrderListTab() {
        myActions.action_click(purchaseOrderListTab);
    }

    public void clickTOListTab() {
        myActions.action_click(tOListTab);
    }

    public void clickCreateGRNTab() {
        myActions.action_click(createGRNTab);
    }


    /*--------------Create Purchase Order Tab-------------------*/
    public class CreatePurchaseOrderTab {
        private WebDriver driver;
        private MyActions myActions;
        @FindBy(xpath = "//div[@id='Addpurchage']//label[@for='sel_warehouse']/following-sibling::select")
        private WebElement warehouseDropdown;
        @FindBy(xpath = "//div[@id='Addpurchage']//label[@for='sel_seller']/following-sibling::select")
        private WebElement sellerDropdown;
        @FindBy(xpath = "//div[@id='Addpurchage']//label[@for='sel_supplier']/following-sibling::select")
        private WebElement supplierDropdown;
        @FindBy(xpath = "//div[@id='Addpurchage']//label[@for='sel_address']/following-sibling::select")
        private WebElement addressDropdown;
        @FindBy(xpath = "//button[text()='+ Add Sku Input Fields']")
        private WebElement addSkuInputFields;
        @FindBy(xpath = "//button[text()='Create PO']")
        private WebElement createPOButton;

        public CreatePurchaseOrderTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }

        public void selectWarehouseDropdown(String warehouse) {
            myActions.action_select(warehouseDropdown, warehouse);
        }

        public void selectSellerDropdown(String seller) {
            myActions.action_select(sellerDropdown, seller);
        }

        public void selectSupplierDropdown(String supplier) {
            myActions.action_select(supplierDropdown, supplier);
        }

        public void selectAddressDropdown(String address) {
            myActions.action_select(addressDropdown, address);
        }

        public void enterWarehouseDetails(String warehouse, String seller, String supplier, String address) {
            selectWarehouseDropdown(warehouse);
            selectSellerDropdown(seller);
            selectSupplierDropdown(supplier);
            selectAddressDropdown(address);
            sleep(10000);
        }

        public void skuCodeInput(int index, String skuCode) {
            String skuCodeXPath = "//div[@id='Addpurchage']//input[@id='select" + index + "']";
            WebElement skuCodeEntry = driver.findElement(By.xpath(skuCodeXPath));
            myActions.action_sendKeys(skuCodeEntry, skuCode);
        }

        public void quantityInput(int index, String quantity) {
            String quantityXpath = "//div[@id='Addpurchage']//input[@id='orderQuantity" + index + "']";
            WebElement quantityEntry = driver.findElement(By.xpath(quantityXpath));
            myActions.action_sendKeys(quantityEntry, quantity);
        }

        public void transferPriceInput(int index, String price) {
            String transferPriceXpath = "//div[@id='Addpurchage']//input[@id='transferPrice" + index + "']";
            WebElement transferPriceEntry = driver.findElement(By.xpath(transferPriceXpath));
            myActions.action_sendKeys(transferPriceEntry, price);
        }

        public String productImage(int index) {
            String productImageXpath = "//div[@id='Addpurchage']//input[@id='select" + index + "']/ancestor::div[@class='row']//img";
            WebElement productImageElement = driver.findElement(By.xpath(productImageXpath));
            String src = productImageElement.getAttribute("src");
            return src;
        }

        public void clickRemoveButton(int index) {
            String removeButtonXpath = "//div[@id='Addpurchage']//input[@id='select" + index + "']/ancestor::div[@class='row']//button";
            WebElement removeButton = driver.findElement(By.xpath(removeButtonXpath));
            myActions.action_click(removeButton);
        }

        public void clickAddSkuInputFields() {
            myActions.action_click(addSkuInputFields);
        }

        public void clickCreatePOButton() {
            myActions.action_click(createPOButton);
        }

        public void createPO(int no_of_products, String skuCode[], String quantity[], String price[]) {
            for (int i = 0; i < no_of_products; i++) {
                skuCodeInput(i, skuCode[i]);
                quantityInput(i, quantity[i]);
                transferPriceInput(i, price[i]);
                String src = productImage(i);
                if (i != (no_of_products - 1)) {
                    clickAddSkuInputFields();
                }
            }
        }
    }

    public class EditPurchaseOrder {
        private WebDriver driver;
        private MyActions myActions;
        @FindBy(xpath = "//div[@id='EditPurchaseOrder']//input[@type='text']")
        private WebElement poIDEntry;
        @FindBy(xpath = "//button[text()='Close PO']")
        private WebElement closePOButton;
        @FindBy(xpath = "//a[text()='Print Purchase order']")
        private WebElement printPurchaseOrder;
        @FindBy(xpath = "//a[text()='Print using barcode printer']")
        private WebElement printUsingBarcodePrinter;
        @FindBy(xpath = "//div[@id='EditPurchaseOrder']//b")
        private WebElement purchaseOrderStatus;

        public EditPurchaseOrder(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }

        public void clickPOIDEntry(String poID) {
            myActions.action_sendKeys(poIDEntry, poID);
            myActions.action_enter(poIDEntry);
        }

        public void clickClosePOButton() {
            myActions.action_click(closePOButton);
        }

        public void clickPrintPurchaseOrder() {
            myActions.action_click(printPurchaseOrder);
        }

        public void clickPrintUsingBarcodePrinter() {
            myActions.action_click(printUsingBarcodePrinter);
        }

        public void getPOStatus() {
            myActions.action_getText(purchaseOrderStatus);
        }

        public int getTotalProducts() {
            List<WebElement> products = driver.findElements(By.xpath("//div[@id='EditPurchaseOrder']//tbody/tr"));
            return products.size();
        }

        public String getDescription(int index) {
            String descriptionXpath = "//div[@id='EditPurchaseOrder']//tbody/tr[" + index + "]/td[2]";
            WebElement description = driver.findElement(By.xpath(descriptionXpath));
            return myActions.action_getText(description);
        }

        public String getOrderedQuantity(int index) {
            String quantityXpath = "///div[@id='EditPurchaseOrder']//tbody/tr[" + index + "]/td[3]";
            WebElement quantity = driver.findElement(By.xpath(quantityXpath));
            return myActions.action_getText(quantity);
        }

    }


    /*--------------Purchase Order List Tab-------------------*/
    public class PurchaseOrderList {
        String purchaseOrderListTabXpath = "//div[@id='PurchaseOrderList']";
        private WebDriver driver;
        private MyActions myActions;

        public PurchaseOrderList(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }

        public int getTotalPurchaseOrders() {
            List<WebElement> purchaseOrders = driver.findElements(By.xpath("//div[@id='PurchaseOrderList']//thead/following-sibling::tbody/tr"));
            return purchaseOrders.size();
        }

        public String getWarehouseName(int index) {
            String warehouseXpath = "//div[@id='PurchaseOrderList']//thead/following-sibling::tbody/tr[" + index + "]/td[1]";
            WebElement warehouse = driver.findElement(By.xpath(warehouseXpath));
            return myActions.action_getText(warehouse);
        }

        public String getPOID(int index) {
            String pOIDXpath = "//div[@id='PurchaseOrderList']//thead/following-sibling::tbody/tr[" + index + "]/td[2]";
            WebElement pOID = driver.findElement(By.xpath(pOIDXpath));
            return myActions.action_getText(pOID);
        }

        public String getCreatedDate(int index) {
            String createdDateXpath = "//div[@id='PurchaseOrderList']//thead/following-sibling::tbody/tr[" + index + "]/td[3]";
            WebElement createdDate = driver.findElement(By.xpath(createdDateXpath));
            return myActions.action_getText(createdDate);
        }

        public String getPOType(int index) {
            String pOTypeXpath = "//div[@id='PurchaseOrderList']//thead/following-sibling::tbody/tr[" + index + "]/td[4]";
            WebElement pOType = driver.findElement(By.xpath(pOTypeXpath));
            return myActions.action_getText(pOType);
        }

        public String getStatus(int index) {
            String statusXpath = "//div[@id='PurchaseOrderList']//thead/following-sibling::tbody/tr[" + index + "]/td[5]";
            WebElement status = driver.findElement(By.xpath(statusXpath));
            return myActions.action_getText(status);
        }

        public String getSupplierName(int index) {
            String supplierXpath = "//div[@id='PurchaseOrderList']//thead/following-sibling::tbody/tr[" + index + "]/td[6]";
            WebElement supplier = driver.findElement(By.xpath(supplierXpath));
            return myActions.action_getText(supplier);
        }

        //pending

        public String getSkuCode(int index) {
            String skuCodeXpath = "//div[@id='PurchaseOrderList']//thead/following-sibling::tbody/tr[" + index + "]/td[7]/table/tbody/tr[1]";
            WebElement skuCode = driver.findElement(By.xpath(skuCodeXpath));
            return myActions.action_getText(skuCode);
        }

        public String getQuantity(int index) {
            String quantityXpath = "//div[@id='PurchaseOrderList']//thead/following-sibling::tbody/tr[" + index + "]/td[8]/table/tbody/tr[1]";
            WebElement quantity = driver.findElement(By.xpath(quantityXpath));
            return myActions.action_getText(quantity);
        }

        //pending
        public void printPurchaseOrder(int index) {
            String printPurchaseOrderXpath = "//div[@id='PurchaseOrderList']//thead/following-sibling::tbody/tr[" + index + "]/td[9]/div/a[1]";
            WebElement printPurchaseOrderElement = driver.findElement(By.xpath(printPurchaseOrderXpath));
            myActions.action_click(printPurchaseOrderElement);
        }

        public void printUsingBarcodePrinter(int index) {
            String printUsingBarcodePrinterXpath = "//div[@id='PurchaseOrderList']//thead/following-sibling::tbody/tr[" + index + "]/td[9]/div/a[2]";
            WebElement printUsingBarcodePrinterElement = driver.findElement(By.xpath(printUsingBarcodePrinterXpath));
            myActions.action_click(printUsingBarcodePrinterElement);
        }
    }
}
