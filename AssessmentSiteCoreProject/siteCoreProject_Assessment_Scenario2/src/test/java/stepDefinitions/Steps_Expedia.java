
/*
 * This is where the steps defined in the feature file are implemented
 * the class needs the object ExpediaPage in order to achieve its goal
 */

package stepDefinitions;


import io.cucumber.java.en.*;
import pageObjects.ExpediaPage;
import utilities.Utilities;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Steps_Expedia {
	public WebDriver driver;
	public ExpediaPage lp2;
	
	
	// 1st step we launch the Chrome browser with the help of chrome driver
	@Given("User Launch A New Chrome browser")
	public void user_launch_a_new_chrome_browser() {
		System.setProperty("webdriver.chromer.driver", Utilities.DRIVER_LOCATION);
		driver = new ChromeDriver();
	   lp2 = new ExpediaPage(driver);
	}

	// 2nd step that will get the expedia.com page and elarge it
	@When("User navigate to URL {string}")
	public void user_navigate_to_url(String url) throws InterruptedException {
		System.out.println("New Expedia Features");
		
		driver.get(url);
		Thread.sleep(1000);
		driver.manage().window().maximize();
	}
	
	// This is the last step that close the driver and also quit it to close
	// all the drivers opened for this scenario and thus free the disk space
	// very useful if you want to keep your disk safe  
	@Then("close the new browser")
	public void close_browser() throws IOException, InterruptedException {
		Thread.sleep(1000);
		driver.close();
		driver.quit();
		
	
	}
	
	
	// Step that will lead us to the Flight tab
	@When("click on Link Text {string}")
	public void click_on_link_text(String string) throws InterruptedException {
	   lp2.clickOnFlightLink();
	   Thread.sleep(3000);
	}
	
	
	//Step where will set the departure and the destination of our Flight
	// In our scenario that will be respectively Brussels and New-York
	@When("Enter a valid departure as {string} And valid destination as {string}")
	public void enter_a_valid_departure_as_and_valid_destination_as(String dep, String dest) throws InterruptedException {
		
		Thread.sleep(200);
	    lp2.setDepAndDestSearKeys(dep, dest);
	}
	
	
	// This is where we implement the step that launch our search 
	@When("click on search Button")
	public void click_on_search_button() throws InterruptedException {
		Thread.sleep(3000);
	   lp2.clickOnSubmit();
	   
	}
	
	//Step that add a child of 3 yrs old in the traveler options. The functions needs
	// the age of the child as a parameter
	@When("Add a child of {int} Years old for the flight")
	public void add_a_child_of_years_old_for_the_flight(Integer age) throws InterruptedException {
	    Thread.sleep(2000);
	    lp2.addAChild();
	    Thread.sleep(2000);
	    lp2.selectAChildOf3Yrs();
	}
	
	// The method that will select any date in 3 months; The parameter is an offset that 
	//represents the number of months after which we want to flight
	@When("select date in the calendar in {int} months")
	public void select_date_in_the_calendar_in_months(Integer monthOffset) throws InterruptedException {
	      
	      lp2.setDate(monthOffset);
	}
	
	// The method that implements the step where we select the accommodations
	@When("Select an accommodation corresponding to the dates of the flights")
	public void select_an_accommodation_corresponding_to_the_dates_of_the_flights() throws InterruptedException {
		lp2.clickOnStayLink();
		Thread.sleep(3000);
	}
	
	// The scenario is successful if the last page is the page with the flights options
	// as required. This page has as title "{string}"receive from the feature file in our 
	//case "BRU to NYC Flights | Expedia"
	@Then("The page title should be {string}")
	public void the_page_title_should_be(String title) {
		
		System.out.println("Page title is: "+driver.getTitle());
		Assert.assertEquals(title, driver.getTitle());
	}


}
