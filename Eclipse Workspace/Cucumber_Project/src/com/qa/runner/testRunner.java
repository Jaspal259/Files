package com.qa.runner;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(
		
		features="C:/Users/jaspal-singh/Desktop/Eclipse Workspace/Cucumber_Project/src/com/qa/features",
		plugin={"pretty","html:C:/Users/jaspal-singh/Desktop/Eclipse Workspace/Cucumber_Project/Reports/"},
		glue={"com.qa.stepDefination"},
		monochrome = true
				)			


public class testRunner 				
	{	
	
	}