package utils;

import org.openqa.selenium.WebElement;

public class MyActions extends WebAppBaseClass{

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
}
