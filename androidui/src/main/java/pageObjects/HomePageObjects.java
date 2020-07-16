package pageObjects;

import org.openqa.selenium.*;
import utils.*;
import io.appium.java_client.android.*;

public class HomePageObjects extends AndroidBaseClass {

    private final AndroidDriver<WebElement> androidDriver;
    private final MyActions myActions;

    public HomePageObjects(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        myActions = new MyActions();
    }


    /*------------------- List of HomePage Items And Their Functions--------------------------*/



}
