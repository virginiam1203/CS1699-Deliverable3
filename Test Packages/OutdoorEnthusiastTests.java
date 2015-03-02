/*
 *As an outdoor enthusiast
 *I want to check the weather forecast
 *So that I can choose my outdoor activities based on the weather
 */

/**
 * @author Ginger
 */

import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class OutdoorEnthusiastTests  {
  private WebDriver driver;
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
// Search using keyword through Google search

  /*
   * Scenario: Check the golf forecast
   * Given an accuweather home page without golf as an interest tab
   * When the user attempts to add a golf tab
   * Then the golf tab should be added to interests
   * And the user should be able to click it to navigate to the golf forecast
   */
  @Test
  public void CheckGolf() throws Exception {
        //Open Home Page
        driver.get("http://www.accuweather.com");
        //Find the add golf to interests button in dropdown menu
        WebElement addNewInterest = driver.findElement(By.id("add-new-interest"));
        Actions builder = new Actions(driver);
        builder.moveToElement( addNewInterest );    
        builder.perform();   
        driver.findElement(By.id("add-golf")).click();
        //Click on the golf button
        driver.findElement(By.cssSelector("a[href*='golf-weather']")).click();
        //Assert that we are at the golf forecast page
        assert(driver.getTitle().contains("Golf Weather Forecast"));
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    }
  }