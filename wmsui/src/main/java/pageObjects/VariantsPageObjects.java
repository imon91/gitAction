package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.*;

import java.util.*;

public class VariantsPageObjects extends WmsBaseClass {
    private WebDriver driver;
    private MyActions myActions;

    public VariantsPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        myActions = new MyActions();
    }


    /*--------------Actions-------------------*/
    public void clickAddVariantsTab() {
        WebElement addVariantsTab = xpathSetterClick("//a[text()='Add Variant']");
        myActions.action_click(addVariantsTab);
    }

    public void clickBulkUploadTab() {
        WebElement bulkUploadTab = xpathSetterClick("//a[text()='Bulk Upload']");
        myActions.action_click(bulkUploadTab);
    }

    public void clickBinsForSkuTab() {
        WebElement binsForSkuTab = xpathSetterClick("//a[text()='Bins for Sku']");
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
            WebElement skuCodeAddVariantEntry =
                    xpathSetter("//div[@id='AddVariant']//input[@name='sku_code']");
            myActions.action_sendKeys(skuCodeAddVariantEntry, skuCode);
        }

        public void enterDescriptionAddVariant(String description) {
            WebElement descriptionAddVariantEntry =
                    xpathSetter("/div[@id='AddVariant']//input[@name='notes']");
            myActions.action_sendKeys(descriptionAddVariantEntry, description);
        }

        public void enterCategoryDropdownAddVariant(String category) {
            WebElement categoryDropdownAddVariantEntry =
                    xpathSetter("//div[@id='AddVariant']//select[@name='category']");
            myActions.action_select(categoryDropdownAddVariantEntry, category);
        }

        public void enterPriceAddVariant(String price) {
            WebElement priceAddVariantEntry =
                    xpathSetter("//div[@id='AddVariant']//input[@name='variant_price']");
            myActions.action_sendKeys(priceAddVariantEntry, price);
        }

        public void enterReorderPointAddVariant(String reorderPoint) {
            WebElement reorderPointAddVariantEntry =
                    xpathSetter("//div[@id='AddVariant']//input[@name='reorder_point']");
            myActions.action_sendKeys(reorderPointAddVariantEntry, reorderPoint);
        }

        public void checkVoonikCheckBox() {
            WebElement voonikCheckBox =
                    xpathSetter("//div[@id='AddVariant']//input[@name='mappings']");
            myActions.action_click(voonikCheckBox);
        }

        public void clickAddVariantButton() {
            WebElement addVariantButton =
                    xpathSetter("//div[@id='AddVariant']/div/form[@id='addVariantForm']/div/button[1]");
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


        /*--------------Actions-------------------*/
        public void enterSellerDropdownBinsForSku(String seller) {
            WebElement sellerDropdownBinsForSku =
                    xpathSetter("//div[@id='SkuBinList']//select[@id='ManualPickListSellerId']");
            myActions.action_select(sellerDropdownBinsForSku, seller);
        }

        public void enterSkuCodeBinsForSku(String binCode) {
            WebElement skuCodeEntryBinsForSku =
                    xpathSetter("//div[@id='SkuBinList']//input[@id='binDetailSkuData']");
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
}