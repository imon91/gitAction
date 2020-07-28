package utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;

public class StoreWapActions extends StoreWapBaseClass{

    private static TouchAction touchAction;
    private AndroidDriver<WebElement> androidDriver;

    public void action_click(WebElement element){
        sleep(300);
        try{
            element.click();
        }catch (ElementClickInterceptedException e){
            sleep(2000);
            element.click();
        }catch (StaleElementReferenceException e){
            sleep(2000);
            element.click();
        }
    }

    public void action_sendKeys(WebElement element, String data){
        sleep(300);
        try {
            element.sendKeys(data);
        }catch (IllegalStateException e){
            sleep(2000);
            action_sendKeys(element,data);
        }catch (StaleElementReferenceException e){
            sleep(2000);
            action_sendKeys(element,data);
        }
    }

    public String action_getText(WebElement element){
        sleep(300);
        try {
            return element.getText();
        }catch (IllegalStateException e){
            sleep(2000);
            return action_getText(element);
        }catch (StaleElementReferenceException e){
            sleep(2000);
            return action_getText(element);
        }
    }

    public String action_getTagName(WebElement element){
        sleep(300);
        try {
            return element.getTagName();
        }catch (IllegalStateException e){
            sleep(2000);
            return action_getTagName(element);
        }catch (StaleElementReferenceException e){
            sleep(2000);
            return action_getTagName(element);
        }
    }

    public void swipe(double data1, double data2) throws Exception {
        androidDriver = getBaseDriver();
        touchAction = new TouchAction(androidDriver);
        Dimension dimension = androidDriver.manage().window().getSize();
        int x = (int)(dimension.getHeight() * data1);
        int y = (int)(dimension.getHeight() * data2);
        touchAction.press(PointOption.point(0,x)).waitAction().moveTo(PointOption.point(0,y)).release().perform();
    }

    public void scrollVerticallyToElement(String xpath) throws Exception {
        androidDriver = getBaseDriver();
        WebElement element = androidDriver.findElement(By.xpath(xpath));
        ((JavascriptExecutor) androidDriver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollHorizontallyToElement(String xpath) throws Exception {
        androidDriver = getBaseDriver();
        WebElement element = androidDriver.findElement(By.xpath(xpath));
        ((JavascriptExecutor) androidDriver).executeScript("arguments[1].scrollIntoView(true);", element);
    }

}
