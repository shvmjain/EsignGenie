package org.tq.EsignGenie;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.tq.Utility.BrowserFactory;
import org.tq.Utility.EmailSent;
import org.tq.Utility.ExcelUtility;
import org.tq.Utility.GetProperty;
import org.tq.Utility.Helper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass
{
	public static WebDriver driver;
	public GetProperty config;
	public ExtentReports report;
	public ExtentTest logger;
	public ExcelUtility excel;
	@BeforeSuite
	public void setupSuite()
	{
		Reporter.log("Settings done Test can be started ", true);
	//	excel= new ExcelUtility(null);
		config= new GetProperty();
		ExtentHtmlReporter extent= new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"./ExtentReports/EsignGenie"+Helper.getcurrentDateTime())+".html" );
		report = new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("Setting done Test can be started", true);
	}

	@BeforeClass
	public void setup()
	{
		Reporter.log("Trying to start Browser and Getting application ready", true);
		driver= BrowserFactory.startApplication(driver, config.getBrowser(), config.getUrl());
		Reporter.log("Browser and Application is up and running");
	}

	@AfterClass
	public void tearDown() throws Exception
	{
		
		report.flush();
		Reporter.log("Test Completed >>> Extent Report Generated", true);
		//EmailSent.emailSentAfterSuccessfullTestCaseExecution();
		BrowserFactory.quitDriver(driver);
	}

//	@AfterMethod
//	public void  TearDownMethod(ITestResult result) throws IOException
//	{
//		Reporter.log("Test is about to End", true);
//
//		if(result.getStatus()==ITestResult.FAILURE)
//		{
//			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenShot(driver)).build());
//		}
//
//		else if(result.getStatus()==ITestResult.SUCCESS)
//		{
//			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenShot(driver)).build());
//		}
//		else if(result.getStatus()==ITestResult.SKIP)
//		{
//			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenShot(driver)).build());
//		}
//		report.flush();
//		Reporter.log("Test Completed >>> Extent Report Generated", true);
//	}

}
