Feature: Logging in and opening a new account, transferrign funds between accounts, and submitting a customer care form

Background:
	Given user navigates to Para Bank website
	And user enters a valid username
	And user enters a valid password
	When clicks the Log In button
	Then user is taken to Accounts Overview page
	
Scenario: Submit a Customer Care Form
	Given user clicks on Customer Care Form button
	And user enter name
	And user enter email 
	And user enter phone
	And user enter message
	When presses button to Send To Customer Care
	Then message is successfully sent
	