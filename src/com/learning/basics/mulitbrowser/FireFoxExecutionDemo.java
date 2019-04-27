package com.learning.basics.mulitbrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.learning.basics.utils.ActitimeUtils;

public class FireFoxExecutionDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		//session obj
		//Creating object to Chrome browser
		WebDriver driver =  new FirefoxDriver();		
		//launching the application 
		driver.get("http://localhost/login.do");
		
		//entering username
		driver.findElement(By.id("username")).sendKeys("admin");

		//entering password
		driver.findElement(By.name("pwd")).sendKeys("manager");
		
		//clicking on login button
		driver.findElement(By.id("loginButton")).click();
		//driver.close();
	}
}
