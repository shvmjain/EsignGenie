package org.tq.Utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Helper
{
	public static  String CaptureScreenShot(WebDriver driver)
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String ScreenshotPath= System.getProperty("user.dir")+"/screenshots/EsignGenie" +getcurrentDateTimeforScreenshot()+".png";
		try
		{
			FileHandler.copy(src, new File(ScreenshotPath));
		}
		catch(Exception e)
		{
			System.out.println("Unable to capture Screenshot" +e.getMessage());
		}
		return ScreenshotPath;

	}

	public void getScreenShot(WebDriver driver, String filename) 
	{
		EventFiringWebDriver efw = new EventFiringWebDriver(driver);

		try {
			String ScreenshotPath= System.getProperty("user.dir")+"/screenshots/EsignGenie" +getcurrentDateTimeforScreenshot();
			File file = new File(".//screenshot"+filename+".png");
			FileUtils.copyFile(efw.getScreenshotAs(OutputType.FILE), file);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static String getcurrentDateTime()
	{
		//DateFormat customformat=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		DateFormat customformat=new SimpleDateFormat("dd_MM_yyyy");
		Date currentDate= new Date();
		return customformat.format(currentDate);
	}
	
	public static String getcurrentDateTimeforScreenshot()
	{
		DateFormat customformat=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		//DateFormat customformat=new SimpleDateFormat("dd_MM_yyyy");
		Date currentDate= new Date();
		return customformat.format(currentDate);
	}
}
