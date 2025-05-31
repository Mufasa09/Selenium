package tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestClass{
	/*Variables*/
	
	protected static WebDriver driver;
	
	
	/*Base functions*/
    public static void initializeDriver(Map<String, String> map) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        if(map.get("incognito").contains("true"))
            options.addArguments("--incognito");
        if(map.get("headless").contains("true"))
            options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    public static String GrabText(By loc)
    {
        return driver.findElement(loc).getText();
    }
    /*Resusable methods*/
    
    
    //Navigates to the page
    public static void NavigateToPage(String page) {
    	driver.get(page);
    }
    
    //Enters the users info into the desired textbox
    public static void Enter(By loc, String info) {
    	driver.findElement(loc).sendKeys(info);
    }
    
    //Clicks on the desired element
    public static void Click(By loc) {
    	driver.findElement(loc).click();
    }
    
    public static void VerifyTextData(By loc, String data, boolean boolData)
    {
        if(boolData)
        	assertTrue(driver.findElement(loc).getText().contains(data));
        else
        	assertTrue(driver.findElement(loc).getText().contains(data));
    }
    
    public static void VerifyDataIsPresent(By loc, boolean boolData)
    {
        if (boolData)
        	assertTrue(driver.findElement(loc).isDisplayed());
        else
        	assertTrue(driver.findElement(loc).isDisplayed());
    }
    
    public void VerifyDataIsEnabled(By loc, boolean boolData)
    {
        if (boolData)
        	assertTrue(driver.findElement(loc).isEnabled());
        else
        	assertFalse(driver.findElement(loc).isEnabled());
    }
    
  
    
    public void VerifyTitle(String title) throws InterruptedException
    {
    	CustomWait(3);
        driver.getTitle().contains(title);
    }
    
    public static WebDriverWait CustomWait(int time) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait;
    }
    
    public static WebDriverWait CustomElementWait(int time, By loc) {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));

    	// Wait until the element is present and visible
        WebElement element = wait.until(
            ExpectedConditions.visibilityOfElementLocated(loc));
    	return wait;
    }
    
    
    
}