package com.vtiger.stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;

import com.codoid.products.exception.FilloException;
import com.vtiger.common.CommonMethods;
import com.vtiger.pages.NewleadPage;
import com.vtiger.pages.NeworderPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewOrderStepDefinitions extends BaseTest 
{
	public CommonMethods cm;
	
	@Before
	public void getscenarioName(Scenario scenario) throws IOException, FilloException
	{
		initiation();
		TCName = scenario.getName();
		logger= extent.createTest(TCName);

	}
	
	@After
	public void savereport()
	{
		extent.flush();

	}

	@Given("User should be on login page")
	public void user_should_be_on_login_page() throws IOException, FilloException 
	{
		//launchapp();
		//initiation();
    }
	
	@When("user perform valid login")
	public void user_perform_valid_login() {
		NewleadPage np = new NewleadPage(driver);
		np.login(dt.get(TCName).get("Userid"), dt.get(TCName).get("Password"));
	}
	@Then("user should be navigated to home page")
	public void user_should_be_navigated_to_home_page() {
		driver.findElement(By.linkText("Home")).isDisplayed();
	}
	
	@Given("user should be on home page")
	public void user_should_be_on_home_page() {
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.name("Login")).click();
	    
	}
	
	@When("user click on new lead link and fill valid data and click on save button")
	public void user_click_on_new_lead_link_and_fill_valid_data_and_click_on_save_button(io.cucumber.datatable.DataTable dataTable) {
	    List<Map<String,String>> lst = dataTable.asMaps();
	    for(Map<String,String> map:lst)
	    {
	    driver.findElement(By.linkText("New Lead")).click();
	    driver.findElement(By.name("lastname")).sendKeys(map.get("name"));
		driver.findElement(By.name("company")).sendKeys(map.get("company"));
		driver.findElement(By.name("button")).click();
	    }
	    
	}
	
	@Then("new lead should be created successfully")
	public void new_lead_should_be_created_successfully() {
		//driver.findElement(By.name("Save")).click();    

	   }
	
	@When("User should move to showsubmenu")
	public void user_should_move_to_showsubmenu() 
	{
		
		NeworderPage no = new NeworderPage(driver);
		no.navigate();

	}
	@When("User should click on New Purches Order link")
	public void user_should_click_on_new_purches_order_link() 
	{
		NeworderPage no = new NeworderPage(driver);
		no.MouseclickNewPurchesOrder();
		
	}
	
	@Then("Enter subject name")
	public void enter_subject_name()
	{
		NeworderPage no = new NeworderPage(driver);
		no.enterSubjectName(dt.get(TCName).get("Subject"));
	}
	
	@Then("Enter billing address")
	public void enter_billing_address() 
	{
		NeworderPage no = new NeworderPage(driver);
		no.enterBillingAddress(dt.get(TCName).get("Billing Address"));
	    
	}
	
	@Then("Enter shipping address")
	public void enter_shipping_address()
	{
		NeworderPage no = new NeworderPage(driver);
		no.enterShippingAddress(dt.get(TCName).get("Shipping Address"));
	}
	@Then("Click on chnage button")
	public void click_on_chnage_button() {
	   
	}
	
	@Then("New purches order should create")
	public void new_purches_order_should_create() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
	
	/*@When("User click on NewPurchesOrder link")
	public void user_click_on_new_purches_order_link() 
	{
		cm = new CommonMethods(driver);
		
	}
	
	@When("enter subject")
	public void enter_subject() 
	{
	    driver.findElement(By.xpath("subject")).sendKeys("Testing");
	}
	@When("enter vendor name")
	public void enter_vendor_name() 
	{
	    driver.findElement(By.xpath("vendor name")).sendKeys("xyz");
	}*/
	

}