import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebApp {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        AndroidDriver<WebElement> driver;
        //cap.setCapability("DeviceName", "GalaxyM10");
        //cap.setCapability("udid","520082dcca3c86db");
        //cap.setCapability("platformName","Android");
        //cap.setCapability("platformVersion","9");
        //cap.setCapability("chromedriverExecutable", "C:\\Users\\siva\\Downloads\\chromedriver83\\chromedriver.exe");
        //cap.setCapability("browserName", "Chrome");
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--disable-notifications");
        cap.setCapability(ChromeOptions.CAPABILITY, opt);
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.get("https://uatwap.shopups1.xyz/r");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        driver.findElementByCssSelector("#header > div.mainHeader___1D0Y8 > div.customHeaderPdp___1MkCO > button").click();
        driver.findElementByCssSelector("#searchTag").sendKeys("Shirt");
        driver.findElementByCssSelector("#header > div.mainHeader___1D0Y8 > div.flex___1bJDE.around___2yVgM.middle___1jEMZ.searchBox___17XJm > button").click();
        driver.findElementByCssSelector("#content > div > div:nth-child(4) > div.page-body > div > div > div > div > div:nth-child(2) > div > div > div > div:nth-child(2) > div > div.feed-grid-main > div > div.feed-grid-container > ul > li:nth-child(1) > div > a").click();
        driver.findElementByXPath("//input[@class='hide' and @value='M']").click();
        driver.findElementByCssSelector("#content > div > div:nth-child(4) > div.page-body > div > div > div > div > div > div.product-details > div.pdp-det-box.available-sizes > div > button.btn.mrvoonik-primary-btn").click();
    }
}
