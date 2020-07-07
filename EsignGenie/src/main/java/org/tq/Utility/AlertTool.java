package org.tq.Utility;

import org.openqa.selenium.NoAlertPresentException;
import org.tq.EsignGenie.BaseClass;

public class AlertTool extends BaseClass
{
	public AlertTool() {
		super(); 
	}
	

	public static boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException ex) {
			ex.getSuppressed();
			return false;
		}
		
	}

}
