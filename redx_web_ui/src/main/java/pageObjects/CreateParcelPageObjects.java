package pageObjects;

import dataParcer.CSVParser;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import utils.*;
import java.util.*;


public class CreateParcelPageObjects extends RedXWebBaseClass {

    private WebDriver driver;
    private MyActions myActions;
    private HomePageObjects homePageObjects;
    private ShopInfoPageObjects shopInfoPageObjects;
    private DeliveryChargeDetailsPageObjects deliveryChargeDetailsPageObjects;
    private Actions actions;
    private Random random;

    public CreateParcelPageObjects(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
        actions = new Actions(driver);
        random = new Random();
        homePageObjects = new HomePageObjects(driver);
        shopInfoPageObjects = new ShopInfoPageObjects();
        deliveryChargeDetailsPageObjects = new DeliveryChargeDetailsPageObjects();
    }

    /*----------Elements----------*/

    private WebElement createBulkParcelButton;

    private WebElement deliveryTypeRadioButton;

    private WebElement customerNameInput;
    private WebElement customerNameErrorMessage;

    private WebElement customerPhoneNumberInput;
    private WebElement customerPhoneNumberErrorMessage;

    private WebElement customerAddressInput;
    private WebElement customerAddressErrorMessage;

    private WebElement merchantInvoiceIdInput;

    private WebElement parcelWeightInput;
    private WebElement parcelWeightErrorMessage;
    private WebElement increaseWeightButton;
    private WebElement decreaseWeightButton;

    private WebElement areaInput;
    private WebElement pickupAreaErrorMessage;
    private WebElement searchArea;
    private WebElement areaInputOption;
    private List<WebElement> areaInputOptions;
    private WebElement pathName;
    private List<WebElement> areaDropDown;

    private WebElement pickupStoreDropDown;
    private WebElement pickupStoreDropDownOption;
    private List<WebElement> pickupStoreDropDownOptions;
    private WebElement pickupStoreErrorMessage;

    private WebElement parcelType;
    private WebElement cashCollectionInput;
    private WebElement amountErrorMessage;
    private WebElement sellingPriceInput;
    private WebElement sellingPriceErrorMessage;
    private WebElement acknowledgementBoxButton;
    private WebElement acknowledgeErrorMessage;
    private WebElement instructionsTextArea;
    private WebElement createParcelButton;

    private WebElement deliveryCharge;
    private WebElement CODCharge;
    private WebElement deliveryOnChargeParcelPage;
    private WebElement parcelPopup;

    private String[] deliveryTypes = {"Regular","Reverse"};
    private String[] parcelTypes = {"Fragile","Liquid"};


    /*----------Actions----------*/

    public void clickCreateBulkParcelButton()
    {
        createBulkParcelButton = xpathSetter("//button[contains(text(),'Create Bulk Parcels')]");
        myActions.action_click(createBulkParcelButton);
        waitForLoading();
        actions.sendKeys(Keys.ESCAPE).build().perform();
    }

    public void enterCustomerNameInput(String name)
    {
        System.out.println("Customer Name : " + name);
        customerNameInput = xpathSetter("//input[@name='customerName']");
        customerNameInput.clear();
        myActions.action_sendKeys(customerNameInput,name);
    }

    public String getCustomerNameErrorMessage()
    {
        customerNameErrorMessage = xpathSetter("//input[@name='customerName']/../div[@class='fieldError']");
        System.out.println(myActions.action_getText(customerNameErrorMessage));
        return myActions.action_getText(customerNameErrorMessage);
    }

    public void enterCustomerPhoneInput(String phone)
    {
        System.out.println("Customer Phone : " + phone);
        customerPhoneNumberInput = xpathSetter("//input[@name='customerPhone']");
        customerPhoneNumberInput.clear();
        myActions.action_sendKeys(customerPhoneNumberInput,phone);
    }

    public String getCustomerPhoneErrorMessage()
    {
        customerPhoneNumberErrorMessage = xpathSetter("//input[@name='customerPhone']/../div[@class='fieldError']");
        System.out.println(myActions.action_getText(customerPhoneNumberErrorMessage));
        return myActions.action_getText(customerPhoneNumberErrorMessage);
    }

    public void enterAddressInput(String address)
    {
        System.out.println("Customer Address : " + address);
        customerAddressInput = xpathSetter("//textarea[@name='customerAddress']");
        customerAddressInput.clear();
        myActions.action_sendKeys(customerAddressInput,address);
    }

    public String getCustomerAddressErrorMessage()
    {
        customerAddressErrorMessage = xpathSetter("//textarea[@name='customerAddress']/../div[@class='fieldError']");
        System.out.println(myActions.action_getText(customerAddressErrorMessage));
        return myActions.action_getText(customerAddressErrorMessage);
    }

    public void enterMerchantInvoiceIdInput(String invoice)
    {
        System.out.println("Merchant Invoice Id : " + invoice);
        merchantInvoiceIdInput = xpathSetter("//input[@name='invoiceNumber']");
        merchantInvoiceIdInput.clear();
        myActions.action_sendKeys(merchantInvoiceIdInput,invoice);
    }

    public void clickParcelWeightInput()
    {
        parcelWeightInput = xpathSetter("//input[@name='weight']");
        myActions.action_click(parcelWeightInput);
    }
    public void enterParcelWeightInput(String weight)
    {
        parcelWeightInput = xpathSetter("//input[@name='weight']");
        myActions.action_click(parcelWeightInput);
        if(Integer.parseInt(getParcelWeight())>0)
            clickDecreaseWeightButton();
        myActions.action_sendKeys(parcelWeightInput,weight);
    }

    public String getParcelWeightErrorMessage()
    {
        parcelWeightErrorMessage = xpathSetter("//input[@name='weight']/../../../div[@class='fieldError']");
        System.out.println(myActions.action_getText(parcelWeightErrorMessage));
        return myActions.action_getText(parcelWeightErrorMessage);
    }

    public String getParcelWeight()
    {
        parcelWeightInput = xpathSetter("//input[@name='weight']");
        return parcelWeightInput.getAttribute("aria-valuenow");
    }

    public void clickIncreaseWeightButton()
    {
        increaseWeightButton = xpathSetter("//span[@aria-label='Increase Value']/i");
        myActions.action_click(increaseWeightButton);
    }

    public void clickDecreaseWeightButton()
    {
        decreaseWeightButton = xpathSetter("//span[@aria-label='Decrease Value']/i");
        myActions.action_click(decreaseWeightButton);
    }

    public void clickAreaInput()
    {
        areaInput = xpathSetter("//div[@class='right-form']/div[1]//i");
        myActions.action_click(areaInput);
    }

    public void searchArea(String area)
    {
        searchArea = xpathSetter("//input[@name='selectedArea']");
        myActions.action_sendKeys(searchArea,area);
    }

    public void chooseArea(String area)
    {
        searchArea(area);
        areaInputOption = xpathSetter("//div[@class='area-tree']/p/span[text()='" + area + "']");
        myActions.action_click(areaInputOption);
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

    public void clickPathName()
    {
        pathName = xpathSetter("//p[@class='path-name']");
        myActions.action_click(pathName);
    }

    public String getPickupAreaErrorMessage()
    {
        pickupAreaErrorMessage = xpathSetter("//div[@class='right-form']/div[1]//div[@class='fieldError']");
        System.out.println(myActions.action_getText(pickupAreaErrorMessage));
        return myActions.action_getText(pickupAreaErrorMessage);
    }

    public void clickPickupStoreDropDown()
    {
        pickupStoreDropDown = xpathSetter("//div[@class='right-form']/div[2]//i");
        myActions.action_click(pickupStoreDropDown);
    }

    public void choosePickupStore(String location)
    {
        clickPickupStoreDropDown();
        pickupStoreDropDownOption = xpathSetter("//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']/li[text()='" + location +"']");
        myActions.action_click(pickupStoreDropDownOption);
    }

    public void choosePickupStore()
    {
        clickPickupStoreDropDown();
        pickupStoreDropDownOptions = xpathListSetter("//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']/li");
        int size = pickupStoreDropDownOptions.size();
        int index = random.nextInt(size);
        String location = pickupStoreDropDownOptions.get(index).getText();
        System.out.println("Size : " + size);
        System.out.println("Index : " + index);
        System.out.println("Location : " + location);
        myActions.action_click(pickupStoreDropDownOptions.get(index));
    }

    public String getPickupStoreErrorMessage()
    {
        pickupStoreErrorMessage = xpathSetter("//div[@class='right-form']/div[2]//div[@class='fieldError']");
        System.out.println(myActions.action_getText(pickupStoreErrorMessage));
        return myActions.action_getText(pickupStoreErrorMessage);
    }

    public void clickParcelType(String type)
    {
//        parcelType = xpathSetter("//input[@name='" + type + "']");
        parcelType = xpathSetter("//span[text()='" + type + "']/..");
        myActions.action_click(parcelType);
    }

    public void enterCashCollectionAmount(String amount)
    {
        cashCollectionInput = xpathSetter("//input[@name='amount']");
        cashCollectionInput.clear();
        myActions.action_sendKeys(cashCollectionInput,amount);
    }

    public String getAmountErrorMessage()
    {
        amountErrorMessage = xpathSetter("//input[@name='amount']/../div[@class='fieldError']");
        return myActions.action_getText(amountErrorMessage);
    }

    public void enterSellingPrice(String amount)
    {
        sellingPriceInput = xpathSetter("//input[@name='sellingPrice']");
        sellingPriceInput.clear();
        myActions.action_sendKeys(sellingPriceInput,amount);
    }

    public String getSellingPriceErrorMessage()
    {
        sellingPriceErrorMessage = xpathSetter("//input[@name='sellingPrice']/../div[@class='fieldError']");
        return myActions.action_getText(sellingPriceErrorMessage);
    }

    public void clickAcknowledgementButton()
    {
        acknowledgementBoxButton = xpathSetter("//div[@name='parcelValueConfirmation']/label");
        myActions.action_click(acknowledgementBoxButton);
    }

    public String getAcknowledgementErrorMessage()
    {
        acknowledgeErrorMessage = xpathSetter("//div[@name='parcelValueConfirmation']/..//div[@class='fieldError']");
        System.out.println(myActions.action_getText(acknowledgeErrorMessage));
        return myActions.action_getText(acknowledgeErrorMessage);
    }

    public void enterInstructions(String instructions)
    {
        instructionsTextArea = xpathSetter("//textarea[@name='instruction']");
        myActions.action_sendKeys(instructionsTextArea,instructions);
    }

    public void enterAreaTerm(String location,String lastletter)
    {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='right-form']/div[1]/div"))).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='right-form']/div[1]/div[2]/input"))).sendKeys(location);
        sleep(500);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='right-form']/div[1]/div[2]/input"))).sendKeys(lastletter);
        sleep(1000);
    }

    public WebElement deliveryCharge()
    {
        deliveryCharge = driver.findElement(By.xpath("//div[@class='delivery-charge']/div[@class='body']/div[2]/p[2]"));
        return deliveryCharge;
    }

    public WebElement CODCharge()
    {
        CODCharge = driver.findElement(By.xpath("//div[@class='delivery-charge']/div[@class='body']/div[3]/p[2]"));
        return CODCharge;
    }
    public void clickCreateParcelButton()
    {
        createParcelButton = driver.findElement(By.xpath("//div[@class='btn-wrappper']/button"));
        myActions.action_click(createParcelButton);
    }

    public void clickOnParcelPopupOkButton()
    {
        parcelPopup = driver.findElement(By.xpath("//div[@class='ant-modal-confirm-btns']/button"));
        myActions.action_click(parcelPopup);
    }

    public List<WebElement> areaDropDown()
    {
        return areaDropDown = driver.findElements(By.xpath("//div[@class='right-form']/div[1]//div[@class='area-tree']/p"));
    }

    public WebElement deliveryChargeParcelPage()
    {
        deliveryOnChargeParcelPage = driver.findElement(By.xpath("//div[@tabindex='-1']/table[@class='ant-table-fixed']/tbody/tr[1]/td[7]"));
        return deliveryOnChargeParcelPage;
    }

    public void chooseDeliveryType(String type)
    {
        deliveryTypeRadioButton = xpathSetter("//span[text()='" + type + "']/..");
        myActions.action_click(deliveryTypeRadioButton);
    }


    /*----------Functions----------*/

    public void createNewParcel(String divisionTerm,String districtTerm,String location_or_AreaTerm,int addressIndex,String lastLetter)
    {
        homePageObjects.clickOnCreateParcelButton();
        sleep(1000);
        enterCustomerNameInput("Customer Name Savar");
        enterCustomerPhoneInput("01877755590");
        enterAddressInput("Address");
        enterCashCollectionAmount(System.getProperty("selling price")+"0");
        enterSellingPrice(System.getProperty("selling price"));

        enterAndApplyAddress(divisionTerm,districtTerm,location_or_AreaTerm,addressIndex);
        sleep(1000);
        clickAcknowledgementButton();
    }

    public void enterAndApplyAddress(String divisionTerm,String districtTerm,String location_or_AreaTerm,int addressIndex) {
        enterCashCollectionAmount(System.getProperty("selling price"));
        enterAreaTerm(divisionTerm, "");
        sleep(500);
        areaDropDown();
        myActions.action_click(areaDropDown().get(addressIndex));
        sleep(100);
        enterAreaTerm(districtTerm, "");
        sleep(100);
        areaDropDown();
        myActions.action_click(areaDropDown().get(addressIndex));
        sleep(100);
        enterAreaTerm(location_or_AreaTerm, "");
        sleep(100);
        areaDropDown();
        myActions.action_click(areaDropDown().get(addressIndex));
    }

    public void selectArea(String division,String district,String area)
    {
        clickAreaInput();
        chooseArea(division);
        chooseArea(district);
        chooseArea(area);
    }

    public String getRandomValue(String filter)
    {
        int index;
        String value = null;
        switch (filter)
        {
            case "Delivery Type":
                index = random.nextInt(2);
                value = deliveryTypes[index];
                break;
            case "Parcel Type":
                index = random.nextInt(2);
                value = parcelTypes[index];
                break;
        }
        return value;
    }

    public List<String> getDeliveryChargeInfo()
    {
        List<String> deliveryCharges = new ArrayList<>();
        deliveryCharges.add(deliveryChargeDetailsPageObjects.getCashCollectionValue());
        deliveryCharges.add(deliveryChargeDetailsPageObjects.getDeliveryChargeValue());
        deliveryCharges.add(deliveryChargeDetailsPageObjects.getDiscountAmountValue());
        deliveryCharges.add(deliveryChargeDetailsPageObjects.getCodChargeValue());
        deliveryCharges.add(deliveryChargeDetailsPageObjects.getTotalPayableAmountValue());
        return deliveryCharges;
    }

    public void setParcelWeightInput(String weight)
    {
        System.out.println("Parcel Weight : " + weight);
        if(!getParcelWeight().equalsIgnoreCase(weight))
        {
            if(Integer.parseInt(weight)%500==0)
            {
                clickParcelWeightInput();
                while(!getParcelWeight().equalsIgnoreCase(weight))
                {
                    clickIncreaseWeightButton();
                }
            } else enterParcelWeightInput(weight);
        }
    }

    public String setAreaInput(String ...areaInput)
    {
        clickAreaInput();
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

    public String[] getDataFromCsv(String testName)
    {
        String[] data = new String[14];
        List<HashMap<String, Object>> createParcelData = CSVParser.getHashListForDataPath(RedXWebFileUtils.createParcelDataCsvFilePath);
        for(int i=0;i<createParcelData.size();i++)
        {
            if(createParcelData.get(i).get("Test_Name").equals(testName))
            {
                System.out.println(createParcelData.get(i).get("Delivery_Type").toString());
                switch (createParcelData.get(i).get("Delivery_Type").toString())
                {
                    case "Regular":
                        data[0]=createParcelData.get(i).get("Pickup_Location").toString();
                        data[1]=createParcelData.get(i).get("Customer_Name").toString();
                        data[2]=createParcelData.get(i).get("Customer_Phone").toString();
                        data[3]=createParcelData.get(i).get("Customer_Address").toString();
                        data[4]=createParcelData.get(i).get("Invoice").toString();
                        if(data[4].equalsIgnoreCase("random"))
                            data[4] = String.valueOf(random.nextInt(999999-100000)+100000);
                        data[5]=createParcelData.get(i).get("Parcel_Weight").toString();
                        if(data[5].equalsIgnoreCase("random"))
                            data[5] = String.valueOf(random.nextInt(1000)+1);
                        data[6]=createParcelData.get(i).get("District").toString();
                        data[7]=createParcelData.get(i).get("Division").toString();
                        data[8]=createParcelData.get(i).get("Area").toString();
                        data[9]=createParcelData.get(i).get("Parcel_Type").toString();
                        if(data[9].equalsIgnoreCase("random"))
                            data[9] = getRandomValue("Parcel Type");
                        data[10]=createParcelData.get(i).get("Cash_Collection").toString();
                        if(data[10].equalsIgnoreCase("random"))
                            data[10] = String.valueOf(random.nextInt(3000));
                        data[11]=createParcelData.get(i).get("Selling_Price").toString();
                        if(data[11].equalsIgnoreCase("random"))
                            data[11] = String.valueOf(random.nextInt(2000));
                        data[12]=createParcelData.get(i).get("Acknowledgement").toString();
                        data[13]=createParcelData.get(i).get("Instructions").toString();
                        break;
                    case "Reverse":
                        data[0]=createParcelData.get(i).get("Customer_Name").toString();
                        data[1]=createParcelData.get(i).get("Customer_Phone").toString();
                        data[2]=createParcelData.get(i).get("Customer_Address").toString();
                        data[3]=createParcelData.get(i).get("Invoice").toString();
                        if(data[3].equalsIgnoreCase("random"))
                            data[3] = String.valueOf(random.nextInt(999999-100000)+100000);
                        data[4]=createParcelData.get(i).get("Parcel_Weight").toString();
                        if(data[4].equalsIgnoreCase("random"))
                            data[4] = String.valueOf(random.nextInt(1000)+1);
                        data[5]=createParcelData.get(i).get("Division").toString();
                        data[6]=createParcelData.get(i).get("District").toString();
                        data[7]=createParcelData.get(i).get("Area").toString();
                        data[8]=createParcelData.get(i).get("Pickup_Store").toString();
                        data[9]=createParcelData.get(i).get("Parcel_Type").toString();
                        if(data[9].equalsIgnoreCase("random"))
                            data[9] = getRandomValue("Parcel Type");
                        data[10]=createParcelData.get(i).get("Selling_Price").toString();
                        if(data[10].equalsIgnoreCase("random"))
                            data[10] = String.valueOf(random.nextInt(2000));
                        data[11]=createParcelData.get(i).get("Acknowledgement").toString();
                        data[12]=createParcelData.get(i).get("Instructions").toString();
                        data[13] = "";
                        break;
                }
            }
        }
        return data;
    }

    public void clickCreateParcelWithNoInputs(String deliveryType)
    {
//        chooseDeliveryType(deliveryType);
        clickParcelWeightInput();
        clickDecreaseWeightButton();
        enterSellingPrice("0");
        clickAcknowledgementButton();
        clickAcknowledgementButton();
        clickCreateParcelButton();
        getErrorMessages(deliveryType).toString();
    }

    public List<String> createRegularParcel(String ...input)
    {
      /* String pickupLocation, String name, String phoneNumber, String address, String merchantId, String parcelWeight,
      String District, String Division, String area, String parcelType, String cashCollection, String sellingPrice, String acknowledgement, String instructions */

        List<String> deliveryChargeDetails = new ArrayList<>();
        String pickupArea = new String();
//        chooseDeliveryType("Regular");
        System.out.println("Creating Regular Parcel");
        for (int i = 0; i < input.length; i++)
        {
            if (!input[i].equalsIgnoreCase(""))
                switch (i)
                {
                    case 0:
                        if(input[i].equalsIgnoreCase("random"))
                            pickupArea = shopInfoPageObjects.choosePickupLocation();
                        else {shopInfoPageObjects.choosePickupLocation(input[i]);
                        pickupArea=input[i];}
                        System.out.println("Pickup Address : " + shopInfoPageObjects.getPickupAddressValue());
                        break;
                    case 1:
                        if(input[i].equalsIgnoreCase("random"))
                            input[i] = "Create ParcelName : " + (random.nextInt(1000)+1);
                        enterCustomerNameInput(input[i]);
                        break;
                    case 2:
                        enterCustomerPhoneInput(input[i]);
                        break;
                    case 3:
                        enterAddressInput(input[i]);
                        break;
                    case 4:
                        enterMerchantInvoiceIdInput(input[i]);
                        break;
                    case 5:
                        setParcelWeightInput(input[i]);
                        break;
                    case 6:
                        deliveryChargeDetails.add(setAreaInput(input[i], input[i+1], input[i+2]));
                        break;
                    case 9:
                        clickParcelType(input[i]);
                        break;
                    case 10:
                        System.out.println("Cash Collection : " + input[i]);
                        enterCashCollectionAmount(input[i]);
                        break;
                    case 11:
                        System.out.println("Selling Price : " + input[i]);
                        enterSellingPrice(input[i]);
                        break;
                    case 12:
                        clickAcknowledgementButton();
                        break;
                    case 13:
                        enterInstructions(input[i]);
                        break;
                }
        }
        deliveryChargeDetails.addAll(1,getDeliveryChargeInfo());
        deliveryChargeDetails.add(pickupArea);
        clickCreateParcelButton();
        return deliveryChargeDetails;
    }

    public List<String> createReverseParcel(String ...input)
    {
      /* String name, String phoneNumber, String address, String merchantId, String parcelWeight,
      String Division, String District, String area, String pickupStore, String parcelType, String sellingPrice, String acknowledgement, String instructions */

        List<String> deliveryChargeDetails = new ArrayList<>();
        chooseDeliveryType("Reverse");
        System.out.println("Creating Reverse Parcel");
        for (int i = 0; i < input.length; i++)
        {
            if (!input[i].equalsIgnoreCase(""))
                switch (i) {
                    case 0:
                        if(input[i].equalsIgnoreCase("random"))
                            input[i] = "Create ParcelName : " + (random.nextInt(1000)+1);
                        enterCustomerNameInput(input[i]);
                        break;
                    case 1:
                        enterCustomerPhoneInput(input[i]);
                        break;
                    case 2:
                        enterAddressInput(input[i]);
                        break;
                    case 3:
                        enterMerchantInvoiceIdInput(input[i]);
                        break;
                    case 4:
                        setParcelWeightInput(input[i]);
                        break;
                    case 5:
                        deliveryChargeDetails.add(setAreaInput(input[5], input[6], input[7]));
                        break;
                    case 8:
                        if(input[i].equalsIgnoreCase("random"))
                            choosePickupStore();
                        else choosePickupStore(input[i]);
                        break;
                    case 9:
                        clickParcelType(input[i]);
                        break;
                    case 10:
                        enterSellingPrice(input[i]);
                        break;
                    case 11:
                        clickAcknowledgementButton();
                        break;
                    case 12:
                        enterInstructions(input[i]);
                        break;
                }
        }
        deliveryChargeDetails.addAll(1,getDeliveryChargeInfo());
        clickCreateParcelButton();
        return deliveryChargeDetails;
    }

    public List<String> getErrorMessages(String deliveryType)
    {
        List<String> errorMsgs = new ArrayList<>();
        switch (deliveryType)
        {
            case "Regular" :
                errorMsgs.add(shopInfoPageObjects.getPickupLocationErrorMessage());
                errorMsgs.add(getCustomerNameErrorMessage());
                errorMsgs.add(getCustomerPhoneErrorMessage());
                errorMsgs.add(getCustomerAddressErrorMessage());
                errorMsgs.add(getCustomerNameErrorMessage());
                errorMsgs.add(getParcelWeightErrorMessage());
                errorMsgs.add(getPickupAreaErrorMessage());
                errorMsgs.add(getAmountErrorMessage());
                errorMsgs.add(getSellingPriceErrorMessage());
                errorMsgs.add(getAcknowledgementErrorMessage());
                break;
            case "Reverse" :
                errorMsgs.add(getCustomerNameErrorMessage());
                errorMsgs.add(getCustomerPhoneErrorMessage());
                errorMsgs.add(getCustomerAddressErrorMessage());
                errorMsgs.add(getCustomerNameErrorMessage());
                errorMsgs.add(getParcelWeightErrorMessage());
                errorMsgs.add(getPickupAreaErrorMessage());
                errorMsgs.add(getPickupStoreErrorMessage());
                errorMsgs.add(getSellingPriceErrorMessage());
                errorMsgs.add(getAcknowledgementErrorMessage());
                break;
        }
        return errorMsgs;
    }

    public void waitForLoading()
    {
        while(driver.getCurrentUrl().equalsIgnoreCase("https://redx.shopups1.xyz/create-parcel/"))
            sleep(100);
    }

    /*---------------Classes---------------*/

    public class ShopInfoPageObjects
    {

        /*---------------Elements---------------*/

        private WebElement shopName;
        private WebElement chooseShopButton;
        private WebElement allPickupLocationDropDown;
        private List<WebElement> pickupLocationDropDownOptions;
        private WebElement pickupLocationDropDownOption;
        private WebElement pickupAddressValue;
        private WebElement pickUpLocationErrorMessage;

        /*---------------Actions---------------*/

        public String getShopName()
        {
            shopName = xpathSetter("//div[@class='shop-info']//p[contains(@class,'shop-name')]");
            String shop = myActions.action_getText(shopName);
            shop = shop.substring(10);
            System.out.println("Shop Name : " + shop);
            return shop.toLowerCase();
        }

        public void clickChooseShopButton()
        {
            chooseShopButton = xpathSetter("//a[@href='/shop-list/']/..");
            myActions.action_click(chooseShopButton);
            waitForLoading();
        }

        public void clickAllPickupLocationDropDown()
        {
            allPickupLocationDropDown = xpathSetter("//div[@class='shop-info']//span[@class='ant-select-arrow']/..");
            myActions.action_click(allPickupLocationDropDown);
        }

        public void choosePickupLocation(String location)
        {
            clickAllPickupLocationDropDown();
            pickupLocationDropDownOption = xpathSetter("//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']//li[text()='" + location + "']");
            myActions.action_click(pickupLocationDropDownOption);
        }

        public String choosePickupLocation()
        {
            clickAllPickupLocationDropDown();
            pickupLocationDropDownOptions = xpathListSetter("//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']//li[text()]");
            int size = pickupLocationDropDownOptions.size();
            int index = random.nextInt(size);
            String pickupLocation = myActions.action_getText(pickupLocationDropDownOptions.get(index));
            System.out.println("Size : " + size);
            System.out.println("Index : " + index);
            System.out.println("Pickup Location : " + pickupLocation);
            myActions.action_click(pickupLocationDropDownOptions.get(index));
            return pickupLocation;
        }

        public String getPickupAddressValue()
        {
            pickupAddressValue = xpathSetter("//div[@class='shop-info']/div[@class='footer']/p[2]");
            return myActions.action_getText(pickupAddressValue);
        }

        public String getPickupLocationErrorMessage()
        {
            pickUpLocationErrorMessage = xpathPresenceSetter("//div[@class='ant-message-notice']//span[contains(text(),'pickup')]");
            String msg = myActions.action_getText(pickUpLocationErrorMessage);
            System.out.println("Pickup Location Error Msg : " + msg);
            return msg;
        }
    }

    public class ImportFromShopUpPageObjects
    {

        /*---------------Elements---------------*/

        private WebElement importFromShopUpButton;
        private WebElement modalTitle;
        private WebElement searchInput;
        private WebElement cancelButton;
        private WebElement addToDeliveryList;
        private WebElement closeIcon;

        /*---------------Actions---------------*/

        public void clickImportFromShopUpButton()
        {
            importFromShopUpButton = xpathSetter("//div[@class='link-wrapper']/button");
            myActions.action_click(importFromShopUpButton);
        }

        public String getModalTitle()
        {
            modalTitle = xpathSetter("//div[@class='ant-modal-title']//p");
            return myActions.action_getText(modalTitle);
        }

        public void enterSearchInput(String searchValue)
        {
            searchInput = xpathSetter("//div[@class='search-box']//input");
            myActions.action_sendKeys(searchInput,searchValue);
        }

        public void clickCancelButton()
        {
            cancelButton = xpathSetter("//div[@class='ant-modal-footer']//button/span[text()='Cancel']/..");
            myActions.action_click(cancelButton);
        }

        public void clickAddToDeliveryList()
        {
            addToDeliveryList = xpathSetter("//div[@class='ant-modal-footer']//button/span[text()='Add to delivery list']/..");
            myActions.action_click(addToDeliveryList);
        }

        public void clickCloseIcon()
        {
            closeIcon = xpathSetter("//button[@class='ant-modal-close']");
            myActions.action_click(closeIcon);
        }
    }

    public class DeliveryChargeDetailsPageObjects
    {

        /*---------------Elements---------------*/

        private WebElement cashCollectionValue;
        private WebElement deliveryChargeValue;
        private WebElement discountAmountValue;
        private WebElement codChargeValue;
        private WebElement totalPayableAmountValue;

        /*---------------Actions---------------*/

        public String getCashCollectionValue() {
            cashCollectionValue = xpathSetter("//div[@class='delivery-charge']//div[@class='amount-info'][1]/p[2]");
            String value = myActions.action_getText(cashCollectionValue);
            return value.substring(4);
        }

        public String getDeliveryChargeValue() {
            deliveryChargeValue = xpathSetter("//div[@class='delivery-charge']//div[@class='amount-info'][2]/p[2]");
            String value = myActions.action_getText(deliveryChargeValue);
            return value.substring(4);
        }

        public String getDiscountAmountValue()
        {
            discountAmountValue = xpathSetter("//div[@class='delivery-charge']//div[@class='amount-info'][3]/p[2]");
            String value = myActions.action_getText(discountAmountValue);
            return value.substring(4);
        }

        public String getCodChargeValue() {
            codChargeValue = xpathSetter("//p[text()='COD Charge']/../p[contains(text(),'Tk')]");
            String value = myActions.action_getText(codChargeValue);
            return value.substring(4);
        }

        public String getTotalPayableAmountValue() {
            totalPayableAmountValue = xpathSetter("//p[text()='Total Payable Amount']/../p[contains(text(),'Tk')]");
            String value = myActions.action_getText(totalPayableAmountValue);
            return value.substring(4);
        }
    }

    public class ParcelSuccessPageObjects
    {

        /*----------Elements----------*/

        private WebElement okButton;
        private WebElement alertMessage;
        private WebElement pickupShop;
        private WebElement customerAddress;
        private WebElement trackOrdersButton;
        private WebElement requestNewParcelButton;
        private WebElement printLabelButton;


        /*----------Actions----------*/

        public void clickOkButton()
        {
            okButton=xpathSetter("//div[@class='ant-modal-confirm-btns']/button");
            myActions.action_click(okButton);
        }

        public String getAlertMessage()
        {
            alertMessage = xpathSetter("//span[@class='ant-alert-message']");
            return myActions.action_getText(alertMessage); //Your parcel request has been placed successfully
        }

        public String getPickupShop()
        {
            pickupShop = xpathSetter("//div[@class='pickup-info']//font[text()]");
            return myActions.action_getText(pickupShop);
        }

        public String getCustomerAddress()
        {
            customerAddress = xpathSetter("//div[@class='shipment-info']/div[@class='subtitle-wrapper']/p");
            return myActions.action_getText(customerAddress);
        }

        public void clickTrackOrdersButton()
        {
            trackOrdersButton = xpathSetter("//div[@class='track-button-wrapper']/button");
            myActions.action_click(trackOrdersButton);
            waitForLoading();
        }

        public void clickRequestNewParcelButton()
        {
            requestNewParcelButton = xpathSetter("//div[@class='parcel-create-button-wrapper']/button");
            myActions.action_click(requestNewParcelButton);
            waitForLoading();
        }

        public void clickPrintLabelButton()
        {
            int loop = 0;
            printLabelButton = xpathSetter("//div[@class='print-label-button-wrapper']/button");
            myActions.action_click(printLabelButton);
            while(driver.getWindowHandles().size()==1)
            {
                sleep(500);
                loop++;
                if(loop>10)
                    break;
            }
        }

        public void waitForLoading()
        {
            while(driver.getCurrentUrl().contains("https://redx.shopups1.xyz/parcel-success/"))
                sleep(100);
        }
    }

}




