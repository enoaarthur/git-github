#Here below the differents steps that will be executed to implement the first scenario
#which is search the city 'Bahamas' on google
#We use the 'Scenario Outline' in order to expand the scenario to search another city like Amsterdam
#The parameter we use here is <city> and in the exemples are given in  a table the cities that will be 
#used as input data

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