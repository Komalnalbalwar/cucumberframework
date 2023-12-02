package com.vtiger.stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.codoid.products.exception.FilloException;
import com.vtiger.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDefinitions extends BaseTest {
	
	
	@Before
	public void getscenarioName(Scenario scenario) throws IOException, FilloException
	{
		initiation();
		TCName = scenario.getName();
		//logger = extent.createTest(TCName);
		logger= extent.createTest(TCName);

	}
	
	@After
	public void savereport()
	{
		extent.flush();

	}
	
	//public WebDriver driver;
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://localhost:100");    
	}
	
	
	@Given("User should be on login page")
	public void user_should_be_on_login_page() throws IOException, FilloException {
		launchapp();
	}
	@When("user perform valid login")
	public void user_perform_valid_login() {
		LoginPage lp = new LoginPage(driver);
		lp.login(dt.get(TCName).get("Userid"), dt.get(TCName).get("Password"));
	}
	
	@When("user perform invalid login")
	public void user_perform_invalid_login() {
		LoginPage lp = new LoginPage(driver);
		lp.login(dt.get(TCName).get("Userid"), dt.get(TCName).get("Password"));
	}
	
	@Then("user should validate error message")
	public void user_should_validate_error_message() {
		LoginPage lp = new LoginPage(driver);
		lp.verifyErrorMsg();

	}
	
	@Then("user should validate logo")
	public void user_should_validate_logo() {
		LoginPage lp = new LoginPage(driver);
		lp.verifyLogo();
	}

	@When("user enters valid userid")
	public void user_enters_valid_userid() {
		driver.findElement(By.name("user_name")).sendKeys("admin");
	}
		
	@When("user enters invalid userid")
	public void user_enters_invalid_userid() {
		driver.findElement(By.name("user_name")).sendKeys("admin123");    
	}
	
	@When("enters valid password")
	public void enters_valid_password() {
		driver.findElement(By.name("user_password")).sendKeys("admin");    
	}
	
	@When("click on login button")
	public void click_on_login_button() {
		driver.findElement(By.name("Login")).click();    
	}
	
	@Then("user should be navigated to home page")
	public void user_should_be_navigated_to_home_page() {
		driver.findElement(By.linkText("Home")).isDisplayed();
	}
		
	@Then("user should be navigated to login page")
	public void user_should_be_navigated_to_login_page() {
		driver.findElement(By.name("user_password")).isDisplayed();    
	}
	
	@Then("user can see logout link")
	public void user_can_see_logout_link() {
		driver.findElement(By.linkText("Logout")).isDisplayed();
	}
		
	@Then("user can see the error message")
	public void user_can_see_the_error_message() {
		driver.findElement(By.xpath("//*[contains(text(),'You must specify a valid username and password.')]")).isDisplayed();
	    
	}
	
	@And("close browser")
	public void close_browser() {
		driver.quit();
	    
	}
	
	@When("user enters invalid userid as {string}")
	public void user_enters_invalid_userid_as(String uid) {
		driver.findElement(By.name("user_name")).clear();
		driver.findElement(By.name("user_name")).sendKeys(uid);

	}
	
	@When("enters valid password as {string}")
	public void enters_valid_password_as(String pwd) {
		driver.findElement(By.name("user_password")).clear();
		driver.findElement(By.name("user_password")).sendKeys(pwd);    

	}
	
	@Given("user should be on home page")
	public void user_should_be_on_home_page() {
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.name("Login")).click();
	    
	}
	@When("user click on new lead lin and fill valid data and click on save button")
	public void user_click_on_new_lead_lin_and_fill_valid_data_and_click_on_save_button(io.cucumber.datatable.DataTable dataTable) {
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
	
	




}
