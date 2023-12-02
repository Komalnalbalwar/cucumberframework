@ATH
Feature: Login Functionality

Background:
Given user is on login page


Scenario: valid login
When user enters valid userid 
And enters valid password 
And click on login button
Then user should be navigated to home page
And user can see logout link
And close browser

@Komal
Scenario: Invalid login
When user enters invalid userid 
And enters valid password 
And click on login button
Then user should be navigated to login page
And user can see the error message
And close browser

@Dev
Scenario Outline: Invalid login with multiple user
When user enters invalid userid as "<userid>"
And enters valid password as "<password>"
And click on login button
Then user should be navigated to login page
And user can see the error message
And close browser
Examples:
| userid | password |
| admin1 | pass1 |
| admin2 | pass2 |
| admin3 | pass3 |
| admin4 | pass4 |

@Audi
Scenario:
Given user should be on home page
When user click on new lead lin and fill valid data and click on save button
|name   |company   |  
|Komal    |TTL     |
|Shraddha |Google  |
Then new lead should be created successfully