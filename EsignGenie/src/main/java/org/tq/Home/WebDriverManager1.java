package org.tq.Home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManager1 {

	static WebDriver driver;
	public static void main(String[] args) 
	{
		WebDriverManager.iedriver().setup();
		driver= new InternetExplorerDriver();
		driver.get("https://esigngenie.com");

	}

}
