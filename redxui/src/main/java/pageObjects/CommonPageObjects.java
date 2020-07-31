package pageObjects;

import org.openqa.selenium.WebElement;
import utils.*;

public class CommonPageObjects extends RedXBaseClass
{
    private MyActions myActions;

    public CommonPageObjects()
    {
        myActions = new MyActions();
    }

    /*----------Elements----------*/

    private WebElement backButton;
    private WebElement pageTitle;

    /*----------Actionts----------*/

    public void clickBackButton()
    {
        backButton = xpathSetter("//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[@index='0']/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[@index='0']");
        myActions.action_click(backButton);
    }

    public String getPageTitle()
    {
        pageTitle = xpathSetter("//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[@index='0']/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[@index='1']");
        return myActions.action_getText(pageTitle);
    }

}
