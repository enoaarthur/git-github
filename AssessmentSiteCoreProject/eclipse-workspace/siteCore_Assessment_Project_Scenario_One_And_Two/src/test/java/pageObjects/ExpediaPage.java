package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ExpediaPage {
	
public WebDriver l2driver;
	
	public ExpediaPage (WebDriver r2driver) {
		l2driver = r2driver;
		PageFactory.initElements(r2driver, this);
		
	}
	
	
		  @FindBy(linkText="Flights")
	      @CacheLookup
	      WebElement linkTextFlight;
	
		  @FindBy(xpath="//a[@data-testid='travelers-field']")
		  @CacheLookup
		  WebElement linkTraveler;
	
	
		
		  @FindBy(xpath="//div[@id='location-field-leg1-origin-menu']/div/ul")
		  @CacheLookup 
		  WebElement listOfDep;
		  
	
	     @FindBy(xpath="//div[@id='location-field-leg1-destination-menu']/div/ul")
	     @CacheLookup
	     WebElement listOfDest;
	
	 
	  	  @FindBy(xpath="//div[@id='location-field-leg1-origin-menu']"
		  		+ "/div/button[@class='uitk-faux-input']")
		  @CacheLookup 
		  WebElement btnDepField;
	
	  	  
	  	  @FindBy(xpath="//div[@id='location-field-leg1-destination-menu']"
		  		+ "/div/button")
		  @CacheLookup 
		  WebElement btnDestField;
	  
	      @FindBy(xpath="//button[@data-testid='submit-button']")
		  @CacheLookup 
		  WebElement btnSubmit;
	      
	      @FindBy(xpath="//div[@data-testid='room-1']//div[2]//div/button[2]")
	      @CacheLookup
	      WebElement increaseChildBtn;
	      
	      
	      @FindBy(xpath="//select[@id='child-age-input-0-0']")
	      @CacheLookup
	      WebElement ChildOf3Years;
	      
	      @FindBy(xpath="//button[@data-testid='guests-done-button']")
	      @CacheLookup
	      WebElement btnGuestsDone;
	      
	      
	      
	public void clickOnFlightLink() {
		linkTextFlight.click();
	}
	
	public void clickOnSubmit() {
		btnSubmit.click();
		
		WebElement lastElementToLoad = l2driver.findElement(By.xpath("//a[@data-test-id='goto-opinion-lab-button']"));
		WebDriverWait wait = new WebDriverWait(l2driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(lastElementToLoad));
	}
	
	public void addAChild() {
		
		increaseChildBtn.click();
	}
	
	public void setDepAndDestSearKeys(String dep,String dest) throws InterruptedException {
		
		btnDepField.click();
		btnDepField.sendKeys(dep);
		
		Thread.sleep(4000);
		
		List<WebElement> optionsDep = listOfDep.findElements(By.tagName("li"));
		optionsDep.get(0).click();

		    
		//Thread.sleep(4000);
		btnDestField.click();
		btnDestField.sendKeys(dest);
		
		List<WebElement> optionsDest = listOfDest.findElements(By.tagName("li"));
		Thread.sleep(2000);
		optionsDest.get(0).click();
		linkTraveler.click();
		Thread.sleep(2000);
	}
	public void selectAChildOf3Yrs() throws InterruptedException {
		ChildOf3Years.click();
		List<WebElement> optionsAge = ChildOf3Years.findElements(By.tagName("option"));
		optionsAge.get(1).click();
		//System.out.println("J_ai choisi: "+optionsAge.get(1).getAttribute("value").toString());
		btnGuestsDone.click();
		Thread.sleep(2000);
	}
}
