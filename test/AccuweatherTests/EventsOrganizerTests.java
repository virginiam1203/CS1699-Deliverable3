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

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class EventsOrganizerTests {
    
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
   * Scenario: Find the Accuweather Twitter page from the homepage
   * Given the Accuweather home page
   * When the user clicks on the Twitter icon
   * Then the user should be taken to the Accuweather Twitter page
   */
  @Test
  public void CheckTwitterFromHome() throws Exception {
        //Open Home Page
        driver.get("http://www.accuweather.com");
        //Find the Twitter link
        driver.findElement(By.linkText("Follow Us")).click();
      
        //Assert that we have been taken to the Accuweather Twitter page
        driver.switchTo().window(null);
        assert(driver.getTitle().contains("Twitter"));
        assert(driver.getTitle().contains("Accuweather"));
  }
    
}
