package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.*;

import java.util.*;

public class PackagesPageObjects extends WmsBaseClass {
    private WebDriver driver;
    private MyActions myActions;

    public PackagesPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        myActions = new MyActions();
    }


    /*--------------Actions-------------------*/
    public void clickPackagesListTab() {
        WebElement packagesListTab =
                xpathSetter("//a[contains(text(),'Packages List')]");
        myActions.action_click(packagesListTab);
    }

    public void clickCreatePutawayListTab() {
        WebElement createPutawayListTab =
                xpathSetter("//a[contains(text(),'Create Putaway List')]");
        myActions.action_click(createPutawayListTab);
    }

    public void clickBinInScanTab() {
        WebElement binInScanTab =
                xpathSetter("//a[contains(text(),'Bin In Scan')]");
        myActions.action_click(binInScanTab);
    }

    public void clickBinResetTab() {
        WebElement binResetTab =
                xpathSetter("//a[contains(text(),'Bin Reset')]");
        myActions.action_click(binResetTab);
    }

    public void clickPackageDetailsTab() {
        WebElement packageDetailsTab =
                xpathSetter("//a[contains(text(),'Package Details')]");
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


        /*--------------Actions-------------------*/
        public void selectStatus(String status) {
            WebElement selectStatusDropdown =
                    xpathSetter("//div[@id='PackagesList']//select");
            myActions.action_select(selectStatusDropdown, status);
        }

        public void clickSelectAllButton() {
            WebElement selectAllButton = xpathSetter("//div[@id='PackagesList']//button");
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
            String quantityXpath = "//div[@id='PackagesList']//table/tbody/tr[" + index + "]/td[5]";
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


        /*--------------Actions-------------------*/
        public void inputPackageID(String packageID) {
            WebElement packageIDEntry =
                    xpathSetter("//div[@id='BinReset']//input[@id='binResetPackageId']");
            myActions.action_sendKeys(packageIDEntry, packageID);
        }

        public void selectStatus(String status) {
            WebElement selectStatusDropdown =
                    xpathSetter("//div[@id='BinReset']//select[@id='binResetPackageIdStatus']");
            myActions.action_select(selectStatusDropdown, status);
        }

        public void clickResetButton() {
            WebElement resetButton =
                    xpathSetter("//div[@id='BinReset']//div[2]/button[1]");
            myActions.action_click(resetButton);
        }

        public void clickResetBinButton() {
            WebElement resetBinButton =
                    xpathSetter("//div[@id='BinReset']//div[2]/button[2]");
            myActions.action_click(resetBinButton);
        }


        /*--------------Functions-------------------*/
        public void resetBin(String packageID, String status) {
            inputPackageID(packageID);
            selectStatus(status);
            clickResetBinButton();
        }

        public void resetBinPass(String packageID) {
            inputPackageID(packageID);
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


        /*--------------Actions-------------------*/
        public void enterPackageID(String packageID) {
            WebElement packageIDEntry =
                    xpathSetter("//div[@id='PackageDetail']//input[@id='PackageDetailPackageID']");
            myActions.action_sendKeys(packageIDEntry, packageID);
            myActions.action_enter(packageIDEntry);
        }


        /*--------------Functions-------------------*/
        public String getPackageID() {
            String packageIDXpath = "//div[@id='PackageDetail']/div[1]/div[2]/div[1]";
            WebElement packageID = driver.findElement(By.xpath(packageIDXpath));
            String packageIDText = myActions.action_getText(packageID);
            return packageIDText;
        }

        public String getCurrentStatus() {
            String currentStatusXpath = "//div[@id='PackageDetail']/div[1]/div[2]/div[2]";
            WebElement currentStatus = driver.findElement(By.xpath(currentStatusXpath));
            String currentStatusText = myActions.action_getText(currentStatus);
            return currentStatusText;
        }

        public String getSkuCode() {
            String skuCodeXpath = "//div[@id='PackageDetail']/div[1]/div[2]/div[3]";
            WebElement skuCode = driver.findElement(By.xpath(skuCodeXpath));
            String skuCodeText = myActions.action_getText(skuCode);
            return skuCodeText;
        }

        public String getSellerName() {
            String sellerNameXpath = "//div[@id='PackageDetail']/div[1]/div[2]/div[4]";
            WebElement sellerName = driver.findElement(By.xpath(sellerNameXpath));
            String sellerNameText = myActions.action_getText(sellerName);
            return sellerNameText;
        }

        public String getBinCode() {
            String binCodeXpath = "//div[@id='PackageDetail']/div[1]/div[2]/div[5]";
            WebElement binCode = driver.findElement(By.xpath(binCodeXpath));
            String binCodeText = myActions.action_getText(binCode);
            return binCodeText;
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
            WebElement printPackageButton = xpathSetter("//div[@id='PackageDetail']//div[9]/button");
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


        /*--------------Actions-------------------*/
        public void binCodeInput(String binCode) {
            WebElement binCodeEntry =
                    xpathSetter("//div[@id='InScan']//input[@id='packageinscanBinCode']");
            myActions.action_sendKeys(binCodeEntry, binCode);
        }

        public void packageIdInput(String packageId) {
            WebElement packageIdEntry =
                    xpathSetter("//div[@id='InScan']//input[@id='inScanPackageId']");
            myActions.action_sendKeys(packageIdEntry, packageId);
        }

        public void clickResetButton() {
            WebElement resetButton =
                    xpathSetter("//div[@id='InScan']//div/button[1]");
            myActions.action_click(resetButton);
        }

        public void clickInScanButton() {
            WebElement inScanButton =
                    xpathSetter("//div[@id='InScan']//div/button[2]");
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
