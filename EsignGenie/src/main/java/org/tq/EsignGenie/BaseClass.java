package org.tq.EsignGenie;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.tq.Utility.BrowserFactory;
import org.tq.Utility.EmailSent;
import org.tq.Utility.ExcelUtility;
import org.tq.Utility.GetProperty;
import org.tq.Utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

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
		//ExtentAventReporter extent= new ExtentAventReporter(new File(System.getProperty("user.dir")+"./ExtentReports/EsignGenie"+Helper.getcurrentDateTime())+".html" );
		ExtentHtmlReporter extent= new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"./ExtentReports/EsignGenie"+Helper.getcurrentDateTime())+".html" );
		extent.config().setEncoding("utf-8");
		extent.config().setTheme(Theme.DARK);
		extent.config().setDocumentTitle("Test Execution Report");
		extent.config().setReportName("EsignGenie Test Report");
		report = new ExtentReports();
		report.attachReporter(extent);
		report.setSystemInfo("Tester Name", "Shivam Jain");
		report.setSystemInfo("Project Name", "eSignGenie Software");
		report.setSystemInfo("Platform", "Windows");
		report.setSystemInfo("OS", "Windows 10");
		report.setSystemInfo("Company Name", "AccountSight Pvt LTD");
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
		
	//	report.flush();
		Reporter.log("Test Completed >>> Extent Report Generated", true);
		EmailSent.emailSentAfterSuccessfullTestCaseExecution();
		BrowserFactory.quitDriver(driver);
	}
	
	@BeforeMethod
	public void register(Method method)
	{
		String testName=method.getName();
		logger=report.createTest(testName);
	}

	@AfterMethod
	public void  TearDownMethod(ITestResult result) throws IOException
	{
		Reporter.log("Test is about to End", true);

		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.log(Status.FAIL, "The Test Method name as "+result.getName()+"is failed");
			logger.log(Status.FAIL, "Test Failure"+result.getThrowable());
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenShot(driver)).build());
		}

		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.log(Status.PASS, "The Test Method name as "+result.getName()+"is passed");
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenShot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.log(Status.SKIP, "The Test Method name as "+result.getName()+"is skipped");
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenShot(driver)).build());
		}
		report.flush();
		Reporter.log("Test Completed >>> Extent Report Generated", true);
	}
	
//	@AfterTest
//	public void cleanUp()
//	{
//		report.flush();
//	}

}
