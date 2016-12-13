Feature: As a User I want to check logged screen actions

Scenario: Check the user token its correct

Given User logged
When Users show token   
Then Token its the same
