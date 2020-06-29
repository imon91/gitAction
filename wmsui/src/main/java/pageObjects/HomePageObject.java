package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;
import utils.WmsBaseClass;

public class HomePageObject extends WmsBaseClass {

    private WebDriver driver;
    private MyActions myActions;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        myActions = new MyActions();
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


    /*--------------Actions-------------------*/
    public void clickWarehouses() {
        myActions.action_click(warehouseModule);
    }

    public void clickSuppliers() {
        myActions.action_click(suppliersModule);
    }

    public void clickVariants() {
        myActions.action_click(variantsModule);
    }

    public void clickPurchaseOrders() {
        myActions.action_click(purchaseOrdersModule);
    }

    public void clickPackages() {
        myActions.action_click(packagesModule);
    }

    public void clickPickOrders() {
        myActions.action_click(pickOrdersModule);
    }

    public void clickOrderProcess() {
        myActions.action_click(orderProcessModule);
    }

    public void clickReturns() {
        myActions.action_click(returnsModule);
    }

    public void clickLogout() {
        sleep(2000);
        myActions.action_click(logoutButton);
        sleep(5000);
    }

    public String getPopUpMessage(){
        sleep(1000);
        String popUpMessage = "//div[@id='toastbar-text']";
        WebElement popUpMessageElement = driver.findElement(By.xpath(popUpMessage));
        return myActions.action_getText(popUpMessageElement);
    }
}
