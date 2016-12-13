Scenario: Login with empty password

Given User is on Signup screen
When User enter user1 email
And User login
Then validation error appears