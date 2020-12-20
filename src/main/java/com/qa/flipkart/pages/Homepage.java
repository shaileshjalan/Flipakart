package com.qa.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.flipkart.base.Testbase;

public class Homepage extends Testbase {

	@FindBy(xpath="//div[contains(text(),'shailesh')]")
	 WebElement loginuser;

	@FindBy(xpath="//a[contains(@href,'/account/?rd=0&link=home_account')]")
    WebElement Myprofile;

	
	@FindBy(xpath="//span[(@class='oKZoMV')]")
	
	WebElement editlink;
	
	public Homepage() {
		PageFactory.initElements(driver, this);
	}
public String VerifyUser() {

	return loginuser.getText();
}
	public MyProfilePage NavigatetoMyProfile(){
		
		Actions action=new Actions(driver);
		action.moveToElement(loginuser).build().perform();
		Myprofile.click();
		editlink.click();
		return new MyProfilePage();
		
	}

}

