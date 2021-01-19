Feature: SearchFlightsInExpedia

Scenario: Search A Flight Trip on Expedia

	Given User Launch A New Chrome browser
	When User navigate to URL "https://www.expedia.com/"
	And click on Link Text "Flights"
	And Enter a valid departure as " Brussels" And valid destination as " New York"
	And Add a child of 3 Years old for the flight
	And select date in the calendar in 3 months 
	And Select an accommodation corresponding to the dates of the flights
	And click on search Button 
	Then The page title should be "BRU to NYC Flights |Expedia"
	And close the new browser
	