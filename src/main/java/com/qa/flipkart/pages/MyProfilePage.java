package com.qa.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.flipkart.base.Testbase;

public class MyProfilePage extends Testbase{
	
	@FindBy(xpath="//input[contains(@name,'firstName')]")
	WebElement Firstname;
	
	@FindBy(xpath="//input[contains(@name,'lastName')]")
	
	WebElement Lastname;
	
	public MyProfilePage() {
		PageFactory.initElements(driver,this);
	}
	
	public void clikOnEditbuttonEnterdata(String Firstna,String Lastna) {
		Firstname.clear();
		Firstname.sendKeys(Firstna);
		Lastname.clear();
		Lastname.sendKeys(Lastna);
	   
	
	}
     
}
