package generator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;

public class PublishReport {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Called here");
    }


    @Test
    public void publish() throws Exception{
        System.setProperty("webdriver.chrome.driver","/Users/jagadeesh-shopf/SeleniumWebDrivers/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://localhost:63342/Shopf%20Ui%20Automation/Shopf_Ui_Automation.automation_report.main/index.html?_ijt=3rl08d7p9fsu6n4oc1ncg55pjl");
        String htmlData = driver.findElement(By.id("parent-tag")).getAttribute("outerHTML");
        System.out.println(htmlData);
        System.out.println("Total Tests Count : "+driver.findElement(By.id("tests-count")).getText());
        driver.quit();
        File htmlTemplateFile = new File(System.getProperty("user.dir")+"/src/main/java/finalReports/daily_report.html");
        FileOutputStream fileOutputStream = new FileOutputStream(htmlTemplateFile);
        fileOutputStream.write(htmlData.getBytes());
        fileOutputStream.close();
    }
}
