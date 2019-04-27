package com.learning.basics.waits;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitDemo
{

	public static void main(String[] args)
	{
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver =  new ChromeDriver();
		//Configure the driver with implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS); // 5 mins
//		driver.manage().timeouts().setScriptTimeout(arg0, arg1)
		
				
		System.out.println("launching application ");
		//Launching http://formy-project.herokuapp.com/form App
		driver.get("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("Intellipaat");
		
		List<WebElement> suggestions = driver.findElements(By.xpath("//li[@role='presentation']"));
		
		System.out.println("total suggestions displayed - " + suggestions.size());
		
		for(int i= 0; i<suggestions.size();i++)
		{
			WebElement ele = suggestions.get(i);
			System.out.println(ele.getText());
			
		}
	}
}
