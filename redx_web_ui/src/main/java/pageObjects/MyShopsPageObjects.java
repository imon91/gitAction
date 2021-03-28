package pageObjects;

import dataParcer.CSVParser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import utils.*;
import java.util.*;

public class MyShopsPageObjects extends RedXWebBaseClass
{
    private WebDriver driver;
    private MyActions myActions;
    private Random random;

    public MyShopsPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
        random = new Random();
    }

    /*----------Elements----------*/

    private WebElement addNewShopIcon;
    private WebElement shopModule;
    private List<WebElement> editShopButtons;
    private WebElement editShopButton;
    private WebElement shopName;
    private WebElement shopPickupLocation;
    private WebElement shopPickupPhone;
    private WebElement successIcon;
    private WebElement toastMsg;

    private WebElement shop1;
    private WebElement shop2;
    private WebElement shop3;
    private List<WebElement> shops;
    private List<WebElement> editShopIcon;
    private List<WebElement> deliveryZoneDropDownWhileEditShop;
    private List<WebElement> locationDropDownWhileEditShop;
    private WebElement saveButtonWhileEditShop;

    /*----------Actions----------*/

    public void clickShopByName(String name)
    {
        System.out.println("Changing Shop Name");
        shopModule = xpathSetter("//div[@class='shoplist']/div/div//p[text()='" + name + "']/..");
        myActions.action_click(shopModule);
        sleep(1000);
    }

    public void clickShopByIndex(int index)
    {
        System.out.println("Changing Shop Name");
        shopModule = xpathSetter("//div[@class='shoplist']/div/div[" + index + "]");
        myActions.action_click(shopModule);
        setImplicitWait(10000);
    }

    public void clickAddNewShopIcon()
    {
        addNewShopIcon = xpathSetter("//div[@class='shoplist']/div/div[1]");
        myActions.action_click(addNewShopIcon);
    }

    public int getRandomShop()
    {
        shops = xpathListSetter("//div[@class='shoplist']/div/div");
        int size = shops.size();
        int index = random.nextInt(size-1)+2;
        System.out.println("Shops Size : " + size);
        System.out.println("Index : " + index);
        return index;
    }

    public String getShopName(int index)
    {
        shopName = xpathSetter("//div[@class='shoplist']/div/div[" + index + "]//div[@class='header']/p[1]");
        return myActions.action_getText(shopName);
    }

    public String getShopPickupLocation(int index)
    {
        shopPickupLocation = xpathSetter("//div[@class='shoplist']/div/div[" + index + "]//div[@class='body']/p[1]");
        return myActions.action_getText(shopPickupLocation);
    }

    public String getShopPickupPhone(int index)
    {
        shopPickupPhone = xpathSetter("//div[@class='shoplist']/div/div[" + index + "]//div[@class='body']/p[2]");
        return myActions.action_getText(shopPickupPhone);
    }

    public Boolean isShopSelected(int index)
    {
        successIcon = xpathPresenceSetter("//div[@class='shoplist']/div/div[" + index + "]//img[@alt='success']");
        return successIcon.isDisplayed();
    }

    public void clickEditShopButton(String shopName)
    {
        editShopButton = xpathSetter("//p[text()='" + shopName + "']/../..//div[@class='footer']//img[@alt='edit']");
        myActions.action_click(editShopButton);
    }

    public void clickRandomEditShopButton()
    {
        editShopButtons = xpathListSetter("//p[contains(text(),'Sanity Test Shop ')]/../..//div[@class='footer']//img[@alt='edit']");
        int size = editShopButtons.size();
        int index = random.nextInt(size);
        myActions.action_click(editShopButtons.get(index));
    }

    public String getToastMsg()
    {
        toastMsg = xpathSetter("//div[@class='ant-message-notice']//span");
        //Shop updated successfully
        return myActions.action_getText(toastMsg);
    }

    public void clickOnShop(int index)
    {
        shops = driver.findElements(By.xpath("//div[@class='shoplist']//div[@class='ant-col ant-col-md-12 ant-col-lg-6 ant-col-xl-6']"));

        myActions.action_click(shops.get(++index));
    }

    public void clickOnEditShopIcon(int index)
    {
        editShopIcon = driver.findElements(By.xpath("//div[@class='shoplist']//div[@class='ant-col ant-col-md-12 ant-col-lg-6 ant-col-xl-6']//div[@class='action-icon-wrapper']/*"));
        //EditButton was less than shopList
        myActions.action_click(editShopIcon.get(index));
    }

    public void clickOnNewShopIcon()
    {
        editShopIcon = driver.findElements(By.xpath("//div[@class='shoplist']//div[@class='ant-col ant-col-md-12 ant-col-lg-6 ant-col-xl-6']"));
        myActions.action_click(editShopIcon.get(0));
    }

    public void enterAndApplyAreaOnEditShop(String division,String District,String areaTerm)
    {

        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@class='shop-create-form']//div[@class='ant-row'][3]/div[2]/div/div"))).click();
        sleep(1500);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@class='shop-create-form']//div[@class='ant-row'][3]/div[2]/div/div[2]/input"))).sendKeys(division);
        sleep(500);
        locationDropDownWhileEditShop = driver.findElements(By.xpath("//section[@class='shop-create-form']//div[@class='ant-row'][3]/div[2]/div/div[2]/div/p"));
        myActions.action_click(locationDropDownWhileEditShop.get(0));
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@class='shop-create-form']//div[@class='ant-row'][3]/div[2]/div/div[2]/input"))).sendKeys(District);
        sleep(500);
        locationDropDownWhileEditShop = driver.findElements(By.xpath("//section[@class='shop-create-form']//div[@class='ant-row'][3]/div[2]/div/div[2]/div/p"));
        myActions.action_click(locationDropDownWhileEditShop.get(0));
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@class='shop-create-form']//div[@class='ant-row'][3]/div[2]/div/div[2]/input"))).sendKeys(areaTerm);
        sleep(500);
        locationDropDownWhileEditShop = driver.findElements(By.xpath("//section[@class='shop-create-form']//div[@class='ant-row'][3]/div[2]/div/div[2]/div/p"));
        myActions.action_click(locationDropDownWhileEditShop.get(0));

    }

    public void enterFullName(String name)
    {
        WebElement fullName = xpathSetter("//input[@type='text'][@name='name']");
        myActions.action_sendKeys(fullName,name);
    }

    public void clickOnSaveButtonWhileEditShop()
    {
        saveButtonWhileEditShop = driver.findElement(By.xpath("//div[@class='form-wrapper']//button"));
        myActions.action_click(saveButtonWhileEditShop);
    }



    /**************************ISSUE Automation special functions**********************/
    public void clickOnShop1KALABAGAN()
    {
        shop1 = driver.findElement(By.xpath("//div[@class='ant-col ant-col-md-12 ant-col-lg-6 ant-col-xl-6'][2]/div[1]/div[1]"));
        myActions.action_click(shop1);
    }

    public void clickOnShop2NARORE()
    {
        shop2 = driver.findElement(By.xpath("//div[@class='ant-col ant-col-md-12 ant-col-lg-6 ant-col-xl-6'][3]/div[1]/div[1]"));
        myActions.action_click(shop2);
    }
    public void clickOnShop3SAVAR()
    {
        shop3 = driver.findElement(By.xpath("//div[@class='ant-col ant-col-md-12 ant-col-lg-6 ant-col-xl-6'][4]/div[1]/div[1]"));
        myActions.action_click(shop3);
    }

    public void editShopDetails(int shopIndex,String division,String district,String areaTerm,String name)
    {
        clickOnEditShopIcon(shopIndex);
        enterAndApplyAreaOnEditShop(division,district,areaTerm);
        enterFullName(name);
        sleep(500);
        clickOnSaveButtonWhileEditShop();
        sleep(1000);
    }

    /*----------Functions----------*/

    /*----------Classes----------*/

    public class AddNewShopPageObjects
    {

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

        public void enterPickupPhoneInput(String pickupAdress)
        {
            pickupPhoneInput = xpathSetter("//input[@name='phone']");
            myActions.action_sendKeys(pickupPhoneInput,pickupAdress);
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

        public String[] getDataFromCsv(String testId)
        {
            String[] data = new String[15];
            List<HashMap<String, Object>> addNewShopData = CSVParser.getHashListForDataPath(RedXWebFileUtils.addNewShopDataCsvFilePath);
            for (int i = 0; i < addNewShopData.size(); i++)
            {
                if(addNewShopData.get(i).get("Test_Case_ID").equals(testId))
                {
                    data[0]=addNewShopData.get(i).get("Account_Type").toString();
                    data[1]=addNewShopData.get(i).get("Full_Name").toString();
                    data[2]=addNewShopData.get(i).get("Shop_Name").toString();
                    data[3]=addNewShopData.get(i).get("Shop_Email").toString();
                    data[4]=addNewShopData.get(i).get("Shop_Address").toString();
                    data[5]=addNewShopData.get(i).get("Pickup_Address").toString();
                    data[6]=addNewShopData.get(i).get("Division").toString();
                    data[7]=addNewShopData.get(i).get("District").toString();
                    data[8]=addNewShopData.get(i).get("Area").toString();
                    data[9]=addNewShopData.get(i).get("Pickup_Phone").toString();
                    data[10]=addNewShopData.get(i).get("Product_Type").toString();
                    data[11]=addNewShopData.get(i).get("Password").toString();
                    data[12]=addNewShopData.get(i).get("Confirm_Password").toString();
                    data[13]=addNewShopData.get(i).get("Referred_By").toString();
                    data[14]=addNewShopData.get(i).get("Referrer_Code").toString();
                }
            }
            return data;
        }

        public void addNewShop(String ...input)
        {
            /*  String accountType, String fullName, String shopName, String shopEmail, String shopAddress,
                String pickupAddress, String division, String district, String area, String pickupPhone, String productType,
                String password, String confirmPassword, String referredBy, String referrerCode */

            clickAddNewShopIcon();
            int num = random.nextInt(1000)+1;

            for(int i=0;i<input.length;i++)
            {
                switch (i)
                {
                    case 0:
                        switch (input[i])
                        {
                            case "random":
                                input[i] = getRandomValue("Account Type");
                                System.out.println("Account Type : " + input[i]);
                                chooseAccountTypeDropDownOption(input[i]);
                                break;
                            case "N/A":
                                break;
                            default : chooseAccountTypeDropDownOption(input[i]);
                        }
                        break;
                    case 1:
                        switch (input[i])
                        {
                            case "random":
                                input[i] = "Sanity Test Add New Shop " + num;
                                System.out.println("Full Name : " + input[i]);
                                enterFullNameInput(input[i]);
                                break;
                            case "N/A":
                                clickFullNameInput();
                                break;
                            default : enterFullNameInput(input[i]);
                        }
                        break;
                    case 2:
                        switch (input[i])
                        {
                            case "random":
                                input[i] = "Sanity Test Shop " + num;
                                System.out.println("Shop Name : " + input[i]);
                                enterShopNameInput(input[i]);
                                break;
                            case "N/A":
                                clickShopNameInput();
                                break;
                            default : enterShopNameInput(input[i]);
                        }
                        break;
                    case 3:
                        switch (input[i])
                        {
                            case "N/A":
                                clickShopEmailInput();
                                break;
                            default : enterShopEmailInput(input[i]);
                        }
                        break;
                    case 4:
                        switch (input[i])
                        {
                            case "N/A":
                                clickShopAddressInput();
                                break;
                            default : enterShopAddressInput(input[i]);
                        }
                        break;
                    case 5:
                        switch (input[i])
                        {
                            case "N/A":
                                clickPickupAddressInput();
                                break;
                            default : enterPickupAddressInput(input[i]);
                        }
                        break;
                    case 6:
                        if(!input[i].equalsIgnoreCase("N/A"))
                            setAreaInput(input[i],input[i+1],input[i+2]);
                        break;
                    case 9:
                        switch (input[i])
                        {
                            case "N/A":
                                clickPickupPhoneInput();
                                break;
                            default : enterPickupPhoneInput(input[i]);
                        }
                        break;
                    case 10:
                        switch (input[i])
                        {
                            case "random":
                                input[i] = getRandomValue("Product Type");
                                System.out.println("Product Type : " + input[i]);
                                chooseProductTypeDropDown(input[i]);
                                break;
                            case "N/A":
                                break;
                            default : chooseProductTypeDropDown(input[i]);
                        }
                        break;
                    case 11:
                        switch (input[i])
                        {
                            case "N/A":
                                enterPasswordInput(input[i]);
                                clearPasswordInput();
                                break;
                            default : enterPasswordInput(input[i]);
                        }
                        break;
                    case 12:
                        switch (input[i])
                        {
                            case "N/A":
                                enterConfirmPasswordInput("N/");
                                clearConfirmPasswordInput();
                                break;
                            default : enterConfirmPasswordInput(input[i]);
                        }
                        break;
                    case 13:
                        enterReferredByInput(input[i]);
                        break;
                    case 14:
                        enterReferrerCodeInput(input[i]);
                        break;
                }
            }
        }

        public List<String> getAllErrorMessages()
        {
            List<String> errorMsgs = new ArrayList<>();
            errorMsgs.add(getFullNameErrorMessage());
            errorMsgs.add(getShopNameErrorMessage());
            errorMsgs.add(getShopEmailErrorMessage());
            errorMsgs.add(getShopAddressErrorMessage());
            errorMsgs.add(getPickupAddressErrorMessage());
            errorMsgs.add(getPickupPhoneErrorMessage());
            errorMsgs.add(getPasswordErrorMessage());
            errorMsgs.add(getConfirmPasswordErrorMessage());
            errorMsgs.add(getReferredByErrorMessage());
            errorMsgs.add(getReferrerCodeErrorMessage());
            return errorMsgs;
        }
    }

    public class EditShopPageObjects
    {

        /*----------Elements----------*/

        private WebElement titleWrapper;
        private WebElement closeIcon;

        private WebElement shopEmailInput;
        private WebElement shopEmailErrorMessage;

        private WebElement shopNameInput;
        private WebElement shopNameErrorMessage;

        private WebElement shopAddressInput;
        private WebElement shopAddressErrorMessage;
        private WebElement editShopButton;

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

        public void clickEditShopButton()
        {
            editShopButton = xpathSetter("//form//div[@class='button']/button[@type='submit']");
            myActions.action_click(editShopButton);
        }

        /*----------Functions----------*/

        public String[] getDataFromCsv(String testId)
        {
            String[] data = new String[3];
            List<HashMap<String, Object>> editShopData = CSVParser.getHashListForDataPath(RedXWebFileUtils.editShopDataCsvFilePath);
            for (int i = 0; i < editShopData.size(); i++)
            {
                if(editShopData.get(i).get("Test_Case_ID").equals(testId))
                {
                    data[0]=editShopData.get(i).get("Shop_Email").toString();
                    data[1]=editShopData.get(i).get("Shop_Address").toString();
                    data[2]=editShopData.get(i).get("Shop_Name").toString();
                }
            }
            return data;
        }

        public void editShop(String ...inputs)
        {
            for(int i = 0;i<inputs.length;i++)
            {
                switch (i)
                {
                    case 0:
                        switch (inputs[i])
                        {
                            case "N/A":
                                enterShopEmailInput("");
                                break;
                            default:
                                System.out.println("Shop Email : " + inputs[i]);
                                enterShopEmailInput(inputs[i]);
                        }
                        break;
                    case 1:
                        switch (inputs[i])
                        {
                            case "N/A":
                                enterShopAddressInput("");
                                break;
                            default:
                                System.out.println("Shop Address : " + inputs[i]);
                                enterShopAddressInput(inputs[i]);
                        }
                        break;
                    case 2:
                        switch (inputs[i])
                        {
                            case "N/A":
                                enterShopNameInput("");
                                break;
                            case "random":
                                String name = "Edit Sanity Test Shop " + (random.nextInt(1000)+1);
                                System.out.println("Shop Name : " + name);
                                enterShopNameInput(name);
                                break;
                            default: enterShopNameInput(inputs[i]);
                        }
                        break;
                }
            }
        }

        public List<String> getAllErrorMessages()
        {
            List<String> errorMsgs = new ArrayList<>();
            errorMsgs.add(getShopEmailErrorMessage());
            errorMsgs.add(getShopAddressErrorMessage());
            errorMsgs.add(getShopNameErrorMessage());
            return errorMsgs;
        }
    }
}
