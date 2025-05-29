package pages.SauceDemo;

import org.openqa.selenium.By;

public class SauceDemoInventoryPage extends SauceDemoBasePage {
	public String title = "Products";
	public By Menu = By.id("react-burger-menu-btn");
	public By Title = By.xpath("//span[contains(@class,'title')]");
	public By ShoppingCartLink = By.xpath("//a[contains(@class,'shopping_cart_link')]");
	public By CartDescription = By.xpath("//div[contains(@class,'cart_list')]");
	public By ShoppingCartBadge = By.xpath("//span[contains(@class,'shopping_cart_badge')]");
	public By RemoveButton = By.xpath("//button[contains(text(),'Remove')]");

	public By SauceLabsBackpack(String action) {
		return By.id(action + "-to-cart-sauce-labs-backpack");
	}

	public By SauceLabsBikeLight(String action) {
		return By.id(action + "-to-cart-sauce-labs-bike-light");
	}

	public By SauceLabsBoltTshirt(String action) {
		return By.id(action + "-to-cart-sauce-labs-bolt-t-shirt");
	}

	public By SauceLabsFleeceJacket(String action) {
		return By.id(action + "-to-cart-sauce-labs-fleece-jacket");
	}

	public By SauceLabsOnsie(String action) {
		return By.id(action + "-to-cart-sauce-labs-onesie");
	}

	public By SauceLabsTshirtRed(String action) {
		return By.id(action + "-to-cart-test.allthethings()-t-shirt-(red)");
	}
}