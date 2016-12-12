@smoke
Feature: As a User I need to check the Admin user token

Scenario: Check admin user token

Given User logged
When show token 
Then Compare the user token