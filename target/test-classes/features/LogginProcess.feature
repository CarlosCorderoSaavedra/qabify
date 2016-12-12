Feature: As a User I want to check loggin proccess and validation errors.

Scenario: Sucessfull login with the user "user1"

Given User is on Signup screen
When Users enter user1 details
And Users login
Then loggin successfull

Scenario: Sucessfull login with the user "admin"

Given User is on Signup screen
When Users enter admin details
And Users login
Then loggin successfull

Scenario: Sucessfull login with the user "user1"

Given User is on Signup screen
When Users enter user1 details
And Users login
Then loggin successfull

Scenario: Check show password button 

Given User is on Signup screen
When Users enter user1 details
And Users show password
Then password appears

Scenario: Login with empty password

Given User is on Signup screen
When Users enter user1 email 
And Users login
Then validation error appears

Scenario: Login with a too short password

Given User is on Signup screen
When Users enter user1 email
And Users enter short password
And Users login  
Then validation error appears

Scenario: Login with a invalid email

Given User is on Signup screen
When Users enter invalid email
And Users login  
Then validation error appears

Scenario: Login with a empty mail and password

Given User is on Signup screen
When Users login  
Then validation error appears


Scenario: Login with a empty mail and password

Given User is on Signup screen
When Users enter password
And Users login  
Then validation error appears








