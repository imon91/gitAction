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

public class PickOrdersPageObjects extends WmsBaseClass {
    private WebDriver driver;
    private MyActions myActions;

    public PickOrdersPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        myActions = new MyActions();
    }


    /*--------------Tabs-------------------*/
    @FindBy(xpath = "//div[@class='packages-details-tabs']/ul/li[1]/a")
    private WebElement createPickListTab;

    @FindBy(xpath = "//div[@class='packages-details-tabs']/ul/li[2]/a")
    private WebElement demandLessPickListTab;

    @FindBy(xpath = "//div[@class='packages-details-tabs']/ul/li[3]/a")
    private WebElement allPickListsTab;

    @FindBy(xpath = "//div[@class='packages-details-tabs']/ul/li[4]/a")
    private WebElement pickListActionTab;


    /*--------------Actions-------------------*/
    public void clickCreatePickListTab(){myActions.action_click(createPickListTab);}

    public void clickDemandLessPickListTab(){myActions.action_click(demandLessPickListTab);}

    public void clickAllPickListsTab(){myActions.action_click(allPickListsTab);}

    public void clickPickListActionTab(){myActions.action_click(pickListActionTab);}


    /*--------------Demand Less Pick List Tab-------------------*/
    public class DemandLessPickListTab {
        private WebDriver driver;
        private MyActions myActions;

        public DemandLessPickListTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }

        @FindBy(xpath = "//div[@id='NewPickList']//select[@id='ManualPickListWarehouseId']")
        private WebElement selectWarehouseIdDropdown;

        @FindBy(xpath = "//div[@id='NewPickList']//select[@id='ManualPickListSellerId']")
        private WebElement selectSellerIdDropdown;

        @FindBy(xpath = "//div[@id='NewPickList']//select[@id='ManualPickListPickupAgentId']")
        private WebElement selectPickupAgentIdDropdown;

        @FindBy(xpath = "//div[@id='NewPickList']//select[@id='ManualPickListTypeId']")
        private WebElement selectTypeIdDropdown;

        @FindBy(xpath = "//div[@id='NewPickList']//button[@type='submit']")
        private WebElement select;

        @FindBy(xpath = "//div[@id='NewPickList']//div[@class='row'][5]/div[1]/button")
        private WebElement createPickListButton;

        @FindBy(xpath = "//div[@id='NewPickList']//div[@class='skuInput-main']/button")
        private WebElement addSkuInputFields;


        /*--------------Actions-------------------*/
        public void clickAddSkuInputFields() {
            myActions.action_click(addSkuInputFields);
        }

        public void clickCreatePickListButton() {
            myActions.action_click(createPickListButton);
        }

        public void selectWarehouse(String warehouse) {
            myActions.action_select(selectWarehouseIdDropdown, warehouse);
        }

        public void selectSeller(String seller) {
            myActions.action_select(selectSellerIdDropdown, seller);
        }

        public void selectPickupAgent(String pickup_agent) {
            myActions.action_sendKeys(selectPickupAgentIdDropdown, pickup_agent);
        }

        public void selectType(String picklist_type) {
            myActions.action_select(selectTypeIdDropdown, picklist_type);
        }

        public void skuCodeInput(int index, String skuCode) {
            String skuCodeXPath = "//div[@id='NewPickList']//input[@id='select" + index + "']";
            WebElement skuCodeEntry = driver.findElement(By.xpath(skuCodeXPath));
            myActions.action_sendKeys(skuCodeEntry, skuCode);
        }

        public void quantityInput(int index, String quantity) {
            String quantityXpath = "//div[@id='NewPickList']//input[@id='orderQuantity" + index + "']";
            WebElement quantityEntry = driver.findElement(By.xpath(quantityXpath));
            myActions.action_sendKeys(quantityEntry, quantity);
        }

        public void transferPriceInput(int index, String price) {
            String transferPriceXpath = "//div[@id='NewPickList']//input[@id='transferPrice" + index + "']";
            WebElement transferPriceEntry = driver.findElement(By.xpath(transferPriceXpath));
            myActions.action_sendKeys(transferPriceEntry, price);
        }

        public String productImage(int index) {
            String productImageXpath = "//div[@id='NewPickList']//input[@id='select" + index + "']/ancestor::div[@class='row']//img";
            WebElement productImageElement = driver.findElement(By.xpath(productImageXpath));
            String src = productImageElement.getAttribute("src");
            return src;
        }

        public void clickRemoveButton(int index) {
            String removeButtonXpath = "//div[@id='NewPickList']//input[@id='select" + index + "']/ancestor::div[@class='row']//button";
            WebElement removeButton = driver.findElement(By.xpath(removeButtonXpath));
            myActions.action_click(removeButton);
        }


        /*--------------Functions-------------------*/
        public void enterWarehouseDetails(String warehouse, String seller, String pickup_agent, String picklist_type) {
            selectWarehouse(warehouse);
            selectSeller(seller);
            selectPickupAgent(pickup_agent);
            selectType(picklist_type);
            sleep(10000);
        }

        public void createPickList(int no_of_products, String skuCode[], String quantity[], String price[]) {
            for (int i = 0; i < no_of_products; i++) {
                skuCodeInput(i, skuCode[i]);
                quantityInput(i, quantity[i]);
                transferPriceInput(i, price[i]);
                String src = productImage(i);
                if (i != (no_of_products - 1)) {
                    clickAddSkuInputFields();
                }
            }
            clickCreatePickListButton();
        }
    }


    /*--------------Pick List Action Tab-------------------*/
    public class PickListActionTab{
        private WebDriver driver;
        private MyActions myActions;

        public PickListActionTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }

        @FindBy(xpath = "//div[@id='PackageOutScan']//input[@id='packageOutScanPickListId']")
        private WebElement pickListIdEntry;

        @FindBy(xpath = "//div[@id='PackageOutScan']//input[@id='packageOutScanId']")
        private WebElement packageIdEntry;

        @FindBy(xpath = "//div[@id='PackageOutScan']//label[2]//span[1]//input[1]")
        private WebElement qcPassCheckBox;

        @FindBy(xpath = "//div[@id='PackageOutScan']//label[3]//span[1]//input[1]")
        private WebElement qcFailCheckBox;

        @FindBy(xpath = "//div[@id='PackageOutScan']//button[1]")
        private WebElement resetButton;

        @FindBy(xpath = "//div[@id='PackageOutScan']//button[2]")
        private WebElement submitOutScanButton;


        /*--------------Actions-------------------*/
        public void pickListIdInput(String pickListId){myActions.action_sendKeys(pickListIdEntry,pickListId);}

        public void packageIdInput(String packageId){myActions.action_sendKeys(packageIdEntry,packageId);}

        public void clickQcPassCheckBox(){myActions.action_click(qcPassCheckBox);}

        public void clickQcFailCheckBox(){myActions.action_click(qcFailCheckBox);}

        public void clickResetButton(){myActions.action_click(resetButton);}

        public void clickSubmitOutScanButton(){myActions.action_click(submitOutScanButton);}

        public void performOutScan(String pickListId, String packageId) {
            pickListIdInput(pickListId);
            packageIdInput(packageId);
            clickSubmitOutScanButton();
        }
    }


    /*--------------All Pick Lists Tab-------------------*/
    public class AllPickListsTab{
        private WebDriver driver;
        private MyActions myActions;

        public AllPickListsTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }


        /*--------------Actions-------------------*/
        public int getTotalPickLists() {
            List<WebElement> pickLists = driver.findElements(By.xpath("//div[@id='AllPickList']//tbody/tr"));
            return pickLists.size();
        }

        public String getPickListID(int index) {
            String pickListIdXpath = "//div[@id='AllPickList']//tbody/tr["+index+"]/td[1]";
            WebElement pickListID = driver.findElement(By.xpath(pickListIdXpath));
            return myActions.action_getText(pickListID);
        }

        public String getCreatedDate(int index) {
            String createdDateXpath = "//div[@id='AllPickList']//tbody/tr["+index+"]/td[2]";
            WebElement createdDate = driver.findElement(By.xpath(createdDateXpath));
            return myActions.action_getText(createdDate);
        }

        public String getPickListReason(int index) {
            String pickListReasonXpath = "//div[@id='AllPickList']//tbody/tr["+index+"]/td[3]";
            WebElement pickListReason = driver.findElement(By.xpath(pickListReasonXpath));
            return myActions.action_getText(pickListReason);
        }

        public String getStatus(int index) {
            String statusXpath = "//div[@id='AllPickList']//tbody/tr["+index+"]/td[4]";
            WebElement status = driver.findElement(By.xpath(statusXpath));
            return myActions.action_getText(status);
        }

        public String getTotalQuantity(int index) {
            String totalQuantityXpath = "//div[@id='AllPickList']//tbody/tr["+index+"]/td[5]";
            WebElement totalQuantity = driver.findElement(By.xpath(totalQuantityXpath));
            return myActions.action_getText(totalQuantity);
        }

        public ArrayList<String> getSkuCode(int index) {
            String skuCodeXpath = "//div[@id='AllPickList']//tbody/tr["+index+"]/td[6]/div/p";
            List<WebElement> skuCode = driver.findElements(By.xpath(skuCodeXpath));
            ArrayList<String> skuCodes = new ArrayList<String>();
            for (WebElement element : skuCode)
                skuCodes.add(myActions.action_getText(element));
            return skuCodes;
        }

        public ArrayList<String> getWarehouseBinCode(int index) {
            String warehouseBinCodeXpath = "//div[@id='AllPickList']//tbody/tr["+index+"]/td[7]/div/p";
            List<WebElement> warehouseBinCode = driver.findElements(By.xpath(warehouseBinCodeXpath));
            ArrayList<String> warehouseBinCodes = new ArrayList<String>();
            for (WebElement element : warehouseBinCode)
                warehouseBinCodes.add(myActions.action_getText(element));
            return warehouseBinCodes;
        }

        public ArrayList<String> getQuantity(int index) {
            String quantityXpath = "//div[@id='AllPickList']//tbody/tr["+index+"]/td[8]/div/p";
            List<WebElement> quantity = driver.findElements(By.xpath(quantityXpath));
            ArrayList<String> quantities = new ArrayList<String>();
            for (WebElement element : quantity)
                quantities.add(myActions.action_getText(element));
            return quantities;
        }

        public ArrayList<String> getPickedQuantity(int index) {
            String pickedQuantityXpath = "//div[@id='AllPickList']//tbody/tr["+index+"]/td[9]/div/p";
            List<WebElement> pickedQuantity = driver.findElements(By.xpath(pickedQuantityXpath));
            ArrayList<String> pickedQuantities = new ArrayList<String>();
            for (WebElement element : pickedQuantity)
                pickedQuantities.add(myActions.action_getText(element));
            return pickedQuantities;
        }

        public void printInvoice(int index){
            String printInvoiceXpath = "//div[@id='AllPickList']//tbody/tr["+index+"]/td[10]/a";
            WebElement printInvoiceButton = driver.findElement(By.xpath(printInvoiceXpath));
            myActions.action_click(printInvoiceButton);
        }

        public void clickCloseButton(int index){
            String closeXpath = "//div[@id='AllPickList']//tbody/tr["+index+"]/td[10]/p";
            WebElement closeButton = driver.findElement(By.xpath(closeXpath));
            myActions.action_click(closeButton);
        }


        /*--------------Page Handling-------------------*/
        @FindBy(xpath = "//div[@id='AllPickList']/div[1]/div[2]/ul[1]/li[9]/a")
        private WebElement nextPage;

        @FindBy(xpath = "//div[@id='AllPickList']/div[1]/div[2]/ul[1]/li[1]/a")
        private WebElement previousPage;

        @FindBy(xpath = "//div[@id='AllPickList']//input[@id='rc_select_21']")
        private WebElement pageSize;

        @FindBy(xpath = "//div[@id='AllPickList']/div[1]/div[2]/ul[1]/li[10]/div[2]/input")
        private WebElement pageNumberEntry;


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

        public void enterPageNumber(String pageNumber){
            myActions.action_sendKeys(pageNumberEntry,pageNumber);
            myActions.action_enter(pageNumberEntry);
        }

    }
}
