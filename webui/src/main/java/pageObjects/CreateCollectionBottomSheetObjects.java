package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

public class CreateCollectionBottomSheetObjects {


    private WebDriver driver;
    private MyActions myActions;

    public CreateCollectionBottomSheetObjects(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        myActions = new MyActions();
    }




    // CreateNewCollection Text
    @FindBy(xpath = "//p[contains(text(),'Create New Collection')]")
    private WebElement createNewCollectionText;

    // EnterCollectionName EditText
    @FindBy(xpath = "//input[@id='name']")
    private WebElement enterYourCollectionNameEditText;

    // SaveCollection Button
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    private WebElement saveCollectionButton;

    // Cancel Button
    @FindBy(xpath = " //*[@id=\"content\"]/div/div[2]/div[2]/div/div/div/div/div/div[2]/div/div[3]/div/div/svg")
    private WebElement cancelCollectionButton;

    // Field Required Error Message
    @FindBy(xpath = "//p[contains(text(),'This field is required')]")
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
