package com.redbus.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


/**
 * This class contains methods to interact with different kinds of web browser
 * @author Kishor
 *
 */
public class Base {
	
	   //this method will return value as String from specified file
	
	public String getConfigProperty(String config_key) {
		Properties properties = new Properties();
		try {
			FileInputStream inputStream = new FileInputStream("C:\\Users\\kishor.joshi\\Desktop\\java program\\seleniumCodes\\redbus\\src\\main\\resources\\testData\\config.properties");
			properties.load(inputStream);
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value=properties.getProperty(config_key);
		return value;
	}
	
	
	//this method will return value as String from specified file
	public String getLocator(String user_key) {
		Properties properties = new Properties();
		try {
			FileInputStream inputStream = new FileInputStream("C:\\Users\\kishor.joshi\\Desktop\\java program\\seleniumCodes\\redbus\\src\\main\\resources\\locators\\locators.properties");
			properties.load(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String value=properties.getProperty(user_key);
		return value;
	}
	public static void waitForElement() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
