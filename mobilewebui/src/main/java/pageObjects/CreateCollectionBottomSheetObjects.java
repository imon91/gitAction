package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

public class CreateCollectionBottomSheetObjects {

    private AndroidDriver<WebElement> driver;
    private MyActions myActions;

    public CreateCollectionBottomSheetObjects(AndroidDriver<WebElement> androidDriver){
        this.driver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
    }




    // CreateNewCollection Text
    @FindBy(css = "#content > div > div:nth-child(4) > div.page-body > div > div > div > div > div:nth-child(2) > div > div.drawerContainer___7enVI.containerBottom___790KD > div > form > div > div")
    private WebElement createNewCollectionText;

    // EnterCollectionName EditText
    @FindBy(css = "#name")
    private WebElement enterYourCollectionNameEditText;

    // SaveCollection Button
    @FindBy(css = "#content > div > div:nth-child(4) > div.page-body > div > div > div > div > div:nth-child(2) > div > div.drawerContainer___7enVI.containerBottom___790KD > div > form > div > button")
    private WebElement saveCollectionButton;

    // Cancel Button
    @FindBy(css = "#content > div > div:nth-child(4) > div.page-body > div > div > div > div > div:nth-child(2) > div > div.drawerContainer___7enVI.containerBottom___790KD > div > div")
    private WebElement cancelCollectionButton;

    // Field Required Error Message
    @FindBy(css = "#content > div > div:nth-child(4) > div.page-body > div > div > div > div > div:nth-child(2) > div > div.drawerContainer___7enVI.containerBottom___790KD > div > form > div > div > p")
    private WebElement fieldRequiredErrorMessage;


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
