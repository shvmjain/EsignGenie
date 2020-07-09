package org.tq.EsignGenieTestScript;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.tq.EsignGenie.BaseClass;
import org.tq.LoginPages.LoginPage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class LoginTest extends BaseClass
{
	
	@Test(priority=1, enabled=false)
	public void loginTest() throws Exception
	{
		//ExtentTest test = extent.createTest("Login Test", "This Test is verified the login functionality");
		ExtentTest test = report.createTest("Login Test", "This Test is verified the login functionality");
		test.info("Start the execution of Test Case-->Login the EsignGenie Account with valid credentials");
		LoginPage login= new LoginPage(driver);
		login.Loginaccount("shvmjain@gmail.com", "Shivam");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		test.pass("Pass");
		test.info("Test case has been executed-->Login functionality");
	}
	
	@Test (priority=2, enabled=false)
	public void verifyTitleofESignGenie() throws InterruptedException
	{
		ExtentTest test = report.createTest("Verify Title of ESignGenie", "This Test is verified the title of application");
		test.info("Start the execution of Test Case-->Verify the Title");
		LoginPage login= new LoginPage(driver);
		login.VerifyTitle();
		test.pass("Pass");
		test.info("Test case has been executed-->Verify the Title ");
	}
	
	@Test (priority=3)
	public void verifyForgotPassword() throws InterruptedException
	{
		ExtentTest test = report.createTest("Verify the forgot password", "This Test is verified the forgot password functionality");
		test.info("Start the execution of Test Case-->Verify the forgot password");
		LoginPage login= new LoginPage(driver);
		login.forgotPassword();
		test.pass("Pass");
		test.info("Test case has been executed-->Verify the forgot password");
	}


}
