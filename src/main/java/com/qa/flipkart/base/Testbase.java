package com.qa.flipkart.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.qa.flipkart.util.Testutil;
import com.qa.flipkart.util.webdriverlistener;

public class Testbase {
	
	public static  	EventFiringWebDriver event;
public static	webdriverlistener listernar;

	public static WebDriver driver;
	public	static Properties prop;
	
	public Testbase() {
		
		prop =new Properties();
		
		try {
			FileInputStream fis=new FileInputStream("C:\\Users\\shree\\eclipse-workspace\\FlipkartDem\\src\\main\\java\\com\\qa\\flipkart\\config\\config.properties");
		
			prop.load(fis);
		} catch (Exception e) {
			
		/*	e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		}
	}
	
	public static void initilization() {
		
		String Browsernam=prop.getProperty("browser");
		if(Browsernam.equals("chrome")) {
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\shree\\eclipse-workspace\\Cucumber\\src\\test\\java\\Cucumber\\resource\\chromedriver.exe");
			 driver =new ChromeDriver();
			 
               event=new EventFiringWebDriver(driver);
			
	        listernar=new webdriverlistener();
	        event.register(listernar);
	           driver=event;
			  
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOU, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		 	driver.get(prop.getProperty("url"));
			
		}
	
	}
}
	
	
	
	 



