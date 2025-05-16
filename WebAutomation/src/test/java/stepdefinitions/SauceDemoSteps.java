package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.SauceDemoTests;

public class SauceDemoSteps{
	
	public SauceDemoSteps() {
		sauceDemoTests = new SauceDemoTests();
	}
	
	 SauceDemoTests sauceDemoTests;
	
	    @Given("I navigate to the {string} site")
	    public void I_Navigate_To_The_Site(String site) {
	    	sauceDemoTests.NavigateToPage(site);
	    }
	    
	    @When("I enter {string} user credentials on SauceDemo site")
	    public void I_Enter_User_Cred_On_SauceDemo_Site(String user) {
	    	sauceDemoTests.EnterUserCredSauceDemo(user);
	    }
	    
	    @Then("I verify login error")
	    public void I_Verify_Login_Error() {
	    	sauceDemoTests.VerifyLoginError();
	    }
}