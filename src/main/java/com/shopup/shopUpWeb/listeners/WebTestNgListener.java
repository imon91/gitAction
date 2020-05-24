package com.shopup.shopUpWeb.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class WebTestNgListener implements ITestListener {

    public void onTestStart(ITestResult iTestResult) {

    }

    public void onTestSuccess(ITestResult iTestResult) {

    }

    public void onTestFailure(ITestResult iTestResult) {

        //takeScreenshotAtEndOfTest(iTestResult.getMethod().getMethodName());

    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
}

