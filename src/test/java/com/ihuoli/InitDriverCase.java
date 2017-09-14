package com.ihuoli;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ResourceCDN;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentXReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.annotations.BeforeClass;

import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class InitDriverCase {
 private static String reportLocation = "extent/extent.html";
 protected static ExtentReports extent;
 protected static ExtentTest test;

  public static ExtentReports getExtent() {
	  if (extent == null) {
		  	System.out.println("before suite execute");
		  	
		  	CustomExtentHtmlReporter htmlReporter = new CustomExtentHtmlReporter(reportLocation);
			extent = new ExtentReports();
			
			// initialize ExtentXReporter
			//远程IP， MongoDB port
			ExtentXReporter extentxReporter = new ExtentXReporter("127.0.0.1", 27017);
			// project name
			extentxReporter.config().setProjectName("Jenkins Report Demo");

			// server URL
			// ! must provide this to be able to upload snapshots
			// Note: this is the address to the ExtentX server, not the Mongo database
			extentxReporter.config().setServerUrl("http://localhost:1337");
			
	        Map<String, String> envMap = (Map<String, String>) System.getenv();
	        String buildNumber = envMap.get("BUILD_NUMBER");
	        
	        if (buildNumber == null || buildNumber.isEmpty()) {
	        	buildNumber = "Build-Local";
	        } else {
	        	buildNumber = "Build-" + buildNumber;
	        }
	        
			// report or build name
			extentxReporter.config().setReportName(buildNumber);
			
			extent.attachReporter(htmlReporter, extentxReporter);
			


	        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);

	        htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setDocumentTitle(reportLocation);
	        htmlReporter.config().setEncoding("gbk");
	        
	        htmlReporter.config().setReportName("Demo Report");
	        
	  }
	  return extent;
	  
  }


public static ExtentTest getTest() {
	return test;
}

public static void setTest(ExtentTest test) {
	InitDriverCase.test = test;
}
  
  
}
