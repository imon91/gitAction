package pageObjects.logistics;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import utils.*;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ReceiveDeliveryAgentsParcelPageObjects extends SapBaseClass {

    private WebDriver driver;
    private MyActions myActions;
    private Random random;

    public ReceiveDeliveryAgentsParcelPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        myActions = new MyActions();
        random = new Random();
    }

    /*----------Elements----------*/

    private WebElement titleValue;
    private WebElement searchBarInput;
    private WebElement problematicStatusDropDown;
    private WebElement problematicStatusDropDownOption;
    private String[] problematicStatuses = {"Return","Hold","Area","All"};

    private WebElement assignedParcelsValue;
    private WebElement deliveredParcelsValue;
    private WebElement scannedParcelsValue;

    private WebElement parcel;
    private WebElement dropDownOption;

    private WebElement printButton;

    private WebElement modalTitle;
    private WebElement modalMsg;
    private WebElement modalCloseButton;

    private WebElement expectedCashValue;
    private WebElement cashReceivedValue;

    private WebElement cashReceivedButton;
    private WebElement parcelReceivedButton;
    private WebElement yesButton;

    /*----------Actions----------*/

    public String getTitleValue()
    {
        titleValue = xpathSetter("//h3[@class='ng-binding']");
        return myActions.action_getText(titleValue);
    }

    public void enterSearchBar(String section, String searchTerm)
    {
        searchBarInput = xpathSetter("//section[@class='" + section + "-section']//input");
        searchBarInput.clear();
        myActions.action_sendKeys(searchBarInput,searchTerm);
    }

    public int[] getAssignedParcelsValue()
    {
        assignedParcelsValue = xpathSetter("//div[@class='panels']/div[1]//div[@class='header-right']/div");
        String value = myActions.action_getText(assignedParcelsValue);
        int[] values = {Integer.parseInt(value.substring(0,value.indexOf("/")-1)),Integer.parseInt(value.substring(value.indexOf("/")+2))};
        return values;
    }

    public int[] getDeliveredParcelsValue()
    {
        deliveredParcelsValue = xpathSetter("//div[@class='panels']/div[2]//div[@class='header-right']/div");
        String value = myActions.action_getText(deliveredParcelsValue);
        int[] values = {Integer.parseInt(value.substring(0,value.indexOf("/")-1)),Integer.parseInt(value.substring(value.indexOf("/")+2))};
        return values;
    }

    public int[] getProblematicParcelsValue()
    {
        scannedParcelsValue = xpathSetter("//div[@class='panels']/div[3]//div[@class='header-right']/div");
        String value = myActions.action_getText(scannedParcelsValue);
        int[] values = {Integer.parseInt(value.substring(0,value.indexOf("/")-1)),Integer.parseInt(value.substring(value.indexOf("/")+2))};
        return values;
    }

    public void clickParcel(String section,int index)
    {
        parcel = xpathSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'" + section + "')][" + index + "]");
        myActions.action_click(parcel);
    }

    public void clickDropDownOptionByTitle(String option)
    {
        dropDownOption = xpathSetter("//a[@title='" + option.trim() + "']");
        myActions.action_click(dropDownOption);
    }

    public String getModalTitle()
    {
        modalTitle = xpathSetter("//div[@class='modal-content']//span[@class='ng-binding']");
        return myActions.action_getText(modalTitle);
    }

    public String getModalMsg()
    {
        modalMsg = xpathSetter("//div[@class='modal-content']//div[@ng-bind-html='msg']");
        return myActions.action_getText(modalMsg);
    }

    public void clickModalCloseButton()
    {
        modalCloseButton = xpathSetter("//button[@class='close']");
        myActions.action_click(modalCloseButton);
    }

    public void clickProblematicStatusDropDown()
    {
        problematicStatusDropDown = xpathSetter("//select[@ng-model='problematicStatusesModel']");
        myActions.action_click(problematicStatusDropDown);
    }

    public void chooseProblematicStatusDropDownOption(String option)
    {
        System.out.println("Status : " + option);
        clickProblematicStatusDropDown();
        problematicStatusDropDownOption = xpathSetter("//select[@ng-model='problematicStatusesModel']/option[@label='" + option + "']");
        myActions.action_click(problematicStatusDropDownOption);
    }

    public String chooseProblematicStatusDropDownOption()
    {
        int index = random.nextInt(2);
        String status = problematicStatuses[index];
        chooseProblematicStatusDropDownOption(status);
        return status;
    }

    public int getCashReceivedValue()
    {
        cashReceivedValue = xpathSetter("//div[@class='receiving-footer']//h5[contains(text(),'Cash Received')]");
        String value = myActions.action_getText(cashReceivedValue);
        return Integer.parseInt(value.substring(16));
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

    public void clickPrintButton(String section,int index)
    {
        printButton = xpathSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'" + section + "')][" + index + "]//button[contains(@ng-click,'print')]");
        myActions.action_click(printButton);
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

    public class RaiseIssueModalPageObjects
    {
        private WebElement raiseIssueButton;
        private WebElement issueTypeTitle;
        private List<WebElement> issueTypes;
        private WebElement agentInput;
        private WebElement descriptionInput;
        private WebElement raiseIssueSubmitButton;

        public void clickRaiseIssueButton(String section,int index)
        {
            clickParcel(section,index);
            raiseIssueButton = xpathSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'" + section + "')][" + index + "]//button[contains(@ng-click,'raiseIssue')]");
            myActions.action_click(raiseIssueButton);
        }

        public String getModalTitle()
        {
            issueTypeTitle = xpathSetter("//div[@class='modal-body']//h4/span[not(contains(@class,'hide'))]");
            System.out.println(myActions.action_getText(issueTypeTitle));
            return myActions.action_getText(issueTypeTitle);
        }

        public void enterAgentInput(String agentName)
        {
            myActions.action_click(xpathSetter("//input[@placeholder='Select Agent']/.."));
            agentInput = xpathSetter("//input[@placeholder='Select Agent']");
            myActions.action_sendKeys(agentInput,agentName);
            sleep(1000);
            agentInput.sendKeys(Keys.ENTER);
        }

        public void enterDescriptionInput(String input)
        {
            descriptionInput = xpathSetter("//div[@class='modal-body']//textarea");
            myActions.action_sendKeys(descriptionInput,input);
        }

        public void clickRaiseIssueSubmitButton()
        {
            raiseIssueSubmitButton = xpathSetter("//div[@class='modal-body']//button[@type='submit']");
            myActions.action_click(raiseIssueSubmitButton);
        }

        public void performRaiseIssue(String section,String trackingId,String agentName)
        {
            System.out.println("Performing Raise Issue for " + trackingId);
            switch (section) {
                case "unassigned":
                    enterSearchBar("unscanned",trackingId);
                    break;
                case "delivered":
                    break;
                case "problematic":
                    enterSearchBar("scanned",trackingId);
                    break;
            }
            clickRaiseIssueButton(section,1);
            String title;
            do {
                issueTypes = xpathListSetter("//div[@class='issue-tree']/div");
                int issues = issueTypes.size();
                int issue = random.nextInt(issues);
                myActions.action_click(issueTypes.get(issue));
                title = getModalTitle();
            } while (title.equalsIgnoreCase("Select an Issue Type"));
            enterAgentInput(agentName);
            enterDescriptionInput("Test");
            clickRaiseIssueSubmitButton();
        }
    }

    public class HoldModalPageObjects
    {
        /*----------Elements----------*/

        private WebElement holdButton;
        private WebElement dateInput;
        private WebElement reasonCategoryDropDown;
        private List<WebElement> reasonCategoryDropDownOptions;
        private WebElement reasonDropDown;
        private List<WebElement> reasonDropDownOptions;
        private WebElement holdParcelButton;
        private WebElement closeButton;

        /*----------Actions----------*/

        public void clickHoldButton(String section,int index)
        {
            holdButton = xpathSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'" + section + "')][" + index + "]//button[contains(text(),'Hold')]");
            myActions.action_click(holdButton);
        }

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

        public List<String> performHoldParcel(String section, String trackingId, Boolean isCtAgent)
        {
            List<String> reason = new ArrayList<>();
            System.out.println("Performing Hold Parcel for " + trackingId);
            switch (section) {
                case "unassigned":
                    enterSearchBar("unscanned",trackingId);
                    clickHoldButton(section,1);
                    break;
                case "delivered":
                    int index = new ParcelDetailsPageObjects().getIndexValue(section,trackingId);
                    clickParcel(section,index);
                    clickHoldButton(section,index);
                    if(!isCtAgent)
                        return null;
                    break;
                case "problematic":
                    enterSearchBar("scanned",trackingId);
                    clickHoldButton(section,1);
                    if(!isCtAgent)
                        return null;
                    break;
            }
            reason.add(chooseReasonCategoryOption());
            reason.add(chooseReasonDropDownOption());
            clickHoldParcelButton();
            return reason;
        }
    }

    public class AreaChangeModalPageObjects
    {
        /*----------Elements----------*/

        private WebElement areaChangeButton;
        private WebElement areaInput;
        private WebElement addressInput;
        private WebElement closeButton;
        private WebElement updateParcelButton;

        /*----------Actions----------*/

        public void clickAreaChangeButton(String section,int index)
        {
            areaChangeButton = xpathSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'" + section + "')][" + index + "]//button[contains(text(),'Area change')]");
            myActions.action_click(areaChangeButton);
        }

        public void enterAreaInput(String area)
        {
            areaInput = xpathSetter("//input[@placeholder='Select Area']");
            areaInput.clear();
            myActions.action_sendKeys(areaInput,area);
            sleep(2000);
            clickDropDownOptionByTitle(area);
        }

        public void enterAddressInput(String address)
        {
            addressInput = xpathSetter("//div[@class='ui-control-wrap']/textarea");
            addressInput.clear();
            myActions.action_sendKeys(addressInput,address);
        }

        public void clickCloseButton()
        {
            closeButton = xpathSetter("//button[contains(text(),'Close')]");
            myActions.action_click(closeButton);
            try{
                new WebDriverWait(driver,2).until(ExpectedConditions.invisibilityOf(closeButton));
            } catch (Exception e){
                System.out.println(e);
                new Actions(driver).sendKeys(Keys.ESCAPE).build().perform();
            }
        }

        public void clickUpdateParcelButton()
        {
            updateParcelButton = xpathSetter("//button[contains(text(),'Update Parcel')]");
            myActions.action_click(updateParcelButton);
        }

        public void waitForLoading() {
            System.out.println("Waiting For Loading");
            new WebDriverWait(driver,10).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[contains(text(),'Update Parcel')]")));
            System.out.println("Loaded");
        }

        /*----------Functions----------*/

        public void performAreaChange(String section,String trackingId,String area)
        {
            System.out.println("Performing Area Change for Parcel " + trackingId);
            switch (section) {
                case "unassigned":
                    enterSearchBar("unscanned",trackingId);
                    clickAreaChangeButton(section,1);
                    break;
                case "delivered":
                    int index = new ParcelDetailsPageObjects().getIndexValue(section,trackingId);
                    clickParcel(section,index);
                    clickAreaChangeButton(section,index);
                    break;
                case "problematic":
                    enterSearchBar("scanned",trackingId);
                    clickAreaChangeButton(section,1);
                    break;
            }
            enterAreaInput(area);
            clickUpdateParcelButton();
        }
    }

    public class ReturnedModalPageObjects
    {
        /*----------Elements----------*/

        private WebElement returnedButton;
        private WebElement reasonCategoryDropDown;
        private List<WebElement> reasonCategoryDropDownOptions;
        private WebElement reasonDropDown;
        private List<WebElement> reasonDropDownOptions;
        private WebElement updateParcelButton;
        private WebElement closeButton;

        /*----------Actions----------*/

        public void clickReturnedButton(String section,int index)
        {
            returnedButton = xpathSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'" + section + "')][" + index + "]//button[contains(text(),'Returned')]");
            myActions.action_click(returnedButton);
        }

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

        public List<String> performReturned(String section,String trackingId, Boolean isCtAgent)
        {
            List<String> reason = new ArrayList<>();
            System.out.println("Performing Return Parcel for " + trackingId);
            switch (section) {
                case "unassigned":
                    enterSearchBar("unscanned",trackingId);
                    clickReturnedButton(section,1);
                    break;
                case "delivered":
                    int index = new ParcelDetailsPageObjects().getIndexValue(section,trackingId);
                    clickParcel(section,index);
                    clickReturnedButton(section,index);
                    if(!isCtAgent)
                        return null;
                    break;
                case "problematic":
                    enterSearchBar("scanned",trackingId);
                    clickReturnedButton(section,1);
                    if(!isCtAgent)
                        return null;
                    break;
            }
            reason.add(chooseReasonCategoryOption());
            reason.add(chooseReasonDropDownOption());
            clickUpdateParcelButton();
            return reason;
        }
    }

    public class DeliveredModalPageObjects
    {
        /*----------Elements----------*/

        private WebElement modalTitle;
        private WebElement deliveredButton;
        private WebElement otpInput;
        private WebElement confirmButton;

        /*----------Actions----------*/

        public void clickDeliveredButton(String section,int index)
        {
            deliveredButton = xpathSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'" + section + "')][" + index + "]//button[contains(text(),'Delivered')]");
            myActions.action_click(deliveredButton);
        }

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

        public void performDelivered(String section,String trackingId, Boolean isCtAgent)
        {
            System.out.println("Performing Deliver Parcel for " + trackingId);
            int cash,index = 1;
            switch (section) {
                case "unassigned":
                    enterSearchBar("unscanned",trackingId);
                    break;
                case "delivered":
                    new ParcelDetailsPageObjects().getIndexValue(section,trackingId);
                    clickParcel(section,index);
                    break;
                case "problematic":
                    enterSearchBar("scanned",trackingId);
                    break;
            }
            cash = Integer.parseInt(new ParcelDetailsPageObjects().getCashValue(section,index));
            System.out.println("Cash Value : " + cash);
            clickDeliveredButton(section,index);
            if ((cash==0)&&(section.equalsIgnoreCase("unassigned")||isCtAgent)) {
                enterOtpInput("1234");
                clickConfirmButton();
            }
        }
    }

    public class ExchangeModalPageObjects
    {
        private WebElement exchangeButton;
        private WebElement exchangeRadioInput;
        private WebElement deliveredTrackingId;
        private WebElement trackingIdInput;
        private WebElement submitButton;

        public void clickExchangeButton(String section,int index)
        {
            exchangeButton = xpathSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'" + section + "')][" + index + "]//button[contains(text(),'Exchange')]");
            myActions.action_click(exchangeButton);
        }

        public void chooseExchangeRadioInput(int input)
        {
            exchangeRadioInput = xpathSetter("//div[@class='modal-body']//div[@class='radio radio-warning'][" + input + "]");
            myActions.action_click(exchangeRadioInput);
        }

        public void enterDeliveredTrackingId(String trackingId)
        {
            deliveredTrackingId = xpathSetter("//input[@placeholder='Delivered Parcel ID']");
            myActions.action_sendKeys(deliveredTrackingId,trackingId);
        }

        public String getTrackingIdInput()
        {
            trackingIdInput = xpathSetter("//input[@placeholder='New Parcel ID']");
            return trackingIdInput.getAttribute("value");
        }

        public void clickSubmitButton()
        {
            submitButton = xpathSetter("//div[@class='modal-body']//button[@type='submit']");
            myActions.action_click(submitButton);
            new WebDriverWait(driver,10).until(ExpectedConditions.invisibilityOf(submitButton));
            sleep(1000);
        }

        public void performExchangeWithDeliveredParcel(String section,int index,String trackingId, Boolean isCtAgent)
        {
            clickExchangeButton(section,index);
            if (section.equalsIgnoreCase("unassigned")||isCtAgent) {
                chooseExchangeRadioInput(1);
                enterDeliveredTrackingId(trackingId);
                clickSubmitButton();
            }
        }

        public void performExchangeWithoutDeliveredParcel(String section,int index, Boolean isCtAgent)
        {
            clickExchangeButton(section,index);
            if (section.equalsIgnoreCase("unassigned")||isCtAgent) {
                chooseExchangeRadioInput(2);
                clickSubmitButton();
            }
        }
    }

    public class PartialModalPageObjects
    {
        /*----------Elements----------*/

        private WebElement partialButton;
        private WebElement modalTitle;
        private WebElement amountInput;
        private WebElement saveButton;

        /*----------Actions----------*/

        public void clickPartialButton(String section,int index)
        {
            partialButton = xpathSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'" + section + "')][" + index + "]//button[contains(text(),'Partial')]");
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
            new WebDriverWait(driver,10).until(ExpectedConditions.invisibilityOf(saveButton));
            sleep(1000);
        }

        /*----------Functions----------*/

        public void performPartial(String section,int index, String amount, Boolean isCtAgent)
        {
            clickPartialButton(section,index);
            if (section.equalsIgnoreCase("unassigned")||isCtAgent) {
                enterAmountInput(amount);
                clickSaveButton();
            }
        }
    }

    public class ParcelDetailsPageObjects
    {
        private List<WebElement> parcels;
        private WebElement phoneValue;
        private WebElement trackingIdValue;
        private WebElement nameValue;
        private WebElement cashValue;
        private WebElement deliveryTypeValue;
        private WebElement deliveryAttemptsValue;
        private WebElement addressValue;
        private WebElement statusValue;
        private WebElement areaValue;
        private WebElement hubValue;
        private WebElement partnerValue;
        private WebElement deliveryDateValue;
        private WebElement reasonValue;

        public int getIndexValue(String section,String trackingId)
        {
            System.out.println("Tracking Id : " + trackingId);
            parcels = xpathListSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'" + section + "')]//small");
            int size = parcels.size();
            for(int i=0;i<size;i++) {
                if(myActions.action_getText(parcels.get(i)).equalsIgnoreCase(trackingId))
                    return i+1;
            }
            return -1;
        }

        public String getPhoneValue(String  section,int index)
        {
            phoneValue = xpathSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'" + section + "')][" + index + "]//h4[contains(@class,'phone')]");
            String value = myActions.action_getText(phoneValue);
            return value.substring(0,value.length()-14);
        }


        public String getTrackingIdValue(String  section,int index)
        {
            trackingIdValue = xpathSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'" + section + "')][" + index + "]//small");
            return myActions.action_getText(trackingIdValue);
        }

        public String getNameValue(String  section,int index)
        {
            nameValue = xpathSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'" + section + "')][" + index + "]//p[contains(@class,'name')]");
            return myActions.action_getText(nameValue);
        }

        public String getCashValue(String  section,int index)
        {
            cashValue = xpathSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'" + section + "')][" + index + "]//p[contains(text(),'Cash')]");
            String value = myActions.action_getText(cashValue);
            return value.substring(7);
        }

        public String getDeliveryTypeValue(String  section,int index)
        {
            deliveryTypeValue = xpathSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'" + section + "')][" + index + "]//p[contains(@class,'red')]");
            String value = myActions.action_getText(deliveryTypeValue);
            return value.substring(1,value.length()-1);
        }

        public String getDeliveryAttemptsValue(String  section,int index)
        {
            deliveryAttemptsValue = xpathSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'" + section + "')][" + index + "]//h5[contains(text(),'attempts')]");
            String value = myActions.action_getText(deliveryAttemptsValue);
            return value.substring(19);
        }

        public String getAddressValue(String  section,int index)
        {
            addressValue = xpathSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'" + section + "')][" + index + "]//p[contains(@class,'address')]");
            return myActions.action_getText(addressValue);
        }

        public String getStatusValue(String  section,int index)
        {
            statusValue = xpathSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'" + section + "')][" + index + "]//p[contains(@class,'status')]");
            return myActions.action_getText(statusValue);
        }

        public String getAreaValue(String  section,int index)
        {
            areaValue = xpathSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'" + section + "')][" + index + "]//h5[contains(text(),'Area')]");
            return myActions.action_getText(areaValue).substring(6);
        }

        public String getHubValue(String  section,int index)
        {
            hubValue = xpathSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'" + section + "')][" + index + "]//h5[contains(text(),'Hub')]");
            return myActions.action_getText(hubValue).substring(5);
        }

        public String getPartnerValue(String  section,int index)
        {
            partnerValue = xpathSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'" + section + "')][" + index + "]//h5[contains(text(),'Partner')]");
            return myActions.action_getText(partnerValue);
        }

        public String getDeliveryDateValue(String  section,int index)
        {
            deliveryDateValue = xpathSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'" + section + "')][" + index + "]//p[contains(text(),'Delivery Date')]");
            return myActions.action_getText(deliveryDateValue);
        }

        public String getReasonValue(String  section,int index)
        {
            reasonValue = xpathSetter("//div[@class='fresh-parcel ng-scope'][contains(@ng-repeat,'" + section + "')][" + index + "]//p[contains(@ng-if,'pc.status=')][contains(text(),'(')]");
            return myActions.action_getText(reasonValue);
        }
    }
}
