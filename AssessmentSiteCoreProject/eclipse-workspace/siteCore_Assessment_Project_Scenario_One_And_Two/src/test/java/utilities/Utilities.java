package utilities;

import java.util.Random;


public class Utilities {
	
	public static int getRandomNumberInRange(int min, int max) {

	    if (min >= max) {
	        throw new IllegalArgumentException("max must be greater than min");
	    }

	    Random r = new Random();
	    return r.nextInt((max - min) + 1) + min;
	}
	
	public static String DRIVER_LOCATION = "/siteCore_Assessment_Project_Scenario_One_And_Two/"
			+ "src/test/java/sitecore/assessment/testing/Drivers/chromedriver.exe\"";

}
