package org.tq.HomeTestScript;

import org.testng.annotations.Test;
import org.tq.EsignGenie.BaseClass;
import org.tq.Home.HomePages;
import org.tq.LoginPages.LoginPage;
import org.tq.LoginPages.LogoutPages;

import com.aventstack.extentreports.ExtentTest;

public class AllTabofHomeTestScript extends BaseClass
{
	@Test(priority=1, enabled=false)
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
	
	@Test(priority=2, enabled=false)
	public void verifyDocumentWaitingForMySignature() throws Exception
	{
		ExtentTest test = report.createTest("Verify the logout application", "This Test is verified to Document Waiting For My Signature");
		test.info("Start the execution of Test Case-->Document Waiting For My Signature");
		HomePages homepage= new HomePages(driver);
		homepage.documentWaitingForMySignature();
		test.pass("Pass");
		test.info("Test case has been executed Successfully-->Document Waiting For My Signature");
	}
	
	@Test(priority=3, enabled=false)
	public void logOutApplication() throws InterruptedException
	{
		ExtentTest test = report.createTest("Verify the logout application", "This Test is verified to logout application");
		test.info("Start the execution of Test Case-->Logout Application");
		LogoutPages logout = new LogoutPages(driver);
		logout.logOut();
		test.pass("Pass");
		test.info("Test case has been executed Successfully-->Logout Application.");
	}
	
	@Test(priority=4, enabled=false)
	public void loginTestwithDifferentUser() throws Exception
	{
		//ExtentTest test = extent.createTest("Login Test", "This Test is verified the login functionality");
		ExtentTest test = report.createTest("Verify the Login Test", "This Test is verified the login functionality.");
		test.info("Start the execution of Test Case-->Login the EsignGenie Account with valid credentials.");
		LoginPage login= new LoginPage(driver);
		login.LoginaccountwithDifferentUser("sjain@accountsight.com", "Shivam");
		test.pass("Pass");
		test.info("Test case has been executed Successfully-->Login functionality.");
	}
	
	@Test(priority=5, enabled=false)
	public void verifyDocumentWaitingForOtherSignature() throws InterruptedException
	{
		ExtentTest test = report.createTest("Verify the logout application", "This Test is verified to logout application");
		test.info("Start the execution of Test Case-->Logout Application");
		HomePages homepage= new HomePages(driver);
		homepage.documentWaitingForOtherSignature();
		test.pass("Pass");
		test.info("Test case has been executed Successfully-->Logout Application.");
	}
	
	@Test(priority=1)
	public void CreateDocumentFromHomePage() throws Exception
	{
		ExtentTest test = report.createTest("Verify the Create Document from HomePage", "This Test is verified to Create Document from HomePage");
		test.info("Start the execution of Test Case-->Create Document from HomePage");
		LoginPage login= new LoginPage(driver);
		login.Loginaccount("shvmjain@gmail.com", "Shivam");
		LogoutPages logout = new LogoutPages(driver);
		HomePages homepage= new HomePages(driver);
		homepage.uploadPDF();
		homepage.addMe();
		homepage.addNewParty();
		homepage.dragAndDropSignatureField();
		homepage.dragAndDropDataField();
		homepage.updatePropertyOfInitialField();
		homepage.updatePropertyOfSignerEmail();
		homepage.updatePropertyOfSignerName();
		homepage.saveDocument();
		homepage.sendDocument();
		logout.logOut();
		test.pass("Pass");
		test.info("Test case has been executed Successfully-->Create Document from HomePage");
	}
	
	@Test(priority=2, enabled=false)
	public void VerifyProcessOfSignatureOfOnePartyToOtherParty() throws Exception
	{
		ExtentTest test = report.createTest("Verify the process of Signature on Document of both of party", "This Test is verified to Signature on Document of both of party");
		test.info("Start the execution of Test Case-->Signature on Document of both of party");
		LoginPage login= new LoginPage(driver);
		HomePages homepage= new HomePages(driver);
		LogoutPages logout = new LogoutPages(driver);
		login.Loginaccount("shvmjain@gmail.com", "Shivam");
		//login.Loginaccount("sjain@accountsight.com", "Shivam");
		homepage.documentWaitingForMySignature();
		logout.logOut();
		login.LoginaccountwithDifferentUser("sjain@accountsight.com", "Shivam");
		homepage.documentWaitingForOtherSignature();
		logout.logOut();
		test.pass("Pass");
		test.info("Test case has been executed Successfully-->Signature on Document of both of party");
	}
	
	@Test(priority=3, enabled=true)
	public void VerifyDocumentwaitingformysignature() throws Exception
	{
		ExtentTest test = report.createTest("Verify the process of Document waiting for my signature", "This Test is verified to Document waiting for other signature");
		test.info("Start the execution of Test Case-->Document waiting for my signature");
		LoginPage login= new LoginPage(driver);
		HomePages homepage= new HomePages(driver);
		LogoutPages logout = new LogoutPages(driver);
		login.LoginaccountwithDifferentUser("shvmjain@gmail.com", "Shivam");
		//login.Loginaccount("sjain@accountsight.com", "Shivam");
		homepage.documentWaitingForMySignature();
		logout.logOut();
		test.pass("Pass");
		test.info("Test case has been executed Successfully-->Document waiting for my signature");
	}
	
	@Test(priority=4, enabled=true)
	public void VerifyDocumentwaitingforOthersignature() throws Exception
	{
		ExtentTest test = report.createTest("Verify the process of Document waiting for other signature", "This Test is verified to Document waiting for other signature");
		test.info("Start the execution of Test Case-->Document waiting for other signature");
		LoginPage login= new LoginPage(driver);
		HomePages homepage= new HomePages(driver);
		LogoutPages logout = new LogoutPages(driver);
		login.LoginaccountwithDifferentUser("sjain@accountsight.com", "Shivam");
		homepage.documentWaitingForOtherSignature();
		logout.logOut();
		test.pass("Pass");
		test.info("Test case has been executed Successfully-->Document waiting for other signature");
	}

}
