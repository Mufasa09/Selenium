package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestClass{
	/*Variables*/
	
	protected WebDriver driver;
	
	
	/*Base functions*/
    public void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    /*Resusable methods*/
    
    
    //Navigates to the page
    public void NavigateToPage(String page) {
    	driver.get(page);
    }
    
    //Enters the users info into the desired textbox
    public void Enter(By loc, String info) {
    	driver.findElement(loc).sendKeys(info);
    }
    
    //Clicks on the desired element
    public void Click(By loc) {
    	driver.findElement(loc).click();
    }
    
}