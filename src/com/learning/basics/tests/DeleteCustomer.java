package com.learning.basics.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.learning.basics.utils.ActitimeUtils;
import com.learning.basics.utils.ConfigReader;

public class DeleteCustomer 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver= ActitimeUtils.getMyDriver(ConfigReader.getMyConfigValue("browser"));
		ActitimeUtils.launchApp(ConfigReader.getMyConfigValue("url"));
		ActitimeUtils.login(ConfigReader.getMyConfigValue("username"), ConfigReader.getMyConfigValue("password"));
		
		
		ActitimeUtils.clickOnModule("Tasks");
		ActitimeUtils.deleteCustomer("ThirdtCustomer2-Mar10");
		ActitimeUtils.logout();
	}
}
