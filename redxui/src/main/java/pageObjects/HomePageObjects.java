package pageObjects;

import org.openqa.selenium.WebElement;
import utils.*;

import java.util.List;

public class HomePageObjects extends RedXBaseClass
{
    private MyActions myActions;

    public HomePageObjects() { myActions = new MyActions(); }

    /*----------ELements----------*/

    private WebElement settingsButton;
    private WebElement deliverYourParcelModule;
    private WebElement viewParcelUpdatesModule;
    private WebElement viewPaymentUpdatesModule;
    private WebElement chooseShopModule;

    /*----------Actions----------*/

    public void clickChooseShopModule()
    {
        chooseShopModule = xpathSetter("//android.view.ViewGroup[1]//android.widget.ImageView[@index='1']");
        myActions.action_click(chooseShopModule);
    }

    public void clickSettingsButton()
    {
        settingsButton = xpathSetter("//android.view.ViewGroup[@index='2']/android.widget.TextView");
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



    public class ChooseShopModule
    {
        /*----------Elements----------*/

        private WebElement backButton;
        private List<WebElement> shopsList;

        /*----------Actions----------*/

        public void clickBackButton()
        {
            backButton = xpathSetter("//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[@index='0']");
        }

        public List<WebElement> getShopsList()
        {
            shopsList = xpathListSetter("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup");
            shopsList.remove(new int[]{0, shopsList.size() - 1, shopsList.size() - 2});
            return shopsList;
        }

        public void selectShopById(List<WebElement> list, int index)
        {
            System.out.println("Index: " + index);
            myActions.action_click(list.get(index));
        }

        public void selectShopByText(String shopName)
        {
            String shopSelector = "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\")).scrollIntoView(new UiSelector().text(\""+ shopName +"\"))";
            WebElement selectedShop = uiAutomatorSetter(shopSelector);
            myActions.action_click(selectedShop);
        }
    }
}
