Feature: GoogleSearch

Scenario Outline: Successful Search of a city on Google

	Given User Launch Chrome browser
	When User opens URL "https://www.google.com"
	Then Page Title should be "Google"
	And User enter city Name as "<city>"
	And press the Key Enter
	Then Page Title should be "<city> - Google "
	And close browser
	
	Examples:
			| city |
			|Bahamas|
			|Amsterdam|