package com.qa.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import org.openqa.selenium.remote.server.handler.GetPageSource;

public class propReader 
	
	{
		
		private static Properties properties;
		private final String propertyFilePath= "C:\\Users\\jaspal-singh\\Desktop\\Eclipse Workspace\\Cucumber_Project\\Config\\config.properties";

		
		public propReader(){
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader(propertyFilePath));
				properties = new Properties();
				try {
					properties.load(reader);
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
			}		
		}
		
		public static String Url(){
			
			String baseUrl = properties.getProperty("Url");
			return baseUrl;
		}
		
		
		public static String getDriver(){
			
			String baseUrl = properties.getProperty("webdriver");
			return baseUrl;
		}
		public static String getBrowser(){
			
			String baseUrl = properties.getProperty("webbrowser");
			return baseUrl;
		}
		
		public static String cssLoginUsername(){
			
			String loginUsername = properties.getProperty("loginUsername");
			return loginUsername;
		}
		
		
		public static String cssLoginPassword(){
			
			String loginPassword = properties.getProperty("loginPassword");
			return loginPassword;
		}
		
		public static String cssloginButton(){
			
			String loginButton = properties.getProperty("loginButton");
			return loginButton;
		}
		
		public static String cssPageText1(){
			
			String pageText1 = properties.getProperty("pageText1");
			return pageText1;
		}
		
		public static String cssViewDetails(){
			
			String viewDetails = properties.getProperty("viewDetails");
			return viewDetails;
		}
		
		public static String cssContactDetails(){
			
			String contactDetails = properties.getProperty("contactDetails");
			return contactDetails;
		}
		
		public static String cssEditButton(){
			
			String editButton = properties.getProperty("editButton");
			return editButton;
		}
		
		public static String cssEditInput(){
			
			String editInput = properties.getProperty("editInput");
			return editInput;
		}
		
		
		public static String cssSaveButton(){
			
			String saveButton = properties.getProperty("saveButton");
			return saveButton;
		}

		public static String cssSuccessMessage(){
	
			String successMessage = properties.getProperty("successMessage");
			return successMessage;
		
		}
		public static String cssBWOption(){
			
			String BWOption = properties.getProperty("BWOption");
			return BWOption;
		
		}
		public static String xpathLogoutLink(){
			
			String logoutLink = properties.getProperty("logoutLink");
			return logoutLink;
		
		}
		
		public static String CssLogoutAlertButton(){
			
			String logoutAlertButton = properties.getProperty("logoutAlertButton");
			return logoutAlertButton;
		
		}

		
		
		
		
	}