package pageObjects.logistics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MyActions;
import utils.SapBaseClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ReceiveFromDeliveryAgentsPageObjects extends SapBaseClass {

    private WebDriver driver;
    private MyActions myActions;
    private Random random;

    public ReceiveFromDeliveryAgentsPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        myActions = new MyActions();
        random = new Random();
    }

    /*----------Elements----------*/

    private WebElement hubInput;
    private WebElement agentInput;
    private WebElement parcelsButton;

    private WebElement titleValue;
    private WebElement searchBarInput;

    private WebElement cashValue;

    private WebElement holdButton;
    private WebElement areaChangeButton;
    private WebElement returnedButton;
    private WebElement deliveredButton;
    private WebElement exchangeButton;
    private WebElement partialButton;
    private WebElement raiseIssueButton;

    private WebElement assignedParcelsValue;
    private WebElement deliveredParcelsValue;
    private WebElement scannedParcelsValue;

    private WebElement cashReceivedButton;
    private WebElement parcelReceivedButton;
    private WebElement yesButton;

    private WebElement name;

    /*----------Actions----------*/

    public void chooseHubInput(String hubName)
    {
        hubInput = xpathSetter("//input[@placeholder='Search hub']");
        if(!hubInput.getAttribute("value").equalsIgnoreCase(hubName))
        {
//            myActions.action_click(hubInput);
            hubInput.clear();
            myActions.action_sendKeys(hubInput,hubName);
            sleep(1000);
            hubInput.sendKeys(Keys.ENTER);
        }
    }

    public void chooseAgent(String agent)
    {
        agentInput = xpathSetter("//h3[text()='From Delivery Agents']/../input");
        myActions.action_sendKeys(agentInput,agent);
        sleep(2000);
        agentInput.sendKeys(Keys.ENTER);
    }

    public void clickParcelsButton()
    {
        parcelsButton = xpathSetter("//h3[text()='From Delivery Agents']/..//button[text()='Parcels']");
        myActions.action_click(parcelsButton);
        waitForLoading();
    }

    public String getTitleValue()
    {
        titleValue = xpathSetter("//h3[@class='ng-binding']");
        return myActions.action_getText(titleValue);
    }

    public void enterSearchBar(String searchTerm)
    {
        searchBarInput = xpathSetter("//section[@class='unscanned-section']//input");
        searchBarInput.clear();
        myActions.action_sendKeys(searchBarInput,searchTerm);
    }


    public String getCashValue(String trackingId)
    {
        cashValue = xpathSetter("//small[text()='" + trackingId + "']/ancestor::div[@class='fresh-parcel ng-scope']//p[contains(text(),'Cash')]");
        String value = myActions.action_getText(cashValue);
        return value.substring(7);
    }

    public void clickHoldButton(String trackingId)
    {
        holdButton = xpathSetter("//small[text()='" + trackingId + "']/ancestor::div[@class='fresh-parcel ng-scope']//div[not(contains(@class,'hide'))]/button[contains(text(),'Hold')]");
        myActions.action_click(holdButton);
    }

    public void clickAreaChangeButton(String trackingId)
    {
        areaChangeButton = xpathSetter("//small[text()='" + trackingId + "']/ancestor::div[@class='fresh-parcel ng-scope']//div[not(contains(@class,'hide'))]/button[contains(text(),'Area change')]");
        myActions.action_click(areaChangeButton);
    }

    public void clickReturnedButton(String trackingId)
    {
        returnedButton = xpathSetter("//small[text()='" + trackingId + "']/ancestor::div[@class='fresh-parcel ng-scope']//div[not(contains(@class,'hide'))]/button[contains(text(),'Returned')]");
        myActions.action_click(returnedButton);
    }

    public void clickDeliveredButton(String trackingId)
    {
        deliveredButton = xpathSetter("//small[text()='" + trackingId + "']/ancestor::div[@class='fresh-parcel ng-scope']//div[not(contains(@class,'hide'))]/button[contains(text(),'Delivered')]");
        myActions.action_click(deliveredButton);
    }

    public void clickExchangeButton(String trackingId)
    {
        exchangeButton = xpathSetter("//small[text()='" + trackingId + "']/ancestor::div[@class='fresh-parcel ng-scope']//div[not(contains(@class,'hide'))]/button[contains(text(),'Exchange')]");
        myActions.action_click(exchangeButton);
    }

    public void clickPartialButton(String trackingId)
    {
        partialButton = xpathSetter("//small[text()='" + trackingId + "']/ancestor::div[@class='fresh-parcel ng-scope']//div[not(contains(@class,'hide'))]/button[contains(text(),'Partial')]");
        myActions.action_click(partialButton);
    }

    public int getDeliveredParcelsValue()
    {
        deliveredParcelsValue = xpathSetter("//div[@class='panels']/div[2]//div[@class='header-right']/div");
        String value = myActions.action_getText(deliveredParcelsValue);
        return Integer.parseInt(value.substring(0,value.indexOf("/")-1));
    }

    public int getScannedParcelsValue()
    {
        scannedParcelsValue = xpathSetter("//div[@class='panels']/div[3]//div[@class='header-right']/div");
        String value = myActions.action_getText(scannedParcelsValue);
        return Integer.parseInt(value.substring(0,value.indexOf("/")-1));
    }

    public void clickCashReceivedButton()
    {
        cashReceivedButton = xpathSetter("//button[contains(text(),'Cash Received')]");
        myActions.action_click(cashReceivedButton);
        clickYesButton();
    }

    public void clickParcelReceivedButton()
    {
        parcelReceivedButton = xpathSetter("//button[contains(text(),'Parcel Received')]");
        myActions.action_click(parcelReceivedButton);
        clickYesButton();
    }

    public void clickYesButton()
    {
        yesButton = xpathSetter("//button[contains(text(),'Yes')]");
        myActions.action_click(yesButton);
    }

    public void waitForLoading()
    {
        int size =0;
        int count = 0;
        while(size<3)
        {
            count++;
            assignedParcelsValue = xpathSetter("//div[@class='panels']/div[1]//div[@class='header-right']/div");
            String value = myActions.action_getText(assignedParcelsValue);
            size = value.length();
//            System.out.println(value + " : " + value.length());
            if(count>20)
                break;
        }
    }

    /*----------Functions----------*/

    public String getCurrentDateTime()
    {
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String date = currentDate.format(format);
//        System.out.println("Current Date Time Actual: " + currentDate.format(formatter));
        return date;
    }

    /*----------Classes----------*/

    public class HoldModulePageObjects
    {
        /*----------Elements----------*/

        private WebElement dateInput;
        private WebElement reasonCategoryDropDown;
        private List<WebElement> reasonCategoryDropDownOptions;
        private WebElement reasonDropDown;
        private List<WebElement> reasonDropDownOptions;
        private WebElement holdParcelButton;
        private WebElement closeButton;

        /*----------Actions----------*/

        public void clickReasonCategoryDropDown()
        {
            reasonCategoryDropDown = xpathSetter("//div[@class='modal-content']//div[@class='row']/select[1]");
            myActions.action_click(reasonCategoryDropDown);
        }

        public String chooseReasonCategoryOption()
        {
            clickReasonCategoryDropDown();
            reasonCategoryDropDownOptions = xpathListSetter("//div[@class='modal-content']//div[@class='row']/select[1]/option");
            int size = reasonCategoryDropDownOptions.size();
            int index = random.nextInt(size-1)+1;
            String reasonCategory = myActions.action_getText(reasonCategoryDropDownOptions.get(index));
            myActions.action_click(reasonCategoryDropDownOptions.get(index));
            return  reasonCategory;
        }

        public void clickReasonDropDown()
        {
            reasonDropDown = xpathSetter("//div[@class='modal-content']//div[@class='row']/select[2]");
            myActions.action_click(reasonDropDown);
        }

        public String chooseReasonDropDownOption()
        {
            clickReasonDropDown();
            reasonDropDownOptions = xpathListSetter("//div[@class='modal-content']//div[@class='row']/select[2]/option");
            int size = reasonDropDownOptions.size();
            int index = random.nextInt(size-1)+1;
            String reason = myActions.action_getText(reasonDropDownOptions.get(index));
            myActions.action_click(reasonDropDownOptions.get(index));
            return  reason;
        }

        public void clickHoldParcelButton()
        {
            holdParcelButton = xpathSetter("//div[@class='modal-content']//button[contains(text(),'Hold parcel')]");
            myActions.action_click(holdParcelButton);
        }

        public List<String> performHoldParcel(String trackingId)
        {
            List<String> reason = new ArrayList<>();
            System.out.println("Performing Hold Parcel for " + trackingId);
            enterSearchBar(trackingId);
            clickHoldButton(trackingId);
            reason.add(chooseReasonCategoryOption());
            reason.add(chooseReasonDropDownOption());
            clickHoldParcelButton();
            return reason;
        }
    }

    public class AreaChangeModulePageObjects
    {
        /*----------Elements----------*/

        private WebElement areaInput;
        private WebElement addressInput;
        private WebElement updateParcelButton;

        /*----------Actions----------*/

        public void enterAreaInput(String area)
        {
            areaInput = xpathSetter("//input[@placeholder='Select Area']");
            areaInput.clear();
            myActions.action_sendKeys(areaInput,area);
            sleep(2000);
            areaInput.sendKeys(Keys.ENTER);
        }

        public void enterAddressInput(String address)
        {
            addressInput = xpathSetter("//div[@class='ui-control-wrap']/textarea");
            addressInput.clear();
            myActions.action_sendKeys(addressInput,address);
        }

        public void clickUpdateParcelButton()
        {
            updateParcelButton = xpathSetter("//button[contains(text(),'Update Parcel')]");
            myActions.action_click(updateParcelButton);
        }

        /*----------Functions----------*/

        public void performAreaChange(String ...inputs)
        {
            String trackingId = inputs[0];
            String area = inputs[1];
            System.out.println("Performing Area Change for Parcel " + trackingId);
            enterSearchBar(trackingId);
            clickAreaChangeButton(trackingId);
            enterAreaInput(area);
            if(inputs.length>2)
                enterAddressInput(inputs[2]);
            clickUpdateParcelButton();
        }
    }

    public class ReturnedModulePageObjects
    {
        /*----------Elements----------*/

        private WebElement reasonCategoryDropDown;
        private List<WebElement> reasonCategoryDropDownOptions;
        private WebElement reasonDropDown;
        private List<WebElement> reasonDropDownOptions;
        private WebElement updateParcelButton;
        private WebElement closeButton;

        /*----------Actions----------*/

        public void clickReasonCategoryDropDown()
        {
            reasonCategoryDropDown = xpathSetter("//div[@class='modal-content']//div[@class='row']/select[1]");
            myActions.action_click(reasonCategoryDropDown);
        }

        public String chooseReasonCategoryOption()
        {
            clickReasonCategoryDropDown();
            reasonCategoryDropDownOptions = xpathListSetter("//div[@class='modal-content']//div[@class='row']/select[1]/option");
            int size = reasonCategoryDropDownOptions.size();
            int index = random.nextInt(size-1)+1;
            String reasonCategory = myActions.action_getText(reasonCategoryDropDownOptions.get(index));
            myActions.action_click(reasonCategoryDropDownOptions.get(index));
            return  reasonCategory;
        }

        public void clickReasonDropDown()
        {
            reasonDropDown = xpathSetter("//div[@class='modal-content']//div[@class='row']/select[2]");
            myActions.action_click(reasonDropDown);
        }

        public String chooseReasonDropDownOption()
        {
            clickReasonDropDown();
            reasonDropDownOptions = xpathListSetter("//div[@class='modal-content']//div[@class='row']/select[2]/option");
            int size = reasonDropDownOptions.size();
            int index = random.nextInt(size-1)+1;
            String reason = myActions.action_getText(reasonDropDownOptions.get(index));
            myActions.action_click(reasonDropDownOptions.get(index));
            return  reason;
        }

        public void clickUpdateParcelButton()
        {
            updateParcelButton = xpathSetter("//div[@class='modal-content']//button[contains(text(),'Update Parcel')]");
            myActions.action_click(updateParcelButton);
        }

        /*----------Functions----------*/

        public List<String> performReturned(String trackingId)
        {
            List<String> reason = new ArrayList<>();
            System.out.println("Performing Return Parcel for " + trackingId);
            enterSearchBar(trackingId);
            clickReturnedButton(trackingId);
            reason.add(chooseReasonCategoryOption());
            reason.add(chooseReasonDropDownOption());
            clickUpdateParcelButton();
            return reason;
        }
    }

    public class DeliveredModulePageObjects
    {
        /*----------Elements----------*/

        private WebElement modalTitle;
        private WebElement otpInput;
        private WebElement confirmButton;

        /*----------Actions----------*/

        public void enterOtpInput(String otp)
        {
            otpInput = xpathPresenceSetter("//div[@class='ui-control-wrap']/input");
            myActions.action_sendKeys(otpInput,otp);
        }

        public void clickConfirmButton()
        {
            confirmButton = xpathPresenceSetter("//button[contains(text(),'Confirm')]");
            myActions.action_click(confirmButton);
        }

        /*----------Functions----------*/

        public void performDelivered(String trackingId)
        {
            System.out.println("Performing Deliver Parcel for " + trackingId);
            int d1 = getDeliveredParcelsValue();
            enterSearchBar(trackingId);
            clickDeliveredButton(trackingId);
            if(d1==getDeliveredParcelsValue())
            {
                enterOtpInput("1234");
                clickConfirmButton();
            }
//            try{
//                new WebDriverWait(driver,2)
//                        .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body']//h4")));
//                System.out.println("Try");
//                enterOtpInput("1234");
//                clickConfirmButton();
//            } catch (Exception e)
//            {
//                System.out.println("Catch");
//                System.out.println("Exception : " + e);
//            }
        }
    }

    public class ExchangeModalPageObjects
    {
        private WebElement exchangeWithoutDeliveredInput;
        private WebElement trackingIdValue;
        private WebElement submitButton;

        public void clickExchangeWithoutDeliveredInput()
        {
            exchangeWithoutDeliveredInput = xpathSetter("//div[@class='modal-body']//div[@class='radio radio-warning'][2]");
            myActions.action_click(exchangeWithoutDeliveredInput);
        }

        public String getTrackingIdValue()
        {
            trackingIdValue = xpathSetter("//input[@placeholder='New Parcel ID']");
            return trackingIdValue.getAttribute("value");
        }

        public void clickSubmitButton()
        {
            submitButton = xpathSetter("//div[@class='modal-body']//button[@type='submit']");
            myActions.action_click(submitButton);
        }
    }

    public class PartialModulePageObjects
    {
        /*----------Elements----------*/

        private WebElement partialButton;
        private WebElement modalTitle;
        private WebElement amountInput;
        private WebElement saveButton;

        /*----------Actions----------*/

        public void clickPartialButton(String trackingId)
        {
            partialButton = xpathSetter("//small[text()='" + trackingId + "']/ancestor::div[@class='fresh-parcel ng-scope']//div[not(contains(@class,'hide'))]/button[contains(text(),'Partial')]");
            myActions.action_click(partialButton);
        }

        public String getModalTitleValue()
        {
            modalTitle = xpathSetter("//div[@class='modal-content']//span");
            return myActions.action_getText(modalTitle);
        }

        public void enterAmountInput(String amount)
        {
            amountInput = xpathSetter("//div[@class='modal-content']//input");
            myActions.action_sendKeys(amountInput,amount);
        }

        public void clickSaveButton()
        {
            saveButton = xpathSetter("//div[@class='modal-content']//button[contains(text(),'Save')]");
            myActions.action_click(saveButton);
            sleep(2000);
        }

        /*----------Functions----------*/
    }

    public class UnScannedSectionPageObjects
    {
        private WebElement trackingId;
        private WebElement name;
        private WebElement cash;

        public String getTrackingIdValue(int index)
        {
            trackingId = xpathSetter("//div[2]//section[@class='unscanned-section']//div[contains(@class,'fresh-parcel')][" + index + "]//small");
            return myActions.action_getText(trackingId);
        }

        public String getNameValue(int index)
        {
            name = xpathSetter("//div[2]//section[@class='unscanned-section']//div[contains(@class,'fresh-parcel')][" + index + "]//p[contains(@class,'name')]");
            return myActions.action_getText(name);
        }

        public String getCashValue(int index)
        {
            cash = xpathSetter("//section[@class='unscanned-section']//div[contains(@class,'fresh-parcel')][" + index + "]//p[contains(text(),'Cash')]");
            String value = myActions.action_getText(cash);
            return value.substring(7);
        }
    }

    public class ScannedSectionPageObjects
    {
        private WebElement trackingId;
        private WebElement name;
        private WebElement status;
        private WebElement cash;

        public String getTrackingIdValue(int index)
        {
            trackingId = xpathSetter("//section[@class='scanned-section']//div[contains(@class,'fresh-parcel')][" + index + "]//small");
            return myActions.action_getText(trackingId);
        }

        public String getNameValue(int index)
        {
            name = xpathSetter("//section[@class='scanned-section']//div[contains(@class,'fresh-parcel')][" + index + "]//p[contains(@class,'name')]");
            return myActions.action_getText(name);
        }

        public String getStatusValue(int index)
        {
            status = xpathSetter("//section[@class='scanned-section']//div[contains(@class,'fresh-parcel')][" + index + "]//p[contains(@class,'status')]");
            return myActions.action_getText(status);
        }

        public String getCashValue(int index)
        {
            cash = xpathSetter("//section[@class='scanned-section']//div[contains(@class,'fresh-parcel')][" + index + "]//p[contains(text(),'Cash')]");
            String value = myActions.action_getText(cash);
            System.out.println("Cash Value : " + value);
            return value.substring(7);
        }
    }
}
