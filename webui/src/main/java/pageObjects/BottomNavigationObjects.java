package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

public class BottomNavigationObjects {

    private WebDriver driver;
    private MyActions myActions;

    public BottomNavigationObjects(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        myActions = new MyActions();
    }



    // Bottom-Navigation-Bar HomeIcon
    @FindBy(id = "com.shopup.reseller:id/homeBottomBar")
    private WebElement bottomBarHomeIcon;

    // Bottom-Navigation-Bar MyShopIcon
    @FindBy(id = "com.shopup.reseller:id/myShopBottomBar")
    private WebElement bottomBarMyShopIcon;

    // Bottom-Navigation-Bar MyOrders
    @FindBy(id = "com.shopup.reseller:id/myOrderBottomBar")
    private WebElement bottomBarMyOrdersIcon;

    // Bottom-Navigation-Bar PaymentsIcon
    @FindBy(id = "com.shopup.reseller:id/myIncomeBottomBar")
    private WebElement bottomBarPaymentsIcon;



    public void clickOnBottomBarHomeIcon(){
        myActions.action_click(bottomBarHomeIcon);
    }

    public void clickOnBottomBarMyShopIcon(){
        myActions.action_click(bottomBarMyShopIcon);
    }

    public void clickOnBottomBarMyOrdersIcon(){
        myActions.action_click(bottomBarMyOrdersIcon);
    }

    public void clickOnBottomBarPaymentsIcon(){
        myActions.action_click(bottomBarPaymentsIcon);
    }

}
