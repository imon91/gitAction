package pageObjects;

import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.*;
import java.util.*;

public class SortPageObjects extends AndroidBaseClass{

    private AndroidDriver<WebElement> androidDriver;
    private MyActions myActions;
    private String packageName;

    public SortPageObjects(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
        packageName = getAppPackage();
    }


    // Sort Items Container
    private WebElement sortRecycler;

    public void getSortRecycler(){
        sortRecycler =
                xpathSetter("//androidx.recyclerview.widget.RecyclerView[@resource-id='"+packageName+":id/sort_recycler']");
    }


    public List<WebElement> getSortTexts(){
        List<WebElement> sortTextList =
                xpathListSetter("//android.widget.TextView[@resource-id='"+packageName+":id/sort_text']");
        return sortTextList;
    }


    public void clickOnSortElement(String sortText){
        WebElement sortElement = xpathSetter("//android.widget.TextView[@text='"+sortText+"']");
        myActions.action_click(sortElement);
    }


}
