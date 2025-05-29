package stepdefinitions;
import io.cucumber.java.en.*;
import tests.BaseTestClass;

public class BaseSteps{
	
	BaseTestClass Tests;
    public BaseSteps(){
    	Tests = new BaseTestClass();
    }



    @When("I verify the title of the site is {string}")
    public void VerifySiteTitle(String title) throws InterruptedException {
    	Tests.VerifyTitle(title);  
    	}


}
