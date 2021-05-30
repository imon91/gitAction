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

    /*----------Elements----------*/

    private WebElement pageTitle;
    private WebElement nameInput;
    private WebElement phoneInput;
    private WebElement addressInput;
    private WebElement invoiceNumberInput;
    private WebElement weightInput;
    private WebElement areaDropDown;
    private WebElement parcelType;
    private WebElement productCategoryDropDown;
    private List<WebElement> productCategoryDropDownOptions;
    private WebElement productCategoryDropDownOption;
    private WebElement cashInput;
    private WebElement sellingPriceInput;
    private WebElement instructionInput;
    private WebElement confirmButton;
    private WebElement importButton;

    private String[] parcelTypes = {"Fragile","Liquid"};

    /*----------Actions----------*/

    public String getPageTitle()
    {
        pageTitle = xpathSetter("//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[@index='0']/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[@index='1']");
        return myActions.action_getText(pageTitle);
    }

    public void enterName(String name)
    {
        nameInput = xpathSetter("//android.widget.EditText[@index='6']");
        myActions.action_sendKeys(nameInput,name);
        try {
            PropertyReader.setValue(PropertyReader.Keys.CUSTOMER_NAME,name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterPhone(String phone)
    {
        phoneInput = xpathSetter("//android.widget.EditText[@index='12']");
        myActions.action_sendKeys(phoneInput,phone);
        try {
            PropertyReader.setValue(PropertyReader.Keys.CUSTOMER_PHONE,phone);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterAddress(String address)
    {
        addressInput = xpathSetter("//android.widget.EditText[@index='18']");
        myActions.action_sendKeys(addressInput,address);
        try {
            PropertyReader.setValue(PropertyReader.Keys.DELIVERY_ADDRESS,address);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterInvoiceNumber(String invoiceNumber)
    {
        invoiceNumberInput = xpathSetter("//android.widget.EditText[@index='24']");
        myActions.action_sendKeys(invoiceNumberInput,invoiceNumber);
        try {
            PropertyReader.setValue(PropertyReader.Keys.INVOICE_NUMBER,invoiceNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterWeight(int weight)
    {
        weightInput = xpathSetter("//android.widget.EditText[@index='32']");
        weightInput.clear();
        myActions.action_sendKeys(weightInput,String.valueOf(weight));
    }

    public void enterArea()
    {
        areaDropDown = xpathSetter("//android.widget.EditText[@index='5']");
        myActions.action_click(areaDropDown);
    }

    public List<WebElement> districtList()
    {
        String areaXpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup";
        List<WebElement> listOfAreas = xpathListSetter(areaXpath);
//        listOfAreas.remove(0);
        return listOfAreas;
    }

    public List<WebElement> areaList()
    {
        String areaXpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup";
        List<WebElement> listOfAreas = xpathListSetter(areaXpath);
//        listOfAreas.remove(0);
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

    public void selectParcelType(String type)
    {
        System.out.println("Parcel Type : " + type);
        parcelType = xpathSetter("//android.widget.TextView[@text='" + type +"']/../android.widget.ImageView");
        myActions.action_click(parcelType);
    }

    public void clickProductCategoryDropDown()
    {
        productCategoryDropDown = xpathSetter("//android.widget.TextView[@text='Select Product Category']/../../android.widget.EditText");
        myActions.action_click(productCategoryDropDown);
    }

    public void chooseProductCategory()
    {
        clickProductCategoryDropDown();
        productCategoryDropDownOptions = xpathListSetter("//android.widget.ScrollView//android.widget.TextView");
        int size = productCategoryDropDownOptions.size();
        int index = random.nextInt(size);
        System.out.println("Size : " + size);
        System.out.println("Index : " + index);
        System.out.println("Selected Category : " + myActions.action_getText(productCategoryDropDownOptions.get(index)));
        myActions.action_click(productCategoryDropDownOptions.get(index));
    }

    public void chooseProductCategory(String category)
    {
        clickProductCategoryDropDown();
        productCategoryDropDownOption = xpathSetter("//android.widget.ScrollView//android.widget.TextView[contains(@text,'" + category + "')]");
        System.out.println("Selected Category : " + myActions.action_getText(productCategoryDropDownOption));
        myActions.action_click(productCategoryDropDownOption);
    }

    public void enterCash(String cash)
    {
        cashInput = xpathSetter("//android.widget.EditText[@index='44']");
        myActions.action_sendKeys(cashInput,cash);
        try {
            PropertyReader.setValue(PropertyReader.Keys.PARCEL_CASH,cash);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterSellingPrice(String sellingPrice)
    {
        sellingPriceInput = xpathSetter("//android.widget.EditText[@index='50']");
        myActions.action_sendKeys(sellingPriceInput,sellingPrice);
        try {
            PropertyReader.setValue(PropertyReader.Keys.PARCEL_SELLING_PRICE,sellingPrice);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void enterInstruction(String instruction)
    {
        instructionInput = xpathSetter("//android.widget.EditText[@index='56']");
        myActions.action_sendKeys(instructionInput,instruction);
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

    public void scrollIntoView()
    {
        String instructionSelector = "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\")).scrollIntoView(new UiSelector().text(\"Write instruction\"))";
        instructionInput = uiAutomatorSetter(instructionSelector);
    }

    /*----------Functions----------*/

    public void addParcel()
    {
        int n = random.nextInt(1000);
        int i = random.nextInt(2);
        System.out.println("i : " + i);
        enterName("Test Name ");
        enterPhone("01401122188");
        enterAddress("Test Address");
        enterInvoiceNumber("Test Invoice " + n);
        enterArea();
        sleep(1000);
        System.out.println("District List Size: " + districtList().size());
        int index = random.nextInt(areaList().size());
        selectAreaById(areaList(),index);
        System.out.println("Area List Size: " + areaList().size());
        index = random.nextInt(areaList().size());
        selectAreaById(areaList(),index);
        selectParcelType(parcelTypes[i]);
        scrollIntoView();
        chooseProductCategory();
        enterCash("350");
        enterSellingPrice("500");
        enterInstruction("Test Instruction");
        clickConfirmButton();
    }

    public void addParcel(String name, String phone, String cash, String sellingPrice, String address, String area,
                          String category, String invoiceNumber, String instruction)
    {
        enterName(name);
        enterPhone(phone);
        enterCash(cash);
        enterSellingPrice(sellingPrice);
        enterAddress(address);
        enterArea();
        selectAreaByText(area);
        chooseProductCategory(category);
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
