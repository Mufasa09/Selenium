package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestClass{
	/*Variables*/
	
	protected static WebDriver driver;
	
	
	/*Base functions*/
    public static void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
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
    
    public static void Wait(int number) throws InterruptedException
    {
        Thread.sleep(number);
    }
    
    public void VerifyTitle(String title) throws InterruptedException
    {
    	Wait(3000);
        driver.getTitle().contains(title);
    	Wait(5000);
    }
}