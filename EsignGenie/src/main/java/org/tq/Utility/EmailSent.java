package org.tq.Utility;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.tq.EsignGenie.BaseClass;


public class EmailSent extends BaseClass
{
	
	public static void emailSentAfterSuccessfullTestCaseExecution() throws Exception
	{
		System.out.println("==========Email Started==========");
		EmailAttachment attachment=new EmailAttachment();
		attachment.setPath("E:\\Hybrid framwork\\EsignGenie\\ExtentReports\\EsignGenie"+Helper.getcurrentDateTime()+".html");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("Test Report");
		attachment.setName("Test Execution Report");
		MultiPartEmail email= new MultiPartEmail();
		//Email email = new SimpleEmail();
		//email.setHostName("smtp.googlemail.com");
		email.setHostName("mail.esigngenie.com");
		email.setSmtpPort(465);
		//email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator("sjain@esigngenie.com", "$j@!nbpB>8F"));
		email.setSSLOnConnect(true);
		email.setFrom("sjain@esigngenie.com");
		email.setSubject("Test Execution Report Mail");
		email.setMsg("Dear Sir,\n\nAll Test case has been executed successfully. Please find attached Test Report with this mail \n\n\n\nThanks & Regards\nShivam Jain");
		//email.addTo("dsingh@accountsight.com");
		//email.addTo("mbist@accountsight.com");
		email.addTo("sjain@accountsight.com");
		email.addCc("sjain@esigngenie.com");
		email.attach(attachment);
		email.send();
		System.out.println("==========Email Ended==========");
	}

}
