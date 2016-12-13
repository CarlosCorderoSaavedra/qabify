Scenario: Login with a too short password

Given User is on Signup screen
When User enter user1 email
And User enter short password
And User login
Then validation error appears