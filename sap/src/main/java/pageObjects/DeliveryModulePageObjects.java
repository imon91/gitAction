package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;
import utils.SapBaseClass;

public class DeliveryModulePageObjects extends SapBaseClass {

    private WebDriver driver;
    private MyActions myActions;

    private String[] searchOptions = {"invoiceId","shopName","parcelId","trackingId","invoiceNumbers"};

    public DeliveryModulePageObjects (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        myActions = new MyActions();
    }

    /*----------Elements----------*/

    private WebElement searchOptionButton;
    private WebElement searchOption;
    private WebElement searchBar;
    private WebElement searchButton;

    /*----------Actions----------*/

    public void clickSearchOptionButton()
    {
        searchOptionButton = xpathSetter("//div[@class='search-option']//button");
        myActions.action_click(searchOptionButton);
    }

    public void chooseSearchOption(String option)
    {
        clickSearchOptionButton();
        searchOption = xpathSetter("//li[contains(@ng-click,'" + option + "')]/a");
        myActions.action_click(searchOption);
    }

    public void enterSearchBar(String searchTerm)
    {
        searchBar = xpathSetter("//input[@placeholder='Search by shop name / invoiceId / parcelId / trackingId / invoice number']");
        myActions.action_sendKeys(searchBar,searchTerm);
    }

    public void clickSearchButton()
    {
        searchButton = xpathSetter("//button[contains(text(),'SEARCH')]");
        myActions.action_click(searchButton);
    }

    /*----------Functions----------*/

    public void performSearch(String option,String searchTerm)
    {
        chooseSearchOption(option);
        enterSearchBar(searchTerm);
        clickSearchButton();
    }

    /*----------Classes----------*/

    public class ParcelDetails
    {
        /*----------Elements----------*/

        private WebElement trackingIdValue;
        private WebElement totalPaymentValue;
        private WebElement partialDeliveryButton;
        private WebElement amountInput;
        private WebElement saveButton;

        /*----------Actions----------*/

        public String getTrackingIdValue(int index)
        {
            trackingIdValue = xpathSetter("//div[@class='t-body']/div[" + index + "]//b[contains(text(),'#')]");
            String value = myActions.action_getText(trackingIdValue);
            return value.substring(1);
        }

        public String getTotalPaymentValue(int index)
        {
            totalPaymentValue = xpathSetter("//div[@class='t-body']/div[" + index + "]//div[contains(text(),'Total')]/../div[contains(@class,'input')]");
            return myActions.action_getText(totalPaymentValue);
        }

        public void clickPartialDeliveryButton(int index)
        {
            partialDeliveryButton = xpathSetter("//div[@class='t-body']/div[" + index + "]//button[contains(text(),'Partial Delivery')]");
            myActions.action_click(partialDeliveryButton);
        }

        public void enterAmountInput(String amount)
        {
            System.out.println("Amount : " + amount);
            amountInput = xpathSetter("//input[@placeholder='Current amount']");
            myActions.action_sendKeys(amountInput,amount);
        }

        public void clickSaveButton()
        {
            saveButton = xpathSetter("//button[contains(text(),'Save')]");
            myActions.action_click(saveButton);
        }

        /*----------Functions----------*/

        public void performPartialDelivery(int index, String amount)
        {
            clickPartialDeliveryButton(index);
            enterAmountInput(amount);
            clickSaveButton();
        }
    }


}
