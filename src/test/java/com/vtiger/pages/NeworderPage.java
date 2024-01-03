package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.common.CommonMethods;

public class NeworderPage {
	
	public WebDriver driver;
	public CommonMethods cm;
	
	public NeworderPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		cm = new CommonMethods(driver);
	}
	@FindBy(xpath="//a[@id='showSubMenu']")
	WebElement navigate;
	
	@FindBy(xpath="//a[text()='New Purchase Order']")
	WebElement lnkNewPurchesOrder;
	
	@FindBy(xpath="//input[@name='subject']")
	WebElement subject;
	
	@FindBy(xpath="//textarea[@name='bill_street']")
	WebElement billing;
	
	@FindBy(xpath="//textarea[@name='ship_street']")
	WebElement shipping;
	
	@FindBy(xpath="//input[@value='Change'][1]")
	WebElement vname;
	
	
	
	public void navigate()
	{
		cm.mouseHover(navigate);
		
	}
	
	public void MouseclickNewPurchesOrder()
	{
		cm.MouseClick(lnkNewPurchesOrder, "link clicked");
	}
	
	public void enterSubjectName(String sub)
	{
		cm.enterValue(subject, sub, "Subject entered successfully");

	}
	
	public void enterBillingAddress(String bill)
	{
		cm.enterValue(billing, bill, "Bill address entered successfully");
	}
	
	public void enterShippingAddress(String ship)
	{
		cm.enterValue(shipping, ship, "Shipping address entered successfully");

	}
	public void elementClickvname()
	{
		cm.clickElement(vname, "Element clicked successfully");
	}
	
	

	
	
	/*public void data(String sub,String vname)
	{
		cm.enterValue(subject, sub, "Subject entered successfully");
		//driver.findElement(By.xpath("subject")).sendKeys("Testing");
		cm.enterValue(vendorname, vname, "Vendor name entered successfully");
		//driver.findElement(By.xpath("vendor name")).sendKeys("xyz");

		
	}*/


	

}
