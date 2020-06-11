package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

public class MyOrderPageObjects {
    private AndroidDriver<WebElement> driver;
    private MyActions myActions;

    public MyOrderPageObjects(AndroidDriver<WebElement> androidDriver) {
        this.driver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
        myActions = new MyActions();
    }

//searchOrder
    @FindBy(xpath = "//input[@class='fullWidth___3mngV inputSearch___18p3g']")
    private WebElement searchOrder;

//clickOnSearchIcon
    @FindBy(xpath = "//*[@id=\"myorderSearch\"]/div/svg")
    private WebElement searchIcon;

//sortTab
    @FindBy(xpath = "//div[@class='ripple___K-6Hk sort____ctuP']")
    private WebElement sortTab;

//recentOrders
    @FindBy(xpath = "//input[@id='recent_orders']")
    private WebElement recentOrders;

//oldOrders
   @FindBy(xpath = "//input[@id='old_orders']")
   private WebElement oldOrders;

//status
    @FindBy(xpath = "//input[@id='status']")
    private WebElement status;

//apply
    @FindBy(xpath = "//button[@class='flat___n-myg primary___OLr69 button___3btga ripple___1U_Uk contain___ux0BW']")
    private WebElement apply;

//cancel
    @FindBy(xpath = "//button[@class='flat___n-myg flatSecondary___8V87I button___3btga ripple___1U_Uk contain___ux0BW']")
    private WebElement cancel;

//closeSortBy
    @FindBy(xpath = "//div[@class='close___3yvOX']")
    private WebElement close;

//filterTab
    @FindBy(xpath = "//div[@class='ripple___K-6Hk filter___19NYL']")
    private WebElement filterTab;

//byDate
    @FindBy(xpath = "/input[@id='date']")
    private WebElement byDate;

//fromDate
    @FindBy(xpath = "//input[@id='from_date']")
    private WebElement fromDate;

//toDate
    @FindBy(xpath = "//input[@id='to_date']")
    private WebElement toDate;

//byStatus
    @FindBy(xpath = "//input[@id='status']")
    private WebElement byStatus;

//confirmed
    @FindBy(xpath = "//input[@id='confirmed']")
    private WebElement confirmed;

//inProcess
    @FindBy(xpath = "//input[@id='in_process']")
    private WebElement inProcess;

//inTransit
    @FindBy(xpath = "//input[@id='in_transit']")
    private WebElement inTransit;

//delivered
    @FindBy(xpath = "//input[@id='delivered']")
    private WebElement delivered;

//cancelled
    @FindBy(xpath = "//input[@id='cancelled']")
    private WebElement cancelled;


/*---------Actions--------*/

public void clickOnSearchOrder(){myActions.action_click(searchOrder);}

public void clickOnSearchIcon(){myActions.action_click(searchIcon);}

public void clickOnSortTab(){myActions.action_click(sortTab);}

public void clickOnRecentOrders(){myActions.action_click(recentOrders);}

public void clickOnOldOrders(){myActions.action_click(oldOrders);}

public void clickOnStatus(){myActions.action_click(status);}

public void clickOnApply(){myActions.action_click(apply);}

public void clickOnCancel(){myActions.action_click(cancel);}

public void clickOnClose(){myActions.action_click(close);}

public void clickOnFilterTab(){myActions.action_click(filterTab);}

public void clickOnByDate(){myActions.action_click(byDate);}

public void clickOnFromDate(){myActions.action_click(fromDate);}

public void clickOnToDate(){myActions.action_click(toDate);}

public void clickOnByStatus(){myActions.action_click(byStatus);}

public void clickOnConfirmed(){myActions.action_click(confirmed);}

public void clickOnInProcess(){myActions.action_click(inProcess);}

public void clickOnInTransit(){myActions.action_click(inTransit);}

public void clickOnDelivered(){myActions.action_click(delivered);}

public void clickOnCancelled(){myActions.action_click(cancelled);}


/*---------Functions*---------/

 */


















}
