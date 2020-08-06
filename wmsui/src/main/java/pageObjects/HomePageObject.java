package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MyActions;
import utils.WmsBaseClass;

public class HomePageObject extends WmsBaseClass {

    private WebDriver driver;
    private MyActions myActions;
    private WebDriverWait wait;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        myActions = new MyActions();
        wait = new WebDriverWait(driver,10);
    }

    //Warehouses
    @FindBy(xpath = "//div[@class='left-sidebar-main']/ul[1]/li[1]/a")
    private WebElement warehouseModule;

    //Suppliers
    @FindBy(xpath = "//div[@class='left-sidebar-main']/ul[1]/li[2]/a")
    private WebElement suppliersModule;

    //Variants
    @FindBy(xpath = "//div[@class='left-sidebar-main']/ul[1]/li[3]/a")
    private WebElement variantsModule;

    //Purchase Orders
    @FindBy(xpath = "//div[@class='left-sidebar-main']/ul[1]/li[4]/a")
    private WebElement purchaseOrdersModule;

    //Packages
    @FindBy(xpath = "//div[@class='left-sidebar-main']/ul[1]/li[5]/a")
    private WebElement packagesModule;

    //Pick Orders
    @FindBy(xpath = "//div[@class='left-sidebar-main']/ul[1]/li[6]/a")
    private WebElement pickOrdersModule;

    //Order Process
    @FindBy(xpath = "//div[@class='left-sidebar-main']/ul[1]/li[7]/a")
    private WebElement orderProcessModule;

    //Returns
    @FindBy(xpath = "//div[@class='left-sidebar-main']/ul[1]/li[8]/a")
    private WebElement returnsModule;

    //Logout
    @FindBy(xpath = "//div[@id='root']//h3//a[text()='Log out']")
    private WebElement logoutButton;

    //Warehouse Select
    @FindBy(xpath = "//div[@id='root']//form//select")
    private WebElement selectWarehouseDropDown;


    /*--------------Actions-------------------*/
    public void clickWarehouses() {
        wait.until(ExpectedConditions.elementToBeClickable(warehouseModule));
        myActions.action_click(warehouseModule);
    }

    public void clickSuppliers() {
        wait.until(ExpectedConditions.elementToBeClickable(suppliersModule));
        myActions.action_click(suppliersModule);
    }

    public void clickVariants() {
        wait.until(ExpectedConditions.elementToBeClickable(variantsModule));
        myActions.action_click(variantsModule);
    }

    public void clickPurchaseOrders() {
        wait.until(ExpectedConditions.elementToBeClickable(purchaseOrdersModule));
        myActions.action_click(purchaseOrdersModule);
    }

    public void clickPackages() {
        wait.until(ExpectedConditions.elementToBeClickable(packagesModule));
        myActions.action_click(packagesModule);
    }

    public void clickPickOrders() {
        wait.until(ExpectedConditions.elementToBeClickable(pickOrdersModule));
        myActions.action_click(pickOrdersModule);
    }

    public void clickOrderProcess() {
        wait.until(ExpectedConditions.elementToBeClickable(orderProcessModule));
        myActions.action_click(orderProcessModule);
    }

    public void clickReturns() {
        wait.until(ExpectedConditions.elementToBeClickable(returnsModule));
        myActions.action_click(returnsModule);
    }

    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        myActions.action_click(logoutButton);
    }

    public String getPopUpMessage(){
        String popUpMessage = "//div[@id='toastbar-text']";
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(popUpMessage))));
        WebElement popUpMessageElement = driver.findElement(By.xpath(popUpMessage));
        return myActions.action_getText(popUpMessageElement);
    }

    public void selectWarehouse(String warehouse) {
        wait.until(ExpectedConditions.visibilityOf(selectWarehouseDropDown));
        myActions.action_select(selectWarehouseDropDown,warehouse);
    }

    public void popUpInvisibility(){
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElement(By.xpath("//div[@id='toastbar-text']"))));
    }
}
