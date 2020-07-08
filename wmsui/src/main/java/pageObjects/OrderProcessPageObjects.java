package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

import java.util.List;

public class OrderProcessPageObjects {
    private final WebDriver driver;
    private final MyActions myActions;

    public OrderProcessPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        myActions = new MyActions();
    }


    /*--------------Tabs-------------------*/
    @FindBy(xpath = "//div[@class='packages-details-tabs']/ul/li[1]/a")
    private WebElement orderPackTab;

    @FindBy(xpath = "//div[@class='packages-details-tabs']/ul/li[2]/a")
    private WebElement createManifestTab;

    @FindBy(xpath = "//div[@class='packages-details-tabs']/ul/li[3]/a")
    private WebElement uploadManifestTab;

    @FindBy(xpath = "//div[@class='packages-details-tabs']/ul/li[4]/a")
    private WebElement orderDetailTab;


    /*--------------Actions-------------------*/
    public void clickOrderPackTab(){myActions.action_click(orderPackTab);}

    public void clickCreateManifestTab(){myActions.action_click(createManifestTab);}

    public void clickUploadManifestTab(){myActions.action_click(uploadManifestTab);}

    public void clickOrderDetailTab(){myActions.action_click(orderDetailTab);}


    /*--------------Order Pack Tab-------------------*/
    public class OrderPackTab{
        private final WebDriver driver;
        private final MyActions myActions;

        public OrderPackTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }

        @FindBy(xpath = "//div[@id='ordersPacking']//input[@id='orderPackingNumber']")
        private WebElement orderPackingNumberEntry;

        @FindBy(xpath = "//div[@id='ordersPacking']//input[@id='orderPackingIds']")
        private WebElement orderPackingIdEntry;

        @FindBy(xpath = "//div[@id='ordersPacking']//button")
        private WebElement submitButton;


        /*--------------Actions-------------------*/
        public void orderPackingNumberInput(String orderPackingNumber){myActions.action_sendKeys(orderPackingNumberEntry,orderPackingNumber); }

        public void orderPackingIdInput(String orderPackingId){myActions.action_sendKeys(orderPackingIdEntry,orderPackingId);}

        public void clickSubmitButton(){myActions.action_click(submitButton);}


        /*--------------Functions-------------------*/
        public void checkOrderPack(String orderPackingNumber, String orderPackingId){
            orderPackingNumberInput(orderPackingNumber);
            orderPackingIdInput(orderPackingId);
            clickSubmitButton();
        }
    }


    /*--------------Create Manifest Tab-------------------*/
    public class CreateManifestTab{
        private final WebDriver driver;
        private final MyActions myActions;

        public CreateManifestTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }
    }


    /*--------------Upload Manifest Tab-------------------*/
    public class UploadManifestTab{
        private final WebDriver driver;
        private final MyActions myActions;

        public UploadManifestTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }

        @FindBy(xpath = "//div[@id='Manifest']/div[1]/button")
        private WebElement manifestsButton;


        /*--------------Actions-------------------*/
        public void clickManifestsButton(){myActions.action_click(manifestsButton);}

        public int getTotalManifests() {
            List<WebElement> manifests = driver.findElements(By.xpath("//div[@id='Manifest']//tbody/tr"));
            return manifests.size();
        }

        public String getManifestID(int index) {
            String manifestIdXpath = "//div[@id='Manifest']//tbody/tr["+index+"]/td[1]";
            WebElement manifestID = driver.findElement(By.xpath(manifestIdXpath));
            return myActions.action_getText(manifestID);
        }

        public String getCreatedDate(int index) {
            String createdDateXpath = "//div[@id='Manifest']//tbody/tr["+index+"]/td[2]";
            WebElement createdDate = driver.findElement(By.xpath(createdDateXpath));
            return myActions.action_getText(createdDate);
        }

        public String getTotalOrders(int index) {
            String totalOrdersXpath = "//div[@id='Manifest']//tbody/tr["+index+"]/td[3]";
            WebElement totalOrders = driver.findElement(By.xpath(totalOrdersXpath));
            return myActions.action_getText(totalOrders);
        }

        public String getTotalManifestedOrders(int index) {
            String totalManifestedOrdersXpath = "//div[@id='Manifest']//tbody/tr["+index+"]/td[4]";
            WebElement totalManifestedOrders = driver.findElement(By.xpath(totalManifestedOrdersXpath));
            return myActions.action_getText(totalManifestedOrders);
        }

        public String getCourier(int index) {
            String courierXpath = "//div[@id='Manifest']//tbody/tr["+index+"]/td[5]";
            WebElement courier = driver.findElement(By.xpath(courierXpath));
            return myActions.action_getText(courier);
        }

        public void printManifest(int index){
            String printManifestXpath = "//div[@id='Manifest']//tbody/tr["+index+"]/td[6]/div[1]/div[1]/a";
            WebElement printManifestButton = driver.findElement(By.xpath(printManifestXpath));
            myActions.action_click(printManifestButton);
        }


        /*--------------Page Handling-------------------*/
        @FindBy(xpath = "//div[@id='Manifest']//button[@title='Next Page']")
        private WebElement nextPage;

        @FindBy(xpath = "//div[@id='Manifest']//select[@type='text']")
        private WebElement pageSize;

        @FindBy(xpath = "//div[@id='Manifest']//button[@title='Previous Page']")
        private WebElement previousPage;

        @FindBy(xpath = "//div[@id='Manifest']//button[@title='First Page']")
        private WebElement firstPage;

        @FindBy(xpath = "//div[@id='Manifest']//button[@title='Current Page Number']/span")
        private WebElement pageNo;


        /*--------------Actions-------------------*/
        public void goToNextPage() {
            myActions.action_click(nextPage);
        }

        public void selectPageSize(String size) {
            myActions.action_select(pageSize, size);
        }

        public void goToPreviousPage() {
            myActions.action_click(previousPage);
        }

        public void goToFirstPage() {
            myActions.action_click(firstPage);
        }

        public int getPageNumber() {
            int pageNoInteger = Integer.valueOf(myActions.action_getText(pageNo));
            return pageNoInteger;
        }
    }


    /*--------------Order Details Tab-------------------*/
    public class OrderDetailTab{
        private final WebDriver driver;
        private final MyActions myActions;

        public OrderDetailTab(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            myActions = new MyActions();
        }

        @FindBy(xpath = "//div[@id='OrderDetails']//input[@type='text']")
        private WebElement orderNumberEntry;


        /*--------------Actions-------------------*/
        public void orderNumberInput(String orderNumber){
            myActions.action_sendKeys(orderNumberEntry,orderNumber);
            myActions.action_enter(orderNumberEntry);
        }
    }
}
