import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.BeforeSuite;
import pageObjects.ActionBarObjects;
import pageObjects.LoginPageObjects;
import utils.BaseClass;
import utils.DriverControls;
import utils.MyActions;

public class AppOrderFlow extends BaseClass
{
    private AndroidDriver<AndroidElement> driver;
    private  LoginPageObjects loginPageObjects;
    private DriverControls driverControls;
    private ActionBarObjects actionBarObjects;
    private MyActions myActions;
    private ActionBarObjects actionbar;


        public void Authendication () throws Exception
        {
            startService();
            driver = getDriver();
            driverControls = new DriverControls(driver);
            loginPageObjects.performAuthentication("1877755590", "666666");
            actionbar.clickOnSearchImageButton();
            AndroidElement searchbar = driver.findElementById("com.shopup.reseller:id/etSearch");
            myActions.action_sendKeys(searchbar,"mobile cases");


        }
}