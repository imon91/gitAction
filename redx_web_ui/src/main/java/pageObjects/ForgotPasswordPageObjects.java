package pageObjects;

import dataParcer.CSVParser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import utils.*;

import java.util.*;

public class ForgotPasswordPageObjects extends RedXWebBaseClass {

    private WebDriver driver;
    private MyActions myActions;

    public ForgotPasswordPageObjects(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        myActions = new MyActions();
    }

    /*----------Elements----------*/

    private WebElement title;
    private WebElement phoneNumberInput;
    private WebElement phoneNumberErrorMsg;
    private WebElement continueButton;
    private WebElement loginWithOtpIcon;

    /*----------Actions----------*/

    public String getTitleValue()
    {
        title = xpathSetter("//div[@class='login-caption-wrapper']/p");
        return myActions.action_getText(title);
    }

    public void enterPhoneNumberInput(String number)
    {
        phoneNumberInput = xpathSetter("//input[@name='phone']");
        myActions.action_sendKeys(phoneNumberInput,number);
    }

    public String getPhoneNumberErrorMsg()
    {
        phoneNumberErrorMsg = xpathSetter("//div[@class='login-form-wrapper']//div[@class='fieldError']");
        return myActions.action_getText(phoneNumberErrorMsg);
    }

    public void clickContinueButton()
    {
        continueButton = xpathSetter("//div[@class='login-form-wrapper']//button");
        myActions.action_click(continueButton);
    }

    public void clickLoginWithOtp()
    {
        loginWithOtpIcon = xpathSetter("//div[@class='login-form-wrapper']//a[@href='/login/']");
        myActions.action_click(loginWithOtpIcon);
    }

    /*----------Functions----------*/

    public String[] getDataFromCsv(String testName)
    {
        String[] data = new String[4];
        List<HashMap<String, Object>> resetPasswordData = CSVParser.getHashListForDataPath(RedXWebFileUtils.resetPasswordDataCsvFilePath);
        System.out.println(resetPasswordData);
        for (int i = 0; i < resetPasswordData.size(); i++)
        {
            if (resetPasswordData.get(i).get("Test_Case_ID").equals(testName))
            {
                data[0] = resetPasswordData.get(i).get("Phone_Number").toString();
                data[1] = resetPasswordData.get(i).get("Otp").toString();
                data[2] = resetPasswordData.get(i).get("Password").toString();
                data[3] = resetPasswordData.get(i).get("Confirm_Password").toString();
            }
        }
        return data;
    }

    /*----------Classes----------*/

    public class ResetPasswordPageObjects
    {

        /*----------Elements----------*/

        private WebElement title;

        private WebElement phoneNumberValue;
        private WebElement editIcon;

        private List<WebElement> otpInputFields;
        private WebElement otpErrorMsg;
        private WebElement resendOtpIcon;

        private WebElement passwordInput;
        private WebElement passwordEyeIcon;
        private WebElement passwordErrorMessage;

        private WebElement confirmPasswordInput;
        private WebElement confirmPasswordEyeIcon;
        private WebElement confirmPasswordErrorMessage;

        private WebElement verifyButton;
        private WebElement toastMsg;

        /*----------Actions----------*/

        public String getTitleValue()
        {
            title = xpathSetter("//div[@class='login-caption-wrapper']/p");
            return myActions.action_getText(title);
        }

        public String getPhoneNumberValue()
        {
            phoneNumberValue = xpathSetter("//pr[@class='edit']");
            return myActions.action_getText(phoneNumberValue);
        }

        public void clickEditIcon()
        {
            editIcon = xpathSetter("//pr[@class='edit']/a");
            myActions.action_click(editIcon);
        }

        public void enterOtpInput(String otp)
        {
            otpInputFields = xpathListSetter("//div[@class='otp']/input[@class='otp-field']");
            for(int i=0;i<otpInputFields.size();i++)
            {
                myActions.action_sendKeys(otpInputFields.get(i), String.valueOf(otp.charAt(i)));
            }
        }

        public String getOtpErrorMsg()
        {
            otpErrorMsg = xpathSetter("//div[@class='error']");
            return myActions.action_getText(otpErrorMsg);
        }

        public void clickResendOtpIcon()
        {
            resendOtpIcon = xpathSetter("//p[contains(@class,'subtext')]/a");
            myActions.action_click(resendOtpIcon);
        }

        public void enterPasswordInput(String password)
        {
            passwordInput = xpathSetter("//input[@name='password']");
            myActions.action_sendKeys(passwordInput,password);
        }

        public void clearPasswordInput()
        {
            passwordInput = xpathSetter("//input[@name='password']");
            passwordInput.clear();
        }

        public String getPasswordErrorMessage()
        {
            passwordErrorMessage = xpathSetter("//div[@class='password-input']/div[2]");
            return myActions.action_getText(passwordErrorMessage);
        }

        public void clickPasswordEyeIcon()
        {
            passwordEyeIcon = xpathSetter("//input[@name='password']/..//i");
            myActions.action_click(passwordEyeIcon);
        }

        public String getPasswordInputType()
        {
            passwordInput = xpathSetter("//input[@name='password']");
            return passwordInput.getAttribute("type");
        }

        public void enterConfirmPasswordInput(String password)
        {
            confirmPasswordInput = xpathSetter("//input[@name='confirmPassword']");
            myActions.action_sendKeys(confirmPasswordInput,password);
        }

        public void clearConfirmPasswordInput()
        {
            confirmPasswordInput = xpathSetter("//input[@name='confirmPassword']");
            confirmPasswordInput.clear();
        }

        public String getConfirmPasswordErrorMessage()
        {
            confirmPasswordErrorMessage = xpathSetter("//form//div[4]/div[2]");
            return myActions.action_getText(confirmPasswordErrorMessage);
        }

        public void clickConfirmPasswordEyeIcon()
        {
            confirmPasswordEyeIcon = xpathSetter("//input[@name='confirmPassword']/..//i");
            myActions.action_click(confirmPasswordEyeIcon);
        }

        public String getConfirmPasswordInputType()
        {
            passwordInput = xpathSetter("//input[@name='confirmPassword']");
            return passwordInput.getAttribute("type");
        }

        public void clickVerifyButton()
        {
            verifyButton = xpathSetter("//form//button[@type='submit']");
            myActions.action_click(verifyButton);
        }

        public String getToastMsg()
        {
            toastMsg = xpathSetter("//div[@class='ant-message-notice']//span");
            return myActions.action_getText(toastMsg);
        }

        /*----------Functions----------*/

        public List<String> getAllErrorMsg()
        {
            List<String> errorMsg = new ArrayList<>();
            errorMsg.add(getOtpErrorMsg());
            errorMsg.add(getPasswordErrorMessage());
            errorMsg.add(getConfirmPasswordErrorMessage());
            return errorMsg;
        }

        public void performVerifyFunctionality(String otp,String password,String confirmPassword)
        {
            enterOtpInput(otp);
            enterPasswordInput(password);
            enterConfirmPasswordInput(confirmPassword);
        }
    }

    public class ResetPasswordSuccessPageObjects
    {
        private WebElement headerValue;
        private WebElement returnToLoginButton;
        private WebElement loginWithOtpIcon;

        public String getHeaderValue()
        {
            headerValue = xpathSetter("//p[contains(@class,'password-header')]");
            return myActions.action_getText(headerValue);
        }

        public void clickReturnToLoginButton()
        {
            returnToLoginButton = xpathSetter("//button[contains(@class,'login-btn')]");
            myActions.action_click(returnToLoginButton);
            sleep(1500);
        }

        public void clickLoginWithOtpIcon()
        {
            loginWithOtpIcon = xpathSetter("//a[@href='/login/']");
            myActions.action_click(loginWithOtpIcon);
        }
    }
}
