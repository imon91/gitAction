package pageObjects;

import org.openqa.selenium.*;
import utils.*;
import java.util.*;

public class AddParcelPageObjects extends RedXBaseClass
{
    private MyActions myActions;
    private Random random;

    public AddParcelPageObjects()
    {
        myActions = new MyActions();
        random = new Random();
    }

    /*----------ELements----------*/

    private WebElement pageTitle;
    private WebElement nameEntry;
    private WebElement phoneEntry;
    private WebElement cashEntry;
    private WebElement sellingPriceEntry;
    private WebElement addressEntry;
    private WebElement areaDropDown;
    private WebElement invoiceNumberEntry;
    private WebElement instructionEntry;
    private WebElement confirmButton;
    private WebElement importButton;

    /*----------Actions----------*/

    public String getPageTitle()
    {
        pageTitle = xpathSetter("//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[@index='0']/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[@index='1']");
        return myActions.action_getText(pageTitle);
    }

    public void enterName(String name)
    {
        nameEntry = xpathSetter("//android.widget.EditText[@text='Name']");
        myActions.action_sendKeys(nameEntry,name);
        try {
            PropertyReader.setValue(PropertyReader.Keys.CUSTOMER_NAME,name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterPhone(String phone)
    {
        phoneEntry = xpathSetter("//android.widget.EditText[@text='Phone']");
        myActions.action_sendKeys(phoneEntry,phone);
        try {
            PropertyReader.setValue(PropertyReader.Keys.CUSTOMER_PHONE,phone);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterCash(String cash)
    {
        cashEntry = xpathSetter("//android.widget.EditText[@text='Cash']");
        myActions.action_sendKeys(cashEntry,cash);
        try {
            PropertyReader.setValue(PropertyReader.Keys.PARCEL_CASH,cash);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterSellingPrice(String sellingPrice)
    {
        sellingPriceEntry = xpathSetter("//android.widget.EditText[@text='Selling Price']");
        myActions.action_sendKeys(sellingPriceEntry,sellingPrice);
        try {
            PropertyReader.setValue(PropertyReader.Keys.PARCEL_SELLING_PRICE,sellingPrice);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterAddress(String address)
    {
        addressEntry = xpathSetter("//android.widget.EditText[@text='Address']");
        myActions.action_sendKeys(addressEntry,address);
        try {
            PropertyReader.setValue(PropertyReader.Keys.DELIVERY_ADDRESS,address);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterArea()
    {
        areaDropDown = xpathSetter("//android.widget.EditText[@text='Area']");
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
        invoiceNumberEntry = xpathSetter("//android.widget.EditText[@text='Own Invoice Number']");
        myActions.action_sendKeys(invoiceNumberEntry,invoiceNumber);
        try {
            PropertyReader.setValue(PropertyReader.Keys.INVOICE_NUMBER,invoiceNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterInstruction(String instruction)
    {
        String instructionSelector = "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\")).scrollIntoView(new UiSelector().text(\"Write instruction\"))";
        instructionEntry = uiAutomatorSetter(instructionSelector);
        myActions.action_sendKeys(instructionEntry,instruction);
        try {
            PropertyReader.setValue(PropertyReader.Keys.DELIVERY_INSTRUCTION,instruction);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickImportButton()
    {
        importButton = xpathSetter("//android.widget.TextView[@text='IMPORT']");
        myActions.action_click(importButton);
    }

    public void clickConfirmButton()
    {
        confirmButton = xpathSetter("//android.widget.TextView[@text='CONFIRM']");
        myActions.action_click(confirmButton);
    }

    /*----------Functions----------*/

    public void addParcel()
    {
        int n = random.nextInt(1000);
        enterName("Test Name ");
        enterPhone("01401122188");
        enterCash("350");
        enterSellingPrice("500");
        enterAddress("Test Address");
        enterArea();
        sleep(1000);
        System.out.println("Area List Size: " + areaList().size());
        int index = random.nextInt(areaList().size());
        selectAreaById(areaList(),index);
        enterInvoiceNumber("Test Invoice " + n);
        enterInstruction("Test Instruction");
        clickConfirmButton();
    }

    public void addParcel(String name, String phone, String cash, String sellingPrice, String address, String area,
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
        enterInstruction(instruction);
        clickConfirmButton();
    }

    public List<String> createParcelCautionMessages()
    {
        List<String> cautionMessages = new ArrayList<>();
        WebElement nameCautionMessage = xpathSetter("//android.widget.TextView[@index='3']");
        WebElement phoneCautionMessage = xpathSetter("//android.widget.TextView[@index='8']");
        WebElement cashCautionMessage = xpathSetter("//android.widget.TextView[@index='9']");
        WebElement sellingPriceCautionMessage = xpathSetter("//android.widget.TextView[@index='12']");
        WebElement addressCautionMessage = xpathSetter("//android.widget.TextView[@index='16']");
        cautionMessages.add(myActions.action_getText(nameCautionMessage));
        cautionMessages.add(myActions.action_getText(phoneCautionMessage));
        cautionMessages.add(myActions.action_getText(cashCautionMessage));
        cautionMessages.add(myActions.action_getText(sellingPriceCautionMessage));
        cautionMessages.add(myActions.action_getText(addressCautionMessage));
        return cautionMessages;
    }



    /*----------Import Parcel Module----------*/

    public class ImportParcelModule
    {
        /*----------Elements----------*/

        private WebElement backButton;

        /*----------Actions----------*/

        public void clickBackButton()
        {
            backButton = xpathSetter("//android.view.ViewGroup/android.widget.TextView[@index='0']");
            myActions.action_click(backButton);
        }
    }
}
