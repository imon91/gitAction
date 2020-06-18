package utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebElement;

public class MyActions extends WebAppBaseClass{

    private static TouchAction touchAction = null;
    public void action_click(WebElement element){
        element.click();
    }

    public void action_sendKeys(WebElement element, String data){
       sleep(1000);
        element.sendKeys(data);
    }

    public String action_getText(WebElement element){
        sleep(1000);
        return element.getText();
    }

    public String action_getTagName(WebElement element){
        sleep(1000);
        return element.getTagName();
    }

    public void swipe(int data1, int data2){
        touchAction.press(PointOption.point(0,data1)).waitAction().moveTo(PointOption.point(0,data2)).release().perform();
        return;
    }

    //public void scrollTo(driver,String x){}
}
