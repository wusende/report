package com.ihuoli;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestngListener extends TestListenerAdapter {
    protected static ExtentReports extent;
    protected static ExtentTest test;

    @Override
    public void onTestStart(ITestResult tr) {
        super.onTestStart(tr);

        System.out.println("On test Start");
        extent = InitDriverCase.getExtent();

        System.out.println("extent: " + extent);
        test = extent.createTest(tr.getName());

        InitDriverCase.setTest(test);
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);

        System.out.println(test);
        test.fail(tr.getThrowable());
        extent.flush();

    }


    @Override
    public void onTestSkipped(ITestResult tr) {
        super.onTestSkipped(tr);

        test.skip("SKIP");
        extent.flush();
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);

        System.out.print("call success");
        test.pass("pass");
        extent.flush();
    }

    @Override
    public void onFinish(ITestContext testContext) {
        super.onFinish(testContext);
    }
}