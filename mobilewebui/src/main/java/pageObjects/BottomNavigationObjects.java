package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

public class BottomNavigationObjects {
    private AndroidDriver<WebElement> driver;
    private MyActions myActions;

    public BottomNavigationObjects(AndroidDriver<WebElement> androidDriver){
        this.driver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
    }



    // Bottom-Navigation-Bar HomeIcon
    @FindBy(css = "#content > div > div:nth-child(4) > div:nth-child(1) > div.bottomHeader___GLrO8 > div > a:nth-child(1)")
    private WebElement bottomBarHomeIcon;

    // Bottom-Navigation-Bar MyShopIcon
    @FindBy(css = "#content > div > div:nth-child(4) > div:nth-child(1) > div.bottomHeader___GLrO8 > div > a:nth-child(2)")
    private WebElement bottomBarMyShopIcon;

    // Bottom-Navigation-Bar MyOrders
    @FindBy(css = "#content > div > div:nth-child(4) > div:nth-child(1) > div.bottomHeader___GLrO8 > div > a:nth-child(3)")
    private WebElement bottomBarMyOrdersIcon;

    // Bottom-Navigation-Bar PaymentsIcon
    @FindBy(css = "#content > div > div:nth-child(4) > div:nth-child(1) > div.bottomHeader___GLrO8 > div > a:nth-child(4)")
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
