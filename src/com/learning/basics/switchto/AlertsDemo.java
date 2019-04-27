package com.learning.basics.switchto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.learning.basics.utils.ActitimeUtils;


public class AlertsDemo 
{

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =  ActitimeUtils.getMyDriver();
		ActitimeUtils.launchApp("http://localhost/login.do");
		ActitimeUtils.login("admin", "manager");
		ActitimeUtils.clickOnModule("TASKS");
		ActitimeUtils.clickOnCreateCustomerButton();
	//	driver.findElement(By.id("customerLightBox_nameField")).sendKeys("JunkText");
	//	ActitimeUtils.getMyElement("id", "customerLightBox_nameField").sendKeys("JunkText");
	
		ActitimeUtils.typeOnElement("id", "customerLightBox_nameField", "JunkText");
		ActitimeUtils.clickOnElement("xpath", "//div[@id='customerLightBox_footer']//div[@id='customerLightBox_cancelBtn']");
		Thread.sleep(3000);
		
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		Thread.sleep(3000);
		
		ActitimeUtils.clickOnElement("xpath", "//div[@id='customerLightBox_footer']//div[@id='customerLightBox_cancelBtn']");
		driver.switchTo().alert().accept();
	}

	
}
