package pageObjects;

import io.appium.java_client.android.*;
import org.openqa.selenium.*;
import utils.*;
import java.util.*;

public class HamburgerMenuPageObjects extends AndroidBaseClass {

    private AndroidDriver<AndroidElement> androidDriver;
    private MyActions myActions;
    private String packageName;
    private ServiceRequestLayer serviceRequestLayer;

    public HamburgerMenuPageObjects(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
        myActions = new MyActions();
        packageName = getAppPackage();
        serviceRequestLayer = new ServiceRequestLayer();
    }

    public String getHamburgerMenuTitle(){
        return myActions.action_getText(androidDriver.
                findElement(By.xpath("//android.widget.TextView[@resource-id='"+packageName+"::id/title'][0]")));
    }

    public List<String> selectRandomCategoryPair(){
        List<String> categoryPair = serviceRequestLayer
                .getControlOverServices().getValidCategoryPair();
        // To gt the category
                myActions.action_click(androidDriver.findElement(
                        By.xpath("//android.widget.TextView[@text='"+categoryPair.get(0)+"']")));
        sleep(1000);
        // To gt the sub-category
        myActions.action_click(androidDriver.findElement(
                By.xpath("//android.widget.TextView[@text='"+categoryPair.get(1)+"']")));
        return categoryPair;
    }



}
