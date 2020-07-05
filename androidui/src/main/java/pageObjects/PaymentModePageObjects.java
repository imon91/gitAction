package pageObjects;

import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.MyActions;

public class PaymentModePageObjects {


    private AndroidDriver<AndroidElement> androidDriver;
    private MyActions myActions;

    public PaymentModePageObjects(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
    }


    @FindBy(xpath = "//div[@class='panel-heading']/h4/a")
    private WebElement codPaymentMode;

    @FindBy(xpath = "//div[@class='summary-container']/following-sibling::div[1]/button")
    private WebElement makePaymentTopButton;

    @FindBy(xpath = "//div[@class='home-deliver-text']/a")
    private WebElement changeAddress;


    public void selectPaymentOptionCOD(){
        myActions.action_click(codPaymentMode);
    }

    public void clickOnPayTopButton(){
        myActions.action_click(makePaymentTopButton);
    }

    public void clickOnChangeAddress(){
        myActions.action_click(changeAddress);
    }


    public void proceedPaymentWithoutChangeAddressThroughTopButton(){
        selectPaymentOptionCOD();
        try {
            Thread.sleep(5000);
        }catch (Exception e){
        }

        clickOnPayTopButton();

    }


}
