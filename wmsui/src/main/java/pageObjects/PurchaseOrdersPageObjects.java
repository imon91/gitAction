package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;
import utils.WmsBaseClass;

import java.util.ArrayList;
import java.util.List;

public class PurchaseOrdersPageObjects extends WmsBaseClass {
    private WebDriver driver;
    private MyActions myActions;


    public PurchaseOrdersPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        myActions = new MyActions();
    }


    /*--------------Tabs-------------------*/
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



        public CreatePurchaseOrderTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }

        @FindBy(xpath = "//div[@id='Addpurchage']//label[@for='sel_warehouse']/following-sibling::select")
        private WebElement warehouseDropdown;

        @FindBy(xpath = "//div[@id='Addpurchage']//label[@for='sel_seller']/following-sibling::select")
        private WebElement sellerDropdown;

        @FindBy(xpath = "//div[@id='Addpurchage']//label[@for='sel_supplier']/following-sibling::select")
        private WebElement supplierDropdown;

        @FindBy(xpath = "//div[@id='Addpurchage']//label[@for='sel_address']/following-sibling::select")
        private WebElement addressDropdown;

        @FindBy(xpath = "//div[@id='Addpurchage']//div[@class='skuInput-main']/button")
        private WebElement addSkuInputFields;

        @FindBy(xpath = "//div[@id='Addpurchage']//div[@class='text-center']/button")
        private WebElement createPOButton;


        /*--------------Actions-------------------*/
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

        public void skuCodeInput(int index, String skuCode) {
            String skuCodeXPath = "//div[@id='Addpurchage']//input[@id='select" + index + "']";
            WebElement skuCodeEntry = driver.findElement(By.xpath(skuCodeXPath));
            myActions.action_sendKeys(skuCodeEntry, skuCode);
            myActions.action_enter(skuCodeEntry);
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


        /*--------------Functions-------------------*/
        public void enterWarehouseDetails() {
            selectWarehouseDropdown("Shopup Dhaka");
            sleep(2000);
            selectSellerDropdown("DFW");
            sleep(1000);
            selectSupplierDropdown("Dhaka Fashion Wear");
            sleep(1000);
            selectAddressDropdown("House no. 33 Road:3 Block - D , Mirpur-1");
            sleep(10000);
        }

        public void createPurchaseOrder(){
            skuCodeInput(0,"140882");
            sleep(1000);
            quantityInput(0,"1");
            clickCreatePOButton();
            sleep(1000);
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
            clickCreatePOButton();
        }
    }


    /*--------------Edit Purchase Order Tab-------------------*/
    public class EditPurchaseOrder {
        private WebDriver driver;
        private MyActions myActions;

        public EditPurchaseOrder(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }

        public void clickPOIDEntry(String poID) {
            myActions.action_sendKeys(poIDEntry, poID);
            myActions.action_enter(poIDEntry);
        }

        @FindBy(xpath = "//div[@id='EditPurchaseOrder']//input[@type='text']")
        private WebElement poIDEntry;

        @FindBy(xpath = "//button[text()='Close PO']")
        private WebElement closePOButton;

        @FindBy(xpath = "//a[text()='Print Purchase order']")
        private WebElement printPurchaseOrder;

        @FindBy(xpath = "//a[text()='Print using barcode printer']")
        private WebElement printUsingBarcodePrinter;

        @FindBy(xpath = "//div[@id='EditPurchaseOrder']//div//div//div//div//b")
        private WebElement purchaseOrderStatus;

        @FindBy(xpath = "//div[@id='EditPurchaseOrder']//button[text()='Yes']")
        private WebElement clickYes;


        /*--------------Actions-------------------*/
        public void  poIdInput(String poId){
            myActions.action_sendKeys(poIDEntry,poId);
            myActions.action_enter(poIDEntry);
        }
        public void clickClosePOButton() {
            myActions.action_click(closePOButton);
            sleep(1000);
            myActions.action_click(clickYes);
        }

        public void clickPrintPurchaseOrder() {
            myActions.action_click(printPurchaseOrder);
        }

        public void clickPrintUsingBarcodePrinter() {
            myActions.action_click(printUsingBarcodePrinter);
        }

        public String getPOStatus() {

           return myActions.action_getText(purchaseOrderStatus);
        }


        /*--------------Functions-------------------*/
        public int getTotalProducts() {
            List<WebElement> products = driver.findElements(By.xpath("//div[@id='EditPurchaseOrder']//tbody/tr"));
            return products.size();
        }

        public String getSkuCode(int index) {
            String skuCodeXpath = "//div[@id='EditPurchaseOrder']//tbody/tr[" + index + "]/td[1]";
            WebElement skuCode = driver.findElement(By.xpath(skuCodeXpath));
            return myActions.action_getText(skuCode);
        }

        public String getDescription(int index) {
            String descriptionXpath = "//div[@id='EditPurchaseOrder']//tbody/tr[" + index + "]/td[2]";
            WebElement description = driver.findElement(By.xpath(descriptionXpath));
            return myActions.action_getText(description);
        }

        public String getOrderedQuantity(int index) {
            String quantityXpath = "//div[@id='EditPurchaseOrder']//tbody/tr[" + index + "]/td[3]";
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


        /*--------------Functions-------------------*/
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

        public ArrayList<String> getSkuCode(int index) {
            String skuCodeXpath = "//div[@id='PurchaseOrderList']//thead/following-sibling::tbody/tr[" + index + "]/td[7]/table/tbody/tr";
            List<WebElement> skuCode = driver.findElements(By.xpath(skuCodeXpath));
            ArrayList<String> skuCodes = new ArrayList<String>();
            for (WebElement element : skuCode)
                skuCodes.add(myActions.action_getText(element));
            return skuCodes;
        }

        public ArrayList<String> getQuantity(int index) {
            String quantityXpath = "//div[@id='PurchaseOrderList']//thead/following-sibling::tbody/tr[" + index + "]/td[8]/table/tbody/tr";
            List<WebElement> quantity = driver.findElements(By.xpath(quantityXpath));
            ArrayList<String> quantities = new ArrayList<String>();
            for (WebElement element : quantity){
                quantities.add(myActions.action_getText(element));
            }
            return quantities;

        }

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


        /*--------------Page Handling-------------------*/
        @FindBy(xpath = "//div[@id='PurchaseOrderList']//button[@title='Next Page']")
        private WebElement nextPage;

        @FindBy(xpath = "//div[@id='PurchaseOrderList']//select[@type='text']")
        private WebElement pageSize;

        @FindBy(xpath = "//div[@id='PurchaseOrderList']//button[@title='Previous Page']")
        private WebElement previousPage;

        @FindBy(xpath = "//div[@id='PurchaseOrderList']//button[@title='First Page']")
        private WebElement firstPage;

        @FindBy(xpath = "//div[@id='PurchaseOrderList']//button[@title='Current Page Number']/span")
        private WebElement pageNo;


        /*--------------Actions-------------------*/
        public void goToNextPage() {
            myActions.action_click(nextPage);
        }

        public void selectPageSize(String size) {
            myActions.action_select(pageSize, size);
        }

        public void goToPreviousPage() {
            myActions.action_click(previousPage);
        }

        public void goToFirstPage() {
            myActions.action_click(firstPage);
        }

        public int getPageNumber() {
            int pageNoInteger = Integer.valueOf(myActions.action_getText(pageNo));
            return pageNoInteger;
        }
    }


    /*--------------Create GRN Tab-------------------*/
    public class CreateGRNTab {
        private WebDriver driver;
        private MyActions myActions;

        public CreateGRNTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }

        @FindBy(xpath = "//div[@id='CreateGrn']//input[@type='text']")
        private WebElement poIDEntryField;

        @FindBy(xpath = "//div[@id='CreateGrn']//div/button")
        private WebElement createGRNButton;


        /*--------------Actions-------------------*/
        public void poIDEntry(String poID) {
            myActions.action_sendKeys(poIDEntryField, poID);
            myActions.action_enter(poIDEntryField);
        }

        public void clickGRNButton() {
            myActions.action_click(createGRNButton);
        }


        /*--------------Functions-------------------*/
        public int getTotalProducts() {
            List<WebElement> products = driver.findElements(By.xpath("//div[@id='CreateGrn']//table/tbody/tr"));
            return products.size();
        }

        public String getSkuCode(int index) {
            String skuCodeXpath = "//div[@id='CreateGrn']//tbody/tr[" + index + "]/td[1]";
            WebElement skuCode = driver.findElement(By.xpath(skuCodeXpath));
            return myActions.action_getText(skuCode);
        }

        public String getProductName(int index) {
            String productNameXpath = "//div[@id='CreateGrn']//tbody/tr[" + index + "]/td[2]";
            WebElement productName = driver.findElement(By.xpath(productNameXpath));
            return myActions.action_getText(productName);
        }

        public String getOrderedQuantity(int index) {
            String orderedQuantityXpath = "//div[@id='CreateGrn']//tbody/tr[" + index + "]/td[3]";
            WebElement orderedQuantity = driver.findElement(By.xpath(orderedQuantityXpath));
            return myActions.action_getText(orderedQuantity);
        }

        public String getReceivableQuantity(int index) {
            String receivableQuantityXpath = "//div[@id='CreateGrn']//tbody/tr[" + index + "]/td[4]";
            WebElement receivableQuantity = driver.findElement(By.xpath(receivableQuantityXpath));
            return myActions.action_getText(receivableQuantity);
        }

        public void receivedQuantityEntry(int index, String quantityReceived) {
            String receivedQuantityXpath = "//div[@id='CreateGrn']//tbody/tr[" + index + "]/td[5]//input";
            WebElement receivedQuantity = driver.findElement(By.xpath(receivedQuantityXpath));
            myActions.action_sendKeys(receivedQuantity, quantityReceived);
        }
    }


    /*--------------Qc Scan Tab-------------------*/
    public class QcScanTab {
        private WebDriver driver;
        private MyActions myActions;

        public QcScanTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }

        @FindBy(xpath = "//div[@id='QcScan']//div[@class='inner-in-scan ']//input[@type='text']")
        private WebElement packageIDEntry;

        @FindBy(xpath = "//div[@id='QcScan']//div[@class='inner-in-scan ']//input[@type='text']")
        private WebElement skuCode;

        @FindBy(xpath = "//div[@id='QcScan']//div[@class='inner-in-scan ']//input[@type='text']")
        private WebElement description;

        @FindBy(xpath = "//div[@id='QcScan']//div[@class='inner-in-scan ']//input[@type='text']")
        private WebElement image;


        /*--------------Actions-------------------*/
        public void packageIDInput(String packageID){
            myActions.action_sendKeys(packageIDEntry,packageID);
            myActions.action_enter(packageIDEntry);
        }


        /*--------------Functions-------------------*/
        public String getSkuCode(int index) {
            String skuCodeXpath = "//div[@id='QcScan']//table/tbody/tr/td[1]";
            WebElement skuCode = driver.findElement(By.xpath(skuCodeXpath));
            return myActions.action_getText(skuCode);
        }

        public String getDescription(int index) {
            String descriptionXpath = "//div[@id='QcScan']//table/tbody/tr/td[2]";
            WebElement description = driver.findElement(By.xpath(descriptionXpath));
            return myActions.action_getText(description);
        }

        public String productImage() {
            String productImageXpath = "//div[@id='QcScan']//table/tbody/tr/td[3]";
            WebElement productImageElement = driver.findElement(By.xpath(productImageXpath));
            String src = productImageElement.getAttribute("src");
            return src;
        }
    }


    /*--------------Create Bulk Purchase Order Tab-------------------*/
    public class CreateBulkPurchaseOrderTab {
        private WebDriver driver;
        private MyActions myActions;


        public CreateBulkPurchaseOrderTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }

        @FindBy(xpath = "//div[@id='CreateBulkPurchaseOrders']//label[@for='sel_warehouse']/following-sibling::select")
        private WebElement warehouseDropdown;

        @FindBy(xpath = "//div[@id='CreateBulkPurchaseOrders']//label[@for='sel_seller']/following-sibling::select")
        private WebElement sellerDropdown;

        @FindBy(xpath = "//div[@id='CreateBulkPurchaseOrders']//label[@for='sel_supplier']/following-sibling::select")
        private WebElement supplierDropdown;

        @FindBy(xpath = "//div[@id='CreateBulkPurchaseOrders']//label[@for='sel_address']/following-sibling::select")
        private WebElement addressDropdown;

        @FindBy(xpath = "//div[@id='CreateBulkPurchaseOrders']//div[5]/input")
        private WebElement addFile;

        @FindBy(xpath = "//div[@id='CreateBulkPurchaseOrders']//div[@class='text-center']/button")
        private WebElement createPOButton;

        @FindBy(xpath = "//div[@id='CreateBulkPurchaseOrders']//a")
        private WebElement downloadTemplateButton;


        /*--------------Actions-------------------*/
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

        public void clickAddSkuInputFields() {
            myActions.action_click(addFile);
        }

        public void clickCreatePOButton() {
            myActions.action_click(createPOButton);
        }

        public void clickDownloadTemplateButton() {
            myActions.action_click(downloadTemplateButton);
        }
    }


    /*--------------Transfer Order List Tab-------------------*/
    public class TransferOrderListTab{
        private WebDriver driver;
        private MyActions myActions;


        public TransferOrderListTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }


        /*--------------Functions-------------------*/
        public int getTotalTransferOrders() {
            List<WebElement> transferOrders = driver.findElements(By.xpath("//div[@id='PurchaseOrderList']//thead/following-sibling::tbody/tr"));
            return transferOrders.size();
        }

        public String getSourceWarehouseName(int index) {
            String sourceWarehouseXpath = "//div[@id='TransferOrderList']//thead/following-sibling::tbody/tr[" + index + "]/td[2]";
            WebElement sourceWarehouse = driver.findElement(By.xpath(sourceWarehouseXpath));
            return myActions.action_getText(sourceWarehouse);
        }

        public String getDestinationWarehouseName(int index) {
            String destinationWarehouseXpath = "//div[@id='TransferOrderList']//thead/following-sibling::tbody/tr[" + index + "]/td[3]";
            WebElement destinationWarehouse = driver.findElement(By.xpath(destinationWarehouseXpath));
            return myActions.action_getText(destinationWarehouse);
        }

        public String getTOId(int index) {
            String tOIDXpath = "//div[@id='TransferOrderList']//thead/following-sibling::tbody/tr[" + index + "]/td[1]";
            WebElement tOID = driver.findElement(By.xpath(tOIDXpath));
            return myActions.action_getText(tOID);
        }

        public String getStatus(int index) {
            String statusXpath = "//div[@id='TransferOrderList']//thead/following-sibling::tbody/tr[" + index + "]/td[4]";
            WebElement status = driver.findElement(By.xpath(statusXpath));
            return myActions.action_getText(status);
        }

        public ArrayList<String> getSkuCode(int index) {
            String skuCodeXpath = "//div[@id='TransferOrderList']//thead/following-sibling::tbody/tr[" + index + "]/td[5]/table/tbody/tr";
            List<WebElement> skuCode = driver.findElements(By.xpath(skuCodeXpath));
            ArrayList<String> skuCodes = new ArrayList<String>();
            for (WebElement element : skuCode)
                skuCodes.add(myActions.action_getText(element));
            return skuCodes;
        }

        public ArrayList<String> getOrderedQuantity(int index) {
            String quantityXpath = "//div[@id='TransferOrderList']//thead/following-sibling::tbody/tr[" + index + "]/td[6]/table/tbody/tr";
            List<WebElement> quantity = driver.findElements(By.xpath(quantityXpath));
            ArrayList<String> quantities = new ArrayList<String>();
            for (WebElement element : quantity)
                quantities.add(myActions.action_getText(element));
            return quantities;
        }

        public String getPickListID(int index) {
            String pickListIdXpath = "//div[@id='TransferOrderList']//thead/following-sibling::tbody/tr[" + index + "]/td[7]";
            WebElement pickListID = driver.findElement(By.xpath(pickListIdXpath));
            return myActions.action_getText(pickListID);
        }

        public void closeTO(int index){
            String closeTOXpath = "//div[@id='TransferOrderList']//thead/following-sibling::tbody/tr[" + index + "]/td[8]//button";
            WebElement closeTOButton = driver.findElement(By.xpath(closeTOXpath));
            myActions.action_click(closeTOButton);
        }
    }


    /*--------------Create Transfer Order Tab-------------------*/
    public class CreateTransferOrderTab{
        private WebDriver driver;
        private MyActions myActions;


        public CreateTransferOrderTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }

        @FindBy(xpath = "//div[@id='CreateTransferOrder']//label[@for='sel_source_warehouse']/following-sibling::select")
        private WebElement sourceWarehouseDropdown;

        @FindBy(xpath = "//div[@id='CreateTransferOrder']//label[@for='sel_destination_warehouse']/following-sibling::select")
        private WebElement destinationWarehouseDropdown;

        @FindBy(xpath = "//div[@id='CreateTransferOrder']//label[@for='sel_seller']/following-sibling::select")
        private WebElement sellerDropdown;

        @FindBy(xpath = "//div[@id='CreateTransferOrder']//div[@class='text-center']/button")
        private WebElement createTOButton;


        /*--------------Actions-------------------*/
        public void selectSourceWarehouseDropdown(String warehouse) {myActions.action_select(sourceWarehouseDropdown, warehouse);}

        public void selectDestinationWarehouseDropdown(String warehouse) { myActions.action_select(destinationWarehouseDropdown, warehouse);}

        public void selectSellerDropdown(String seller) {
            myActions.action_select(sellerDropdown, seller);
        }

        public void clickCreateTOButton() {
            myActions.action_click(createTOButton);
        }
    }
}
