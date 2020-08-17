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

    /*--------------Actions-------------------*/
    public void clickWarehouses() {
        WebElement warehouseModule = xpathSetterClick("//a[contains(text(),'Warehouses')]");
        myActions.action_click(warehouseModule);
    }

    public void clickSuppliers() {
        WebElement suppliersModule = xpathSetterClick("//a[contains(text(),'Suppliers')]");
        myActions.action_click(suppliersModule);
    }

    public void clickVariants() {
        WebElement variantsModule = xpathSetterClick("//a[contains(text(),'Variants')]");
        myActions.action_click(variantsModule);
    }

    public void clickPurchaseOrders() {
        WebElement purchaseOrdersModule = xpathSetterClick("//a[contains(text(),'Purchase Orders')]");
        myActions.action_click(purchaseOrdersModule);
    }

    public void clickPackages() {
        WebElement packagesModule = xpathSetterClick("//a[contains(text(),'Packages')]");
        myActions.action_click(packagesModule);
    }

    public void clickPickOrders() {
        WebElement pickOrdersModule = xpathSetterClick("//a[contains(text(),'Pick Orders')]");
        myActions.action_click(pickOrdersModule);
    }

    public void clickOrderProcess() {
        WebElement orderProcessModule = xpathSetterClick("//a[contains(text(),'Order Process')]");
        myActions.action_click(orderProcessModule);
    }

    public void clickReturns() {
        WebElement returnsModule = xpathSetterClick("//a[contains(text(),'Returns')]");
        myActions.action_click(returnsModule);
    }

    public void clickLogout() {
        WebElement logoutButton = xpathSetterClick("//div[@id='root']//h3//a[text()='Log out']");
        myActions.action_click(logoutButton);
    }

    public String getPopUpMessage(){
        String popUpMessage = "//div[@id='toastbar-text']";
        WebElement popUpMessageElement = xpathSetter(popUpMessage);
        return myActions.action_getText(popUpMessageElement);
    }

    public void selectWarehouse(String warehouse) {
        WebElement selectWarehouseDropDown = xpathSetter("//div[@id='root']//form//select");
        myActions.action_select(selectWarehouseDropDown,warehouse);
    }

    public void popUpInvisibility(){
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElement(By.xpath("//div[@id='toastbar-text']"))));
    }
}




