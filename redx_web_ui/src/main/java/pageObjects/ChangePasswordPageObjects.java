package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import utils.*;

import java.util.*;

public class ChangePasswordPageObjects extends RedXWebBaseClass {

    private WebDriver driver;
    private MyActions myActions;

    public ChangePasswordPageObjects(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        myActions = new MyActions();
    }

    /*----------Elements----------*/

    private WebElement currentPasswordInput;
    private WebElement currentPasswordErrorMsg;
    private WebElement newPasswordInput;
    private WebElement newPasswordErrorMsg;
    private WebElement confirmPasswordInput;
    private WebElement confirmPasswordErrorMsg;
    private WebElement saveButton;
    private WebElement resetButton;
    private WebElement toastMsg;

    /*----------Actions----------*/

    public void enterCurrentPasswordInput(String password)
    {
        currentPasswordInput = xpathSetter("//input[@name='currentPassword']");
        myActions.action_sendKeys(currentPasswordInput,password);
    }

    public String getCurrentPasswordErrorMsg()
    {
        currentPasswordErrorMsg = xpathSetter("//input[@name='currentPassword']/../div[@class='fieldError']");
        return myActions.action_getText(currentPasswordErrorMsg);
    }

    public void enterNewPasswordInput(String password)
    {
        newPasswordInput = xpathSetter("//input[@name='password']");
        myActions.action_sendKeys(newPasswordInput,password);
    }

    public String getNewPasswordErrorMsg()
    {
        newPasswordErrorMsg = xpathSetter("//input[@name='password']/../div[@class='fieldError']");
        return myActions.action_getText(newPasswordErrorMsg);
    }

    public void enterConfirmPasswordInput(String password)
    {
        confirmPasswordInput = xpathSetter("//input[@name='confirmPassword']");
        myActions.action_sendKeys(confirmPasswordInput,password);
    }

    public String getConfirmPasswordErrorMsg()
    {
        confirmPasswordErrorMsg = xpathSetter("//input[@name='confirmPassword']/../div[@class='fieldError']");
        return myActions.action_getText(confirmPasswordErrorMsg);
    }

    public void clickSaveButton()
    {
        saveButton = xpathSetter("//span[contains(text(),'Save')]/..");
        myActions.action_click(saveButton);
    }

    public void clickResetButton()
    {
        resetButton = xpathSetter("//a[@href='/forgot-password/']");
        myActions.action_click(resetButton);
        sleep(2000);
    }

    public String getToastMsg()
    {
        toastMsg = xpathSetter("//div[@class='ant-message-notice']//span");
        return myActions.action_getText(toastMsg);
    }

    /*----------Functions----------*/

    public void performChangePassword(String currentPwd, String newPwd, String confirmPwd)
    {
        enterCurrentPasswordInput(currentPwd);
        enterNewPasswordInput(newPwd);
        enterConfirmPasswordInput(confirmPwd);
        clickSaveButton();
    }

    public List<String> getAllErrorMsg()
    {
        List<String> errorMsg = new ArrayList<>();
        errorMsg.add(getCurrentPasswordErrorMsg());
        errorMsg.add(getNewPasswordErrorMsg());
        errorMsg.add(getConfirmPasswordErrorMsg());
        return errorMsg;
    }
}
