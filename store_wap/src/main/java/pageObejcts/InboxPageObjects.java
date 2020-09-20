package pageObejcts;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.StoreWapActions;

public class InboxPageObjects {


    private AndroidDriver<WebElement> androidDriver;
    private StoreWapActions storeWapActions;


    @FindBy(xpath = "//div[2]/div/div/div/div[2]/div/div/div[3]/div/div[1]/div/div/div")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[1]/div/div/div/div[2]/div[2]/div/div/div/div[2]/div/div/div[1]")
    private WebElement backButton;

    @FindBy(xpath = "//div[2]/div/div/div/div[2]/div/div/div[3]/div/div[2]")
    private WebElement navButton;

    public InboxPageObjects(AndroidDriver<WebElement> androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements((androidDriver), this);
        storeWapActions = new StoreWapActions();
    }

    /*-------------------------------------Actions---------------------------------------------------------------------*/

    public void clickOnBackButton(){storeWapActions.action_click(backButton);}

    public void clickOnNavButton(){storeWapActions.action_click(navButton);}

    /*-------------------------------------Functions------------------------------------------------------------------*/

    public String getPageTitle(){
        return storeWapActions.action_getText(pageTitle);
    }

    public String clickOnCustomer(int customer) {
        String xpath = "//div[text()='Inbox']//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//div[@class='css-1dbjc4n r-13awgt0 r-eqz5dr r-nsbfu8']["+customer+"]";
        WebElement customerElement = androidDriver.findElement(By.xpath(xpath));
        String name = storeWapActions.action_getText(androidDriver.findElement(By.xpath(xpath+"/div/div/div/div/div[2]/div")));
        storeWapActions.action_click(customerElement);
        return name;
    }


}
