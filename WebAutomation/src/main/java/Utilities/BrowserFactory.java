package Utilities;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	
	public static WebDriver ChooseBrowser(Properties config, WebDriver driver) {

		String browserType = config.getProperty("Browser");
		switch (browserType) {
		case "Chrome":
			return initializeChromeDriver(Options(config), driver);
		case "Edge":

			return new EdgeDriver();
		case "Firefox":

			return new FirefoxDriver();
		
			default:
				throw new IllegalArgumentException("Unsupported browser: " + browserType);
		}
	}
	
    public static WebDriver initializeChromeDriver(Map<String, String> map, WebDriver driver) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        if(map.get("incognito").contains("true"))
            options.addArguments("--incognito");
        if(map.get("headless").contains("true"))
            options.addArguments("--headless");
        return new ChromeDriver(options);
    }
    
	public static Map<String, String> Options(Properties config) {
		
		Map<String, String> ChromeOptions = new HashMap<String, String>();
		String headless = config.getProperty("Headless");
		String incognito = config.getProperty("Incognito");
		ChromeOptions.put("headless", headless);
		ChromeOptions.put("incognito", incognito);
		
		return ChromeOptions;
	}
	

}

