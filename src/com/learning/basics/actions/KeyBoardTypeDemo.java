package com.learning.basics.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.learning.basics.utils.ActitimeUtils;
import com.learning.basics.utils.DriverUtils;

public class KeyBoardTypeDemo
{

	public static void main(String[] args)
	{
		WebDriver driver =  DriverUtils.getMyDriver();
		ActitimeUtils.launchApp("http://localhost:8080/login.do");
		
		//Use Actions
		/*
		 * 1. Create an object to Actions
		 * 2. use the newly created object to perform action on the elements
		 * 3. NOTE -> always call perform() method when you are using actions
		 */
		
	
		Actions act = new Actions(driver);
		act.sendKeys("admin").perform();
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys("manager").perform();
		act.sendKeys(Keys.ENTER).perform();
		
		
		
		
	}
}
