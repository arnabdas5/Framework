package com.tutorial.utilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutilites 
{
		public static FileInputStream fi;
		public static FileOutputStream fo;
		public static XSSFWorkbook wb;
		public static XSSFSheet ws;
		public static XSSFRow wr;
	    public static XSSFCell wc;
	    
	    public static int getrowcount(String xlfile,String xlsheet) throws IOException
	    {
	    	fi=new FileInputStream(xlfile);
	    	wb=new XSSFWorkbook(fi);
	    	ws=wb.getSheet(xlsheet);
	    	int rcount=ws.getLastRowNum();
	    	wb.close();
	    	fi.close();
	    	return rcount;
	    }
	    public static int getcellcount(String xlfile,String xlsheet,int rownum) throws IOException
	    {
	    	fi=new FileInputStream(xlfile);
	    	wb=new XSSFWorkbook(fi);
	    	ws=wb.getSheet(xlsheet);
	    	wr=ws.getRow(rownum);
	    	int ccount=wr.getLastCellNum();
	    	wb.close();
	    	fi.close();
	    	return ccount;
	    }
	    public static String getcelldata(String xlfile,String xlsheet,int rownum,int cellnum) throws IOException 
	    {
	    	fi=new FileInputStream(xlfile);
	    	wb=new XSSFWorkbook(fi);
	    	ws=wb.getSheet(xlsheet);
	    	wr=ws.getRow(rownum);
	    	wc=wr.getCell(cellnum);
	    	String data;
	    	try {
	    		DataFormatter formatter = new DataFormatter();
	    		String celldata=formatter.formatCellValue(wc);
	    		return celldata;
	    	}
	    	catch(Exception e)
	    	{
	    		data="";
	    	}
	    	
	    	wb.close();
	    	fi.close();
	    	return data;
	    }
	    public static void setcelldata(String xlfile,String xlsheet,int rownum,int cellnum,String data) throws IOException
	    {
	    	fi=new FileInputStream(xlfile);
	    	wb=new XSSFWorkbook(fi);
	    	ws=wb.getSheet(xlsheet);
	    	wr=ws.getRow(rownum);
	    	wc=wr.createCell(cellnum);
	    	wc.setCellValue(data);
	    	fo= new FileOutputStream(xlfile);
	    	wb.write(fo);
	      	wb.close();
	    	fi.close();
	    	fo.close();
	    }
	    	
	    	
	    	
	    	
	    	
	    }


