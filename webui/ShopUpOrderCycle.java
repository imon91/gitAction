package com.shopf.automation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ShopUpOrderCycle {
    public static void main(String[] args) throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "/Users/nikhiljustus/Downloads/chromedriver");
        WebDriver sul = new ChromeDriver();
        sul.get("https://uatwap.shopups1.xyz/r");
        sul.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        sul.findElement(By.linkText("Login")).click();
        sul.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        sul.findElement(By.xpath("//*[@id=\"newPhone\"]")).sendKeys("01877755590");
        sul.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/button")).click();
        Thread.sleep(500);
        sul.findElement(By.xpath("//*[@id=\"newOtp\"]")).sendKeys("666666");
        sul.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/div/button")).click();
        Thread.sleep(5000);

        //sul.findElement(By.xpath("//*[@id=\"searchTag\"]")).sendKeys("Wallets");
        //sul.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/section[2]/div/div/ul[1]/li[2]/div/form/div/div[1]/div/i")).submit();
        List<WebElement> all = sul.findElements(By.tagName("a"));
        all.get(28).click();
        Thread.sleep(2000);
        sul.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/div/div/div/div/div[1]/div[2]/div/div[2]/div/ul/li[3]/button")).click();
        sul.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(500);
        //sul.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[3]/div/div/div[1]/ul/li/ul/li/div/div[2]/div/div[1]/div[1]/div[2]/input[3]")).click();
        sul.findElement(By.xpath("//*[@id=\"SLF-0-cp\"]")).sendKeys("530");
        //sul.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[3]/div/div/div[1]/ul/li/ul/li/div/div[2]/div/div[1]/div[2]/div[2]/button")).click();
        sul.findElement(By.xpath("//*[@id=\"deliveryCharge\"]")).sendKeys("50");
        Thread.sleep(500);
        Actions actions = new Actions(sul);
        WebElement e = sul.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[3]/div/div/div[2]/div[1]/a/button"));
        Thread.sleep(5000);
        actions.moveToElement(e).click().perform();
        //sul.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[3]/div/div/div[2]/div[1]/a/button")).click();
        Thread.sleep(2000);
        sul.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[3]/div/div/div[1]/div/div[3]/ul/li[2]")).click();
        Thread.sleep(2000);
        sul.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[3]/div/div/div[2]/div[1]/button")).click();
        Thread.sleep(5000);

        sul.quit();
    }

}
