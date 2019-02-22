package KeywordDrivenPackage;

import java.rmi.server.Operation;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverScript
{
	
 public static WebDriver driver = null;
	
 public static void main(String[] args) throws Exception 
 {
	 
	
 String sPath = "C:\\Users\\jaspal-singh\\Desktop\\WorkSpace\\TestProject\\src\\TestKeyword.xlsx"; 
 
 ReadExcelData.setExcelFile(sPath, "Sheet1");
 
 
   
 for (int iRow=1;iRow<=8;iRow++)
 {

 String sActions = ReadExcelData.getCellData(iRow, 1); 
  
 if(sActions.equals("openBrowser"))
 	{
	 
	 perform(sActions);
	
 	}
 
 if(sActions.equals("navigate"))
 	{
	 perform(sActions);
 	}
 
 if(sActions.equals("input"))
 	{
	 //perform(sActions);
	 
	// public void enterText(String value, String text) {
      //   WebElement element = driver.findElement(value);
       //  element.sendKeys(text);
	  
 	}
 /*
 if(sActions.equals("input_Password"))
 	{
	 perform(sActions);
 	}
 	*/
 if(sActions.equals("click_Login"))
 	{
	 perform(sActions);
 	}
 
 if(sActions.equals("Wait"))
 	{
	 perform(sActions);
 	}
 
 if(sActions.equals("closeBrowser"))
 	{   
	 perform(sActions);
 	}
 }
 	
 
 
 }
 private By locatorValue(String locatorType, String value) {
     By by;
     switch (locatorType) {
         case "id":
             by = By.id(value);
             break;
         case "name":
             by = By.name(value);
             break;
         case "xpath":
             by = By.xpath(value);
             break;
         case "css":
             by = By.cssSelector(value);
             break;
         case "linkText":
             by = By.linkText(value);
             break;
         case "partialLinkText":
             by = By.partialLinkText(value);
             break;
         default:
             by = null;
             break;
     }
     return by;
 }
 
 //CR0 1UD
 public static void perform(String operartion) throws Exception
 {
	 switch (operartion)
	 {
     case "openBrowser":
    	 try
    	 {
    	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\jaspal-singh\\Desktop\\Selenium Library\\chromedriver.exe");
 		driver = new ChromeDriver();
    	 }
    	 catch(Exception e)
    	 {
    		 System.out.println("Error Message is : "+e.getMessage());
    	 }
    	 break;
    	 
     case "navigate":
    	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	 driver.get("https://v218-dal-qa-merceros.mercer.com:10492/ovtdemo/login");
    	 break;
         
     case "input":
    	 
    	 
    	 for(int i=1 ; i<=8;i++)
    	 {
    		 if((ReadExcelData.getCellData(i,1).equals("input")))
    			 
    		 {
    			String input = ReadExcelData.getCellData(i,2);
    			String path = ReadExcelData.getCellData(i,3);

    			System.out.println(input);
    			System.out.println(path);

    			//driver.findElement(By.cssSelector("input#userIdInput")).sendKeys(username); 
       		    driver.findElement(By.cssSelector(path)).sendKeys(input); 	
       		 
	    		
    		 }
    	 }
    	 
    	 
         break;
         /*
     case "input_Password":
    	 
    	 for(int i=1 ; i<=8;i++)
    	 {
    		 if((ReadExcelData.getCellData(i,1).equals("input_Password")))
    			 
    		 {
    			String password = ReadExcelData.getCellData(i,2);
    			String path = ReadExcelData.getCellData(i,3);

    	 		//driver.findElement(By.cssSelector("input#passcodeInput")).sendKeys(password);
    	 		driver.findElement(By.cssSelector(path)).sendKeys(password);

    		 }
    		 
    	 }
    	 break;
    	 */
         
     case "click_Login":
    	 driver.findElement(By.cssSelector("button#LogInBtn")).click();
    	 break;
    	 
     case "Wait":
    	 Thread.sleep(10000);
    	 break;
    	 
     case "closeBrowser":
       try {
     	driver.close();
       } catch(Exception e)
       {
    	   System.out.println("Nothing to close");
       }
     	break;
    	 
     default:
         break;
     }
 
 
  }
 
}