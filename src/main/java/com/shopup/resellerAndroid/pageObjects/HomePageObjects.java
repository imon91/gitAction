package com.shopup.resellerAndroid.pageObjects;

import com.shopup.utils.MyActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {

    private AndroidDriver<AndroidElement> androidDriver;
    private MyActions myActions;

    public HomePageObjects(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
        myActions = new MyActions();
    }


    /*------------------- List of HomePage Items And Their Functions--------------------------*/


}
