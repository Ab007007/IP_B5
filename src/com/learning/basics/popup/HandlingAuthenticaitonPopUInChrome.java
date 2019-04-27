package com.learning.basics.popup;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.learning.basics.utils.ActitimeUtils;

public class HandlingAuthenticaitonPopUInChrome
{
	public static void main(String[] args)
	{
		try 
		{
			Runtime.getRuntime().exec("D:\\Eclipse_WS\\Intellipaat_10_March\\autoItScripts\\authenticationHandlerForChrome.exe");
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
		WebDriver driver =  ActitimeUtils.getMyDriver("chrome");
		driver.get("https://www.engprod-charter.net/");
		
		
	}

}
