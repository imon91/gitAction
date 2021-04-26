package pageObjects;

import org.openqa.selenium.*;
import utils.*;
import java.util.*;

public class ParcelsPageObjects extends RedXBaseClass
{
    private MyActions myActions;

    public ParcelsPageObjects() {myActions = new MyActions();}


    /*----------Action Bar Page Objects----------*/

    public class ActionBarPageObjects
    {
        /*----------ELements----------*/

        private WebElement backButton;
        private WebElement pageTitle;
        private WebElement searchButton;
        private WebElement parcelDetailsTitle;
        private WebElement searchBar;

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

        public String getPageTitle()
        {
            pageTitle = xpathSetter("//android.view.ViewGroup[@index='0']/android.widget.TextView[@index='1']");
            return myActions.action_getText(pageTitle);
        }

        public String getParcelDetailsTitle()
        {
            parcelDetailsTitle = xpathSetter("//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[@index='0']/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.TextView[@index='0']");
            return myActions.action_getText(parcelDetailsTitle);
        }

        public void enterSearchTerm(String searchTerm)
        {
           WebElement searchIcon = xpathSetter("//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']");
           myActions.action_click(searchIcon);
           sleep(500);
            searchBar = xpathSetter("//android.view.ViewGroup[@index='0']/android.widget.EditText[@index='1']");
            myActions.action_sendKeys(searchBar,searchTerm);
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

        public void clickPreviousMonthButton()
        {
            nextMonthButton = xpathSetter("//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[@index='0']");
            myActions.action_click(nextMonthButton);
        }

        public void clickNextMonthButton()
        {
            previousMonthButton = xpathSetter("//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.TextView[@index='0']");
            myActions.action_click(previousMonthButton);
        }

        public String getCurrentMonth()
        {
            currentMonth = xpathSetter("//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[@index='0']/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.TextView");
            return myActions.action_getText(currentMonth);
        }

        /*----------Functions----------*/

        public void chooseMonthByText(String month)
        {
            System.out.println("Required Month: " + month);
            while(!getCurrentMonth().equals(month))
            {
                System.out.println("Current Month: " + getCurrentMonth() + " ");
                clickPreviousMonthButton();
                sleep(1000);
            }
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


    /*----------Parcels Manifest List----------*/

    public class ParcelsManifestList
    {
        /*----------ELements----------*/

        List<WebElement> parcelsList;

        /*----------Actions----------*/

        public List<WebElement> setParcelsList()
        {
            String parcelsListXpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup";
            parcelsList = xpathListSetter(parcelsListXpath);
            parcelsList.remove(0);
            parcelsList.remove(parcelsList.size()-1);
            System.out.println("Parcels Present: " + parcelsList.size());
            return parcelsList;
        }

        public void clickParcelByIndex(int index)
        {
            String date = myActions.action_getText(childXpathSetter(parcelsList,index,"//android.widget.TextView[@index='0']"));
            try {
                PropertyReader.setValue(PropertyReader.Keys.PARCEL_DATE,date);
                System.out.println("Index: " + index);
                System.out.println("Date :" + date);
            } catch (Exception e) {
                e.printStackTrace();
            }
            myActions.action_click(parcelsList.get(index));
        }

        public void clickParcelByDate(String date)
        {
            String parcelSelector = "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\")).scrollIntoView(new UiSelector().text(\""+ date +"\"))";
            WebElement parcel = uiAutomatorSetter(parcelSelector);
            myActions.action_click(parcel);
        }
    }
}
