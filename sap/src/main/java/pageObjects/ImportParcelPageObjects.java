package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import services.serviceUtils.ShopUpPostMan;
import utils.MyActions;
import utils.SapBaseClass;

import javax.tools.Tool;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class ImportParcelPageObjects extends SapBaseClass {

    private WebDriver driver;
    private MyActions myActions;
    private DashboardPageObjects dashboardPageObjects;

    public ImportParcelPageObjects (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        myActions = new MyActions();
        dashboardPageObjects = new DashboardPageObjects(driver);
    }

    /*----------Elements----------*/

    private WebElement uploadFileButton;
    private WebElement notifyCancelClickButton;
    private WebElement selectShopInput;
    private WebElement submitParcelButton;
    private WebElement refreshButton;
    private List<WebElement> invoiceNumber;
    private List<WebElement> bulkStatus;

    /*----------Actions----------*/

    public void clickUploadFilesButton()
    {
//        uploadFileButton = xpathSetter("//button[@class='btn btn-default']");
        uploadFileButton = xpathSetter(driver,"//button[@class='btn btn-default']");
//        uploadFileButton = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
        myActions.action_click(uploadFileButton);
    }

    public void clickNotifyCancelClickButton()
    {
        try {
            new WebDriverWait(driver,2)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Later']")));
            notifyCancelClickButton = driver.findElement(By.xpath("//button[text()='Later']"));
            myActions.action_click(notifyCancelClickButton);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public List<WebElement> setInvoiceNumber()
    {
//        invoiceNumber = xpathListSetter("//div[@ng-repeat='item in parcelsModel']");
        invoiceNumber = xpathListSetter(driver,"//div[@ng-repeat='item in parcelsModel']");
        return invoiceNumber;
    }

    public void selectShop(String shopName)
    {
//        selectShopInput = xpathSetter("//form//input[@placeholder='Select Shop']");
        selectShopInput = xpathSetter(driver,"//form//input[@placeholder='Select Shop']");
//        selectShopInput = driver.findElement(By.xpath("//form//input[@placeholder='Select Shop']"));
        myActions.action_sendKeys(selectShopInput,shopName);
        sleep(1000);
        selectShopInput.sendKeys(Keys.ENTER);
    }

    public void clickSubmitParcel()
    {
//        submitParcelButton = xpathSetter("//button[@type='submit']");
        submitParcelButton = xpathSetter(driver,"//button[@type='submit']");
//        submitParcelButton = driver.findElement(By.xpath("//button[@type='submit']"));
        myActions.action_click(submitParcelButton);
    }

    public void clickRefreshButton()
    {
        refreshButton = xpathSetter(driver,"//button[@ng-click='reload()']");
//        refreshButton = driver.findElement(By.xpath("//button[@ng-click='reload()']"));
        myActions.action_click(refreshButton);
    }

    public List<WebElement > getBulkStatus()
    {
//        bulkStatus = xpathListSetter("//tr[@ng-repeat='status in bulkStatus']/td[5]//strong");
        bulkStatus = xpathListSetter(driver,"//tr[@ng-repeat='status in bulkStatus']/td[5]//strong");
//        bulkStatus = driver.findElements(By.xpath("//tr[@ng-repeat='status in bulkStatus']/td[5]//strong"));
        return bulkStatus;
    }

    /*----------Functions----------*/


    public void importParcelViaRobotClassMac (String path) throws Exception {
        clickUploadFilesButton();
        sleep(1000);

        Robot robot = new Robot();
        robot.setAutoDelay(2000);
        StringSelection stringSelection = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        robot.setAutoDelay(1000);

        robot.mouseMove(500, 500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        //Cmnd+Shift+G to Search Path
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_G);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_G);

        //Cmnd+V = Paste the Path
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_V);

        robot.setAutoDelay(1000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.setAutoDelay(1000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public List<String> getInvoiceNumber()
    {
        int i,listSize;
        String invoiceNumber;
        List<String> invoiceNumberValue = new ArrayList<String>();
        List<WebElement> invoiceNumbers = setInvoiceNumber();
        listSize = invoiceNumbers.size();
        sleep(1000);
        for(i=1;i<=listSize;i++)
        {
            invoiceNumber = xpathSetter(driver,"//div[@ng-repeat='item in parcelsModel'][" + i + "]//input[@placeholder='Invoice Number']").getAttribute("value");
//            invoiceNumber = driver.findElement(By.xpath("//div[@ng-repeat='item in parcelsModel'][" + i + "]//input[@placeholder='Invoice Number']")).getAttribute("value");
            System.out.println("Invoice Number of Parcel " + i + " is " + invoiceNumber);
            invoiceNumberValue.add(invoiceNumber);
        }
        return invoiceNumberValue;
    }


    public void verifyBulkStatusValue()
    {
        int listSize,i,count = 0;
        boolean run = true;
        WebElement status;
        while (run)
        {
            List <WebElement> bulkStatuses = getBulkStatus();
            listSize = bulkStatuses.size();
//            System.out.println("List Size : " + listSize);
            count++;

//            try {
//                new WebDriverWait(getBaseDriver(),5)
//                        .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='pending']")));
//                clickRefreshButton();
//            }catch (Exception e)
//            {
//                System.out.println(e);
//                if(e.getMessage().contains("NoSuchElementException"))
//                {
//                    run = false;
//                }
//            }

//            if(xpathSetter("//strong[text()='pending']").equals(null))
//            {
//                run = false;
//            }
//            else
//            {
//                clickRefreshButton();
//            }
            clickRefreshButton();
//            System.out.println("Run : " + run);
//            System.out.println("Loop Count : " + count);
            if(count>10)
                break;
        }
    }

    public List<String> performImportBulkParcels(String path, String shopName) throws Exception
    {
        List<String> invoiceNumberValue;

        dashboardPageObjects.clickLogisticsModule();
        dashboardPageObjects.clickImportParcelsModule();

        clickNotifyCancelClickButton();
        sleep(2000);
//        clickNotifyCancelClickButton();

        importParcelViaRobotClassMac(path);
        invoiceNumberValue = getInvoiceNumber();
        selectShop(shopName);
        clickSubmitParcel();
        verifyBulkStatusValue();
        return invoiceNumberValue;
    }
}

