package org.tq.Utility;


import org.testng.ITestListener;
import org.testng.ITestResult;
import org.tq.EsignGenie.BaseClass;

public class Listeners extends BaseClass implements ITestListener 
{
	public void onTestStart(ITestResult result) 
	{
		System.out.println("Test Started");
		//Helper.CaptureScreenShot(driver);
	}
	public void onTestFinish(ITestResult result) 
	{
		System.out.println("Test Finished");
		//Helper.CaptureScreenShot(driver);
	}
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("Test Failed");
		//Helper.CaptureScreenShot(driver);
	}
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("Test Successed");
		//Helper.CaptureScreenShot(driver);
	}
	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("Test Skipped");
	}
}
