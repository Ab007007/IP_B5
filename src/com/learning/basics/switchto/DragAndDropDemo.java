package com.learning.basics.switchto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.learning.basics.utils.ActitimeUtils;
import com.learning.basics.utils.DriverUtils;

public class DragAndDropDemo
{

	public static void main(String[] args)
	{
		WebDriver driver =  DriverUtils.getMyDriver("ff");
		ActitimeUtils.launchApp("http://jqueryui.com/droppable/");
		WebElement frameElement = ActitimeUtils.getMyElement("xpath", "//iframe[contains(@src,'default.html')]");
		driver.switchTo().frame(frameElement);
		
		System.out.println(driver.findElement(By.id("droppable")).getText());
		Actions act = new Actions(driver);
			
		act.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).perform();
		
		System.out.println(driver.findElement(By.id("droppable")).getText());
		
		driver.switchTo().defaultContent();
		ActitimeUtils.clickOnElement("linktext", "Resizable");
		
	}
	
	
}
