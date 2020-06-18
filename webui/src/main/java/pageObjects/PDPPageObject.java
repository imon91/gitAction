package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

import javax.xml.soap.Text;
import java.util.Random;

public class PDPPageObject {

    private WebDriver driver;
    private MyActions myActions;

    public PDPPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
    }


    //see size chart
    @FindBy(xpath = "//span[text()='SEE SIZE CHART']")
    private WebElement sizeChartOption;

    //size M
    @FindBy(xpath = "//label[text()='M']")
    private WebElement selectSiceM;

    //size L
    @FindBy(xpath = "//label[text()='L']")
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
    //@FindBy(xpath = "//a[text()='CASH ON DELIVERY']")
    //private WebElement categoryOption;

    //previous page option
    @FindBy(xpath = "//ol[@class='breadcrumb']/li[3]/a[@itemprop='item']")
    private WebElement previousPageOption;

    //Product text name
    @FindBy(xpath = "//ol[@class='breadcrumb']/li[4]")
    private WebElement productName;

    //click on Collection in myshop
    @FindBy(xpath = "//button[text()='collection-A']")
    private WebElement collection_a;

    //Newly Added CollectionName
    @FindBy(xpath = "//div[@class='wishlist-items col-xs-12']/div[1]")
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
    }

    public void clickOnSizeM() {
        myActions.action_click(selectSiceM);
    }

    public void clickOnSizeL() { myActions.action_click(selectSizeL); }

    public void clickOnSizeXL() { myActions.action_click(selectSizeXL);
    }

    public void clickOnAddToMyshopButton() {
        myActions.action_click(addToMyShopButton);
    }

    public void clickOnOrderNowButtonPDPPage() {
        myActions.action_click(orderNowButtonPDPPge);}

    //public void clickOnCategoryOption() {
      //  myActions.action_click(categoryOption;}

    public void clickOnProductImage() {
        myActions.action_click(productImage);
    }

    public void clickOnDownloadImage() {
        myActions.action_click(downloadProductImage);
    }

    public void clickOnPreviousPageOption() { myActions.action_click(previousPageOption); }

    public String getProductName() {
        String GetProductName =myActions.action_getText(productName);
        return GetProductName; }


//
    private void clickOnAddNewCollectionButton() { myActions.action_click(addNewCollectionButton); }

    private void clickOnAddYourCollectionText(String collectionName) { myActions.action_sendKeys(addYourCollectionText,collectionName); }

   private void clickOnAddButton() { myActions.action_click(addButton); }

    private void clickOnNewlyCreatedCollection() { myActions.action_click(currentCollection); }

    public void clickNewlyAddedCollection() { myActions.action_click(firstCollection); }


    public void addToCollection_A() { myActions.action_click(collection_a); }




    /*--------Function-------*/
    public String addItemToNewCollection() {
        clickOnAddNewCollectionButton();
        String collectionName = "TestingCollection : " + new Random().nextInt(5000);
        clickOnAddYourCollectionText(collectionName);
        clickOnAddButton();
        clickOnNewlyCreatedCollection();
        return collectionName;
    }



}
