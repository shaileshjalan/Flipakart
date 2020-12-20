package com.qa.flipkart.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.internal.ThreeStateBoolean;

import com.qa.flipkart.base.Testbase;
import com.qa.flipkart.pages.Homepage;
import com.qa.flipkart.pages.Loginpage;
import com.qa.flipkart.pages.MyProfilePage;
import com.qa.flipkart.pages.Personalinfo;
import com.qa.flipkart.util.Testutil;

public class MyProfilePageTest extends Testbase {

	Loginpage loginpgae;
	Homepage homepage;
	Testutil testutil;
    MyProfilePage mypage;
  
	
	public MyProfilePageTest() {
		super();
		
	}
	
	
	@BeforeMethod
	public void setup() {
		initilization();
		loginpgae  =new Loginpage();
		homepage=loginpgae.Logindetails(prop.getProperty("username"),prop.getProperty("password"));
		 mypage=new MyProfilePage();
	    testutil=new Testutil();
	}
	
	@DataProvider
	public  Object[][] getTestdata() {
		Object[][] data= testutil.gettestdata("Data1");
		return data;
	 
	}
	
	@Test(priority = 1,dataProvider = "getTestdata")
	public void Enterdetails(String FirstN,String LastN) {
		homepage.NavigatetoMyProfile();
	try {
		Thread.sleep(20000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	mypage.clikOnEditbuttonEnterdata(FirstN,LastN);
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
