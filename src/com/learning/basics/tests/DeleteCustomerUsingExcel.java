package com.learning.basics.tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.learning.basics.utils.ActitimeUtils;
import com.learning.basics.utils.ConfigReader;
import com.learning.basics.utils.ExcelUtils;

public class DeleteCustomerUsingExcel 
{
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException 
	{
		WebDriver driver= ActitimeUtils.getMyDriver(ConfigReader.getMyConfigValue("browser"));
		ActitimeUtils.launchApp(ConfigReader.getMyConfigValue("url"));
		ActitimeUtils.login(ConfigReader.getMyConfigValue("username"), ConfigReader.getMyConfigValue("password"));
		ActitimeUtils.clickOnModule("Tasks");
		
		int rowCount = ExcelUtils.getMyRowCount("customerdata");
		
		for (int i = 1; i < rowCount; i++) 
		{
			ActitimeUtils.deleteCustomer(ExcelUtils.getMyCellValue("customerdata", i, 0));
		}
		
		ActitimeUtils.logout();
	}
}
