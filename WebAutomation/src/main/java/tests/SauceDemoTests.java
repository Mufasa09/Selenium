package tests;

import java.util.Map;

import org.openqa.selenium.NoSuchElementException;
import io.cucumber.datatable.DataTable;
import pages.SauceDemo.SauceDemoInventoryPage;
import pages.SauceDemo.SauceDemoLoginPage;
import pages.SauceDemo.SauceDemoPage;
import pages.SauceDemo.SauceDemoCartPage;

public class SauceDemoTests extends BaseTestClass{
	
	SauceDemoPage sauceDemoPage;
	SauceDemoInventoryPage SauceDemoInventoryPage;
	SauceDemoCartPage SauceDemoCartPage;
	SauceDemoLoginPage SauceDemoLoginPage;
	
	public SauceDemoTests() {
		sauceDemoPage = new SauceDemoPage();
		SauceDemoInventoryPage = new SauceDemoInventoryPage();
		SauceDemoCartPage = new SauceDemoCartPage();
        SauceDemoLoginPage = new SauceDemoLoginPage();
	}
	
	/* Variables */
	
	
	
	/*Methods*/
   

    public void EnterUserCredSauceDemo(DataTable dataTable)
    {
    	Map<String, String> data = dataTable.asMap(String.class, String.class);
        Enter(SauceDemoLoginPage.UserNameTextBox, data.get("role"));
        Enter(SauceDemoLoginPage.PasswordTextBox, "secret_sauce");
        Click(SauceDemoLoginPage.LoginButton);
    }

    public void EnterUserCredSauceDemo(String role)
    {
        Enter(SauceDemoLoginPage.UserNameTextBox, role);
        Enter(SauceDemoLoginPage.PasswordTextBox, "secret_sauce");
        Click(SauceDemoLoginPage.LoginButton);
    }

    public void VerifyProductPage()                
    {
        if(driver.findElements(SauceDemoLoginPage.LoginErrorContainer).size() > 0)
            VerifyTextData(SauceDemoLoginPage.LoginErrorContainer, "Epic sadface: Sorry, this user has been locked out.", true);
        else
            VerifyTextData(SauceDemoInventoryPage.Title, "Products", true);
    }

    public void VerifyICanLogout()
    {
        Click(SauceDemoInventoryPage.MenuButton);
        Click(SauceDemoInventoryPage.LogoutLink);
        VerifyDataIsPresent(SauceDemoLoginPage.LoginButton,true);
    }

    public void AddItemToCart(String item, String action)
    {
        switch (item)
        {
            case "Sauce Labs Backpack":
                Click(SauceDemoInventoryPage.SauceLabsBackpack(action));
                break;
            case "Sauce Labs Bike Light":
                Click(SauceDemoInventoryPage.SauceLabsBikeLight(action));
                break;
            case "Sauce Labs Bolt T-Shirt":
                Click(SauceDemoInventoryPage.SauceLabsBoltTshirt(action));
                break;
            case "Sauce Labs Fleece Jacket":
                Click(SauceDemoInventoryPage.SauceLabsFleeceJacket(action));
                break;
            case "Sauce Labs Onesie":
                Click(SauceDemoInventoryPage.SauceLabsOnsie(action));
                break;                
            case "Test.allTheThings() T-Shirt (Red)":
                Click(SauceDemoInventoryPage.SauceLabsTshirtRed(action));
                break;
            default:
            	throw new NoSuchElementException("Not Found");
        }
    }


    public void AddItemToCart(DataTable dataTable, String action)
    {
    	Map<String, String> data = dataTable.asMap(String.class, String.class);
        switch (data.get("item"))
        {
            case "Sauce Labs Backpack":
                Click(SauceDemoInventoryPage.SauceLabsBackpack("add"));
                break;
            case "Sauce Labs Bike Light":
                Click(SauceDemoInventoryPage.SauceLabsBikeLight(action));
                break;
            case "Sauce Labs Bolt T-Shirt":
                Click(SauceDemoInventoryPage.SauceLabsBoltTshirt(action));
                break;
            case "Sauce Labs Fleece Jacket":
                Click(SauceDemoInventoryPage.SauceLabsFleeceJacket(action));
                break;
            case "Sauce Labs Onesie":
                Click(SauceDemoInventoryPage.SauceLabsOnsie(action));
                break;
            case "Test.allTheThings() T-Shirt (Red)":
                Click(SauceDemoInventoryPage.SauceLabsTshirtRed(action));
                break;
            default:
            	throw new NoSuchElementException("Not Found");
        }
    }

    public void VerifyItemsInCart(String data)
    {
        VerifyTextData(SauceDemoInventoryPage.CartDescription,data, true);
    }

    public void VerifyItemsInCart(DataTable dataTable)
    {
    	Map<String, String> data = dataTable.asMap(String.class, String.class);
        Click(SauceDemoCartPage.ShoppingCartLink);
        VerifyTextData(SauceDemoInventoryPage.CartDescription, data.get("ItemName"), true);
    }

    public void ClearCart()
    {
        int finalCount = CartCount();
        for (int cartCount = 1; cartCount <= finalCount; cartCount++)
            Click(SauceDemoInventoryPage.RemoveButton);
    }

    public int CartCount()
    {
        String count = GrabText(SauceDemoInventoryPage.ShoppingCartBadge);
        return Integer.parseInt(count);
    }
}