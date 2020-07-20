package pageObjects;

import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import utils.*;

public class ToolBarObjects extends AndroidBaseClass{

    private final AndroidDriver<WebElement> androidDriver;
    private final MyActions myActions;
    private final String packageName;

    public ToolBarObjects(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
        packageName = getAppPackage();
    }

    // Tool Bar Parent
    private WebElement toolBar;

    // Back Button
    private WebElement toolBarBackButton;

    // Back Button
    @AndroidFindBy(className = "android.widget.TextView")
    private WebElement toolBarPageName;


    public void navigateBack(){
        toolBarBackButton = xpathSetter("//android.widget.ImageButton[@content-desc='Navigate up']");
        myActions.action_click(toolBarBackButton);
    }

    public String getPageName(){
        return myActions.action_getText(toolBarPageName);
    }

}
