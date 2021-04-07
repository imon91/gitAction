package pageObjects;

import auth.CookieManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import utils.*;
import java.util.*;
import java.util.NoSuchElementException;

public class SAPPanelPageObject extends SapBaseClass {
    private WebDriver driver;
    private MyActions myActions;

    public SAPPanelPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
    }

    private WebElement phoneNumberInput;
    private List<WebElement> otpInputFields;
    private WebElement loginButton;
    private WebElement loginErrorMsg;
    private WebElement logistics;
    private WebElement receive;
    private WebElement hubDropDown;
    private WebElement tejgaonHub;
    private WebElement viewResellerParcel;
    private WebElement parcelIDText;
    private WebElement popupCloseButton;
    private WebElement reconcileLaterButton;


    public void enterPhoneNumberInput(String mobileNo)
    {
        phoneNumberInput = xpathSetter("//div[@class='form-group']/input");
//        phoneNumberInput = xpathSetter(driver,"//div[@class='form-group']/input");
        phoneNumberInput.clear();
        myActions.action_sendKeys(phoneNumberInput,mobileNo);
        sleep(500);
        phoneNumberInput.sendKeys(Keys.ENTER);
    }

    public void enterOtpInput(String otp)
    {
        otpInputFields = xpathListSetter("//div[@class='verification-input']/input");
//        otpInputFields = xpathListSetter(driver,"//div[@class='verification-input']/input");
//        otpInputFields = driver.findElements(By.xpath("//div[@class='verification-input']/input"));
        for (int i=0;i<4 ; i++){
            myActions.action_sendKeys(otpInputFields.get(i), String.valueOf(otp.charAt(i)));}
    }

    public void clickLoginButton()
    {
        loginButton = xpathSetter("//div[@class='panel-body'][2]/button");
//      loginButton = xpathSetter(driver,"//div[@class='panel-body'][2]/button");
//      loginButton = driver.findElement(By.xpath("//div[@class='panel-body'][2]/button"));
        myActions.action_click(loginButton);
    }

    public String getLoginErrorMsg()
    {
        loginErrorMsg = xpathSetter("//strong[text()='Login Error']/../small");
        return myActions.action_getText(loginErrorMsg);
    }

    public void clickOnLogisticsModule()
    {
        logistics = xpathSetter("//ul[@class='nav luna-nav']/li[7]");
        myActions.action_click(logistics);
    }

    public void clickOnReceiveIcon()
    {
        receive = xpathSetter("//ul[@class='nav nav-second in collapse']/li[2]");
        myActions.action_click(receive);
    }

    public void clickOnReconcileLaterButton()
    {
        reconcileLaterButton = xpathSetter("//div[@class='modal-content']/div/div[3]/button[2]");
        myActions.action_click(reconcileLaterButton);
    }

    public void clickHubDropDown()
    {
        hubDropDown = xpathSetter("//div[@class='col-xs-2']/select");
        myActions.action_click(hubDropDown);
    }

    public void clickOnTejgaonHub()
    {
        tejgaonHub = xpathSetter("//div[@class='col-xs-2']/select/option[9]");
        myActions.action_click(tejgaonHub);
    }

    public void clickOnViewResellerTab()
    {
        viewResellerParcel = xpathSetter("//div[@class='content receiving-content text-center ng-scope']/div[2]/div[3]/button");
        myActions.action_click(viewResellerParcel);
    }

    public void enterAndApplyParcelID(String parcelID)
    {
        parcelIDText = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='left-panel']//div[@class='ui-control-wrap'][1]/input")));
        myActions.action_sendKeys(parcelIDText,parcelID);
        sleep(300);
        parcelIDText.sendKeys(Keys.ENTER);
        sleep(300);
        try{
            popupCloseButton = xpathSetter("//div[@class='modal-content']/div[3]/button");
            myActions.action_click(popupCloseButton);}
        catch (NoSuchElementException e)
        {
            System.out.println("The error occured at parcelID"+parcelID);
            WebElement clickSomeWareParcelPopup = xpathSetter("//input[@type='text'][@placeholder='Invoice Number']");
            myActions.action_click(clickSomeWareParcelPopup);
        }
    }

    public String performAuthentication(String mobileNo, String otp)
    {
        enterPhoneNumberInput(mobileNo);
        enterOtpInput(otp);
        clickLoginButton();
        sleep(3000);
        String ck = null;
        for(Cookie cookie : driver.manage().getCookies()){
            ck = cookie.getName();
            if(ck.equalsIgnoreCase("__ti__"))
            {
                ck = cookie.getName() + "=" + cookie.getValue();
//                System.out.println("Cookie Value : " + ck);
                try {
                    CookieManager.setValue(CookieManager.Keys.SAP_WEB_COOKIE,ck);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return ck;
            }
        }
        return null;
    }






}
