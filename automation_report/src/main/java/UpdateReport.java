import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class UpdateReport {

    public static void main(String[] args) throws Exception{
        System.setProperty("webdriver.chrome.driver","/Users/jagadeesh-shopf/SeleniumWebDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
         driver.get("https://jenkins-gcp.vnksrvc.com/job/webSanity/354/Reportng_20Report/");
         driver.findElement(By.id("identifierId")).sendKeys("jagadeesh");
        driver.findElement(By.xpath("//div[@jsname='Njthtb']")).click();
         try{
             driver.findElement(By.id("password")).sendKeys("JagadeeshShopUpGmail");
         }catch (ElementNotInteractableException e){
             Thread.sleep(5000);
             driver.findElement(By.id("password")).sendKeys("JagadeeshShopUpGmail");
         }
        driver.findElement(By.xpath("//div[@jsname='Njthtb']")).click();
        driver.quit();
    }

}
