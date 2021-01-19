/*
 * This class is for handle the web pages in the context of this scenario that will be google.com homepage
 * This Obect page will help us finding the different html elements in the html page, send the keys to the 
 * input field, press enter to launch the search. This particular class is coupled with the class that implements
 * the steps of the scenario class Steps_Google.java in our project. To achieve its goal it receives an Webdriver 
 * instance once instanciated
 * 
 */

package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class SearchPage {
	
	
public WebDriver ldriver;
	
	public SearchPage (WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	
	// below the input element that we search to enter the key to search
	
	@FindBy(xpath=("//*[@name='q']"))
	@CacheLookup
	WebElement txtSearch;
	
	
	//To launch the search, the element below will be needed to press the button
	@FindBy(id="introAgreeButton")
	@CacheLookup
	WebElement agreeButton;
	
	
	// This function will handle the launching of the new google page
	// it will enlarge the screen, it will close the popup window
	// you get when you open a brand new google page
	public void manageOpenNewWindow() throws InterruptedException {
        
		ldriver.manage().window().maximize();
		
		// here we switch to the popup window and agreed in order to launch to get the search page
		ldriver.switchTo().frame(0);
		WebElement agree = ldriver.findElement(By.id("introAgreeButton"));
		agree.click();
		Thread.sleep(4000);
	}
	
	//This function will be called to enter the search key which city name 
	public void setSearchFieldName(String cityName) {
		txtSearch.clear();
		txtSearch.sendKeys(cityName);
	}
	
	
	// this function is called to press on enter once the search key is filled up
	public void pressEnterKey() {
		txtSearch.sendKeys(Keys.RETURN);
		
	}
	
	

}
