package pageObjects;

import org.openqa.selenium.WebElement;
import utils.DeliveryAgentsBaseClass;
import utils.MyActions;

public class ProfilePageObjects extends DeliveryAgentsBaseClass {

    private MyActions myActions;

    public ProfilePageObjects()
    {
        myActions = new MyActions();
    }

    /*----------Elements----------*/

    private WebElement titleValue;
    private WebElement earningDetailsLink;

    /*----------Actions----------*/

    public String getTitleValue()
    {
        titleValue = xpathSetter("//android.widget.TextView[@index='0']");
        return myActions.action_getText(titleValue);
    }

    public void clickEarningDetailsLink()
    {
        earningDetailsLink = xpathSetter("//android.view.ViewGroup[@index='7']//android.widget.TextView[contains(@text,'Details')]");
        myActions.action_click(earningDetailsLink);
    }
}
