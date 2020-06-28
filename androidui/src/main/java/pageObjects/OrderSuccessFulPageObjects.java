package pageObjects;

import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.AndroidBaseClass;
import utils.MyActions;

public class OrderSuccessFulPageObjects {


    private AndroidDriver<AndroidElement> androidDriver;
    private MyActions myActions;
    private String myPackage;

    public OrderSuccessFulPageObjects(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
        myPackage = AndroidBaseClass.getAppPackage();
    }


    @FindBy(xpath = "//span[contains(text(),'Click Here')]")
    private WebElement clickHereButton;


    public void clickOnClickHereButton(){
        myActions.action_click(clickHereButton);
    }

}
