package com.qa.stepDefination;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import javax.servlet.annotation.WebListener;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.utils.propReader;

import junit.framework.Assert;

public class Mercer {

	public static void main(String[] args) throws InterruptedException,StaleElementReferenceException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jaspal-singh\\Desktop\\Selenium Library\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	             driver.manage().deleteAllCookies();
	             driver.manage().window().maximize();
	             
	             
	             driver.get("https://v218-dal-qa-merceros.mercer.com:10492/ovtdemo/login");
	             driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		         driver.findElement(By.cssSelector("input#userIdInput")).sendKeys("mercerdemo");
		         driver.findElement(By.cssSelector("input#passcodeInput")).sendKeys("Oneview2019*");
		         
		         Thread.sleep(2000);
		         driver.findElement(By.cssSelector("button#LogInBtn")).click();
		         
		         WebDriverWait wait = new WebDriverWait(driver, 70);
		         
		 		  WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id$='TypeLabel'][class='mos-o-subheader-4 mos-u-spacer--margin-bottom-none mos-u-text-size--md header-color--db']")));
		 		
                   //WebElement ele = driver.findElement(By.cssSelector("div[id$='TypeLabel'][class='mos-o-subheader-4 mos-u-spacer--margin-bottom-none mos-u-text-size--md header-color--db']"));
		         
		         String text = ele.getText();
		         System.out.println(text); 
		 		// if element found then we will use- In this example I just called isDisplayed method
         if(ele.isDisplayed())		  
		 		// if else condition
		 	 {
		 			System.out.println("Proceed...............");
		 			
		 			//WebElement tag = driver.findElement(By.tagName("a"));
		 			
		 			List<WebElement> rows = driver.findElements(By.cssSelector("a[id$='DetailsButton'][class='mos-t-button--primary-alt mos-c-button mos-c-button--md']"));
		 			
		 			System.out.println(rows.size());
		 			/*
		 			for(WebElement r :rows)
		 			{
		 				System.out.println(r);
		 				
		 			}
		 			*/
		 			
		 			for(int i=1; i<=rows.size();i++)
		 			{
		 				
		 				System.out.println(rows.get(i));
		 				
		 				Thread.sleep(2000);
		 				
		 				
		 				JavascriptExecutor executor = (JavascriptExecutor)driver;
		 				executor.executeScript("arguments[0].click();", rows.get(2));
		 				
		 				//  rows.get(3).click();

		 						 			
		 				WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[id$='contact_detailsLink']")));
		 				
		 				 				
		 				element2.click();
		 				
		 				WebElement element3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button#contactDetailsEditButton")));
		 						
		 				element3.click();		
		 				
		 				//visibilityOfElementLocated(By.cssSelector("button#contactDetailsEditButton]")));

		 			
		 				WebElement element4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#addressLine5Input")));
		 				element4.clear();
		 				element4.sendKeys("Test");
		 				
		 				
		 				WebElement element5 = driver.findElement(By.cssSelector("button#saveButton"));
		 				executor.executeScript("arguments[0].click();", element5);

		 				
		 				
		 				WebElement element6 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='ng-tns-c7-17 column mos-c-toast__content mos-c-toast__content-close']/toaster-template/p")));
		 				
		 				
		 						
		 						
		 						
		 						//driver.findElement(By.xpath("//div[@class='ng-tns-c7-17 column mos-c-toast__content mos-c-toast__content-close']/toaster-template/p"));
		 				String   message = element6.getText();
		 				
		 				
		 				
		 				System.out.println(message);
		 				
		 				String ExpectedMessage = "You have successfully submitted your message";
		 				
		 				Assert.assertEquals(ExpectedMessage, message);
		 				
		 				
		 				
		 				WebElement element7 = driver.findElement(By.cssSelector("div[class='mos-c-circle--lg mos-t-circle--primary-alt']"));
		 				executor.executeScript("arguments[0].click();", element7);

		 				
		 				
		 				WebElement element8 = driver.findElement(By.xpath("//ul[@class='mos-c-dropdown__list']/li/a[@id='LogoutLink']"));
		 				executor.executeScript("arguments[0].click();", element8);

		 				
		 				WebElement element9 = driver.findElement(By.cssSelector("button#logoutButton"));
		 				executor.executeScript("arguments[0].click();", element9);
		 					 			
		 				
		 		                	}
		 		
		 	 	 	 
		 	          } 
              else {
		 			System.out.println("try again");
		 	     	}
         	driver.close();
		         
	}}   
   
		         
		         

		         
		
		
		
	

	
