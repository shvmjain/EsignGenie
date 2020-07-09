package org.tq.EsignGenieTestScript;

import org.testng.annotations.Test;
import org.tq.EsignGenie.BaseClass;
import org.tq.LoginPages.LoginPage;
import org.tq.LoginPages.LogoutPages;

import com.aventstack.extentreports.ExtentTest;

public class LogoutTest extends BaseClass
{
	@Test(priority=1)
	public void loginTest() throws Exception
	{
		//ExtentTest test = extent.createTest("Login Test", "This Test is verified the login functionality");
		ExtentTest test = report.createTest("Verify the Login Test", "This Test is verified the login functionality.");
		test.info("Start the execution of Test Case-->Login the EsignGenie Account with valid credentials.");
		LoginPage login= new LoginPage(driver);
		login.Loginaccount("shvmjain@gmail.com", "Shivam");
		test.pass("Pass");
		test.info("Test case has been executed Successfully-->Login functionality.");
	}
	
	
	@Test(priority=2)
	public void logOutApplication() throws InterruptedException
	{
		ExtentTest test = report.createTest("Verify the logout application", "This Test is verified to logout application");
		test.info("Start the execution of Test Case-->Logout Application");
		LogoutPages logout = new LogoutPages(driver);
		logout.logOutfromHomePage();
		test.pass("Pass");
		test.info("Test case has been executed Successfully-->Logout Application.");
	}
}
