package pageObjects;

import dataParcer.CSVParser;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import utils.*;

import java.util.*;

public class CreateShopPageObjects extends RedXWebBaseClass {

    private WebDriver driver;
    private MyActions myActions;
    private Random random;
    private Actions actions;

    public CreateShopPageObjects(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
        random = new Random();
        actions = new Actions(driver);
    }

    /*----------Elements----------*/

    private WebElement titleWrapper;
    private WebElement closeIcon;

    private WebElement accountTypeDropDown;
    private WebElement accountTypeDropDownOption;

    private WebElement fullNameInput;
    private WebElement fullNameErrorMessage;

    private WebElement shopNameInput;
    private WebElement shopNameErrorMessage;

    private WebElement shopEmailInput;
    private WebElement shopEmailErrorMessage;

    private WebElement shopAddressInput;
    private WebElement shopAddressErrorMessage;

    private WebElement pickupAddressInput;
    private WebElement pickupAddressErrorMessage;

    private WebElement pickupAreaInput;
    private WebElement searchArea;
    private WebElement areaInputOption;
    private List<WebElement> areaInputOptions;

    private WebElement pickupPhoneInput;
    private WebElement pickupPhoneErrorMessage;

    private WebElement productTypeDropDown;
    private WebElement productTypeDropDownOption;

    private WebElement passwordInput;
    private WebElement passwordEyeIcon;
    private WebElement passwordErrorMessage;

    private WebElement confirmPasswordInput;
    private WebElement confirmPasswordEyeIcon;
    private WebElement confirmPasswordErrorMessage;

    private WebElement referredByInput;
    private WebElement referredByErrorMessage;

    private WebElement referrerCodeInput;
    private WebElement referrerCodeErrorMessage;
    private WebElement addShopButton;

    private String[] accountType = {"Business use","Personal use"};
    private String[] productType = {"Electronics","Jewellery","Clothing","Craft","Fashion Accessories","Fragile","Others"};
    private String[] inputType = {"alpha","numeric","alphanumeric"};

    /*----------Actions----------*/

    public String getTitle()
    {
        titleWrapper = xpathSetter("//section[@id='shop-form']//div[@class='header-wrapper']//p");
        return myActions.action_getText(titleWrapper);
    }

    public void clickCloseIcon()
    {
        closeIcon = xpathSetter("//section[@id='shop-form']//div[@class='icon-wrapper']/i");
        myActions.action_click(closeIcon);
    }

    public void clickAccountTypeDropDown()
    {
        accountTypeDropDown = xpathSetter("//form/div[@class='selectInput']//i");
        myActions.action_click(accountTypeDropDown);
    }

    public String chooseAccountTypeDropDownOption(String option)
    {
        clickAccountTypeDropDown();
        accountTypeDropDownOption = xpathSetter("//div[contains(@class,'ant-select-dropdown')][not(contains(@class,'hidden'))]//li[@title='" + option + "']");
        myActions.action_click(accountTypeDropDownOption);
        return option;
    }

    public void clickFullNameInput()
    {
        fullNameInput = xpathSetter("//input[@name='name']");
        myActions.action_click(fullNameInput);
    }

    public String getFullNameErrorMessage()
    {
        fullNameErrorMessage = xpathSetter("//input[@name='name']/..//div[@class='fieldError']");
        return myActions.action_getText(fullNameErrorMessage);
    }

    public void enterFullNameInput(String name)
    {
        fullNameInput = xpathSetter("//input[@name='name']");
        fullNameInput.clear();
        myActions.action_sendKeys(fullNameInput,name);
    }

    public void clickShopNameInput()
    {
        shopNameInput = xpathSetter("//input[@name='businessName']");
        myActions.action_click(shopNameInput);
    }

    public String getShopNameErrorMessage()
    {
        shopNameErrorMessage = xpathSetter("//input[@name='businessName']/..//div[@class='fieldError']");
        return myActions.action_getText(shopNameErrorMessage);
    }

    public void enterShopNameInput(String shopName)
    {
        shopNameInput = xpathSetter("//input[@name='businessName']");
        shopNameInput.clear();
        myActions.action_sendKeys(shopNameInput,shopName);
    }

    public void clickShopEmailInput()
    {
        shopEmailInput = xpathSetter("//input[@name='shopEmail']");
        myActions.action_click(shopEmailInput);
    }

    public String getShopEmailErrorMessage()
    {
        shopEmailErrorMessage = xpathSetter("//input[@name='shopEmail']/..//div[@class='fieldError']");
        return myActions.action_getText(shopEmailErrorMessage);
    }

    public void enterShopEmailInput(String shopEmail)
    {
        shopEmailInput = xpathSetter("//input[@name='shopEmail']");
        shopEmailInput.clear();
        myActions.action_sendKeys(shopEmailInput,shopEmail);
    }

    public void clickShopAddressInput()
    {
        shopAddressInput = xpathSetter("//input[@name='shopAddress']");
        myActions.action_click(shopAddressInput);
    }

    public String getShopAddressErrorMessage()
    {
        shopAddressErrorMessage = xpathSetter("//input[@name='shopAddress']/..//div[@class='fieldError']");
        return myActions.action_getText(shopAddressErrorMessage);
    }

    public void enterShopAddressInput(String shopAddress)
    {
        shopAddressInput = xpathSetter("//input[@name='shopAddress']");
        shopAddressInput.clear();
        myActions.action_sendKeys(shopAddressInput,shopAddress);
    }

    public void clickPickupAddressInput()
    {
        pickupAddressInput = xpathSetter("//input[@name='pickupAddress']");
        myActions.action_click(pickupAddressInput);
    }

    public String getPickupAddressErrorMessage()
    {
        pickupAddressErrorMessage = xpathSetter("//input[@name='pickupAddress']/..//div[@class='fieldError']");
        return myActions.action_getText(pickupAddressErrorMessage);
    }

    public void enterPickupAddressInput(String pickupAdress)
    {
        pickupAddressInput = xpathSetter("//input[@name='pickupAddress']");
        pickupAddressInput.clear();
        myActions.action_sendKeys(pickupAddressInput,pickupAdress);
    }

    public void clickPickupAreaInput()
    {
        pickupAreaInput = xpathSetter("//form/div[@class='ant-row'][3]//i");
        myActions.action_click(pickupAreaInput);
    }

    public void searchArea(String area)
    {
        searchArea = xpathSetter("//div[@class='right-form']/div[1]//input");
        myActions.action_sendKeys(searchArea,area);
    }

    public String chooseArea()
    {
        areaInputOptions = xpathListSetter("//div[@class='area-tree']/p/span");
        int size = areaInputOptions.size();
        int index = random.nextInt(size);
        String area = areaInputOptions.get(index).getText();
        System.out.println("Index : " + index);
        myActions.action_click(areaInputOptions.get(index));
        return area;
    }

    public void chooseArea(String area)
    {
        searchArea(area);
        areaInputOption = xpathSetter("//div[@class='area-tree']/p/span[text()='" + area + "']");
        myActions.action_click(areaInputOption);
    }

    public void clickPickupPhoneInput()
    {
        pickupPhoneInput = xpathSetter("//input[@name='phone']");
        myActions.action_click(pickupPhoneInput);
    }

    public String getPickupPhoneErrorMessage()
    {
        pickupPhoneErrorMessage = xpathSetter("//input[@name='phone']/..//div[@class='fieldError']");
        return myActions.action_getText(pickupPhoneErrorMessage);
    }

    public void enterPickupPhoneInput(String pickupPhone)
    {
        pickupPhoneInput = xpathSetter("//input[@name='phone']");
        pickupPhoneInput.clear();
        myActions.action_sendKeys(pickupPhoneInput,pickupPhone);
    }

    public void clickProductTypeDropDown()
    {
        productTypeDropDown = xpathSetter("//form/div[@class='ant-row'][4]//i");
        myActions.action_click(productTypeDropDown);
    }

    public void chooseProductTypeDropDown(String option)
    {
        clickProductTypeDropDown();
        productTypeDropDownOption = xpathSetter("//div[contains(@class,'ant-select-dropdown')][not(contains(@class,'hidden'))]//li[@title='" + option + "']");
        myActions.action_click(productTypeDropDownOption);
    }

    public void enterPasswordInput(String password)
    {
        passwordInput = xpathSetter("//input[@name='password']");
        passwordInput.clear();
        myActions.action_sendKeys(passwordInput,password);
    }

    public void clearPasswordInput()
    {
        passwordInput = xpathSetter("//input[@name='password']");
        passwordInput.clear();
    }

    public String getPasswordErrorMessage()
    {
        passwordErrorMessage = xpathSetter("//form/div[@class='ant-row'][5]/div[1]/div[@style][2]");
        return myActions.action_getText(passwordErrorMessage);
    }

    public void clickPasswordEyeIcon()
    {
        passwordEyeIcon = xpathSetter("//form/div[@class='ant-row'][5]/div[1]//i");
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
        confirmPasswordInput.clear();
        myActions.action_sendKeys(confirmPasswordInput,password);
    }

    public void clearConfirmPasswordInput()
    {
        confirmPasswordInput = xpathSetter("//input[@name='confirmPassword']");
        confirmPasswordInput.clear();
    }

    public String getConfirmPasswordErrorMessage()
    {
        confirmPasswordErrorMessage = xpathSetter("//form/div[@class='ant-row'][5]/div[2]/div[@style][2]");
        return myActions.action_getText(confirmPasswordErrorMessage);
    }

    public void clickConfirmPasswordEyeIcon()
    {
        confirmPasswordEyeIcon = xpathSetter("//form/div[@class='ant-row'][5]/div[2]//i");
        myActions.action_click(confirmPasswordEyeIcon);
    }

    public String getConfirmPasswordInputType()
    {
        passwordInput = xpathSetter("//input[@name='confirmPassword']");
        return passwordInput.getAttribute("type");
    }

    public void enterReferredByInput(String reference)
    {
        referredByInput = xpathSetter("//input[@name='referrerUserId']");
        referredByInput.clear();
        myActions.action_sendKeys(referredByInput,reference);
    }

    public String getReferredByErrorMessage()
    {
        referredByErrorMessage = xpathSetter("//input[@name='referrerUserId']/../div[@class='fieldError']");
        return myActions.action_getText(referredByErrorMessage);
    }

    public void enterReferrerCodeInput(String reference)
    {
        referrerCodeInput = xpathSetter("//input[@name='referrerCode']");
        referrerCodeInput.clear();
        myActions.action_sendKeys(referrerCodeInput,reference);
    }

    public String getReferrerCodeErrorMessage()
    {
        referrerCodeErrorMessage = xpathSetter("//input[@name='referrerCode']/../div[@class='fieldError']");
        return myActions.action_getText(referrerCodeErrorMessage);
    }

    public void clickAddShopButton()
    {
        addShopButton = xpathSetter("//form//div[@class='button']/button[@type='submit']");
        myActions.action_click(addShopButton);
    }


    /*----------Functions----------*/

    public String getRandomValue(String filter)
    {
        int index;
        String value = null;
        switch (filter)
        {
            case "Account Type":
                index = random.nextInt(2);
                value = accountType[index];
                break;
            case "Product Type":
                index = random.nextInt(7);
                value = productType[index];
                break;
            case "Value":
                index = random.nextInt(3);
                value = inputType[index];
                break;
        }
        return value;
    }

    public String setAreaInput(String ...areaInput)
    {
        clickPickupAreaInput();
        for(int i=0;i<areaInput.length;i++)
        {
            switch (i)
            {
                case 0:
                    if(areaInput[i].equalsIgnoreCase("random"))
                        areaInput[i] = chooseArea();
                    else chooseArea(areaInput[i]);
                    System.out.println("Division : " + areaInput[i]);
                    break;
                case 1:
                    if(areaInput[i].equalsIgnoreCase("random"))
                        areaInput[i] = chooseArea();
                    else chooseArea(areaInput[i]);
                    System.out.println("District : " + areaInput[i]);
                    break;
                case 2:
                    if(areaInput[i].equalsIgnoreCase("random"))
                        areaInput[i] = chooseArea();
                    else chooseArea(areaInput[i]);
                    System.out.println("Area : " + areaInput[i]);
                    break;
            }
        }
        return areaInput[2];
    }

    public List<String> getDataFromCsv(String testCaseName,String inputTestCaseId,String errorMsgTestCaseId) throws Exception
    {
        List<HashMap<String, Object>> createShopData = CSVParser.getHashListForDataPath(RedXWebFileUtils.registrationFlowDataCsvFilePath);
        List<String> data = new ArrayList<>();
        for(int i=0;i<createShopData.size();i++) {
            if (createShopData.get(i).get("Test_Case_Name").equals(testCaseName))
            {
                if (createShopData.get(i).get("Test_Case_Id").equals(inputTestCaseId))
                {
                    switch (testCaseName)
                    {
                        case "Phone Number Validation":
                            data.add(getInputValue("Pickup_Phone", String.valueOf(createShopData.get(i).get("Pickup_Phone*"))));
                            break;
                        default:
                            data.add(getInputValue("Account_Type", String.valueOf(createShopData.get(i).get("Account_Type"))));
                            data.add(getInputValue("Full_Name", String.valueOf(createShopData.get(i).get("Full_Name*"))));
                            data.add(getInputValue("Shop_Name", String.valueOf(createShopData.get(i).get("Shop_Name*"))));
                            data.add(getInputValue("Shop_Email", String.valueOf(createShopData.get(i).get("Shop_Email*"))));
                            data.add(getInputValue("Shop_Address", String.valueOf(createShopData.get(i).get("Shop_Address*"))));
                            data.add(getInputValue("Pickup_Address", String.valueOf(createShopData.get(i).get("Pickup_Address*"))));
                            data.add(getInputValue("Pickup_Area", String.valueOf(createShopData.get(i).get("Pickup_Area"))));
                            data.add(getInputValue("Pickup_Phone", String.valueOf(createShopData.get(i).get("Pickup_Phone*"))));
                            data.add(getInputValue("Product_Type", String.valueOf(createShopData.get(i).get("Product_Type"))));
                            data.add(getInputValue("Password", String.valueOf(createShopData.get(i).get("Password*"))));
                            data.add(getInputValue("Confirm_Password", String.valueOf(createShopData.get(i).get("Confirm_Password*"))));
                            data.add(getInputValue("Referred_By", String.valueOf(createShopData.get(i).get("Referred_By"))));
                            data.add(getInputValue("Referrer_Code", String.valueOf(createShopData.get(i).get("Referrer_Code"))));
                            break;
                    }
                } else if (createShopData.get(i).get("Test_Case_Id").equals(errorMsgTestCaseId))
                {
                    switch (testCaseName)
                    {
                        case "Phone Number Validation":
                            data.add(String.valueOf(createShopData.get(i).get("Pickup_Phone*")));
                            break;
                        case "Required/Optional":
                            data.add(String.valueOf(createShopData.get(i).get("Full_Name*")));
                            data.add(String.valueOf(createShopData.get(i).get("Shop_Name*")));
                            data.add(String.valueOf(createShopData.get(i).get("Shop_Email*")));
                            data.add(String.valueOf(createShopData.get(i).get("Shop_Address*")));
                            data.add(String.valueOf(createShopData.get(i).get("Pickup_Address*")));
                            data.add(String.valueOf(createShopData.get(i).get("Pickup_Phone*")));
                            data.add(String.valueOf(createShopData.get(i).get("Password*")));
                            data.add(String.valueOf(createShopData.get(i).get("Confirm_Password*")));
                            break;
                        case "Invalid String Validation":
                            data.add(String.valueOf(createShopData.get(i).get("Full_Name*")));
                            data.add(String.valueOf(createShopData.get(i).get("Shop_Email*")));
                            data.add(String.valueOf(createShopData.get(i).get("Pickup_Phone*")));
                            data.add(String.valueOf(createShopData.get(i).get("Password*")));
                            data.add(String.valueOf(createShopData.get(i).get("Confirm_Password*")));
                            data.add(String.valueOf(createShopData.get(i).get("Referred_By")));
                            data.add(String.valueOf(createShopData.get(i).get("Referrer_Code")));
                            break;
                        case "Invalid Input Validation":
                            data.add(String.valueOf(createShopData.get(i).get("Full_Name*")));
                            data.add(String.valueOf(createShopData.get(i).get("Shop_Name*")));
                            data.add(String.valueOf(createShopData.get(i).get("Shop_Address*")));
                            data.add(String.valueOf(createShopData.get(i).get("Pickup_Address*")));
                            break;
                        case "Valid String Validation":
                            break;
                    }
                }
            }
        }
        return data;
    }

    public String getInputValue(String field,String value) throws Exception {
        String input = new String();
        int n = (random.nextInt(1000)+1);
        switch (field)
        {
            case "Account_Type":
                switch (value)
                {
                    case "Valid String":
                        input = getRandomValue("Account Type");
                        break;
                    case "N/A":
                        input ="";
                        break;
                }
                break;
            case "Full_Name":
                switch (value)
                {
                    case "Valid String":
                        input = "RedX Web" + PropertyReader.getValueOfKey(PropertyReader.Keys.SHOP_NAME) + n;
                        break;
                    case "Invalid String":
                        input = getRandomData("special",random.nextInt(5)+1);
                        break;
                    case "Invalid Input":
                        input = " ";
                        break;
                    case "N/A":
                        input ="";
                        break;
                }
                break;
            case "Shop_Name":
                switch (value)
                {
                    case "Valid String":
                        input = PropertyReader.getValueOfKey(PropertyReader.Keys.SHOP_NAME) + String.valueOf(n);
                        break;
                    case "Invalid Input":
                        input = " ";
                        break;
                    case "N/A":
                        input ="";
                        break;
                }
                break;
            case "Shop_Email":
                switch (value)
                {
                    case "Valid String":
                        input = "shopup@gmail.com";
                        break;
                    case "Invalid String":
                        input = getRandomData(getRandomValue("Value"),random.nextInt(10)+1);
                        break;
                    case "N/A":
                        input ="";
                        break;
                }
                break;
            case "Shop_Address":
                switch (value)
                {
                    case "Valid String":
                        input = "Shop Area,District,Division,Code";
                        break;
                    case "Invalid Input":
                        input = " ";
                        break;
                    case "N/A":
                        input ="";
                        break;
                }
                break;
            case "Pickup_Address":
                switch (value)
                {
                    case "Valid String":
                        input = "Pickup Area,District,Division,Code";
                        break;
                    case "Invalid Input":
                        input = " ";
                        break;
                    case "N/A":
                        input ="";
                        break;
                }
                break;
            case "Pickup_Area":
                switch (value)
                {
                    case "Valid String":
                        input = "random";
                        break;
                    case "N/A":
                        input ="";
                        break;
                }
                break;
            case "Pickup_Phone":
                switch (value)
                {
                    case "Valid String":
                        input = String.valueOf(Long.valueOf(PropertyReader.getValueOfKey(PropertyReader.Keys.PHONE_NUMBER))+1);
                        break;
                    case "Invalid String":
                        input = getRandomData(getRandomValue("Value"),random.nextInt(10)+1);
                        break;
                    case "N/A":
                        input ="";
                        break;
                }
                break;
            case "Product_Type":
                switch (value)
                {
                    case "Valid String":
                        input = getRandomValue("Product Type");
                        break;
                    case "N/A":
                        input ="";
                        break;
                }
                break;
            case "Password":
                switch (value)
                {
                    case "Valid String":
                        input = "Registration Flow Automation Test";
                        break;
                    case "Short String":
                        input = getRandomData(getRandomValue("Value"),random.nextInt(7)+1);
                        break;
                    case "N/A":
                        input ="";
                        break;
                }
                break;
            case "Confirm_Password":
                switch (value)
                {
                    case "Valid String":
                        input = "Registration Flow Automation Test";
                        break;
                    case "Invalid String":
                        input = getRandomData(getRandomValue("Value"),random.nextInt(7)+1);
                        break;
                    case "N/A":
                        input ="";
                        break;
                }
                break;
            case "Referred_By":
                switch (value)
                {
                    case "Valid String":
//                        input = "Valid String";
                        break;
                    case "Invalid String":
                        input = getRandomData("alpha",random.nextInt(5)+1);
                        break;
                    case "N/A":
                        input ="";
                        break;
                }
                break;
            case "Referrer_Code":
                switch (value)
                {
                    case "Valid String":
//                        input = "Valid String";
                        break;
                    case "Invalid String":
                        input = getRandomData("special",random.nextInt(5)+1);
                        break;
                    case "N/A":
                        input ="";
                        break;
                }
                break;
        }
        return input;
    }

    public String getRandomData(String value,int length)
    {
        String data = new String();
        String alphaString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";
        String numericString = "0123456789";
        String alphaNumericString = alphaString + numericString;
        String specialCharacterString = "~!@#$%^&*";
        StringBuilder sb = new StringBuilder(length);
        switch (value)
        {
            case "alpha":
                for (int i = 0; i < length; i++) {
                    int index = random.nextInt(alphaString.length());
                    sb.append(alphaString.charAt(index));
                }
                data = sb.toString();
                break;
            case "numeric":
                for (int i = 0; i < length; i++) {
                    int index = random.nextInt(numericString.length());
                    sb.append(numericString.charAt(index));
                }
                data = sb.toString();
                break;
            case "alphanumeric":
                for (int i = 0; i < length; i++) {
                    int index = random.nextInt(alphaNumericString.length());
                    sb.append(alphaNumericString.charAt(index));
                }
                data = sb.toString();
                break;
            case "special":
                for (int i = 0; i < length; i++) {
                    int index = random.nextInt(specialCharacterString.length());
                    sb.append(specialCharacterString.charAt(index));
                }
                data = sb.toString();
                break;
        }
        return data;
    }

    public void createShop(List<String> data)
    {
            for(int i=0;i<13;i++)
            {
                switch (i)
                {
                    case 0:
                        if(!data.get(i).equalsIgnoreCase(""))
                            chooseAccountTypeDropDownOption(data.get(i));
                        break;
                    case 1:
                        enterFullNameInput(data.get(i));
                        break;
                    case 2:
                        enterShopNameInput(data.get(i));
                        break;
                    case 3:
                        enterShopEmailInput(data.get(i));
                        break;
                    case 4:
                        enterShopAddressInput(data.get(i));
                        break;
                    case 5:
                        enterPickupAddressInput(data.get(i));
                        break;
                    case 6:
                        if(!data.get(i).equalsIgnoreCase(""))
                            setAreaInput(data.get(i),data.get(i),data.get(i));
                        break;
                    case 7:
                        if(data.get(i).equalsIgnoreCase(""))
                            clickPickupPhoneInput();
                        enterPickupPhoneInput(data.get(i));
                        break;
                    case 8:
                        if(!data.get(i).equalsIgnoreCase(""))
                            chooseProductTypeDropDown(data.get(i));
                        break;
                    case 9:
                        if(data.get(i).equalsIgnoreCase(""))
                        {
                            enterPasswordInput("P");
                            actions.sendKeys(Keys.BACK_SPACE).build().perform();
                        } else enterPasswordInput(data.get(i));
                        break;
                    case 10:
                        if(data.get(i).equalsIgnoreCase(""))
                        {
                            enterConfirmPasswordInput("P");
                            actions.sendKeys(Keys.BACK_SPACE).build().perform();
                        } else enterConfirmPasswordInput(data.get(i));
                        break;
                    case 11:
                        enterReferredByInput(data.get(i));
                        break;
                    case 12:
                        enterReferrerCodeInput(data.get(i));
                        break;
                }
            }
        }
    }
