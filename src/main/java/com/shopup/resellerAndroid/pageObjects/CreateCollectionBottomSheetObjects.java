package com.shopup.resellerAndroid.pageObjects;

import com.shopup.utils.MyActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCollectionBottomSheetObjects {


    private AndroidDriver<AndroidElement> androidDriver;
    private MyActions myActions;

    public CreateCollectionBottomSheetObjects(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
    }




    // CreateNewCollection Text
    @AndroidFindBy(xpath = "//android.view.View[@text='Create New Collection']")
    private AndroidElement createNewCollectionText;

    // EnterCollectionName EditText
    @FindBy(xpath = "//*[@id=\"name\"]")
    private AndroidElement enterYourCollectionNameEditText;

    // SaveCollection Button
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/div/div[2]/div/div[3]/div/form/div/button")
    private AndroidElement saveCollectionButton;

    // Cancel Button
    @AndroidFindBy(xpath = "//android.widget.Image[0]")
    private AndroidElement cancelCollectionButton;

    // Field Required Error Message
    @AndroidFindBy(xpath = "//android.view.View[@text='This field is required']")
    private AndroidElement fieldRequiredErrorMessage;


    private String getCreateNewCollectionText(){
        return myActions.action_getText(createNewCollectionText);
    }

    private void enterCollectionName(String collectionName){
        myActions.action_sendKeys(enterYourCollectionNameEditText,collectionName);
    }

    private void clickOnSaveCollectionButton(){
        myActions.action_click(saveCollectionButton);
    }

    private void clickOnCancelCollectionButton(){
        myActions.action_click(cancelCollectionButton);
    }

    private void getTheErrorMessage(){
        myActions.action_getText(fieldRequiredErrorMessage);
    }


    /*-----------Functions---------------*/

    public void performAddCollection(String collectionName){
        enterCollectionName(collectionName);
        clickOnSaveCollectionButton();
    }

    public void performCancelTheAddCollection(String collectionName){
        enterCollectionName(collectionName);
        clickOnCancelCollectionButton();
    }

}
