package pageObjects;

import dataParcer.CSVParser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import services.redxMethods.GetRedxApiResponse;
import utils.*;
import java.util.*;

public class PickupLocationPageObjects extends RedXWebBaseClass
{
    private WebDriver driver;
    private MyActions myActions;
    private GetRedxApiResponse getRedxApiResponse;
    private Random random;

    public PickupLocationPageObjects(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
        getRedxApiResponse = new GetRedxApiResponse("redxweb");
        random = new Random();
    }

    /*----------Elements----------*/

    private WebElement searchBar;
    private WebElement addNewLocationIcon;
    private List<WebElement> pickupLocations;
    private WebElement pickupName;
    private WebElement pickupAddress;
    private WebElement editLocationIcon;
    private WebElement toastMsg;

    private String[] locationStatus= {"Active","Inactive"};

    /*----------Actions----------*/

    public void enterSearchBar(String searchTerm) {
        searchBar = xpathSetter("//input[@placeholder='Search pickup location']");
        myActions.action_sendKeys(searchBar, searchTerm);
        sleep(1000);
        try {
            searchBar = xpathPresenceSetter("//span[@class='ant-alert-message']");
            System.out.println(myActions.action_getText(searchBar));
        } catch (Exception e) {}
    }

    public void clearSearchBar()
    {
        searchBar = xpathSetter("//input[@placeholder='Search pickup location']");
        myActions.action_click(searchBar);
        searchBar.clear();
        sleep(2000);
    }

    public int getRandomLocation()
    {
        pickupLocations = xpathListSetter("//div[@class='pickup-points']/div/div");
        int size = pickupLocations.size();
        int index = random.nextInt(size-3)+3;
        System.out.println("Size : " + (size-1));
        System.out.println("Index : " + index);
        return index;
    }

    public void clickAddNewLocationIcon()
    {
        addNewLocationIcon = xpathSetter("//div[@class='pickup-points']/div/div[1]");
        myActions.action_click(addNewLocationIcon);
    }

    public String getPickupName(int index)
    {
        pickupName = xpathSetter("//div[@class='pickup-points']/div/div[" + index + "]//div[@class='header']/p[1]");
        return myActions.action_getText(pickupName);
    }

    public String getPickupAddress(int index)
    {
        pickupAddress = xpathSetter("//div[@class='pickup-points']/div/div[" + index + "]//div[@class='body']/p[1]");
        return myActions.action_getText(pickupAddress);
    }

    public void clickEditLocationIcon(int index)
    {
        editLocationIcon = xpathSetter("//div[@class='pickup-points']/div/div[" + index + "]//img[@alt='edit']");
        myActions.action_click(editLocationIcon);
    }

    public String getToastMsg()
    {
        toastMsg = xpathSetter("//div[@class='ant-notification-notice-message']");
        return myActions.action_getText(toastMsg);
    }

    /*----------Functions----------*/

    public String getRandomValue(String filter)
    {
        int index;
        String value = null;
        switch (filter)
        {
            case "Location Status" :
                index = random.nextInt(2);
                value = locationStatus[index];
                break;
        }
        return value;
    }

    /*----------Classes----------*/

    public class AddNewPickupLocationPageObjects
    {
        /*----------Elements----------*/

        private WebElement titleHeader;
        private WebElement closeIcon;

        private WebElement pickupNameInput;
        private WebElement pickupNameErrorMsg;

        private WebElement pickupAddressInput;
        private WebElement pickupAddressErrorMsg;

        private WebElement pickupAreaInput;

        private WebElement pickupPhoneInput;
        private WebElement pickupPhoneErrorMsg;

        private WebElement backButton;
        private WebElement confirmButton;

        /*----------Actions----------*/

        public String getTitle()
        {
            titleHeader = xpathSetter("//div[@class='ant-modal-title']");
            return myActions.action_getText(titleHeader);
        }

        public void clickCloseIcon()
        {
            closeIcon = xpathSetter("//button[@class='ant-modal-close']");
            myActions.action_click(closeIcon);
        }

        public void clickPickupNameInput()
        {
            pickupNameInput = xpathSetter("//input[@name='pickupName']");
            myActions.action_click(pickupNameInput);
        }

        public void enterPickupNameInput(String name)
        {
            pickupNameInput = xpathSetter("//input[@name='pickupName']");
            myActions.action_sendKeys(pickupNameInput,name);
        }

        public String getPickupNameErrorMsg()
        {
            pickupNameErrorMsg = xpathSetter("//input[@name='pickupName']/../div[@class='fieldError']");
            return myActions.action_getText(pickupNameErrorMsg);
        }

        public void clickPickupAddressInput()
        {
            pickupAddressInput = xpathSetter("//input[@name='pickupAddress']");
            myActions.action_click(pickupAddressInput);
        }

        public void enterPickupAddressInput(String name)
        {
            pickupAddressInput = xpathSetter("//input[@name='pickupAddress']");
            myActions.action_sendKeys(pickupAddressInput,name);
        }

        public String getPickupAddressErrorMsg()
        {
            pickupAddressErrorMsg = xpathSetter("//input[@name='pickupAddress']/../div[@class='fieldError']");
            return myActions.action_getText(pickupAddressErrorMsg);
        }

        public void clickPickupAreaInput()
        {
            pickupAreaInput = xpathSetter("//p[text()='Pickup Area']/..");
            myActions.action_click(pickupAreaInput);
        }

        public void enterPickupAreaInput(String name)
        {
            clickPickupAreaInput();
            pickupAreaInput = xpathSetter("//p[text()='Pickup Area']/..//input");
            myActions.action_sendKeys(pickupAreaInput,name);
            sleep(1500);
            pickupAreaInput.sendKeys(Keys.ENTER);
        }

        public void clickPickupPhoneInput()
        {
            pickupPhoneInput = xpathSetter("//input[@name='pickupPhone']");
            myActions.action_click(pickupPhoneInput);
        }

        public void enterPickupPhoneInput(String name)
        {
            pickupPhoneInput = xpathSetter("//input[@name='pickupPhone']");
            myActions.action_sendKeys(pickupPhoneInput,name);
        }

        public String getPickupPhoneErrorMsg()
        {
            pickupPhoneErrorMsg = xpathSetter("//input[@name='pickupPhone']/../div[@class='fieldError']");
            return myActions.action_getText(pickupPhoneErrorMsg);
        }

        public void clickBackButton()
        {
            backButton = xpathSetter("//span[text()='Back']/..");
            myActions.action_click(backButton);
        }

        public void clickConfirmButton()
        {
            confirmButton = xpathSetter("//span[text()='Confirm']/..");
            myActions.action_click(confirmButton);
        }

        /*----------Functions----------*/

        public String[] getDataFromCsv(String testId)
        {
            String[] data = new String[4];
            List<HashMap<String, Object>> addNewLocationData = CSVParser.getHashListForDataPath(RedXWebFileUtils.addNewLocationDataCsvFilePath);
            for (int i = 0; i < addNewLocationData.size(); i++)
            {
                if(addNewLocationData.get(i).get("Test_Case_ID").equals(testId))
                {
                    data[0]=addNewLocationData.get(i).get("Pickup_Name").toString();
                    data[1]=addNewLocationData.get(i).get("Pickup_Address").toString();
                    data[2]=addNewLocationData.get(i).get("Pickup_Phone").toString();
                    data[3]=addNewLocationData.get(i).get("Pickup_Area").toString();
                }
            }
            return data;
        }

        public List<String> getAllErrorMessages()
        {
            List<String> errorMsgs = new ArrayList<>();
            errorMsgs.add(getPickupNameErrorMsg());
            errorMsgs.add(getPickupAddressErrorMsg());
            errorMsgs.add(getPickupPhoneErrorMsg());
            return errorMsgs;
        }

        public void addNewLocation(String ...input)
        {
            /* String pickupName,String pickupAddress,String pickupArea,String pickupPhone */

            clickAddNewLocationIcon();
            int num = random.nextInt(1000)+1;
            for(int i=0;i<input.length;i++)
            {
                switch (i)
                {
                    case 0:
                        switch (input[i])
                        {
                            case "random":
                                input[i] = "Sanity Test Add New Location " + num;
                                System.out.println("Pickup Name : " + input[i]);
                                enterPickupNameInput(input[i]);
                                break;
                            case "N/A":
                                clickPickupNameInput();
                                break;
                            default : enterPickupNameInput(input[i]);
                        }
                        break;
                    case 1:
                        switch (input[i])
                        {
                            case "N/A":
                                clickPickupAddressInput();
                                break;
                            default :
                                System.out.println("Pickup Address : " + input[i]);
                                enterPickupAddressInput(input[i]);
                        }
                        break;
                    case 2:
                        switch (input[i])
                        {
                            case "N/A":
                                clickPickupPhoneInput();
                                break;
                            default :
                                System.out.println("Pickup Phone : " + input[i]);
                                enterPickupPhoneInput(input[i]);
                        }
                        break;
                    case 3:
                        switch (input[i])
                        {
                            case "random":
                                String area[] = getRedxApiResponse.getRandomArea();
                                input[i] = area[2];
                                System.out.println("Pickup Area : " + input[i]);
                                enterPickupAreaInput(input[i]);
                                break;
                            case "N/A":
                                clickPickupAreaInput();
                                break;
                            default : enterPickupAreaInput(input[i]);
                        }
                        break;
                }
            }

        }
    }

    public class EditPickupLocationPageObjects {

        /*----------Elements----------*/

        private WebElement titleHeader;
        private WebElement closeIcon;

        private WebElement pickupNameInput;
        private WebElement pickupNameErrorMsg;

        private WebElement pickupAddressInput;
        private WebElement pickupAddressErrorMsg;

        private WebElement pickupAreaInput;

        private WebElement pickupPhoneInput;
        private WebElement pickupPhoneErrorMsg;

        private WebElement pickupLocationStatusDropDown;
        private WebElement pickupLocationStatusDropDownOption;
        private List<WebElement> pickupLocationStatusDropDownOptions;

        private WebElement shopPhone;
        private WebElement otpInput;
        private WebElement otpInputErrorMsg;

        private WebElement backButton;
        private WebElement confirmButton;
        private WebElement updateButton;

        /*----------Actions----------*/

        public String getTitle() {
            titleHeader = xpathSetter("//div[@class='ant-modal-title']");
            return myActions.action_getText(titleHeader);
        }

        public void clickCloseIcon() {
            closeIcon = xpathSetter("//button[@class='ant-modal-close']");
            myActions.action_click(closeIcon);
        }

        public void clickPickupNameInput() {
            pickupNameInput = xpathSetter("//input[@name='pickupName']");
            myActions.action_click(pickupNameInput);
            pickupNameInput.clear();
        }

        public void enterPickupNameInput(String name) {
            pickupNameInput = xpathSetter("//input[@name='pickupName']");
            pickupNameInput.clear();
            myActions.action_sendKeys(pickupNameInput, name);
        }

        public String getPickupNameErrorMsg() {
            pickupNameErrorMsg = xpathSetter("//input[@name='pickupName']/../div[@class='fieldError']");
            return myActions.action_getText(pickupNameErrorMsg);
        }

        public void clickPickupAddressInput() {
            pickupAddressInput = xpathSetter("//input[@name='pickupAddress']");
            myActions.action_click(pickupAddressInput);
            pickupAddressInput.clear();
        }

        public void enterPickupAddressInput(String name) {
            pickupAddressInput = xpathSetter("//input[@name='pickupAddress']");
            pickupAddressInput.clear();
            myActions.action_sendKeys(pickupAddressInput, name);
        }

        public String getPickupAddressErrorMsg() {
            pickupAddressErrorMsg = xpathSetter("//input[@name='pickupAddress']/../div[@class='fieldError']");
            return myActions.action_getText(pickupAddressErrorMsg);
        }

        public void clickPickupAreaInput()
        {
            pickupAreaInput = xpathSetter("//p[text()='Pickup Area']/..");
            myActions.action_click(pickupAreaInput);
        }

        public void enterPickupAreaInput(String name)
        {
            clickPickupAreaInput();
            pickupAreaInput = xpathSetter("//p[text()='Pickup Area']/..//input");
            myActions.action_sendKeys(pickupAreaInput,name);
            sleep(1500);
            pickupAreaInput.sendKeys(Keys.ENTER);
        }

        public void clickPickupPhoneInput() {
            pickupPhoneInput = xpathSetter("//input[@name='pickupPhone']");
            myActions.action_click(pickupPhoneInput);
            pickupPhoneInput.clear();
        }

        public void enterPickupPhoneInput(String name) {
            pickupPhoneInput = xpathSetter("//input[@name='pickupPhone']");
            pickupPhoneInput.clear();
            myActions.action_sendKeys(pickupPhoneInput, name);
        }

        public String getPickupPhoneErrorMsg() {
            pickupPhoneErrorMsg = xpathSetter("//input[@name='pickupPhone']/../div[@class='fieldError']");
            return myActions.action_getText(pickupPhoneErrorMsg);
        }

        public void clickPickupLocationStatusDropDown() {
            pickupLocationStatusDropDown = xpathSetter("//p[text()='Pickup Location Status']/..//i");
            myActions.action_click(pickupLocationStatusDropDown);
        }

        public void choosePickupLocationStatusDropDownOption(String status) {
            clickPickupLocationStatusDropDown();
            pickupLocationStatusDropDownOption = xpathSetter("//ul[contains(@class,'ant-select-dropdown-menu')]/li[@title='" + status + "']");
            myActions.action_click(pickupLocationStatusDropDownOption);
        }

        public void choosePickupLocationStatusDropDownOption() {
            clickPickupLocationStatusDropDown();
            pickupLocationStatusDropDownOptions = xpathListSetter("//ul[contains(@class,'ant-select-dropdown-menu')]/li");
            int size = pickupLocationStatusDropDownOptions.size();
            int index = random.nextInt(size);
            myActions.action_click(pickupLocationStatusDropDownOptions.get(index));
        }

        public void clickShopPhone() {
            shopPhone = xpathSetter("//p[@class='shop-phone']");
            myActions.action_click(shopPhone);
        }

        public String getShopPhone() {
            shopPhone = xpathSetter("//p[@class='shop-phone']");
            return myActions.action_getText(shopPhone);
        }

        public void clickOtpInput() {
            otpInput = xpathSetter("//input[@name='otp']");
            myActions.action_click(otpInput);
        }

        public void enterOtpInput(String otp) {
            otpInput = xpathSetter("//input[@name='otp']");
            myActions.action_sendKeys(otpInput, otp);
        }

        public String getOtpErrorMsg() {
            otpInputErrorMsg = xpathSetter("//input[@name='otp']/../div[@class='fieldError']");
            return myActions.action_getText(otpInputErrorMsg);
        }

        public void clickUpdateButton() {
            updateButton = xpathSetter("//span[text()='Update']/..");
            myActions.action_click(updateButton);
        }

        public void clickBackButton() {
            backButton = xpathSetter("//span[text()='Back']/..");
            myActions.action_click(backButton);
        }

        public void clickConfirmButton() {
            confirmButton = xpathSetter("//span[text()='Confirm']/..");
            myActions.action_click(confirmButton);
            new WebDriverWait(driver,30).until(ExpectedConditions.invisibilityOf(confirmButton));
        }

        /*----------Functions----------*/

        public String[] getDataFromCsv(String testId) {
            String[] data = new String[5];
            List<HashMap<String, Object>> editLocationData = CSVParser.getHashListForDataPath(RedXWebFileUtils.editLocationDataCsvFilePath);
            for (int i = 0; i < editLocationData.size(); i++) {
                if (editLocationData.get(i).get("Test_Case_ID").equals(testId)) {
                    data[0] = editLocationData.get(i).get("Pickup_Name").toString();
                    data[1] = editLocationData.get(i).get("Pickup_Address").toString();
                    data[2] = editLocationData.get(i).get("Pickup_Phone").toString();
                    data[3] = editLocationData.get(i).get("Pickup_Area").toString();
                    data[4] = editLocationData.get(i).get("Pickup_Location_Status").toString();
                }
            }
            return data;
        }

        public List<String> getAllErrorMessages() {
            List<String> errorMsgs = new ArrayList<>();
            errorMsgs.add(getPickupNameErrorMsg());
            errorMsgs.add(getPickupAddressErrorMsg());
            errorMsgs.add(getPickupPhoneErrorMsg());
            return errorMsgs;
        }

        public void editLocation(String... input) {
            /* String pickupName,String pickupAddress,String pickupArea,String pickupPhone */

            int num = random.nextInt(1000) + 1;
            for (int i = 0; i < input.length; i++) {
                switch (i) {
                    case 0:
                        switch (input[i]) {
                            case "random":
                                input[i] = "Sanity Test Edit Location " + num;
                                System.out.println("Pickup Name : " + input[i]);
                                enterPickupNameInput(input[i]);
                                break;
                            case "N/A":
                                clickPickupNameInput();
                                break;
                            default:
                                enterPickupNameInput(input[i]);
                        }
                        break;
                    case 1:
                        switch (input[i]) {
                            case "N/A":
                                clickPickupAddressInput();
                                break;
                            default:
                                System.out.println("Pickup Address : " + input[i]);
                                enterPickupAddressInput(input[i]);
                        }
                        break;
                    case 2:
                        switch (input[i]) {
                            case "N/A":
                                clickPickupPhoneInput();
                                break;
                            default:
                                System.out.println("Pickup Phone : " + input[i]);
                                enterPickupPhoneInput(input[i]);
                        }
                        break;
                    case 3:
                        switch (input[i]) {
                            case "random":
                                String area[] = getRedxApiResponse.getRandomArea();
                                input[i] = area[2];
                                System.out.println("Pickup Area : " + input[i]);
                                enterPickupAreaInput(input[i]);
                                break;
                            case "N/A":
                                clickPickupAreaInput();
                                break;
                            default:
                                enterPickupAreaInput(input[i]);
                        }
                        break;
                    case 4:
                        switch (input[i]) {
                            case "random":
                                String status = getRandomValue("Location Status");
                                System.out.println("Location Status : " + status);
                                choosePickupLocationStatusDropDownOption(status);
                                break;
                            case "N/A":
                                break;
                            default: choosePickupLocationStatusDropDownOption(input[i]);
                        }
                        break;
                }
            }
        }

        public void updateLocation(String otp)
        {
            enterOtpInput(otp);
            clickUpdateButton();
        }
    }
}
