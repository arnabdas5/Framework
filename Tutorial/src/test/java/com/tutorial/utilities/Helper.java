package com.tutorial.utilities;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper 
{
	public static void cptrscreenshot(WebDriver Driver)
	{
		File src =((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
		try 
		{
			FileHandler.copy(src, new File("./screenshots/login.png"));
		}
		catch(Exception e)
		{
			System.out.println("Unable to cature screenhsot");
		}
	}
	
}
