package com.learning.basics.tests;

import org.openqa.selenium.WebDriver;

import com.learning.basics.utils.ActitimeUtils;
import com.learning.basics.utils.ConfigReader;

public class CreateCustomerTest 
{
	public static void main(String[] args) 
	{
		WebDriver driver= ActitimeUtils.getMyDriver(ConfigReader.getMyConfigValue("browser"));
		ActitimeUtils.launchApp(ConfigReader.getMyConfigValue("url"));
		ActitimeUtils.login(ConfigReader.getMyConfigValue("username"), ConfigReader.getMyConfigValue("password"));
		ActitimeUtils.clickOnModule("Tasks");
		ActitimeUtils.clickOnCreateCustomerButton();
		ActitimeUtils.createCustomer("ThirdtCustomer2-Mar10","FirstCustomer1-Mar10-Desc");
		ActitimeUtils.logout();
	}
}
//div[span[contains(text(),'FirstCustomer')]]/following-sibling::div