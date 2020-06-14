package pageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

public class LoginPageObject {
    private WebDriver driver;
    private MyActions myActions;


    public LoginPageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements( (driver), this);
        myActions = new MyActions();
    }

    //Login icon
    @FindBy(xpath = "//p[text()='Login']")
    private WebElement loginIconButton;

    //Mobile number entry text
    @FindBy(xpath = "//span[text()='Mobile Number']")
    private WebElement mobileNumberTextView;

    //Skip button
    @FindBy(xpath = "//a[text()='SKIP']")
    private WebElement getSkipLoginButton;

    //continue button
    @FindBy(xpath = "//button[text()='CONTINUE']")
    private WebElement continueButton;

    //otp entry Text box
    @FindBy(xpath = "//span[text()='OTP']")
    private WebElement otpTextView;

    //otp submit button
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElement otpSubmitButton;

    //Resent otp button
    @FindBy(xpath = "//button[text()='Resend']")
    private WebElement resentOtpButton;


    /*--------------Actions-------------------*/
    private void enterMobileNumber(String mobileNumber) {
        myActions.action_sendKeys(mobileNumberTextView, mobileNumber); }

    private void clickContinueButton(){
        myActions.action_click(continueButton);
    }

    private void enterOtp(String otp){ myActions.action_sendKeys(otpTextView,otp); }

    private void clickSubmitButton(){myActions.action_click(otpSubmitButton);}

    private void clickOnLoginButton(){myActions.action_click(loginIconButton);}

    private void clickOnResentOtpButton(){myActions.action_click(resentOtpButton);}

    public String getLoginLabelText(){
        return myActions.action_getText(loginIconButton); }



        /*FUNCTIONS*/

    //1.Normal Authentication Function
        public void performAuthentication(String mobileNumber, String otp){
            clickOnLoginButton();
            enterMobileNumber(mobileNumber);
            clickContinueButton();
            enterOtp(otp);
            clickSubmitButton();
        }





}
