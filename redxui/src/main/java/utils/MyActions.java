package utils;

import io.appium.java_client.android.nativekey.*;
import org.openqa.selenium.WebElement;

public class MyActions extends RedXBaseClass {

    public void action_click(WebElement element){
        sleep(300);
        try{
            element.click();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void action_sendKeys(WebElement element, String data){
        sleep(300);
        try{
            element.sendKeys(data);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public String action_getText(WebElement element){
        sleep(300);
        try{
            return element.getText();
        }catch (Exception e){
            System.out.println(e);
            return e.toString();
        }
    }

    public String action_getTagName(WebElement element){
        return element.getTagName();
    }

    public Boolean action_is_selected(WebElement element) {
        sleep(300);
        if (element.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    public void action_clearText(WebElement element){
        element.clear();
    }

    public void clickOnHardKeyBack() throws Exception{
        try{
            getBaseDriver().pressKey(new KeyEvent(AndroidKey.BACK));
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("Pressed Device BackKey");
    }
}
