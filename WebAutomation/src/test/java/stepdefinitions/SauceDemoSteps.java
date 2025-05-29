package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.SauceDemoTests;

public class SauceDemoSteps {

	public SauceDemoSteps() {
		SauceDemoTests = new SauceDemoTests();
	}

	SauceDemoTests SauceDemoTests;

	@Then("I enter (.*) user credentials on SauceDemo site")
	public void EnterUserCredentials(String role, DataTable dataTable) {
		SauceDemoTests.EnterUserCredSauceDemo(dataTable);

	}

	@Then("I verify user is on the main page")
	public void ThenIVerifyUserIsOnTheMainPage() {
		SauceDemoTests.VerifyProductPage();
	}

	@Then("I logout")
	public void ThenILogout() {
		SauceDemoTests.VerifyICanLogout();
	}

	@Then("I (.*) the item (.*) to the cart")
	public void ThenIAddAnItemToTheCart(String action, String item) {
		SauceDemoTests.AddItemToCart(item, action);
	}

	@Then("I (.*) the item to the cart")
	public void _ThenIAddAnItemToTheCart(String action, DataTable dataTable) {
		SauceDemoTests.AddItemToCart(dataTable, action);
	}

	@Then("I verify it was added to the cart")
	public void ThenIVerifyItWasAddedToTheCart(DataTable dataTable) {
		SauceDemoTests.VerifyItemsInCart(dataTable);
	}

	@Then("I clear the cart")
	public void ThenIClearTheCart() {
		SauceDemoTests.ClearCart();
	}

	@Then("I verify items in cart before removing")
	public void ThenIVerifyItemsInCartBeforeRemoving(DataTable dataTable) {
		SauceDemoTests.VerifyItemsInCart(dataTable);
		SauceDemoTests.ClearCart();
	}
}