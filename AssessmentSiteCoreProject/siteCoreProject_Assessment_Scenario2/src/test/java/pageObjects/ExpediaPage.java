/*
 * This class represents the different pages that will be part of our experience throughout 
 * this scenario. 
 * It will help us in finding the different elements with which an interaction with the page
 *  will be required. To handle those pages, the instance of the driver will be required.
 *  This class is coupled with the class Steps_Expedia which implements the steps of our scenario
 */


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
	
	
	      // Element used to go to the Flight tab
		  @FindBy(linkText="Flights")
	      @CacheLookup
	      WebElement linkTextFlight;
		  
		  
		// Element used to go to the Stay(accommodation) tab 
		  @FindBy(linkText="Stays")
	      @CacheLookup
	      WebElement linkTextStay;
	
		  // Element to go to the traveler options
		  @FindBy(xpath="//a[@data-testid='travelers-field']")
		  @CacheLookup
		  WebElement linkTraveler;
	
		   
	      // Another element to go to the traveler options particularly on the Stay tab
		  @FindBy(xpath="//button[@data-testid='travelers-field-trigger']")
		  @CacheLookup 
		  WebElement linkTravelerForStay;
		  
		  @FindBy(xpath="//a[@data-testid='travelers-field']")
		  @CacheLookup 
		  WebElement linkTravelerForStay2;
		  
		  //Element used to click on page and get the different hotels relevant for our trip
		  @FindBy(xpath="//button[@data-stid='submit-hotel-reserve']")
		  @CacheLookup 
		  WebElement btnSubmitHotel;
	 
		 
	
		  // The calendar is set as a table, so here locate the <ul> tag whom children
		  // are <tr>, <td> tags where are respectively for weeks and days. 
		  @FindBy(xpath="//div[@id='location-field-leg1-origin-menu']/div/ul")
		  @CacheLookup 
		  WebElement listOfDep;// for departure city
		  
	
	     @FindBy(xpath="//div[@id='location-field-leg1-destination-menu']/div/ul")
	     @CacheLookup
	     WebElement listOfDest; // for destination city
	
	 
	     //Element useful to enable input field once click on it. This is 
	     // for departure field
	  	  @FindBy(xpath="//div[@id='location-field-leg1-origin-menu']"
		  		+ "/div/button[@class='uitk-faux-input']")
		  @CacheLookup 
		  WebElement btnDepField;
	
	  	//Element useful to enable input field once click on it. This is 
		     // for destination field
	  	  @FindBy(xpath="//div[@id='location-field-leg1-destination-menu']"
		  		+ "/div/button")
		  @CacheLookup 
		  WebElement btnDestField;
	  
	  	  // Once all the fields are filled up, this is the element button we need
	  	  // to submit the search
	      @FindBy(xpath="//button[@data-testid='submit-button']")
		  @CacheLookup 
		  WebElement btnSubmit;
	      
	      
	      @FindBy(xpath="//button[@data-testid='submit-button']")
		  @CacheLookup 
		  WebElement btnSubmitForStay;
	      
	      // This element is useful to increase the number of children we'll flight with
	      @FindBy(xpath="//div[@data-testid='room-1']//div[2]//div/button[2]")
	      @CacheLookup
	      WebElement increaseChildBtn;
	      
	      
	   // This element is useful to decrease the number of children we'll flight with
	      @FindBy(xpath="//div[@data-testid='room-1']//div[1]//div/button[1]")
	      @CacheLookup
	      WebElement decreaseChildBtnForStay;
	      
	      @FindBy(xpath="//div[@data-testid='room-1']//div[2]//div/button[2]")
	      @CacheLookup
	      WebElement increaseChildBtnForStay;
	      
	      
	      //The requirement asked to flight with a child of 3 yrs old
	      //This element will be useful to set the age of the child to 3
	      @FindBy(xpath="//select[@id='child-age-input-0-0']")
	      @CacheLookup
	      WebElement ChildOf3Years;
	      
	      
	      // Once the traveler are selected, we can confirm the changes thanks to this button element
	      @FindBy(xpath="//button[@data-testid='guests-done-button']")
	      @CacheLookup
	      WebElement btnGuestsDone;
	      
	      @FindBy(xpath="//button[@data-testid='guests-done-button']")
	      @CacheLookup
	      WebElement btnGuestsDoneForStay;
	      
	      @FindBy(xpath="//button[@id='d1-btn']")
	      @CacheLookup
	      WebElement btnDepDate;
	      
	      
	      // On the Stay tab, we need to check the options "flights" why this element
	      @FindBy(xpath="//input[@id='add-flight-switch']")
	      @CacheLookup
	      WebElement checkFlight;
	      
	      @FindBy(xpath="//a[@data-stid='open-hotel-information']")
	      @CacheLookup
	      WebElement selectHotel;
	      
	      
	      // We click on the button below oin order to select the the dates of departure and return
	      @FindBy(xpath="//table[@class='uitk-new-date-picker-weeks']/tbody//tr[4]//td[2]/button")
	      @CacheLookup
	      WebElement DepartureDate;
	      
	      @FindBy(xpath="//table[@class='uitk-new-date-picker-weeks']/tbody//tr[5]//td[2]/button")
	      @CacheLookup
	      WebElement ReturnDate;
	      
	      
	      // Once the dates are chosen, we confirm our choices with the button element below
	      @FindBy(xpath="//button[@data-stid='apply-date-picker']")
	      @CacheLookup
	      WebElement confirmDate;
	      
	      @FindBy(xpath="//div[@class='uitk-calendar']//div//button[2]")
	      @CacheLookup
	      WebElement nextMonth;
	      
	      
	      // function called to set the date; this function needs the value offset that will help us from the 
	      //current date to go the date in <offset> month. This parameter is 3 (months) in our scenario
	   public void setDate(Integer mOffset) throws InterruptedException {
		   
		  
	  		btnDepDate.click();
	  		
	  		Thread.sleep(4000);
	  		
	  		// Here we are going to select any dates in the coming 3 months according to the scenario
	  		for(int offset=1;offset<3;++offset) {
		  		nextMonth.click();
		  		Thread.sleep(1000);
	  		}
	  	
	  		DepartureDate.click();
	  		Thread.sleep(2000);
	  		ReturnDate.click();
	  		
	  		
	  		confirmDate.click();
	  	}
	      
	   
	   // the function to go to the Flight tab
	public void clickOnFlightLink() {
		linkTextFlight.click();
	}
	
	
	// The function to go to the Stay tab and check the option "Flights"
	public void clickOnStayLink() throws InterruptedException {
		linkTextStay.click();
		Thread.sleep(3000);
		checkFlight.click();
		Thread.sleep(5000);
		
		// Here we go to the traveller options by clicking on the element linkTraveler
		// it's Surrounded by a try catch because the page renders us either "[traveller-field]"
		// or "[traveller-field-triggered]"
		try {
			linkTravelerForStay.click();
		} catch (Exception e) {
			// TODO: handle exception
			
			linkTravelerForStay2.click();
		}
		Thread.sleep(3000);
		increaseChildBtnForStay.click();
		Thread.sleep(3000);
		decreaseChildBtnForStay.click();
		Thread.sleep(3000);
		btnGuestsDoneForStay.click();
		Thread.sleep(3000);
	}
	
	
	// here we submit our search and select an hotel on the result page
	public void clickOnSubmit() throws InterruptedException {
		
		
		Thread.sleep(3000);
		btnSubmitForStay.click();
		
		Thread.sleep(3000);
				selectHotel.click();

				 //Perform the click operation that opens new window

				//Switch to new window opened
				for(String winHandle : l2driver.getWindowHandles()){
				    l2driver.switchTo().window(winHandle);
				}

				Thread.sleep(4000);
				
				WebDriverWait wait = new WebDriverWait(l2driver, 30);
				  wait.until(ExpectedConditions.elementToBeClickable(btnSubmitHotel));
				  
				btnSubmitHotel.click();
				
		 Thread.sleep(4000);
		  
		 
		 
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
		btnGuestsDone.click();
		Thread.sleep(2000);
	}
}
