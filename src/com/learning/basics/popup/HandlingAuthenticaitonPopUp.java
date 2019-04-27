package com.learning.basics.popup;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.learning.basics.utils.ActitimeUtils;

public class HandlingAuthenticaitonPopUp
{
	public static void main(String[] args)
	{
		try 
		{
			Runtime.getRuntime().exec("D:\\Eclipse_WS\\Intellipaat_10_March\\autoItScripts\\authenticationHandler.exe");
			Thread.sleep(2000);
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Main Started...");
		WebDriver driver =  ActitimeUtils.getMyDriver("ff");
		driver.get("https://www.engprod-charter.net/");
		
	}

}
