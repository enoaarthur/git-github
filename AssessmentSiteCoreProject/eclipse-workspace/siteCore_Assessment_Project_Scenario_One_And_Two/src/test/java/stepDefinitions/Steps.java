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

public class Steps {
	
	public WebDriver driver;
	public SearchPage lp;
	public Integer index_img = 0;
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		
		System.setProperty("webdriver.chromer.driver", 
				"C:\\Users\\TEMP.DOMAIN01\\eclipse-workspace\\new_nopCommerce004_Cucumber"
						+ "\\src\\test\\java\\Drivers\\chromedriver");
		driver = new ChromeDriver();
		/*
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("--lang=en-us"); Map<String, Object> prefs = new
		 * HashMap<String, Object>();
		 * 
		 * prefs.put("intl.accept_languages", "en-us,en");
		 * 
		 * options.setExperimentalOption("prefs", prefs); driver = new
		 * ChromeDriver(options);
		 */
	   lp = new SearchPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) throws InterruptedException {
		driver.get(url);
		Thread.sleep(3000);
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		WebElement agree = driver.findElement(By.id("introAgreeButton"));
		agree.click();
		Thread.sleep(4000);
	   
	}
	

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
	

	@Then("User enter city Name as {string}")
	public void user_enter_city_name_as(String cityName) {
		lp.setSearchFieldName(cityName);
	    
	}

	@Then("press the Key Enter")
	public void press_the_key_enter() throws InterruptedException {
	    lp.pressEnterKey();
	    Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() throws IOException, InterruptedException {
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("C:\\Users\\TEMP.DOMAIN01\\eclipse-workspace\\"
				+ "siteCore_Assessment_Project_Scenario_One_And_Two\\"
				+ "searchGoogle_"+ index_img++ +".png");
		FileUtils.copyFile(SrcFile, DestFile);
		Thread.sleep(3000);
		driver.close();
	}

}
