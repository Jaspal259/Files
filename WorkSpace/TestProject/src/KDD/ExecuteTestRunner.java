package KDD;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.WebDriver;

public class ExecuteTestRunner {
	
	

	public static void main(String[] args) throws Exception {

		resusableFuction func = new resusableFuction();
		
		String[][] KeywordsData = func.fetchDataFromExcel();
		
		int rownum = KeywordsData.length;

		int column = KeywordsData[0].length;
		
		
		String TC_Name = KeywordsData[0][0];
		String TC_Step_No = KeywordsData[0][1];
		String TC_Step_Name = KeywordsData[0][2];
		String TC_func = KeywordsData[0][3];
		String TC_location = KeywordsData[0][4];
		String TC_LV = KeywordsData[0][5];
		String TC_param = KeywordsData[0][6];
		String TC_Execute= KeywordsData[0][7];
		
		
		//System.out.println(TC_Execute);
		
		for(int count=1; count <rownum ;count++)
		{
			String function = KeywordsData[count][3];
			String LocatorBy = KeywordsData[count][4];
			String LocatorElement = resusableFuction.fetchprop(KeywordsData[count][5]);
			//String LocatorElement = KeywordsData[column][5];

			String content_param = KeywordsData[count][6];
			String execute = KeywordsData[count][7];
			
			System.out.println(content_param);
			


			System.out.println(function + "\t" + LocatorBy + "\t" + LocatorElement + "\t" + content_param );
			if(execute.equals("Y"))
	         {
			switch (function) {
			case "launchAppl":
				func.launchAppl();
				Thread.sleep(3000);
				break;
			case "filltext":
				
				func.filltext(LocatorBy, LocatorElement, content_param);
				Thread.sleep(3000);

				break;	
			case "click":
				func.click(LocatorBy, LocatorElement);
				
			case "driverClose":
				func.driverClose();
				break;
				
			case "Wait":
				func.Wait();
				break;

			default:
				break;
			}
			

		} 
		}

		

		
		
	}

}
