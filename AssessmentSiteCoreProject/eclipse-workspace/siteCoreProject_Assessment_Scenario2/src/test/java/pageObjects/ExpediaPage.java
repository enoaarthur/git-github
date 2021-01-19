package pageObjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
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
		  
		  @FindBy(linkText="Stays")
	      @CacheLookup
	      WebElement linkTextStay;
	
		  @FindBy(xpath="//a[@data-testid='travelers-field']")
		  @CacheLookup
		  WebElement linkTraveler;
	
		  
	
		  @FindBy(xpath="//button[@data-testid='travelers-field-trigger']")
	  
		  @CacheLookup 
		  WebElement linkTravelerForStay;
		  
		  @FindBy(xpath="//a[@data-testid='travelers-field']")
		  @CacheLookup 
		  WebElement linkTravelerForStay2;
		  
		  
		  @FindBy(xpath="//button[@data-stid='submit-hotel-reserve']")
		  @CacheLookup 
		  WebElement btnSubmitHotel;
	 
		 
	
		
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
	      
	      
	      @FindBy(xpath="//button[@data-testid='submit-button']")
		  @CacheLookup 
		  WebElement btnSubmitForStay;
	      
	      @FindBy(xpath="//div[@data-testid='room-1']//div[2]//div/button[2]")
	      @CacheLookup
	      WebElement increaseChildBtn;
	      
	      
	      @FindBy(xpath="//div[@data-testid='room-1']//div[1]//div/button[1]")
	      @CacheLookup
	      WebElement decreaseChildBtnForStay;
	      
	      @FindBy(xpath="//div[@data-testid='room-1']//div[2]//div/button[2]")
	      @CacheLookup
	      WebElement increaseChildBtnForStay;
	      
	      
	      @FindBy(xpath="//select[@id='child-age-input-0-0']")
	      @CacheLookup
	      WebElement ChildOf3Years;
	      
	      @FindBy(xpath="//button[@data-testid='guests-done-button']")
	      @CacheLookup
	      WebElement btnGuestsDone;
	      
	      @FindBy(xpath="//button[@data-testid='guests-done-button']")
	      @CacheLookup
	      WebElement btnGuestsDoneForStay;
	      
	      @FindBy(xpath="//button[@id='d1-btn']")
	      @CacheLookup
	      WebElement btnDepDate;
	      
	      @FindBy(xpath="//input[@id='add-flight-switch']")
	      @CacheLookup
	      WebElement checkFlight;
	      
	      @FindBy(xpath="//a[@data-stid='open-hotel-information']")
	      @CacheLookup
	      WebElement selectHotel;
	      
	      
	      
	      @FindBy(xpath="//table[@class='uitk-new-date-picker-weeks']/tbody//tr[4]//td[2]/button")
	      @CacheLookup
	      WebElement DepartureDate;
	      
	      
	      @FindBy(xpath="//button[@data-stid='apply-date-picker']")
	      @CacheLookup
	      WebElement confirmDate;
	      
	      @FindBy(xpath="//div[@class='uitk-calendar']//div//button[2]")
	      @CacheLookup
	      WebElement nextMonth;
	      
	      
	      @FindBy(xpath="//div[@class='uitk-new-date-picker-menu-months-container']")
	      @CacheLookup
	      WebElement theMonthToFlight;
	      
	      
	      
	   public void setDateDep(Integer mOffset) throws InterruptedException {
		   
		  
	  		btnDepDate.click();
	  		
	  		Thread.sleep(4000);
	  		
	  		// Here we are going to select any dates in the coming 3 months according to the scenario
	  		for(int offset=0;offset<3;++offset) {
		  		nextMonth.click();
		  		Thread.sleep(1000);
	  		}
	  	
	  		DepartureDate.click();
	  		
	  		
	  		confirmDate.click();
	  	}
	      
	public void clickOnFlightLink() {
		linkTextFlight.click();
	}
	
	public void clickOnStayLink() throws InterruptedException {
		linkTextStay.click();
		Thread.sleep(3000);
		checkFlight.click();
		Thread.sleep(5000);
		
		
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
		//btnSubmitForStay.click();
		//Thread.sleep(3000);
		//selectHotel.click();
		//String winHandleBefore = l2driver.getWindowHandle();

		// Perform the click operation that opens new window

		// Switch to new window opened
		/*for(String winHandle : l2driver.getWindowHandles()){
		    l2driver.switchTo().window(winHandle);
		}*/

		// Perform the actions on new window

		// Close the new window, if that window no more required
		//driver.close();

		// Switch back to original browser (first window)
		//l2driver.switchTo().window(winHandleBefore);

		// Continue with original browser (first window)
		//System.out.println("Je suis sur la page: "+l2driver.getTitle().toString());
		//Thread.sleep(3000);
		
		//WebDriverWait wait = new WebDriverWait(l2driver, 30);
		  //wait.until(ExpectedConditions.elementToBeClickable(btnSubmitHotel));
		//btnSubmitHotel.click();
	}
	
	public void clickOnSubmit() throws InterruptedException {
		
		
		Thread.sleep(3000);
		btnSubmitForStay.click();
		
		Thread.sleep(3000);
				selectHotel.click();
				String winHandleBefore = l2driver.getWindowHandle();

				 //Perform the click operation that opens new window

				//Switch to new window opened
				for(String winHandle : l2driver.getWindowHandles()){
				    l2driver.switchTo().window(winHandle);
				}

				// Perform the actions on new window

				// Close the new window, if that window no more required
				//driver.close();

				// Switch back to original browser (first window)
				//l2driver.switchTo().window(winHandleBefore);

				// Continue with original browser (first window)
				System.out.println("Je suis sur la page: "+l2driver.getTitle().toString());
				Thread.sleep(3000);
				
				WebDriverWait wait = new WebDriverWait(l2driver, 30);
				  wait.until(ExpectedConditions.elementToBeClickable(btnSubmitHotel));
				  
				btnSubmitHotel.click();
		
				System.out.println("ExpediaPage_ Je suis sur la page: "+l2driver.getTitle().toString());
		
		  //WebElement lastElementToLoad =  l2driver.findElement(By.xpath("//button[@datastid='submit-hotel-search']"));
		  
		 // WebDriverWait wait2 = new WebDriverWait(l2driver, 30);
		  //wait2.until(ExpectedConditions.elementToBeClickable(lastElementToLoad));
		 
		 
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
