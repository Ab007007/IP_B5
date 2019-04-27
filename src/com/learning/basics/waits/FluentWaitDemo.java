package com.learning.basics.waits;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

/*
 * drawbacks of webdriver wait:
 * -----------------------------
 * 1. you can use only the perdefined functions
 * 		if you want to write your own wait function (own logic)
 * 2. polling ->500ms
 * 3. exceptions while waiting for elements 
 */

/*
 *  Steps:
 *  ====================
 *  1. Create an Object to FluentWait
 *  	- Which element 
 *  	- What is the max time to wait
 *   	- What is the polling time to be configured
 *   	- Exceptions to be Ignored
 *  2. Override apply method Present in Function Interface and keep your own logic 
 *  3. use wait object and pass your function to until method
 *  
 */


public class FluentWaitDemo
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
		
		FluentWait<WebElement> wait =  new FluentWait<WebElement>(driver.findElement(By.id("demo")))
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofMillis(100))
				.ignoring(NoSuchElementException.class)
				.ignoring(Exception.class);
		
		Function<WebElement, Boolean> fun  = new Function<WebElement, Boolean>()
		{
			public Boolean apply(WebElement element)
			{
				if(element.getText().equals("Hello"))
				{
					System.out.println("Found Text Helloo.................");
					return true;
				}
				else
				{
					System.out.println("Waiting!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					return false;
				}
			}
		};
		
		wait.until(fun);
		System.out.println("End of main...");
		
		
	}
	
	
}






