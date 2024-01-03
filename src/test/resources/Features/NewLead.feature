@Newlead
Feature: NewLead Functionality

@new
Scenario: verifylogin_TC01
Given User should be on login page
When user perform valid login
Then user should be navigated to home page

@lead
Scenario: click_on_NewLead_TC02
Given user should be on home page
When user click on new lead link and fill valid data and click on save button
|name   |company   |  
|Komal    |TTL     |
|Shraddha |Google  |
Then new lead should be created successfully




 