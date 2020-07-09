package org.tq.HomeTestScript;

import org.testng.annotations.Test;
import org.tq.EsignGenie.BaseClass;
import org.tq.Home.HomePages;
import org.tq.LoginPages.LoginPage;
import org.tq.LoginPages.LogoutPages;

import com.aventstack.extentreports.ExtentTest;

public class HomeTestScript extends BaseClass

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

	@Test (priority=2, enabled=false)
	public void VerifyTitleofESignGenie() throws InterruptedException
	{
		ExtentTest test = report.createTest("Verify Title of ESignGenie", "This Test is verified the title of application.");
		test.info("Start the execution of Test Case-->Verify the Title.");
		LoginPage login= new LoginPage(driver);
		login.VerifyTitle();
		test.pass("Pass");
		test.info("Test case has been executed Successfully-->Verify the Title. ");
	}

	@Test (priority=3)
	public void createNewDocument() throws InterruptedException
	{
		ExtentTest test = report.createTest("Verify the upload a PDF document", "This Test is verified the upload a PDF document");
		test.info("Start the execution of Test Case-->Verify the Create a New Document.");
		HomePages homepage= new HomePages(driver);
		homepage.uploadPDF();
		test.pass("Pass");
		test.info("Test case has been executed Successfully-->Verify the Create a New Document.");
	}

	@Test(priority=4)
	public void addMe() throws InterruptedException 
	{
		ExtentTest test = report.createTest("Verify Add me as party.", "This Test is verified the Add me as party.");
		test.info("Start the execution of Test Case-->Verify the Add me as party.");
		HomePages homepage= new HomePages(driver);
		homepage.addMe();
		test.pass("Pass");
		test.info("Test case has been executed Successfully-->Verify the Add me as party.");
	}

	@Test(priority=5, enabled=true)
	public void addNewParty() throws InterruptedException 
	{
		ExtentTest test = report.createTest("Verify the Add New Party.", "This Test is verified to Add New Party.");
		test.info("Start the execution of Test Case-->Verify the create a Add New Party.");
		HomePages homepage= new HomePages(driver);
		homepage.addNewParty();
		test.pass("Pass");
		test.info("Test case has been executed Successfully-->Verify the create a Add New Party.");
	}

	@Test(priority=6)
	public void addSignatureField() throws InterruptedException
	{
		ExtentTest test = report.createTest("Verify the Add a New Signature Field on document", "This Test is verified to Add a New Signature Field on document.");
		test.info("Start the execution of Test Case-->Add a New Signature on document.");
		HomePages homepage= new HomePages(driver);
		homepage.dragAndDropSignatureField();
		test.pass("Pass");
		test.info("Test case has been executed Successfully-->Add a New Signature Field on document.");
	}

	@Test(priority=7, enabled=true)
	public void addDataField() throws InterruptedException
	{
		ExtentTest test = report.createTest("Verify the Data Field on document", "This Test is verified to add data field on document.");
		test.info("Start the execution of Test Case-->Add Data Field on document.");
		HomePages homepage= new HomePages(driver);
		homepage.dragAndDropDataField();
		test.pass("Pass");
		test.info("Test case has been executed Successfully-->Add Data Field on document.");

	}

	@Test(priority=8, enabled=true)
	public void updatePartyOfInitialField() throws InterruptedException
	{
		ExtentTest test = report.createTest("Verify the update party of Initial Field", "This Test is verified to update party of Initial Field.");
		test.info("Start the execution of Test Case-->Update party of Initial Field.");
		HomePages homepage= new HomePages(driver);
		homepage.updatePropertyOfInitialField();
		test.pass("Pass");
		test.info("Test case has been executed Successfully-->Update party of Initial Field.");
	}

	@Test(priority=9, enabled=true)
	public void updatePartyOfSignerEmail() throws InterruptedException
	{
		ExtentTest test = report.createTest("Verify the update party of Signer Email", "This Test is verified to update party of signer Email.");
		test.info("Start the execution of Test Case-->Update party of Signer Email.");
		HomePages homepage= new HomePages(driver);
		homepage.updatePropertyOfSignerEmail();
		test.pass("Pass");
		test.info("Test case has been executed Successfully-->Update party of Signer Email.");
	}
	
	@Test(priority=10, enabled=true)
	public void updatePartyOfSignerName() throws InterruptedException
	{
		ExtentTest test = report.createTest("Verify the update party of signer name", "This Test is verified to update party of signer name.");
		test.info("Start the execution of Test Case-->Update party of signer name.");
		HomePages homepage= new HomePages(driver);
		homepage.updatePropertyOfSignerName();
		test.pass("Pass");
		test.info("Test case has been executed Successfully-->Update party of signer name.");
	}
	
	@Test(priority=11, enabled=true)
	public void saveUploadedDocument() throws InterruptedException
	{
		ExtentTest test = report.createTest("Verify the save uploaded document", "This Test is verified to save uploaded document.");
		test.info("Start the execution of Test Case-->Save uploaded document.");
		HomePages homepage= new HomePages(driver);
		homepage.saveDocument();
		test.pass("Pass");
		test.info("Test case has been executed Successfully-->Save uploaded document.");
	}
	
	@Test(priority=12)
	public void sendUploadedDocument() throws InterruptedException
	{
		ExtentTest test = report.createTest("Verify the send uploaded document", "This Test is verified to send uploaded document.");
		test.info("Start the execution of Test Case-->Send uploaded document.");
		HomePages homepage= new HomePages(driver);
		homepage.sendDocument();
		test.pass("Pass");
		test.info("Test case has been executed Successfully-->Send uploaded document.");
	}
	
	@Test(priority=13, enabled=false)
	public void verifyDocumentWaitingForMySignature() throws Exception
	{
		ExtentTest test = report.createTest("Verify the logout application", "This Test is verified to logout application");
		test.info("Start the execution of Test Case-->Logout Application");
		HomePages homepage= new HomePages(driver);
		homepage.documentWaitingForMySignature();
		test.pass("Pass");
		test.info("Test case has been executed Successfully-->Logout Application.");
	}
	
	@Test(priority=14)
	public void logOutApplication() throws InterruptedException
	{
		ExtentTest test = report.createTest("Verify the logout application", "This Test is verified to logout application");
		test.info("Start the execution of Test Case-->Logout Application");
		LogoutPages logout = new LogoutPages(driver);
		logout.logOut();
		test.pass("Pass");
		test.info("Test case has been executed Successfully-->Logout Application.");
	}
	
	
	



}
