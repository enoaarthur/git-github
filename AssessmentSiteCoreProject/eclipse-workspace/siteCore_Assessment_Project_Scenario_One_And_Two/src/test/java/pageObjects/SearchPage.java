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
	
	
	@FindBy(xpath=("//*[@name='q']"))
	@CacheLookup
	WebElement txtSearch;
	
	@FindBy(id="introAgreeButton")
	@CacheLookup
	WebElement agreeButton;
	
	public void setSearchFieldName(String cityName) {
		txtSearch.clear();
		txtSearch.sendKeys(cityName);
	}
	
	
	
	public void pressEnterKey() {
		txtSearch.sendKeys(Keys.RETURN);
		
	}
	public void pressAgreeButton() {
		agreeButton.click();
	}
	
	
	

}
