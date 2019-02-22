package com.qa.utils;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtility {
	

	String un = null;
	int sc, rc, cc;

     	
    	
    	public String getData(int rc,int cc)
    	{
    		
    		try {
    			

    			FileInputStream fs1 = new FileInputStream("C:\\Users\\jaspal-singh\\Desktop\\test.xls");
    			HSSFWorkbook book = new HSSFWorkbook(fs1);
    			HSSFSheet sheet = book.getSheet("Sheet1");

    					
    					HSSFCell cell = sheet.getRow(rc).getCell(cc);

    					String CellData = cell.getStringCellValue();

    					return CellData;
    					
    					
    				
    			
    		} catch (Exception e) {

    		}
    		return "";



    }

}