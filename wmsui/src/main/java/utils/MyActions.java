package utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyActions extends WmsBaseClass {

    public void action_click(WebElement element){
        element.click();
    }

    public void action_sendKeys(WebElement element, String data){
        element.sendKeys(data);
    }

    public String action_getText(WebElement element){
        return element.getText();
    }

    public String action_getTagName(WebElement element){
        sleep(1000);
        return element.getTagName();
    }

    //Select DropDown By Visible Text
    public void action_select(WebElement element, String data){
        sleep(1000);
        Select select = new Select(element);
        select.selectByVisibleText(data);
    }

    //Press Enter explicitly once Entry Fields are filled
    public void action_enter(WebElement element){
        sleep(1000);
        element.sendKeys(Keys.ENTER);
    }

    //Select DropDown By Index
    public void action_select_index(WebElement element, int index){
        sleep(1000);
        Select select = new Select(element);
        select.selectByIndex(index);
    }
}
