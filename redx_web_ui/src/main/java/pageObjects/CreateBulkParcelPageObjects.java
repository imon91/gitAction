package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.*;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;


public class CreateBulkParcelPageObjects extends RedXWebBaseClass {

    private WebDriver driver;
    private MyActions myActions;
    private CreateBulkParcelPageObjects.BulkUploadPageObjects bulkUploadPageObjects;
    private Random random;

    public CreateBulkParcelPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
        random = new Random();
        bulkUploadPageObjects = new BulkUploadPageObjects();
    }

    /*----------Elements----------*/

    private WebElement titleWrapper;
    private WebElement downloadSampleButton;
    private WebElement allPickupLocationDropDown;
    private List<WebElement> pickupLocationDropDownOptions;
    private WebElement pickupLocationDropDownOption;
    private WebElement uploadFileButton;
    private WebElement toastMsg;

    /*---------------Actions---------------*/

    public String getTitleWrapper()
    {
        titleWrapper = xpathSetter("//div[@class='title-wrapper']/p");
        return myActions.action_getText(titleWrapper);
    }

    public void clickDownloadSampleButton()
    {
        downloadSampleButton = xpathSetter("//a[@href='/redx-sample.xlsx']");
        myActions.action_click(downloadSampleButton);
    }

    public void clickAllPickupLocationDropDown()
    {
        allPickupLocationDropDown = xpathSetter("//div[@class='pickup-store']//div[@class='ant-select-selection__rendered']");
        myActions.action_click(allPickupLocationDropDown);
    }

    public void choosePickupLocation(String location)
    {
        clickAllPickupLocationDropDown();
        pickupLocationDropDownOption = xpathSetter("//ul/li//font[contains(text(),'" + location + "']");
        myActions.action_click(pickupLocationDropDownOption);
    }

    public String choosePickupLocation()
    {
        clickAllPickupLocationDropDown();
        pickupLocationDropDownOptions = xpathListSetter("//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']/li");
        int size = pickupLocationDropDownOptions.size();
        int index = random.nextInt(size);
        System.out.println("Size : " + size);
        System.out.println("Index : " + index);

        String pickupLocation = myActions.action_getText(pickupLocationDropDownOptions.get(index));
        System.out.println("Pickup Location : " + pickupLocation);
        myActions.action_click(pickupLocationDropDownOptions.get(index));
        return pickupLocation;
    }

    public void clickUploadFilesButton()
    {
        uploadFileButton = xpathSetter("//span[@class='ant-upload']/button");
        myActions.action_click(uploadFileButton);
    }

    public void uploadParcelViaRobotClassMac (String path) throws Exception {
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

    public String getToastMsg()
    {
        toastMsg = xpathSetter("//div[@class='ant-message-notice']//span");
        return myActions.action_getText(toastMsg);
    }

    /*---------------Functions---------------*/

    public void performUploadFile(String path) throws Exception {
        choosePickupLocation();
        uploadParcelViaRobotClassMac(path);
        bulkUploadPageObjects.clickConfirmationButton();
        bulkUploadPageObjects.clickSubmitButton();
    }

    /*---------------Classes---------------*/

    public class BulkUploadPageObjects
    {

        /*---------------Elements---------------*/

        private WebElement titleWrapper;
        private List<WebElement> parcels;
        private WebElement customerName;
        private WebElement removeParcelButton;
        private List<WebElement> removeParcelButtons;
        private WebElement yesButton;
        private WebElement noButton;
        private WebElement confirmationButton;
        private WebElement confirmationButtonErrorMsg;
        private WebElement submitButton;
        private WebElement resetButton;


        /*---------------Actions---------------*/

        public String getTitleWrapper()
        {
            titleWrapper = xpathSetter("//div[@class='title-wrapper']/p");
            String title = myActions.action_getText(titleWrapper);
            System.out.println("Title : " + title);
            return title;
        }

        public int getParcelsSize()
        {
            parcels = xpathListSetter("//tbody/tr");
            return parcels.size();
        }

        public String getCustomerName(int index)
        {
            customerName = xpathSetter("//div[@class='ant-table-wrapper']//tr[" + index + "]/td[1]//input");
            return customerName.getAttribute("value");
        }

        public void clickConfirmationButton()
        {
            confirmationButton = xpathSetter("//label[@class='ant-checkbox-group-item ant-checkbox-wrapper']");
            myActions.action_click(confirmationButton);
        }

        public String getConfirmationErrorMsg()
        {
            confirmationButtonErrorMsg = xpathSetter("//div[@name='parcelValueConfirmation']/../div[@class='fieldError']");
            return myActions.action_getText(confirmationButtonErrorMsg);
        }

        public void clickSubmitButton()
        {
            submitButton = xpathSetter("//button[text()='Submit']");
            myActions.action_click(submitButton);
        }

        public void clickResetButton()
        {
            resetButton = xpathSetter("//button[text()='Reset']");
            myActions.action_click(resetButton);
        }

        public void clickRemoveButton(int index)
        {
            removeParcelButton = xpathSetter("//div[@class='ant-table-wrapper']//tr[" + index + "]/td[10]//button");
            myActions.action_click(removeParcelButton);
        }

        public void clickYesButton()
        {
            yesButton = xpathSetter("//div[contains(@class,'ant-popover-placement')][not(contains(@class,'hidden'))]//span[text()='Yes']/..");
            myActions.action_click(yesButton);
        }

        public void clickNoButton()
        {
            noButton = xpathSetter("//div[contains(@class,'ant-popover-placement')][not(contains(@class,'hidden'))]//span[text()='No']/..");
            myActions.action_click(noButton);
        }

        public void clickRemoveButton()
        {
            removeParcelButtons = xpathListSetter("//div[@class='ant-table-wrapper']//tr/td[10]//button");
            int size = removeParcelButtons.size();
            int index = random.nextInt(size) + 1;
            System.out.println("Size : " + size);
            System.out.println("Index : " + index);
            System.out.println("Customer Name : " + getCustomerName(index));
            clickRemoveButton(index);
        }

        public void removeParcel()
        {
            clickRemoveButton();
            clickYesButton();
        }
    }

    public class BulkUploadImportStatus
    {

        /*---------------Elements---------------*/

        private WebElement titleWrapper;
        private WebElement toastMsg;
        private List<WebElement> parcels;
        private WebElement statusFilterDropDown;
        private WebElement statusFilterDropDownOption;
        private List<WebElement> statusFilterDropDownOptions;
        private WebElement successInfo;
        private WebElement failedInfo;
        private WebElement refreshButton;

        /*---------------Actions---------------*/

        public String getTitleWrapper()
        {
            titleWrapper = xpathSetter("//div[@class='title-wrapper']//p");
            String title = myActions.action_getText(titleWrapper);
            System.out.println("Title : " + title);
            return title;
        }

        public String getToastMsg()
        {
            toastMsg = xpathSetter("//div[@class='ant-message-notice']//span");
            return myActions.action_getText(toastMsg);
        }

        public int getParcelsSize()
        {
            parcels = xpathListSetter("//tbody/tr");
            return parcels.size();
        }

        public String getSuccessInfo()
        {
            successInfo = xpathSetter("//div[@class='status-info']/span[2]");
            String value = myActions.action_getText(successInfo);
            return value.substring(0,value.length()-8);
        }

        public String getFailedInfo()
        {
            failedInfo = xpathSetter("//div[@class='status-info']/span[3]");
            String value = myActions.action_getText(failedInfo);
            return value.substring(0,value.length()-7);
        }

        public void clickRefreshButton()
        {
            refreshButton = xpathSetter("//div[@class='status-action']/button");
            myActions.action_click(refreshButton);
        }

        public void clickStatusFilterDropDownButton()
        {
            statusFilterDropDown = xpathSetter("//div[@class='title-wrapper']//div[@class='ant-select-selection__rendered']");
            myActions.action_click(statusFilterDropDown);
        }

        public void clickStatusFilterDropDownOption(String status)
        {
            clickStatusFilterDropDownButton();
            statusFilterDropDownOption = xpathSetter("//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']/li[contains(text(),'" + status + "')]");
            myActions.action_click(statusFilterDropDownOption);
        }

        public String clickStatusFilterDropDownOption()
        {
            clickStatusFilterDropDownButton();
            statusFilterDropDownOptions = xpathListSetter("//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']/li");
            int size = statusFilterDropDownOptions.size();
            int index = random.nextInt(size);
            System.out.println("Size : " + size);
            System.out.println("Index : " + index);

            String status = myActions.action_getText(statusFilterDropDownOptions.get(index));
            System.out.println("Stauts : " + status);
            myActions.action_click(statusFilterDropDownOptions.get(index));
            return status;
        }

        /*---------------Functions---------------*/

        public void clickRefreshTillStatus()
        {
            int parcels = getParcelsSize();
            int success = 0;
            int fail = 0;

            while((success + fail)!=parcels)
            {
                System.out.println("Success Parcels : " + success);
                System.out.println("Failed Parcels : " + fail);
                clickRefreshButton();
                success = Integer.parseInt(getSuccessInfo());
                fail = Integer.parseInt(getFailedInfo());
            }
        }
    }
}
