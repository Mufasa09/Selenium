package Utilities;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(WebDriver driverInstance) {
		driver.set(driverInstance);
	}

//	   public static void quitDriver() {
//	        if (driver != null) {
//	            driver.quit();
//	        }
//	    }

	public static void removeDriver() {
		WebDriver drv = driver.get();
		if (drv != null) {
			drv.quit();
			//drv.close();
			driver.remove();
		}
	}
}