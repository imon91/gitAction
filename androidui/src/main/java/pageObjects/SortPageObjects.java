package pageObjects;

import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.*;

import java.util.List;

public class SortPageObjects {

    private AndroidDriver<AndroidElement> androidDriver;
    private MyActions myActions;

    public SortPageObjects(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
    }


    // Sort Items Container
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.shopup.reseller:id/sort_recycler']")
    private AndroidElement sortRecycler;


    public List<AndroidElement> getSortTexts(){
        List<AndroidElement> sortTextList =
                androidDriver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.shopup.reseller:id/sort_text']"));
        return sortTextList;
    }


    public void clickOnSortElement(String sortText){
        AndroidElement sortElement = androidDriver.findElement(By.xpath("//android.widget.TextView[@text='"+sortText+"']"));
        myActions.action_click(sortElement);
    }


}
