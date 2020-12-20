package com.qa.flipkart.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.flipkart.base.Testbase;

public class Testutil extends Testbase{
	
	public static long PAGE_LOAD_TIMEOU= 30;
	public static long IMPLICIT_WAIT=40;

	public static String path="C:\\Users\\shree\\eclipse-workspace\\FlipkartDem\\ExcelDetails\\FlipkartTestdata.xlsx";
public static	Workbook book=null;
public static org.apache.poi.ss.usermodel.Sheet sheet;
	
	public static Object [][] gettestdata(String sheetname){
		FileInputStream fis=null;
		
		try {
         fis=new FileInputStream(path);
		} catch (FileNotFoundException e) {
		}
		
		try {
			 book= WorkbookFactory.create(fis);
		} catch (InvalidFormatException e) {
		} catch (IOException e) {
		
		}
		
		 sheet=book.getSheet(sheetname);
		 
		 Object[][] data =new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		 
		 for(int i=0;i<sheet.getLastRowNum();i++) {
		for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
			
			data[i][k]=sheet.getRow(i+1).getCell(k).toString();
						
		}
		 }
		 return data;
	}
	
	public static void takescreenshotAtEnd() { 
		
		TakesScreenshot tk= ((TakesScreenshot)driver);
		
		 File src =tk.getScreenshotAs(OutputType.FILE);
		 
		String dest=System.getProperty("user.dir");
		 
		 try {
			FileUtils.copyFile(src, new File(dest +"/screenshot/"+System.currentTimeMillis() +".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
	}
	
}
