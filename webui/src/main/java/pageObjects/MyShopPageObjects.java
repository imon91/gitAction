package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

import java.util.List;
import java.util.Random;

public class MyShopPageObjects {


    private WebDriver driver;
    private MyActions myActions;
    private Random random;



    public MyShopPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
    }

    /*--------------------Left corner Informations options--------*/

    //My income option
    @FindBy(xpath = "//p[text()='My Income']")
    private WebElement myincomeButton;
    //My credit option
    @FindBy(xpath = "//p[text()='My Credits']")
    private WebElement mycreditButton;
    //Personal Imformation Option
    @FindBy(xpath = "//p[text()='Personal Information']")
    private WebElement personalinformationButton;
    //My shop
    @FindBy(xpath = "//p[text()='My Shop']")
    private WebElement myshopbutton;

    //OrderNowButton
    @FindBy(xpath = "//button[text()='ORDER NOW']")
    private WebElement orderNowButton;
    //Add new collection Icon
    @FindBy(xpath = "//div[text()='ADD NEW']")
    private WebElement addNewCollectionButton;
    //add your collection text
    @FindBy(xpath = "//input[@type='text'][@id='wl-new-clname']")
    private WebElement addYourCollectionText;
    //add button
    @FindBy(xpath = "//button[text()='Add']")
    private WebElement addButton;

    // product name-1
    @FindBy(xpath = "//div[@class='item-name']/p[1]")
    private WebElement productName1;
    // product-1 size L
    @FindBy(xpath = "//ul[@class='size-lists-in-feed']/li[2]/div")
    private WebElement productSizeL;

    //Load more button
    @FindBy(xpath = "//div[@class='flex___1bJDE center___10Hxv loadMore___1pvGz']//button")
    private WebElement loadmoreButton;





    public void clickOnMyincomeOption() {
        myActions.action_click(myincomeButton);
    }



    /*----------Add New collection tab--------------*/

    public void clickOnMycreditOPtion() {
        myActions.action_click(mycreditButton);
    }

    public void clickOnPersonalInformationOption() {
        myActions.action_click(personalinformationButton);
    }

    public void clickOnMyshopOption() {
        myActions.action_click(myshopbutton);
    }

    public void clickOnAddNewCollectionButton() {
        myActions.action_click(addNewCollectionButton);
    }

    public void clickOnAddYourCollectionText(String collectionName) {
        myActions.action_sendKeys(addYourCollectionText, collectionName);
    }

    public void clickOnAddButton() {
        myActions.action_click(addButton);
    }

    public void clickOnOrderNow() {
        myActions.action_click(orderNowButton);
    }

    public void getProductName1() {
        myActions.action_getText(productName1);
        myActions.action_click(productName1);
    }

    public void clickOnProductSizeL() {
        myActions.action_click(productSizeL);
    }




    /*----------------Functions-------------------*/

    public String createNewCollection() {
        clickOnAddNewCollectionButton();
        String collectionName = "TestingCollection : " + new Random().nextInt(5000);
        clickOnAddYourCollectionText(collectionName);
        clickOnAddButton();
        return collectionName;
    }

    /////////////////////*dynamic Xpath function*/////////////////////
    public String clickOnOldCollection(int collectionIndex,String ByName)
    {
        {
            String collectionXpath = "//div[@class='wishlist-items col-xs-12']/div";
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
                collection = "//a[text()='"+ByName+"']";
            }
            WebElement collectionname = driver.findElement(By.xpath(collection));
            collectionName = myActions.action_getText(collectionname);
            myActions.action_click(collectionname);
            return collectionName;
        }
    }

    //close the existing collection
    public String closeCollection(int collectionNo)
    {
        String collectionXpath="//div[@class='wishlist-items col-xs-12']/div";
        List<WebElement> collectionList = driver.findElements(By.xpath(collectionXpath));
        String collections,collectionName,collectionname;
        if(collectionNo!=0)
        {
            collections = collectionXpath+"]"+collectionNo+"]//i";
            collectionname = collectionXpath+"["+collectionNo+"]//a";
        }
        else
        {
            int index = random.nextInt(collectionList.size());
            collections = collectionXpath +"["+ ++index +"]//i";
            collectionname = collectionXpath+"["+ ++index +"]//a";
        }
        WebElement collectionDelButton = driver.findElement(By.xpath(collections));
        WebElement collectionNameDeleted = driver.findElement(By.xpath(collectionname));
        collectionName = myActions.action_getText(collectionNameDeleted);
        myActions.action_click(collectionDelButton);
        return collectionName;
    }

    //inside collection --click on product
    public String clickOnProduct (int productNo)
    {
        String productsXpath= "//div[@class='feed-grid-container']/ul/li";
        List<WebElement> productsList = driver.findElements(By.xpath(productsXpath));
        String productName,productImage;
        if(productNo!=0)
        {
            productImage = productsXpath+"["+productNo+"]//img";
            String productname = productsXpath+"["+productNo+"]//p";
            WebElement productnam = driver.findElement(By.xpath(productname));
            productName = myActions.action_getText(productnam);
        }
        else
        {
            int index = random.nextInt(productsList.size());
            productImage = productsXpath+"["+ ++index +"]//img";
            String productname = productsXpath+"["+ ++index +"]//p";
            WebElement productnam = driver.findElement(By.xpath(productname));
            productName = myActions.action_getText(productnam);
        }
        WebElement productimg = driver.findElement(By.xpath(productImage));
        myActions.action_click(productimg);

        return productName;
    }

    //Order now through collection
    public String orderProduct(int productNo,int sizeIndex)
    {
        String productsXpath= "//div[@class='feed-grid-container']/ul/li";
        List<WebElement> productsList = driver.findElements(By.xpath(productsXpath));
        String productName,sizeLabel,productname = null,size=null,orderbutton=null;
        if(productNo!=0&&sizeIndex!=0)
        {
            productname = productsXpath+"["+productNo+"]//p";
            size = productsXpath+"["+productNo+"]//div[@class='feed-size-select']/ul/li["+sizeIndex+"]";
            orderbutton = productsXpath+"["+productNo+"]//button";
        }
        else if (productNo==0&&sizeIndex!=0)
        {
            int index = random.nextInt(productsList.size());
            productname = productsXpath+"["+index+"]//p";
            size = productsXpath+"["+index+"]//div[@class='feed-size-select']/ul/li["+sizeIndex+"]";
            orderbutton = productsXpath+"["+index+"]//button";
        }
        else if(productNo!=0&&sizeIndex==0)
        {
            String sizexpath= productsXpath+"["+productNo+"]//div[@class='feed-size-select']/ul/li";
            List<WebElement> sizeList = driver.findElements(By.xpath(sizexpath));
            int index = random.nextInt(sizeList.size());
            productname = productsXpath+"["+productNo+"]//p";
            size = productsXpath+"["+productNo+"]//div[@class='feed-size-select']/ul/li["+  ++index  +"]";
            orderbutton = productsXpath+"["+productNo+"]//button";
        }
        WebElement productnam = driver.findElement(By.xpath(productname));
        WebElement sizelabel = driver.findElement(By.xpath(size));
        productName = myActions.action_getText(productnam);
        myActions.action_click(productnam);
        sizeLabel = myActions.action_getText(sizelabel);
        System.out.println("the selected size was:"+sizeLabel);
        myActions.action_click(sizelabel);
        WebElement orderbutt = driver.findElement(By.xpath(orderbutton));
        myActions.action_click(orderbutt);
        return productName;
    }


}

