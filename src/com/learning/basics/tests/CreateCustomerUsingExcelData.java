package com.learning.basics.tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;

import com.learning.basics.utils.ActitimeUtils;
import com.learning.basics.utils.ConfigReader;
import com.learning.basics.utils.ExcelUtils;

public class CreateCustomerUsingExcelData 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		WebDriver driver= ActitimeUtils.getMyDriver(ConfigReader.getMyConfigValue("browser"));
		ActitimeUtils.launchApp(ConfigReader.getMyConfigValue("url"));
		ActitimeUtils.login(ConfigReader.getMyConfigValue("username"), ConfigReader.getMyConfigValue("password"));
		ActitimeUtils.clickOnModule("Tasks");
		
		int rowCount = ExcelUtils.getMyRowCount("customerdata");
		String cn,cd;
		for (int i = 1; i < rowCount; i++) 
		{
			cn = ExcelUtils.getMyCellValue("customerdata", i, 0);
			cd = ExcelUtils.getMyCellValue("customerdata", i, 1);
			ActitimeUtils.clickOnCreateCustomerButton();
			ActitimeUtils.createCustomer(cn,cd);
			
		}
			ActitimeUtils.logout();
	}
}
//div[span[contains(text(),'FirstCustomer')]]/following-sibling::div