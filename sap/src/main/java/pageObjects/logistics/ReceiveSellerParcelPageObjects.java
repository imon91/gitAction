package pageObjects.logistics;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import utils.*;

import java.util.*;

public class ReceiveSellerParcelPageObjects extends SapBaseClass {

    private WebDriver driver;
    private MyActions myActions;
    private Random random;

    public ReceiveSellerParcelPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        myActions = new MyActions();
        random = new Random();
    }

    /*----------Elements----------*/

    private WebElement titleValue;
    private WebElement count;
    private WebElement dropDownOption;
    private List<WebElement> parcels;

    private WebElement phoneSearchInput;
    private WebElement rejectedPhoneSearchInput;
    private WebElement invoiceIdSearchInput;

    private WebElement scannedCodeInput;
    private WebElement sendToSortingButton;

    private WebElement phoneValue;
    private WebElement trackingIdValue;
    private WebElement customerNameValue;
    private WebElement cashValue;
    private WebElement addressValue;
    private WebElement invoiceValue;
    private WebElement createdDateValue;
    private WebElement areaInput;
    private WebElement partnerDropDown;
    private List<WebElement> partnerDropDownOptions;
    private WebElement partnerValue;
    private WebElement weightInput;
    private WebElement hubValue;

    private WebElement returnButton;

    private WebElement printButton;
    private WebElement moveButton;
    private WebElement errorMessageCloseButton;

    /*----------Actions----------*/

    public void clickDropDownOption(String option)
    {
        dropDownOption = xpathSetter("//strong[text()='" + option + "']/..");
        myActions.action_click(dropDownOption);
    }

    public void clickDropDownOptionByTitle(String option)
    {
        dropDownOption = xpathSetter("//a[contains(@title,'" + option + "')]");
        myActions.action_click(dropDownOption);
    }

    public String getTitleValue()
    {
        titleValue = xpathSetter("//h3[@class='ng-binding']");
        return myActions.action_getText(titleValue);
    }

    public String getParcelsCount()
    {
        count = xpathSetter("//div[@ng-show='!isBusy']");
        String value = myActions.action_getText(count);
        return value.substring(4);
    }

    public Boolean enterPhoneSearchInput(String phone)
    {
        phoneSearchInput = xpathSetter("//input[@placeholder='Phone search']");
        myActions.action_sendKeys(phoneSearchInput,phone);
        sleep(1000);
        clickDropDownOption(phone);
        return closeErrorMessage();
    }

    public void enterRejectedPhoneSearchInput(String phone)
    {
        rejectedPhoneSearchInput = xpathSetter("//input[@placeholder='Rejected Phone search']");
        myActions.action_sendKeys(rejectedPhoneSearchInput,phone);
        sleep(1000);
        clickDropDownOption(phone);
    }


    public void enterInvoiceIdSearchInput(String invoice,String trackingId)
    {
        invoiceIdSearchInput = xpathSetter("//input[@placeholder='Invoice id search']");
        myActions.action_sendKeys(invoiceIdSearchInput,invoice);
        sleep(1000);
        clickDropDownOptionByTitle(trackingId);
        closeErrorMessage();
    }

    public void enterScanInvoiceNumberInput(String invoice)
    {
        invoiceIdSearchInput = xpathSetter("//input[@placeholder='Scan Invoice Number']");
        myActions.action_sendKeys(invoiceIdSearchInput,invoice);
        invoiceIdSearchInput.sendKeys(Keys.ENTER);
        closeErrorMessage();
    }

    public void enterScanCodeInput(String trackingId)
    {
        scannedCodeInput = xpathSetter("//input[@placeholder='Scanned code']");
        myActions.action_sendKeys(scannedCodeInput,trackingId);
        scannedCodeInput.sendKeys(Keys.ENTER);
    }

    public void enterScannedParcelIdInput(String trackingId)
    {
        scannedCodeInput = xpathSetter("//input[@placeholder='Scanned parcel id']");
        myActions.action_sendKeys(scannedCodeInput,trackingId);
        scannedCodeInput.sendKeys(Keys.ENTER);
    }

    public Boolean closeErrorMessage()
    {
        try { errorMessageCloseButton = xpathPresenceSetter("//button[@class='close']");
            myActions.action_click(errorMessageCloseButton);
            return Boolean.TRUE;
        } catch (Exception e) { System.out.println(e);
            return Boolean.FALSE;}
    }

    public void clickSendToSorting()
    {
        sendToSortingButton = xpathSetter("//button[contains(text(),'SEND TO SORTING')]");
        myActions.action_click(sendToSortingButton);
    }

    public String getParcelPhoneValue(String section,int index)
    {
        phoneValue = xpathSetter("//section[@class='" + section + "-section']//div[contains(@class,'fresh-parcel')][" + index + "]//h4");
        String value = myActions.action_getText(phoneValue);
        String[] values = value.split(" ");
        return values[0];
    }

    public String getTrackingIdValue(String section, int index)
    {
        trackingIdValue = xpathSetter("//section[@class='" + section + "-section']//div[contains(@class,'fresh-parcel')][" + index + "]//h4/small");
        return myActions.action_getText(trackingIdValue);
    }

    public String getCustomerNameValue(String section,int index)
    {
        customerNameValue = xpathSetter("//section[@class='" + section + "-section']//div[contains(@class,'fresh-parcel')][" + index + "]//p[@class='name ng-binding']");
        return myActions.action_getText(customerNameValue);
    }

    public String getCashValue(String section,int index)
    {
        cashValue = xpathSetter("//section[@class='" + section + "-section']//div[contains(@class,'fresh-parcel')][" + index + "]//p[contains(text(),'Cash')]");
        String value = myActions.action_getText(cashValue);
        return value.substring(7);
    }

    public String getAddressValue(String section,int index)
    {
        addressValue = xpathSetter("//section[@class='" + section + "-section']//div[contains(@class,'fresh-parcel')][" + index + "]//p[@class='address ng-binding'][1]");
        return myActions.action_getText(addressValue);
    }

    public String getInvoiceIdValue(String section,int index)
    {
        invoiceValue = xpathSetter("//section[@class='" + section + "-section']//div[contains(@class,'fresh-parcel')][" + index + "]//b[text()='Merchant Invoice ID:']/..");
        String value = myActions.action_getText(invoiceValue);
        return value.substring(21);
    }

    public String getCreatedDateValue(String section,int index)
    {
        createdDateValue= xpathSetter("//section[@class='" + section + "-section']//div[contains(@class,'fresh-parcel')][" + index + "]//b[text()='Created Date:']/..");
        String value = myActions.action_getText(createdDateValue);
        String[] values = value.split("\\(");
        return values[0].substring(14);
    }

    public void enterAreaInput(String section,int index,String area)
    {
        areaInput = xpathSetter("//section[@class='" + section + "-section']//div[contains(@class,'fresh-parcel')][" + index + "]//input[@placeholder='Select Area']");
        areaInput.clear();
        myActions.action_sendKeys(areaInput,area);
        clickDropDownOption(area);
        sleep(1000);
    }

    public String getAreaValue(String section,int index)
    {
        areaInput = xpathSetter("//section[@class='" + section + "-section']//div[contains(@class,'fresh-parcel')][" + index + "]//input[@placeholder='Select Area']");
        return areaInput.getAttribute("value");
    }

    public void clickPartnerDropDown(String section,int index)
    {
        partnerDropDown = xpathSetter("//section[@class='" + section + "-section']//div[contains(@class,'fresh-parcel')][" + index + "]//select");
        myActions.action_click(partnerDropDown);
    }

    public String chooseRandomPartnerDropDownOption(String section,int index)
    {
        clickPartnerDropDown(section,index);
        partnerDropDownOptions = xpathListSetter("");
        int size = partnerDropDownOptions.size();
        int option = random.nextInt(size);
        String partner = myActions.action_getText(partnerDropDownOptions.get(option));
        myActions.action_click(partnerDropDownOptions.get(option));
        return partner;
    }

    public String getPartnerValue(String section,int index)
    {
        partnerValue = xpathSetter("//section[@class='" + section + "-section']//div[contains(@class,'fresh-parcel')][" + index + "]//select/option[@selected]");
        return myActions.action_getText(partnerValue);
    }

    public void enterWeightInput(String section,int index, int weight)
    {
        weightInput = xpathSetter("//section[@class='" + section + "-section']//div[contains(@class,'fresh-parcel')][" + index + "]//div[@class='label-weight']/../input");
        weightInput.clear();
        new WebDriverWait(driver,10).until(ExpectedConditions.alertIsPresent());
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        myActions.action_sendKeys(weightInput,String.valueOf(weight));
    }

    public String getWeightValue(String section,int index)
    {
        weightInput = xpathSetter("//section[@class='" + section + "-section']//div[contains(@class,'fresh-parcel')][" + index + "]//div[@class='label-weight']/../input");
        return weightInput.getAttribute("value");
    }

    public String getHubValue(String section,int index)
    {
        hubValue = xpathSetter("//section[@class='" + section + "-section']//div[contains(@class,'fresh-parcel')][" + index + "]//h5[@class='ng-binding']");
        String value = myActions.action_getText(hubValue);
        return value.substring(5);
    }

    public void clickReturnButton(String section,int index)
    {
        returnButton = xpathSetter("//section[@class='" + section + "-section']//div[contains(@class,'fresh-parcel')][" + index + "]//button[contains(text(),'Return')]");
        myActions.action_click(returnButton);
    }

    public void clickPrintButton(int index)
    {
        myActions.action_click(xpathSetter("//section[@class='unscanned-section']//div[contains(@class,'fresh-parcel')][" + index + "]"));
        printButton = xpathSetter("//section[@class='unscanned-section']//div[contains(@class,'fresh-parcel')][" + index + "]//button[@class='print-btn']");
        myActions.action_click(printButton);
        closeErrorMessage();
    }

    public void clickMoveButton(int index)
    {
        myActions.action_click(xpathSetter("//section[@class='scanned-section']//div[contains(@class,'fresh-parcel')][" + index + "]"));
        moveButton = xpathSetter("//section[@class='scanned-section']//div[contains(@class,'fresh-parcel')][" + index + "]//button");
        myActions.action_click(moveButton);
    }

    /*----------Functions----------*/

    public void waitForLoading()
    {
        Boolean check = true;
        while (check)
        {
            WebDriverWait wait = new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@ng-show='!isBusy']")));
            count = driver.findElement(By.xpath("//div[@ng-show='!isBusy']"));
            System.out.println("isBusy Text :" + count.getText() + ".");
            if(count.getText().equalsIgnoreCase("0 /"))
            {
                driver.navigate().refresh();
            }
            else check = false;
        }
    }

    public int getIndex(String section,String trackingId)
    {
        parcels = xpathListSetter("//section[@class='" + section + "-section']//div[contains(@class,'fresh-parcel')]//small");
        int size = parcels.size();
        int index = -1;
        for(int i=0;i<size;i++)
        {
            if(myActions.action_getText(parcels.get(i)).equalsIgnoreCase(trackingId)) {
                index = i+1;
                break;
            }
        }
        return index;
    }

    /*----------Classes----------*/

    public class CreateParcelPageObjects
    {
        /*---------------Elements---------------*/

        private WebElement createNewParcelButton;
        private WebElement storeDropDown;
        private WebElement storeDropDownOption;
        private WebElement customerNameInput;
        private WebElement customerPhoneInput;
        private WebElement customerAddressInput;
        private WebElement areaInput;
        private WebElement weightInput;
        private WebElement cashInput;
        private WebElement sellingPriceInput;
        private WebElement invoiceNumberInput;
        private WebElement submitButton;

        /*---------------Actions---------------*/

        public void clickCreateNewParcelButton()
        {
            createNewParcelButton = xpathSetter("//button[text()='Create New Parcel']");
            myActions.action_click(createNewParcelButton);
        }

        public void clickStoreDropDown()
        {
            storeDropDown = xpathSetter("//div[@class='modal-content']//form//select");
            myActions.action_click(storeDropDown);
        }

        public void chooseStoreDropDownOption(String store)
        {
            clickStoreDropDown();
            storeDropDownOption = xpathSetter("//div[@class='modal-content']//form//select/option[@label='" + store + "']");
            myActions.action_click(storeDropDownOption);
        }

        public void enterCustomerNameInput(String customerName)
        {
            customerNameInput = xpathSetter("//input[@placeholder='Customer Name']");
            myActions.action_sendKeys(customerNameInput,customerName);
        }

        public void enterCustomerPhoneInput(String customerPhone)
        {
            customerPhoneInput = xpathSetter("//input[@placeholder='Customer Phone']");
            myActions.action_sendKeys(customerPhoneInput,customerPhone);
        }

        public void enterCustomerAddressInput(String customerAddress)
        {
            customerAddressInput = xpathSetter("//input[@placeholder='Customer Address']");
            myActions.action_sendKeys(customerAddressInput,customerAddress);
        }

        public void enterAreaInput(String area)
        {
            areaInput = xpathSetter("//input[@placeholder='Select Area']");
            myActions.action_sendKeys(areaInput,area);
            clickDropDownOption(area);
        }

        public void enterWeightInput(String weight)
        {
            weightInput = xpathSetter("//input[@placeholder='Weight']");
            weightInput.clear();
            myActions.action_sendKeys(weightInput,weight);
        }

        public void enterCashInput(String cash)
        {
            cashInput = xpathSetter("//input[@placeholder='Cash']");
            myActions.action_sendKeys(cashInput,cash);
        }

        public void enterSellingPriceInput(String sellingPrice)
        {
            sellingPriceInput = xpathSetter("//input[@placeholder='Product Selling Price']");
            myActions.action_sendKeys(sellingPriceInput,sellingPrice);
        }

        public void enterInvoiceInput(String invoice)
        {
            invoiceNumberInput = xpathSetter("//input[@placeholder='Merchant Invoice No']");
            myActions.action_sendKeys(invoiceNumberInput,invoice);
        }

        public void clickSubmitButton()
        {
            submitButton = xpathSetter("//button[@type='submit']");
            myActions.action_click(submitButton);
        }

        public void createParcel(String ...inputs)
        {
            clickCreateNewParcelButton();
            chooseStoreDropDownOption(inputs[0]);
            enterCustomerNameInput(inputs[1]);
            enterCustomerPhoneInput(inputs[2]);
            enterCustomerAddressInput(inputs[3]);
            enterAreaInput(inputs[4]);
            enterWeightInput(inputs[5]);
            enterCashInput(inputs[6]);
            enterSellingPriceInput(inputs[7]);
            enterInvoiceInput(inputs[8]);
            clickSubmitButton();
        }
    }

    public class MotherHubScannedParcelPageObjects
    {
        /*---------------Elements---------------*/

        private WebElement scannedParcelCount;
        private WebElement scannedParcelHub;

        private WebElement sendToSortingButton;
        private WebElement viewParcelsButton;

        private WebElement phoneValue;
        private WebElement trackingIdValue;
        private WebElement customerNameValue;
        private WebElement cashValue;
        private WebElement addressValue;
        private WebElement invoiceValue;
        private WebElement createdDateValue;
        private WebElement areaInput;
        private WebElement partnerDropDown;
        private List<WebElement> partnerDropDownOptions;
        private WebElement partnerValue;
        private WebElement weightInput;
        private WebElement hubValue;

        private WebElement moveButton;

        /*---------------Actions---------------*/

        public String getScannedParcelHubValue(int index)
        {
            scannedParcelHub = xpathSetter("//section[@class='scanned-section']//div[contains(@class,'fresh-parcel')][" + index + "]//h4");
            String value = myActions.action_getText(scannedParcelHub);
            return value.substring(5);
        }

        public String getScannedParcelCountValue(int index)
        {
            scannedParcelCount = xpathSetter("//section[@class='scanned-section']//div[contains(@class,'fresh-parcel')][" + index + "]//p");
            String value = myActions.action_getText(scannedParcelCount);
            return value.substring(14);
        }

        public void clickSendToSortingButton(int index)
        {
            sendToSortingButton = xpathSetter("//section[@class='scanned-section']//div[contains(@class,'fresh-parcel')][" + index + "]//button[contains(text(),'Send to sorting')]");
            myActions.action_click(sendToSortingButton);
        }

        public void clickViewParcelsButton(int index)
        {
            viewParcelsButton = xpathSetter("//section[@class='scanned-section']//div[contains(@class,'fresh-parcel')][" + index + "]//button[contains(text(),'View parcels')]");
            myActions.action_click(viewParcelsButton);
        }

        public String getParcelPhoneValue(int index)
        {
            phoneValue = xpathSetter("//div[@class='modal-content']//div[contains(@class,'fresh-parcel')][" + index + "]//h4");
            String value = myActions.action_getText(phoneValue);
            String[] values = value.split(" ");
            return values[0];
        }

        public String getTrackingIdValue(int index)
        {
            trackingIdValue = xpathSetter("//div[@class='modal-content']//div[contains(@class,'fresh-parcel')][" + index + "]//h4/small");
            return myActions.action_getText(trackingIdValue);
        }

        public String getCustomerNameValue(int index)
        {
            customerNameValue = xpathSetter("//div[@class='modal-content']//div[contains(@class,'fresh-parcel')][" + index + "]//p[@class='name ng-binding']");
            return myActions.action_getText(customerNameValue);
        }

        public String getCashValue(int index)
        {
            cashValue = xpathSetter("//div[@class='modal-content']//div[contains(@class,'fresh-parcel')][" + index + "]//p[contains(text(),'Cash')]");
            String value = myActions.action_getText(cashValue);
            return value.substring(7);
        }

        public String getAddressValue(int index)
        {
            addressValue = xpathSetter("//div[@class='modal-content']//div[contains(@class,'fresh-parcel')][" + index + "]//p[@class='address ng-binding'][1]");
            return myActions.action_getText(addressValue);
        }

        public String getInvoiceIdValue(int index)
        {
            invoiceValue = xpathSetter("//div[@class='modal-content']//div[contains(@class,'fresh-parcel')][" + index + "]//b[text()='Merchant Invoice ID:']/..");
            String value = myActions.action_getText(invoiceValue);
            return value.substring(21);
        }

        public void enterAreaInput(int index,String area)
        {
            areaInput = xpathSetter("//div[@class='modal-content']//div[contains(@class,'fresh-parcel')][" + index + "]//input[@placeholder='Select Area']");
            areaInput.clear();
            myActions.action_sendKeys(areaInput,area);
            clickDropDownOption(area);
            sleep(1000);
        }

        public String getAreaValue(int index)
        {
            areaInput = xpathSetter("//div[@class='modal-content']//div[contains(@class,'fresh-parcel')][" + index + "]//input[@placeholder='Select Area']");
            return areaInput.getAttribute("value");
        }

        public void clickPartnerDropDown(int index)
        {
            partnerDropDown = xpathSetter("//div[@class='modal-content']//div[contains(@class,'fresh-parcel')][" + index + "]//select");
            myActions.action_click(partnerDropDown);
        }

        public String chooseRandomPartnerDropDownOption(int index)
        {
            clickPartnerDropDown(index);
            partnerDropDownOptions = xpathListSetter("");
            int size = partnerDropDownOptions.size();
            int option = random.nextInt(size);
            String partner = myActions.action_getText(partnerDropDownOptions.get(option));
            myActions.action_click(partnerDropDownOptions.get(option));
            return partner;
        }

        public String getPartnerValue(int index)
        {
            partnerValue = xpathSetter("//div[@class='modal-content']//div[contains(@class,'fresh-parcel')][" + index + "]//select/option[@selected]");
            return myActions.action_getText(partnerValue);
        }

        public String getWeightValue(int index)
        {
            weightInput = xpathSetter("//div[@class='modal-content']//div[contains(@class,'fresh-parcel')][" + index + "]//div[@class='label-weight']/../input");
            return weightInput.getAttribute("value");
        }

        public String getHubValue(int index)
        {
            hubValue = xpathSetter("//div[@class='modal-content']//div[contains(@class,'fresh-parcel')][" + index + "]//h5[@class='ng-binding']");
            String value = myActions.action_getText(hubValue);
            return value.substring(5);
        }

        public void clickMoveButton(int index)
        {
            myActions.action_click(xpathSetter("//div[@class='modal-content']//div[contains(@class,'fresh-parcel')][" + index + "]"));
            moveButton = xpathSetter("//div[@class='modal-content']//div[contains(@class,'fresh-parcel')][" + index + "]//button");
            myActions.action_click(moveButton);
            new Actions(driver).sendKeys(Keys.ESCAPE).build().perform();
        }
    }
}
