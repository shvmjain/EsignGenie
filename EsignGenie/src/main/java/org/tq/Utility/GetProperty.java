package org.tq.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class GetProperty
{
	Properties pro;
	public  GetProperty()
	{
		File src=  new File("./Config/config.properties");
		try
		{
			FileInputStream fis = new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
					
		}
		catch(Exception e)
		{
			System.out.println("Waitable to load config file" +e.getMessage());
		}
		
	}
	public String getBrowser()
	{
		return pro.getProperty("Browser");
		
	}
	public String getUrl()
	{
		return pro.getProperty("Url");
		
	}
	
	
	

}
