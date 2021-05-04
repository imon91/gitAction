package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.ManifestParcelDetails.PackageDetailsModule;
import utils.*;

import java.util.ArrayList;
import java.util.List;

public class PaymentUpdatesPageObjects extends RedXBaseClass
{
    private MyActions myActions;

    public PaymentUpdatesPageObjects(){myActions = new MyActions();}

    /*----------Elements----------*/

    private WebElement paidAmountTab;
    private WebElement processingTab;
    private WebElement unpaidAmountTab;
    private WebElement paidAmountValue;
    private WebElement processingAmountValue;
    private WebElement unpaidAmountValue;
    private List<WebElement> parcelsList;

    /*----------Actions----------*/

    public void clickPaidAmountTab()
    {
        paidAmountTab = xpathSetter("//android.widget.TextView[@text='PAID AMOUNT']");
        myActions.action_click(paidAmountTab);
        sleep(1000);
    }

    public void clickProcessingTab()
    {
        processingTab = xpathSetter("//android.widget.TextView[@text='PROCESSING']");
        myActions.action_click(processingTab);
        sleep(1000);
    }

    public void clickUnpaidAmount()
    {
        unpaidAmountTab = xpathSetter("//android.widget.TextView[@text='UNPAID AMOUNT']");
        myActions.action_click(unpaidAmountTab);
    }

    public String getPaidAmountValue()
    {
        paidAmountValue = xpathSetter("//android.widget.TextView[@text='PAID AMOUNT']/../android.widget.TextView[@index='0']");
        String amount = myActions.action_getText(paidAmountValue);
        return amount.substring(1);
    }

    public String getProcessingAmountValue()
    {
        processingAmountValue = xpathSetter("//android.widget.TextView[@text='PROCESSING']/../android.widget.TextView[@index='0']");
        String amount = myActions.action_getText(processingAmountValue);
        return amount.substring(1);
    }

    public String getUnpaidAmountValue()
    {
        unpaidAmountValue = xpathSetter("//android.widget.TextView[@text='UNPAID AMOUNT']/../android.widget.TextView[@index='0']");
        String amount = myActions.action_getText(unpaidAmountValue);
        return amount.substring(1);
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
        String date = myActions.action_getText(parcelsList.get(index).findElement(By.xpath("//android.widget.TextView[@index='0']")));
        try {
            PropertyReader.setValue(PropertyReader.Keys.PARCEL_DATE,date);
            System.out.println("Index: " + index);
            System.out.println("Date :" + date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement selectedPackage = parcelsList.get(index).findElement(By.xpath("//android.widget.TextView[@text='VIEW INVOICE']"));
        myActions.action_click(selectedPackage);
    }

    /*----------Functions----------*/

    public List<String> getPaymentValue()
    {
        List<String> paymentValue = new ArrayList<>();
        paymentValue.add(getPaidAmountValue());
        paymentValue.add(getProcessingAmountValue());
        paymentValue.add(getUnpaidAmountValue());
        return paymentValue;
    }


    /*----------Action Bar Page Objects----------*/

    public class ActionBarPageObjects {
        /*----------ELements----------*/

        private WebElement backButton;
        private WebElement pageTitle;
        private WebElement parcelDetailsTitle;

        /*----------Actions----------*/

        public void clickBackButton()
        {
            backButton = xpathSetter("//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[@index='0']/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[@index='0']");
            myActions.action_click(backButton);
        }

        public String getPageTitle()
        {
            pageTitle = xpathSetter("//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[@index='0']/android.view.ViewGroup[1]/android.widget.TextView[@index='1']");
            return myActions.action_getText(pageTitle);
        }

        public String getParcelDetailsTitle()
        {
            parcelDetailsTitle = xpathSetter("//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[@index='0']/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.TextView[@index='0']");
            return myActions.action_getText(parcelDetailsTitle);
        }
    }


    /*----------View Invoice Page Objects----------*/

    public class ViewInvoice
    {
        /*----------Elements----------*/

        private WebElement pageTitle;
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
        private ManifestParcelDetails manifestParcelDetails = new ManifestParcelDetails();
        private PackageDetailsModule packageDetailsModule = new ManifestParcelDetails().new PackageDetailsModule();

        /*----------Actions----------*/

        public String getPageTitle()
        {
            pageTitle = xpathSetter("//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[@index='0']/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[@index='1']");
            return myActions.action_getText(pageTitle);
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
            String parcelID = manifestParcelDetails.getParcelId(index);
            String parcelStatus = manifestParcelDetails.getParcelStatus(index);
            try {
                PropertyReader.setValue(PropertyReader.Keys.PARCEL_ID, parcelID);
                PropertyReader.setValue(PropertyReader.Keys.PARCEL_STATUS, parcelStatus);
            } catch (Exception e) {
                e.printStackTrace();
            }
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

