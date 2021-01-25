Feature: Logging in and opening a new account, transferrign funds between accounts, and submitting a customer care form

Background:
	Given user navigates to Para Bank website
	And user enters a valid username
	And user enters a valid password
	When clicks the Log In button
	Then user is taken to Accounts Overview page
	
Scenario: Transfer funds between accounts
	Given user clicks on link to Transfer Funds
	And user enters amount and account to choose
			| 20000 | 14121 | 14121 |
	When click the Transfer button
	Then the transfer should be successful
	