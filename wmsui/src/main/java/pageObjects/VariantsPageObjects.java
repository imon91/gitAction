package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

import java.util.List;

public class VariantsPageObjects {
    private WebDriver driver;
    private MyActions myActions;

    public VariantsPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        myActions = new MyActions();
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
        myActions.action_click(addVariantsTab);
    }

    public void clickVariantListTab() {
        myActions.action_click(variantListTab);
    }

    public void clickBulkUploadTab() {
        myActions.action_click(bulkUploadTab);
    }

    public void clickBinsForSkuTab() {
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

        @FindBy(xpath = "//input[@name='sku_code']")
        private WebElement skuCodeAddVariantEntry;

        @FindBy(xpath = "//input[@name='notes']")
        private WebElement descriptionAddVariantEntry;

        @FindBy(xpath = "//select[@name='category']")
        private WebElement categoryDropdownAddVariantEntry;

        @FindBy(xpath = "//input[@name='variant_price']")
        private WebElement priceAddVariantEntry;

        @FindBy(xpath = "//input[@name='reorder_point']")
        private WebElement reorderPointAddVariantEntry;

        @FindBy(xpath = "//button[text()='Add Variant']")
        private WebElement addVariantButton;

        @FindBy(xpath = "//input[@name='mappings']")
        private WebElement voonikCheckBox;


        /*--------------Actions-------------------*/
        public void enterSkuCodeAddVariant(String skuCode) {
            myActions.action_sendKeys(skuCodeAddVariantEntry, skuCode);
        }

        public void enterDescriptionAddVariant(String description) {
            myActions.action_sendKeys(descriptionAddVariantEntry, description);
        }
        
        public void enterCategoryDropdownAddVariant(String category) {
            myActions.action_select(categoryDropdownAddVariantEntry, category);
        }

        public void enterPriceAddVariant(String price) {
            myActions.action_sendKeys(priceAddVariantEntry, price);
        }

        public void enterReorderPointAddVariant(String reorderPoint) {
            myActions.action_sendKeys(reorderPointAddVariantEntry, reorderPoint);
        }

        public void checkVoonikCheckBox() {
            myActions.action_click(voonikCheckBox);
        }

        public void clickAddVariantButton() {
            myActions.action_click(addVariantButton);
        }


        /*--------------Functions-------------------*/
        public void addNewVariant(String skuCode, String description, String category, String price, String reorderPoint) {
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

        @FindBy(xpath = "//select[@id='ManualPickListSellerId']")
        private WebElement sellerDropdownBinsForSku;

        @FindBy(xpath = "//input[@id='binDetailSkuData']")
        private WebElement skuCodeEntryBinsForSku;


        /*--------------Actions-------------------*/

        public void enterSellerDropdownBinsForSku(String seller) {
            myActions.action_select(sellerDropdownBinsForSku, seller);
        }

        public void enterSkuCodeBinsForSku(String binCode) {
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
            String quantityXpath = "//div[@id='SkuBinList']//tbody/tr[" + index + "]/td[1]";
            WebElement quantity = driver.findElement(By.xpath(quantityXpath));
            return myActions.action_getText(quantity);
        }

        public String getPackageIds(int index) {
            String packageIdsXpath = "//div[@id='SkuBinList']//tbody/tr[" + index + "]/td[1]";
            WebElement packageIds = driver.findElement(By.xpath(packageIdsXpath));
            return myActions.action_getText(packageIds);
        }
    }
}
