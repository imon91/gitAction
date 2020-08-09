package generator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileOutputStream;

public class PublishReport {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Called here");
        WebDriverManager.chromedriver().setup();
    }


    @Test
    public void publish() throws Exception{
        Runtime.getRuntime().exec("python3 -m http.server 8000 --bind 0.0.0.0");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://0.0.0.0:8000/src/main/java/index.html");
        System.out.println(driver.getCurrentUrl());
        String htmlData = driver.findElement(By.id("parent-tag")).getAttribute("outerHTML");
        System.out.println(htmlData);
        System.out.println("Total Tests Count : "+driver.findElement(By.id("tests-count")).getText());
        driver.quit();
        File htmlTemplateFile = new File(System.getProperty("user.dir")+"/src/main/java/finalReports/daily_report.html");
        FileOutputStream fileOutputStream = new FileOutputStream(htmlTemplateFile);
        fileOutputStream.write(htmlData.getBytes());
        fileOutputStream.close();
    }

    @AfterSuite
    public void killAllProcess() throws Exception{
        Runtime.getRuntime().exec("killall Python");
    }
}
