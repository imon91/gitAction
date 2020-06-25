package Appflow;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebDriver;
import sun.jvm.hotspot.debugger.cdbg.BaseClass;
import sun.jvm.hotspot.debugger.cdbg.Type;

public class AppFlow extends BaseClass  {

    private AndroidDriver<AndroidElement> androidDriver;
    private WebDriver webDriver;
    private DriverControls driverControls;
    private LoginPageObjects loginPageObjects;
    private BottomNavigationObjects bottomNavigationObjects;
    private ActionBarObjects actionBarObjects;
    private RightNavigationDrawer rightNavigationDrawer;
    private MyShopPageObjects myShopPageObjects;

    public void applaunch() throws Exception
    {
    startService();
        androidDriver = getDriver();

    }

}

