package org.tq.Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory 
{
@Parameters("browser")	
public static WebDriver startApplication(WebDriver driver, String browserName, String Url)
{
	if (browserName.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
	}
	
	else if (browserName.equalsIgnoreCase("Firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
	}
	
	else if (browserName.equalsIgnoreCase("IE"))
	{
		WebDriverManager.iedriver().setup();
		driver= new InternetExplorerDriver();
		
	}
	else
	{
		System.out.println("Browser is not supported");
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.get(Url);
	return driver;
}

public static void quitDriver(WebDriver driver)
{
	driver.quit();
}
}
