package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.MyActions;
import utils.OmsBaseClass;

import java.util.Random;

public class ImageURLGenerator  extends OmsBaseClass {
    private WebDriver driver;
    private MyActions myActions;
    private Random random;

    public ImageURLGenerator(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
        random = new Random();
    }


    /*--------------Actions-------------------*/
    public void getUrl(){
        driver.get("https://uatap.shopups2.xyz/uploads");
    }

    public void selectCategory() {
        WebElement selectCategory = xpathSetter("//select[@name='upload_options']");
        myActions.action_select(selectCategory, "Upload Image/File");
    }

    public void selectBucket() {
        WebElement selectCategory = xpathSetter("//select[@name='bucket_temp']");
        myActions.action_select(selectCategory, "shopimages1.vstores.io");
    }

    public void selectFolder() {
        WebElement selectCategory = xpathSetter("//select[@name='folder']");
        myActions.action_select(selectCategory, "000_mohan");
    }

    public void selectFile(String filePath) {
        WebElement selectCategory = xpathSetter("//input[@name='files[]']");
        myActions.action_sendKeys(selectCategory, filePath);
    }

    public void clickUpload() {
        WebElement selectCategory = xpathSetter("//input[@name='commit']");
        myActions.action_click(selectCategory);
    }

    private String getURL() {
        WebElement getURL = xpathSetter("//tbody/tr[1]/td[3]");
        return myActions.action_getText(getURL);
    }


    /*--------------Functions-------------------*/
    public String generateURL(){

        String dir = System.getProperty("user.dir");
        int num = random.nextInt(4)+1;
        String filePath = dir + "/imagesForUpload/" + num + ".jpg";

        getUrl();
        selectCategory();
        selectBucket();
        selectFolder();
        selectFile(filePath);
        clickUpload();
        return getURL();
    }
}
