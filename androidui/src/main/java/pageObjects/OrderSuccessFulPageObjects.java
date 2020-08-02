package pageObjects;

import coreUtils.CoreConstants;
import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import services.commerceMethods.GetMyBagApiResponse;
import utils.*;

public class OrderSuccessFulPageObjects extends AndroidBaseClass{


    private AndroidDriver<WebElement> androidDriver;
    private MyActions myActions;
    private String myPackage;
    private GetMyBagApiResponse getMyBagApiResponse;
    private ServiceRequestLayer serviceRequestLayer;

    public OrderSuccessFulPageObjects(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        switchFromNativeToWeb(CoreConstants.SHOP_UP_RESELLER_WEB_VIEW);
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
        myPackage = getAppPackage();
        serviceRequestLayer = new ServiceRequestLayer();
        getMyBagApiResponse = serviceRequestLayer.getMyBagControl();
    }


    @FindBy(xpath = "//span[contains(text(),'Click Here')]")
    private WebElement clickHereButton;

    @FindBy(xpath = "//span[contains(text(),'My Orders')]")
    private WebElement myOrdersButton;

    @FindBy(xpath = "//div[@class='order_success_green_bg text-center order_success_green_bg_app']//h4/b")
    private WebElement orderSuccessfulText;

    @FindBy(xpath = "//div[@class='succeed_order_number text-center']//p[2]/span[2]")
    private WebElement orderID;
  
    @FindBy(xpath = "//p[@class='thankyou_order_no']/span[2]")
    private WebElement orderNumber;

    public String getOrderNumber(){
        return myActions.action_getText(orderNumber);
    }

    public void clickOnClickHereButton(){
        try{
            PropertyReader.setValue(PropertyReader.Keys.ORDER_NUMBER,getOrderNumber());
        }catch (Exception e){
            System.out.println("Exception While Updating OrderNumber : ClickOnGoTOMyOrdersButton");
        }
        myActions.action_click(clickHereButton);
    }

    public void clickOnGoTOMyOrdersButton(){
        try{
            PropertyReader.setValue(PropertyReader.Keys.ORDER_NUMBER,getOrderNumber());
        }catch (Exception e){
            System.out.println("Exception While Updating OrderNumber : ClickOnGoTOMyOrdersButton");
        }
        myActions.action_click(myOrdersButton);
    }

    public String getOrderSuccessfulText(){return myActions.action_getText(orderSuccessfulText);}

    public String getOrderID(){return myActions.action_getText(orderID);}

    public String getOrderIDData(){return getMyBagApiResponse.getOrderDetails().get(0);}

    public String getOrderSuccessfulHeading(){return getMyBagApiResponse.getOrderDetails().get(1);}

}
