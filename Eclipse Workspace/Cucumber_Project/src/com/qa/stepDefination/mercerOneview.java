package com.qa.stepDefination;

import static org.junit.Assert.fail;

import java.util.List;
import com.qa.utils.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.utils.ExcelUtility;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import junit.framework.Assert;
import org.junit.*;
import org.apache.commons.exec.ExecuteException;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

//@FixMethodOrder(MethodSorters.DEFAULT)


public class mercerOneview {
	
	public static WebDriver driver  ;
	public static  WebDriverWait wait  ;
	public static  JavascriptExecutor executor ;
	final static Logger logger = Logger.getLogger(Step1.class);
	ExcelUtility ex = new ExcelUtility();
	propReader pr = new propReader();

	
	//@Test
	@Given("^Url is launched$")
	public void Test1() throws Throwable
	{
		try
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jaspal-singh\\Desktop\\Selenium Library\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(pr.Url());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		catch (Exception e)
		{
			closeBrowser();		
			fail(e.getMessage());
			}
		

	}

	//@Test
	@When("^User enters username and password$")
	public void Test2() throws Throwable
	{
		
		try
		{
		String username = ex.getData(1, 0);
		String password = ex.getData(1, 1);
		driver.findElement(By.cssSelector(pr.cssLoginUsername())).sendKeys(username);
        driver.findElement(By.cssSelector(pr.cssLoginPassword())).sendKeys(password);
        Thread.sleep(2000);
		}
		catch (Exception e)
		{
			closeBrowser();		
			fail(e.getMessage());
			}
		
		

	}

	//@Test
	@Then("^Click on login button$")
	public void Test3() throws Throwable
	{
		try
		{
			try {
		driver.findElement(By.cssSelector(pr.cssloginButton())).click();
			}catch(Exception e)
			{
				closeBrowser();		
				fail(e.getMessage());
				
			}
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		WebElement ele = wait1
				.ignoring(Exception.class)
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(pr.cssPageText1())));
		}
		catch (Exception e)
		{
			closeBrowser();		
			fail(e.getMessage());	
			
		}
		
		
	}

	//@Test
	@Then("^User navigates to next and click on view details$")
	public void Test4() throws Throwable,StaleElementReferenceException
	{
		try
		{

		//WebDriverWait wait1 = new WebDriverWait(driver, 10);
		//WebElement ele = wait1
				//.ignoring(Exception.class)
				//.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(pr.cssPageText1())));
		//String text = ele.getText();
      //  System.out.println(text);
        List<WebElement> rows = driver.findElements(By.cssSelector(pr.cssViewDetails()));
        //System.out.println(rows.size());
        try
        { 
        	for(int i=1; i<=rows.size();i++)
        	{
        		//System.out.println(rows.get(i));
        		Thread.sleep(2000);
        		executor = (JavascriptExecutor)driver;
        		executor.executeScript("arguments[0].click();", rows.get(2));
			
        	}
        }
        catch (StaleElementReferenceException e) {
		}
		Thread.sleep(1000);
		WebDriverWait wait2 = new WebDriverWait(driver, 80);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(pr.cssContactDetails())));

		}
		catch (Exception e)
		{
			closeBrowser();		
			fail(e.getMessage());
			}
		

        }

	//@Test
	@Then("^again click on contact details to update information$")
	public void Test5() throws Throwable
	{
		try
		{
		//WebDriverWait wait2 = new WebDriverWait(driver, 80);
		//wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(pr.cssContactDetails())));
			try
			{
		WebElement element2 = driver.findElement(By.cssSelector(pr.cssContactDetails()));
		element2.click();
			}
			catch(Exception e)
			{
				closeBrowser();		
				fail(e.getMessage());	}
		//Thread.sleep(2000);
		WebDriverWait wait3 = new WebDriverWait(driver, 10);
		 wait3.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(pr.cssEditButton())));

		}
		catch (Exception e)
		{
			closeBrowser();		
			fail(e.getMessage());
			}
		

	}

	//@Test
	@Then("^click on Edit button$")
	public void Test6() throws Throwable
	{
		try
		{
		
		 //WebDriverWait wait3 = new WebDriverWait(driver, 10);
		// wait3.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(pr.cssEditButton())));
		 WebElement element3 = driver.findElement(By.cssSelector(pr.cssEditButton()));
		 element3.click();
		 WebDriverWait wait4 = new WebDriverWait(driver, 20);
		 wait4.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(pr.cssEditInput())));
		}
		catch (Exception e)
		{
			closeBrowser();		
			fail(e.getMessage());
			}
		

	}

	//@Test
	@And("^update information$")
	public void Test7() throws Throwable
	{
		try
		{
		//WebDriverWait wait4 = new WebDriverWait(driver, 5);
		//wait4.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(pr.cssEditInput())));
		WebElement element4 = driver.findElement(By.cssSelector(pr.cssEditInput()));
		element4.clear();
		element4.click();
		
		String address = ex.getData(1, 2);
		element4.sendKeys(address);
		Thread.sleep(2000);
		}
		catch (Exception e)
		{
			closeBrowser();		
			fail(e.getMessage());
			}
		
			
	}

	//@Test
	@Then("^click on Save button$")
	public void Test8() throws Throwable
	{
		try
		{
			
		WebElement element5 = driver.findElement(By.cssSelector(pr.cssSaveButton()));
		executor.executeScript("arguments[0].click();", element5);
		}
		catch (Exception e)
		{
			closeBrowser();		
			fail(e.getMessage());

		}
			
		wait = new WebDriverWait(driver, 10);
		WebElement element6 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(pr.cssSuccessMessage())));
		//String message = element6.getText();
		//System.out.println(message);
		//String ExpectedMessage = "You have successfully submitted your message";
		//Assert.assertEquals(ExpectedMessage, message);
		
		

	}

	//@Test
	@And("^click to select logout button$")
	public void Test9() throws Throwable
	{
		//try
	//	{
		//wait = new WebDriverWait(driver, 10);
		//WebElement element6 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(pr.cssSuccessMessage())));
		//String message = element6.getText();
		//System.out.println(message);
		//String ExpectedMessage = "You have successfully submitted your message";
		//Assert.assertEquals(ExpectedMessage, message);
			try
			{
		WebElement element7 = driver.findElement(By.cssSelector(pr.cssBWOption()));
		executor.executeScript("arguments[0].click();", element7);
		Thread.sleep(2000);
			} catch (Exception e )
			{
				closeBrowser();		
				fail(e.getMessage());		}
			
			try
			{
		WebElement element8 = driver.findElement(By.xpath(pr.xpathLogoutLink()));
		executor.executeScript("arguments[0].click();", element8);
		Thread.sleep(2000);
			} catch (Exception e)
			{
				closeBrowser();		
				fail(e.getMessage());			}
			
			try
			{
		WebElement element9 = driver.findElement(By.cssSelector(pr.CssLogoutAlertButton()));
		executor.executeScript("arguments[0].click();", element9);
			}
			catch(Exception e)
			{
				closeBrowser();		
				fail(e.getMessage());
			}
		
	//	}
		///catch (Exception e)
		//{
		//	driver.close();
	//	}
		

		
	}

	//@Test
	@Then("^user will be logged out successfully$")
	public void Test10() throws Throwable
	{
		try
		{
		Thread.sleep(2000);
		System.out.println("Logged out Successfully");
		
		}
		catch (Exception e)
		{
			closeBrowser();		
			fail(e.getMessage());	}
		

	}

	public static void closeBrowser() throws Exception{
	    
		  if (driver == null) {
		        return;
		    }
		  driver.quit();
	}
	


}