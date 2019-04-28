package com.learning.basics.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActitimeUtils extends DriverUtils {

	
	public static void deleteCustomer(String cutomerName)
	{
		Actions act =  new Actions(driver);
		act.moveToElement(getMyElement("xpath", "//div[@class='title' and contains(text(),'" + cutomerName + "')]/following-sibling::div")).perform();
		clickOnElement("xpath",  String.format("//div[@class='title' and contains(text(),'%s')]/following-sibling::div", cutomerName));
		myWait();
		clickOnElement("xpath", "//div[@id='taskListBlock']//div[@class='customerNamePlaceHolder']/following-sibling::div[@class='actions']");
		myWait();
		clickOnElement("xpath", "//div[@class='edit_customer_sliding_panel sliding_panel']//div[@class='deleteButton']");
		clickOnElement("id", "customerPanel_deleteConfirm_submitBtn");
		validateSuccessMessage();
	}
	public static void logout()
	{
		System.out.println("clicking on logout link and closing browser..");
		clickOnElement("id", "logoutLink");
		driver.close();
	}
	/**
	 * @author Aravind
	 * @param cn
	 * @param cd
	 * creates a customer with a given values and validate the success message successfully...
	 */
	public static void createCustomer(String cn, String cd ) {
		System.out.println("Creating customer with "  +cn + " and " + cd);
		typeOnElement("id", "customerLightBox_nameField", cn);
		typeOnElement("id", "customerLightBox_descriptionField", cd);
		clickOnElement("id", "customerLightBox_commitBtn");
		validateSuccessMessage();
		System.out.println("Customer Created Successfully...");
	}
	/**
	 * @throws InterruptedException 
	 * 
	 */
	public static void validateSuccessMessage() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebDriverWait waitForVisible = new WebDriverWait(driver, 20);
		WebElement ele = waitForVisible.until(ExpectedConditions.visibilityOf(getMyElement("class", "toast")));
		System.out.println("Success message is displayed.....");
		System.out.println(ele.getText());
		WebDriverWait waitForInVisible = new WebDriverWait(driver, 20);
		waitForInVisible.until(ExpectedConditions.invisibilityOf(getMyElement("class", "toast")));
		System.out.println("Success message is disappeared...");
	}
	public static void validatePage(String expectedTitle) {
		System.out.println("Validating the page Title " + expectedTitle);
		String actualTitle = driver.getTitle();

		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Page Validated Successfully...");
		} else {
			System.out.println("Actual title " + actualTitle + " is not matched with expected title " + expectedTitle);
		}
	}

	/**
	 * @author Aravind
	 * @param driver
	 * @param url
	 */
	public static void launchApp(String url) {
		System.out.println("launching the applicaiton " + url);
		driver.get(url);
		validatePage("actiTIME - Login");
	}

	/**
	 * default username is admin and password is manager
	 * 
	 * @author Aravind
	 * @param username
	 * @param password
	 */
	public static void login(String username, String password) {
		System.out.println(" Logging in to the application using " + username + " and " + password);
		typeOnElement("id", "username", username);
		typeOnElement("name", "pwd", password);
		clickOnElement("id", "loginButton");
		myWait();
		validatePage("actiTIME - Enter Time-Track");

	}

	private static void myWait() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void clickOnModule(String name) {
		System.out.println("Clicking on the module " + name);
		// driver.findElement(By.xpath("//a[div[text()='" + name + "']]")).click();
		clickOnElement("xpath", "//a[div[text()='" + name.toUpperCase() + "']]");
		
		switch (name.toLowerCase()) {
		case "tasks":
			validatePage("actiTIME - Task List");
			break;
		case "reports":
			validatePage("actiTIME - Reports Dashboard");
			break;
		case "timetrack":
			validatePage("actiTIME - Enter Time-Track");
			break;
		case "users":
			validatePage("actiTIME - User List ");
			break;
			
		}
	}

	public static void clickOnCreateCustomerButton() {
		System.out.println("clicking on New Customer from Tasks Page");

		clickOnElement("xpath", "//div[@class='addNewContainer']");
		clickOnElement("xpath", "//div[contains(text(),'New Customer')]");
	
		String textOnScreen = getTextOnElement("id", "customerLightBox_titlePlaceholder");	
		
		if(textOnScreen.equals("Create New Customer"))
		{
			System.out.println("Create customer page is displayed...");
		}
		else
		{
			System.out.println("******************FAILED TO OPEN CREATE CUSTOMER PAGE************");
		}

	}

}
