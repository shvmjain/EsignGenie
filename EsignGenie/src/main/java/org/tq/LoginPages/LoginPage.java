package org.tq.LoginPages;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.tq.EsignGenie.BaseClass;


public class LoginPage extends BaseClass

{
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	 @FindBy(xpath="//*[@id=\'menu-business-menu\']/li[7]/a") private WebElement enterLoginButton;
	 @FindBy(xpath="//*[@id=\'login_party_emailId\']") private WebElement enterUserName;
	 @FindBy(xpath="//*[@id=\'login_party_loginPassword\']") private WebElement enterPassword;
	 @FindBy(xpath="//*[@id=\'submit\']") private WebElement clickOnLogin;
	 @FindBy(xpath="//span[@class='pull-left']/a") private WebElement clickOnForgotPassword;
	 @FindBy(xpath="//input[@id='sendResetPassword_party_emailId']") private WebElement enterEmailId;
	 @FindBy(xpath="//form[@id='sendResetPassword']/input[@id='submit']") private WebElement clickOnSubmitButton;
	
	 public void Loginaccount() throws Exception
	 {
		 enterLoginButton.click();
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 enterUserName.sendKeys("shvmjain@gmail.com");
		 enterPassword.sendKeys("Shivam");
		 clickOnLogin.click(); 
		 Thread.sleep(3000);
		 //String title=driver.getTitle();
		// System.out.println(title);
	 }
	 
	 public void VerifyTitle() throws InterruptedException
	 {
		 Thread.sleep(2000);
		 String title=driver.getTitle();
		 System.out.println(title);
		 Assert.assertEquals(title,"Home eSignGenie", "Title Verified");
		 
	 }
	 
	 public void forgotPassword() throws InterruptedException
	 {
		 Thread.sleep(2000);
		 enterLoginButton.click();
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 clickOnForgotPassword.click();
		 enterEmailId.sendKeys("sjain@accountsight.com");
		 clickOnSubmitButton.click();
		 Thread.sleep(1000);
	 }
	 
	 
	
	
	
	
	
	
	
	
		
		
		
		
}
