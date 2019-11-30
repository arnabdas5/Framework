package com.tutorial.testcases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.tutorial.utilities.BrowserFactory;
import com.tutorial.utilities.ConfigUtilities;
import com.tutorial.utilities.Excelutilites;
import com.tutorial.utilities.Helper;

public class Baseclass 
{
	public WebDriver driver;
	public ConfigUtilities config;
	public ExtentReports report;
	public ExtentTest logger;
	@BeforeSuite
	public void setupsuite()
	{
		config= new ConfigUtilities();
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File("./reports/report.html"));
		report =new ExtentReports();
		report.attachReporter(extent);
			
	}
	@BeforeClass
	public void setup()
	{
		driver=BrowserFactory.startapp(driver, config.getbrowser(), config.geturl());
		//System.out.println(driver.getTitle());
		
	}
	
	@DataProvider(name="logindata")
	public String[][] getdata() throws IOException 
	{
		String path= "./Testdata/Testdata.xlsx";
		int rnum=Excelutilites.getrowcount(path,"Sheet1");
		int col=Excelutilites.getcellcount(path, "Sheet1",1);
		String logindata[][]=new String[rnum][col];
		for(int i=1;i<=rnum;i++) 
		{
			for(int j=0;j<col;j++) 
			{
				logindata[i-1][j]=Excelutilites.getcelldata(path, "Sheet1",i,j);
			}
		}
		return logindata;
	}
	@AfterClass
	public void teardown()
	{
		BrowserFactory.quitbrowser(driver);
	}
	
	@AfterMethod
	public void teardownmethod(ITestResult result )
	{
		
		if(result.getStatus()== ITestResult.SUCCESS)
			Helper.cptrscreenshot(driver);
		report.flush();
	}
}
