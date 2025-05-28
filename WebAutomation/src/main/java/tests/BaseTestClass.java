package tests;

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
    
}