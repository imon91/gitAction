package pageObjects;

import utils.MyActions;
import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.*;

public class CreateCollectionBottomSheetObjects {


    private AndroidDriver<AndroidElement> androidDriver;
    private MyActions myActions;

    public CreateCollectionBottomSheetObjects(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
    }




    // CreateNewCollection Text
    @FindBy(xpath = "//p[contains(text(),'Create New Collection')]")
    private AndroidElement createNewCollectionText;

    // EnterCollectionName EditText
    @FindBy(xpath = "//input[@id='name']")
    private AndroidElement enterYourCollectionNameEditText;

    // SaveCollection Button
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    private AndroidElement saveCollectionButton;

    // Cancel Button
    @FindBy(xpath = " //*[@id=\"content\"]/div/div[2]/div[2]/div/div/div/div/div/div[2]/div/div[3]/div/div/svg")
    private AndroidElement cancelCollectionButton;

    // Field Required Error Message
    @FindBy(xpath = "//p[contains(text(),'This field is required')]")
    private AndroidElement fieldRequiredErrorMessage;


    /*--------------Actions-------------------*/



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
