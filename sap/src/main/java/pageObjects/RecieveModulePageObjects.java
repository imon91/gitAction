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
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class RecieveModulePageObjects  extends SapBaseClass {

    private WebDriver driver;
    private MyActions myActions;
    private DashboardPageObjects dashboardPageObjects;
    private Actions actions;

    public RecieveModulePageObjects (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        myActions = new MyActions();
        dashboardPageObjects = new DashboardPageObjects(driver);
        actions = new Actions(driver);
    }

    /*----------Elements----------*/

    private WebElement hubOption;
    private WebElement setHubOption;
    private WebElement notifyCancelClickButton;
    private WebElement shopNameInput;
    private WebElement selectShopParcels;
    private WebElement scanInvoiceNumber;
    private WebElement errorMessageCloseButton;
    private WebElement sendToSortingButton;
    private WebElement viewParcelsButton;
    private List<WebElement> parcelIdList;
    private WebElement hubName;
    private WebElement isBusy;


    /*----------Actions----------*/

    public void clickNotifyCancelClickButton()
    {
        notifyCancelClickButton = xpathSetter("//button[text()='Later']");
        myActions.action_click(notifyCancelClickButton);
    }

    public void clickHubOption()
    {
//        hubOption = xpathSetter("//select[@ng-model='ownHubId']");
        hubOption = xpathSetter(driver,"//select[@ng-model='ownHubId']");
//        hubOption = driver.findElement(By.xpath("//select[@ng-model='ownHubId']"));
        myActions.action_click(hubOption);
    }

    public void selectHubOption(String hubName)
    {
        clickHubOption();
//        setHubOption = xpathSetter("//option[@label='"+ hubName +"']");
        setHubOption = xpathSetter(driver,"//option[@label='"+ hubName +"']");
//        setHubOption = driver.findElement(By.xpath("//option[@label='" + hubName + "']"));
        myActions.action_click(setHubOption);
    }

    public void selectShop(String shopName)
    {
//        shopNameInput = xpathSetter("//input[@placeholder='Select shop']");
        shopNameInput = xpathSetter(driver,"//input[@placeholder='Select shop']");
//        shopNameInput = driver.findElement(By.xpath("//input[@placeholder='Select shop']"));
        myActions.action_click(shopNameInput);
        myActions.action_sendKeys(shopNameInput,shopName);
        sleep(3000);
        shopNameInput.sendKeys(Keys.ENTER);
    }

    public void chooseSelectShopParcels()
    {
//        selectShopParcels = xpathSetter("//div[@ng-show='ownHubId'][1]/div[1]//button[text()='Parcels']");
        selectShopParcels = xpathSetter(driver,"//div[@ng-show='ownHubId'][1]/div[1]//button[text()='Parcels']");
//        selectShopParcels = driver.findElement(By.xpath("//div[@ng-show='ownHubId'][1]/div[1]//button[text()='Parcels']"));
        myActions.action_click(selectShopParcels);
    }

    public void enterScanInvoiceNumber(String invoiceNumber)
    {
//        scanInvoiceNumber = xpathSetter("//input[@placeholder='Scan Invoice Number']");
        scanInvoiceNumber = xpathSetter(driver,"//input[@placeholder='Scan Invoice Number']");
//        scanInvoiceNumber = driver.findElement(By.xpath("//input[@placeholder='Scan Invoice Number']"));
        myActions.action_sendKeys(scanInvoiceNumber,invoiceNumber);
        scanInvoiceNumber.sendKeys(Keys.ENTER);
    }

    public void closeErrorMessage()
    {
//        errorMessageCloseButton = xpathSetter("//button[@class='close']");
        errorMessageCloseButton = xpathSetter(driver,"//button[@class='close']");
//        errorMessageCloseButton = driver.findElement(By.xpath("//button[@class='close']"));
        myActions.action_click(errorMessageCloseButton);
    }

    public void clickSendToSorting()
    {
//        sendToSortingButton = xpathSetter("//div[@class='fresh-parcel'][1]//button[contains(text(),'Send to sorting')]");
        sendToSortingButton = xpathSetter(driver,"//div[@class='fresh-parcel'][1]//button[contains(text(),'Send to sorting')]");
//        sendToSortingButton = driver.findElement(By.xpath("//div[@class='fresh-parcel'][1]//button[contains(text(),'Send to sorting')]"));
        myActions.action_click(sendToSortingButton);
    }

    public void clickViewParcels()
    {
//        viewParcelsButton = xpathSetter("//div[@class='fresh-parcel'][1]//button[contains(text(),'View parcels')]");
        viewParcelsButton = xpathSetter(driver,"//div[@class='fresh-parcel'][1]//button[contains(text(),'View parcels')]");
//        viewParcelsButton = driver.findElement(By.xpath("//div[@class='fresh-parcel'][1]//button[contains(text(),'View parcels')]"));
        myActions.action_click(viewParcelsButton);
    }

    public List<WebElement> setParcelIdList()
    {
//            parcelIdList = xpathListSetter("//div[@class='modal-content']//div[@class='fresh-parcel ng-scope']");
        parcelIdList = xpathListSetter(driver,"//div[@class='modal-content']//div[@class='fresh-parcel ng-scope']");
//        parcelIdList = driver.findElements(By.xpath("//div[@class='modal-content']//div[@class='fresh-parcel ng-scope']"));
        return parcelIdList;
    }

    public WebElement setHubName()
    {
//        hubName = xpathSetter("//div[@class='modal-content']//div[@class='fresh-parcel ng-scope']//h5[contains(text(),'Hub')]");
        hubName = xpathSetter(driver,"//div[@class='modal-content']//div[@class='fresh-parcel ng-scope']//h5[contains(text(),'Hub')]");
//        hubName = driver.findElement(By.xpath("//div[@class='modal-content']//div[@class='fresh-parcel ng-scope']//h5[contains(text(),'Hub')]"));
        return  hubName;
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
//            parcelIdList = xpathSetter("//div[@class='modal-content']//div[@class='fresh-parcel ng-scope']["+ i +"]//small[@class='ng-binding']").getText();
            parcelIdList = xpathSetter(driver,"//div[@class='modal-content']//div[@class='fresh-parcel ng-scope']["+ i +"]//small[@class='ng-binding']").getText();
//            parcelIdList = driver.findElement(By.xpath("//div[@class='modal-content']//div[@class='fresh-parcel ng-scope']["+ i +"]//small[@class='ng-binding']")).getText();
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

    public void checkLoading()
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

        dashboardPageObjects.clickRecieveModule();

        chooseHub(hubName);
        receiveSellerParcels(shopName);
        sleep(5000);
        checkLoading();
        for(i=0;i<listSize;i++)
        {
            enterScanInvoiceNumber(invoiceNumber.get(i));
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
