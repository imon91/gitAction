package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DeliveryAgentsBaseClass;
import utils.MyActions;

public class EarningDetailsPageObjects extends DeliveryAgentsBaseClass {

    private MyActions myActions;

    public EarningDetailsPageObjects()
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

    /*----------Functions----------*/

    public void waitForLoading()
    {
        System.out.println("Waiting For Loading");
        try {
            new WebDriverWait(getBaseDriver(),30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ScrollView//android.view.ViewGroup[@index='1']")));
        } catch (Exception e)
        {
            System.out.println("Exception : " + e);
        }
    }
}
