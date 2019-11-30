package com.tutorial.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory
{
	public static WebDriver startapp(WebDriver driver, String browser, String url)
	{
		if(browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver=new ChromeDriver();
			driver.get(url);
			
		}
		else if(browser.equals("Firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "./drivers/geckodriver.exe");
			driver=new FirefoxDriver();
			driver.get(url);
		}
		else 
		{
			System.out.println("We dont support this browser");
		}
		driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		
		
		return driver;
	}
	public static void quitbrowser(WebDriver driver)
	{
		driver.quit();
	}
	
	
}
