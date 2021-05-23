package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import utils.*;

import java.util.*;

public class PickupModulePageObjects extends SapBaseClass {

    private WebDriver driver;
    private MyActions myActions;
    private Random random;

    private String[] statuses = {"All Statuses","Pending","Confirmed","PickedUp","Failed","Cancelled"};

    public PickupModulePageObjects (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        myActions = new MyActions();
        random = new Random();
    }

    /*----------Elements----------*/

    private WebElement hubFilterDropDown;
    private WebElement hubFilterDropDownOption;

    private WebElement statusFilterDropDown;
    private WebElement statusFilterDropDownOption;

    private WebElement agentFilterDropDown;
    private WebElement agentFilterDropDownOption;

    private WebElement agentDropDown;
    private WebElement agentDropDownOption;
    private WebElement manageAgentsButton;

    private WebElement shopsFilter;
    private WebElement shopsFilterValue;

    private WebElement downloadButton;
    private WebElement createPickupButton;

    private WebElement pickupPointsValue;

    /*----------Actions----------*/

    public void clickHubFilterDropDown()
    {
        hubFilterDropDown = xpathSetter("//select[contains(@ng-options,'hub')]");
        myActions.action_click(hubFilterDropDown);
    }

    public void selectHubFilter(String hubName)
    {
        clickHubFilterDropDown();
        hubFilterDropDownOption = xpathSetter("//select[contains(@ng-options,'hub')]/option[@label='" + hubName + "']");
        myActions.action_click(hubFilterDropDownOption);
    }

    public void clickStatusFilterDropDown()
    {
        statusFilterDropDown = xpathSetter("//select[contains(@ng-options,'status')]");
        myActions.action_click(statusFilterDropDown);
    }

    public void selectStatusFilter(String status)
    {
        System.out.println("Status : " + status);
        clickStatusFilterDropDown();
        statusFilterDropDownOption = xpathSetter("//select[contains(@ng-options,'status')]/option[@label='" + status + "']");
        myActions.action_click(statusFilterDropDownOption);
    }

    public String selectStatusFilter()
    {
        String status = statuses[random.nextInt(statuses.length)];
        selectStatusFilter(status);
        return status;
    }

    public void clickAgentFilterDropDown()
    {
        agentFilterDropDown = xpathSetter("//div[@class='row']//select[contains(@ng-options,'agent')]");
        myActions.action_click(agentFilterDropDown);
    }

    public void selectAgentFilter(String agentName)
    {
        clickAgentFilterDropDown();
        agentFilterDropDownOption = xpathSetter("//div[@class='row']//select[contains(@ng-options,'agent')]/option[@label='" + agentName + "']");
        myActions.action_click(agentFilterDropDownOption);
    }

    public void clickAgentDropDown()
    {
        agentDropDown = xpathSetter("//div[@class='row ng-scope']//select[contains(@ng-options,'agent')]");
        myActions.action_click(agentDropDown);
    }

    public void selectAgent(String agentName)
    {
        clickAgentDropDown();
        agentDropDownOption = xpathSetter("//div[@class='row ng-scope']//select[contains(@ng-options,'agent')]/option[@label='" + agentName + "']");
        myActions.action_click(agentDropDownOption);
        sleep(5000);
    }

    public void clickManageAgentsButton()
    {
        manageAgentsButton = xpathSetter("//div[@class='row ng-scope']//a[@href='/agent/management']");
        myActions.action_click(manageAgentsButton);
    }

    public void clickShopsFilter()
    {
        shopsFilter = xpathSetter("//span[@id='enabled']");
        myActions.action_click(shopsFilter);
    }

    public String getShopsFilterValue()
    {
        shopsFilterValue = xpathSetter("//span[@class='ng-scope']");
        return myActions.action_getText(shopsFilterValue);
    }

    public void clickDownloadButton()
    {
        downloadButton = xpathSetter("//button[contains(@ng-click,'download')]");
        myActions.action_click(downloadButton);
    }

    public void clickCreatePickupButton()
    {
        createPickupButton = xpathSetter("//button[contains(@ng-click,'createPickUp')]");
        myActions.action_click(createPickupButton);
    }

    public int getPickupPointsValue()
    {
        pickupPointsValue = xpathSetter("//h3");
        String value = myActions.action_getText(pickupPointsValue);
        return Integer.parseInt(value.substring(16,17));
    }

    /*----------Classes----------*/

    public class CreatePickupPageObjects
    {
        /*----------Elements----------*/

        private WebElement modalTitle;
        private WebElement shopInput;
        private WebElement storeDropDown;
        private WebElement storeDropDownOption;
        private WebElement parcelCountInput;
        private WebElement closeButton;
        private WebElement createPickupButton;

        /*----------Actions----------*/

        public String getModalTitle()
        {
            modalTitle = xpathSetter("//div[@class='modal-body']//strong");
            return myActions.action_getText(modalTitle);
        }

        public void enterShopInput(String shopName)
        {
            System.out.println("Shop Name : " + shopName);
            sleep(5000);
            shopInput = xpathSetter("//input[@placeholder='Select Shop']");
            myActions.action_click(shopInput);
            myActions.action_sendKeys(shopInput,shopName);
            sleep(2000);
            shopInput.sendKeys(Keys.ENTER);
        }

        public void clickStoreDropDown()
        {
            storeDropDown = xpathSetter("//select[contains(@ng-options,'store')]");
            myActions.action_click(storeDropDown);
        }

        public void selectStore(String store)
        {
            System.out.println("Store : " + store);
            clickStoreDropDown();
            storeDropDownOption = xpathSetter("//select[contains(@ng-options,'store')]/option[@label='" + store + "']");
            myActions.action_click(storeDropDownOption);
        }

        public void enterParcelCountInput(int count)
        {
            System.out.println("Parcel Count : " + count);
            parcelCountInput = xpathSetter("//input[@placeholder='Parcel Count']");
            myActions.action_sendKeys(parcelCountInput, String.valueOf(count));
        }

        public void clickCloseButton()
        {
            closeButton = xpathSetter("//button[text()='Close']");
            myActions.action_click(closeButton);
        }

        public void clickCreatePickupButton()
        {
            createPickupButton = xpathSetter("//button[contains(@ng-click,'createPickup')]");
            myActions.action_click(createPickupButton);
        }

        /*----------Functions----------*/

        public void createPickup(String shopName,String storeName,int count)
        {
            System.out.println("Creating Pickup");
            enterShopInput(shopName);
            selectStore(storeName);
            enterParcelCountInput(count);
            clickCreatePickupButton();
            sleep(5000);
        }
    }

    public class PickupDetailsPageObjects
    {
        /*----------Elements----------*/

        private WebElement selectPickup;
        private WebElement shopNameValue;
        private WebElement storeDetailsValue;
        private WebElement phoneAddressDetailsValue;
        private WebElement changeButton;
        private WebElement agentNameValue;
        private WebElement parcelCountValue;
        private WebElement parcelPickedUpCountValue;
        private WebElement scannedParcelCountValue;
        private WebElement unScannedParcelCountValue;
        private WebElement requestTypeValue;
        private WebElement failedReasonValue;
        private WebElement remarksValue;
        private WebElement statusValue;
        private WebElement createdAtValue;

        private WebElement cancelButton;
        private WebElement confirmButton;
        private WebElement pickedUpButton;

        /*----------Actions----------*/

        public void clickSelectPickup(int index)
        {
            selectPickup = xpathSetter("//tbody/tr[" + index + "]//input[@type='checkbox']");
            myActions.action_click(selectPickup);
        }

        public String getShopNameValue(int index)
        {
            shopNameValue = xpathSetter("//tbody/tr[" + index + "]//td[2]");
            String value = myActions.action_getText(shopNameValue);
            value = getSplitString(value,"\n",0);
            return value;
        }

        public String getShopDetailsValue(int index,int line)
        {
            storeDetailsValue = xpathSetter("//tbody/tr[" + index + "]//td[3]");
            String value = myActions.action_getText(storeDetailsValue);
            value = getSplitString(value,"\n",line);
            return value;
        }

        public String getAreaAddressPhoneValue(int index,int line)
        {
            phoneAddressDetailsValue = xpathSetter("//tbody/tr[" + index + "]//td[4]");
            String value = myActions.action_getText(phoneAddressDetailsValue);
            value = getSplitString(value,"\n",line);
            return value;
        }

        public String getAgentNameValue(int index)
        {
            agentNameValue = xpathSetter("//tbody/tr[" + index + "]//td[5]");
            String value = myActions.action_getText(agentNameValue);
            return value;
        }

        public String getParcelCountValue(int index)
        {
            parcelCountValue = xpathSetter("//tbody/tr[" + index + "]//td[6]");
            String value = myActions.action_getText(parcelCountValue);
            return value;
        }

        public String getParcelPickedUpCountValue(int index)
        {
            parcelPickedUpCountValue = xpathSetter("//tbody/tr[" + index + "]//td[7]");
            String value = myActions.action_getText(parcelPickedUpCountValue);
            return value;
        }

        public String getScannedParcelCountValue(int index)
        {
            scannedParcelCountValue = xpathSetter("//tbody/tr[" + index + "]//td[8]");
            String value = myActions.action_getText(scannedParcelCountValue);
            return value;
        }

        public String getUnScannedParcelCountValue(int index)
        {
            unScannedParcelCountValue = xpathSetter("//tbody/tr[" + index + "]//td[9]");
            String value = myActions.action_getText(unScannedParcelCountValue);
            return value;
        }

        public String getRequestTypeValue(int index)
        {
            requestTypeValue = xpathSetter("//tbody/tr[" + index + "]//td[10]");
            String value = myActions.action_getText(requestTypeValue);
            return value;
        }

        public String getFailedReasonValue(int index)
        {
            failedReasonValue = xpathSetter("//tbody/tr[" + index + "]//td[11]");
            String value = myActions.action_getText(failedReasonValue);
            return value;
        }

        public String getRemarksValue(int index)
        {
            remarksValue = xpathSetter("//tbody/tr[" + index + "]//td[12]");
            String value = myActions.action_getText(remarksValue);
            return value;
        }

        public String getStatusValue(int index)
        {
            statusValue = xpathSetter("//tbody/tr[" + index + "]//td[13]");
            String value = myActions.action_getText(statusValue);
            return value;
        }

        public String getCreatedAtValue(int index)
        {
            createdAtValue = xpathSetter("//tbody/tr[" + index + "]//td[14]");
            String value = myActions.action_getText(createdAtValue);
            return value;
        }

        /*----------Functions----------*/

        public String getSplitString(String text,String splitTerm,int index)
        {
            String[] splitString = text.split(splitTerm);
            System.out.println("Split String : " + Arrays.toString(splitString));
            return splitString[index];
        }

        public void assignAgent(int index,String agentName)
        {
            clickSelectPickup(index);
            selectAgent(agentName);
        }
    }

    public class ActionsPageObjects
    {
        /*----------Elements----------*/

        private WebElement confirmButton;

        private WebElement pickedUpButton;
        private WebElement countInput;

        private WebElement cancelButton;
        private WebElement reasonCategoryDropDown;
        private WebElement reasonCategoryDropDownOption;
        private WebElement reasonDropDown;
        private List<WebElement> reasonDropDownOption;
        private WebElement updatePickupButton;

        /*----------Actions----------*/

        public void clickConfirmButton(int index)
        {
            confirmButton = xpathSetter("//tbody/tr[" + index + "]//td[15]/button[contains(text(),'Confirm')]");
            myActions.action_click(confirmButton);
            sleep(2000);
        }

        public void clickCancelButton(int index)
        {
            cancelButton = xpathSetter("//tbody/tr[" + index + "]//td[15]/button[contains(text(),'Cancel')]");
            myActions.action_click(cancelButton);
        }

        public void clickPickedUpButton(int index)
        {
            pickedUpButton = xpathSetter("//tbody/tr[" + index + "]//td[15]/button[contains(text(),'Picked Up')]");
            myActions.action_click(pickedUpButton);
        }

        public void enterCountInput(int count)
        {
            countInput = xpathSetter("//input[@name='pickup-count']");
            myActions.action_sendKeys(countInput,String.valueOf(count));
        }

        public void selectReasonCategoryDropDown()
        {
            reasonCategoryDropDown = xpathSetter("//div[@class='modal-body']//select[1]");
            myActions.action_click(reasonCategoryDropDown);
            reasonCategoryDropDownOption = xpathSetter("//div[@class='modal-body']//select[1]/option[@label='General']");
            myActions.action_click(reasonCategoryDropDownOption);
        }

        public void clickReasonDropDown()
        {
            reasonDropDown = xpathSetter("//div[@class='modal-body']//select[2]");
            myActions.action_click(reasonDropDown);
        }

        public String selectReasonDropDownOption()
        {
            clickReasonDropDown();
            reasonDropDownOption = xpathListSetter("//div[@class='modal-body']//select[2]/option");
            int options = reasonDropDownOption.size();
            int index = random.nextInt(options-1)+1;
            myActions.action_click(reasonDropDownOption.get(index));
            String reason = myActions.action_getText(reasonDropDownOption.get(index));
            System.out.println("Reason : " + reason);
            return reason;
        }

        public void clickUpdatePickup()
        {
            updatePickupButton = xpathSetter("//div[@class='modal-body']//button[contains(text(),'Update')]");
            myActions.action_click(updatePickupButton);
            sleep(2000);
        }

        /*----------Functions----------*/

        public void performPickedUp(int index,int count)
        {
            clickPickedUpButton(index);
            enterCountInput(count);
            clickUpdatePickup();
        }

        public String performCancelPickup(int index)
        {
            String reason;
            clickCancelButton(index);
            selectReasonCategoryDropDown();
            reason = selectReasonDropDownOption();
            clickUpdatePickup();
            return reason;
        }
    }
}
