package com.learning.basics.waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetTextFromAppDemo
{

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver =  new ChromeDriver();
		
		//Configure the driver with implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		System.out.println("launching application ");
		//Launching http://formy-project.herokuapp.com/form App
		driver.get("file:///D:/Intellipaat/Intellipaat_10_March/html/tiimeout.html"); //5 mins
		
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 180);
		
		WebElement textElement = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("demo"))));
		
			
		System.out.println("text displayed is --> " + textElement.getText());
		
		System.out.println("main Ended");
	}
}














