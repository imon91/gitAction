package pageObejcts;


import dataBase.DataBaseCore;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import utils.*;



public class AuthenticationPageObjects extends StoreWapBaseClass {



    private AndroidDriver<WebElement> androidDriver;
    private StoreWapActions storeWapActions;


    //mobile number text input
    @FindBy(xpath = "//div[text()='Enter Mobile Number']//following-sibling::input")
    private WebElement mobileNumberText;

    //Terms of Service button
    @FindBy(xpath = "//span[text()='Terms of Service']")
    private WebElement termsOfServiceButton;

    //Privacy policy button
    @FindBy(xpath = "//span[text()='Privacy Policy']")
    private WebElement privacyPolicyButton;

    //Terms of Service & Privacy policy back button
    @FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-18u37iz']/div[1]")
    private WebElement backButton;

    // verify mobile number button
    @FindBy(xpath = "//div[text()='Verify Mobile Number']")
    private WebElement verifyMobileNumberButton;

    //otp text input
    @FindBy(xpath = "//div[text()='Enter OTP']//following-sibling::input")
    private WebElement otpText;

    //request another otp button
    @FindBy(xpath = "//div[text()='Request Another OTP']")
    private WebElement requestAnotherOtpButton;


    public AuthenticationPageObjects(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements((androidDriver), this);
        storeWapActions = new StoreWapActions();
    }


    /*------------------------------------------Actions---------------------------------------------*/


    public void clickVerifyMobileNumberButton(){ storeWapActions.action_click(verifyMobileNumberButton);}

    public void clickTermsOfServiceButton(){ storeWapActions.action_click(termsOfServiceButton);}

    public void clickPrivacyPolicyButton(){ storeWapActions.action_click(privacyPolicyButton);}

    public void clickBackInPrivacyPolicyOrTermsOfServicePage(){ storeWapActions.action_click(backButton);}

    private void clickRequestAnotherOtp(){ storeWapActions.action_click(requestAnotherOtpButton);}

    public void enterOtp(String otp){ storeWapActions.action_sendKeys(otpText,otp);}

    public void enterMobileNumber(String mobileNumber){ storeWapActions.action_sendKeys(mobileNumberText,mobileNumber);}


    /*------------------------------------------Functions---------------------------------------------*/


    public void clearMobileNumberField(String mobileNumber){
        WebElement mobileNumberText = androidDriver.findElement(By.xpath("//div[text()='Enter Mobile Number']/following-sibling::input"));
        new Actions(androidDriver).click(mobileNumberText).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(mobileNumber).perform();
        clickVerifyMobileNumberButton();
    }

    public void sendOtp(String mobileNumber){
        System.out.println("Mobile Number is : "+mobileNumber);
        enterMobileNumber(mobileNumber+ "\n");
        clickVerifyMobileNumberButton();
    }

    public void sendOtpInvalidMobileNumber(){
        String invalidMobileNumber = "12345678900";
        System.out.println("Invalid mobile number : "+ invalidMobileNumber);
        enterMobileNumber(invalidMobileNumber +  "\n");
        //clickVerifyMobileNumberButton();
    }

    public String getOtpStatusMessage() {
        try {
            WebDriverWait wait = new WebDriverWait(getBaseDriver(), 30);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='css-901oao r-75nptz r-pz5f6p r-1b43r93 r-5njf8e']"))).getText();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public String getErrorMessage(){
        try{
            WebDriverWait wait = new WebDriverWait(getBaseDriver(),30);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='css-901oao r-z6cwzn r-pz5f6p r-1b43r93']"))).getText();
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public void enterValidOtp(){
        String otp = new DataBaseCore().getOTPForStore();
        System.out.println("Valid OTP : "+otp);
        enterOtp(otp + "\n");
        clickVerifyMobileNumberButton();
    }

    public void enterInValidOtp(){
        String otp = "112345";
        System.out.println("Invalid OTP : "+otp);
        enterOtp(otp + "\n");
        clickVerifyMobileNumberButton();
    }

    public void enterValidResendOtp(){
        sleep(32000);
        clickRequestAnotherOtp();
        sleep(5000);
        String otp = new DataBaseCore().getOTPForStore();
        System.out.println("Valid resent OTP : "+otp);
        enterOtp(otp+ "\n");
        clickVerifyMobileNumberButton();
    }

    public void enterInValidResendOtp(){
        sleep(32000);
        clickRequestAnotherOtp();
        String otp = "112345";
        System.out.println("Invalid resend OTP : "+otp);
        enterOtp(otp+ "\n");
        clickVerifyMobileNumberButton();
    }



}

