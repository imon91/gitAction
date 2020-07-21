package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidBaseClass;
import utils.MyActions;

import java.util.List;
import java.util.Random;

public class AddNewAddressPageObjects extends AndroidBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private MyActions myActions;
    private Random random;

    public AddNewAddressPageObjects(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
        random = new Random();
    }

    //firstName
    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement firstName;

    //phonenumber
    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phoneNumber;

    //alternativePhoneNumber
    @FindBy(xpath = "//input[@name='alternative_phone']")
    private WebElement alternativePhoneNumber;

    //address
    @FindBy(xpath = "//input[@name='address1']")
    private WebElement address;

    //fromDropDown
    @FindBy(xpath = "//div[@id='react-autowhatever-1']/ul/li[1]")
    private WebElement chooseFromDropDown;

    //locality
    @FindBy(xpath = "//input[@name='address2']")
    private WebElement locality;

    //landmark
    @FindBy(xpath = "//input[@name='landmark']")
    private WebElement landmark;

    //Area
    @FindBy(xpath = "//div[@class='inputsearch inputSearch___13R7q']")
    private WebElement area;

    //Save
    @FindBy(xpath = "//button[@class='flat___n-myg primary___OLr69 button___3btga ripple___1U_Uk contain___ux0BW next']")
    private WebElement saveButton;

    //cancel
    @FindBy(xpath = "//button[@class='flat___n-myg flatSecondary___8V87I button___3btga ripple___1U_Uk contain___ux0BW']")
    private WebElement cancelButton;

    //Back to Addresses
    @FindBy(xpath = "//span[contains(text(),'Back to Addresses')]")
    private WebElement BacktoAddressesButton;

    public void enterFirstName(String name){myActions.action_sendKeys(firstName,name);};

    public void enterPhoneNumber(String number){myActions.action_sendKeys(phoneNumber,number);};

    public void enterAlternativePhoneNumber(String alternative){myActions.action_sendKeys(alternativePhoneNumber,alternative);};

    public void enterAddress(String data){myActions.action_sendKeys(address,data);};

    public void chooseArea(){myActions.action_click(chooseFromDropDown);}

    public void enterLocality(String Locality){myActions.action_sendKeys(locality,Locality);};

    public void enterLandmark(String Landmark){myActions.action_sendKeys(landmark,Landmark);};

    public void enterArea(){myActions.action_click(area);};

    public void clickOnSaveAddress(){myActions.action_click(saveButton);};

    public void clickOnCancel(){myActions.action_click(cancelButton);}

    public void clickOnbackToAddress(){myActions.action_click(BacktoAddressesButton);};


    public List<WebElement> areaList(){
        String areaXpath = "//div[@id='react-autowhatever-1']/ul/li";
        List<WebElement> listofAreas = xpathListSetter(areaXpath);
        return listofAreas;
    }

    public String selectArea(WebElement element,int index){
        String areaSelected = "//div[@id='react-autowhatever-1']/ul/li["+ ++index +"]/div";
        myActions.action_click(element);
        return areaSelected;
    }


    public String selectPreferredDeliveryDateAndTime(String date,int deliveyIndex){
        String selected ="";
        if(date == "Date"){
            selected = selectPreferredDelivery(deliveyIndex,1);
        }else if(date == "Time"){
            selected = selectPreferredDelivery(deliveyIndex,2);
        } else{
            System.out.println("Enter a valuable preference");
        }
        return selected;
    }
    public String selectPreferredDelivery(int deliveryIntex,int preferenceOption){
        String preferredDeliveryDays = "//div[@class='additionalInformation___c5Ocl']//div[@class='flex___1bJDE between___1AlI0 middle___1jEMZ badgesRow___2CvtS']["+preferenceOption+"]";
        List<WebElement> deliveryDaysList = androidDriver.findElements(By.xpath(preferredDeliveryDays));
        int size = deliveryDaysList.size();
        if(deliveryIntex == 0){
            int x = random.nextInt(size);
            deliveryIntex = x++;
        }
        String delivery = preferredDeliveryDays+"//div"+deliveryIntex+"//label";
        String deliveryLabel = preferredDeliveryDays+"//div"+deliveryIntex+"//label/span";
        String deliverySelected = myActions.action_getText(androidDriver.findElement(By.xpath(deliveryLabel)));
        myActions.action_click(androidDriver.findElement(By.xpath(delivery)));
        return deliverySelected;
    }

/*--------functions---------*/

    public void createNewAddress(String name,String address,String phoneNumber){
        enterFirstName(name);
        enterArea();
        int count = random.nextInt(areaList().size());
        selectArea(areaList().get(count),count);
        enterPhoneNumber(phoneNumber);
        enterAddress(address);
        clickOnSaveAddress();
    }

    public void editNameInAddress(String newName){
        if (!firstName.getText().isEmpty()) {
            firstName.clear();
            enterFirstName(newName);
        }
    }

    public void editAddressInAddress(String newAddress){
        if (!address.getText().isEmpty()) {
            address.clear();
        }
        enterAddress(newAddress);
    }

    public void editPhoneNumberInAddress(String newPhoneNumber){
        if(!phoneNumber.getText().isEmpty()) {
            phoneNumber.clear();
        }
        enterPhoneNumber(newPhoneNumber);
    }

    public void editAlternativePhoneNumberInAddress(String newAlternativeNumber){
        if(!alternativePhoneNumber.getText().isEmpty()) {
            alternativePhoneNumber.clear();
        }
        enterAlternativePhoneNumber(newAlternativeNumber);
    }

    public void editLocalityInAddress(String newLocality){
        if(!locality.getText().isEmpty()) {
            locality.clear();
        }
        enterLocality(newLocality);
    }

    public void editLandmarkInAddress(String newLandmark){
        if (!landmark.getText().isEmpty()){
            landmark.clear();
        }
        enterLandmark(newLandmark);
    }


}
