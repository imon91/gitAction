package pageObjects;

import utils.MyActions;
import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {

    private AndroidDriver<AndroidElement> androidDriver;
    private MyActions myActions;

    public HomePageObjects(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
    }


    /*------------------- List of HomePage Items And Their Functions--------------------------*/



}
