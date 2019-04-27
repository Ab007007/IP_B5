package com.learning.basics.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.learning.basics.utils.ActitimeUtils;
import com.learning.basics.utils.DriverUtils;

public class MouseMMOperations
{

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = DriverUtils.getMyDriver();
		ActitimeUtils.launchApp("https://www.flipkart.com/");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		Actions act = new Actions(driver);
		
		WebElement mensTab=  driver.findElement(By.xpath("//span[text()='Men']"));
		WebElement homeFurnitureTab=  driver.findElement(By.xpath("//span[text()='Home & Furniture']"));
		WebElement womenTab=  driver.findElement(By.xpath("//span[text()='Women']"));
		WebElement tvTab=  driver.findElement(By.xpath("//span[text()='TVs & Appliances']"));
	
		System.out.println("Moving mouse to mensTab");
		act.moveToElement(mensTab).perform();
		Thread.sleep(2000);
		
		System.out.println("Moving mouse to homeFurnitureTab");
		act.moveToElement(homeFurnitureTab).perform();
		Thread.sleep(2000);
		
		System.out.println("Moving mouse to womenTab");
		act.moveToElement(womenTab).perform();
		Thread.sleep(2000);
		
		System.out.println("Moving mouse to tvTab");
		act.moveToElement(tvTab).perform();
		Thread.sleep(2000);
		
		
	}
}
