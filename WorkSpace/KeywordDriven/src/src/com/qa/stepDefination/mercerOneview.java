package com.qa.stepDefination;

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
import junit.framework.Assert;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

//@FixMethodOrder(MethodSorters.DEFAULT)


public class mercerOneview {
	
	public static WebDriver driver ;
	public static  WebDriverWait wait ;
	public static  JavascriptExecutor executor ;
	final static Logger logger = Logger.getLogger(Step1.class);
	ExcelUtility ex = new ExcelUtility();
	propReader pr = new propReader();

	
	//@Test
	@Given("^Url is launched$")
	public void Test1() throws Throwable
	{
		BasicConfigurator.configure();
		logger.debug("Test1 is running");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jaspal-singh\\Desktop\\Selenium Library\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(pr.Url());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		logger.debug("End of Test1");
		
		

	}

	//@Test
	@When("^User enters username and password$")
	public void Test2() throws Throwable
	{
		String username = ex.getData(1, 0);
		String password = ex.getData(1, 1);
		logger.debug("Test2 is running");
		driver.findElement(By.cssSelector(pr.cssLoginUsername())).sendKeys(username);
        driver.findElement(By.cssSelector(pr.cssLoginPassword())).sendKeys(password);
        Thread.sleep(2000);
		logger.debug("End of Test2");

	}

	//@Test
	@Then("^Click on login button$")
	public void Test3() throws Throwable
	{
		logger.debug("Test3 is running");
		driver.findElement(By.cssSelector(pr.cssloginButton())).click();
		logger.debug("End of Test3");

	}

	//@Test
	@Then("^User navigates to next and click on view details$")
	public void Test4() throws Throwable,StaleElementReferenceException
	{
		logger.debug("Test3 is running");

		wait = new WebDriverWait(driver, 100);
		WebElement ele = wait
				.ignoring(Exception.class)
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(pr.cssPageText1())));
		String text = ele.getText();
        System.out.println(text);
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
		Thread.sleep(2000);

		logger.debug("End of Test4");

        }

	//@Test
	@Then("^again click on contact details to update information$")
	public void Test5() throws Throwable
	{
		logger.debug("Test5 is running");

		WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(pr.cssContactDetails())));
		element2.click();
		Thread.sleep(2000);

		logger.debug("End of Test5");

	}

	//@Test
	@Then("^click on Edit button$")
	public void Test6() throws Throwable
	{
		logger.debug("Test6 is running");

		WebElement element3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(pr.cssEditButton())));
		element3.click();
		logger.debug("End of Test6");

	}

	//@Test
	@And("^update information$")
	public void Test7() throws Throwable
	{
		logger.debug("Test7 is running");

		WebElement element4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(pr.cssEditInput())));
		element4.clear();
		String address = ex.getData(1, 2);
		element4.sendKeys(address);
		Thread.sleep(3000);
		logger.debug("End of Test7");

			
	}

	//@Test
	@Then("^click on Save button$")
	public void Test8() throws Throwable
	{
		logger.debug("Test8 is running");

		WebElement element5 = driver.findElement(By.cssSelector(pr.cssSaveButton()));
		executor.executeScript("arguments[0].click();", element5);
		logger.debug("End of Test8");

	}

	//@Test
	@And("^click to select logout button$")
	public void Test9() throws Throwable
	{
		logger.debug("Test9 is running");

		WebElement element6 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(pr.cssSuccessMessage())));
		String message = element6.getText();
		System.out.println(message);
		String ExpectedMessage = "You have successfully submitted your message";
		Assert.assertEquals(ExpectedMessage, message);
		WebElement element7 = driver.findElement(By.cssSelector(pr.cssBWOption()));
		executor.executeScript("arguments[0].click();", element7);
		Thread.sleep(2000);
		WebElement element8 = driver.findElement(By.xpath(pr.xpathLogoutLink()));
		executor.executeScript("arguments[0].click();", element8);
		Thread.sleep(2000);
		WebElement element9 = driver.findElement(By.cssSelector(pr.CssLogoutAlertButton()));
		executor.executeScript("arguments[0].click();", element9);
		
		logger.debug("End of Test9");

		
	}

	//@Test
	@Then("^user will be logged out successfully$")
	public void Test9_1() throws Throwable
	{
		logger.debug("Test9_1 is running");
		Thread.sleep(2000);
		System.out.println("Logged out Successfully");
		driver.close();
		
		logger.debug("End of Test9_1");

	}

	


}