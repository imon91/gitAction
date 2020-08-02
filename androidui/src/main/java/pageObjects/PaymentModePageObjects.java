package pageObjects;

import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import services.commerceMethods.GetMyBagApiResponse;
import utils.*;
import java.util.*;

public class PaymentModePageObjects extends AndroidBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private MyActions myActions;
    private GetMyBagApiResponse getMyBagApiResponse;
    private ServiceRequestLayer serviceRequestLayer;


  public PaymentModePageObjects(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
        serviceRequestLayer = new ServiceRequestLayer();
        getMyBagApiResponse = serviceRequestLayer.getMyBagControl();
    }


    @FindBy(xpath = "//div[@class='panel-heading']/h4/a")
    private WebElement paymentMethods;

    @FindBy(xpath = "//div[@class='summary-container']/following-sibling::div[1]/button")
    private WebElement makePaymentTopButton;

    @FindBy(xpath = "//div[@class='home-deliver-text']/a")
    private WebElement changeAddress;

    @FindBy(xpath = "//div[@class='payment-breakup-link text-center']//p")
    private WebElement paymentBreakup;

    @FindBy(xpath = "//div[@class='modal-footer']//p")
    private WebElement closePaymentBreakup;

    @FindBy(xpath = "//div[@class='you-save-left text-left']//p//b")
    private WebElement earnings;

    @FindBy(xpath = "//div[@class='you-save-right text-right']//p//b")
    private WebElement orderValue;

    @FindBy(xpath = "//div[@class='flex___1bJDE']//input")
    private WebElement shippingCharges;

    @FindBy(xpath = "//div[@class='deliver-to-address']//div/div/p/span")
    private WebElement firstName;

    @FindBy(xpath = "//div[@class='deliver-to-address']//div/div//p[2]")
    private WebElement address;

    @FindBy(xpath = "//div[@class='deliver-to-address']//div/div//p[3]//span[2]")
    private WebElement landmark;

    @FindBy(xpath = "//div[@class='deliver-to-address']//div/div//p[3]")
    private WebElement city;

    @FindBy(xpath = "//div[@class='deliver-to-address']//div/div//p[4]//span[2]")
    private WebElement phoneNumber;

    @FindBy(xpath = "//div[@class='deliver-to-address']//div/div//p[4]")
    private WebElement cityWithLandmark;

    @FindBy(xpath = "//div[@class='deliver-to-address']//div/div//p[5]//span[2]")
    private WebElement phoneNumberWithLandmark;

    @FindBy(xpath = "//div[@class='cash-on-delivery-container-1']//p")
    private WebElement cashOnDeliveryContainer;


    public String getNamefromAddress(){return myActions.action_getText(firstName);}

    public String getAddressfromAddress(){return myActions.action_getText(address);}

    public String getLandmarkfromAddress(){
        return myActions.action_getText(landmark);
    }

    public String getCity(){
        return myActions.action_getText(cityWithLandmark);
    }

    public String getCityfromAddress(){
        return myActions.action_getText(city);
    }

    public String getPhoneNumber(){
        return myActions.action_getText(phoneNumberWithLandmark);
    }

    public String getPhoneNumberFromAddress(){
            return myActions.action_getText(phoneNumber);
    }

    public String getTextFromCODConatainer(){ return myActions.action_getText(cashOnDeliveryContainer);}

    public void selectPaymentOptionCOD(){
        int size = getListOfPaymentMode().size();
        for(int i=0;i<size;i++){
            if(getListOfPaymentMode().get(i).getText().equalsIgnoreCase("CASH ON DELIVERY")){
                myActions.action_click(getListOfPaymentMode().get(i));
            }
        }
    }

    public void clickOnPayTopButton(){
        myActions.action_click(makePaymentTopButton);
    }

    public void clickOnChangeAddress(){
        myActions.action_click(changeAddress);
    }

    public void clickOnPaymentBreakup(){myActions.action_click(paymentBreakup);}

    public void clickOnCloseButton(){myActions.action_click(closePaymentBreakup);}

    public int getEarningsAmount(){
        String withTakeAmount = myActions.action_getText(earnings);
        System.out.println(withTakeAmount);
        //String[] splitAmount = withTakeAmount.split("");
        String splitAmount = withTakeAmount.replaceAll("Tk. ","");
        System.out.println(splitAmount);
        return Integer.parseInt(splitAmount.replaceAll(",",""));
    }

    public int getCartValueAmount(){
        String withTakeAmount = myActions.action_getText(orderValue);
        //String[] splitAmount = withTakeAmount.split("");
        String splitAmount = withTakeAmount.replaceAll("Tk. ","");
        return Integer.parseInt(splitAmount.replaceAll(",",""));
    }

    public int getShippingCharges(){
        String amount = shippingCharges.getAttribute("placeholder");
        System.out.println(amount);
        //String[] splitAmount = withTakeAmount.split("");
        return Integer.parseInt(amount.replaceAll("Tk. ",""));
        //System.out.println(splitAmount);
        //return Integer.parseInt(splitAmount);
    }

    public List<WebElement> getListOfPaymentMode(){
        return xpathListSetter("//div[@class='panel-heading']/h4/a");
    }

    public void proceedPaymentWithoutChangeAddressThroughTopButton(){
        selectPaymentOptionCOD();
        sleep(3000);
        clickOnPayTopButton();

    }

    public class ProductDetails {

        private AndroidDriver<WebElement> androidDriver;
        private MyActions myActions;

        public ProductDetails(AndroidDriver<WebElement> androidDriver) {
            this.androidDriver = androidDriver;
            PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
            myActions = new MyActions();
        }

        //products containerPath
        private String productContainerPath = "//div[@class='col-xs-12 payment_select_inner']//div[2]/div[@class='flex___1bJDE']";

        public List<WebElement> getListOfProductImage(){
            String productImage = productContainerPath+"//div[1]/img";
            List<WebElement> productImagesList = xpathListSetter(productImage);
            return productImagesList;
        }

        public List<WebElement> getListOfProductName(){
            String productName = productContainerPath+"//div[2]/p[1]";
            List<WebElement> productNamesList = xpathListSetter(productName);
            return productNamesList;
        }

        public List<WebElement> getListOfProductOrderValue(){
            String productVariantPrice = productContainerPath+"//div[2]/p[2]";
            List<WebElement> productVariantPricesList = xpathListSetter(productVariantPrice);
            return productVariantPricesList;
        }

        public int getProductContainerSize(){
            List<WebElement> noofProducts = xpathListSetter(productContainerPath);
            return noofProducts.size();
        }

        public String getProductImage(int index){
            String imageLink = getListOfProductImage().get(index).getAttribute("src");
            return imageLink.substring(0,imageLink.lastIndexOf("&"));
        }

        public String getProductName(int index){
            return myActions.action_getText(getListOfProductName().get(index));
        }

        public String getProductOrderValue(int index){
            return myActions.action_getText(getListOfProductOrderValue().get(index));
        }

    }

/*---------Data---------*/

    public List<String> getSelectedAddressDetails(){
        return getMyBagApiResponse.getSelectedAddressDetails();
    }

}
