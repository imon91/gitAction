package utils;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyActions extends StoresAppBaseClass {

    public void action_click(WebElement element){
        //sleep(300);
        try{
            element.click();
        }catch (ElementClickInterceptedException e){
            sleep(2000);
            action_click(element);
        }catch (StaleElementReferenceException e){
            sleep(2000);
            action_click(element);
        }
    }

    public void action_sendKeys(WebElement element, String data){
        //sleep(300);
        try{
            element.sendKeys(data);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public String action_getText(WebElement element){
        //sleep(300);
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
        //sleep(300);
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

    //Select DropDown By Visible Text
    public void action_select(WebElement element, String data){
        //sleep(1000);
        try{
            Select select = new Select(element);
            select.selectByVisibleText(data);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    //Select DropDown By Index
    public void action_select_index(WebElement element, int index){
        //sleep(1000);
        try{
            Select select = new Select(element);
            select.selectByIndex(index);
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
