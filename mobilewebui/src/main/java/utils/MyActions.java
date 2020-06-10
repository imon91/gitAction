package utils;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;

public class MyActions {
    public void action_click(WebElement element){
        element.click();
    }

    public void action_sendKeys(WebElement element, String data){
        CommonUtils.threadSleep(3000);
        element.sendKeys(data);
    }

    public String action_getText(WebElement element){
        CommonUtils.threadSleep(1000);
        return element.getText();
    }

    public String action_getTagName(WebElement element){
        CommonUtils.threadSleep(1000);
        return element.getTagName();
    }
}
