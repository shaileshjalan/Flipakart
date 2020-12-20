package com.qa.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.flipkart.base.Testbase;

public class Loginpage extends Testbase {
	
	//page factory
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	
	WebElement LoginButton;
	
    @FindBy(xpath="(//input[contains(@type,\"text\")])[2]")
 
    WebElement username;
    
    
    @FindBy(xpath = "//input[contains(@type,'password')]")
    
    WebElement password;
    
 @FindBy(xpath = "(//button[contains(@type,'submit')])[2]")
    
    WebElement Loginbutton ;
 
 @FindBy(xpath="//img[contains(@src,\"//img1a.flixcart.com/www/linchpin/fk-cp-zion/img/flipkart-plus_\")]")
  WebElement MainLogo;
 

 
 //initlize the OR
 public Loginpage() {
 PageFactory.initElements(driver, this);

 }
//actions
 
 public String ValidateLoginPagetitle() {
	 return driver.getTitle();
 }
 
 public boolean loginlogo() {
	 
	 return MainLogo.isDisplayed();
 }
	 
	 public Homepage Logindetails(String un,String pwd) {
		 username.sendKeys(un);
		 password.sendKeys(pwd);
		 Loginbutton.click();		 
		return new Homepage(); 	  
	 }
	 
 }
    
