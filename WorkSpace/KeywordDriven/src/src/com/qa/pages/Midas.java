package com.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Midas {
	
	public static WebDriver driver ;
	
	public static void switchToNewWindow(int windowNumber) {
	    Set < String > s = driver.getWindowHandles();   
	    Iterator < String > ite = s.iterator();
	    int i = 1;
	    while (ite.hasNext() && i < 10) {
	        String popupHandle = ite.next().toString();
	        driver.switchTo().window(popupHandle);
	        System.out.println("Window title is : "+driver.getTitle());
	        int windowCount = 0;
			if (i == windowCount) break;
	        i++;
	    }
	}
	

	public static void main(String[] args) throws InterruptedException, AWTException {
   
	
		
		System.setProperty("webdriver.ie.driver", "C:\\Users\\jaspal-singh\\Desktop\\Cucumber Jars\\CucumberJars-master\\IE32\\IEDriverServer.exe");
		
		 driver = new InternetExplorerDriver();
		
		driver.get("http://midasworkflowsys.mercer.com/CI/Inbox.aspx");
				
				
		WebElement ele1 = driver.findElement(By.cssSelector("div#MainContent_NavMainContent_InboxControl_schemeProcessing_CD"));

		ele1.click();
		
		switchToNewWindow(1);
			
		  
		}
		
		
	
	
}
