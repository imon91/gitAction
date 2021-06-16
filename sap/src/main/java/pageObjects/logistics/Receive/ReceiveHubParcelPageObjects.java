package pageObjects.logistics.Receive;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import utils.*;

import java.util.List;

public class ReceiveHubParcelPageObjects extends SapBaseClass {

    private WebDriver driver;
    private MyActions myActions;

    public ReceiveHubParcelPageObjects (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        myActions = new MyActions();
    }

    /*----------Elements----------*/

    private WebElement dropDownOption;
    private List<WebElement> parcels;
    private WebElement viewParcelsButton;
    private WebElement sendToSortingButton;

    /*----------Actions----------*/

    public void clickDropDownOptionByTitle(String option)
    {
        dropDownOption = xpathSetter("//a[contains(@title,'" + option.trim() + "')]");
        myActions.action_click(dropDownOption);
    }

    public int getIndexOf(String section,String bulkTransferId)
    {
        parcels = xpathListSetter("//section[@class='" + section + "-section']//div[@class='fresh-parcel ng-scope']//h4");
        for(int i=0;i<parcels.size();i++)
            if(myActions.action_getText(parcels.get(i)).contains(bulkTransferId))
                return i+1;
            return -1;
    }

    public void clickViewParcelsButton(int index)
    {
        viewParcelsButton = xpathSetter("//div[@class='fresh-parcel ng-scope'][" + index + "]//button");
        myActions.action_click(viewParcelsButton);
    }

    public void clickSendToSortingButton(int index)
    {
        sendToSortingButton = xpathSetter("//div[@class='fresh-parcel ng-scope'][" + index + "]//button[contains(text(),'SEND TO SORTING')]");
        myActions.action_click(sendToSortingButton);
    }

    /*----------Class----------*/

    public class BulkModalPageObjects
    {
        /*----------Elements----------*/

        private WebElement scanParcelIdInput;
        private WebElement confirmButton;

        /*----------Actions----------*/

        public void enterScanParcelIdInput(String trackingId)
        {
            scanParcelIdInput = xpathSetter("//div[@class='modal-content']//input");
            myActions.action_sendKeys(scanParcelIdInput,trackingId);
            scanParcelIdInput.sendKeys(Keys.ENTER);
        }

        public void clickConfirmButton()
        {
            confirmButton = xpathSetter("//div[@class='modal-content']//button[contains(text(),'CONFIRM')]");
            myActions.action_click(confirmButton);
        }

        public void performScanParcel(String trackingId)
        {
            enterScanParcelIdInput(trackingId);
            clickConfirmButton();
        }
    }

}
