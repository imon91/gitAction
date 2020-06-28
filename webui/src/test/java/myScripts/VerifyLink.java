package myScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class VerifyLink {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/nikhiljustus/Downloads/chromedriver");
        WebDriver sra = new ChromeDriver();
        sra.get("https://shopup.com.bd/r");
        Thread.sleep(1000);
        int dl = 1, wl = 0, nwl = 0, att = 0;
        String l = " ", cl = " ";
        List<WebElement> all = sra.findElements(By.tagName("a"));
        Actions actions = new Actions(sra);
        System.out.println(all.size());
        for (int i = 1; i < all.size(); i++) {
            if (all.get(i).isDisplayed()) {
                System.out.print(dl + ".");
                WebElement e = all.get(i);
                actions.moveToElement(e).keyDown(Keys.COMMAND).keyDown(Keys.SHIFT).click().perform();
                Thread.sleep(1000);
                actions.keyUp(Keys.CONTROL).keyUp(Keys.SHIFT);
                ArrayList tabs = new ArrayList(sra.getWindowHandles());
                try {
                    sra.switchTo().window((String) tabs.get(1));
                    dl++;
                } catch (IndexOutOfBoundsException exc) {
                    continue;
                }
                cl = sra.getCurrentUrl();
                sra.close();
                sra.switchTo().window((String) tabs.get(0));
                System.out.println(" " + cl + " - " + all.get(i).getAttribute("href"));
                if (cl.equals(all.get(i).getAttribute("href")))
                    System.out.println("Matches");
                else
                    System.out.println("Does not Match");
                Thread.sleep(1000);
                all = sra.findElements(By.tagName("a"));

            }
        }
    }
}
    /*public boolean clickOn(WebElement element, WebDriver driver, int timeout)
    {
        try{
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
        element.click();
        return true;
    }catch (Exception e){
            return false;
        }
}}*/
