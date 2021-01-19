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
	
	@Given("User Launch A New Chrome browser")
	public void user_launch_a_new_chrome_browser() {
		System.setProperty("webdriver.chromer.driver", Utilities.DRIVER_LOCATION);
		driver = new ChromeDriver();
	   lp2 = new ExpediaPage(driver);
	}

	
	@When("User navigate to URL {string}")
	public void user_navigate_to_url(String url) throws InterruptedException {
		System.out.println("New Expedia Features");
		
		driver.get(url);
		Thread.sleep(1000);
		driver.switchTo().parentFrame();
		driver.manage().window().maximize();
	}
	
	@Then("close the new browser")
	public void close_browser() throws IOException, InterruptedException {
		Thread.sleep(1000);
		//driver.close();
	}
	
	@When("click on Link Text {string}")
	public void click_on_link_text(String string) throws InterruptedException {
	   lp2.clickOnFlightLink();
	   Thread.sleep(3000);
	}
	
	@When("Enter a valid departure as {string} And valid destination as {string}")
	public void enter_a_valid_departure_as_and_valid_destination_as(String dep, String dest) throws InterruptedException {
		
		Thread.sleep(200);
	    lp2.setDepAndDestSearKeys(dep, dest);
	}
	
	@When("click on search Button")
	public void click_on_search_button() throws InterruptedException {
		Thread.sleep(3000);
	   lp2.clickOnSubmit();
	   
	}
	
	@When("Add a child of {int} Years old for the flight")
	public void add_a_child_of_years_old_for_the_flight(Integer age) throws InterruptedException {
	    Thread.sleep(2000);
	    lp2.addAChild();
	    Thread.sleep(2000);
	    lp2.selectAChildOf3Yrs();
	}
	
	@When("select date in the calendar in {int} months")
	public void select_date_in_the_calendar_in_months(Integer monthOffset) throws InterruptedException {
	      
	      lp2.setDateDep(monthOffset);
	}
	
	@When("Select an accommodation corresponding to the dates of the flights")
	public void select_an_accommodation_corresponding_to_the_dates_of_the_flights() throws InterruptedException {
		lp2.clickOnStayLink();
		Thread.sleep(3000);
	}
	
	@Then("The page title should be {string}")
	public void the_page_title_should_be(String title) {
		
		System.out.println("Page title is: "+driver.getTitle());
		Assert.assertEquals(title, driver.getTitle());
	}


}
