package com.qa.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonUtilities {

	public static WebDriver driver;
	private static HtmlReporter reporter = null;
	
	static{
		//loadProperties();
		setReporter(HtmlReporter.getInstance());
	}
	
	
	
	public void waitForVisibility(String xpath){
		WebDriverWait wait = new WebDriverWait(driver,30);
		/*wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))
		);*/
	}
	
	public static HtmlReporter getReporter(){
		return reporter;
	}
	
	public static void setReporter(HtmlReporter reporter){
		CommonUtilities.reporter = reporter;
	}
	
	public void generateReport(){
		File reportOutputDirectory = new File(System.getProperty("user.dir") + "/target");
		List<String> list = new ArrayList<String>();
		list.add(System.getProperty("user.dir") + "/target/cucumber-report.json");
		
		String pluginUrlPath= "";
		String buildNumber = "1";
		String BuildProject = "cucumber-jvm";
		boolean skippedFails = true;
		boolean pendingFails = true;
		boolean undefinedFails = true;
		
	}
		
	public void waitForPageLoad() throws InterruptedException{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		while(!executor.executeScript("return document.readyState").toString().equals("complete")){
			System.out.println("waiting");
			Thread.sleep(1000);
		}
	//	new WebDriverWait(driver, 60).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@src='styles/img/loading-animation.gif']")));
	}
	
	public void waitForTime(String Time) throws InterruptedException{
		int waitTime = Integer.parseInt(Time);
		Thread.sleep(1000*waitTime);
	}
	
	public void clickJS(WebElement element) throws InterruptedException{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		waitForPageLoad();
	}
	
	
}
