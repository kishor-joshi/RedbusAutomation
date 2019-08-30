package com.redbus.testscripts;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.redbus.helper.Base;


/**
 * This class contains Test methods for testing Redbus website
 * @author Kishor
 *
 */


public class RedbusTestScript{
	Base base=new Base();
	
	WebDriver driver;
	WebElement element;
	
	
	//opening Redbus web page
	@BeforeTest
	public void openWebPage() {
	System.setProperty(base.getConfigProperty("driver"),base.getConfigProperty("chromepath"));
	driver=new ChromeDriver();
	driver.get(base.getConfigProperty("url"));
	driver.manage().window().maximize();
	}
	
	
	//Quieting 
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
	@Test(priority=1)
	public void HomePage() {
		driver.findElement(By.id(base.getLocator("fromplace_textbox"))).sendKeys(base.getConfigProperty("fromplace"));
		Base.waitForElement();
		driver.findElement(By.id(base.getLocator("fromplace_textbox"))).sendKeys(Keys.ENTER);
		driver.findElement(By.id(base.getLocator("toplace_textbox"))).sendKeys(base.getConfigProperty("toplace"));
		Base.waitForElement();
		driver.findElement(By.id(base.getLocator("toplace_textbox"))).sendKeys(Keys.ENTER);
		
		
		driver.findElement(By.id(base.getLocator("onwardcalender"))).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(base.getLocator("onward_date"))).click();
		driver.findElement(By.cssSelector(base.getLocator("search_btm"))).click();
		Base.waitForElement();
	}
	@Test(priority = 2)
	public void countTotalBusesTest() {
		driver.findElement(By.xpath(base.getLocator("viewbus_btn"))).click();
		List<WebElement>list=driver.findElements(By.xpath(base.getLocator("actualtotal_viewseats")));
		System.out.println(list.size());
		String actualtotalbus=""+list.size();
		WebElement element =driver.findElement(By.xpath(base.getLocator("expectedtotal_bus")));
		System.out.println(element.getText());
		String arr[]=element.getText().split("\\s+");
		System.out.println(arr[0]);
		String expectedtotalbus=arr[0];
		Assert.assertEquals(actualtotalbus, expectedtotalbus, "displayed total bus number is not matched");
	}
}
