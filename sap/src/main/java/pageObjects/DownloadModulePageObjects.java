package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;
import utils.SapBaseClass;

import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;

public class DownloadModulePageObjects extends SapBaseClass {

    private WebDriver driver;
    private MyActions myActions;
    private DashboardPageObjects dashboardPageObjects;

    public DownloadModulePageObjects (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        myActions = new MyActions();
        dashboardPageObjects = new DashboardPageObjects(driver);
    }

    /*----------Elements----------*/

    private WebElement notifyCancelClickButton;
    private WebElement bulkIdSearchBar;
    private WebElement runSheetIdSearchBar;
    private WebElement bulkIdValue;
    private WebElement runSheetValue;
    private WebElement actionValue;
    private WebElement pdfDownloadButton;

    /*----------Actions----------*/

    public void clickNotifyCancelClickButton()
    {
//        notifyCancelClickButton = xpathSetter("//button[text()='Later']");
        notifyCancelClickButton = driver.findElement(By.xpath("//button[text()='Later']"));
        myActions.action_click(notifyCancelClickButton);
    }

    public void searchByBulkId(String bulkId)
    {
//        bulkIdSearchBar = xpathSetter("//input[@placeholder='Search by Bulk Transfer ID']");
        bulkIdSearchBar = xpathSetter(driver,"//input[@placeholder='Search by Bulk Transfer ID']");
//        bulkIdSearchBar = driver.findElement(By.xpath("//input[@placeholder='Search by Bulk Transfer ID']"));
        myActions.action_click(bulkIdSearchBar);
        myActions.action_sendKeys(bulkIdSearchBar,bulkId);
    }

    public void searchByRunSheetId(String runSheetId)
    {
//        runSheetIdSearchBar = xpathSetter("//input[@placeholder='Search by Runsheet ID']");
        runSheetIdSearchBar = xpathSetter(driver,"//input[@placeholder='Search by Runsheet ID']");
//        runSheetIdSearchBar = driver.findElement(By.xpath("//input[@placeholder='Search by Runsheet ID']"));
        myActions.action_click(runSheetIdSearchBar);
        myActions.action_sendKeys(runSheetIdSearchBar,runSheetId);
        runSheetIdSearchBar.sendKeys(Keys.ENTER);
    }

    public String getRunSheetValue()
    {
//        runSheetValue = xpathSetter("//td[@class='ng-binding'][1]");
        runSheetValue = xpathSetter(driver,"//td[@class='ng-binding'][1]");
//        runSheetValue = driver.findElement(By.xpath("//td[@class='ng-binding'][1]"));
        return myActions.action_getText(runSheetValue);
    }

    public String getBulkIdValue()
    {
//        bulkIdValue = xpathSetter("//td[@class='ng-binding'][2]");
        bulkIdValue = xpathSetter(driver,"//td[@class='ng-binding'][2]");
//        bulkIdValue = driver.findElement(By.xpath("//td[@class='ng-binding'][2]"));
        return myActions.action_getText(bulkIdValue);
    }

    public String getActionValue()
    {
//        actionValue = xpathSetter("//td[@class='ng-binding'][3]");
        actionValue = xpathSetter(driver,"//td[@class='ng-binding'][3]");
//        actionValue = driver.findElement(By.xpath("//td[@class='ng-binding'][3]"));
        return myActions.action_getText(actionValue);
    }

    public void clickPdfDownloadButton()
    {
//        pdfDownloadButton = xpathSetter("//button[contains(text(),'PDF Download')]");
        pdfDownloadButton = xpathSetter(driver,"//button[contains(text(),'PDF Download')]");
//        pdfDownloadButton = driver.findElement(By.xpath("//button[contains(text(),'PDF Download')]"));
        myActions.action_click(pdfDownloadButton);
    }

    /*----------Functions----------*/

    public Boolean verifyParcelNumbers(int parcelNumber)
    {
        Boolean assertParcelNumber = false;
        String parcelsNumber = getActionValue();
        String assertValue = "received-from-seller ("+parcelNumber+")";
        if(parcelsNumber.equalsIgnoreCase(assertValue))
            assertParcelNumber=true;
        return assertParcelNumber;
    }

    public Boolean[] performVerifyBulkIssue(String bulkId, int parcelNumber)
    {
        Boolean[] assertValues = new Boolean[5];
        String tableBulkIdValue;
        String tableRunSheetIdValue;

        dashboardPageObjects.clickDownloadModule();
        sleep(2000);
        driver.navigate().refresh();

        System.out.println("Parcels Number : " + parcelNumber);
        System.out.println("Bulk Id : " + bulkId);
        searchByBulkId(bulkId);
        tableBulkIdValue = getBulkIdValue();
        tableRunSheetIdValue = getRunSheetValue();
        assertValues[0] = verifyParcelNumbers(parcelNumber);
        clickPdfDownloadButton();

        driver.navigate().refresh();
        System.out.println("Bulk Id Value : " + tableBulkIdValue);
        System.out.println("Runsheet Id Value : " + tableRunSheetIdValue);

        searchByRunSheetId(tableRunSheetIdValue);
        assertValues[1] = tableBulkIdValue.equalsIgnoreCase(getBulkIdValue());
        assertValues[2] = verifyParcelNumbers(parcelNumber);

        clickPdfDownloadButton();

        System.out.println(Arrays.toString(assertValues));

        return assertValues;
    }
}
