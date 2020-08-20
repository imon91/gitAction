package pageObejcts;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.StoreWapActions;
import java.util.List;
import java.util.Random;



public class FacebookPageObjects {



    private AndroidDriver<WebElement> androidDriver;
    private StoreWapActions storeWapActions;

    Random random = new Random();


    @FindBy(xpath = "//div[text()='Continue']")
    private WebElement connectFacebookPageContinueButton;

    public FacebookPageObjects(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements((androidDriver), this);
        storeWapActions = new StoreWapActions();
    }


    /*---------------------------------------------Actions--------------------------------------------------------*/


    public void clickContinueAfterConnectFacebookPage(){ storeWapActions.action_click(connectFacebookPageContinueButton);}


    /*--------------------------------------------Functions-------------------------------------------------------*/


    /* zeplin - https://zpl.io/aXxx0yM */
    public String connectRandomFacebookPage(int index){
        String baseXpath = "//div[@class='css-1dbjc4n r-150rngu r-eqz5dr r-16y2uox r-1wbh5a2 r-11yh6sk r-1rnoaur r-1sncvnh']/div";
        //List<WebElement> connectedPagesList = androidDriver.findElements(By.xpath(baseXpath));
        //if(index==0 || index>connectedPagesList.size()){
        //    index = random.nextInt(connectedPagesList.size()+1);
        //}
        String pageName = baseXpath + "/div["+index+"]//div[@class='css-901oao r-14iuakf r-pz5f6p r-1b43r93']";
        WebElement nameOfPage = androidDriver.findElement(By.xpath(pageName));
        String name = storeWapActions.action_getText(nameOfPage);
        String pageXpath = baseXpath +"/div["+index+"]/div/div/div/div[3]/div";
        WebElement selectPage = androidDriver.findElement(By.xpath(pageXpath));
        storeWapActions.action_click(selectPage);
        return name;
    }



}