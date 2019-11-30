package com.tutorial.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigUtilities 
{
	
	Properties pro;
		
		public ConfigUtilities() {
			File fl=new File("./config/config.properties");
			try {
				FileInputStream fc=new FileInputStream(fl);
				pro=new Properties();
				pro.load(fc);
			}
			catch(Exception e) {
				System.out.println("File Not found");
			}
			
			
		}
		
		public String getbrowser() {
			String username=pro.getProperty("Browser") ;
			return username;
		}
		
		
		
		public String geturl() {
			String ul=pro.getProperty("Url") ;
			return ul;
		}
		

	}


