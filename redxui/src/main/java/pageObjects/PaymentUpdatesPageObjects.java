package pageObjects;

import org.openqa.selenium.WebElement;
import utils.*;

public class PaymentUpdatesPageObjects extends RedXBaseClass
{
    private MyActions myActions;

    public PaymentUpdatesPageObjects(){myActions = new MyActions();}

    /*----------Elements----------*/

    private WebElement backButton;
    private WebElement paidAmountTab;
    private WebElement processingTab;
    private WebElement unpaidAmountTab;

    /*----------Actions----------*/

    public void clickBackButton()
    {
        backButton = xpathSetter("//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='0']");
        myActions.action_click(backButton);
    }

    public void clickPaidAmountTab()
    {
        paidAmountTab = xpathSetter("//android.widget.TextView[@text='PAID AMOUNT']");
        myActions.action_click(paidAmountTab);
    }

    public void clickProcessingTab()
    {
        processingTab = xpathSetter("//android.widget.TextView[@text='PROCESSING']");
        myActions.action_click(processingTab);
    }

    public void clickUnpaidAmount()
    {
        unpaidAmountTab = xpathSetter("//android.widget.TextView[@text='UNPAID AMOUNT']");
        myActions.action_click(unpaidAmountTab);
    }
}

