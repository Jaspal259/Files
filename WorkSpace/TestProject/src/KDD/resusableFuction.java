package KDD;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class resusableFuction {
	
	WebDriver driver;
	
	public String[][] fetchDataFromExcel() throws Exception,NullPointerException 
	{
		
		Workbook wb = null;
		String[][] data = null;
		
		String path = "C:\\Users\\jaspal-singh\\Desktop\\WorkSpace\\TestProject\\src\\KDD\\NewKeywords.xlsx";
		File excel = new File(path);
		FileInputStream file = new FileInputStream(excel);
	
		System.out.println(path);
		String extn = path.substring(path.indexOf(".")+1);
		
		System.out.println(extn);
		
		if(extn.equals("xlsx"))
		{
			wb = new XSSFWorkbook(file);
		} else
		{
			wb = new HSSFWorkbook(file);
		
      	}
		Sheet sheet = wb.getSheet("Sheet2");
		int rownum = sheet.getLastRowNum();
		int column = sheet.getRow(0).getLastCellNum();
		
		data = new String[rownum][column];
		
		
		for(int i = 0 ; i < rownum; i++)
		{
			Row row = sheet.getRow(i);
			for(int j=0 ; j < column ; j++)
			{
				Cell cell = row.getCell(j);
				String value = cell.toString();
				
				//System.out.println(value);
				data[i][j] = value;
			}
		
		
		}
		return data;


	}
	
	public static String fetchprop(String text)
	{
		Properties prop = new Properties();
		FileInputStream input;
		try{
			input = new FileInputStream("C:\\Users\\jaspal-singh\\Desktop\\WorkSpace\\TestProject\\src\\KDD\\object.properties");
			prop.load(input);
		  
		}catch (Exception e)
		{
			
		}
		return prop.getProperty(text);
	}
	
	public void launchAppl()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jaspal-singh\\Desktop\\Selenium Library\\chromedriver.exe");
		driver = new ChromeDriver();
	    driver.get(fetchprop("URL"));
		//driver.get("https://github.com/");

		//System.out.println(fetchprop("URL"));
	}
	
	public void filltext(String LocatorBy,String LocatorValue,String text)
	{
		switch (LocatorBy) {
		case "css":
			driver.findElement(By.cssSelector(LocatorValue)).sendKeys(text);
			break;
		case "name":
			driver.findElement(By.name(LocatorValue)).sendKeys(text);
			break;
					
		default:
			break;
		}
		

	}
	public void click(String LocatorBy, String LocatorValue) throws Exception
	{
		switch (LocatorBy) {
		case "css":
			try
			{
			WebElement ele1=driver.findElement(By.cssSelector(LocatorValue));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ele1);
			Thread.sleep(2000);
			}catch (Exception e)
			{
				e.printStackTrace();
			}
			break;
		case "name":
			driver.findElement(By.name(LocatorValue)).click();
			break;
					
		default:
			break;
	}
	}
	public void driverClose()
	{
		driver.quit();
	}
	
	public void Wait() throws Exception
	{
		Thread.sleep(5000);
	}

}
