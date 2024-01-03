package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.common.CommonMethods;

public class HomePage {
	
	public WebDriver driver;
	public CommonMethods cm;
	
	public HomePage(WebDriver driver)           
	{
		this.driver = driver;  
		PageFactory.initElements(driver, this);
		cm = new CommonMethods(driver);
	}
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement lnkLogout;
	
	public void verifyLogout()
	{
		cm.elementExist(lnkLogout, "Logo displayed");
	}
	
	public void clickLogout()
	{
		cm.clickElement(lnkLogout, "Logout link clicked");
	}


}
