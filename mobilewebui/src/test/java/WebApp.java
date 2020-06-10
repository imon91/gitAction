import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import MyPageObjects.HomePageObjects;
import MyUtils.BaseClass;
import MyUtils.DriverControls;


public class WebApp extends BaseClass
{
    public static void main(String[] args) throws Exception {
        BaseClass baseClass = new BaseClass();
        AndroidDriver<WebElement> driver;
        DriverControls driverControls;
        HomePageObjects homePageObjects = null;
        baseClass.startService();
        driver= baseClass.getDriver();
        driverControls = new DriverControls(driver);
        driver.get("https://uatwap.shopups1.xyz/r");
        driverControls.setImplicitWait(30);
        homePageObjects.searchForObject("Shirt");
        driver.findElementByCssSelector("#content > div > div:nth-child(4) > div.page-body > div > div > div > div > div:nth-child(2) > div > div > div > div:nth-child(2) > div > div.feed-grid-main > div > div.feed-grid-container > ul > li:nth-child(1) > div > a").click();
        driver.findElementByXPath("//input[@class='hide' and @value='M']").click();
        driver.findElementByCssSelector("#content > div > div:nth-child(4) > div.page-body > div > div > div > div > div > div.product-details > div.pdp-det-box.available-sizes > div > button.btn.mrvoonik-primary-btn").click();
    }
}
