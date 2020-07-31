package pageObjects;

import org.openqa.selenium.WebElement;
import utils.*;

import java.util.List;

public class SettingsPageObjects extends RedXBaseClass
{
    MyActions myActions;

    public SettingsPageObjects() { myActions = new MyActions(); }

    /*----------Elements----------*/

    private WebElement backButton;
    private WebElement paymentDetailsModule;
    private WebElement pickupInfoModule;
    private WebElement otherSettingsModule;
    private WebElement termsOfDeliveryModule;
    private WebElement logoutButton;
    private WebElement confirmLogoutButton;

    /*----------Actions----------*/

    public void clickBackButton()
    {
        backButton = xpathSetter("//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='0']");
        myActions.action_click(backButton);
    }

    public void clickPaymentDetailsModule()
    {
        paymentDetailsModule = xpathSetter("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]");
        myActions.action_click(paymentDetailsModule);
    }

    public void clickPickupAreaModule()
    {
        pickupInfoModule = xpathSetter("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]");
        myActions.action_click(pickupInfoModule);
    }

    public void clickOtherSettingsModule()
    {
        otherSettingsModule = xpathSetter("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]");
        myActions.action_click(otherSettingsModule);
    }

    public void clickTermsOfDeliveryModule()
    {
        termsOfDeliveryModule = xpathSetter("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]");
        myActions.action_click(termsOfDeliveryModule);
    }

    public void clickLogoutButton()
    {
        logoutButton = xpathSetter("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]");
        myActions.action_click(logoutButton);
    }

    public void clickOkButton()
    {
        confirmLogoutButton = idSetter("android:id/button2");
        myActions.action_click(confirmLogoutButton);
    }

    /*----------Functions----------*/

    public void performLogout()
    {
        clickLogoutButton();
        clickOkButton();
    }


    /*----------Payment Details Module----------*/

    public class PaymentDetailsPageObjects
    {

        /*----------Elements----------*/

        private WebElement backButton;
        private WebElement bKashAccountNumberEntry;
        private WebElement bankAccountNameEntry;
        private WebElement bankDropDown;
        private WebElement branchDropDown;
        private WebElement accountNoEntry;
        private WebElement routingNoEntry;
        private WebElement accountTypeDropDown;
        private WebElement saveChangesButton;

        /*----------Actions----------*/

        public void clickBackButton()
        {
            backButton = xpathSetter("//android.view.ViewGroup[@index='0']/android.view.ViewGroup/android.widget.TextView[@index='0']");
            myActions.action_click(backButton);
        }

        public void enterBkashAccountNumber(String bKashAcntNo)
        {
            bKashAccountNumberEntry = xpathSetter("//android.widget.EditText[@text='bKash Account Number']");
            myActions.action_sendKeys(bKashAccountNumberEntry,bKashAcntNo);
        }

        public void enterBankAccountName(String  bankAcntName)
        {
            bankAccountNameEntry = xpathSetter("//android.widget.EditText[@text='Bank Account Name']");
            myActions.action_sendKeys(bankAccountNameEntry,bankAcntName);
        }

        public void clickBank()
        {
            bankDropDown = xpathSetter("//android.widget.EditText[@text='Bank']");
            myActions.action_click(bankDropDown);
        }

        public List<WebElement> bankList()
        {
            String bankListXpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup";
            List<WebElement> listOfBanks = xpathListSetter(bankListXpath);
            return listOfBanks;
        }

        public void selectBankById(List<WebElement> list,int index)
        {
            System.out.println("Index: " + index);
            myActions.action_click(list.get(index));
        }

        public void selectBankByText(String bank)
        {
            String bankSelector = "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\")).scrollIntoView(new UiSelector().text(\""+ bank +"\"))";
            WebElement selectedBank = uiAutomatorSetter(bankSelector);
            myActions.action_click(selectedBank);
        }

        public void clickBranch()
        {
            branchDropDown = xpathSetter("//android.widget.EditText[@text='Branch']");
            myActions.action_click(branchDropDown);
        }

        public void selectBranchByText(String branch)
        {
            WebElement searchBranch = xpathSetter("//android.widget.EditText");
            myActions.action_sendKeys(searchBranch,branch);
            WebElement selectedBranch = xpathSetter("//android.widget.ScrollView//android.widget.TextView");
            myActions.action_click(selectedBranch);
        }

        public void enterAccountNo(String acntNo)
        {
            accountNoEntry = xpathSetter("//android.widget.EditText[@text='Account No.']");
            myActions.action_sendKeys(accountNoEntry,acntNo);
        }

        public void enterRoutingNo(String routingNo)
        {
            routingNoEntry = xpathSetter("//android.widget.EditText[@text='Routing No.']");
            myActions.action_sendKeys(routingNoEntry,routingNo);
        }

        public void selectAccountType(String acntType)
        {
            accountTypeDropDown = idSetter("android:id/text1");
            myActions.action_select(accountTypeDropDown,acntType);
        }

        public void clickSaveChanges()
        {
            saveChangesButton = xpathSetter("//android.widget.TextView[@text='SAVE CHANGES']");
            myActions.action_click(saveChangesButton);
        }

        /*----------Functions----------*/

        public void updatePaymentInfo(String bKashAcntNo,String bankAcntName, String bank, String branch,
                                      String acntNo, String acntType)
        {
            enterBkashAccountNumber(bKashAcntNo);
            enterBankAccountName(bankAcntName);
            clickBank();
            selectBankByText(bank);
            clickBranch();
            selectBranchByText(branch);
            enterAccountNo(acntNo);
            selectAccountType(acntType);
            clickSaveChanges();
        }
    }


    /*----------PickUp Information Module----------*/

    public class PickUpInformation
    {

        /*----------Elements----------*/

        private WebElement area;
        private WebElement address;
        private WebElement contactNumber;
        private WebElement editInfo;
        private WebElement areaEntry;
        private WebElement addressEntry;
        private WebElement contactNumberEntry;
        private WebElement saveChangesButton;
        private WebElement backButton;

        /*----------Actions----------*/

        public String getArea()
        {
            area = xpathSetter("//android.widget.TextView[3]");
            return myActions.action_getText(area);
        }

        public String getAddress()
        {
            address = xpathSetter("//android.widget.TextView[5]");
            return myActions.action_getText(address);
        }

        public String getContactNumber()
        {
            contactNumber = xpathSetter("//android.widget.TextView[7]");
            return myActions.action_getText(contactNumber);
        }

        public void clickEditInfo()
        {
            editInfo = xpathSetter("//android.view.ViewGroup[2]/android.widget.TextView");
            myActions.action_click(editInfo);
        }

        public void enterArea()
        {
            areaEntry = xpathSetter("//android.view.ViewGroup/android.widget.EditText[@index='0']");
            myActions.action_click(areaEntry);
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
            WebElement selectedArea = getBaseDriver().findElementByAndroidUIAutomator(areaSelector);
            myActions.action_click(selectedArea);
        }

        public void enterAddress(String address)
        {
            addressEntry = xpathSetter("//android.view.ViewGroup/android.widget.EditText[@index='3']");
            myActions.action_clearText(addressEntry);
            myActions.action_sendKeys(addressEntry,address);
        }

        public void enterContactNumber(String contactNumber)
        {
            contactNumberEntry = xpathSetter("//android.view.ViewGroup/android.widget.EditText[@index='5']");
            myActions.action_clearText(contactNumberEntry);
            myActions.action_sendKeys(contactNumberEntry,contactNumber);
        }

        public void clickSaveChanges()
        {
            saveChangesButton = xpathSetter("//android.widget.TextView[@text='SAVE CHANGES']");
            myActions.action_click(saveChangesButton);
        }

        public void clickBackButton()
        {
            backButton = xpathSetter("//android.view.ViewGroup[@index='0']/android.view.ViewGroup[1]/android.widget.TextView[@index='0']");
            myActions.action_click(backButton);
        }

        /*----------Functions----------*/

        public void getPickupInfo()
        {
            System.out.println("Pickup Area: " + getArea());
            System.out.println("Pickup Address: " + getAddress());
            System.out.println("Pickup Contact Number: " + getContactNumber());
        }

        public void updatePickupInfo(String area, String address, String contactNumber)
        {
            clickEditInfo();
            enterArea();
            selectAreaByText(area);
            enterAddress(address);
            enterContactNumber(contactNumber);
            clickSaveChanges();
        }
    }


    /*----------Other Settings Module----------*/

    public class OtherSettings
    {
        /*----------Elements----------*/

        //private WebElement backButton;
        private WebElement banglaLanguage;
        private WebElement englishLanguage;

        /*----------Actions----------*/

//        public void clickBackButton()
//        {
//            backButton = xpathSetter("//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='0']");
//            myActions.action_click(backButton);
//        }

        public void setBanglaLanguage()
        {
            banglaLanguage = xpathSetter("//android.view.ViewGroup[2]/android.view.ViewGroup[2]");
            myActions.action_click(banglaLanguage);
        }

        public void setEnglishLanguage()
        {
            englishLanguage = xpathSetter("//android.view.ViewGroup[2]/android.view.ViewGroup[3]");
            myActions.action_click(englishLanguage);
        }

        /*----------Functions----------*/

        public void changeToEnglish()
        {
            clickOtherSettingsModule();
            setEnglishLanguage();
        }

        public void changeToBangla()
        {
            clickOtherSettingsModule();
            setBanglaLanguage();
        }
    }
}
