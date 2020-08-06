package pageObjects;

import coreUtils.CoreConstants;
import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.*;

public class OrderSuccessFulPageObjects extends AndroidBaseClass{


    private AndroidDriver<WebElement> androidDriver;
    private MyActions myActions;
    private String myPackage;

    public OrderSuccessFulPageObjects(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        switchFromNativeToWeb(CoreConstants.SHOP_UP_RESELLER_WEB_VIEW);
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
        myPackage = getAppPackage();
    }


    @FindBy(xpath = "//span[contains(text(),'Click Here')]")
    private WebElement clickHereButton;

    @FindBy(xpath = "//span[contains(text(),'My Orders')]")
    private WebElement myOrdersButton;

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

}
