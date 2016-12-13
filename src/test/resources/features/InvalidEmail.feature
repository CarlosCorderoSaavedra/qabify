
Scenario: Login with a invalid email

Given User is on Signup screen
When User enter invalid email
And User login
Then validation error appears