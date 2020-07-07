package org.tq.Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author shivu
 *
 */


public class WaitStatementsLib 
{
	public static void waitForSecond(WebDriver driver, long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public static void waitForMinute(WebDriver driver, long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.MINUTES);
	}
	
	public static void elementToBeVisisble(WebDriver driver, long time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void elementToBeClickable(WebDriver driver, int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void elementToBeSelectable(WebDriver driver, int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
	public static void waitForURL(WebDriver driver, int time, String url) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.urlToBe(url));
	}
	
	public static void stalnessOfElement(WebDriver driver, int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.stalenessOf(element));
	}
	
	public static void AlertToBePresent(WebDriver driver, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	
	public static void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
