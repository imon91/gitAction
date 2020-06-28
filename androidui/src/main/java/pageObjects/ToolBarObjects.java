package pageObjects;

import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.support.*;
import utils.*;

public class ToolBarObjects {

    private AndroidDriver<AndroidElement> androidDriver;
    private MyActions myActions;

    public ToolBarObjects(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
    }

    // Tool Bar Parent
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.shopup.reseller:id/toolbar']")
    private AndroidElement toolBar;

    // Back Button
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private AndroidElement toolBarBackButton;

    // Back Button
    @AndroidFindBy(className = "android.widget.TextView")
    private AndroidElement toolBarPageName;


    public void navigateBack(){
        myActions.action_click(toolBarBackButton);
    }

    public String getPageName(){
        return myActions.action_getText(toolBarPageName);
    }

}
