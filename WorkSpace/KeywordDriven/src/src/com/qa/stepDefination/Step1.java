package com.qa.stepDefination;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.qa.utils.driverLauncher;
import com.qa.utils.propReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Step1  {				

	final static Logger logger = Logger.getLogger(Step1.class);
	
	static WebDriver driver;    
	propReader rd = new propReader();

	@Test
	@Given("^A_AOpen the Firefox and launch the application$")				
    public void A_Aopen_the_Firefox_and_launch_the_application() throws Throwable							
    {		
		logger.debug("code is started");
		System.setProperty("webdriver.ie.driver", propReader.getDriver());
		 driver = new InternetExplorerDriver();
	      driver.manage().deleteAllCookies();
		
	//	driverLauncher dl = new driverLauncher();
		//driverLauncher.browserLauncher();	
	    //driver1.navigate().to(rd.getDriverPath());
	    driver.navigate().to("https://www.naukri.com/");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		logger.debug("code is closed");
		
    }		
	
	@Test
   @When("^B_BEnter the Username and Password$")					
    public void B_Benter_the_Username_and_Password() throws Throwable 							
    {		
		logger.debug("code is started");
    	String parentWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		int count = allWindow.size();
		//System.out.println("No. of Windows : "+count);
		for(String child : allWindow)
			
		{
			if(!parentWindow.equals(child))
			{
				
				driver.switchTo().window(child);
				driver.manage().window().maximize();
				String title = driver.getTitle();
				
				if(title.equalsIgnoreCase("technosoft"))
				{
				//driver1.findElement(By.linkText("https://company.naukri.com/landing-page/technosoftcorp/422019")).click();
					System.out.println(" I am Child window jaspal "+title);
					Thread.sleep(9000); 
					driver.close();
				}
			}
				driver.switchTo().window(parentWindow);
		}
		logger.debug("code is closed");

    	}
	
	@Test
    @Then("^C_CReset the credential$")					
    public void C_CReset_the_credential() throws Throwable 							
    {    		
		logger.debug("code is Started");
    	driver.quit();
		logger.debug("code is closed");

    }		

}