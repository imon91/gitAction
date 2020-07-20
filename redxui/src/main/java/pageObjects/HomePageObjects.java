package pageObjects;

import org.openqa.selenium.WebElement;
import utils.*;

public class HomePageObjects extends RedXBaseClass
{
    private MyActions myActions;

    public HomePageObjects() { myActions = new MyActions(); }

    /*----------ELements----------*/

    private WebElement settingsButton;
    private WebElement deliverYourParcelModule;
    private WebElement viewParcelUpdatesModule;
    private WebElement viewPaymentUpdatesModule;

    /*----------Actions----------*/

    public void clickSettingsButton()
    {
        settingsButton = xpathSetter("//android.view.ViewGroup[@index='1']/android.widget.TextView");
        myActions.action_click(settingsButton);
    }

    public void clickDeliverYourParcelModule()
    {
        deliverYourParcelModule = xpathSetter("//android.widget.TextView[@text='Deliver your parcels']");
        myActions.action_click(deliverYourParcelModule);
    }

    public void clickViewParcelUpdatesModule()
    {
        viewParcelUpdatesModule = xpathSetter("//android.widget.TextView[@text='View parcel updates']");
        myActions.action_click(viewParcelUpdatesModule);
    }

    public void clickViewPaymentUpdatesModule()
    {
        viewPaymentUpdatesModule = xpathSetter("//android.widget.TextView[@text='View payment updates']");
        myActions.action_click(viewPaymentUpdatesModule);
    }
}
