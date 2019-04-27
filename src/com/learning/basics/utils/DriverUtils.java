package com.learning.basics.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverUtils {
	public static WebDriver driver = null;

	/**
	 * ***** function returns Browser instance ******
	 * 
	 * @author Aravind
	 * @return chrome browser
	 * 
	 */
	public static WebDriver getMyDriver() {
		System.out.println("Creating a driver");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	public static WebDriver getMyDriver(String type) {
		System.out.println("Creating a Driver for " + type);
		switch (type) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "ff":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup(); 
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("Please contat FrameWork developers.., we are supporting only chrome and FF");
			break;
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	/**
	 * @author Aravind
	 * @param locator      -->id, name, class, tagName, linkText,
	 *                     PartialLinkText, cssSelector, xPath
	 * @param locatorValue
	 * @return
	 */
	public static WebElement getMyElement(String locator, String locatorValue) {
		WebElement ele = null;
		System.out.println("Finding element on webPage using " + locator + "  and  " + locatorValue);

		switch (locator) {
		case "id":
			ele = driver.findElement(By.id(locatorValue));
			break;
		case "name":
			ele = driver.findElement(By.name(locatorValue));
			break;
		case "class":
			ele = driver.findElement(By.className(locatorValue));
			break;
		case "tagname":
			ele = driver.findElement(By.tagName(locatorValue));
			break;
		case "linktext":
			ele = driver.findElement(By.linkText(locatorValue));
			break;
		case "partiallinktext":
			ele = driver.findElement(By.partialLinkText(locatorValue));
			break;
		case "css":
			ele = driver.findElement(By.cssSelector(locatorValue));
			break;
		case "xpath":
			ele = driver.findElement(By.xpath(locatorValue));
			break;

		default:
			System.out.println("Please contact your Framwork Team..!!!!!");
			break;
		}
		return ele;
	}

	
	
	public static void typeOnElement(String locator, String locatorValue,String textToType)
	{
		System.out.println("Typing on  element  using " + locator + "  and  " + locatorValue + "---> " + textToType);
		getMyElement(locator, locatorValue).sendKeys(textToType);
	}
	
	public static void clickOnElement(String locator, String locatorValue)
	{
		System.out.println("clicking on  element  using " + locator + "  and  " + locatorValue );
		getMyElement(locator, locatorValue).click();
		
	}
	
	public static String getTextOnElement(String locator, String locatorValue)
	{
		System.out.println("Getting text on the  element  using " + locator + "  and  " + locatorValue );
		String textOnElement = getMyElement(locator, locatorValue).getText();
		return textOnElement;
	}
	
	
	
	
	
	
	
	
	
	
}
