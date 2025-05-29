package tests;


import static org.testng.Assert.assertTrue;

import java.util.Map;

import io.cucumber.datatable.DataTable;
import pages.GoogleHomePage;

public class GoogleTests extends BaseTestClass{
	GoogleHomePage google;

	public GoogleTests() {
		google = new GoogleHomePage();
	}
	
	public void searchGoogle(String query) {
		Enter(google.searchBox,query);
		driver.findElement(google.searchBox).submit();
	}
	
	public void verifyResults(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap(String.class, String.class);
    	String results = data.get("results");
		String pageText = driver.findElement(google.bodyText).getText();
    	System.out.print(driver.findElement(google.searchBox).getText());

		assertTrue(pageText.contains(results), "Page text did not contain expected results");
	}
	
}