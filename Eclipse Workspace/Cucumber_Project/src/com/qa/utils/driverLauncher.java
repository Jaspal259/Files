package com.qa.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class driverLauncher  {
	
	public static WebDriver driver;

	
	public static void browserLauncher()
	{
	
	//propReader rd =new propReader();

		
	if(propReader.getBrowser().equalsIgnoreCase("ie"))
	{
		System.setProperty("webdriver.ie.driver", propReader.getDriver());
	}
	else if(propReader.getBrowser().equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.ie.driver", propReader.getDriver());
	}
	else
	{
		System.setProperty("webdriver.ie.driver", propReader.getDriver());
	}
		
	 driver = new InternetExplorerDriver();
	 driver.manage().deleteAllCookies();
	
	
}
}
