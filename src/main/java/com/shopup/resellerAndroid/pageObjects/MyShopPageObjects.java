package com.shopup.resellerAndroid.pageObjects;

import com.shopup.utils.MyActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div[2]/div/div/div/div/div/div[2]/div/div[2]/div[1]/div")
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



}
