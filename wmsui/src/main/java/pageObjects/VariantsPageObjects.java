package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MyActions;

import java.util.List;

public class VariantsPageObjects {
    private WebDriver driver;
    private MyActions myActions;
    private WebDriverWait wait;

    public VariantsPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        myActions = new MyActions();
        wait = new WebDriverWait(driver,10);
    }

    @FindBy(xpath = "//a[text()='Add Variant']")
    private WebElement addVariantsTab;

    @FindBy(xpath = "//a[text()='Variant List']")
    private WebElement variantListTab;

    @FindBy(xpath = "//a[text()='Bulk Upload']")
    private WebElement bulkUploadTab;

    @FindBy(xpath = "//a[text()='Bins for Sku']")
    private WebElement binsForSkuTab;


    /*--------------Actions-------------------*/
    public void clickAddVariantsTab() {
        wait.until(ExpectedConditions.visibilityOf(addVariantsTab));
        myActions.action_click(addVariantsTab);
    }

    public void clickVariantListTab() {
        wait.until(ExpectedConditions.visibilityOf(variantListTab));
        myActions.action_click(variantListTab);
    }

    public void clickBulkUploadTab() {
        wait.until(ExpectedConditions.visibilityOf(bulkUploadTab));
        myActions.action_click(bulkUploadTab);
    }

    public void clickBinsForSkuTab() {
        wait.until(ExpectedConditions.visibilityOf(binsForSkuTab));
        myActions.action_click(binsForSkuTab);
    }


    /*--------------Add Variant Tab-------------------*/
    public class AddVariantTab {
        private WebDriver driver;
        private MyActions myActions;

        public AddVariantTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }

        @FindBy(xpath = "//div[@id='AddVariant']//input[@name='sku_code']")
        private WebElement skuCodeAddVariantEntry;

        @FindBy(xpath = "//div[@id='AddVariant']//input[@name='notes']")
        private WebElement descriptionAddVariantEntry;

        @FindBy(xpath = "//div[@id='AddVariant']//select[@name='category']")
        private WebElement categoryDropdownAddVariantEntry;

        @FindBy(xpath = "//div[@id='AddVariant']//input[@name='variant_price']")
        private WebElement priceAddVariantEntry;

        @FindBy(xpath = "//div[@id='AddVariant']//input[@name='reorder_point']")
        private WebElement reorderPointAddVariantEntry;

        @FindBy(xpath = "//div[@id='AddVariant']/div/form[@id='addVariantForm']/div/button[1]")
        private WebElement addVariantButton;

        @FindBy(xpath = "//div[@id='AddVariant']//input[@name='mappings']")
        private WebElement voonikCheckBox;

        @FindBy(xpath = "//div[@id='AddVariant']//input[@name='uvid']")
        private WebElement mpVIDEntry;

        @FindBy(xpath = "//div[@id='AddVariant']//input[@name='product_id']")
        private WebElement mpPIDEntry;

        @FindBy(xpath = "//div[@id='AddVariant']//input[@name='sku']")
        private WebElement mpSKUEntry;

        @FindBy(xpath = "//div[@id='AddVariant']//div[4]/button")
        private WebElement fetchVIDButton;

        @FindBy(xpath = "//div[@id='AddVariant']//div[1]/div[5]/button")
        private WebElement fetchPIDSKUButton;


        /*--------------Actions-------------------*/
        public void enterSkuCodeAddVariant(String skuCode) {
            wait.until(ExpectedConditions.visibilityOf(skuCodeAddVariantEntry));
            myActions.action_sendKeys(skuCodeAddVariantEntry, skuCode);
        }

        public void enterDescriptionAddVariant(String description) {
            wait.until(ExpectedConditions.visibilityOf(descriptionAddVariantEntry));
            myActions.action_sendKeys(descriptionAddVariantEntry, description);
        }

        public void enterCategoryDropdownAddVariant(String category) {
            wait.until(ExpectedConditions.visibilityOf(categoryDropdownAddVariantEntry));
            myActions.action_select(categoryDropdownAddVariantEntry, category);
        }

        public void enterPriceAddVariant(String price) {
            wait.until(ExpectedConditions.visibilityOf(priceAddVariantEntry));
            myActions.action_sendKeys(priceAddVariantEntry, price);
        }

        public void enterReorderPointAddVariant(String reorderPoint) {
            wait.until(ExpectedConditions.visibilityOf(reorderPointAddVariantEntry));
            myActions.action_sendKeys(reorderPointAddVariantEntry, reorderPoint);
        }

        public void checkVoonikCheckBox() {
            myActions.action_click(voonikCheckBox);
        }

        public void clickAddVariantButton() {
            wait.until(ExpectedConditions.visibilityOf(addVariantButton));
            myActions.action_click(addVariantButton);
        }

        public void enterMPVID(String mp_vid){myActions.action_sendKeys(mpVIDEntry,mp_vid);}

        public void enterMPPID(String mp_pid){myActions.action_sendKeys(mpPIDEntry,mp_pid);}

        public void enterMPSKU(String mp_sku){myActions.action_sendKeys(mpSKUEntry,mp_sku);}

        public void clickFetchVIDButton(){myActions.action_click(fetchVIDButton);}

        public void clickFetchPIDSKUButton(){myActions.action_click(fetchPIDSKUButton);}

        /*--------------Functions-------------------*/
        public void addNewVariantVoonik(String skuCode, String description, String category, String price, String reorderPoint,
                                  String mp_vid, String mp_pid, String mp_sku) {
            enterSkuCodeAddVariant(skuCode);
            enterDescriptionAddVariant(description);
            enterCategoryDropdownAddVariant(category);
            enterPriceAddVariant(price);
            enterReorderPointAddVariant(reorderPoint);
            checkVoonikCheckBox();
            enterMPVID(mp_vid);
            enterMPPID(mp_pid);
            enterMPSKU(mp_sku);
            clickAddVariantButton();

        }

        public void addNewVariantNonVOONIK(String skuCode, String description, String category, String price, String reorderPoint){
            enterSkuCodeAddVariant(skuCode);
            enterDescriptionAddVariant(description);
            enterCategoryDropdownAddVariant(category);
            enterPriceAddVariant(price);
            enterReorderPointAddVariant(reorderPoint);
            clickAddVariantButton();
        }

    }


    /*--------------Bins For Sku Tab-------------------*/
    public class BinsForSkuTab {
        private WebDriver driver;
        private MyActions myActions;

        public BinsForSkuTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }

        @FindBy(xpath = "//div[@id='SkuBinList']//select[@id='ManualPickListSellerId']")
        private WebElement sellerDropdownBinsForSku;

        @FindBy(xpath = "//div[@id='SkuBinList']//input[@id='binDetailSkuData']")
        private WebElement skuCodeEntryBinsForSku;


        /*--------------Actions-------------------*/
        public void enterSellerDropdownBinsForSku(String seller) {
            wait.until(ExpectedConditions.visibilityOf(sellerDropdownBinsForSku));
            myActions.action_select(sellerDropdownBinsForSku, seller);
        }

        public void enterSkuCodeBinsForSku(String binCode) {
            wait.until(ExpectedConditions.visibilityOf(skuCodeEntryBinsForSku));
            myActions.action_sendKeys(skuCodeEntryBinsForSku, binCode);
            myActions.action_enter(skuCodeEntryBinsForSku);
        }


        /*--------------Functions-------------------*/
        public void checkVariantBins(String skuCode, String binCode) {
            enterSellerDropdownBinsForSku(skuCode);
            enterSkuCodeBinsForSku(binCode);
        }

        public int getTotalBins() {
            List<WebElement> bins = driver.findElements(By.xpath("//div[@id='SkuBinList']//tbody/tr"));
            return bins.size();
        }

        public String getBinCode(int index) {
            String binCodeXpath = "//div[@id='SkuBinList']//tbody/tr[" + index + "]/td[1]";
            WebElement binCode = driver.findElement(By.xpath(binCodeXpath));
            return myActions.action_getText(binCode);
        }

        public String getQuantity(int index) {
            String quantityXpath = "//div[@id='SkuBinList']//tbody/tr[" + index + "]/td[2]";
            WebElement quantity = driver.findElement(By.xpath(quantityXpath));
            return myActions.action_getText(quantity);
        }

        public String getPackageIds(int index) {
            String packageIdsXpath = "//div[@id='SkuBinList']//tbody/tr[" + index + "]/td[3]";
            WebElement packageIds = driver.findElement(By.xpath(packageIdsXpath));
            return myActions.action_getText(packageIds);
        }
    }


    /*--------------Variant List Tab-------------------*/
    public class VariantListTab{
        private WebDriver driver;
        private MyActions myActions;

        public VariantListTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }

        public int getTotalProducts(){
            List<WebElement> products = driver.findElements(By.xpath("//div[@class='variant-details-tabs']//thead/following-sibling::tbody/tr"));
            return products.size();
        }

        public String getVariantId(int index) {
            String variantIdXpath = "//div[@class='variant-details-tabs']//thead/following-sibling::tbody/tr[" + index + "]/td[1]";
            WebElement variantId = driver.findElement(By.xpath(variantIdXpath));
            return myActions.action_getText(variantId);
        }

        public String getSellerName(int index) {
            String sellerNameXpath = "//div[@class='variant-details-tabs']//thead/following-sibling::tbody/tr[" + index + "]/td[2]";
            WebElement sellerName = driver.findElement(By.xpath(sellerNameXpath));
            return myActions.action_getText(sellerName);
        }
        public String getSkuCode(int index) {
            String skuCodeXpath = "//div[@class='variant-details-tabs']//thead/following-sibling::tbody/tr[" + index + "]/td[3]";
            WebElement skuCode = driver.findElement(By.xpath(skuCodeXpath));
            return myActions.action_getText(skuCode);
        }

        public String getDescription(int index) {
            String descriptionXpath = "//div[@class='variant-details-tabs']//thead/following-sibling::tbody/tr[" + index + "]/td[4]";
            WebElement description = driver.findElement(By.xpath(descriptionXpath));
            return myActions.action_getText(description);
        }

        public String getCategory(int index) {
            String categoryXpath = "//div[@class='variant-details-tabs']//thead/following-sibling::tbody/tr[" + index + "]/td[5]";
            WebElement category = driver.findElement(By.xpath(categoryXpath));
            return myActions.action_getText(category);
        }

        public String getPrice(int index) {
            String priceXpath = "//div[@class='variant-details-tabs']//thead/following-sibling::tbody/tr[" + index + "]/td[6]";
            WebElement price = driver.findElement(By.xpath(priceXpath));
            return myActions.action_getText(price);
        }

        public String getReorderPoint(int index) {
            String reorderPointXpath = "//div[@class='variant-details-tabs']//thead/following-sibling::tbody/tr[" + index + "]/td[7]";
            WebElement reorderPoint = driver.findElement(By.xpath(reorderPointXpath));
            return myActions.action_getText(reorderPoint);
        }

        public String getMarketPlace(int index) {
            String marketPlaceXpath = "//div[@class='variant-details-tabs']//table/tbody/tr[" + index + "]/td[8]/table/tbody/tr/td";
            WebElement marketPlace = driver.findElement(By.xpath(marketPlaceXpath));
            return myActions.action_getText(marketPlace);
        }

        public String getMPVariantId(int index) {
            String mPVariantIdXpath = "//div[@class='variant-details-tabs']//table/tbody/tr[" + index + "]/td[9]/table/tbody/tr/td";
            WebElement mPVariantId = driver.findElement(By.xpath(mPVariantIdXpath));
            return myActions.action_getText(mPVariantId);
        }
    }

}
