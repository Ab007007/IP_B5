package com.learning.grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginWithGridExecution {
	static WebDriver driver = null;

	public static void main(String[] args) throws MalformedURLException {
		String nodeUrl = "http://192.168.0.6:5555/wd/hub";
		
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WIN10);
		options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.addArguments("disable-infobars");
		
		driver = new RemoteWebDriver(new URL(nodeUrl), options);

		System.out.println("launching application ");
		// Launching http://formy-project.herokuapp.com/form App
		driver.get("http://formy-project.herokuapp.com/form");

		System.out.println("entering user first name");
		driver.findElement(By.id("first-name")).sendKeys("Formy-FN1");

		System.out.println("entering user last name");
		driver.findElement(By.id("last-name")).sendKeys("Formy-LN1");

		System.out.println("entering user job title");
		driver.findElement(By.xpath("//input[@placeholder='Enter your job title']")).sendKeys("Trainer");

		System.out.println("Selecting Education ");
		driver.findElement(By.id("radio-button-1")).click();

		System.out.println("Selecting Sex");
		driver.findElement(By.id("checkbox-1")).click();

	}
}
