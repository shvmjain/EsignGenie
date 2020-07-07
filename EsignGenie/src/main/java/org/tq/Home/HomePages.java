package org.tq.Home;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tq.EsignGenie.BaseClass;
import org.tq.Utility.GetProperty;

public class HomePages extends BaseClass
{
	WebElement ele;

	public HomePages(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@id=\"docFileUpload\"]") private WebElement clickOnUploadNewDocument;
	@FindBy(xpath="//button[@id='addMeBtn']") private WebElement clickOnAddMeButton;
	@FindBy(xpath="//*[@id=\"addNewPartyBtn\"]") private WebElement clickOnAddNewPartyButton;
	@FindBy(xpath="//*[@id=\"nwpfname\"]") private WebElement enterFirstName;
	@FindBy(xpath="//*[@id=\"nwplname\"]") private WebElement enterLastName;
	@FindBy(xpath="//*[@id=\"nwpemid\"]") private WebElement enterEmailId;
	@FindBy(xpath="//*[@id=\"newPartyDiv\"]/div[4]/div[1]/div/button") private WebElement clickOnPhoneDropDownList;
	@FindBy(xpath="//*[@id=\"newPartyDiv\"]/div[4]/div[1]/div/button") private WebElement enterCountryNameInTextBox;
	@FindBy(xpath="//*[@id=\"newPartyDiv\"]/div[4]/div[1]/div/div/ul/li[103]/a/span") private WebElement clickOnCountryCode;
	@FindBy(xpath="//*[@id=\"mobile-number\"]") private WebElement enterMobNo;
	@FindBy(xpath="//*[@id=\"newPartyBtn\"]") private WebElement clickOnAddButton;
	@FindBy(xpath="//a[@id='savebtn']") private WebElement clickOnSaveButton;
	@FindBy(xpath="//div[@class='drag-initialfield']") private WebElement clickOnInitialField;
	@FindBy(xpath="//*[@placeholder='Signer Name']") private WebElement clickOnSignerName;
	@FindBy(xpath="//*[@placeholder='Signer Email']") private WebElement clickOnSignerEmail;
	@FindBy(xpath="//select[@id='partyList']") private WebElement clickOnPartyResponsible;
	@FindBy(xpath="//a[@id='sendbtn']") private WebElement clickOnSendButton;
	@FindBy(xpath="//div[@class='party-entry party-selected']/div[@class='media-body']/SELECT[1]") private WebElement clickOnPartyPermission;
	@FindBy(xpath="//select[@id='authenticationLevel']") private WebElement clickOnAuthenticationLevel;
	@FindBy(xpath="//label[@class='switch-input']/i") private WebElement clickOnEnforceSigningSequence;
	@FindBy(xpath="//div[@id='addDocli']/a[@id='addDoc']") private WebElement clickOnAddNewDocument;
	@FindBy(xpath="//span[@id='folderName']") private WebElement clickOnRenameFolder;
	@FindBy(xpath="//input[@class='form-control input-sm']") private WebElement enterTextOfFolder;
	@FindBy(xpath="//i[@class='glyphicon glyphicon-ok']") private WebElement clickOnOKButton;
	@FindBy(xpath="//input[@id='docFileUpload']") private WebElement clickOnUploadDocumentFromAddMoreDocument;
	//	@FindBy(xpath="//button[@id='resendinvite']") private WebElement clickOnFinalSendButton;
	@FindBy(xpath="//div[@class='fr']/button[@id='resendinvite']") private WebElement clickOnFinalSendButton;



	public void uploadPDF() throws InterruptedException
	{
		//Thread.sleep(1000);
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\'docFileUpload\']")));
		//clickOnUploadNewDocument.sendKeys("C:\\Users\\shivu\\Downloads\\Shivam_Jain.pdf");
		clickOnUploadNewDocument.sendKeys("E:\\Hybrid framwork\\EsignGenie\\EsignGenie.pdf");
		Thread.sleep(3000);

	}

	public void addNewParty() throws InterruptedException
	{
		Thread.sleep(2000);
		clickOnAddNewPartyButton.click();
		enterFirstName.sendKeys("Ankur");
		enterLastName.sendKeys("Jain");
		enterEmailId.sendKeys("sjain@accountsight.com");
		clickOnPhoneDropDownList.click();
		enterCountryNameInTextBox.sendKeys("India (+91)");
		clickOnCountryCode.click();
		enterMobNo.sendKeys("7568256824");
		clickOnAddButton.click();
		Thread.sleep(3000);
	}

	public void addMe() throws InterruptedException
	{
		Thread.sleep(1000);
		clickOnAddMeButton.click();
		ele=clickOnPartyPermission;
		Select slct=new Select(ele);
		slct.selectByIndex(1);
		Thread.sleep(1000);
	}

	public void dragAndDropSignatureField() throws InterruptedException
	{

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions act= new Actions(driver); 
		List <WebElement> sidemenu=driver.findElements(By.xpath("//*[@id='collapseOne']/a"));
		int x=sidemenu.size();
		String datacid=js.executeScript("return document.getElementsByClassName('doc-content-img-wrap dropTarget')[0].getAttribute('data-cid')").toString();
		WebElement docImg=driver.findElement(By.id("doc" +datacid+ "_page1_img"));
		for(int i=0; i<x; i++)
		{
			//String subStrBool=js.executeScript("return document.getElementById('collapseOne').getElementsByTagName('a')["+ i +"].draggable").toString();
			act.clickAndHold(sidemenu.get(i)).moveToElement(docImg, (-200), (i*40)).release().build().perform();		
			Thread.sleep(1000);
		}
	}

	public void saveDocument() throws InterruptedException
	{
		clickOnSaveButton.click();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}


	public void dragAndDropDataField() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions act= new Actions(driver); 
		List <WebElement> sidemenu=driver.findElements(By.xpath("//*[@id='collapseTwo']/a"));
		int x=sidemenu.size();
		String datacid=js.executeScript("return document.getElementsByClassName('doc-content-img-wrap dropTarget')[0].getAttribute('data-cid')").toString();
		WebElement docImg=driver.findElement(By.id("doc" +datacid+ "_page1_img"));
		for(int i=0; i<x; i++)
		{
			if(i!=1)
			{
				//String subStrBool=js.executeScript("return document.getElementById('collapseOne').getElementsByTagName('a')["+ i +"].draggable").toString();
				act.clickAndHold(sidemenu.get(i)).moveToElement(docImg, (276), (i*40)).release().build().perform();		
				Thread.sleep(1000);
			}
			else 
			{
				System.out.println("Ignore");
			}
		}

	}

	public void updatePropertyOfInitialField() throws InterruptedException
	{
		Thread.sleep(2000);
		clickOnInitialField.click();
		Thread.sleep(2000);
		ele=clickOnPartyResponsible;
		Select slct= new Select(ele);
		slct.selectByIndex(1);
		Thread.sleep(2000);
	}

	public void updatePropertyOfSignerName() throws InterruptedException
	{
		Thread.sleep(2000);
		clickOnSignerEmail.click();
		ele=clickOnPartyResponsible;
		Select slct= new Select(ele);
		slct.selectByIndex(1);
	}

	public void updatePropertyOfSignerEmail() throws InterruptedException
	{
		Thread.sleep(2000);
		clickOnSignerName.click();
		ele=clickOnPartyResponsible;
		Select slct= new Select(ele);
		slct.selectByIndex(1);
	}

	public void sendDocument() throws InterruptedException
	{
		Thread.sleep(3000);
		//WebDriverWait wait= new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='sendbtn']")));
		clickOnSendButton.click();
		//	WebDriverWait wait= new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='resendinvite']")));
		Thread.sleep(5000);
		boolean b= clickOnFinalSendButton.isEnabled();
		System.out.println("Enabled" +b);
		boolean c= clickOnFinalSendButton.isDisplayed();
		System.out.println("Displayed" +c);
		boolean d= clickOnFinalSendButton.isSelected();
		System.out.println("Selected" +d);
		clickOnFinalSendButton.click();
		Thread.sleep(5000);

	}



































	//		JavascriptExecutor js = (JavascriptExecutor) driver;
	//		Actions act= new Actions(driver); 
	//		List <WebElement> sidemenu=driver.findElements(By.xpath("//*[@id='collapseOne']/a"));
	//		int x=sidemenu.size();
	//		//System.out.println("Length:" +x);
	//		String datacid=js.executeScript("return document.getElementsByClassName('doc-content-img-wrap dropTarget')[0].getAttribute('data-cid')").toString();
	//		//System.out.println("data cid :" +datacid);
	//		WebElement docImg=driver.findElement(By.id("doc" +datacid+ "_page1_img"));
	//		for(int i=0; i<x; i++)
	//		{
	//			String subStrBool=js.executeScript("return document.getElementById('collapseOne').getElementsByTagName('a')["+ i +"].draggable").toString();
	//			boolean subbool=Boolean.parseBoolean(subStrBool);
	//			//System.out.println(subbool);
	//			if(subbool==true)
	//			{
	//				String name=sidemenu.get(i).getText();
	//				//System.out.println("Signature field" +name);
	//				act.clickAndHold(sidemenu.get(i)).moveToElement(docImg, (5), (i*40)).release().build().perform();
	//				Thread.sleep(1000);
	//			}
	//		}





}
