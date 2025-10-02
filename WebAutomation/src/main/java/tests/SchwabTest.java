package tests;

import pages.Schwab.SchwabHomePage;
import tests;

public class SchwabTest extends BaseTestClass{
	
	
	public SchwabTest() {
		SchwabHomePage = new SchwabHomePage();
	}
	
	SchwabHomePage SchwabHomePage;
	
	public void VerifyURL(String url) {
		VerifyURL(url);
	}
	
	public void VerifyTitle(String title) {
		VerifyTitle(title);
	}
	
	
}