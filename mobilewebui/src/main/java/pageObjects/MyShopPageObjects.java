package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

import java.util.Random;

public class MyShopPageObjects {
    private AndroidDriver<WebElement> driver;
    private MyActions myActions;

    public MyShopPageObjects(AndroidDriver<WebElement> androidDriver){
        this.driver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
    }


    /*-------------Collections Tab Elements------------------*/

    // MyCollections Tab Item
    @FindBy(css = "#tab_1")
    private WebElement myCollectionTabItem;

    // ExclusiveCollections Tab Item
    @FindBy(css = "#tab_2")
    private WebElement exclusiveCollectionTabItem;


    public void clickOnMyCollectionTabItem(){
        myActions.action_click(myCollectionTabItem);
    }

    public void clickOnExclusiveCollectionTabItem(){
        myActions.action_click(exclusiveCollectionTabItem);
    }


    /*-------------MyCollections Tab Elements------------------*/

    // No-Of-Collection TextView
    @FindBy(css = "#content > div > div:nth-child(4) > div.page-body > div > div > div > div > div:nth-child(2) > div > div.flex___1bJDE.column___2CDPf.center___10Hxv.middle___1jEMZ.title___3RaA5 > span")
    private WebElement noOfCollectionTextView;

    // Create New or add to existing Collections View
    @FindBy(css = "#content > div > div:nth-child(4) > div.page-body > div > div > div > div > div:nth-child(2) > div > div.flex___1bJDE.wrap___tCzfQ.grid-2___1YlpV.grid___3egso > div:nth-child(1) > div")
    private WebElement createOrAddToNewCollectionText;

    // CreateNewCollection View
    @FindBy(css = "#content > div > div:nth-child(4) > div.page-body > div > div > div > div > div:nth-child(2) > div > div.drawerContainer___7enVI.containerBottom___790KD > div > form > div > div")
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

    public String createNewCollection(){
        clickOnCreateNewCollectionButton();
        String collectionName = "TestingCollection : "+ new Random().nextInt(5000);
        new CreateCollectionBottomSheetObjects(driver).
                performAddCollection(collectionName);
        return collectionName;
    }

    public void enterIntoCollectionFromMyCollections(String collectionName){

    }

}
