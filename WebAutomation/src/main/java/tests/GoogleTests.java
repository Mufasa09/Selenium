package tests;


import pages.GoogleHomePage;

public class GoogleTests extends BaseTestClass{
	GoogleHomePage google;
	
	public GoogleTests() {
		google = new GoogleHomePage();
	}


	public void openGoogleHomePage() {
	NavigateToPage("https://www.google.com");
	
	}
	
	public void searchGoogle(String query) {
		Enter(google.searchBox,query);
		driver.findElement(google.searchBox).submit();
	}
	
	public void verifyResults(String results) {
		driver.findElement(google.searchBox).getText();
	}
	
}