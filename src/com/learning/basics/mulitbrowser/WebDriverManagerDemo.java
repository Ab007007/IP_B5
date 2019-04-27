package com.learning.basics.mulitbrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerDemo {

	public static void main(String[] args) {
		
		//WebDriverManager.edgedriver().setup();//WebDriverManager.iedriver().setup(); 
		//WebDriverManager.chromedriver().setup();
		
//		WebDriverManager.firefoxdriver().setup();
//		WebDriver driver  =  new FirefoxDriver();
//	
		WebDriverManager.iedriver().setup();
		WebDriver driver  =  new InternetExplorerDriver();
		
		driver.get("http://localhost/login.do");
		
		//entering username
		driver.findElement(By.id("username")).sendKeys("admin");

		//entering password
		driver.findElement(By.name("pwd")).sendKeys("manager");
		
		//clicking on login button
		driver.findElement(By.id("loginButton")).click();
		
		
		 
	}
}
