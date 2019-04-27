package com.learning.basics.popup;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.learning.basics.utils.ActitimeUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileDownloadPopUpInFF 
{
	public static void main(String[] args) throws IOException 
	{
		Runtime.getRuntime().exec("D:\\Eclipse_WS\\Intellipaat_10_March\\autoItScripts\\FileDownloadHelper.exe");
		
		FirefoxProfile fp =  new FirefoxProfile();
		fp.setPreference("browser.download.folderList", 2);
		fp.setPreference("browser.download.dir", "D:\\Eclipse_WS\\Intellipaat_10_March\\autoDownload\\123.jar");

		
		FirefoxOptions opt =  new FirefoxOptions();
		opt.setProfile(fp);
		
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver(opt);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.seleniumhq.org/download/");
		driver.findElement(By.xpath("//a[text()='3.141.59']")).click();
//		ActitimeUtils.clickOnElement("xpath", "//a[text()='3.141.59']");
	}
}
