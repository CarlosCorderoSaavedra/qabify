Scenario: Login with a empty mail

Given User is on Signup screen
When User enter password
And User login
Then validation error appears
