package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.github.dockerjava.api.exception.NotFoundException;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseTestClass {

	public String baseUrl;
	public Properties config;

	public Hooks() throws IOException {
		config = new Properties();
		String directoryName = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(directoryName + "/testsettings.properties");
		config.load(fis);
		String headless = config.getProperty("Headless");
		String incognito = config.getProperty("Incognito");
		initializeDriver(Options(config));
		System.out.println("Driver initialized in @Before: " + driver);
	}
	
	public Map<String, String> Options(Properties config) {
		
		Map<String, String> ChromeOptions = new HashMap<String, String>();
		String headless = config.getProperty("Headless");
		String incognito = config.getProperty("Incognito");
		ChromeOptions.put("headless", headless);
		ChromeOptions.put("incognito", incognito);
		
		return ChromeOptions;
	}

	@Before
	public void setUp(Scenario scenario) {
		driver.manage().window().maximize();
		String featureName = getFeatureNameFromScenario(scenario);
		baseUrl = WebsiteSelector(featureName) + "Url";
		String value = config.getProperty(baseUrl);
		driver.navigate().to(value);
	}

	@After
	public void tearDown() {
		quitDriver();
		System.out.println("Driver quit in @After");
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
