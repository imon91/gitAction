package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

public class PackagesPageObjects {
    private WebDriver driver;
    private MyActions myActions;

    public PackagesPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        myActions = new MyActions();
    }


    /*--------------Tabs-------------------*/
    @FindBy(xpath = "//div[@class='packages-container']//ul/li[1]/a")
    private WebElement packagesListTab;

    @FindBy(xpath = "//div[@class='packages-container']//ul/li[2]/a")
    private WebElement createPutawayListTab;

    @FindBy(xpath = "//div[@class='packages-container']//ul/li[3]/a")
    private WebElement binInScanTab;

    @FindBy(xpath = "//div[@class='packages-container']//ul/li[4]/a")
    private WebElement binResetTab;

    @FindBy(xpath = "//div[@class='packages-container']//ul/li[5]/a")
    private WebElement packageDetailsTab;


    /*--------------Actions-------------------*/
    public void clickPackagesListTab() {
        myActions.action_click(packagesListTab);
    }

    public void clickCreatePutawayListTab() {
        myActions.action_click(createPutawayListTab);
    }

    public void clickBinInScanTab() {
        myActions.action_click(binInScanTab);
    }

    public void clickBinResetTab() {
        myActions.action_click(binResetTab);
    }

    public void clickPackageDetailsTab() {
        myActions.action_click(packageDetailsTab);
    }


    /*--------------Packages List Tab-------------------*/
    public class PackagesListTab {
        private WebDriver driver;
        private MyActions myActions;

        public PackagesListTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }

        @FindBy(xpath = "//div[@id='PackagesList']//select")
        private WebElement selectStatusDropdown;

        @FindBy(xpath = "//div[@id='PackagesList']//button")
        private WebElement selectAllButton;


        /*--------------Actions-------------------*/
        public void selectStatus(String status) {
            myActions.action_select(selectStatusDropdown, status);
        }

        public void clickSelectAllButton() {
            myActions.action_click(selectAllButton);
        }

        /*--------------Functions-------------------*/
        public String getSkuCode(int index) {
            String skuCodeXpath = "//div[@id='PackagesList']//table/tbody/tr[" + index + "]/td[2]";
            WebElement skuCode = driver.findElement(By.xpath(skuCodeXpath));
            return myActions.action_getText(skuCode);
        }

        public String getDescription(int index) {
            String descriptionXpath = "//div[@id='PackagesList']//table/tbody/tr[" + index + "]/td[3]";
            WebElement description = driver.findElement(By.xpath(descriptionXpath));
            return myActions.action_getText(description);
        }

        public String getStatus(int index) {
            String statusXpath = "//div[@id='PackagesList']//table/tbody/tr[" + index + "]/td[4]";
            WebElement status = driver.findElement(By.xpath(statusXpath));
            return myActions.action_getText(status);
        }

        public String getQuantity(int index) {
            String quantityXpath = "//div[@id='PackagesList']//table/tbody/tr[" + index + "]/td[4]";
            WebElement quantity = driver.findElement(By.xpath(quantityXpath));
            return myActions.action_getText(quantity);
        }
    }


    /*--------------Create Put-away List Tab-------------------*/
    public class CreatePutawayListTab {
        private WebDriver driver;
        private MyActions myActions;

        public CreatePutawayListTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }

        @FindBy(xpath = "//div[@id='Create-Putaway-List']//div[1]/select")
        private WebElement selectStatusDropdown;

        @FindBy(xpath = "//div[@id='Create-Putaway-List']//div[1]/input")
        private WebElement packageIDEntry;

        @FindBy(xpath = "//div[@id='Create-Putaway-List']//div[3]/select")
        private WebElement selectAllocationTypeDropdown;

        @FindBy(xpath = "//div[@id='Create-Putaway-List']//div/button")
        private WebElement createPutawayListButton;


        /*--------------Actions-------------------*/
        public void selectStatus(String status) {
            myActions.action_select(selectStatusDropdown, status);
        }

        public void inputPackageID(String packageID) {
            myActions.action_sendKeys(selectStatusDropdown, packageID);
        }

        public void selectAllocationType(String allocationType) {
            myActions.action_select(selectAllocationTypeDropdown, allocationType);
        }

        public void clickCreatePutawayListButton() {
            myActions.action_click(createPutawayListButton);
        }


        /*--------------Functions-------------------*/
        public void createPutawayList(String status, String packageID, String allocationType) {
            selectStatus(status);
            inputPackageID(packageID);
            selectAllocationType(allocationType);
            clickCreatePutawayListButton();
        }
    }


    /*--------------Bin Reset Tab-------------------*/
    public class BinResetTab {
        private WebDriver driver;
        private MyActions myActions;

        public BinResetTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }

        @FindBy(xpath = "//div[@id='BinReset']//input[@id='binResetPackageId']")
        private WebElement packageIDEntry;

        @FindBy(xpath = "//div[@id='BinReset']//select[@id='binResetPackageIdStatus']")
        private WebElement selectStatusDropdown;

        @FindBy(xpath = "//div[@id='BinReset']//div[2]/button[1]")
        private WebElement resetButton;

        @FindBy(xpath = "//div[@id='BinReset']//div[2]/button[2]")
        private WebElement resetBinButton;


        /*--------------Actions-------------------*/
        public void inputPackageID(String packageID) {
            myActions.action_sendKeys(selectStatusDropdown, packageID);
        }

        public void selectStatus(String status) {
            myActions.action_select(selectStatusDropdown, status);
        }

        public void clickResetButton() {
            myActions.action_click(resetButton);
        }

        public void clickResetBinButton() {
            myActions.action_click(resetBinButton);
        }


        /*--------------Functions-------------------*/
        public void resetBin(String packageID, String status) {
            inputPackageID(packageID);
            selectStatus(status);
            clickResetBinButton();
        }
    }


    /*--------------Package Details Tab-------------------*/
    public class PackageDetailsTab {
        private WebDriver driver;
        private MyActions myActions;

        public PackageDetailsTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }

        @FindBy(xpath = "//div[@id='PackageDetail']//input[@id='PackageDetailPackageID']")
        private WebElement packageIDEntry;


        /*--------------Actions-------------------*/
        public void enterPackageID(String packageID) {
            myActions.action_sendKeys(packageIDEntry, packageID);
            myActions.action_enter(packageIDEntry);
        }

        @FindBy(xpath = "//div[@id='PackageDetail']//div[9]/button")
        private WebElement printPackageButton;


        /*--------------Functions-------------------*/
        public String getPackageID() {
            String packageIDXpath = "//div[@id='PackageDetail']/div[1]/div[2]/div[1]";
            WebElement packageID = driver.findElement(By.xpath(packageIDXpath));
            String packageIDText[] = myActions.action_getText(packageID).split(" ");
            return packageIDText[1];
        }

        public String getCurrentStatus() {
            String currentStatusXpath = "//div[@id='PackageDetail']/div[1]/div[2]/div[2]";
            WebElement currentStatus = driver.findElement(By.xpath(currentStatusXpath));
            String currentStatusText[] = myActions.action_getText(currentStatus).split(" ");
            return currentStatusText[1];
        }

        public String getSkuCode() {
            String skuCodeXpath = "//div[@id='PackageDetail']/div[1]/div[2]/div[3]";
            WebElement skuCode = driver.findElement(By.xpath(skuCodeXpath));
            String skuCodeText[] = myActions.action_getText(skuCode).split(" ");
            return skuCodeText[1];
        }

        public String getSellerName() {
            String sellerNameXpath = "//div[@id='PackageDetail']/div[1]/div[2]/div[4]";
            WebElement sellerName = driver.findElement(By.xpath(sellerNameXpath));
            String sellerNameText[] = myActions.action_getText(sellerName).split(" ");
            return sellerNameText[1];
        }

        public String getBinCode() {
            String binCodeXpath = "//div[@id='PackageDetail']/div[1]/div[2]/div[5]";
            WebElement binCode = driver.findElement(By.xpath(binCodeXpath));
            String binCodeText[] = myActions.action_getText(binCode).split(" ");
            return binCodeText[1];
        }

        public String getImage() {
            String imageXpath = "//div[@id='PackageDetail']/div[1]/div[2]/div[6]/li/img";
            WebElement image = driver.findElement(By.xpath(imageXpath));
            String src = image.getAttribute("src");
            return src;
        }

        public String getCreatedDate() {
            String createdDateXpath = "//div[@id='PackageDetail']//table/tbody/tr[1]/th[2]";
            WebElement createdDate = driver.findElement(By.xpath(createdDateXpath));
            return myActions.action_getText(createdDate);
        }

        public String getINScanDate() {
            String iNScanDateXpath = "//div[@id='PackageDetail']//table/tbody/tr[2]/th[2]";
            WebElement iNScanDate = driver.findElement(By.xpath(iNScanDateXpath));
            return myActions.action_getText(iNScanDate);
        }

        public String getQCPassedDate() {
            String qCPassedDateXpath = "//div[@id='PackageDetail']//table/tbody/tr[3]/th[2]";
            WebElement qCPassedDate = driver.findElement(By.xpath(qCPassedDateXpath));
            return myActions.action_getText(qCPassedDate);
        }

        public String getAssignedToBinDate() {
            String assignedToBinDateXpath = "//div[@id='PackageDetail']//table/tbody/tr[4]/th[2]";
            WebElement assignedToBinDate = driver.findElement(By.xpath(assignedToBinDateXpath));
            return myActions.action_getText(assignedToBinDate);
        }

        public String getINBinDate() {
            String iNBinDateXpath = "//div[@id='PackageDetail']//table/tbody/tr[5]/th[2]";
            WebElement iNBinDate = driver.findElement(By.xpath(iNBinDateXpath));
            return myActions.action_getText(iNBinDate);
        }

        public void clickPrintPackage() {
            myActions.action_click(printPackageButton);
        }
    }


    /*--------------Bin In Scan Tab-------------------*/
    public class BinInScanTab {
        private WebDriver driver;
        private MyActions myActions;

        public BinInScanTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }

        @FindBy(xpath = "//div[@id='InScan']//input[@id='packageinscanBinCode']")
        private WebElement binCodeEntry;

        @FindBy(xpath = "//div[@id='InScan']//input[@id='inScanPackageId']")
        private WebElement packageIdEntry;

        @FindBy(xpath = "//div[@id='InScan']//div/button[1]")
        private WebElement resetButton;

        @FindBy(xpath = "//div[@id='InScan']//div/button[2]")
        private WebElement inScanButton;


        /*--------------Actions-------------------*/
        public void binCodeInput(String binCode) {
            myActions.action_sendKeys(binCodeEntry, binCode);
        }

        public void packageIdInput(String packageId) {
            myActions.action_sendKeys(packageIdEntry, packageId);
        }

        public void clickResetButton() {
            myActions.action_click(resetButton);
        }

        public void clickInScanButton() {
            myActions.action_click(inScanButton);
        }


        /*--------------Functions-------------------*/
        public void performInScan(String binCode, String packageId) {
            binCodeInput(binCode);
            packageIdInput(packageId);
            clickInScanButton();
        }
    }
}
