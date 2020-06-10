package MyPageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import MyUtils.MyActions;

public class BottomNavigationObjects {
    private AndroidDriver<WebElement> driver;
    private MyActions myActions;

    public BottomNavigationObjects(AndroidDriver<WebElement> androidDriver){
        this.driver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
    }



    // Bottom-Navigation-Bar HomeIcon
    @FindBy(xpath = "//a[@class='footerLink___2zo0t' and @href='/r']")
    private WebElement bottomBarHomeIcon;

    // Bottom-Navigation-Bar MyShopIcon
    @FindBy(xpath = "//a[@class='footerLink___2zo0t' and @href='/wishlist']")
    private WebElement bottomBarMyShopIcon;

    // Bottom-Navigation-Bar MyOrders
    @FindBy(xpath = "//a[@class='footerLink___2zo0t' and @href='/orders/myorders']")
    private WebElement bottomBarMyOrdersIcon;

    // Bottom-Navigation-Bar PaymentsIcon
    @FindBy(xpath = "//a[@class='footerLink___2zo0t' and @href='/myaccount/income']")
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
