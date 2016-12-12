Feature: As a User I want to check loggin proccess and validation errors.

Scenario: Sucessfull login with the user "user1"

Given User is on Signup screen
When User enter user1 details
And User login
Then loggin successfull

Scenario: Sucessfull login with the user "admin"

Given User is on Signup screen
When User enter admin details
And User login
Then loggin successfull

Scenario: Sucessfull login with the user "user1"

Given User is on Signup screen
When User enter user1 details
And User login
Then loggin successfull

Scenario: Check show password button 

Given User is on Signup screen
When User enter user1 details
And User show password
Then password appears

Scenario: Login with empty password

Given User is on Signup screen
When User enter user1 email 
And User login
Then validation error appears

Scenario: Login with a too short password

Given User is on Signup screen
When User enter user1 email
And User enter short password
And User login  
Then validation error appears

Scenario: Login with a invalid email

Given User is on Signup screen
When User enter invalid email
And User login  
Then validation error appears

Scenario: Login with a empty mail and password

Given User is on Signup screen
When User login  
Then validation error appears


Scenario: Login with a empty mail and password

Given User is on Signup screen
When User enter password
And User login  
Then validation error appears








