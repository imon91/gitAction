package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.*;

import java.util.*;

public class PurchaseOrdersPageObjects extends WmsBaseClass {
    private WebDriver driver;
    private MyActions myActions;

    public PurchaseOrdersPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        myActions = new MyActions();
    }


    /*--------------Actions-------------------*/
    public void clickCreatePurchaseOrderTab() {
        WebElement createPurchaseOrderTab = xpathSetter("//a[text()='Create Purchase Order']");
        myActions.action_click(createPurchaseOrderTab);
    }

    public void clickCreateBulkPOTab() {
        WebElement createBulkPOTab = xpathSetter("//a[text()='Create Bulk PO']");
        myActions.action_click(createBulkPOTab);
    }

    public void clickCreateTOTab() {
        WebElement createTOTab = xpathSetter("//a[text()='Create TO']");
        myActions.action_click(createTOTab);
    }

    public void clickQcScanTab() {
        WebElement qcScanTab = xpathSetter("//a[text()='Qc Scan']");
        myActions.action_click(qcScanTab);
    }

    public void clickEditPurchaseOrderTab() {
        WebElement editPurchaseOrderTab = xpathSetter("//a[text()='Edit PurchaseOrder']");
        myActions.action_click(editPurchaseOrderTab);
    }

    public void clickPurchaseOrderListTab() {
        WebElement purchaseOrderListTab = xpathSetter("//a[text()='Purchase Order List']");
        myActions.action_click(purchaseOrderListTab);
    }

    public void clickTOListTab() {
        WebElement tOListTab = xpathSetter("//a[text()='TO List']");
        myActions.action_click(tOListTab);
    }

    public void clickCreateGRNTab() {
        WebElement createGRNTab = xpathSetter("//a[text()='Create GRN']");
        myActions.action_click(createGRNTab);
    }

    public void clickGRNViewTab() {
        WebElement gRNViewTab = xpathSetter("//a[text()='GRN View']");
        myActions.action_click(gRNViewTab);
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


        /*--------------Actions-------------------*/
        public void selectWarehouseDropdown(String warehouse) {
            WebElement warehouseDropdown =
                    xpathSetter("//div[@id='Addpurchage']//label[@for='sel_warehouse']/following-sibling::select");
            myActions.action_select(warehouseDropdown, warehouse);
        }

        public void selectSellerDropdown(String seller) {
            WebElement sellerDropdown =
                    xpathSetter("//div[@id='Addpurchage']//label[@for='sel_seller']/following-sibling::select");
            myActions.action_select(sellerDropdown, seller);
        }

        public void selectSupplierDropdown(String supplier) {
            WebElement supplierDropdown =
                    xpathSetter("//div[@id='Addpurchage']//label[@for='sel_supplier']/following-sibling::select");
            myActions.action_select(supplierDropdown, supplier);
        }

        public void selectAddressDropdown(String address) {
            WebElement addressDropdown =
                    xpathSetter("//div[@id='Addpurchage']//div[3]//div[1]//div[1]//select[1]");
            myActions.action_select(addressDropdown, address);
        }

        public void selectShippingModeDropdown(String mode) {
            WebElement shippingModeDropdown =
                    xpathSetter("//div[@id='Addpurchage']//div[4]//div[1]//div[1]//select[1]");
            myActions.action_select_index(shippingModeDropdown, 1);
        }

        public void skuCodeInput(int index, String skuCode) {
            String skuCodeXPath = "//div[@id='Addpurchage']//input[@id='select" + index + "']";
            WebElement skuCodeEntry = xpathSetterPresence(skuCodeXPath);
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
            WebElement addSkuInputFields =
                    xpathSetter("//div[@id='Addpurchage']//div[@class='skuInput-main']/button");
            myActions.action_click(addSkuInputFields);
        }

        public void clickCreatePOButton() {
            WebElement createPOButton =
                    xpathSetter("//div[@id='Addpurchage']//div[@class='text-center']/button");
            myActions.action_click(createPOButton);
        }


        /*--------------Functions-------------------*/
        public void enterWarehouseDetails() {
            selectSellerDropdown("DFW");
            selectShippingModeDropdown(" Surface ");
        }

        public void createPurchaseOrder(String skuCode){
            skuCodeInput(0,skuCode);
            quantityInput(0,"1");
            clickCreatePOButton();
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


        /*--------------Actions-------------------*/
        public void  poIdInput(String poId){
            WebElement poIDEntry =
                    xpathSetter("//div[@id='EditPurchaseOrder']//input[@type='text']");
            myActions.action_sendKeys(poIDEntry,poId);
            myActions.action_enter(poIDEntry);
        }
        public void clickClosePOButton() {
            WebElement closePOButton =
                    xpathSetter("//button[text()='Close PO']");
            myActions.action_click(closePOButton);
            WebElement clickYes =
                    xpathSetter("//div[@id='EditPurchaseOrder']//button[text()='Yes']");
            myActions.action_click(clickYes);
        }

        public void clickPrintPurchaseOrder() {
            WebElement printPurchaseOrder =
                    xpathSetter("//a[text()='Print Purchase order']");
            myActions.action_click(printPurchaseOrder);
        }

        public void clickPrintUsingBarcodePrinter() {
            WebElement printUsingBarcodePrinter =
                    xpathSetter("//a[text()='Print using barcode printer']");
            myActions.action_click(printUsingBarcodePrinter);
        }

        public String getPOStatus() {
            WebElement purchaseOrderStatus =
                    xpathSetter("//div[@id='EditPurchaseOrder']//div//div//div//div//b");
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


        /*--------------Actions-------------------*/
        public void goToNextPage() {
            WebElement nextPage =
                    xpathSetter("//div[@id='PurchaseOrderList']//button[@title='Next Page']");
            myActions.action_click(nextPage);
        }

        public void selectPageSize(String size) {
            WebElement pageSize =
                    xpathSetter("//div[@id='PurchaseOrderList']//select[@type='text']");
            myActions.action_select(pageSize, size);
        }

        public void goToPreviousPage() {
            WebElement previousPage =
                    xpathSetter("//div[@id='PurchaseOrderList']//button[@title='Previous Page']");
            myActions.action_click(previousPage);
        }

        public void goToFirstPage() {
            WebElement firstPage =
                    xpathSetter("//div[@id='PurchaseOrderList']//button[@title='First Page']");
            myActions.action_click(firstPage);
        }

        public int getPageNumber() {
            WebElement pageNo =
                    xpathSetter("//div[@id='PurchaseOrderList']//button[@title='Current Page Number']/span");
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


        /*--------------Actions-------------------*/
        public void poIDEntry(String poID) {
            WebElement poIDEntryField = xpathSetter("//div[@id='GrnCreate']//input[@type='text']");
            myActions.action_sendKeys(poIDEntryField, poID);
            myActions.action_enter(poIDEntryField);
        }

        public void clickGRNButton() {
            WebElement createGRNButton = xpathSetter("//button[contains(text(),'Create GRN')]");
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


        /*--------------Actions-------------------*/
        public void packageIDInput(String packageID){
            WebElement packageIDEntry =
                    xpathSetter("//div[@id='QcScan']/div/div[1]/div/div/div/input");
            myActions.action_sendKeys(packageIDEntry,packageID);
            myActions.action_enter(packageIDEntry);
        }

        public void packageIDScan(String packageID){
            WebElement packageIDEntryScan =
                    xpathSetter("//div[@id='QcScan']//div[3]//input[@type='text']");
            myActions.action_sendKeys(packageIDEntryScan,packageID);
            myActions.action_enter(packageIDEntryScan);
        }

        public void clickCancelButton(){
            WebElement cancelButton =
                    xpathSetter("//*[@id='sidebar']//print-preview-button-strip//div/cr-button[1]");
            myActions.action_click(cancelButton);
        }

        public String getFirstPackage(){
            WebElement firstPackage = xpathSetter("//body//div[1]//div[1]");
            return myActions.action_getText(firstPackage);
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
            String productImageXpath = "//div[@id='QcScan']//tbody/tr/td[3]//img";
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


    /*--------------GRN View Tab-------------------*/
    public class GRNViewTab {
        private WebDriver driver;
        private MyActions myActions;


        public GRNViewTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }

        @FindBy(xpath = "//div[@id='GrnView']//input")
        private WebElement poIDEntryField;


        /*--------------Actions-------------------*/
        public void poIDEntry(String poID) {
            myActions.action_sendKeys(poIDEntryField, poID);
            myActions.action_enter(poIDEntryField);
        }

        public int getTotalGRN() {
            List<WebElement> grn = driver.findElements(By.xpath("//div[@id='PurchaseOrderList']//thead/following-sibling::tbody/tr"));
            return grn.size();
        }
    }
}