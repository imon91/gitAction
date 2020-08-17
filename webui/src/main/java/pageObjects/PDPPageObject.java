package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;
import utils.WebBaseClass;

import javax.xml.soap.Text;
import java.util.List;
import java.util.Random;

public class PDPPageObject extends WebBaseClass {

    private final WebDriver driver;
    private final MyActions myActions;
    private Random random;

    public PDPPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
    }


    //see size chart
    @FindBy(xpath = "//span[text()='SEE SIZE CHART']")
    private WebElement sizeChartOption;
    @FindBy(xpath = "//div[@class='pop-up-header']/i")
    private WebElement closeSizeChart;

    //size M
    @FindBy(xpath = "//label[text()='M']")
    private WebElement selectSiceM;

    //size L
    @FindBy(xpath = "//ul[@class='size-lists']/li[2]/div/label")
    private WebElement selectSizeL;

    //size XL
    @FindBy(xpath = "//label[text()='XL']")
    private WebElement selectSizeXL;

    //Add to Myshop button
    @FindBy(xpath = "//button[text()='Add to My Shop']")
    private WebElement addToMyShopButton;

    //Order now button
    @FindBy(xpath = "//div[@class='btn-container']/ul[1]/li[3]")
    private WebElement orderNowButtonPDPPge;

    //product image
    @FindBy(xpath = "//li[@id='thumbnail0']")
    private WebElement productImage;

    //download product image
    @FindBy(xpath = "//span[text()='Download']")
    private WebElement downloadProductImage;

    //category option
    @FindBy(xpath = "//ul[@class='list-unstyled']/li[2]//a")
    private WebElement categoryOption;
    //sub category option
    @FindBy(xpath = "//ul[@class='list-unstyled']/li[3]//a")
    private WebElement subCategoryOption;

    //previous page option
    @FindBy(xpath = "//ol[@class='breadcrumb']/li[3]/a[@itemprop='item']")
    private WebElement previousPageOption;

    //Product text name
    @FindBy(xpath = "//div[@class='product-details']/div[1]/h1")
    private WebElement productName;

    //click on Collection in myshop
    @FindBy(xpath = "//button[text()='collection-A']")
    private WebElement collection_a;

    //Newly Added CollectionName
    @FindBy(xpath = "//div[@class='wishlist-items col-xs-12']/div[1]/a")
    private WebElement firstCollection;

    //clickOnAddNewCollectionButton
    @FindBy(xpath = "//button[text()='ADD NEW']")
    private WebElement addNewCollectionButton;

    //clickOnAddYourCollectionText
    @FindBy(xpath = "//input[@type='text'][@placeholder='Add Your Collection Name']")
    private WebElement addYourCollectionText;

    //ClickOnaddButton
    @FindBy(xpath = "//button[text()='Add']")
    private WebElement addButton;

    //ClickOnCollection
    @FindBy(xpath = "//div[@class='row user-collection-body']/button[1]")
    private WebElement currentCollection;


    public void clickOnSizeChart() {
        myActions.action_click(sizeChartOption);
        myActions.action_click(closeSizeChart);
    }

    public void clickOnSizeM() {
        myActions.action_click(selectSiceM);
    }

    public void clickOnSizeL() {
        myActions.action_click(selectSizeL);
    }

    public void clickOnSizeXL() {
        myActions.action_click(selectSizeXL);
    }

    public void clickOnAddToMyshopButton() {
        myActions.action_click(addToMyShopButton);
    }

    public void clickOnOrderNowButtonPDPPage() {
        myActions.action_click(orderNowButtonPDPPge);
    }

    public void clickOnCategoryOption() {
        myActions.action_click(categoryOption);
    }

    public void clickOnSubCategoryOption() {
        myActions.action_click(subCategoryOption);
    }


    public void clickOnProductImage() {
        myActions.action_click(productImage);
    }

    public void clickOnDownloadImage() {
        myActions.action_click(downloadProductImage);
    }

    public void clickOnPreviousPageOption() {
        myActions.action_click(previousPageOption);
    }

    public String getProductName() {
        String GetProductName = myActions.action_getText(productName);
        return GetProductName;
    }


    //
    private void clickOnAddNewCollectionButton() {
        myActions.action_click(addNewCollectionButton);
    }

    private void clickOnAddYourCollectionText(String collectionName) {
        myActions.action_sendKeys(addYourCollectionText, collectionName);
    }

    private void clickOnAddButton() {
        myActions.action_click(addButton);
    }

    private void clickOnNewlyCreatedCollection() {
        myActions.action_click(currentCollection);
    }

    public void clickNewlyAddedCollection() {
        myActions.action_click(firstCollection);
    }


    public void addToCollection_A() {
        myActions.action_click(collection_a);
    }


    /*--------Function-------*/
    public String addToMyshopNewCollection() {
        clickOnAddNewCollectionButton();
        String collectionName = "TestingCollection : " + new Random().nextInt(5000);
        sleep(500);
        clickOnAddYourCollectionText(collectionName);
        sleep(200);
        clickOnAddButton();
        sleep(500);
        clickOnNewlyCreatedCollection();
        return collectionName;
    }

    ///////////////////////////*Dynamic xpath function*///////////////////////////////
    //Select size
    public String selectSize(int sizeNo) {
        String size;
        String sizeLabel;
        String innerSizeXpath = "//ul[@class='size-lists']/li";
        List<WebElement> sizeList = driver.findElements(By.xpath(innerSizeXpath));
        if (sizeNo != 0) {
            size = innerSizeXpath + "[" + sizeNo + "]";
        } else {
            int index = random.nextInt(sizeList.size());
            size = innerSizeXpath + "[" + ++index + "]";
        }
        WebElement sizelabel = driver.findElement(By.xpath(size));
        sizeLabel = myActions.action_getText(sizelabel);
        myActions.action_click(sizelabel);
        return sizeLabel;
    }

    //order recently viewed product
    public String clickRecentlyViewedProduct(int productNo) {
        String recentXpath = "//div[@class='row products-grid-container recentlyViewedItems']/div";
        List<WebElement> relatedproductsList = driver.findElements(By.xpath(recentXpath));
        String product, productnam, productName;
        if (productNo != 0) {
            product = recentXpath + "[" + productNo + "]//img";
            productnam = recentXpath + "[" + productNo + "]//h4";

        } else {
            int index = random.nextInt(relatedproductsList.size());
            product = recentXpath + "[" + ++index + "]//img";
            productnam = recentXpath + "[" + ++index + "]//h4";
        }
        WebElement productname = driver.findElement(By.xpath(productnam));
        WebElement Product = driver.findElement(By.xpath(product));
        productName = myActions.action_getText(productname);
        return productName;
    }

    //add product to myshop
    public String addToMyShopOldCollection(int collectionIndex, String ByName)
    {
        clickOnAddToMyshopButton();
        String collectionXpath = "//div[@class='modal-content']/div[@class='modal-body']//button";
        List<WebElement> collectionList = driver.findElements(By.xpath(collectionXpath));
        String collection, collectionName;
        if (ByName == null)
        {
            if (collectionIndex != 0)
            {
                collection = collectionXpath + "[" + collectionIndex + "]";
            }
            else
                {
                int index = random.nextInt(collectionList.size());
                collection = collectionXpath + "[" + ++index + "]";
                }

        }
        else
            {
            collection = "//button[text()='"+ByName+"']";
        }
        WebElement collectionname = driver.findElement(By.xpath(collection));
        collectionName = myActions.action_getText(collectionname);
        myActions.action_click(collectionname);
        return collectionName;
    }



    public String addToMyshopNewCollection1(String collectionname) {
        clickOnAddNewCollectionButton();
        String collectionName = "TestingCollection : " + new Random().nextInt(5000);
        clickOnAddYourCollectionText(collectionName);
        clickOnAddButton();
        clickOnNewlyCreatedCollection();
        return collectionName;
    }



}
