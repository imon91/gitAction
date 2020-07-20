package pageObjects;

import org.openqa.selenium.*;
import utils.*;
import io.appium.java_client.android.*;
import java.util.*;

public class HamburgerMenuPageObjects extends AndroidBaseClass {

    private final AndroidDriver<WebElement> androidDriver;
    private final MyActions myActions;
    private final String packageName;
    private final ServiceRequestLayer serviceRequestLayer;

    public HamburgerMenuPageObjects(AndroidDriver<WebElement> androidDriver){
        this.androidDriver = androidDriver;
        myActions = new MyActions();
        packageName = getAppPackage();
        serviceRequestLayer = new ServiceRequestLayer();
    }

    private WebElement hamburgerMenuTitle;

    private WebElement randomCategory;

    private WebElement randomSubCategory;


    public String getHamburgerMenuTitle(){
        hamburgerMenuTitle = xpathSetter("//android.widget.TextView[@resource-id='"+packageName+"::id/title'][0]");
        return myActions.action_getText(hamburgerMenuTitle);
    }

    public List<String> selectRandomCategoryPair(){
        List<String> categoryPair = serviceRequestLayer
                .getControlOverServices().getValidCategoryPair();
        // To gt the category
        randomCategory = xpathSetter("//android.widget.TextView[@text='"+categoryPair.get(0)+"']");
                myActions.action_click(randomCategory);
        sleep(1000);
        // To gt the sub-category
        randomSubCategory = xpathSetter("//android.widget.TextView[@text='"+categoryPair.get(1)+"']");
        myActions.action_click(randomSubCategory);
        return categoryPair;
    }



}
