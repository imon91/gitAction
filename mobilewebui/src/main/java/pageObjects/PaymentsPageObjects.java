package pageObjects;

import MyUtils.MyActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentsPageObjects {
    private AndroidDriver<WebElement> driver;
    private MyActions myActions;

    public PaymentsPageObjects(AndroidDriver<WebElement> androidDriver) {
        this.driver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        myActions = new MyActions();
    }

    //Earnings
    @FindBy(xpath = "//button[@class='showHistory___1QWNR showHistoryOutter___3dnaZ']")
    private WebElement Earnings;

    //backFromEarnings
    @FindBy(xpath = "//button[@class='icon___19nzf primary___OLr69 button___3btga ripple___1U_Uk']")
    private WebElement BackFromEarnings;

    //NextPayoutDue
    @FindBy(xpath = "//p[@class='primary___3k9Ts weight-4___ZQvdQ text-16___-Np8V bold___3nNae text-flat___3AZ-6']")
    private WebElement NextPayoutDue;

    //deliveredOrders
    @FindBy(xpath = "//span[contains(text(),'Delivered Orders')]")
    private WebElement DeliveredOrders;

    //LostOrders
    @FindBy(xpath = "/span[contains(text(),'Lost Orders')]")
    private WebElement LostOrders;

    //RTOs
    @FindBy(xpath = "//span[contains(text(),'RTOs')]")
    private WebElement RTOs;

    //ReturnedOrders
    @FindBy(xpath = "//span[contains(text(),'Returned Orders')]")
    private WebElement ReturnedOrders;

    //CancelledOrders
    @FindBy(xpath = "//span[contains(text(),'Cancelled Orders')]")
    private WebElement CancelledOrders;

    //Bonus
    @FindBy(xpath = "//span[contains(text(),'Bonus')]")
    private WebElement Bonus;

    //Adjustments
    @FindBy(xpath = "//span[contains(text(),'Adjustments')]")
    private WebElement Adjustments;

 /*-----------Actions------------*/

public void clickOnEarnings(){myActions.action_click(Earnings);}

    public void clickOnbackFromEarnings(){myActions.action_click(BackFromEarnings);}

    public void clickOnNextPayoutDue(){myActions.action_click(NextPayoutDue);}

    public void clickOnDeliveredObjects(){myActions.action_click(DeliveredOrders);}

    public void clickOnLostOrders(){myActions.action_click(LostOrders);}

    public void clickOnRTOs(){myActions.action_click(RTOs);}

    public void clickOnReturnedOrders(){myActions.action_click(ReturnedOrders);}

    public void clickOnCancelledOrders(){myActions.action_click(CancelledOrders);}

    public void clickOnBonus(){myActions.action_click(Bonus);}

    public void clickOnAdjustments(){myActions.action_click(Adjustments);}

}
