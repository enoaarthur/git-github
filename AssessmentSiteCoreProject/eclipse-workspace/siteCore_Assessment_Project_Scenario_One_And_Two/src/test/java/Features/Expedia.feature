Feature: SearchFlightsInExpedia

Scenario: Search A Flight Trip on Expedia

	Given User Launch A New Chrome browser
	When User navigate to URL "https://www.expedia.com/"
	And click on Link Text "Flights"
	And Enter a valid departure as " Brussels" And valid destination as " New York"
	And Add a child of 3 Years old for the flight
	And click on search Button 
	Then The page title should be "BRU to JFK flights"
	And close the new browser
	