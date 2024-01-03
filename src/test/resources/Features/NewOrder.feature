@Orders
Feature: New order flow

@purchesorder
Scenario: click_on_NewPurchesOrder_TC05
Given user should be on home page
When User should move to showsubmenu
And User should click on New Purches Order link
Then Enter subject name 
And Enter billing address
Then Enter shipping address
Then Click on chnage button