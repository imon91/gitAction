package pageObjects;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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

    private WebElement inProgressPackagesTab;
    private WebElement failedPackagesTab;
    private WebElement deliveredPackagesTab;
    private List<WebElement> packagesList;
    private WebElement parcelID;
    private WebElement parcelStatus;
    private WebElement confirmDeleteButton;

    /*----------Actions----------*/

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

    public String getParcelId(int index)
    {
        String parcelIdXpath = "/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView[@index='0']";
        parcelID = xpathSetter("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[" + (index+2) + "]" + parcelIdXpath);
        System.out.println("Parcel ID: " + myActions.action_getText(parcelID));
        return myActions.action_getText(parcelID);
    }

    public String getParcelStatus(int index)
    {
        String parcelStatusXpath = "/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView[@index='1']";
        parcelStatus = xpathSetter("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[" + (index+2) + "]" + parcelStatusXpath);
        System.out.println("Parcel Status: " + myActions.action_getText(parcelStatus));
        return myActions.action_getText(parcelStatus);
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
        System.out.println("Index: " + index);
        String parcelID = getParcelId(index);
        String parcelStatus = getParcelStatus(index);
        try {
            PropertyReader.setValue(PropertyReader.Keys.PARCEL_ID,parcelID);
            PropertyReader.setValue(PropertyReader.Keys.PARCEL_STATUS,parcelStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(parcelStatus.equals("PICKUP PENDING"))
        {
            WebElement selectedPackage = packagesList.get(index).findElement(By.xpath("//android.widget.TextView[@text='EDIT']"));
            myActions.action_click(selectedPackage);
        }
        else
            System.out.println("Parcel Status is " + parcelStatus + " hence cannot be edited");
    }

    public void clickDeletePackageByIndex(int index)
    {
        System.out.println("Index: " + index);
        String parcelID = getParcelId(index);
        String parcelStatus = getParcelStatus(index);
        try {
            PropertyReader.setValue(PropertyReader.Keys.PARCEL_ID,parcelID);
            PropertyReader.setValue(PropertyReader.Keys.PARCEL_STATUS,parcelStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(parcelStatus.equals("PICKUP PENDING"))
        {
            WebElement selectedPackage = packagesList.get(index).findElement(By.xpath("//android.widget.TextView[@text='DELETE']"));
            myActions.action_click(selectedPackage);
            clickConfirmDeleteButton();
        }
        else
            System.out.println("Parcel Status is " + parcelStatus + " hence cannot be deleted");
    }

    public void clickDetailsByIndex(int index)
    {
        System.out.println("Index: " + index);
        String parcelID = getParcelId(index);
        String parcelStatus = getParcelStatus(index);
        try {
            PropertyReader.setValue(PropertyReader.Keys.PARCEL_ID,parcelID);
            PropertyReader.setValue(PropertyReader.Keys.PARCEL_STATUS,parcelStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if((!parcelStatus.equals("PICKUP PENDING"))||(!parcelStatus.equals("DAMAGED")))
        {
            WebElement selectedPackage = packagesList.get(index).findElement(By.xpath("//android.widget.TextView[@text='DETAILS']"));
            myActions.action_click(selectedPackage);
        }
        else
            System.out.println("Parcel Status is " + parcelStatus + " hence cannot get the details");
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
            try {
                PropertyReader.setValue(PropertyReader.Keys.CUSTOMER_NAME,name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void enterPhone(String phone)
        {
            phoneEntry = xpathSetter("//android.widget.EditText[@index='3']");
            myActions.action_sendKeys(phoneEntry,phone);
            try {
                PropertyReader.setValue(PropertyReader.Keys.CUSTOMER_PHONE,phone);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void enterCash(String cash)
        {
            cashEntry = xpathSetter("//android.widget.EditText[@index='5']");
            myActions.action_sendKeys(cashEntry,cash);
            try {
                PropertyReader.setValue(PropertyReader.Keys.PARCEL_CASH,cash);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void enterSellingPrice(String sellingPrice)
        {
            sellingPriceEntry = xpathSetter("//android.widget.EditText[@index='7']");
            myActions.action_sendKeys(sellingPriceEntry,sellingPrice);
            try {
                PropertyReader.setValue(PropertyReader.Keys.PARCEL_SELLING_PRICE,sellingPrice);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void enterAddress(String address)
        {
            addressEntry = xpathSetter("//android.widget.EditText[@index='10']");
            myActions.action_sendKeys(addressEntry,address);
            try {
                PropertyReader.setValue(PropertyReader.Keys.DELIVERY_ADDRESS,address);
            } catch (Exception e) {
                e.printStackTrace();
            }
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
            try {
                String area = list.get(index).findElement(By.xpath("//android.widget.TextView")).getText();
                System.out.println("Selected Area: " + area);
                myActions.action_click(list.get(index));
                PropertyReader.setValue(PropertyReader.Keys.DELIVERY_AREA,area);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void selectAreaByText(String area)
        {
            String areaSelector = "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\")).scrollIntoView(new UiSelector().text(\""+ area +"\"))";
            WebElement selectedArea = uiAutomatorSetter(areaSelector);
            myActions.action_click(selectedArea);
            try {
                PropertyReader.setValue(PropertyReader.Keys.DELIVERY_AREA,area);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void enterInvoiceNumber(String invoiceNumber)
        {
            invoiceNumberEntry = xpathSetter("//android.widget.EditText[@index='14']");
            myActions.action_sendKeys(invoiceNumberEntry,invoiceNumber);
            try {
                PropertyReader.setValue(PropertyReader.Keys.INVOICE_NUMBER,invoiceNumber);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void enterInstruction(String instruction)
        {
            String instructionSelector = "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\")).scrollIntoView(new UiSelector().className(\"android.widget.EditText\").index(" + 17 + "))";
            instructionEntry = uiAutomatorSetter(instructionSelector);
            myActions.action_sendKeys(instructionEntry,instruction);
            try {
                PropertyReader.setValue(PropertyReader.Keys.DELIVERY_INSTRUCTION,instruction);
            } catch (Exception e) {
                e.printStackTrace();
            }
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
            int index = random.nextInt(areaList().size());
            selectAreaById(areaList(),index);
            enterInvoiceNumber(invoiceNumber);
            enterInstruction(instruction);
            clickUpdateButton();
        }
    }


    /*----------Edit Package Module----------*/
    public class PackageDetailsModule
    {
        /*----------ELements----------*/

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
        private WebElement parcelID;
        private WebElement paymentId;

        /*----------Actions----------*/

        public String getParcelID()
        {
            parcelID = xpathSetter("//android.view.ViewGroup[@index='0']/android.view.ViewGroup[2]/android.widget.TextView[starts-with(@text,'20A')]");
            return myActions.action_getText(parcelID);
        }

        public String getCurrentStatus()
        {
            currentStatus = xpathSetter("//android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[@index='2']");
            return myActions.action_getText(currentStatus);
        }

        public String getParcelPayment()
        {
            parcelPayment = xpathSetter("//android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[@index='5']");
            return myActions.action_getText(parcelPayment);
        }

        public String getDeliveryCharge()
        {
            deliveryCharge = xpathSetter("//android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[@index='7']");
            return myActions.action_getText(deliveryCharge);
        }

        public String getCodCharge()
        {
            codCharge = xpathSetter("//android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[@index='9']");
            return myActions.action_getText(codCharge);
        }

        public String getReturnCharge()
        {
            returnCharge = xpathSetter("//android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[@index='11']");
            return myActions.action_getText(returnCharge);
        }

        public String getPayableAmount()
        {
            payableAmount = xpathSetter("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[@index='12']/android.widget.TextView[@index='1']");
            return myActions.action_getText(payableAmount);
        }

        public String getName()
        {
            name = xpathSetter("//android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[@index='15']");
            return myActions.action_getText(name);
        }

        public String getPhone()
        {
            phone = xpathSetter("//android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[@index='18']");
            return myActions.action_getText(phone);
        }

        public String getRecievable()
        {
            recievable = xpathSetter("//android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[@index='19']");
            return myActions.action_getText(recievable);
        }

        public String getAddress()
        {
            address = xpathSetter("//android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[@index='22']");
            return myActions.action_getText(address);
        }

        public String getArea()
        {
            area = xpathSetter("//android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[@index='25']");
            return myActions.action_getText(area);
        }

        public String getDeliveryDate()
        {
            deliveryDate = xpathSetter("//android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[@index='26']");
            return myActions.action_getText(deliveryDate);
        }

        public String getDeliveryInstruction()
        {
            String parentSelector = "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\")).scrollIntoView(new UiSelector().text(\"Delivery instructions\"))";
            WebElement parent = uiAutomatorSetter(parentSelector);
            deliveryInstruction = xpathSetter("//android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[@index='32']");
            return myActions.action_getText(deliveryInstruction);
        }

        public String getInvoice()
        {
            String parentSelector = "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\")).scrollIntoView(new UiSelector().text(\"Own Invoice\"))";
            WebElement parent = uiAutomatorSetter(parentSelector);
            invoice = xpathSetter("//android.view.ViewGroup[@index='35']/android.widget.TextView[@index='2']");
            return myActions.action_getText(invoice);
        }

        public String getPaymentId()
        {
            String parentSelector = "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\")).scrollIntoView(new UiSelector().text(\"Payment Id\"))";
            WebElement parent = uiAutomatorSetter(parentSelector);
            paymentId = xpathSetter("//android.view.ViewGroup[@index='38']/android.widget.TextView[@index='2']");
            return myActions.action_getText(paymentId);
        }

        /*----------Functions----------*/

        public void getDetails(String module)
        {
            System.out.println();
            System.out.println("Parcel Details");
            System.out.println("Parcel ID : " + getParcelID());
            System.out.println("Current Status : " + getCurrentStatus());
            System.out.println("Parcel Payment : " + getParcelPayment());//
            System.out.println("Delivery Charge : " + getDeliveryCharge());
            System.out.println("COD Charge : " + getCodCharge());
            System.out.println("Return Charge : " + getReturnCharge());
            System.out.println("Payable Amount : " + getPayableAmount());//
            System.out.println("Name : " + getName());
            System.out.println("Phone : " + getPhone());
            System.out.println("Recievable : " + getRecievable());
            System.out.println("Address : " + getAddress());
            System.out.println("Area : " + getArea());
            System.out.println("Delivery Date : " + getDeliveryDate());
            System.out.println("Delivery Instruction : " + getDeliveryInstruction());
            System.out.println("Invoice : "+ getInvoice());//
            if(module == "Payment")
                System.out.println("Payment ID : "+ getPaymentId());
        }
    }

}
