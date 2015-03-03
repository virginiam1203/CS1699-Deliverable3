/*
 * CS1699 Deliverable 3
 * Shelley Goldberg and Ginger Mulky
 */

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * As a Pittsburgh resident
 * I want to check the weather in my area
 * so that I can emotionally prepare myself
 */
public class PittsburghResidentTest {

	private WebDriver driver;
	  @Before
	  public void setUp() throws Exception {
		driver = new FirefoxDriver();
		//wait 60 seconds for elements to appear/pages to load
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  }

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	/*
	 * When a user checks the hourly weather
	 * Then the website will display a temperature and RealFeel temperature for each hour
	 */
	//Test that the temperature is displayed
	@Test
	public void hourlyTemp(){
		driver.get("http://www.accuweather.com/en/us/pittsburgh-pa/15219/hourly-weather-forecast/1310");
		WebElement rain = driver.findElement(By.id("detail-hourly"));
		assertTrue(rain.getText().contains("Temp"));
	}
	//Test that the RealFeel is displayed
	@Test
	public void hourlyRealFeel(){
		driver.get("http://www.accuweather.com/en/us/pittsburgh-pa/15219/hourly-weather-forecast/1310");
		WebElement rain = driver.findElement(By.id("detail-hourly"));
		assertTrue(rain.getText().contains("RealFeel"));
	}
	/*
	 * When a user checks the extended weather
	 * The website will provide an textual indicator of weather conditions
	 */
	@Test
	public void Extended() {
		driver.get("http://www.accuweather.com/en/us/pittsburgh-pa/15219/hourly-weather-forecast/1310");
		WebElement condition= driver.findElement(By.id("feed-tabs"));
		String fullText= condition.getText();
		boolean containsDesc= false;
		String[] splitText = fullText.split("\n");
		int countDesc=0;
		for(int i=0; i<splitText.length; i++)
		{
			//if a String in the element is not a date, day of the week, today/tonight, or more
			//Then is is a description. Count these
			String temp=splitText[i];
			if(!(temp.matches(".*[0-9]+.*")||temp.equals("Mon")||temp.equals("Tue")
					||temp.equals("Wed")|| temp.equals("Thu")|| temp.equals("Fri")||
					temp.equals("Sat")|| temp.equals("Sun")|| temp.equals("more")||
					temp.equals("more")|| temp.equals("Today") || temp.equals("Tonight")))
			{
				containsDesc=true;
				countDesc++;
				}
			
		}
		
		assertEquals(countDesc, 5);
		//assert that a description exists for all 5 days!
	}
	
	/*
	 * Given that it is winter time (unknown what the website displays in other seasons)
	 * When a user checks the hourly weather
	 * Then the website will provide amounts of Rain, Snow, and Ice
	 */
	//Test that Rain values are displayed
	@Test
	public void Rain(){
		driver.get("http://www.accuweather.com/en/us/pittsburgh-pa/15219/hourly-weather-forecast/1310");
		WebElement rain = driver.findElement(By.id("detail-hourly"));
		assertTrue(rain.getText().contains("Rain"));
	}
	//Test that Snow values are displayed
	@Test
	public void Snow(){
		driver.get("http://www.accuweather.com/en/us/pittsburgh-pa/15219/hourly-weather-forecast/1310");
		WebElement rain = driver.findElement(By.id("detail-hourly"));
		assertTrue(rain.getText().contains("Snow"));
	}
	//Test that Ice values are displayed
	@Test
	public void Ice(){
		driver.get("http://www.accuweather.com/en/us/pittsburgh-pa/15219/hourly-weather-forecast/1310");
		WebElement rain = driver.findElement(By.id("detail-hourly"));
		assertTrue(rain.getText().contains("Ice"));
	}
	/*
	 * When a user access the monthly weather
	 * Then the website will provide Historical Averages for each day
	 */
	//Test that there are historical averages on the Month page
	//I had intended to access the monthly page from the Pittsburgh main page,
	//but click() would not work on the link element
	@Test
	public void Monthly(){
		driver.get("http://www.accuweather.com/en/us/pittsburgh-pa/15219/march-weather/1310");
		WebElement calendar= driver.findElement(By.id("panel-main"));
		assertTrue(calendar.getText().contains("Hist. Avg."));
		
	}
	/*
	 * When a user accesses the Pittsburgh weather page
	 * Then the website will contain a video forecast, radar, storm news, and regional weather reports
	 */
	//Test that there is a Video Weather link on the main Pittsburgh page
	  @Test
	  public void VideoTest() throws Exception{
		driver.get("http://www.accuweather.com/en/us/pittsburgh-pa/15219/weather-forecast/1310");
		WebElement content = driver.findElement(By.id("feature-video"));
		assertTrue(content.getText().contains("Video Weather Forecast"));
	  }
	  
	//Test that there is a Radar link on the main Pittsburgh page
	  @Test
	  public void Radar() throws Exception{
		driver.get("http://www.accuweather.com/en/us/pittsburgh-pa/15219/weather-forecast/1310");
		WebElement content = driver.findElement(By.id("feature-radar"));
		assertTrue(content.getText().contains("Pittsburgh Radar"));
	  }
	//Test that there is a News story on the main Pittsburgh page
	  @Test
	  public void News() throws Exception{
		driver.get("http://www.accuweather.com/en/us/pittsburgh-pa/15219/weather-forecast/1310");
		WebElement content = driver.findElement(By.id("article"));
		assertTrue(content.getText().contains("Pittsburgh"));
		//The news story will change between tests, but is likely to contain the word "Pittsburgh"
		//alternatively, I would assert that the element exists. 
	  }
	//Test that there is a Regional News section on the main Pittsburgh page
	  @Test
	  public void Regional() throws Exception{
		driver.get("http://www.accuweather.com/en/us/pittsburgh-pa/15219/weather-forecast/1310");
		WebElement content = driver.findElement(By.id("news"));
		assertTrue(content.getText().contains("Pittsburgh Weather Reports"));
	  }
	
	/*
	 * When a user access the weekend weather and selects the next weekend
	 * Then the website will show the next weekend's weather and allow the user to return to this weekend
	 */
	@Test
	public void Weekend(){
		driver.get("http://www.accuweather.com/en/us/pittsburgh-pa/15219/weekend-weather/1310");
		
		WebElement nextWeekend= driver.findElement(By.cssSelector("a[href*='?wknd=next']"));
		nextWeekend.click();
		WebElement thisWeekend = driver.findElement(By.id("panel-main"));
		assertTrue(thisWeekend.getText().contains("This Weekend"));
		
		
	}
	
	

}
