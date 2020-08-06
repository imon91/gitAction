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

import java.util.List;

public class ReturnsPageObjects extends WmsBaseClass {
    private WebDriver driver;
    private MyActions myActions;
    private WebDriverWait wait;

    public ReturnsPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        myActions = new MyActions();
        wait = new WebDriverWait(driver,10);
    }

    @FindBy(xpath = "//div[@class='returns-tabs']/ul[1]/li[1]/a")
    private WebElement returnInScanTab;

    @FindBy(xpath = "//div[@class='returns-tabs']/ul[1]/li[2]/a")
    private WebElement returnQcScanTab;

    @FindBy(xpath = "//div[@class='returns-tabs']/ul[1]/li[3]/a")
    private WebElement rTSCreateManifestTab;

    @FindBy(xpath = "//div[@class='returns-tabs']/ul[1]/li[4]/a")
    private WebElement rTSOutScanTab;

    @FindBy(xpath = "//div[@class='returns-tabs']/ul[1]/li[5]/a")
    private WebElement rTSUploadManifestTab;

    public void clickReturnInScanTab(){
        wait.until(ExpectedConditions.elementToBeClickable(returnInScanTab));
        myActions.action_click(returnInScanTab);}

    public void clickReturnQcScanTab(){
        wait.until(ExpectedConditions.elementToBeClickable(returnQcScanTab));
        myActions.action_click(returnQcScanTab);}

    public void clickRTSCreateManifestTab(){
        wait.until(ExpectedConditions.elementToBeClickable(rTSCreateManifestTab));
        myActions.action_click(rTSCreateManifestTab);}

    public void clickRTSOutScanTab(){
        wait.until(ExpectedConditions.elementToBeClickable(rTSOutScanTab));
        myActions.action_click(rTSOutScanTab);}

    public void clickRTSUploadManifestTab(){
        wait.until(ExpectedConditions.elementToBeClickable(rTSUploadManifestTab));
        myActions.action_click(rTSUploadManifestTab);}


    /*--------------Return In Scan Tab-------------------*/
    public class ReturnInScanTab{
        private WebDriver driver;
        private MyActions myActions;

        public ReturnInScanTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }


        /*--------------Order Return-------------------*/
        @FindBy(xpath = "//div[@id='RtnInScan']/div/div/form/div/div/div/input[1]")
        private WebElement orderNumberEntry;

        @FindBy(xpath = "//div[@id='RtnInScan']/div/div/form/div/button[1]")
        private WebElement returnInScanButton;


        /*--------------Actions-------------------*/
        public void orderNumberInput(String orderNumber){myActions.action_sendKeys(orderNumberEntry,orderNumber);}

        public void clickReturnInScanButton(){myActions.action_click(returnInScanButton);}


        /*--------------Pick List Return-------------------*/
        @FindBy(xpath = "//div[@id='RtnInScan']/div[1]/div[2]/div[1]/div[1]/span[1]//*[local-name()='svg']")
        private WebElement pickListReturnsSection;

        @FindBy(xpath = "//div[@id='RtnInScan']/div[1]/div[2]/div[1]/div[2]//form//input")
        private WebElement pickListIdEntry;

        @FindBy(xpath = "//div[@id='RtnInScan']/div[1]/div[2]/div[1]/div[2]//form//button")
        private WebElement pickListIdSubmitButton;

        @FindBy(xpath = "//div[@id='RtnInScan']/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]//button")
        private WebElement pickListReturnSubmitButton;


        /*--------------Actions-------------------*/
        public void clickPickListReturnsSection(){
            wait.until(ExpectedConditions.visibilityOf(pickListReturnsSection));
            myActions.action_click(pickListReturnsSection);}

        public void pickListIdInput(String pickListId){
            wait.until(ExpectedConditions.visibilityOf(pickListIdEntry));
            myActions.action_sendKeys(pickListIdEntry,pickListId);}

        public void clickPickListIdSubmitButton(){
            wait.until(ExpectedConditions.visibilityOf(pickListIdSubmitButton));
            myActions.action_click(pickListIdSubmitButton);}

        public void clickPickListReturnSubmitButton(){
            wait.until(ExpectedConditions.visibilityOf(pickListReturnSubmitButton));
            myActions.action_click(pickListReturnSubmitButton);}


        /*--------------Functions-------------------*/
        public int getTotalProducts() {
            List<WebElement> products = driver.findElements(By.xpath("//div[@id='RtnInScan']/div[1]/div[2]/div[1]/div[2]//table/tbody/tr"));
            return products.size();
        }

        public String getSkuCode(int index) {
            String skuCodeXpath = "//div[@id='RtnInScan']/div[1]/div[2]/div[1]/div[2]//table/tbody/tr["+index+"]/td[1]";
            WebElement skuCode = driver.findElement(By.xpath(skuCodeXpath));
            return myActions.action_getText(skuCode);
        }

        public String getProductName(int index) {
            String productNameXpath = "//div[@id='RtnInScan']/div[1]/div[2]/div[1]/div[2]//table/tbody/tr["+index+"]/td[2]";
            WebElement productName = driver.findElement(By.xpath(productNameXpath));
            return myActions.action_getText(productName);
        }

        public int getOrderedQuantity(int index) {
            String orderedQuantityXpath = "//div[@id='RtnInScan']/div[1]/div[2]/div[1]/div[2]//table/tbody/tr["+index+"]/td[3]";
            WebElement orderedQuantity = driver.findElement(By.xpath(orderedQuantityXpath));
            int n = Integer.parseInt(myActions.action_getText(orderedQuantity));
            return n;
        }

        public int getReturnedQuantity(int index) {
            String returnedQuantityXpath = "//div[@id='RtnInScan']/div[1]/div[2]/div[1]/div[2]//table/tbody/tr["+index+"]/td[4]";
            WebElement returnedQuantity = driver.findElement(By.xpath(returnedQuantityXpath));
            int n = Integer.parseInt(myActions.action_getText(returnedQuantity));
            return n;
        }

        public void returnQuantityInput(int index, String quantityReturn) {
            String returnQuantityXpath = "//div[@id='RtnInScan']/div[1]/div[2]/div[1]/div[2]//table/tbody/tr["+index+"]/td[5]//input";
            WebElement returnQuantity = driver.findElement(By.xpath(returnQuantityXpath));
            myActions.action_sendKeys(returnQuantity,quantityReturn);
        }

        public void enterPickListId(String pickListId){
            clickPickListReturnsSection();
            pickListIdInput(pickListId);
            clickPickListIdSubmitButton();
        }


        /*--------------Sku Inward Return-------------------*/
        @FindBy(xpath = "//div[@id='RtnInScan']/div[1]/div[2]/div[2]/div[1]/span[1]//*[local-name()='svg']")
        private WebElement returnInwardSkuSection;

        @FindBy(xpath = "//div[@id='RtnInScan']/div[1]/div[2]/div[2]//form/div[1]//select")
        private WebElement warehouseDropdown;

        @FindBy(xpath = "//div[@id='RtnInScan']/div[1]/div[2]/div[2]//form/div[2]//select")
        private WebElement sellerDropdown;

        @FindBy(xpath = "//div[@id='RtnInScan']/div[1]/div[2]/div[2]//form/div[3]//select")
        private WebElement supplierDropdown;

        @FindBy(xpath = "//div[@id='RtnInScan']/div[1]/div[2]/div[2]//form/div[4]//select")
        private WebElement addressDropdown;

        @FindBy(xpath = "//div[@id='RtnInScan']//form[@id='createReturnPOForm']/div[5]/button")
        private WebElement addSkuInputFields;

        @FindBy(xpath = "//div[@id='RtnInScan']//form[@id='createReturnPOForm']/div[6]/button")
        private WebElement inwardReturnButton;


        /*--------------Actions-------------------*/
        public void clickReturnInwardSkuSection(){
            wait.until(ExpectedConditions.visibilityOf(returnInwardSkuSection));
            myActions.action_click(returnInwardSkuSection);}

        public void selectWarehouseDropdown(String warehouse) {
            wait.until(ExpectedConditions.visibilityOf(warehouseDropdown));
            myActions.action_select(warehouseDropdown, warehouse);
        }

        public void selectSellerDropdown(String seller) {
            wait.until(ExpectedConditions.visibilityOf(sellerDropdown));
            myActions.action_select(sellerDropdown, seller);
        }

        public void selectSupplierDropdown(String supplier) {
            wait.until(ExpectedConditions.visibilityOf(supplierDropdown));
            myActions.action_select(supplierDropdown, supplier);
        }

        public void selectAddressDropdown(String address) {
            wait.until(ExpectedConditions.visibilityOf(addressDropdown));
            myActions.action_select(addressDropdown, address);
        }


        /*--------------Functions-------------------*/
        public void skuCodeInput(int index, String skuCode) {
            String skuCodeXPath = "//div[@id='RtnInScan']//input[@id='select" + index + "']";
            WebElement skuCodeEntry = driver.findElement(By.xpath(skuCodeXPath));
            myActions.action_sendKeys(skuCodeEntry, skuCode);
        }

        public void quantityInput(int index, String quantity) {
            String quantityXpath = "//div[@id='RtnInScan']//input[@id='orderQuantity" + index + "']";
            WebElement quantityEntry = driver.findElement(By.xpath(quantityXpath));
            myActions.action_sendKeys(quantityEntry, quantity);
        }

        public void transferPriceInput(int index, String price) {
            String transferPriceXpath = "//div[@id='RtnInScan']//input[@id='transferPrice" + index + "']";
            WebElement transferPriceEntry = driver.findElement(By.xpath(transferPriceXpath));
            myActions.action_sendKeys(transferPriceEntry, price);
        }

        public String productImage(int index) {
            String productImageXpath = "//div[@id='RtnInScan']//input[@id='select" + index + "']/ancestor::div[@class='row']//img";
            WebElement productImageElement = driver.findElement(By.xpath(productImageXpath));
            String src = productImageElement.getAttribute("src");
            return src;
        }

        public void clickRemoveButton(int index) {
            String removeButtonXpath = "//div[@id='RtnInScan']//input[@id='select" + index + "']/ancestor::div[@class='row']//button";
            WebElement removeButton = driver.findElement(By.xpath(removeButtonXpath));
            myActions.action_click(removeButton);
        }


        /*--------------Actions-------------------*/
        public void clickAddSkuInputFields() {
            wait.until(ExpectedConditions.visibilityOf(addSkuInputFields));
            myActions.action_click(addSkuInputFields);
        }

        public void clickInwardReturnButton() {
            wait.until(ExpectedConditions.visibilityOf(inwardReturnButton));
            myActions.action_click(inwardReturnButton);
        }


        /*--------------Functions-------------------*/
        public void enterWarehouseDetails(String warehouse, String seller, String supplier, String address) {
            selectWarehouseDropdown(warehouse);
            selectSellerDropdown(seller);
            selectSupplierDropdown(supplier);
            selectAddressDropdown(address);
            sleep(10000);
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
            clickInwardReturnButton();
        }
    }


    /*--------------Return Qc Scan Tab-------------------*/
    public class ReturnQcScanTab{
        private WebDriver driver;
        private MyActions myActions;

        public ReturnQcScanTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }

        @FindBy(xpath = "//div[@id='QcScanAfterReturn']//div[1]/input")
        private WebElement packageIdEntry;

        @FindBy(xpath = "//div[@id='QcScanAfterReturn']//table/tbody/tr/td[1]")
        private WebElement skuCodeData;

        @FindBy(xpath = "//div[@id='QcScanAfterReturn']//table/tbody/tr/td[1]")
        private WebElement descriptionData;

        @FindBy(xpath = "//div[@id='QcScanAfterReturn']//table/tbody/tr/td[3]//img")
        private WebElement productImage;

        @FindBy(xpath = "//div[@id='QcScanAfterReturn']//div[2]/div[1]//input")
        private WebElement qcPassInput;

        @FindBy(xpath = "//div[@id='QcScanAfterReturn']//div[2]/div[2]//input")
        private WebElement qcFailInput;

        @FindBy(xpath = "//div[@id='QcScanAfterReturn']//div[3]/button[1]")
        private WebElement qcScanButton;

        @FindBy(xpath = "//div[@id='QcScanAfterReturn']//div[3]/button[2]")
        private WebElement showOrderDetailsButton;


        /*--------------Functions-------------------*/
        public void packageIdInput(String packageId){
            myActions.action_sendKeys(packageIdEntry,packageId);
            myActions.action_enter(packageIdEntry);
        }

        public String getSkuCode() {
            return myActions.action_getText(skuCodeData);
        }

        public String getDescription() {
            return myActions.action_getText(descriptionData);
        }

        public String productImage() {
            String src = productImage.getAttribute("src");
            return src;
        }


        /*--------------Actions-------------------*/
        public void clickQcPassInput(){myActions.action_click(qcPassInput);}

        public void clickQcFailInput(){myActions.action_click(qcFailInput);}

        public void clickQcScanButton(){myActions.action_click(qcScanButton);}

        public void clickShowOrderDetailsButton(){myActions.action_click(showOrderDetailsButton);}
    }


    /*--------------RTS Create Manifest Tab-------------------*/
    public class RTSCreateManifestTab{
        private WebDriver driver;
        private MyActions myActions;

        public RTSCreateManifestTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }


        /*--------------Functions-------------------*/
        public String getSupplierName(int index) {
            String supplierXpath = "//div[@id='RtsCreateManifest']//table/tbody/tr["+index+"]//td[1]";
            WebElement supplier = driver.findElement(By.xpath(supplierXpath));
            return myActions.action_getText(supplier);
        }
        public String getTotalQuantity(int index) {
            String totalQuantityXpath = "//div[@id='RtsCreateManifest']//table/tbody/tr["+index+"]//td[2]";
            WebElement totalQuantity = driver.findElement(By.xpath(totalQuantityXpath));
            return myActions.action_getText(totalQuantity);
        }

        public void createManifest(int index) {
            String createManifestXpath = "//div[@id='RtsCreateManifest']//table/tbody/tr["+index+"]//td[3]/button";
            WebElement createManifestButton = driver.findElement(By.xpath(createManifestXpath));
            myActions.action_click(createManifestButton);
        }
    }


    /*--------------RTS Out Scan Tab-------------------*/
    public class RTSOutScanTab{
        private WebDriver driver;
        private MyActions myActions;

        public RTSOutScanTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }

        @FindBy(xpath = "//div[@id='RtsOutScan']//input[@id='package_id']")
        private WebElement packageIdEntry;

        @FindBy(xpath = "//div[@id='RtsOutScan']//div[2]/button")
        private WebElement outScanButton;


        /*--------------Actions-------------------*/
        public void packageIdInput(String packageId){myActions.action_sendKeys(packageIdEntry,packageId);}

        public void clickOutScanButton(){myActions.action_click(outScanButton);}

        public String getPopUpMessage(){
            String popUpMessage = "//div[@id='toastbar-text']";
            WebElement popUpMessageElement = driver.findElement(By.xpath(popUpMessage));
            return myActions.action_getText(popUpMessageElement);
        }
    }


    /*--------------RTS Upload Manifest Tab-------------------*/
    public class RTSUploadManifestTab{
        private WebDriver driver;
        private MyActions myActions;

        public RTSUploadManifestTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }
    }


}
