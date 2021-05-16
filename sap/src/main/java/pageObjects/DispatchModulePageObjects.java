package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MyActions;
import utils.SapBaseClass;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DispatchModulePageObjects extends SapBaseClass {

    private WebDriver driver;
    private MyActions myActions;
    private DashboardPageObjects dashboardPageObjects;
    private Actions actions;

    public DispatchModulePageObjects (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        myActions = new MyActions();
        dashboardPageObjects = new DashboardPageObjects(driver);
        actions = new Actions(driver);
    }

    /*----------Elements----------*/

    private WebElement notifyCancelClickButton;
    private WebElement hubInput;
    private WebElement hubOption;
    private WebElement setHubOption;
    private WebElement dispatchToSubHub;
    private WebElement dispatchToSubHubParcels;
    private List<WebElement> leftPanelViewParcels;
    private List<WebElement> modalParcelId;
    private WebElement scanBulkIdInput;
    private WebElement isBusy;


    /*----------Actions----------*/

    public void clickNotifyCancelClickButton()
    {
        notifyCancelClickButton = xpathSetter("//button[text()='Later']");
        myActions.action_click(notifyCancelClickButton);
    }

    public void enterHubInput(String hubName)
    {
        hubInput = xpathSetter("//input[@placeholder='Search hub']");
        hubInput.clear();
        myActions.action_sendKeys(hubInput,hubName);
        hubInput.sendKeys(Keys.ENTER);
    }

    public void clickHubOption()
    {
        hubOption = xpathSetter("//select[@ng-model='ownHubId']");
        myActions.action_click(hubOption);
    }

    public void selectHubOption(String hubName)
    {
        clickHubOption();
        setHubOption = xpathSetter("//option[@label='"+ hubName +"']");
        myActions.action_click(setHubOption);
    }

    public void chooseDispatchToSubHub(String hubName)
    {
        dispatchToSubHub = xpathSetter("//div[@ng-if='ownHubId && !ownHub.isVirtual']//input[@placeholder='Choose hub']");
        myActions.action_click(dispatchToSubHub);
        myActions.action_sendKeys(dispatchToSubHub,hubName);
        sleep(1000);
        dispatchToSubHub.sendKeys(Keys.ENTER);
    }

    public void clickDispatchToSubHubParcels()
    {
        dispatchToSubHubParcels = xpathSetter("//div[@ng-show='ownHubId === mainHubId && chosenHub.id']/button[contains(text(),'Parcels')]");
        myActions.action_click(dispatchToSubHubParcels);
    }

    public List<WebElement> setViewParcels()
    {
        leftPanelViewParcels = xpathListSetter("//div[@class='left-panel']//div[@class='fresh-parcel ng-scope']");
        return leftPanelViewParcels;
    }

    public List<WebElement> setParcelIdList()
    {
        modalParcelId = xpathListSetter("//div[@class='modal-content']//div[@class='fresh-parcel ng-scope']");
        return modalParcelId;
    }

    public void scanBulkId(String bulkIdValue)
    {
        scanBulkIdInput = xpathSetter("//input[@placeholder='Scan bulk id']");
        myActions.action_click(scanBulkIdInput);
        myActions.action_sendKeys(scanBulkIdInput,bulkIdValue);
        scanBulkIdInput.sendKeys(Keys.ENTER);
    }

    /*----------Functions----------*/

    public void chooseHub(String hubName)
    {
        clickHubOption();
        selectHubOption(hubName);
    }

    public String selectBulkParcel(List<String> parcelIds) throws AWTException {
        List<WebElement> bulkParcels = setViewParcels();
        WebElement bulkParcel;
        WebElement bulkId;
        String bulkIdValue = new String();
        int listSize = bulkParcels.size();
        int i,index=0;
        for(i=1;i<=listSize;i++)
        {
            bulkParcel = xpathSetter("//div[@class='left-panel']//div[@class='fresh-parcel ng-scope'][" + i + "]//button[contains(text(),'View Parcels')]");
            myActions.action_click(bulkParcel);
            List<String> parcelId = getParcelIds();
            if((parcelId.size()==parcelIds.size())&&(parcelId.containsAll(parcelIds))&&(parcelIds.containsAll(parcelId)))
            {
                bulkId = xpathSetter("//div[@class='modal-content']//h4//strong");
                bulkIdValue = myActions.action_getText(bulkId);
                index = i;
                break;
            }
            else System.out.println("Parcels Not Found in Bulk Parcel " + i);
        }
        System.out.println("Bulk Id Value = " + bulkIdValue + " at Index " + index);
        return bulkIdValue;
    }

    public List<String> getParcelIds()
    {
        int i,listSize;
        String parcelIdList;
        List<String> parcelId = new ArrayList<String>();
        List<WebElement> parcelIds = setParcelIdList();
        listSize = parcelIds.size();
        System.out.println("List Size : " + listSize);
        for(i=1;i<=listSize;i++)
        {
            System.out.println("i : " + i);
            parcelIdList = xpathSetter("//div[@class='modal-content']//div[@class='fresh-parcel ng-scope']["+ i +"]//small[@class='ng-binding']").getText();
            System.out.println("Parcel Id of Parcel " + (i) + " is " + parcelIdList);
            parcelId.add(parcelIdList);
        }
        return parcelId;
    }

    public void clickEscViaRobotClass() throws AWTException
    {
        actions.sendKeys(Keys.ESCAPE).build().perform();
//        Robot robot = new Robot();
//        robot.delay(5000);
//        robot.keyPress(KeyEvent.VK_ESCAPE);
//        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }

    public void checkLoading()
    {
        Boolean check = true;
        while (check)
        {
            WebDriverWait wait = new WebDriverWait(driver,60);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@ng-show='!isBusy']")));
            isBusy = xpathSetter("//div[@ng-show='!isBusy']");
            if(isBusy.getText().equalsIgnoreCase("0 /"))
            {
                driver.navigate().refresh();
            }
            else check = false;
        }
    }

    public String performDispatchParcels(List<String> parcelIds, String hubName) throws AWTException
    {
        String bulkIdValue = new String();
        String subHubName = parcelIds.get(parcelIds.size()-1);
        parcelIds.remove(parcelIds.size()-1);

        System.out.println("parcelIds : " + parcelIds);
        System.out.println("Sub Hub Name : " + subHubName);

        dashboardPageObjects.clickDispatchModule();

        chooseHub(hubName);
        chooseDispatchToSubHub(subHubName);
        clickDispatchToSubHubParcels();
        checkLoading();
        bulkIdValue = selectBulkParcel(parcelIds);
        clickEscViaRobotClass();

        return bulkIdValue;
    }

    public class DispatchAgentPageObjects
    {
        /*----------Elements----------*/

        private WebElement parcelsButton;
        private WebElement titleValue;
        private WebElement scanParcelInput;
        private WebElement selectAgent;
        private WebElement selectAgentOption;
        private WebElement assignedParcelsValue;
        private WebElement showParcelsButton;
        private WebElement skipQrScanButton;
        private WebElement dispatchAgentButton;

        private WebElement trackingIdValue;

        /*----------Actions----------*/

        public void clickParcelsButton()
        {
            parcelsButton = xpathSetter("//button[contains(@href,'dispatch-agent/')]");
            myActions.action_click(parcelsButton);
        }

        public String getTitleValue()
        {
            titleValue = xpathSetter("//h3");
            return myActions.action_getText("//h3");
        }

        public void clickSelectAgent()
        {
            selectAgent = xpathSetter("//select[@ng-model='selectedAgent']");
            myActions.action_click(selectAgent);
        }

        public void selectAgentOption(String agentName)
        {
            clickSelectAgent();
            selectAgentOption = xpathSetter("//option[@label='"+ agentName +"']");
            myActions.action_click(selectAgentOption);
        }

        public void enterScanParcelInput(String trackingId)
        {
            scanParcelInput = xpathSetter("//input[@placeholder='Scan Parcel ID']");
            myActions.action_sendKeys(scanParcelInput,trackingId);
            scanParcelInput.sendKeys(Keys.ENTER);
        }

        public String getAssignedParcelsValue(String agentName)
        {
            assignedParcelsValue = xpathSetter("//h4[contains(text(),'" + agentName + "')][1]");
            String value = myActions.action_getText(assignedParcelsValue);
            System.out.println("Assigned Parcels : " + value);
            return value.substring(agentName.length()+3);
        }

        public void clickShowParcelsButton(String agentName)
        {
            showParcelsButton = xpathSetter("//h4[contains(text(),'" + agentName + "')]/../..//button");
            myActions.action_click(showParcelsButton);
        }

        public void clickSkipQrScanButton()
        {
            skipQrScanButton = xpathSetter("//button[contains(text(),'Skip QR scan')]");
            myActions.action_click(skipQrScanButton);
            new WebDriverWait(driver,10).until(ExpectedConditions.invisibilityOf(skipQrScanButton));
        }

        public void clickDispatchAgentButton()
        {
            dispatchAgentButton = xpathSetter("//button[contains(text(),'Dispatch agent')]");
            myActions.action_click(dispatchAgentButton);
        }

        public String getTrackingIdValue(int index)
        {
            trackingIdValue = xpathSetter("//div[@class='modal-content']//div[contains(@class,'fresh-parcel')][" + index + "]//small");
            return myActions.action_getText(trackingIdValue);
        }

        public Boolean isScanned(int index)
        {
            return xpathSetter("//div[@class='modal-content']//div[contains(@class,'fresh-parcel')][" + index + "]//h5[@class='agent-qr-scan-status']").isDisplayed();
        }
        
        /*----------Functions----------*/
    }
}
