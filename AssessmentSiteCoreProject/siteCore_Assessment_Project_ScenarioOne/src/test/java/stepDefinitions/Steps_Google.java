package stepDefinitions;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageObjects.SearchPage;
import utilities.*;

public class Steps_Google {
	
	public WebDriver driver;
	public SearchPage lp;
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		
		System.setProperty("webdriver.chromer.driver", Utilities.DRIVER_LOCATION);
		
		driver = new ChromeDriver();
	   lp = new SearchPage(driver);
	}

	
	// In this step we open the url given in the feature file
	@When("User opens URL {string}")
	public void user_opens_url(String url) throws InterruptedException {
		driver.get(url);
		Thread.sleep(3000);
		
		lp.manageOpenNewWindow();
	   
	}
	
	
	
    // in this page we ensure that we do have no other web page than google page
	//Google page should have as title page "Google"
	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
		if(driver.getPageSource().contains("Google is unaccessible.")) {
			driver.close();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertEquals(title.contentEquals("Google"), 
					driver.getTitle().contentEquals("Google"));
		}
	    
	}
	

	// This step is to set the input field with the parameter city
	@Then("User enter city Name as {string}")
	public void user_enter_city_name_as(String cityName) {
		lp.setSearchFieldName(cityName);
	    
	}

	// This step is to launch the search by pressing enter key
	@Then("press the Key Enter")
	public void press_the_key_enter() throws InterruptedException {
	    lp.pressEnterKey();
	    Thread.sleep(3000);
	}

	// Once got the result page this step will first take a printscreen of it
	// and then will close the driver
	@Then("close browser")
	public void close_browser() throws IOException, InterruptedException {
		
		int index_img;
	
		// In order to avoid the new printscreen file to overwritte the previous one
		//We genrate some random values (between 1 and 5) that we add to the file path name  
		
		index_img = Utilities.getRandomNumberInRange(1, 5);
		
		
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("C:\\Users\\TEMP.DOMAIN01\\eclipse-workspace\\"
				+ "siteCore_Assessment_Project_ScenarioOne\\"
				+ "searchGoogle_"+ index_img++ +".png");
		FileUtils.copyFile(SrcFile, DestFile);
		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}

}
