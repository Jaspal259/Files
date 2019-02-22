package com.qa.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Dictionary;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;
import com.qa.stepDefination.mercerOneview;


public class HtmlReporter {
	public static String projectName = "Forms Migration";
	public static String reportFileName = projectName+" Automation Report";
	public static String reportPath = System.getProperty("user.dir") + "\\Reports\\";
	public static Boolean Status = true;
	
	public WebDriver webdriver = null;
	public Date stTime = new Date();
	public Date enTime = new Date();
	
	public Dictionary<String , String> Settings = null;
	private static HtmlReporter reporter = new HtmlReporter();
	
	private HtmlReporter(){
		System.out.println("I am in reporter constructor....");
		File reportdir = new File(reportPath);
		if(!reportdir.exists())
			reportdir.mkdir();
	}
	
	public static HtmlReporter getInstance(){
		return reporter;
	}
	
	public void BeginScenario(String scenarioName , String reportName){
		prepareNewReport(reportName);
		ReportStep("<b>Application Page</b>" , "<b>Scenario: " +scenarioName + "</b> " ,false ,false);
		stTime = new Date();
		
	}
	

	public static String captureScreenshot(String uploadPath){
		
		File scrFile = ((TakesScreenshot)mercerOneview.driver).getScreenshotAs(OutputType.FILE);
       
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD HH-mm-ss");
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		File file1 = new File(scrFile.getAbsolutePath());
         File file2 =  new File(uploadPath + "images");
         if(!file2.exists()){
 			file2.mkdir();
 	}
          file2 = new File(file2.getAbsolutePath() + "/" + dateFormat.format(date) + ".png");
       try{
    	   Files.copy(file1, file2);
       }catch(IOException e){
			e.printStackTrace();
		}
       String absolute = file2.getAbsolutePath();
       String screenshot = absolute.replace('\\', '/');
       screenshot = "./images/"+file2.getName();
       return screenshot;
	}
	
	
	
	public void prepareNewReport(String reportName){
		
		FileWriter fstream = null;
		try{
			reportFileName = reportPath +"_" + (new Date()).toString().replace(":", "-") + ".htm";
			fstream = new FileWriter(reportFileName ,false);
		}catch(IOException e1){
			e1.printStackTrace();
		}
		BufferedWriter out = new BufferedWriter(fstream);
		try{
			out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 sTRICT//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
			out.write("html xmlns = \"http://www.w3.org/19999/xhtml\" xml:lang=\"en\" lang=\"en\">");
			out.write("<head>");
			out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
			out.write("meta charset= utf-8\" />");
			out.write("<title>" + projectName + " Automated Test Results Summary </title>");
			out.write("<style type= \"text/css\">");
			out.write("body{font-family: arclays Sans;font-size:80%;} #maintable{background:#ECF4FF;width:100%;}#subtable{background:#ECF4FF;}#col1{text-align:left;}");
			out.write("#col2{text-align:left;}#col3{text-align:center;}#col4{text-align:center;}th{background:#99C7FF;padding:3px}");
			out.write("td{padding:3px;}tr:hover{background:#D0E6FF;}.pass{color:green;}.fail{color:red;}.other{color:orange;};");
			out.write(".TreeView{   font: Verdana;   line-height: 20px;   cursor: pointer;   "
					+ "font-style: normal;}.TreeView LI{   /*the padding is for the tree view nodes */  "
					+ " padding: 0 0 0 18px;   float: left;   width: 100%;   list-style: none;} .TreeView ul{   margin: 0;   padding: 0;}"
					+ "LI.Expanded{   background: url(minus.gif); no-repeat left top;}LI.Expanded ul{   display: block;}LI.Collapsed{   background: url(plus.gif); "
					+ "no-repeat left top;;}LI.Collapse ul{   display: none;}.Highlighted{   color: red;}.AlternateHighLight{   color:blue;}");
			
			out.write("</style>");
			out.write("</head>");
			out.write("</body>");
			out.write("<h2>" + projectName + " Automation Test Results</h2>");
			out.write("<table id=\"maintable\">");
			out.write("<col id=\"col1\"></col>");
			out.write("<col id=\"col2\"></col>");
			out.write("<col id=\"col3\"></col>");
			out.write("<col id=\"col4\"></col>");
			out.write("<col id=\"col5\"></col>");
			out.write("<tr>");
			out.write("<th>Test Component</th>");
			out.write("<th>Description</th>");
			out.write("<th>Status</th>");
			out.write("<th>Screenshot</th>");
			out.write("<th>Start Time</th>");
			out.write("</tr>");
		}catch(IOException e){
			e.printStackTrace();
		}
		try{
			out.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	
	
	public void ReportStep(String stepName, String StepDescription, boolean status, boolean isScreenshotReqd){
		Status=status;
		FileWriter fstream=null;
	try{
		fstream = new FileWriter(reportFileName ,true);
	}catch(IOException e){
		e.printStackTrace();
	}
	BufferedWriter out = new BufferedWriter(fstream);
	try{
		String Status;
		out.write("<TR>");
		if(stepName.equals("<b>Application Page</b>")) {
				out.write("<TD>" + stepName + "</TD><TD>" + StepDescription +"</TD><TD></TD><TD></TD>" );
				
	}else{
		if(status==true){
			Status = "<TD class='pass'>Passed";
			
		}else{
			Status = "<TD class='fail'>Failed";
		}
		if(isScreenshotReqd){
			String screenshot = captureScreenshot(reportPath);
			out.write("<TD>" + stepName + "</TD><TD>" + StepDescription + "</TD>" + Status + "</TD>"
					+ "</TD><TD><A href=\"" + screenshot
							+"\">View Screenshot</A></TD><TD>" + new Date()
							+ "</TD>");
		}else{
			out.write("<TD>" + stepName + "</TD><TD>" + StepDescription + "</TD>" + Status + "</TD>"
					+ "</TD><TD></TD><TD>" + new Date()
							+ "</TD>");
		}
	}
		
	out.write("</TR>");
	}catch(IOException e){
		e.printStackTrace();
	}
	try{
		out.close();
	}catch(IOException e){
		e.printStackTrace();
	}
	}

}
