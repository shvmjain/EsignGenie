package org.tq.LoginPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tq.EsignGenie.BaseClass;

public class LogoutPages extends BaseClass
{
	
	public LogoutPages(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//@FindBy(xpath="//i[@class='fa fa-bars fa-1x']") private WebElement clickOnMenuIcon;
	@FindBy(xpath="	/html/body/nav/div/div[1]/a") private WebElement clickOnMenuIcon;
	@FindBy(xpath="//a[contains(text(), 'Logout')]") private WebElement clickOnLogout;
	@FindBy(xpath="//div[@class='uname']") private WebElement clickOnDropdown;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']/li[2]/a") private WebElement clickOnlogoutApplication;
	
	public void logOut() throws InterruptedException
	{
		Thread.sleep(2000);
		clickOnMenuIcon.click();
		Thread.sleep(2000);
		clickOnLogout.click();
		Thread.sleep(2000);
	}
	
	public void logOutfromHomePage() throws InterruptedException
	{
		clickOnDropdown.click();
		clickOnlogoutApplication.click();
		Thread.sleep(2000);
	}
	

}
