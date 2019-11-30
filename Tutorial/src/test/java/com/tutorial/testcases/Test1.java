package com.tutorial.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


import com.tutorial.pageobjects.Loginpage;

public class Test1 extends Baseclass
{
	
	@Test(dataProvider= "logindata")
	public void login(String username, String password) 
	{
		logger=report.createTest("GTPL login");
		Loginpage loginobj =PageFactory.initElements(driver, Loginpage.class);
		logger.info("Staring login process");
		loginobj.logintoGTPL(username, password);
		logger.pass("Passed");
		
	}
	
	

}
