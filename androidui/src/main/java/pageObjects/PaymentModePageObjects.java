package pageObjects;

import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.*;
import java.util.*;

public class PaymentModePageObjects extends AndroidBaseClass {


    private AndroidDriver<WebElement> androidDriver;
    private MyActions myActions;

    public PaymentModePageObjects(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
    }


    @FindBy(xpath = "//div[@class='panel-heading']/h4/a")
    private WebElement paymentMethods;

    @FindBy(xpath = "//div[@class='summary-container']/following-sibling::div[1]/button")
    private WebElement makePaymentTopButton;

    @FindBy(xpath = "//div[@class='home-deliver-text']/a")
    private WebElement changeAddress;


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

    public List<WebElement> getListOfPaymentMode(){
        return xpathListSetter("//div[@class='panel-heading']/h4/a");
    }


    public void proceedPaymentWithoutChangeAddressThroughTopButton(){
        selectPaymentOptionCOD();
        sleep(3000);
        clickOnPayTopButton();

    }


}
