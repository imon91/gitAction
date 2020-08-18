import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileOutputStream;

public class PublishReport {


    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");
        chromeOptions.setAcceptInsecureCerts(true);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://automation-report.herokuapp.com/index.html");
        for(int i=0;i<2;i++){
            Thread.sleep(5000);
            driver.navigate().refresh();
        }
        Thread.sleep(10000);
        System.out.println(driver.getCurrentUrl());
        String htmlData = driver.findElement(By.id("parent-tag")).getAttribute("outerHTML");
        //System.out.println(htmlData);
        //System.out.println("Total Tests Count : "+driver.findElement(By.id("tests-count")).getText());
        driver.quit();
        File htmlTemplateFile = new File(System.getProperty("user.dir")+"/src/main/java/finalReports/daily_report.html");
        FileOutputStream fileOutputStream = new FileOutputStream(htmlTemplateFile);
        fileOutputStream.write(htmlData.getBytes());
        fileOutputStream.close();
        //Runtime.getRuntime().exec("ps aux && pid=$(pgrep Python) && kill -9 $pid");
        //System.out.println("Done");
    }
}
