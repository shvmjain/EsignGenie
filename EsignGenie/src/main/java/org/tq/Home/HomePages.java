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
import org.tq.LoginPages.LogoutPages;

public class HomePages extends BaseClass
{
	WebElement ele;

	public HomePages(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public void uploadPDF() throws InterruptedException
	{
		//Thread.sleep(1000);
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\'docFileUpload\']")));
		//clickOnUploadNewDocument.sendKeys("C:\\Users\\shivu\\Downloads\\Shivam_Jain.pdf");
		clickOnUploadNewDocument.sendKeys("C:\\Users\\shivu\\git\\EsignGenie\\EsignGenie\\Document\\EsignGenie.pdf");
		//clickOnUploadNewDocument.sendKeys("./Document/EsignGenie.pdf");
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
	
	public void updatePropertyOfSign() throws InterruptedException
	{
		Thread.sleep(2000);
		clickOnSign.click();
		Thread.sleep(2000);
		ele=clickOnPartyResponsible;
		Select slct= new Select(ele);
		slct.selectByIndex(1);
		Thread.sleep(2000);
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
		clickOnSendButton.click();
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

	public void documentWaitingForMySignature() throws InterruptedException
	{
		Thread.sleep(2000);
		WebElement ele = clickOnDocumentsWaitingforMySignature;
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		clickOnPdfDocumentForm.click();
		clickOnInitialFieldTextBox.click();
		Thread.sleep(2000);
		clickOnInitialImage.click();
		clickOnInitialButton.click();
		clickOnFinishButton.click();
		checkOnConfirmSignature.click();
		checkOnConfirmButton.click();
		Thread.sleep(2000);
		clickOnOkButton.click();
	}

	public void documentWaitingForOtherSignature() throws InterruptedException
	{
		Thread.sleep(2000);
		WebElement ele = clickOnDocumentsWaitingforOtherSignature;
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		clickOnPdfDocumentForm.click();
		clickOnSignatureFieldFromDocumentWaitingForOtherSignature.click();
		Thread.sleep(2000);
		clickOnSignatureImage.click();
		clickOnSignButton.click();
		clickOnFinishButton.click();
		checkOnConfirmSignature.click();
		checkOnConfirmButton.click();
		clickOnOkButton.click();

	}

	public void continueFromTheDraft() throws InterruptedException
	{
		Thread.sleep(2000);
		WebElement ele = clickOnContinousFromDraft;
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		clickOnPdfDocumentForm.click();
		sendDocument();
		
	}

	public void completedDocuments() throws InterruptedException
	{
		Thread.sleep(2000);
		WebElement ele = clickOnCompletedDocuments;
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		clickOnPdfDocumentForm.click();
		
	}
	
	public void saveDocumentInDraft() throws InterruptedException
	{
		uploadPDF();
		addMe();
	//	addNewParty();
		dragAndDropSignatureField();
		updatePropertyOfSignerEmail();
		saveDocument();
		LogoutPages logout= new LogoutPages(driver);
		logout.logOut();
	}


	@FindBy(xpath="//*[@id=\"docFileUpload\"]")
	private WebElement clickOnUploadNewDocument;

	@FindBy(xpath="//button[@id='addMeBtn']") 
	private WebElement clickOnAddMeButton;

	@FindBy(xpath="//*[@id=\"addNewPartyBtn\"]")
	private WebElement clickOnAddNewPartyButton;

	@FindBy(xpath="//*[@id=\"nwpfname\"]") 
	private WebElement enterFirstName;

	@FindBy(xpath="//*[@id=\"nwplname\"]")
	private WebElement enterLastName;

	@FindBy(xpath="//*[@id=\"nwpemid\"]")
	private WebElement enterEmailId;

	@FindBy(xpath="//span[@class='filter-option pull-left']")
	private WebElement clickOnPhoneDropDownList;

	@FindBy(xpath="//input[@class='input-block-level form-control']")
	private WebElement enterCountryNameInTextBox;

	@FindBy(xpath="//*[@id=\"newPartyDiv\"]/div[5]/div[1]/div/div/ul/li[103]/a/span")
	private WebElement clickOnCountryCode;

	@FindBy(xpath="//*[@id=\"mobile-number\"]")
	private WebElement enterMobNo;

	@FindBy(xpath="//*[@id=\"newPartyBtn\"]") 
	private WebElement clickOnAddButton;

	@FindBy(xpath="//a[@id='savebtn']")
	private WebElement clickOnSaveButton;
	
	@FindBy(xpath="//div[@class='drag-signfield']") 
	private WebElement clickOnSign;
	

	@FindBy(xpath="//div[@class='drag-initialfield']") 
	private WebElement clickOnInitialField;

	@FindBy(xpath="//*[@placeholder='Signer Name']") 
	private WebElement clickOnSignerName;

	@FindBy(xpath="//*[@placeholder='Signer Email']") 
	private WebElement clickOnSignerEmail;

	@FindBy(xpath="//select[@id='partyList']") 
	private WebElement clickOnPartyResponsible;

	@FindBy(xpath="//a[@id='sendbtn']") 
	private WebElement clickOnSendButton;

	@FindBy(xpath="//div[@class='party-entry party-selected']/div[@class='media-body']/SELECT[1]") 
	private WebElement clickOnPartyPermission;

	@FindBy(xpath="//select[@id='authenticationLevel']")
	private WebElement clickOnAuthenticationLevel;

	@FindBy(xpath="//label[@class='switch-input']/i") 
	private WebElement clickOnEnforceSigningSequence;

	@FindBy(xpath="//div[@id='addDocli']/a[@id='addDoc']") 
	private WebElement clickOnAddNewDocument;

	@FindBy(xpath="//span[@id='folderName']") 
	private WebElement clickOnRenameFolder;

	@FindBy(xpath="//input[@class='form-control input-sm']") 
	private WebElement enterTextOfFolder;

	@FindBy(xpath="//i[@class='glyphicon glyphicon-ok']")
	private WebElement clickOnOKButton;

	@FindBy(xpath="//input[@id='docFileUpload']")
	private WebElement clickOnUploadDocumentFromAddMoreDocument;

	@FindBy(xpath="//div[@class='fr']/button[@id='resendinvite']") 
	private WebElement clickOnFinalSendButton;

	@FindBy(xpath="//li[@class='animated fadeInDown'][1]/a") 
	private WebElement clickOnDocumentsWaitingforMySignature;

	@FindBy(xpath="//li[@class='animated fadeInDown'][2]/a") 
	private WebElement clickOnDocumentsWaitingforOtherSignature;

	@FindBy(xpath="//li[@class='animated fadeInDown'][3]/a") 
	private WebElement clickOnContinousFromDraft;

	@FindBy(xpath="//li[@class='animated fadeInDown'][4]/a") 
	private WebElement clickOnCompletedDocuments;

	@FindBy(xpath="//div[@class='list-group']/div[@class='list-group-item'][1]/div[@class='row']/div[@class='col-sm-4 fittext']/span/a") 
	private WebElement clickOnPdfDocumentForm;

	@FindBy(xpath="//*[@class='drag-initialfield ttbottom']") 
	private WebElement clickOnInitialFieldTextBox;

	@FindBy(xpath="//div[@id='style1']/canvas[@id='type_canvas1']") 
	private WebElement clickOnInitialImage;

	@FindBy(xpath="//*[@class='btn btn-primary zoom-block pull-right']") 
	private WebElement clickOnInitialButton;

	@FindBy(xpath="//button[@id='rightFinishBtn']") 
	private WebElement clickOnFinishButton;

	@FindBy(xpath="//div[@class='checkbox']/label") 
	private WebElement checkOnConfirmSignature;

	@FindBy(xpath="//button[@id='btn-1']") 
	private WebElement checkOnConfirmButton;

	@FindBy(xpath="//div[@class='drag-signfield ttbottom']") 
	private WebElement clickOnSignatureFieldFromDocumentWaitingForMySignature;
	
	@FindBy(xpath="//div[@class='drag-signfield ttbottom ']") 
	private WebElement clickOnSignatureFieldFromDocumentWaitingForOtherSignature;
	
	@FindBy(xpath="//canvas[@id='type_canvas1']") 
	private WebElement clickOnSignatureImage;
	
	@FindBy(xpath="//*[@class='btn btn-primary zoom-block pull-right']") 
	private WebElement clickOnSignButton;

	@FindBy(xpath="//*[@class=\"btn btn-success-outline\"]") 
	private WebElement clickOnOkButton;

	@FindBy(xpath="//span[@class='far fa-download']") 
	private WebElement clickOnDownloadFileFromDraft;

	//div[@class='drag-signfield']

	//div[1]/div[1]/div[@class='drag-signfield']
	//*[@id="fid_164574227"]

}
