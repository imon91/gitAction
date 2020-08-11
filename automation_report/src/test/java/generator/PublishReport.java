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
        try{
            Runtime.getRuntime().exec("http-server -S -C localhost+3.pem -K localhost+3-key.pem");
        }catch (Exception e){
            System.out.println("Exception here" + e);
        }
        System.out.println("Called here");
        WebDriverManager.chromedriver().setup();
    }


    @Test
    public void publish() throws Exception{
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.setAcceptInsecureCerts(true);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://127.0.0.1:8080/automation_report/src/main/java/index.html");
        System.out.println(driver.getCurrentUrl());
        String htmlData = driver.findElement(By.id("parent-tag")).getAttribute("outerHTML");
        System.out.println(htmlData);
        System.out.println("Total Tests Count : "+driver.findElement(By.id("tests-count")).getText());
        driver.quit();
        File htmlTemplateFile = new File(System.getProperty("user.dir")+"/src/main/java/finalReports/daily_report.html");
        FileOutputStream fileOutputStream = new FileOutputStream(htmlTemplateFile);
        fileOutputStream.write(htmlData.getBytes());
        fileOutputStream.close();
        //Runtime.getRuntime().exec("ps aux && pid=$(pgrep Python) && kill -9 $pid");
        //System.out.println("Done");
    }

    @AfterSuite
    public void killAllProcess() throws Exception{

        }
}
