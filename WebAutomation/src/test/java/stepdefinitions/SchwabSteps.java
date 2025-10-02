package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import tests.SchwabTest;

public class SchwabSteps{
	
	SchwabTest SchwabTest;
	
	public SchwabSteps() {
		SchwabTest = new SchwabTest();
	}
	
	
	@Given("I verify the title is: {string}")
	public void GivenIAmOnTheHomePage(String title) {
		SchwabTest.VerifyTitle(title);
	}
	
	@When("I verify the url is: {string}")
	public void WhenIVerifyURL(String url){
		SchwabTest.VerifyURL(url);
	}
	

	
}