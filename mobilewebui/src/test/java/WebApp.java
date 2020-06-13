import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageObjects.HomePageObjects;
import static utils.WebAppBaseClass.*;


public class WebApp{

    private AndroidDriver<WebElement> driver;
    private HomePageObjects homePageObjects;


    @Test
    public void webAppAutomationSample() throws Exception {

        driver = getBaseDriver();
        setImplicitWait(30);
        driver.get("https://uatwap.shopups1.xyz/r");
       homePageObjects = new HomePageObjects(driver);
        homePageObjects.searchForObject("Shirt");
        driver.findElementByCssSelector("#content > div > div:nth-child(4) > div.page-body > div > div > div > div > div:nth-child(2) > div > div > div > div:nth-child(2) > div > div.feed-grid-main > div > div.feed-grid-container > ul > li:nth-child(1) > div > a").click();
        driver.findElementByXPath("//input[@class='hide' and @value='M']").click();
        driver.findElementByCssSelector("#content > div > div:nth-child(4) > div.page-body > div > div > div > div > div > div.product-details > div.pdp-det-box.available-sizes > div > button.btn.mrvoonik-primary-btn").click();
    }
}
