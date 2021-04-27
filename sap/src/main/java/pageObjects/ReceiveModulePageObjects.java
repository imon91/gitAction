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

public class ReceiveModulePageObjects extends SapBaseClass {

    private WebDriver driver;
    private MyActions myActions;
    private DashboardPageObjects dashboardPageObjects;
    private Actions actions;

    public ReceiveModulePageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        myActions = new MyActions();
        dashboardPageObjects = new DashboardPageObjects(driver);
        actions = new Actions(driver);
    }

    /*----------Elements----------*/

    private WebElement hubInput;
    private WebElement hubOption;
    private WebElement setHubOption;
    private WebElement notifyCancelClickButton;
    private WebElement shopNameInput;
    private WebElement selectShopParcels;
    private WebElement titleValue;
    private WebElement scanCodeInput;
    private WebElement errorMessageCloseButton;
    private WebElement sendToSortingButton;
    private WebElement viewParcelsButton;
    private List<WebElement> parcelIdList;
    private WebElement hubName;
    private WebElement isBusy;

    private WebElement scannedParcelId;


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
        sleep(1000);
        hubInput.sendKeys(Keys.ENTER);
    }

    public void clickHubOption()
    {
        hubOption = xpathSetter("//input[@ng-model='ownHubId']");
        myActions.action_click(hubOption);
    }

    public void selectHubOption(String hubName)
    {
        clickHubOption();
        setHubOption = xpathSetter("//option[@label='"+ hubName +"']");
        myActions.action_click(setHubOption);
    }

    public void selectShop(String shopName)
    {
        shopNameInput = xpathSetter("//input[@placeholder='Select shop']");
        myActions.action_click(shopNameInput);
        myActions.action_sendKeys(shopNameInput,shopName);
        sleep(3000);
        shopNameInput.sendKeys(Keys.ENTER);
    }

    public void chooseSelectShopParcels()
    {
        selectShopParcels = xpathSetter("//div[@ng-show='ownHubId'][1]/div[1]//button[text()='Parcels']");
        myActions.action_click(selectShopParcels);
    }

    public String getTitleValue()
    {
        titleValue = xpathSetter("//h3[@class='ng-binding']");
        return myActions.action_getText(titleValue);
    }

    public void enterScanCodeInput(String trackingId)
    {
        scanCodeInput = xpathSetter("//input[@placeholder='Scanned code']");
        myActions.action_sendKeys(scanCodeInput,trackingId);
        scanCodeInput.sendKeys(Keys.ENTER);
    }

    public void closeErrorMessage()
    {

        errorMessageCloseButton = xpathSetter("//button[@class='close']");
        myActions.action_click(errorMessageCloseButton);
    }

    public void clickSendToSorting()
    {
        sendToSortingButton = xpathSetter("//button[contains(text(),'SEND TO SORTING')]");
        myActions.action_click(sendToSortingButton);
    }

    public void clickViewParcels()
    {
        viewParcelsButton = xpathSetter("//div[@class='fresh-parcel'][1]//button[contains(text(),'View parcels')]");
        myActions.action_click(viewParcelsButton);
    }

    public List<WebElement> setParcelIdList()
    {
        parcelIdList = xpathListSetter(driver,"//div[@class='modal-content']//div[@class='fresh-parcel ng-scope']");
        return parcelIdList;
    }

    public WebElement setHubName()
    {
        hubName = xpathSetter("//div[@class='modal-content']//div[@class='fresh-parcel ng-scope']//h5[contains(text(),'Hub')]");
        return  hubName;
    }

    public String getScannedParcelIdValue()
    {
        scannedParcelId = xpathSetter("//section[@class='scanned-section']//div[contains(@class,'fresh-parcel')][1]//h4/small");
        return myActions.action_getText(scannedParcelId);
    }

    /*----------Functions----------*/

    public void chooseHub(String hubName)
    {
        clickHubOption();
        selectHubOption(hubName);
    }

    public void receiveSellerParcels(String shopName)
    {
        selectShop(shopName);
        chooseSelectShopParcels();
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

    public String getHubName()
    {
        WebElement hubNameValue = setHubName();
        String hubName = hubNameValue.getText().substring(5);
        return hubName;
    }

    public void clickEscViaRobotClass() throws AWTException
    {
        actions.sendKeys(Keys.ESCAPE).build().perform();
//        Robot robot = new Robot();
//        robot.delay(5000);
//        robot.keyPress(KeyEvent.VK_ESCAPE);
//        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }

    public void waitForLoading()
    {
        Boolean check = true;
        while (check)
        {
            WebDriverWait wait = new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@ng-show='!isBusy']")));
//            isBusy = xpathSetter("//div[@ng-show='!isBusy']");
            isBusy = driver.findElement(By.xpath("//div[@ng-show='!isBusy']"));
            System.out.println("isBusy Text :" + isBusy.getText() + ".");
            if(isBusy.getText().equalsIgnoreCase("0 /"))
            {
                driver.navigate().refresh();
            }
            else check = false;
        }
    }


    public List<String> performReceiveParcels(List<String> invoiceNumber, String shopName, String hubName) throws AWTException {
        int i,listSize;
        List<String> parcelIds;
        listSize = invoiceNumber.size();

        dashboardPageObjects.clickReceiveModule();

        chooseHub(hubName);
        receiveSellerParcels(shopName);
        sleep(5000);
        waitForLoading();
        for(i=0;i<listSize;i++)
        {
            enterScanCodeInput(invoiceNumber.get(i));
            closeErrorMessage();
        }
        clickViewParcels();
        parcelIds = getParcelIds();
        parcelIds.add(getHubName());
        System.out.println("Hub Name : " + parcelIds.get(parcelIds.size()-1));
        clickEscViaRobotClass();
        clickSendToSorting();
        return parcelIds;
    }
}
