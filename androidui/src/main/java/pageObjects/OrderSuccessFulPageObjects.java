package pageObjects;

import coreUtils.CoreConstants;
import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.*;

public class OrderSuccessFulPageObjects extends AndroidBaseClass{


    private final AndroidDriver<WebElement> androidDriver;
    private final MyActions myActions;
    private final String myPackage;

    public OrderSuccessFulPageObjects(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        switchFromNativeToWeb(CoreConstants.SHOP_UP_RESELLER_WEB_VIEW);
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
        myPackage = getAppPackage();
    }


    @FindBy(xpath = "//span[contains(text(),'Click Here')]")
    private WebElement clickHereButton;


    public void clickOnClickHereButton(){
        myActions.action_click(clickHereButton);
    }

}
