package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.*;

import java.util.List;

public class HomePageObjects extends RedXBaseClass
{
    private MyActions myActions;
    private CommonPageObjects commonPageObjects;

    public HomePageObjects()
    {
        myActions = new MyActions();
        commonPageObjects = new CommonPageObjects();
    }

    /*----------ELements----------*/

    private WebElement settingsButton;
    private WebElement deliverYourParcelModule;
    private WebElement viewParcelUpdatesModule;
    private WebElement viewPaymentUpdatesModule;
    private WebElement chooseShopModule;
    private WebElement toastMessage;

    /*----------Actions----------*/

    public void clickChooseShopModule()
    {
        chooseShopModule = xpathSetter("//android.view.ViewGroup[1]//android.widget.ImageView[@index='1']");
        myActions.action_click(chooseShopModule);
    }

    public String getCurrentShopName()
    {
        String currentShopName = commonPageObjects.getPageTitle();
        try {
            PropertyReader.setValue(PropertyReader.Keys.SHOP_NAME,currentShopName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return currentShopName;
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

    public String getToastMessage()
    {
        toastMessage = xpathSetter("//android.widget.ScrollView//android.view.ViewGroup[2]//android.widget.TextView");
        return myActions.action_getText(toastMessage);
    }



    public class ChooseShopModule
    {
        /*----------Elements----------*/

        private List<WebElement> shopsList;

        /*----------Actions----------*/

        public List<WebElement> getShopsList()
        {
            shopsList = xpathListSetter("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup");
            shopsList.remove(new int[]{0, shopsList.size() - 1, shopsList.size() - 2});
            return shopsList;
        }

        public void selectShopById(List<WebElement> list, int index)
        {
            System.out.println("Index: " + index);
            try {
                String shopName = list.get(index).findElement(By.xpath("//android.widget.TextView")).getText();
                System.out.println("Selected Shop: " + shopName);
                myActions.action_click(list.get(index));
                PropertyReader.setValue(PropertyReader.Keys.SHOP_NAME,shopName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void selectShopByText(String shopName)
        {
            String shopSelector = "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\")).scrollIntoView(new UiSelector().text(\""+ shopName +"\"))";
            WebElement selectedShop = uiAutomatorSetter(shopSelector);
            myActions.action_click(selectedShop);
            try {
                PropertyReader.setValue(PropertyReader.Keys.SHOP_NAME,shopName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
