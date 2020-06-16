package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

public class HomePageObject {

    private WebDriver driver;
    private MyActions myActions;

    public HomePageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        myActions = new MyActions();
    }

    //Warehouses
    @FindBy(xpath = "//a[text()='Warehouses']")
    private WebElement warehouseModule;

    //Suppliers
    @FindBy (xpath = "//a[text()='Suppliers']")
    private WebElement suppliersModule;

    //Variants
    @FindBy (xpath = "//a[text()='Variants']")
    private WebElement variantsModule;

    //Purchase Orders
    @FindBy (xpath = "//a[text()='Purchase Orders']")
    private WebElement purchaseOrdersModule;

    //Packages
    @FindBy (xpath = "//a[text()='Packages']")
    private WebElement packagesModule;

    //Order Process
    @FindBy (xpath = "//a[text()='Order Process']")
    private WebElement orderProcessModule;

    //Returns
    @FindBy (xpath = "//a[text()='Returns']")
    private WebElement returnsModule;

    //Logout
    @FindBy (xpath = "//a[text()='Log out']")
    private WebElement logoutButton;



    /*--------------Actions-------------------*/
    public void clickWarehouses(){myActions.action_click(warehouseModule);}

    public void clickSuppliers(){myActions.action_click(suppliersModule);}

    public void clickVariants(){myActions.action_click(variantsModule);}

    public void clickPurchaseOrders(){myActions.action_click(purchaseOrdersModule);}

    public void clickPackages(){myActions.action_click(packagesModule);}

    public void clickOrderProcess(){myActions.action_click(orderProcessModule);}

    public void clickReturns(){myActions.action_click(returnsModule);}

    public void clickLogout(){myActions.action_click(logoutButton);}
}
