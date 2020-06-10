package webPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;

public class BottomAddonObjects {
    private WebDriver driver;
    private MyActions myActions;



    public BottomAddonObjects(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
    }

      /*---various policy options ----*/

    //Reseller policy
    @FindBy(xpath = "//a[text()='Reseller Policy']")
    private WebElement resellerPolicyButton;

    //Payment policy
    @FindBy(xpath = "//a[text()='Payments Policy']")
    private WebElement paymentPolicyButton;

    //privacy policy
    @FindBy(xpath = "//a[text()='Privacy Policy']")
    private WebElement privacyPolicyButton;




    public void clickOnResellerPolicyButton(){myActions.action_click(resellerPolicyButton);}

    public void clickOnPaymentPolicyButton(){myActions.action_click(paymentPolicyButton);}

    public void clickOnPrivacyPolicyButton(){myActions.action_click(privacyPolicyButton);}




    /*-------Socialmedia options------*/

    //facebook logo
    @FindBy(xpath = "//img[@src='//shopimages1.vstores.io/web_images/facebook.png']\t")
    private WebElement facebookIcon;

    //Instagram logo
    @FindBy(xpath = "//img[@src='//shopimages1.vstores.io/web_images/instagram-logo.png']")
    private WebElement instagramIcon;

    //Youtube logo
    @FindBy(xpath = "//img[@src='//shopimages1.vstores.io/web_images/youtube.png']")
    private WebElement youtubeIcon;



    public void clickOnFacebookIcon(){myActions.action_click(facebookIcon);}

    public void clickOnInstagramIcon(){myActions.action_click(instagramIcon);}

    public void clickOnYoutubeIcon(){myActions.action_click(youtubeIcon);}




    /*-----Download app icons-------*/

    //Delivery app
    @FindBy(xpath = "//span[text()='DELIVERY APP']")
    private WebElement deliveryAppIcon;

    //Eloan app
    @FindBy(xpath = "//text()[.='eLoan APP']/ancestor::a[1]")
    private WebElement eLoanAppIcon;


    public void clickOnDeliveryAppIcon(){myActions.action_click(deliveryAppIcon);}

    public void clickOneELoanAppIcon(){myActions.action_click(eLoanAppIcon);}



}
