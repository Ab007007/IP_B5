package com.learning.grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.learning.basics.utils.ActitimeUtils;
import com.learning.basics.utils.ConfigReader;

public class CreateCustomerUsingGrid 
{
	public static void main(String[] args) throws MalformedURLException 
	{
		String nodeUrl = "http://192.168.0.6:5554/wd/hub";
		
//		ChromeOptions options = new ChromeOptions();
//		options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WIN10);
//		options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
//		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//		options.addArguments("disable-infobars");
		
		InternetExplorerOptions options = new InternetExplorerOptions();
		options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
		options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	//	options.addArguments("disable-infobars");
		
		WebDriver driver = new RemoteWebDriver(new URL(nodeUrl), options);
		ActitimeUtils.driver = driver;
		ActitimeUtils.launchApp(ConfigReader.getMyConfigValue("url"));
		ActitimeUtils.login(ConfigReader.getMyConfigValue("username"), ConfigReader.getMyConfigValue("password"));
		ActitimeUtils.clickOnModule("Tasks");
		ActitimeUtils.clickOnCreateCustomerButton();
		ActitimeUtils.createCustomer("GRID_Customer3-Mar10","FirstCustomer1-Mar10-Desc");
		ActitimeUtils.logout();
	}
}
//div[span[contains(text(),'FirstCustomer')]]/following-sibling::div