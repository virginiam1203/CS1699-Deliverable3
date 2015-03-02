/*
 *As a social media maven
 *I want to get weather updates via social media
 *So that I can contribute and get other user's inputs
 */

/**
 *
 * @author Ginger Mulky
 */

package AccuweatherTests;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SocialMediaTests {
    
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
   * Scenario: Find the AccuWeather Twitter page from the homepage
   * Given the AccuWeather home page
   * When the user clicks on the Twitter icon
   * Then the user should be taken to the AccuWeather Twitter page
   */
  @Test
  public void CheckTwitterFromHome() throws Exception {
        //Open Home Page
        driver.get("http://www.accuweather.com");
        //Find the Twitter link
        driver.findElement(By.linkText("Follow Us")).click();  
        //go to the newest window opened because AccuWeather does not give a target window name
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        //Assert that we have been taken to the AccuWeather Twitter page
        assertTrue(driver.getTitle().contains("Twitter"));
        assertTrue(driver.getTitle().contains("AccuWeather"));
  }
  
  /*
   * Scenario: Find AccuWeather page on facebook
   * Given the AccuWeather home page
   * When the user clicks on the "Like Us on Facebook" button
   * Then the user should be taken to the AccuWeather Facebook page
   */
   @Test
   public void CheckFacebookFromHome() throws Exception {
        //Open Home Page
        driver.get("http://www.accuweather.com");
        //Find the Facebook link
        driver.findElement(By.linkText("Like Us")).click();      
        //go to the newest window opened because AccuWeather does not give a target window name
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        //Assert that we have been taken to the AccuWeather Facebook page
        assertTrue(driver.getTitle().contains("Facebook"));
        assertTrue(driver.getTitle().contains("AccuWeather"));
   }
   
   /*
    * Scenario: Look at the stream of social media on the AccuWeather social page
    * Given the AccuWeather home page
    * When the user clicks on the "Social" link
    * Then the user can see a live stream of social media posts about AccuWeather
    */
    @Test
    public void CheckSocialStream() throws Exception {
        //Open Home Page
        driver.get("http://www.accuweather.com");
        //Find the Social link
         driver.findElement(By.xpath("//div[@id='content']/div[2]/div/ul/li[6]/a/span")).click();    
        //Assert that we now have a streaming element on the page
        assert(driver.findElement(By.className("bbWidget")) != null);   
    }
}