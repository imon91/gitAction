package pageObjects;

import dataParcer.CSVParser;
import org.apache.commons.collections4.Get;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import services.redxMethods.GetRedxApiResponse;
import services.responseModels.redxModels.BanksModel;
import services.responseModels.redxModels.BranchesModel;
import utils.*;

import java.util.*;

public class MyPaymentDetailsPageObjects extends RedXWebBaseClass {

    private WebDriver driver;
    private MyActions myActions;
    private GetRedxApiResponse getRedxApiResponse;
    private Random random;

    public MyPaymentDetailsPageObjects(WebDriver driver) throws Exception
    {
        this.driver = driver;
        PageFactory.initElements((driver),this);
        myActions = new MyActions();
        getRedxApiResponse = new GetRedxApiResponse("redxweb");
        random = new Random();
    }

    /*----------Elements----------*/

    private WebElement changePaymentLink;
    private WebElement paymentMethod;
    private List<WebElement> cardTextElements;

    private WebElement bkashValue;

    private WebElement bankNameValue;
    private WebElement accountNameValue;
    private WebElement branchNameValue;
    private WebElement accountNumberValue;

    private WebElement toastMsg;

    /*----------Actions----------*/

    public void clickChangePaymentLink()
    {
        changePaymentLink = xpathSetter("//a[@href='/update-shop-payment/']");
        myActions.action_click(changePaymentLink);
        sleep(2000);
    }

    public String getPaymentMethod()
    {
        paymentMethod = xpathSetter("//main/p[@class='title']");
        String method = myActions.action_getText(paymentMethod);
        return method.substring(51);
    }

    public int getCardTextElements()
    {
        cardTextElements = xpathListSetter("//div[@class='card']/p");
        return cardTextElements.size();
    }

    public String getBkashValue()
    {
        bkashValue = xpathSetter("//span[text()='Bkash Number']/../span[@class='card__text__value']");
        return myActions.action_getText(bkashValue);
    }

    public String getBankNameValue()
    {
        bankNameValue = xpathSetter("//span[text()='Bank Name']/../span[@class='card__text__value']");
        return myActions.action_getText(bankNameValue);
    }

    public String getAccountNameValue()
    {
        accountNameValue = xpathSetter("//span[text()='Account Holder Name']/../span[@class='card__text__value']");
        return myActions.action_getText(accountNameValue);
    }

    public String getBranchNameValue()
    {
        branchNameValue = xpathSetter("//span[text()='Branch Name']/../span[@class='card__text__value']");
        return myActions.action_getText(branchNameValue);
    }

    public String getAccountNumberValue()
    {
        accountNumberValue = xpathSetter("//span[text()='Account Number']/../span[@class='card__text__value']");
        return myActions.action_getText(accountNumberValue);
    }

    public String getToastMsg()
    {
        toastMsg = xpathSetter("//div[@class='ant-message-notice']//span");
        return myActions.action_getText(toastMsg);
    }

    /*----------Functions----------*/

    public List<String> getPaymentDetails()
    {
        String method = getPaymentMethod();
        List<String> details = new ArrayList<>();
        switch (method)
        {
            case "Bkash":
                details.add(getBkashValue());
                break;
            case "Bank":
                details.add(getBankNameValue());
                details.add(getAccountNameValue());
                details.add(getBranchNameValue());
                details.add(getAccountNumberValue());
                break;
        }
        return details;
    }

    /*----------Classes----------*/

    public class UpdatePaymentDetailsPageObjects
    {
        /*----------Elements----------*/

        private WebElement paymentMethodRadioInput;
        private WebElement checkedPaymentMethod;
        private List<WebElement> antRowElements;
        private WebElement confirmButton;

        private WebElement bankNameInput;
        private WebElement branchNameInput;
        private WebElement accountNameInput;
        private WebElement accountNameErrorMsg;
        private WebElement accountTypeInput;
        private WebElement accountNumberInput;
        private WebElement accountNumberErrorMsg;

        private WebElement bkashNumberInput;
        private WebElement bkashNumberErrorMsg;
        private WebElement confirmBkashNumberInput;
        private WebElement confirmBkashNumberErroMsg;

        private WebElement title;
        private WebElement closeIcon;
        private WebElement otpInput;
        private WebElement authenticateButton;
        private WebElement resendOtpButton;

        private String[] methods = {"Bank Account","BKash"};
        private String[] accountType = {"Saving","AWCDI","SND","STD","AWCA"};

        /*----------Actions----------*/

        public void choosePaymentMethod(String method)
        {
            paymentMethodRadioInput = xpathSetter("//span[text()='" + method + "']/..");
            myActions.action_click(paymentMethodRadioInput);
        }

        public String choosePaymentMethod()
        {
            int index = random.nextInt(2);
            String method = methods[index];
            choosePaymentMethod(method);
            return method;
        }

        public String getCheckedPaymentMethod()
        {
            checkedPaymentMethod = xpathSetter("//label[@class='ant-radio-wrapper ant-radio-wrapper-checked']/span[text()]");
            return myActions.action_getText(checkedPaymentMethod);
        }

        public int getAntRowElements()
        {
            antRowElements = xpathListSetter("//form//div[@class='ant-row']");
            return antRowElements.size();
        }

        public void clickConfirmButton()
        {
            confirmButton = xpathSetter("//button[@type='submit']");
            myActions.action_click(confirmButton);
        }

        public void clickBankNameInput()
        {
            bankNameInput = xpathSetter("//form//div[@class='ant-row'][1]//i");
            myActions.action_click(bankNameInput);
        }

        public void enterBankNameInput(String bankName)
        {
            bankNameInput = xpathSetter("//form//div[@class='ant-row'][1]/div[1]//input[@class='ant-select-search__field']");
            myActions.action_sendKeys(bankNameInput,bankName);
        }

        public String enterBankNameInput()
        {
            BanksModel banksModel = getRedxApiResponse.bankListGetCall();
            int size = banksModel.getBanks().size();
            int index = random.nextInt(size);
            String name = banksModel.getBanks().get(index).getBANK_NAME();
            clickBankNameInput();
            enterBankNameInput(name);
            return name;
        }

        public void clickBranchNameInput()
        {
            branchNameInput = xpathSetter("//form//div[@class='ant-row'][1]/div[2]//div[@class='ant-select-selection__rendered']");
            myActions.action_click(branchNameInput);
        }

        public void enterBranchNameInput(String branchName)
        {
            branchNameInput = xpathSetter("//form//div[@class='ant-row'][1]/div[2]//input[@class='ant-select-search__field']");
            myActions.action_sendKeys(branchNameInput,branchName);
            sleep(1500);
            branchNameInput.sendKeys(Keys.ENTER);
        }

        public String enterBranchNameInput(int bankId)
        {
            BranchesModel branchesModel = getRedxApiResponse.branchListGetCall(bankId);
            int size = branchesModel.getBranches().size();
            int index = random.nextInt(size);
            String name = branchesModel.getBranches().get(index).getBRANCH_NAME();
            clickBranchNameInput();
            enterBranchNameInput(name);
            return name;
        }

        public void enterAccountNameInput(String accountName)
        {
            accountNameInput = xpathSetter("//input[@name='ACCOUNT_NAME']");
            accountNameInput.clear();
            myActions.action_sendKeys(accountNameInput,accountName);
        }

        public String getAccountNameErrorMsg()
        {
            accountNameErrorMsg = xpathSetter("//input[@name='ACCOUNT_NAME']/../div[@class='fieldError']");
            return myActions.action_getText(accountNameErrorMsg);
        }

        public void clickAccountTypeInput()
        {
            accountTypeInput = xpathSetter("//form//div[@class='ant-row'][2]/div[2]//div[@class='ant-select-selection__rendered']");
            myActions.action_click(accountTypeInput);
        }

        public void chooseAccountTypeInput(String accountType)
        {
            accountTypeInput = xpathSetter("//li[@title='" + accountType + "']");
            myActions.action_click(accountTypeInput);
        }

        public String chooseAccountTypeInput()
        {
            int index = random.nextInt(5);
            String type = accountType[index];
            clickAccountTypeInput();
            chooseAccountTypeInput(type);
            return type;
        }

        public void enterAccountNumberInput(String accountNumber)
        {
            accountNumberInput = xpathSetter("//input[@name='ACCOUNT_NUMBER']");
            accountNumberInput.clear();
            myActions.action_sendKeys(accountNumberInput,accountNumber);
        }

        public String getAccountNumberErrorMsg()
        {
            accountNumberErrorMsg = xpathSetter("//input[@name='ACCOUNT_NUMBER']/../div[@class='fieldError']");
            return myActions.action_getText(accountNumberErrorMsg);
        }

        public void enterBkashNumberInput(String number)
        {
            bkashNumberInput = xpathSetter("//input[@name='BKASH_NUMBER']");
            bkashNumberInput.clear();
            myActions.action_sendKeys(bkashNumberInput,number);
        }

        public String getBkashNumberErrorMsg()
        {
            bkashNumberErrorMsg = xpathSetter("//input[@name='BKASH_NUMBER']/../div[@class='fieldError']");
            return myActions.action_getText(bkashNumberErrorMsg);
        }

        public void enterConfirmBkashNumberInput(String number)
        {
            confirmBkashNumberInput = xpathSetter("//input[@name='CONFIRM_BKASH_NUMBER']");
            confirmBkashNumberInput.clear();
            myActions.action_sendKeys(confirmBkashNumberInput,number);
        }

        public String getConfirmBkashNumberErrorMsg()
        {
            confirmBkashNumberErroMsg = xpathSetter("//input[@name='CONFIRM_BKASH_NUMBER']/../div[@class='fieldError']");
            return myActions.action_getText(confirmBkashNumberErroMsg);
        }

        public String getTitle()
        {
            title = xpathSetter("//p[contains(@class,'modal-title')]");
            return myActions.action_getText(title);
        }

        public void enterOtpInput(String otp)
        {
            otpInput = xpathSetter("//div[@class='ant-modal-body']//input");
            myActions.action_sendKeys(otpInput,otp);
        }

        public void clickAuthenticateButton()
        {
            authenticateButton = xpathSetter("//span[text()='Authenticate']/..");
            myActions.action_click(authenticateButton);
        }

        public void clickResendOtpButton()
        {
            resendOtpButton = xpathSetter("//span[text()='Resend OTP']/..");
            myActions.action_click(resendOtpButton);
        }

        public void clickCloseIcon()
        {
            closeIcon = xpathSetter("//button[@class='ant-modal-close']");
            myActions.action_click(closeIcon);
        }

        /*----------Functions----------*/

        public List<String> getDataFromCsv(String testId)
        {
            List<String> data = new ArrayList<>();
            List<HashMap<String, Object>> addPaymentMethodData = CSVParser.getHashListForDataPath(RedXWebFileUtils.myPaymentDetailsDataCsvFilePath);
            String method = getCheckedPaymentMethod();

            for (int i = 0; i < addPaymentMethodData.size(); i++)
            {
                if(addPaymentMethodData.get(i).get("Test_Case_ID").equals(testId))
                {
                    switch (method)
                    {
                        case "Bank Account":
                            data.add(addPaymentMethodData.get(i).get("Bank_Name").toString());
                            data.add(addPaymentMethodData.get(i).get("Branch_Name").toString());
                            data.add(addPaymentMethodData.get(i).get("Account_Name").toString());
                            data.add(addPaymentMethodData.get(i).get("Account_Type").toString());
                            data.add(addPaymentMethodData.get(i).get("Account_Number").toString());
                            break;
                        case "BKash":
                            data.add(addPaymentMethodData.get(i).get("Bkash_Number").toString());
                            data.add(addPaymentMethodData.get(i).get("Confirm_Bkash_Number").toString());
                            break;
                    }
                }
            }
            return data;
        }

        public List<String> getAllErrorMessages()
        {
            List<String> errorMsgs = new ArrayList<>();
            String method = getCheckedPaymentMethod();
            switch (method)
            {
                case "Bank Account":
                    errorMsgs.add(getAccountNameErrorMsg());
                    errorMsgs.add(getAccountNumberErrorMsg());
                    break;
                case "BKash":
                    errorMsgs.add(getBkashNumberErrorMsg());
                    errorMsgs.add(getConfirmBkashNumberErrorMsg());
                    break;
            }
            return errorMsgs;
        }

        public void addPaymentMethod(List<String> data)
        {
            String method = getCheckedPaymentMethod();
            String bankName = new String();
            switch (method)
            {
                case "Bank Account":
                    for(int i = 0;i<data.size();i++) {
                        switch (i) {
                            case 0:
                                switch (data.get(i))
                                {
                                    case "random":
                                        bankName = enterBankNameInput();
                                        System.out.println("Bank Name : " + bankName);
                                        break;
                                    case "N/A":
                                        break;
                                    default: enterBankNameInput(data.get(i));
                                }
                                break;
                            case 1:
                                switch (data.get(i))
                                {
                                    case "random":
                                        int bankId = getRedxApiResponse.getBankId(bankName);
                                        System.out.println("Branch Name : " + enterBranchNameInput(bankId));
                                        break;
                                    case "N/A":
                                        break;
                                    default: enterBranchNameInput(data.get(i));
                                }
                                break;
                            case 2:
                                switch (data.get(i))
                                {
                                    case "random":
                                        String name = "Account Name " + random.nextInt(1000);
                                        System.out.println("Name : " + name);
                                        enterAccountNameInput(name);
                                        break;
                                    default: enterAccountNameInput(data.get(i));
                                }
                                break;
                            case 3:
                                switch (data.get(i))
                                {
                                    case "random":
                                        System.out.println("Account Type : " + chooseAccountTypeInput());
                                        break;
                                    case "N/A":
                                        break;
                                    default: chooseAccountTypeInput(data.get(i));
                                }
                                break;
                            case 4:
                                switch (data.get(i))
                                {
                                    case "random":
                                        int num = random.nextInt(100000);
                                        System.out.println("Account Number : " + num);
                                        enterAccountNumberInput(String.valueOf(num));
                                        break;
                                    default: enterAccountNumberInput(data.get(i));
                                }
                                break;
                        }
                    }
                    break;
                case "BKash":
                    for(int i = 0;i<data.size();i++) {
                        switch (i)
                        {
                            case 0:
                                System.out.println("Bkash Number : " + data.get(i));
                                enterBkashNumberInput(data.get(i));
                                break;
                            case 1:
                                System.out.println("Confirm Bkash Number : " + data.get(i));
                                enterConfirmBkashNumberInput(data.get(i));
                                break;
                        }
                    }
                    break;
            }
        }
    }
}
