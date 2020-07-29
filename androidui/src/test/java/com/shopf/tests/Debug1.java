package com.shopf.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Debug1 {


    @Test(groups = "debug")
    public void test1(){
        Assert.assertEquals(10,10);
    }


    @Test(groups = "debug",dependsOnMethods = "test1")
    public void test2(){
        Assert.assertEquals(100,100);
    }


    @Test(groups = "debug",dependsOnMethods = "test2")
    public void test3(){
        Assert.assertEquals(100,100);
    }


    @Test(groups = "debug",dependsOnMethods = "test3")
    public void test4(){
        Assert.assertEquals(112,100);
    }


    @Test(groups = "debug",dependsOnMethods = "test4")
    public void test5(){
        Assert.assertEquals(112,100);
    }

}
