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

public class MyShopPageObjects extends WebAppBaseClass {
    private AndroidDriver<WebElement> driver;
    private MyActions myActions;
    private Random random;

    public MyShopPageObjects(AndroidDriver<WebElement> androidDriver) throws Exception {
        this.driver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
        random = new Random();
    }


    /*-------------Collections Tab Elements------------------*/

    // MyCollections Tab Item
    @FindBy(xpath = "//p[contains(text(),'My Collections')]")
    private WebElement myCollectionTabItem;

    // ExclusiveCollections Tab Item
    @FindBy(xpath = "//p[contains(text(),'Exclusive Collections')]")
    private WebElement exclusiveCollectionTabItem;


    public void clickOnMyCollectionTabItem(){
        myActions.action_click(myCollectionTabItem);
    }

    public void clickOnExclusiveCollectionTabItem(){
        myActions.action_click(exclusiveCollectionTabItem);
    }


    /*-------------MyCollections Tab Elements------------------*/

    // No-Of-Collection TextView
    @FindBy(xpath = "//span[@class='primary___3k9Ts weight-4___ZQvdQ text-16___-Np8V bold___3nNae text-flat___3AZ-6']")
    private WebElement noOfCollectionTextView;

    // Create New or add to existing Collections View
    @FindBy(xpath = "//p[contains(text(),'Create New or add to existing Collections')]")
    private WebElement createOrAddToNewCollectionText;

    // CreateNewCollection View
    @FindBy(xpath = "//p[contains(text(),'Create New Collection')]")
    private WebElement createNewCollectionButton;


    public String getNoOfCollectionText(){
        return myActions.action_getText(noOfCollectionTextView);
    }

    public String getCreateOrAddNewCollectionsText(){
        return myActions.action_getText(createOrAddToNewCollectionText);
    }

    public void clickOnCreateNewCollectionButton(){
        myActions.action_click(createNewCollectionButton);
    }



    /*-------------ExclusiveCollections Tab Elements------------------*/





    /*----------------Functions-------------------*/

    public String createNewCollection() throws Exception {
        //clickOnCreateNewCollectionButton();
        String collectionName = "TestingCollection : "+ new Random().nextInt(5000);
        new CreateCollectionBottomSheetObjects(driver).performAddCollection(collectionName);
        return collectionName;
    }

    public void enterIntoCollectionFromMyCollections(String collectionName){

    }



    /*------dynamicfunctions--------*/




        public int chooseCollection ( int collectionid){
            String collectionXpath = "//div[@class='gridItems___2yFJ9 items___vci1r']";
            List<WebElement> collectionslist = driver.findElements(By.xpath(collectionXpath));
            String collection;
            int collectionselected;
            if (collectionid != 0) {
                collection = collectionXpath + "[" + collectionid + "]";
                collectionselected = collectionid;
            } else {
                int id = random.nextInt(collectionslist.size());
                id += 2;
                collection = collectionXpath + "[" + id + "]";
                collectionselected = id;
            }
            WebElement choosencollection = driver.findElement(By.xpath(collection));
            myActions.action_click(choosencollection);
            return collectionselected;
        }

        public String CollectionName ( int collectionid){
            String collectionXpath = "//div[@class='gridItems___2yFJ9 items___vci1r']";
            List<WebElement> collectionslist = driver.findElements(By.xpath(collectionXpath));
            String collection;
            if (collectionid != 0) {
                collection = collectionXpath + "[" + collectionid + "]//p";
            } else {
                int id = random.nextInt(collectionslist.size());
                id += 2;
                collection = collectionXpath + "[" + id + "]//p";
            }
            WebElement choosencollection = driver.findElement(By.xpath(collection));
            String collectionselected = myActions.action_getText(choosencollection);
            return collectionselected;
        }

        public String shareCollection ( int collectionid){
            String collectionXpath = "//div[@class='gridItems___2yFJ9 items___vci1r']";
            List<WebElement> collectionslist = driver.findElements(By.xpath(collectionXpath));
            String collection;
            if (collectionid != 0) {
                collection = collectionXpath + "[" + collectionid + "]//button";
            } else {
                int id = random.nextInt(collectionslist.size());
                id += 2;
                collection = collectionXpath + "[" + id + "]//button";
            }
            WebElement choosencollection = driver.findElement(By.xpath(collection));
            String collectionselected = myActions.action_getText(choosencollection);
            return collectionselected;
        }

        public String deleteCollection ( int collectionid){
            String collectionXpath = "//div[@class='gridItems___2yFJ9 items___vci1r']";
            List<WebElement> collectionslist = driver.findElements(By.xpath(collectionXpath));
            String collection;
            if (collectionid != 0) {
                collection = collectionXpath + "[" + collectionid + "]//div[@class='flex___1bJDE middle___1jEMZ delete___IOgcz']/*";
            } else {
                int id = random.nextInt(collectionslist.size());
                id += 2;
                collection = collectionXpath + "[" + id + "]//div[@class='flex___1bJDE middle___1jEMZ delete___IOgcz']/*";
            }
            WebElement choosencollection = driver.findElement(By.xpath(collection));
            String collectionselected = myActions.action_getText(choosencollection);
            return collectionselected;
        }


}
