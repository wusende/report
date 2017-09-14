package com.ihuoli;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentXReporter;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;


public class SimpleTest {
    private ExtentReports  extent;

    @Test
    public void level1() throws IOException {
        System.out.println("level1 test begin");

        // creates a toggle for the given test, adds all log events under it
        ExtentTest test = InitDriverCase.getTest();

        test.info("Level 1 test start");
        test.fail("Level 1 test failed", MediaEntityBuilder.createScreenCaptureFromPath("/Users/xinwu/Desktop/screenshot.png").build());
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

}
