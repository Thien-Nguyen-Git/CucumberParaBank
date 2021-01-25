Feature: Logging in and opening a new account, transferrign funds between accounts, and submitting a customer care form

Background:
	Given user navigates to Para Bank website
	And user enters a valid username
	And user enters a valid password
	When clicks the Log In button
	Then user is taken to Accounts Overview page
	
Scenario: Open a new account
	Given user clicks on Open New Account Link
	And user chooses what account type they want
	And user chooses what account to deposit money into 
	When clicks the Open New Account button
	Then the new account is succesfully opened
	