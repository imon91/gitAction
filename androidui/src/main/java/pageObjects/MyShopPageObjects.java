package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import utils.MyActions;
import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.support.*;
import java.util.*;


public class MyShopPageObjects {

    private AndroidDriver<AndroidElement> androidDriver;
    private MyActions myActions;

    public MyShopPageObjects(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
    }


    /*-------------Collections Tab Elements------------------*/

    // MyCollections Tab Item
    @AndroidFindBy(xpath = "//android.view.View[@text='My Collections']")
    private AndroidElement myCollectionTabItem;

    // ExclusiveCollections Tab Item
    @AndroidFindBy(xpath = "//android.view.View[@text='Exclusive Collections']")
    private AndroidElement exclusiveCollectionTabItem;


    public void clickOnMyCollectionTabItem(){
        myActions.action_click(myCollectionTabItem);
    }

    public void clickOnExclusiveCollectionTabItem(){
        myActions.action_click(exclusiveCollectionTabItem);
    }


    /*-------------MyCollections Tab Elements------------------*/

    // No-Of-Collection TextView
    @AndroidFindBy(className = "android.view.TextView")
    private AndroidElement noOfCollectionTextView;

    // Create New or add to existing Collections View
    @AndroidFindBy(xpath = "//android.view.View[@text='Create New or add to existing Collections']")
    private AndroidElement createOrAddToNewCollectionText;

    // CreateNewCollection View
    @FindBy(xpath = "//p[contains(text(),'Create New Collection')]")
    private AndroidElement createNewCollectionButton;


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
            new CreateCollectionBottomSheetObjects(androidDriver).
                    performAddCollection(collectionName);
            return collectionName;
    }



    public int getPositionOfCollectionName(String collectionName){
        WebDriverWait webDriverWait = new WebDriverWait(androidDriver,30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='share___2_Him']")));
        int position=0;
        List<AndroidElement> listOfCollections =
                androidDriver.findElements(By.xpath("//div[@class='itemInner___2jJUL']/div[2]/p"));
        for(WebElement element : listOfCollections){
            if(element.getText().equals(collectionName)){
                position =  (listOfCollections.indexOf(element) + 1);
                break;
            }
        }
        System.out.println("Position of element "+collectionName+" is :" +position);
        return position;
    }



    public void enterIntoCollectionFromMyCollections(String collectionName){

    }

}
