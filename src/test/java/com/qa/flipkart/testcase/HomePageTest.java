package com.qa.flipkart.testcase;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.flipkart.base.Testbase;
import com.qa.flipkart.pages.Homepage;
import com.qa.flipkart.pages.Loginpage;
import com.qa.flipkart.pages.MyProfilePage;

public class HomePageTest extends Testbase {
	Homepage homepage;
	Loginpage loginPage;
	
	MyProfilePage myProfilePage;
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initilization();
		loginPage=new Loginpage();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homepage=loginPage.Logindetails(prop.getProperty("username"),prop.getProperty("password"));

		
	}
	@Test(priority = 1,enabled = true)
	public void verifyThetitefterlogin() {
		
		String name =homepage.VerifyUser();
		Assert.assertEquals(name, "shailesh");
		
	}
	
	@Test(priority = 2,enabled = true)
	public void MyprofileTab() {
		myProfilePage=homepage.NavigatetoMyProfile();
		
	}
	
	
	@AfterMethod
	public void Teardown() {
		driver.quit();
	}
}
