package stepdefinitions;

import io.cucumber.java.en.*;
import tests.GoogleTests;

public class GoogleSteps{
	
    GoogleTests googleTests;
    
    public GoogleSteps(){
    	googleTests = new GoogleTests();
    }

    @Given("I am on the Google homepage")
    public void i_am_on_google_homepage() {
    	googleTests.openGoogleHomePage();
    }

    @When("I search for {string}")
    public void i_search_for(String query) {
        googleTests.searchGoogle(query);
    }

    @Then("search results should be shown")
    public void search_results_should_be_shown(String results) {
    	googleTests.verifyResults(results);
    }
}
