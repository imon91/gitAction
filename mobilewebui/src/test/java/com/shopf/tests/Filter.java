package com.shopf.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.PLPPageObjects;
import utils.WebAppBaseClass;

public class Filter extends WebAppBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private PLPPageObjects plp;



    @BeforeClass(alwaysRun = true)
    public void FilterBeforeClass() throws Exception {
        System.out.println("FilterBeforeClass is called");
        androidDriver = getBaseDriver();
        plp = new PLPPageObjects(androidDriver);
    }



    @Test(groups = {CoreConstants.GROUP_SMOKE})
    public void verifyFiltering(){
        System.out.println("control came to verifyFiltering");
        //plp.FilteringProduct();
        plp.filter(0,0);
    }



    @Test(groups = {CoreConstants.GROUP_SMOKE})
    public void verifySorting(){
        System.out.println("control came to verifySorting");
        sleep(6000);/*
        //WebElement element = androidDriver.findElement(By.xpath(""));
        //JavascriptExecutor executor = (JavascriptExecutor)androidDriver;
        //executor.executeScript("arguments[0].click();", element);
        //System.out.println("sortTab is clicked");
        //sleep(6000);
        //plp.switchingcontext();
        //System.out.println("switch happened");
        Select select = new Select(androidDriver.findElement(By.xpath("//select")));
        select.selectByIndex(2);
        sleep(6000);*/
        //plp.clickOnSortTab();
        //System.out.println(plp.sorttype(0));
        plp.sorttype(0);
        sleep(2000);
        //plp.sort(0);
    }



    @AfterClass(alwaysRun = true)
    public void FilterAfterClass(){
        System.out.println("FilterAfterClass is called");
    }


}
