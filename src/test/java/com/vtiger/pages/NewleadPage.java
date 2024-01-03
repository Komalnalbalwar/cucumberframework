package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.common.CommonMethods;

public class NewleadPage {
	
	public WebDriver driver;
	public CommonMethods cm;
	
	public NewleadPage(WebDriver driver)           
	{
		this.driver = driver;  
		PageFactory.initElements(driver, this);
		cm = new CommonMethods(driver);
	}
	
	@FindBy(xpath="//input[@name='user_name']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='user_password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='Login']")
	WebElement login;
	
	@FindBy(xpath="//a[text()='New Lead']")
	WebElement lnkNewlead;
	
	public void login(String userid,String pwd)
	{
		
		cm.enterValue(username, userid, "Username entered successfully");
		cm.enterValue(password, pwd, "Password entered successfully");
		cm.clickElement(login, "Login button clicked");

	}
	
	public void clickNewlead()
	{
		cm.clickElement(lnkNewlead, "Newlead link clicked");
	}

}
