package com.redbus.testscripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kishor.joshi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.redbus.in//");
		driver.manage().window().maximize();
		driver.findElement(By.id("src")).sendKeys("Hyderabad");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		driver.findElement(By.id("dest")).sendKeys("Bangalore");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.id("dest")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("onward_cal")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("(//tr//td[text()='31'])[2]")).click();
		driver.findElement(By.cssSelector("#search_btn")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//div[@class='w-14 fl']//div[@class='button']")).click();
		List<WebElement>list=driver.findElements(By.xpath("//div[text()='View Seats']"));
		System.out.println(list.size());
		WebElement element =driver.findElement(By.xpath("//span[@class='f-bold busFound']"));
		System.out.println(element.getText());
		String arr[]=element.getText().split("\\s+");
		System.out.println(arr[0]);
		element= driver.findElement((By.xpath("(//div[text()='View Seats'])[1]")));
	}

}
