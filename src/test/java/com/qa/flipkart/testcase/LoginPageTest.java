package com.qa.flipkart.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.flipkart.base.Testbase;
import com.qa.flipkart.pages.Homepage;
import com.qa.flipkart.pages.Loginpage;

public class LoginPageTest extends Testbase{
	Loginpage loginPage;
	Homepage homepage;
	
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod
	
	public void setup() {
		initilization();
	loginPage=new Loginpage();
	}
	
	@Test(priority = 1,enabled = false)
	
	public void Logintitle() {
		String title=loginPage.ValidateLoginPagetitle();
	Assert.assertEquals(title,"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}

	@Test(priority = 2,enabled = false)
	public void LoginLogovalidate() {
		boolean data=loginPage.loginlogo();
	Assert.assertEquals(data,true);
	}
	
	@Test(priority = 3,enabled = true)
	public void Login() {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homepage=loginPage.Logindetails(prop.getProperty("username"),prop.getProperty("password"));

	}
	
	@AfterMethod
	public void teardown() {
		//driver.quit();
	}
	


	
		
	}

