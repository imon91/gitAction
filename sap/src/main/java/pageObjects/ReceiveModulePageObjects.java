package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import utils.*;

import java.util.*;

public class ReceiveModulePageObjects extends SapBaseClass {

    private WebDriver driver;
    private MyActions myActions;
    private Random random;

    public ReceiveModulePageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        myActions = new MyActions();
        random = new Random();
    }

    /*----------Elements----------*/

    private WebElement hubInput;

    private WebElement sellerParcelShopInput;
    private WebElement viewSellerParcelsButton;
    private WebElement hubParcelsHubInput;
    private WebElement viewHubParcelsButton;
    private WebElement viewMotherHubParcelsButton;
    private WebElement viewResellerParcelsButton;

    private WebElement agentInput;
    private WebElement motherHubReturnedParcelsButton;
    private WebElement motherHubAreaChangedParcelsButton;
    private WebElement problematicHubParcelsHubInput;
    private WebElement problematicHubReturnedParcelsButton;
    private WebElement problematicHubAreaChangedParcelsButton;
    private WebElement reversePickupShopInput;
    private WebElement partnerParcelDropDown;
    private List<WebElement> partnerParcelDropDownOptions;

    private WebElement dropDownOption;
    private WebElement titleValue;
    private WebElement backButton;

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

    public void enterHubInput(String hubName)
    {
        hubInput = xpathSetter("//input[@placeholder='Search hub']");
        hubInput.clear();
        myActions.action_sendKeys(hubInput,hubName);
        clickDropDownOption(hubName);
    }

    public String getHubFilterValue()
    {
        hubInput = xpathSetter("//input[@placeholder='Search hub']");
        return hubInput.getAttribute("value");
    }

    public void enterSellerParcelsShopInput(String shopName,int shopId)
    {
        sellerParcelShopInput = xpathSetter("//input[@placeholder='Select shop']");
        myActions.action_click(sellerParcelShopInput);
        myActions.action_sendKeys(sellerParcelShopInput,shopName);
        clickDropDownOptionByTitle(String.valueOf(shopId));
    }

    public void clickViewSellerParcelsButton()
    {
        viewSellerParcelsButton = xpathSetter("//div[@ng-show='ownHubId'][1]/div[1]//button[text()='View Parcels']");
        myActions.action_click(viewSellerParcelsButton);
        new SellerParcelPageObjects(driver).waitForLoading();
    }

    public void enterHubParcelHubInput(String hubName)
    {
        hubParcelsHubInput = xpathSetter("//div[@ng-show='ownHubId'][1]/div[2]//input[@placeholder='Choose hub']");
        myActions.action_click(hubParcelsHubInput);
        myActions.action_sendKeys(hubParcelsHubInput,hubName);
        clickDropDownOption(hubName);
    }

    public void clickViewHubParcelsButton()
    {
        viewHubParcelsButton = xpathSetter("//div[@ng-show='ownHubId'][1]/div[2]//div[not(contains(@class,'ng-hide'))]/button[@class='btn btn-primary']");
        myActions.action_click(viewHubParcelsButton);
        new HubParcelsPageObjects().waitForLoading();
    }

    public void clickViewMotherHubParcelsButton()
    {
        viewMotherHubParcelsButton = xpathSetter("//div[@ng-show='ownHubId'][1]//h3[text()='Mother hub parcels']/..//button");
        myActions.action_click(viewMotherHubParcelsButton);
        new HubParcelsPageObjects().waitForLoading();
    }

    public void clickViewResellerParcelsButton()
    {
        viewResellerParcelsButton = xpathSetter("//button[text()='View Reseller parcels']");
        myActions.action_click(viewResellerParcelsButton);
    }

    public void chooseDeliveryAgent(String agent)
    {
        agentInput = xpathSetter("//h3[text()='From Delivery Agents']/../input");
        myActions.action_sendKeys(agentInput,agent);
        clickDropDownOption(agent);
    }

    public void choosePickupAgent(String agent)
    {
        agentInput = xpathSetter("//h3[text()='From PickUp Agents']/../input");
        myActions.action_sendKeys(agentInput,agent);
        clickDropDownOption(agent);
    }

    public void clickMotherHubReturnedParcelsButton()
    {
        motherHubReturnedParcelsButton = xpathSetter("//div[@ng-show='ownHubId'][2]/div[3]/div[3]//button[contains(text(),'Returned parcels')]");
        myActions.action_click(motherHubReturnedParcelsButton);
        new ProblematicParcel().waitForLoading();
    }

    public void clickMotherHubAreaChangedParcelsButton()
    {
        motherHubAreaChangedParcelsButton = xpathSetter("//div[@ng-show='ownHubId'][2]/div[3]/div[3]//button[contains(text(),'Area Changed parcels')]");
        myActions.action_click(motherHubAreaChangedParcelsButton);
        new ProblematicParcel().waitForLoading();
    }

    public void enterProblematicHubParcelHubInput(String hubName)
    {
        problematicHubParcelsHubInput = xpathSetter("//div[@ng-show='ownHubId'][2]/div[4]//input[@placeholder='Choose hub']");
        myActions.action_click(problematicHubParcelsHubInput);
        myActions.action_sendKeys(problematicHubParcelsHubInput,hubName);
        clickDropDownOption(hubName);
    }

    public void clickViewProblematicHubReturnedParcelsButton()
    {
        problematicHubReturnedParcelsButton = xpathSetter("//div[@ng-show='ownHubId'][2]/div[4]//button[contains(text(),'Returned parcels')]");
        myActions.action_click(problematicHubReturnedParcelsButton);
        new ProblematicParcel().waitForLoading();
    }

    public void clickViewProblematicHubAreaChangedParcelsButton()
    {
        problematicHubAreaChangedParcelsButton = xpathSetter("//div[@ng-show='ownHubId'][2]/div[4]//button[contains(text(),'Area changed parcels')]");
        myActions.action_click(problematicHubAreaChangedParcelsButton);
        new ProblematicParcel().waitForLoading();
    }

    public void clickPartnerParcelDropDown()
    {
        partnerParcelDropDown = xpathSetter("//div[@ng-show='ownHubId'][2]/div[5]//select");
        myActions.action_click(partnerParcelDropDown);
    }

    public String selectPartnerParcelDropDownOption()
    {
        clickPartnerParcelDropDown();
        partnerParcelDropDownOptions = xpathListSetter("//div[@ng-show='ownHubId'][2]/div[5]//select/option");
        int size = partnerParcelDropDownOptions.size();
        int index = random.nextInt(size)+1;
        String partner = myActions.action_getText(partnerParcelDropDownOptions.get(index));
        myActions.action_click(partnerParcelDropDownOptions.get(index));
        System.out.println("Partner : " + partner);
        return partner;
    }

    public void enterReversePickupShopInput(String shopName,int shopId)
    {
        reversePickupShopInput = xpathSetter("//input[@placeholder='Choose shop']");
        myActions.action_click(reversePickupShopInput);
        myActions.action_sendKeys(reversePickupShopInput,shopName);
        clickDropDownOptionByTitle(String.valueOf(shopId));
    }

    public String getTitleValue(String tag)
    {
        titleValue = xpathSetter("//" + tag + "[@class='ng-binding']");
        return myActions.action_getText(titleValue);
    }

    public String getTitleValue()
    {
        titleValue = xpathSetter("//h3");
        return myActions.action_getText("//h3");
    }

    public String getProblematicHubParcelTitleValue()
    {
        titleValue = xpathSetter("//h3/span[not(contains(@class,'ng-hide'))]");
        return myActions.action_getText(titleValue);
    }

    public void clickBackButton()
    {
        backButton = xpathSetter("//a[@ng-click='goBack()']");
        myActions.action_click(backButton);
    }

    /*----------Functions----------*/

    public void viewSellerParcels(String shopName,int shopId)
    {
        enterSellerParcelsShopInput(shopName,shopId);
        clickViewSellerParcelsButton();
    }


    /*----------Classes----------*/

    public class HubParcelsPageObjects
    {
        /*----------Elements----------*/

        private WebElement titleValue;
        private WebElement count;

        private WebElement bulkIdValue;
        private WebElement hubValue;
        private WebElement parcelCountValue;

        private WebElement viewParcelsButton;

        /*----------Actions----------*/

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

        /*----------Functions----------*/

        public void waitForLoading()
        {
            Boolean check = true;
            while (check)
            {
                WebDriverWait wait = new WebDriverWait(driver,30);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@ng-show='!isBusy']")));
                count = driver.findElement(By.xpath("//div[@ng-show='!isBusy']"));
//                System.out.println("isBusy Text :" + count.getText() + ".");
                if(count.getText().equalsIgnoreCase("0 /"))
                {
                    driver.navigate().refresh();
                }
                else check = false;
            }
        }
    }

    public class ProblematicParcel
    {
        private WebElement count;

        /*----------Functions----------*/

        public void waitForLoading()
        {
            Boolean check = true;
            while (check)
            {
                WebDriverWait wait = new WebDriverWait(driver,30);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='panels']//div[contains(@class,'ng-binding')]")));
                sleep(2000);
                count = driver.findElement(By.xpath("//div[@class='panels']//div[contains(@class,'ng-binding')]"));
//                System.out.println("isBusy Text :" + count.getText() + ".");
                if(count.getText().equalsIgnoreCase("0 /"))
                {
                    driver.navigate().refresh();
                }
                else check = false;
            }
        }
    }

    public class ReturnedModalPageObjects
    {
        /*----------Elements----------*/

        private WebElement reasonCategoryDropDown;
        private List<WebElement> reasonCategoryDropDownOptions;
        private WebElement reasonDropDown;
        private List<WebElement> reasonDropDownOptions;
        private WebElement updateParcelButton;

        /*----------Actions----------*/

        public void clickReasonCategoryDropDown()
        {
            reasonCategoryDropDown = xpathSetter("//div[@class='modal-content']//select[1]");
            myActions.action_click(reasonCategoryDropDown);
        }

        public String chooseReasonCategoryOption()
        {
            clickReasonCategoryDropDown();
            reasonCategoryDropDownOptions = xpathListSetter("//div[@class='modal-content']//select[1]/option");
            int size = reasonCategoryDropDownOptions.size();
            int index = random.nextInt(size-1)+1;
            String reasonCategory = myActions.action_getText(reasonCategoryDropDownOptions.get(index));
            myActions.action_click(reasonCategoryDropDownOptions.get(index));
            return  reasonCategory;
        }

        public void clickReasonDropDown()
        {
            reasonDropDown = xpathSetter("//div[@class='modal-content']//select[2]");
            myActions.action_click(reasonDropDown);
        }

        public String chooseReasonDropDownOption()
        {
            clickReasonDropDown();
            reasonDropDownOptions = xpathListSetter("//div[@class='modal-content']//select[2]/option");
            int size = reasonDropDownOptions.size();
            int index = random.nextInt(size-1)+1;
            String reason = myActions.action_getText(reasonDropDownOptions.get(index));
            myActions.action_click(reasonDropDownOptions.get(index));
            return  reason;
        }

        public void clickUpdateParcelButton()
        {
            updateParcelButton = xpathSetter("//div[@class='modal-content']//button[1]");
            myActions.action_click(updateParcelButton);
        }

        /*----------Functions----------*/

        public List<String> performReturned()
        {
            List<String> reason = new ArrayList<>();
            reason.add(chooseReasonCategoryOption());
            reason.add(chooseReasonDropDownOption());
            clickUpdateParcelButton();
            return reason;
        }
    }
}
