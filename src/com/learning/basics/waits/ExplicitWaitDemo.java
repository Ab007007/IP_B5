package com.learning.basics.waits;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo
{

	public static void main(String[] args)
	{
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver =  new ChromeDriver();
		//Configure the driver with implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("launching application ");
		//Launching http://formy-project.herokuapp.com/form App
		driver.get("https://www.google.com/"); //5 mins
		
		driver.findElement(By.name("q")).sendKeys("Intellipaat");
		
		
		//Step-1 --> Create an object to WebDriverWait
		WebDriverWait wait = new WebDriverWait(driver, 60);
				
		// Step-2 --> use ExpectedConditions class to specify the wait condition
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//ul[@class='erkvQe']"))));
				
		List<WebElement> suggestions = driver.findElements(By.xpath("//li[@role='presentation']"));
		
		System.out.println("total suggestions displayed - " + suggestions.size());
		
		for(int i= 0; i<suggestions.size();i++)
		{
			WebElement ele = suggestions.get(i);
			System.out.println(ele.getText());
			
		}
	}
}
