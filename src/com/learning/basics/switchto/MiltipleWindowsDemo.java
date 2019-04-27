package com.learning.basics.switchto;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.learning.basics.utils.ActitimeUtils;

public class MiltipleWindowsDemo //extends ActitimeUtils
{

	public static void main(String[] args) {
		WebDriver driver = ActitimeUtils.getMyDriver();
		ActitimeUtils.launchApp("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		ActitimeUtils.clickOnElement("linktext", "Contact Us");
		
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> it = windowIds.iterator();
		String parentWindowID = it.next();
		String childWindowID = it.next();
		
		driver.switchTo().window(childWindowID);
		List<WebElement> linksInChildBrowser = driver.findElements(By.xpath("//a"));
		
		for (WebElement webElement : linksInChildBrowser) {
			System.out.println(webElement.getText());
		}
		//driver.close();
		driver.switchTo().window(parentWindowID);
		ActitimeUtils.clickOnElement("linktext", "Home");
		
		driver.quit();
	}
	
}
