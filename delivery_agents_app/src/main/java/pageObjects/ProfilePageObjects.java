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

    /*----------Actions----------*/

    public String getTitleValue()
    {
        titleValue = xpathSetter("//android.widget.TextView[@index='0']");
        return myActions.action_getText(titleValue);
    }
}
