package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;
import utils.WebAppBaseClass;

import java.util.List;
import java.util.Random;

public class PDPPageObjects extends WebAppBaseClass {

    private AndroidDriver<WebElement> driver;
    private MyActions myActions;
    private Random random;

    public PDPPageObjects(AndroidDriver<WebElement> androidDriver) throws Exception {
        this.driver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        myActions = new MyActions();
        random = new Random();
    }


    //addtomyshop
    @FindBy(xpath = "//button[contains(text(),'Add to My Shop')]")
    private WebElement AddToMyShopButton;

    //BuyNowButton
    @FindBy(xpath = "//button[contains(text(),'Buy Now')]")
    private WebElement BuyNowButton;

    //ImageofProduct
    @FindBy(xpath = "//div[@class='item']")
    private WebElement ImageofProduct;

    //closeImageofProduct
    @FindBy(xpath = "//div[@class='close-image-pop']")
    private WebElement CloseImage;

    //sizechart
    @FindBy(xpath = "//span[@class='link']")
    private WebElement Sizechart;

    //closeSizeChart
    @FindBy(xpath = "//div[@class='pop-up-body brands-filter']//div[@class='pointer']/*")
    private WebElement CloseSizeChart;

    //getItemText
    @FindBy(xpath = "//div[@class='product-details']/div/h1")
    private WebElement ItemText;

    //closecollectionlist
    @FindBy(xpath = "//div[@class='modal-header']//button")
    private WebElement closecollection;

    //category
    @FindBy(xpath = "//ul[@class='list-unstyled']//li[2]//a")
    private WebElement Category;

    //getcategory
    @FindBy(xpath = "//ul[@class='list-unstyled']//li[2]//a/font")
    private WebElement category;

    //getsubcategory
    @FindBy(xpath = "//ul[@class='list-unstyled']//li[3]//a/font")
    private WebElement subcategory;

    //subcategory
    @FindBy(xpath = "//ul[@class='list-unstyled']//li[3]//a")
    private WebElement Subcategory;

    //selectsizetext
    @FindBy(xpath = "//div[@class='pdp-det-box available-sizes']/h3/span")
    private WebElement selectSizeText;

    //pricesHeader
    @FindBy(xpath = "//div[@class='pdp-det-box']//h2")
    private WebElement pricesHeader;




/*-------Actions---------*/



    public void clickOnAddToMyShop(){myActions.action_click(AddToMyShopButton);};

    public void clickOnBuyNow(){myActions.action_click(BuyNowButton);};

    public void clickOnImageOfProduct(){myActions.action_click(ImageofProduct);};

    public void clickOnCloseButton(){myActions.action_click(CloseImage);}

    public void clickOnSizeChart(){myActions.action_click(Sizechart);}

    public void closeSizeChart(){myActions.action_click(CloseSizeChart);}

    public String getItemText(){return myActions.action_getText(ItemText);}

    public void closecollections(){myActions.action_click(closecollection);}

    public void moveTocategory(){
        myActions.action_click(Category);
    }

    public String getcategory(){return myActions.action_getText(category);}

    public void moveToSubcategory(){
        myActions.action_click(Subcategory);
    }

    public String getsubcategory(){return myActions.action_getText(subcategory);}


/*-------Functions------*/


    public void seeImageofProduct(){
        clickOnImageOfProduct();
        clickOnCloseButton();
    }


    public void seeSizeChart(){
        clickOnSizeChart();
        closeSizeChart();
    }


/*----------dynamicfunctions--------*/



     public String selectSize(int sizeid){
        String size, sizeButton, sizeLabel;
        String sizeXpath = "//div[@class='pdp-det-box available-sizes']/ul/li";
        List<WebElement> sizeslist = driver.findElements(By.xpath(sizeXpath));
        if(sizeid != 0) {
            size = sizeXpath + "[" + sizeid + "]";
        }
        else{
            int id = random.nextInt(sizeslist.size());
            size = sizeXpath+"["+ ++id +"]";
        }
        sizeButton = size+"/div/input";
        sizeLabel = size+"/div//label";
        WebElement sizeButtonElement = driver.findElement(By.xpath(sizeButton));
        WebElement sizeLabelElement = driver.findElement(By.xpath(sizeLabel));
        String sizeSelected = myActions.action_getText(sizeLabelElement);
        myActions.action_click(sizeLabelElement);
        return sizeSelected;
     }



     public String additemtoCollection(int collectionid){
         String collection;
         String collectionXpath = "//div[@class='user-collection-body']//button";
         List<WebElement> collectionslist = driver.findElements(By.xpath(collectionXpath));
         if(collectionid != 0){
             collection = collectionXpath+"["+collectionid+"]";
         }
         else {
             int id = random.nextInt(collectionslist.size());
             collection = collectionXpath+"["+ ++id +"]";
         }
         WebElement chooseCollection = driver.findElement(By.xpath(collection));
         String collectionSelected = myActions.action_getText(chooseCollection);
         myActions.action_click(chooseCollection);
         return collectionSelected;
     }



     public String recentlyViewed(int productid){
         String product;
         String productXpath = "//div[@class='disply-in-line-block-ul']//div[@class='product-grid']";
         List<WebElement> productslist = driver.findElements(By.xpath(productXpath));
         if(productid != 0){
             product = productXpath+"["+productid+"]";
         }
         else {
             int id = random.nextInt(productslist.size());
             product = productXpath+"["+ ++id +"]";
         }
         String productName = product+"//h4";
         WebElement productnameElement = driver.findElement(By.xpath(productName));
         String productSelected = myActions.action_getText(productnameElement);
         WebElement productElement = driver.findElement(By.xpath(product));
         myActions.action_click(productElement);
         return productSelected;
     }



}

