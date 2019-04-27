package com.learning.basics.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public static void main(String[] args) throws IOException 
	{
	
		getMyConfigValue(("url"));
		getMyConfigValue(("username"));
		getMyConfigValue(("password"));
		getMyConfigValue(("browser"));
		getMyConfigValue(("timeout"));
	
	}

	public static String getMyConfigValue(String key)
	{
		String value = null;
		try
		{
			File file = new File("data\\config.properties");
			FileInputStream fis =  new FileInputStream(file);
			Properties props =  new Properties();
			props.load(fis);
			
			value = props.getProperty(key);
			System.out.println("Got " + value +  " for the key "  +key);
			fis.close();
		}
		catch(Exception ex)
		{
			System.out.println("Exception while reading a file..");
		}
		return value;
	}
	
	
	
	
	
	
}
