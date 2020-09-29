package pageObjects;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import services.responseModels.wmsModels.*;
import utils.*;
import java.io.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.*;
import java.util.*;

public class PickOrdersPageObjects extends WmsBaseClass {

    private WebDriver driver;
    private MyActions myActions;

    public PickOrdersPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        myActions = new MyActions();
    }


    /*--------------Actions-------------------*/
    public void clickCreatePickListTab(){
        WebElement createPickListTab = xpathSetterClick("//div[@class='packages-details-tabs']/ul/li[1]/a");
        myActions.action_click(createPickListTab);
    }

    public void clickDemandLessPickListTab(){
        WebElement demandLessPickListTab = xpathSetterClick("//div[@class='packages-details-tabs']/ul/li[2]/a");
        myActions.action_click(demandLessPickListTab);
    }

    public void clickAllPickListsTab(){
        WebElement allPickListsTab = xpathSetterClick("//a[text()='All Pick Lists']");
        myActions.action_click(allPickListsTab);
    }

    public void clickPickListActionTab(){
        WebElement pickListActionTab = xpathSetterClick("//div[@class='packages-details-tabs']/ul/li[4]/a");
        myActions.action_click(pickListActionTab);
    }


    /*--------------Demand Less Pick List Tab-------------------*/
    public class DemandLessPickListTab {
        private final WebDriver driver;
        private final MyActions myActions;
        private HomePageObject homePageObject;
        private Random random;

        public DemandLessPickListTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
            homePageObject = new HomePageObject(driver);
            random = new Random();
        }


        /*--------------Actions-------------------*/
        public void clickAddSkuInputFields() {
            WebElement addSkuInputFields =
                    xpathSetter("//div[@id='NewPickList']//div[@class='skuInput-main']/button");
            myActions.action_click(addSkuInputFields);
        }

        public void clickCreatePickListButton() {
            WebElement createPickListButton =
                    xpathSetter("//button[contains(text(),'Create sku wise PickList')]");
            myActions.action_click(createPickListButton);
        }

        public void selectSeller(String seller) {
            WebElement selectSellerIdDropdown =
                    xpathSetter("//div[@id='NewPickList']//select[@id='ManualPickListSellerId']");
            myActions.action_select(selectSellerIdDropdown, seller);
        }

        public void selectPickupAgent(String pickup_agent) {
            WebElement selectPickupAgentIdDropdown =
                    xpathSetter("//div[@id='NewPickList']//select[@id='ManualPickListPickupAgentId']");
            myActions.action_sendKeys(selectPickupAgentIdDropdown, pickup_agent);
        }

        public void selectType(String picklist_type) {
            WebElement selectTypeIdDropdown =
                    xpathSetter("//div[@id='NewPickList']//select[@id='ManualPickListTypeId']");
            myActions.action_select(selectTypeIdDropdown, picklist_type);
        }

        public void skuCodeInput(int index, String skuCode) {
            String skuCodeXPath = "//div[@id='NewPickList']//input[@id='select" + index + "']";
            WebElement skuCodeEntry = xpathSetterPresence(skuCodeXPath);
            myActions.action_sendKeys(skuCodeEntry, skuCode+"\n");
        }

        public void quantityInput(int index, String quantity) {
            String quantityXpath = "//div[@id='NewPickList']//input[@id='orderQuantity" + index + "']";
            WebElement quantityEntry = driver.findElement(By.xpath(quantityXpath));
            myActions.action_sendKeys(quantityEntry, quantity);
        }

        public void transferPriceInput(int index, String price) {
            String transferPriceXpath = "//div[@id='NewPickList']//input[@id='transferPrice" + index + "']";
            WebElement transferPriceEntry = driver.findElement(By.xpath(transferPriceXpath));
            transferPriceEntry.clear();
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
        public void enterWarehouseDetails() {
            selectSeller("DFW");
            selectType("PHOTOSHOOT");
        }

        public void createPickListOrder(String skuCode){
            skuCodeInput(0,skuCode);
            quantityInput(0,"1");
            transferPriceInput(0,"200");
            clickCreatePickListButton();
        }

        public boolean addPickList(AddingPickListModel c) throws FileNotFoundException {
            String testCase = c.getTestCaseId();
            String error = c.getErrorMessage();
            System.out.println(testCase);
            System.out.println(error);
            homePageObject.selectWarehouse(getInputData("WarehouseCode",c.getWarehouseCode()));
            if(!c.getSeller().equals("N/A")) selectSeller(getInputData("Seller",c.getSeller()));
            if(!c.getPickupAgents().equals("N/A"))  selectPickupAgent(getInputData("Pickup",c.getPickupAgents()));
            if(!c.getType().equals("N/A"))  selectType(getInputData("Type",c.getType()));
            if(!(testCase.equals("DPL_1") || testCase.equals("DPL_3") || testCase.equals("DPL_5") || testCase.equals("DPL_6") || testCase.equals("DPL_7")))
                {
                skuCodeInput(0, getInputData("Sku Code", c.getSKU()));
                quantityInput(0, getInputData("Quantity", c.getOrderedQuantity()));
                transferPriceInput(0, getInputData("Transfer Price", c.getTransferPrice()));

                if(testCase.equals("DPL_18") || testCase.equals("DPL_19") || testCase.equals("DPL_20") || testCase.equals("DPL_21")){
                    clickAddSkuInputFields();
                    skuCodeInput(1, getInputData("Sku Code", c.getSKU()));
                }
                if(testCase.equals("DPL_19") || testCase.equals("DPL_20") || testCase.equals("DPL_21")){
                    quantityInput(1, getInputData("Quantity", c.getOrderedQuantity()));
                    transferPriceInput(1, getInputData("Transfer Price", c.getTransferPrice()));
                }
                if(testCase.equals("DPL_20") || testCase.equals("DPL_21")){
                    clickAddSkuInputFields();
                    skuCodeInput(2, getInputData("Sku Code", c.getSKU()));
                    quantityInput(2, getInputData("Quantity", c.getOrderedQuantity()));
                    transferPriceInput(2, getInputData("Transfer Price", c.getTransferPrice()));
                }
                if(testCase.equals("DPL_21")){
                    clickAddSkuInputFields();
                    skuCodeInput(3, getInputData("Sku Code", c.getSKU()));
                    quantityInput(3, getInputData("Quantity", c.getOrderedQuantity()));
                    transferPriceInput(3, getInputData("Transfer Price", c.getTransferPrice()));
                }
            }

            clickCreatePickListButton();
            if(error.equals("N/A")) return homePageObject.getPopUpMessage().equals(c.getToastMessage());
            else return verifyElementVisibilityWithText(error);
        }
        public boolean verifyElementVisibilityWithText(String value)
        {
            WebElement element =
                    xpathSetter("//label[contains(text(),'"+value+"')]");
            return element.isDisplayed();
        }

        public String getInputData(String attribute,String input) throws FileNotFoundException {
            switch (attribute) {
                case "WarehouseCode":
                    switch (input) {
                        case "Selected":
                            return "Shopup Dhaka";
                        case "N/A":
                            return "Choose WareHouse";
                    }
                case "Seller":
                    switch (input) {
                        case "Selected":
                            return "DFW";
                        case "N/A":
                            return "Select Seller";
                    }
                case "Type":
                    switch (input) {
                        case "Selected":
                            return "PHOTOSHOOT";
                        case "N/A":
                            return " Select PickList Type";
                    }

                case "Pickup":
                    switch (input) {
                        case "Selected":
                            return "test1";
                        case "N/A":
                            return " Select Pickup Agent";
                    }
                case "Sku Code":
                    switch (input) {
                        case "Selected":
                            return getSkuCodeData();
                        case "Invalid":
                            return "xyz";
                        case "N/A":
                            return " ";
                    }
                case "Quantity":
                    switch (input) {
                        case "Valid":
                            return String.valueOf(random.nextInt(3)+1);
                        case "Invalid":
                            return "xyz";
                        case "Negative":
                            return "-1";
                        case "Zero":
                            return "0";
                        case "N/A":
                            return " ";
                    }
                case "Transfer Price":
                    switch (input) {
                        case "Valid":
                            return String.valueOf(random.nextInt(300));
                        case "Invalid":
                            return "xyz";
                        case "Negative":
                            return "-1";
                        case "Zero":
                            return "0";
                        case "N/A":
                            return " ";
                    }
                default: return " ";
            }
        }

        public String getSkuCodeData() throws FileNotFoundException {
            Gson gson = new Gson();
            String dir = System.getProperty("user.dir");
            String filePath = dir + "/src/test/resources/testData/sellerSkuCodes.json";

            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            List<VariantDetailsModel> list = gson.fromJson(bufferedReader,
                    new TypeToken<List<VariantDetailsModel>>(){}.getType());

            int n = random.nextInt(list.size());
            return list.get(n).getSku_code();
        }

    }


    /*--------------Pick List Action Tab-------------------*/
    public class PickListActionTab{
        private final WebDriver driver;
        private final MyActions myActions;
        private HomePageObject homePageObject;

        public PickListActionTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
            homePageObject = new HomePageObject(driver);
        }


        /*--------------Actions-------------------*/


        public void packageIdInput(String packageId){
            WebElement packageIdEntry =
                    xpathSetter("//div[@id='PackageOutScan']//input[@id='packageOutScanId']");
            myActions.action_sendKeys(packageIdEntry,packageId);
        }

        public void pickListIdInput(String id){
            WebElement pickListIdEntry =
                    xpathSetter("//div[@id='PackageOutScan']//input[@id='packageOutScanPickListId']");
            myActions.action_sendKeys(pickListIdEntry,id);
        }

        public void clickSubmitOutScan(){
            WebElement submitOutScan =
                    xpathSetter("//button[contains(text(),'Submit OutScan')]");
            myActions.action_click(submitOutScan);
        }

        public void clickYes(){
            WebElement yesButton =
                    xpathSetter("//body/div/div/div/div/div/div/div/button[2]");
            myActions.action_click(yesButton);
          
        public void clickQcPassCheckBox(){
            WebElement qcPassCheckBox =
                    xpathSetter("//div[@id='PackageOutScan']//label[2]//span[1]//input[1]");
            myActions.action_click(qcPassCheckBox);
        }

        public void clickQcFailCheckBox(){
            WebElement qcFailCheckBox =
                    xpathSetter("//div[@id='PackageOutScan']//label[3]//span[1]//input[1]");
            myActions.action_click(qcFailCheckBox);
        }

        public void clickResetButton(){
            WebElement resetButton =
                    xpathSetter("//div[@id='PackageOutScan']//button[1]");
            myActions.action_click(resetButton);
        }

        public void clickSubmitOutwardPickListButton(){
            WebElement submitOutScanButton =
                    xpathSetter("//div[@id='PackageOutScan']//div//div//div[1]//div[1]//button[1]");

        public void clickSubmitOutScanButton(){
            WebElement submitOutScanButton =
                    xpathSetter("//div[@id='PackageOutScan']//button[2]");

            myActions.action_click(submitOutScanButton);}

        public void pickListIdEntry(String id){
            WebElement pickListIdEntry =
                    xpathSetter("//div[@id='PackageOutScan']//input[@id='packageOutScanPickListId']");
            myActions.action_sendKeys(pickListIdEntry,id);
            myActions.action_enter(pickListIdEntry);
        }

        public int getTotalProducts(){
            List<WebElement> products = driver.findElements(By.xpath("//div[@id='PackageOutScan']//tbody/tr"));
            return products.size();
        }

        public String getPickListID(int index) {
            String pickListIdXpath = "//div[@id='PackageOutScan']//tbody/tr["+index+"]/td[1]";
            WebElement pickListID = driver.findElement(By.xpath(pickListIdXpath));
            return myActions.action_getText(pickListID);
        }

        public String getSkuCode(int index) {
            String skuCodeXpath = "//div[@id='PackageOutScan']//tbody/tr["+index+"]/td[2]";
            WebElement skuCode = driver.findElement(By.xpath(skuCodeXpath));
            return myActions.action_getText(skuCode);
        }

        public String productImage(int index) {
            String productImageXpath = "//div[@id='PackageOutScan']//tbody/tr["+index+"]/td[3]//img";
            WebElement productImageElement = driver.findElement(By.xpath(productImageXpath));
            String src = productImageElement.getAttribute("src");
            return src;
        }

        public String getDescription(int index) {
            String descriptionXpath = "//div[@id='PackageOutScan']//tbody/tr["+index+"]/td[4]";
            WebElement description = driver.findElement(By.xpath(descriptionXpath));
            return myActions.action_getText(description);
        }

        public String getQuantity(int index) {
            String quantityXpath = "//div[@id='PackageOutScan']//tbody/tr["+index+"]/td[5]";
            WebElement quantity = driver.findElement(By.xpath(quantityXpath));
            return myActions.action_getText(quantity);
        }

        public String getUnpickedQuantity(int index) {
            String quantityUnpickedXpath = "//div[@id='PackageOutScan']//tbody/tr["+index+"]/td[6]";
            WebElement quantityUnpicked = driver.findElement(By.xpath(quantityUnpickedXpath));
            return myActions.action_getText(quantityUnpicked);
        }

        public String getBinCode(int index) {
            String warehouseBinCodeXpath = "//div[@id='PackageOutScan']//tbody/tr["+index+"]/td[7]";
            WebElement warehouseBinCode = driver.findElement(By.xpath(warehouseBinCodeXpath));
            return myActions.action_getText(warehouseBinCode);
        }

        public String getStatus(int index) {
            String statusXpath = "//div[@id='PackageOutScan']//tbody/tr["+index+"]/td[8]";
            WebElement status = driver.findElement(By.xpath(statusXpath));
            return myActions.action_getText(status);
        }

        public boolean pickListActionReg(PickListActionModel p, String id) throws FileNotFoundException {
            String testCase = p.getTestCaseId();
            String error = p.getErrorMessages();
            if(testCase.equals("PLA_7")) {
                pickListIdEntry(getInputData("PickListId", p.getPickListId(), id));
                clickSubmitOutwardPickListButton();
                clickYes();
            }
            else{
                pickListIdInput(getInputData("PickListId", p.getPickListId(), id));
                packageIdInput(getInputData("ScanPackages",p.getScanPackages(),id));
                clickSubmitOutScan();
            }
            if(error.equals("N/A")) return homePageObject.getPopUpMessage().equals(p.getToastMessage());
            else return verifyElementVisibilityWithText(error);
        }

        public boolean verifyElementVisibilityWithText(String value)
        {
            WebElement element =
                    xpathSetter("//label[contains(text(),'"+value+"')]");
            return element.isDisplayed();
        }

        public String getInputData(String attribute,String input, String id) throws FileNotFoundException {
            switch (attribute) {
                case "PickListId":
                    switch (input) {
                        case "Valid":
                            return id;
                        case "Invalid":
                            return "xxx";
                        case "N/A":
                            return " ";
                    }
                case "ScanPackages":
                    switch (input) {
                        case "Valid":
                            return "942727";
                        case "Invalid":
                            return "xxx";
                        case "N/A":
                            return " ";
                    }
                default: return " ";
            }
        }
    }


    /*--------------All Pick Lists Tab-------------------*/
    public class AllPickListsTab{
        private final WebDriver driver;
        private final MyActions myActions;
        private final Actions actions;

        public AllPickListsTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
            actions = new Actions(driver);
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

        public String outForPickup(int index){
            String id  = getPickListID(index);
            printInvoice(index);
            ArrayList<String> tabs = new ArrayList (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            actions.sendKeys(Keys.ESCAPE).build().perform();
            driver.close();
            driver.switchTo().window(tabs.get(0));
            return id;
        }
    }
}
