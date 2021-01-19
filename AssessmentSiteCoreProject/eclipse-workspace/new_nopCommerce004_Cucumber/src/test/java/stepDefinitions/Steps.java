package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageObjects.LoginPage;

public class Steps {

	public WebDriver driver;
	public LoginPage lp;
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chromer.driver", 
				"C:\\Users\\TEMP.DOMAIN01\\eclipse-workspace\\new_nopCommerce004_Cucumber"
						+ "\\src\\test\\java\\Drivers\\chromedriver");
		driver = new ChromeDriver();
	   lp = new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
	   
	}

	@When("User enter Email as {string} and Password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) {
	    lp.setPassword(password);
	    lp.setUserName(email);
	}

	@When("click on Login")
	public void click_on_login() {
		lp.clickLogin();
	   
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
		if(driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertEquals(title, driver.getTitle());
		}
	    
	}

	@When("User click on Logout link")
	public void user_click_on_logout_link() throws InterruptedException {
	    lp.clickLogout();
	    Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {
		driver.close();
	  	}
}
