package com.tutorial.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Loginpage
{
	WebDriver driver;
	public void loginpage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(name="uid") WebElement uname;
	@FindBy(name="password") WebElement pwd;
	@FindBy(name="btnLogin") WebElement login;

	public void logintoGTPL(String username,String password)
	{
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		uname.sendKeys(username);
		pwd.sendKeys(password);
		login.click();
	}
	
}
