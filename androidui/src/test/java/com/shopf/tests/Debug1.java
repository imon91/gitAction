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
        Assert.assertEquals(100,100);
    }


    @Test(groups = "debug",dependsOnMethods = "test4")
    public void test9(){
        Assert.assertEquals(100,100);
    }

    @Test(groups = "debug",dependsOnMethods = "test2")
    public void test10(){
        Assert.assertEquals(100,100);
    }


    @Test(groups = "debug",dependsOnMethods = "test3")
    public void test11(){
        Assert.assertEquals(100,100);
    }


    @Test(groups = "debug",dependsOnMethods = "test4")
    public void test12(){
        Assert.assertEquals(100,100);
    }

    @Test(groups = "debug",dependsOnMethods = "test2")
    public void test13(){
        Assert.assertEquals(100,100);
    }


    @Test(groups = "debug",dependsOnMethods = "test3")
    public void test14(){
        Assert.assertEquals(100,100);
    }


    @Test(groups = "debug",dependsOnMethods = "test4")
    public void test15(){
        Assert.assertEquals(100,100);
    }


    @Test(groups = "debug",dependsOnMethods = "test3")
    public void test16(){
        Assert.assertEquals(100,100);
    }


    @Test(groups = "debug",dependsOnMethods = "test4")
    public void test17(){
        Assert.assertEquals(100,100);
    }

    @Test(groups = "debug",dependsOnMethods = "test2")
    public void test18(){
        Assert.assertEquals(100,100);
    }


    @Test(groups = "debug",dependsOnMethods = "test3")
    public void test19(){
        Assert.assertEquals(100,100);
    }


    @Test(groups = "debug",dependsOnMethods = "test4")
    public void test20(){
        Assert.assertEquals(100,100);
    }

}
