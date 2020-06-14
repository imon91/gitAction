package utils;

import io.appium.java_client.android.AndroidElement;

public class MyActions extends AndroidBaseClass{

    public void action_click(AndroidElement element){
        sleep(300);
        element.click();
    }

    public void action_sendKeys(AndroidElement element, String data){
        sleep(300);
        element.sendKeys(data);
    }

    public String action_getText(AndroidElement element){
        sleep(300);
        return element.getText();
    }

    public String action_getTagName(AndroidElement element){
        sleep(300);
        return element.getTagName();
    }
}
