package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;
import utils.WmsBaseClass;

public class PickOrdersPageObjects extends WmsBaseClass {
    private WebDriver driver;
    private MyActions myActions;

    public PickOrdersPageObjects(WebDriver driver) {
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

    @FindBy(xpath = "//div[@id='NewPickList']//button[@type='submit']")
    private WebElement createPickListButton;

    @FindBy(xpath = "//div[@id='NewPickList']/div/form[@id='createManualPickListForm']/div/button[1]")
    private WebElement addSkuInputFields;

    public void clickAddSkuInputFields() {
        myActions.action_click(addSkuInputFields);
    }

    public void clickCreatePickListButton(){myActions.action_click(createPickListButton);}

    public void selectWarehouse(String warehouse) { myActions.action_select(selectWarehouseIdDropdown, warehouse);}

    public void selectSeller(String seller) {
        myActions.action_select(selectSellerIdDropdown, seller);
    }

    public void selectPickupAgent(String pickup_agent){ myActions.action_sendKeys(selectPickupAgentIdDropdown,pickup_agent); }

    public void selectType(String picklist_type){myActions.action_select(selectTypeIdDropdown,picklist_type);}

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

    public void enterWarehouseDetails(String warehouse, String seller, String pickup_agent, String picklist_type) {
        selectWarehouse(warehouse);
        selectSeller(seller);
        selectPickupAgent(pickup_agent);
        selectType(picklist_type);
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
        clickCreatePickListButton();
    }
}
