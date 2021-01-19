Feature: Login

Scenario: Successful Login with Valid Credentials

	Given User Launch Chrome browser
	When User opens URL "https://admin-demo.nopcommerce.com/"
	And User enter Email as "admin@yourstore.com" and Password as "admin"
	And click on Login
	Then Page Title should be "Dashboard / nopCommerce administration"
	When User click on Logout link
	Then Page Title should be "Your store. Login"
	And close browser
	