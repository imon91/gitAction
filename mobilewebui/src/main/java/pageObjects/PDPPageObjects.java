package pageObjects;

import MyPageObjects.MyShopPageObjects;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;
import utils.WebAppBaseClass;

import java.util.Random;

public class PDPPageObjects extends WebAppBaseClass {

    private AndroidDriver<WebElement> driver;
    private MyActions myActions;

    public PDPPageObjects(AndroidDriver<WebElement> androidDriver) {
        this.driver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        myActions = new MyActions();
    }


    //addtomyshop
    @FindBy(xpath = "//button[contains(text(),'Add to My Shop')]")
    private WebElement AddToMyShopButton;

    //BuyNowButton
    @FindBy(xpath = "//button[contains(text(),'Buy Now')]")
    private WebElement BuyNowButton;

    //ImageofProduct
    @FindBy(xpath = "//div[@class='item']")
    private WebElement ImageofProduct;

    //closeImageofProduct
    @FindBy(xpath = "//div[@class='close-image-pop']")
    private WebElement CloseImage;

    //sizechart
    @FindBy(xpath = "")
    private WebElement Sizechart;

    //closeSizeChart
    @FindBy(xpath = "")
    private WebElement CloseSizeChart;

    //chooseCollection
    @FindBy(xpath = "")
    private WebElement ChooseOurCollection;




/*-------Actions---------*/



    public void clickOnAddToMyShop(){myActions.action_click(AddToMyShopButton);};

    public void clickOnBuyNow(){myActions.action_click(BuyNowButton);};

    public void clickOnImageOfProduct(){myActions.action_click(ImageofProduct);};

    public void clickOnCloseButton(){myActions.action_click(CloseImage);}


/*-------Functions------*/


public void selectOneCollection(){
    //MyShopPageObjects shop = new MyShopPageObjects(driver);
    //String NoOfCollections = shop.getNoOfCollectionText();
    //int y = Integer.parseInt(NoOfCollections);
    //Random random = new Random();
    //int x = random.nextInt(y);
    //driver.findElementByXPath("//button[@class='user-collection-item btn mrvoonik-clear-btn'][x]").click();
    driver.findElementByXPath("//button[contains(text(),'shirts')][1]").click();
}


}

