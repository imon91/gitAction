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

    @FindBy(xpath = "//div[@class='payment-breakup-link text-center']//p")
    private WebElement paymentBreakup;

    @FindBy(xpath = "//div[@class='modal-footer']//p")
    private WebElement closePaymentBreakup;

    @FindBy(xpath = "//div[@class='you-save-left text-left']//p//b")
    private WebElement earnings;

    @FindBy(xpath = "//div[@class='you-save-right text-right']//p//b")
    private WebElement orderValue;


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
        String[] splitAmount = withTakeAmount.split("");
        return Integer.parseInt(String.valueOf(splitAmount));
    }

    public int getCartValueAmount(){
        String withTakeAmount = myActions.action_getText(orderValue);
        String[] splitAmount = withTakeAmount.split("");
        return Integer.parseInt(String.valueOf(splitAmount));
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
