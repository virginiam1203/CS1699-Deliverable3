/*
 * CS1699 Deliverable 3
 * Shelley Goldberg and Ginger Mulky
 */

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


/* As a traveler
 * I want to check the weather in multiple cities
 * so that I can pack accordingly
 */
public class TravelerTest {

	
	private WebDriver driver;
	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    //wait 60 seconds for elements to appear/pages to load
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  }
	  /* When a user types a city name into the search bar and clicks go
	   * Then a page with a list of cities will load
	   */
	  //Test that a user there is a list of cities when he/she searches for a city name
	  @Test
	  public void SearchCity() throws Exception{
		  
		  driver.get("http://www.accuweather.com");
		  WebElement element = driver.findElement(By.name("s"));

	       // Enter something to search for
	       element.sendKeys("New Haven");
	       element.submit();
	       WebElement content = driver.findElement(By.className("panel-body-content"));
	       //There should be a list of cities
	       assertTrue(content.getText().contains("Multiple Locations Found:"));
	       
		  
	  }
	  //Test that there is not a list of cities when a user enters an invalid city name
	  @Test
	  public void BadSearch() throws Exception{
		  
		  driver.get("http://www.accuweather.com");
		  WebElement element = driver.findElement(By.name("s"));

	       // Enter something to search for
	       element.sendKeys("#M0N3Y");
	       element.submit();
	       WebElement content = driver.findElement(By.className("panel-body-content"));
	       //There should not be a list of cities
	       assertTrue(content.getText().contains("Please enter a different location"));
	       
		  
	  }
	  /*
	   * Given a user whose location is in North America
	   * When the user clicks on the "North America" link
	   * Then the North America Weather page will load
	   */
	  
	  //test that user can go to the North America Weather link from the home page
	  @Test
	  public void NorthAmerica() throws Exception{
		  driver.get("http://www.accuweather.com");
		  WebElement link = driver.findElement(By.cssSelector("a[href*='north-america-weather']"));
		  link.click();
		  WebElement content = driver.findElement(By.id("home"));
	      assertTrue(content.getText().contains("North America Weather"));
		  
	  }
	  
	  /*
	   * Given a user whose location is in the world
	   * When the user clicks on the "World" link
	   * Then the World Weather page will load
	   */
	//test that user can go to the World Weather link from the home page
	  @Test
	  public void World() throws Exception{
		  driver.get("http://www.accuweather.com");
		  WebElement link = driver.findElement(By.cssSelector("a[href*='world-weather']"));
		  link.click();
		  WebElement content = driver.findElement(By.id("home"));
	      assertTrue(content.getText().contains("World Weather Conditions"));
		  
	  }
	  /*
	   * When a user accesses a location page
	   * Then the page will have  weekend, extended, month, radar, and MinuteCast tabs
	   */
	  //Test that there is a weekend forecast tab on the page of a city
	  @Test
	  public void WeekendTab() throws Exception{
		  driver.get("http://www.accuweather.com/en/us/phoenix-az/85004/weather-forecast/346935");
		  //go to a page of a particular location- Phoenix, AZ
		  WebElement content = driver.findElement(By.id("forecast-currently"));
	      assertTrue(content.getText().contains("Weekend"));
	  }
	  //Test that there is an extended forecast tab on the page of a city
	  @Test
	  public void ExtendedTab() throws Exception{
		  driver.get("http://www.accuweather.com/en/us/phoenix-az/85004/weather-forecast/346935");
		  //go to a page of a particular location- Phoenix, AZ
		  WebElement content = driver.findElement(By.id("forecast-currently"));
	      assertTrue(content.getText().contains("Extended"));
	  }
	  //Test that there is a monthly forecast tab on the page of a city
	  @Test
	  public void MonthTab() throws Exception{
		  driver.get("http://www.accuweather.com/en/us/phoenix-az/85004/weather-forecast/346935");
		  //go to a page of a particular location- Phoenix, AZ
		  WebElement content = driver.findElement(By.id("forecast-currently"));
	      assertTrue(content.getText().contains("Month"));
	  }
	  //Test that there is a radar tab on the page of a city
	  @Test
	  public void RadarTab() throws Exception{
		  driver.get("http://www.accuweather.com/en/us/phoenix-az/85004/weather-forecast/346935");
		  //go to a page of a particular location- Phoenix, AZ
		  WebElement content = driver.findElement(By.id("forecast-currently"));
	      assertTrue(content.getText().contains("Radar"));
	  }
	  //Test that there is a MinuteCast forecast tab on the page of a city
	  @Test
	  public void MinuteCastTab() throws Exception{
		  driver.get("http://www.accuweather.com/en/us/phoenix-az/85004/weather-forecast/346935");
		  //go to a page of a particular location- Phoenix, AZ
		  WebElement content = driver.findElement(By.id("forecast-currently"));
	      assertTrue(content.getText().contains("MinuteCast"));
	  }
	  
	  /*
	   * Given a user using Fahrenheit temperatures
	   * When a user selects Celsius
	   * Then the temperatures will convert to Celsius
	   */
	  @Test
	  public void tempConv() throws Exception{
		  driver.get("http://accuweather.com");
		  WebElement expectedTemp= driver.findElement(By.id("popular-locations-ul"));
		  String expTemperature= expectedTemp.getText();
		  String[] expvals= expTemperature.split("\n");
		  int expected= Integer.parseInt(expvals[1].substring(0, (expvals[1].length()-1)));
		  
		  
		  WebElement celcius= driver.findElement(By.id("bt-menu-settings"));
		  celcius.click();
		  WebElement selector= driver.findElement(By.className("last"));
		  selector.click();
		  
		  WebElement tempElem= driver.findElement(By.id("popular-locations-ul"));
		  String temperature= tempElem.getText();
		  String[] vals= temperature.split("\n");
		  int observed= Integer.parseInt(vals[1].substring(0, (vals[1].length()-1)));
		  int expCelcius= (int) ((expected-32)/1.8);
		  
		  assertEquals(expCelcius, observed);
		  
	  }
	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    }

}
