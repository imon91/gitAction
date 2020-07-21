package pageObjects;

import org.openqa.selenium.WebElement;
import utils.*;

public class ParcelsPageObjects extends RedXBaseClass
{
    private MyActions myActions;

    public ParcelsPageObjects() {myActions = new MyActions();}


    /*----------Action Bar Page Objects----------*/

    public class ActionBarPageObjects
    {
        /*----------ELements----------*/

        private WebElement backButton;
        private WebElement searchButton;

        /*----------Actions----------*/

        public void clickBackButton()
        {
            backButton = xpathSetter("//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[@index='0']/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[@index='0']");
            myActions.action_click(backButton);
        }

        public void clickSearchButton()
        {
            searchButton = xpathSetter("//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[@index='0']/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.TextView[@index='0']");
            myActions.action_click(searchButton);
        }
    }


    /*----------Date Filter Handling----------*/

    public class DateFilterPageObjects
    {
        /*----------ELements----------*/

        private WebElement nextMonthButton;
        private WebElement previousMonthButton;
        private WebElement currentMonth;

        /*----------Actions----------*/

        public void clickNextMonthButton()
        {
            nextMonthButton = xpathSetter("//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[@index='0']");
            myActions.action_click(nextMonthButton);
        }

        public void clickPreviousMonthButton()
        {
            previousMonthButton = xpathSetter("//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.TextView[@index='0']");
            myActions.action_click(previousMonthButton);
        }

        public void getCurrentMonth()
        {
            currentMonth = xpathSetter("//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[@index='0']/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.TextView");
            myActions.action_getText(currentMonth);
        }
    }


    /*----------Order Status Page Objects----------*/

    public class OrderStatusPageObjects
    {
        /*----------ELements----------*/

        private WebElement inProgressParcelsTab;
        private WebElement failedParcelsTab;
        private WebElement deliveredParcelsTab;

        /*----------Actions----------*/

        public void clickInProgressParcelsTab()
        {
            inProgressParcelsTab = xpathSetter("//android.widget.TextView[@text='IN PROGRESS']");
            myActions.action_click(inProgressParcelsTab);
        }

        public void clickFailedParcelsTab()
        {
            failedParcelsTab = xpathSetter("//android.widget.TextView[@text='FAILED']");
            myActions.action_click(failedParcelsTab);
        }

        public void clickDeliveredParcelsTab()
        {
            deliveredParcelsTab = xpathSetter("//android.widget.TextView[@text='DELIVERED']");
            myActions.action_click(deliveredParcelsTab);
        }
    }
}
