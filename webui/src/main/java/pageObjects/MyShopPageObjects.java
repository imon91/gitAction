package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

import java.util.Random;

public class MyShopPageObjects {

    private WebDriver driver;
    private MyActions myActions;

    public MyShopPageObjects(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        myActions = new MyActions();
    }


    /*-------------Collections Tab Elements------------------*/

    // MyCollections Tab Item
    @FindBy (xpath = "//android.view.View[@text='My Collections']")
    private WebElement myCollectionTabItem;

    // ExclusiveCollections Tab Item
    @FindBy(xpath = "//android.view.View[@text='Exclusive Collections']")
    private WebElement exclusiveCollectionTabItem;


    public void clickOnMyCollectionTabItem(){
        myActions.action_click(myCollectionTabItem);
    }

    public void clickOnExclusiveCollectionTabItem(){
        myActions.action_click(exclusiveCollectionTabItem);
    }


    /*-------------MyCollections Tab Elements------------------*/

    // No-Of-Collection TextView
    @FindBy(className = "android.view.TextView")
    private WebElement noOfCollectionTextView;

    // Create New or add to existing Collections View
    @FindBy(xpath = "//android.view.View[@text='Create New or add to existing Collections']")
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
