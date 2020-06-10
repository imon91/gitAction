package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class DriverControls {
      WebDriver driver;
    public DriverControls(WebDriver driver){
        this.driver = driver;
    }

    public void setImplicitWait(long seconds){
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void quitMyDriver(){
        driver.quit();
    }
}
