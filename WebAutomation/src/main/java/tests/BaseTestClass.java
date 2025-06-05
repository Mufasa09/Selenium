package tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.DriverFactory;
import io.cucumber.datatable.DataTable;


public class BaseTestClass{
	/*Variables*/
	
	
	protected WebDriver driver;


	public BaseTestClass() {
		driver = DriverFactory.getDriver();	
	}


	public String GrabText(By loc)
    {
        return driver.findElement(loc).getText();
    }
    /*Resusable methods*/
    
    
    public  void NavigateToPage(String page) {
    	driver.get(page);
    }
    
    public  void Enter(By loc, String info) {
    	driver.findElement(loc).sendKeys(info);
    }
    
    public  void Click(By loc) {
    	driver.findElement(loc).click();
    }
    
    public  void Click(WebElement element) {
    	element.click();
    }
    
    public  void VerifyTextData(By loc, String data, boolean boolData)
    {
        if(boolData)
        	assertTrue(driver.findElement(loc).getText().contains(data));
        else
        	assertTrue(driver.findElement(loc).getText().contains(data));
    }
    
    public  void VerifyDataIsPresent(By loc, boolean boolData)
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
    
    public  WebDriverWait CustomWait(int time) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait;
    }
    
    public  WebDriverWait CustomElementWait(int time, By loc) {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));

    	// Wait until the element is present and visible
        WebElement element = wait.until(
            ExpectedConditions.visibilityOfElementLocated(loc));
    	return wait;
    }
    
    public  List<WebElement> GrabAllElements(By loc){
    	List<WebElement> allElements = driver.findElements(loc);
    	return allElements;
    }
    
    public  void ClickElementFromList(By loc, String name) {
    	
    	List<WebElement> allListElements = driver.findElements(loc);
  	  // Print tag name and text content of each element
        for (WebElement element : allListElements) {
            System.out.println("Tag: " + element.getTagName() + ", Text: " + element.getText());
        }
    	for(WebElement element : allListElements) {
    		if(element.getText().contains(name)) {
    			Click(element);
    			break;
    		}
    	}
    }
    
    
    public List<Map<String, String>> itemList(DataTable dataTable){
    	List<Map<String, String>> rows = dataTable.asMaps();
    	return rows;
    }
    
    
}