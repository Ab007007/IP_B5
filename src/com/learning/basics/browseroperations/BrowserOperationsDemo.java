package com.learning.basics.browseroperations;

import org.openqa.selenium.WebDriver;

import com.learning.basics.utils.ActitimeUtils;
import com.learning.basics.utils.DriverUtils;

public class BrowserOperationsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//WebDriver driver = DriverUtils.getMyDriver();
		
		WebDriver driver = ActitimeUtils.getMyDriver();
		
		ActitimeUtils.launchApp("http://localhost/login.do");
		
		ActitimeUtils.login("admin","manager");
		
		System.out.println("Clicking on Back Button of browser");
		driver.navigate().back();
		
		System.out.println(" Returns URL of a Broser");
		String url  = driver.getCurrentUrl();
		System.out.println(url);
		
		System.out.println("Clicking on Forward Button of browser");
		driver.navigate().forward();
		
		System.out.println("refresh browser");
		driver.navigate().refresh();
		
		System.out.println("Getting title of the page");
		System.out.println(driver.getTitle());
		
		System.out.println("Maximize the Browser");
		driver.manage().window().maximize();
		
		System.out.println("Launching application");
		driver.navigate().to("https://www.google.com/");
		
		System.out.println("Close the browser");
		driver.close();
//		driver.quit();
//		driver.manage().window().fullscreen();
		
		
		
		

	}

}
