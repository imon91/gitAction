package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.ManifestParcelDetails.PackageDetailsModule;
import utils.*;

import java.util.List;

public class PaymentUpdatesPageObjects extends RedXBaseClass
{
    private MyActions myActions;

    public PaymentUpdatesPageObjects(){myActions = new MyActions();}

    /*----------Elements----------*/

    private WebElement backButton;
    private WebElement paidAmountTab;
    private WebElement processingTab;
    private WebElement unpaidAmountTab;
    private List<WebElement> parcelsList;

    /*----------Actions----------*/

    public void clickBackButton()
    {
        String backXpath="//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='0']";
        backButton = xpathSetter(backXpath);
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

    public List<WebElement> setParcelsList()
    {
        String parcelsListXpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup";
        parcelsList = xpathListSetter(parcelsListXpath);
        parcelsList.remove(0);
        parcelsList.remove(parcelsList.size()-1);
        System.out.println("Parcels Present: " + parcelsList.size());
        return parcelsList;
    }

    public void clickViewInvoiceByIndex(int index)
    {
        WebElement selectedPackage = parcelsList.get(index).findElement(By.xpath("//android.widget.TextView[@text='VIEW INVOICE']"));
        System.out.println("Index: " + index);
        myActions.action_click(selectedPackage);
    }

    public class ViewInvoice
    {
        /*----------Elements----------*/

        private WebElement backButton;
        private WebElement paymentId;
        private WebElement cashCollected;
        private WebElement adjustment;
        private WebElement deliveryCharge;
        private WebElement codCharge;
        private WebElement cashDeposit;
        private WebElement deliveredTab;
        private WebElement returnedTab;
        private WebElement damagedTab;
        private List<WebElement> packagesList;
        private PackageDetailsModule packageDetailsModule = new ManifestParcelDetails().new PackageDetailsModule();

        /*----------Actions----------*/

        public void clickBackButton()
        {
            String backXpath="//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='0']";
            backButton = xpathSetter(backXpath);
            myActions.action_click(backButton);
        }

        public String getPaymentId()
        {
            paymentId = xpathSetter("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]//android.widget.TextView[@index='3']");
            return myActions.action_getText(paymentId);
        }

        public String getCashCollected()
        {
            cashCollected = xpathSetter("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]//android.widget.TextView[@index='5']");
            return myActions.action_getText(cashCollected);
        }

        public String getAdjustment()
        {
            adjustment = xpathSetter("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]//android.widget.TextView[@index='7']");
            return myActions.action_getText(adjustment);
        }

        public String getDeliveryCharge()
        {
            deliveryCharge = xpathSetter("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]//android.widget.TextView[@index='9']");
            return myActions.action_getText(deliveryCharge);
        }

        public String getCodCharge()
        {
            codCharge = xpathSetter("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]//android.widget.TextView[@index='11']");
            return myActions.action_getText(codCharge);
        }

        public String getCashDeposit()
        {
            cashDeposit = xpathSetter("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]//android.widget.TextView[@index='13']");
            return myActions.action_getText(cashDeposit);
        }

        public void clickDeliveredTab()
        {
            deliveredTab = xpathSetter("//android.widget.TextView[@text='DELIVERED']");
            myActions.action_click(deliveredTab);
        }

        public void clickReturnedTab()
        {
            returnedTab = xpathSetter("//android.widget.TextView[@text='RETURNED']");
            myActions.action_click(returnedTab);
        }

        public void clickDamagedTab()
        {
            damagedTab = xpathSetter("//android.widget.TextView[@text='DAMAGED']");
            myActions.action_click(damagedTab);
        }

        public List<WebElement> setPackagesList()
        {
            String packagesListXpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup";
            packagesList = xpathListSetter(packagesListXpath);
            packagesList.remove(packagesList.size()-1);
            packagesList.remove(0);
            System.out.println("Parcels Present: " + packagesList.size());
            return packagesList;
        }

        public void clickDetailsByIndex(int index)
        {
            System.out.println("Index: " + index);
            WebElement selectedPackage = packagesList.get(index).findElement(By.xpath("//android.widget.TextView[@text='DETAILS']"));
            myActions.action_click(selectedPackage);
        }

        /*----------Functions----------*/

        public void getParcelDetails()
        {
            System.out.println();
            System.out.println("Parcel Invoice");
            System.out.println("Payment ID : "+ getPaymentId());
            System.out.println("Cash Collected : "+ getCashCollected());
            System.out.println("Adjustment : "+ getAdjustment());
            System.out.println("Delivery Charge : "+ getDeliveryCharge());
            System.out.println("COD Charge : "+ getCodCharge());
            System.out.println("Cash Deposit : "+ getCashDeposit());
            System.out.println();
        }

        public void getInvoiceDetails()
        {
            packageDetailsModule.getDetails("Payment");
        }
    }
}

