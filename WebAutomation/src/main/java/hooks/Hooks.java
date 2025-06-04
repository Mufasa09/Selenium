package hooks;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.github.dockerjava.api.exception.NotFoundException;

import Utilities.BrowserFactory;
import Utilities.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	private String baseUrl, directoryName;
	private Properties config;
	private WebDriver driver;

	@Before
	public void setUp(Scenario scenario) throws IOException {
		config = new Properties();
		if (config != null) {
			directoryName = System.getProperty("user.dir");
			FileInputStream fis = new FileInputStream(directoryName + "/testsettings.properties");
			config.load(fis);
			driver = BrowserFactory.ChooseBrowser(config, driver);
			DriverFactory.setDriver(driver);
			String featureName = getFeatureNameFromScenario(scenario);
			baseUrl = WebsiteSelector(featureName) + "Url";
			String value = config.getProperty(baseUrl);
			System.out.println("Driver initialized in @Before: " + driver);
			System.out.println("Scenario: " + scenario);
			System.out.println("Feature: " + featureName);
			driver.manage().window().maximize();
			driver.navigate().to(value);
		}
	}

	@After
	public void tearDown() {

		System.out.println("Driver quit in @After: " + driver);
		DriverFactory.removeDriver();
		driver = null;

	}

	public String WebsiteSelector(String featureName) {
		String returnString = "";
		switch (featureName) {
		default:
			if (featureName.contains("SauceDemo")) {
				returnString = "SauceDemo";
				return returnString;
			} else if (featureName.contains("UltimateQA")) {
				returnString = "UltimateQA";
				return returnString;
			} else if (featureName.contains("APIDog")) {
				returnString = "APIDog";
				return returnString;
			} else if (featureName.contains("Google")) {
				returnString = "Google";
				return returnString;
			} else {
				throw new NotFoundException("Website Not Found");
			}
		}
	}

	private String getFeatureNameFromScenario(Scenario scenario) {
		// Format: "file:/.../your.feature"
		String rawUri = scenario.getUri().toString();
		String fileName = rawUri.substring(rawUri.lastIndexOf("/") + 1);
		return fileName.replace(".feature", "");
	}

}
