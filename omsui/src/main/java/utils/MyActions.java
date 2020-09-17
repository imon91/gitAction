package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class MyActions extends OmsBaseClass {

    public void action_click(WebElement element){
        try{
            element.click();
        }catch (ElementClickInterceptedException e){
            action_click(element);
            System.out.println("ElementClickInterceptedException");
        }catch (StaleElementReferenceException e){
            action_click(element);
        }
        catch (NoSuchElementException e){
            System.out.println(e);
        }
        catch (Exception e){
            action_click(element);
            System.out.println(e);
        }

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
        Select select = new Select(element);
        select.selectByVisibleText(data);
    }

    //Press Enter explicitly once Entry Fields are filled
    public void action_enter(WebElement element){
        element.sendKeys(Keys.ENTER);
    }

    //Select DropDown By Index
    public void action_select_index(WebElement element, int index){
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public void action_clear_text(WebElement element){
        element.clear();
    }
}
