package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.*;

import java.util.List;
import java.util.Random;

public class ManifestParcelDetails extends RedXBaseClass
{
    private MyActions myActions;
    private Random random;

    public ManifestParcelDetails()
    {
        myActions = new MyActions();
        random = new Random();
    }

    /*----------ELements----------*/

    private WebElement backButton;
    private WebElement inProgressPackagesTab;
    private WebElement failedPackagesTab;
    private WebElement deliveredPackagesTab;
    private List<WebElement> packagesList;
    private WebElement confirmDeleteButton;

    /*----------Actions----------*/

    public void clickBackButton()
    {
        backButton = xpathSetter("//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[@index='0']/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[@index='0']");
        myActions.action_click(backButton);
    }

    public void clickInProgressPackagesTab()
    {
        inProgressPackagesTab = xpathSetter("//android.widget.TextView[@text='IN PROGRESS']");
        myActions.action_click(inProgressPackagesTab);
    }

    public void clickFailedPackagesTab()
    {
        failedPackagesTab = xpathSetter("//android.widget.TextView[@text='FAILED']");
        myActions.action_click(failedPackagesTab);
    }

    public void clickDeliveredPackagesTab()
    {
        deliveredPackagesTab = xpathSetter("//android.widget.TextView[@text='DELIVERED']");
        myActions.action_click(deliveredPackagesTab);
    }

    public List<WebElement> setPackagesList()
    {
        String packagesListXpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup";
        packagesList = xpathListSetter(packagesListXpath);
        packagesList.remove(0);
        packagesList.remove(packagesList.size()-1);
        System.out.println("Packages Present: " + packagesList.size());
        return packagesList;
    }

    public void clickEditPackageByIndex(int index)
    {
        WebElement selectedPackage = packagesList.get(index).findElement(By.xpath("//android.widget.TextView[@text='EDIT']"));
        System.out.println("Index: " + index);
        myActions.action_click(selectedPackage);
    }

    public void clickDeletePackageByIndex(int index)
    {
        WebElement selectedPackage = packagesList.get(index).findElement(By.xpath("//android.widget.TextView[@text='DELETE']"));
        System.out.println("Index: " + index);
        myActions.action_click(selectedPackage);
        sleep(500);
        clickConfirmDeleteButton();
        sleep(1000);
        clickBackButton();
    }

    public void clickDetailsByIndex(int index)
    {
        WebElement selectedPackage = packagesList.get(index).findElement(By.xpath("//android.widget.TextView[@text='DETAILS']"));
        System.out.println("Index: " + index);
        myActions.action_click(selectedPackage);
    }

    public void clickConfirmDeleteButton()
    {
        confirmDeleteButton = idSetter("android:id/button1");
        myActions.action_click(confirmDeleteButton);
    }


    /*----------Edit Package Module----------*/
    public class EditPackageModule
    {
        /*----------ELements----------*/

        private WebElement nameEntry;
        private WebElement phoneEntry;
        private WebElement cashEntry;
        private WebElement sellingPriceEntry;
        private WebElement addressEntry;
        private WebElement areaDropDown;
        private WebElement invoiceNumberEntry;
        private WebElement instructionEntry;
        private WebElement updateButton;
        private WebElement backButton;

        /*----------Actions----------*/

        public void enterName(String name)
        {
            nameEntry = xpathSetter("//android.widget.EditText[@index='1']");
            myActions.action_sendKeys(nameEntry,name);
        }

        public void enterPhone(String phone)
        {
            phoneEntry = xpathSetter("//android.widget.EditText[@index='3']");
            myActions.action_sendKeys(phoneEntry,phone);
        }

        public void enterCash(String cash)
        {
            cashEntry = xpathSetter("//android.widget.EditText[@index='5']");
            myActions.action_sendKeys(cashEntry,cash);
        }

        public void enterSellingPrice(String sellingPrice)
        {
            sellingPriceEntry = xpathSetter("//android.widget.EditText[@index='7']");
            myActions.action_sendKeys(sellingPriceEntry,sellingPrice);
        }

        public void enterAddress(String address)
        {
            addressEntry = xpathSetter("//android.widget.EditText[@index='10']");
            myActions.action_sendKeys(addressEntry,address);
        }

        public void enterArea()
        {
            areaDropDown = xpathSetter("//android.widget.EditText[@index='0']");
            myActions.action_click(areaDropDown);
        }

        public List<WebElement> areaList()
        {
            String areaXpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup";
            List<WebElement> listOfAreas = xpathListSetter(areaXpath);
            listOfAreas.remove(0);
            return listOfAreas;
        }

        public void selectAreaById(List<WebElement> list,int index)
        {
            System.out.println("Index: " + index);
            myActions.action_click(list.get(index));
        }

        public void selectAreaByText(String area)
        {
            String areaSelector = "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\")).scrollIntoView(new UiSelector().text(\""+ area +"\"))";
            WebElement selectedArea = uiAutomatorSetter(areaSelector);
            myActions.action_click(selectedArea);
        }

        public void enterInvoiceNumber(String invoiceNumber)
        {
            invoiceNumberEntry = xpathSetter("//android.widget.EditText[@index='14']");
            myActions.action_sendKeys(invoiceNumberEntry,invoiceNumber);
        }

        public void enterInstruction(String instruction)
        {
            String instructionSelector = "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\")).scrollIntoView(new UiSelector().className(\"android.widget.EditText\").index(" + 17 + "))";
            instructionEntry = getBaseDriver().findElementByAndroidUIAutomator(instructionSelector);
            myActions.action_sendKeys(instructionEntry,instruction);
        }

        public void clickUpdateButton()
        {
            updateButton = xpathSetter("//android.widget.TextView[@text='UPDATE']");
            myActions.action_click(updateButton);
        }

        /*----------Functions----------*/

        public void editParcel(String name, String phone, String cash, String sellingPrice, String address, String area,
                              String invoiceNumber, String instruction)
        {
            enterName(name);
            enterPhone(phone);
            enterCash(cash);
            enterSellingPrice(sellingPrice);
            enterAddress(address);
            enterArea();
            selectAreaByText(area);
            enterInvoiceNumber(invoiceNumber);
            //enterInstruction(instruction);
            clickUpdateButton();
        }
    }


    /*----------Edit Package Module----------*/
    public class PackageDetailsModule
    {
        /*----------ELements----------*/

        private WebElement backButton;
        private WebElement currentStatus;
        private WebElement parcelPayment;
        private WebElement deliveryCharge;
        private WebElement codCharge;
        private WebElement returnCharge;
        private WebElement payableAmount;
        private WebElement name;
        private WebElement phone;
        private WebElement recievable;
        private WebElement address;
        private WebElement area;
        private WebElement deliveryDate;
        private WebElement deliveryInstruction;
        private WebElement invoice;

        /*----------Functions----------*/

        public void getDetails()
        {
        }

    }

}
