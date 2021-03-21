package pageObjects;

import dataParcer.CSVParser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import utils.*;

import java.util.*;

public class NotificationSettingsPageObjects extends RedXWebBaseClass {

    private WebDriver driver;
    private MyActions myActions;

    public NotificationSettingsPageObjects(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        myActions = new MyActions();
    }

    /*----------Elements----------*/

    private WebElement phoneNumberInput;
    private WebElement phoneNumberErrorMsg;
    private WebElement emailAddressInput;
    private WebElement emailAddressErrorMsg;
    private WebElement cancelButton;
    private WebElement saveButton;
    private WebElement toastMsg;

    /*----------Actions----------*/

    public void enterPhoneNumberInput(String number)
    {
        phoneNumberInput = xpathSetter("//input[@name='SHOP_PHONE']");
        phoneNumberInput.clear();
        myActions.action_sendKeys(phoneNumberInput,number);
    }

    public String getPhoneNumberErrorMsg()
    {
        phoneNumberErrorMsg = xpathSetter("//input[@name='SHOP_PHONE']/../div[@class='fieldError']");
        return myActions.action_getText(phoneNumberErrorMsg);
    }

    public void enterEmailAddressInput(String email)
    {
        emailAddressInput = xpathSetter("//input[@name='SHOP_EMAIL']");
        emailAddressInput.clear();
        myActions.action_sendKeys(emailAddressInput,email);
    }

    public String getEmailAddressErrorMsg()
    {
        emailAddressErrorMsg = xpathSetter("//input[@name='SHOP_EMAIL']/../div[@class='fieldError']");
        return myActions.action_getText(emailAddressErrorMsg);
    }

    public void clickCancelButton()
    {
        cancelButton = xpathSetter("//a[contains(text(),'Cancel')]");
        myActions.action_click(cancelButton);
    }

    public void clickSaveButton()
    {
        saveButton = xpathSetter("//button[@type='submit']");
        myActions.action_click(saveButton);
    }

    public String getToastMsg()
    {
        toastMsg = xpathSetter("//div[@class='ant-message-notice']//span");
        return myActions.action_getText(toastMsg);
    }

    /*----------Functions----------*/

    public String[] getDataFromCsv(String testId)
    {
        String[] data = new String[2];
        List<HashMap<String, Object>> notificationSettingData = CSVParser.getHashListForDataPath(RedXWebFileUtils.notificationSettingsDataCsvFilePath);
        for (int i = 0; i < notificationSettingData.size(); i++)
        {
            if(notificationSettingData.get(i).get("Test_Case_ID").equals(testId))
            {
                data[0]=notificationSettingData.get(i).get("Phone_Number").toString();
                data[1]=notificationSettingData.get(i).get("Email_Address").toString();
            }
        }
        System.out.println("Input Data : " + Arrays.toString(data));
        return data;
    }

    public List<String> getAllErrorMsg()
    {
        List<String> errorMsg = new ArrayList<>();
        errorMsg.add(getPhoneNumberErrorMsg());
        errorMsg.add(getEmailAddressErrorMsg());
        return errorMsg;
    }

    public void saveNotificationDetails(String number, String email)
    {
        enterPhoneNumberInput(number);
        enterEmailAddressInput(email);
        clickSaveButton();
    }
}