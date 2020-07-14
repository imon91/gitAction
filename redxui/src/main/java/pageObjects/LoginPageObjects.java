package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import utils.MyActions;
import utils.RedXBaseClass;

public class LoginPageObjects extends RedXBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private MyActions myActions;
    private String packageName;

    public LoginPageObjects(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        myActions = new MyActions();
    }

}
