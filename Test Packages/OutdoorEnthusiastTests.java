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
    //wait 60 seconds for elements to appear/pages to load
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }


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
  
  /*
   * Scenario: Check the ski forecast
   * Given an accuweather home page without ski as an interest tab
   * When the user attempts to add a ski tab
   * Then the ski tab should be added to interests
   * And the user should be able to click it to navigate to the ski forecast
   */
  @Test
  public void CheckSki() throws Exception {
        //Open Home Page
        driver.get("http://www.accuweather.com");
        //Find the add ski to interests button in dropdown menu
        WebElement addNewInterest = driver.findElement(By.id("add-new-interest"));
        Actions builder = new Actions(driver);
        builder.moveToElement( addNewInterest );    
        builder.perform();   
        driver.findElement(By.id("add-ski")).click();
        //Click on the ski button
        driver.findElement(By.cssSelector("a[href*='ski-weather']")).click();
        //Assert that we are at the ski forecast page
        assert(driver.getTitle().contains("Skiing Weather Forecast"));
  }
  
  /*
   * Scenario: Check the hunting forecast
   * Given an accuweather home page without hunting as an interest tab
   * When the user attempts to add a hunting tab
   * Then the hunting tab should be added to interests
   * And the user should be able to click it to navigate to the hunting forecast
   */
  @Test
  public void CheckHunting() throws Exception {
        //Open Home Page
        driver.get("http://www.accuweather.com");
        //Find the add hunting to interests button in dropdown menu
        WebElement addNewInterest = driver.findElement(By.id("add-new-interest"));
        Actions builder = new Actions(driver);
        builder.moveToElement( addNewInterest );    
        builder.perform();   
        driver.findElement(By.id("add-hunting")).click();
        //Click on the hunting button
        driver.findElement(By.cssSelector("a[href*='hunting-weather']")).click();
        //Assert that we are at the hunting forecast page
        assert(driver.getTitle().contains("Hunting Weather"));
  }
  
  /*
   * Scenario: Check the fishing forecast
   * Given an accuweather home page without fishing as an interest tab
   * When the user attempts to add a fishing tab
   * Then the fishing tab should be added to interests
   * And the user should be able to click it to navigate to the fishing forecast
   */
  @Test
  public void CheckFishing() throws Exception {
        //Open Home Page
        driver.get("http://www.accuweather.com");
        //Find the add fishing to interests button in dropdown menu
        WebElement addNewInterest = driver.findElement(By.id("add-new-interest"));
        Actions builder = new Actions(driver);
        builder.moveToElement( addNewInterest );    
        builder.perform();   
        driver.findElement(By.id("add-fishing")).click();
        //Click on the fishing button
        driver.findElement(By.cssSelector("a[href*='fishing-weather']")).click();
        //Assert that we are at the golf forecast page
        assert(driver.getTitle().contains("Fishing Weather"));
  }
  
  /*
   * Scenario: Check the running forecast
   * Given an accuweather home page without running as an interest tab
   * When the user attempts to add a running tab
   * Then the running tab should be added to interests
   * And the user should be able to click it to navigate to the running forecast
   */
  @Test
  public void CheckRunning() throws Exception {
        //Open Home Page
        driver.get("http://www.accuweather.com");
        //Find the add running to interests button in dropdown menu
        WebElement addNewInterest = driver.findElement(By.id("add-new-interest"));
        Actions builder = new Actions(driver);
        builder.moveToElement( addNewInterest );    
        builder.perform();   
        driver.findElement(By.id("add-running")).click();
        //Click on the running button
        driver.findElement(By.cssSelector("a[href*='running-weather']")).click();
        //Assert that we are at the running forecast page
        assert(driver.getTitle().contains("Running Weather"));
  }
  
  /*
   * Scenario: Check the hiking forecast
   * Given an accuweather home page without hiking as an interest tab
   * When the user attempts to add a hiking tab
   * Then the hiking tab should be added to interests
   * And the user should be able to click it to navigate to the hiking forecast
   */
  @Test
  public void CheckHiking() throws Exception {
        //Open Home Page
        driver.get("http://www.accuweather.com");
        //Find the add ski to interests button in dropdown menu
        WebElement addNewInterest = driver.findElement(By.id("add-new-interest"));
        Actions builder = new Actions(driver);
        builder.moveToElement( addNewInterest );    
        builder.perform();   
        driver.findElement(By.id("add-hiking")).click();
        //Click on the golf button
        driver.findElement(By.cssSelector("a[href*='hiking-weather']")).click();
        //Assert that we are at the golf forecast page
        assert(driver.getTitle().contains("Hiking Weather"));
  }
  
  /*
   * Scenario: Check the biking forecast
   * Given an accuweather home page without biking as an interest tab
   * When the user attempts to add a biking tab
   * Then the biking tab should be added to interests
   * And the user should be able to click it to navigate to the biking forecast
   */
  @Test
  public void CheckBiking() throws Exception {
        //Open Home Page
        driver.get("http://www.accuweather.com");
        //Find the add biking to interests button in dropdown menu
        WebElement addNewInterest = driver.findElement(By.id("add-new-interest"));
        Actions builder = new Actions(driver);
        builder.moveToElement( addNewInterest );    
        builder.perform();   
        driver.findElement(By.id("add-biking")).click();
        //Click on the biking button
        driver.findElement(By.cssSelector("a[href*='biking-weather']")).click();
        //Assert that we are at the golf forecast page
        assert(driver.getTitle().contains("Biking Weather"));
  }
  @After
  public void tearDown() throws Exception {
    driver.quit();
    }
  }