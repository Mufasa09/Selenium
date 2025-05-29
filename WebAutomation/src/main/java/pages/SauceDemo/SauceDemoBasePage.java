package pages.SauceDemo;

import org.openqa.selenium.By;

public class SauceDemoBasePage
    {
        public By MenuButton = By.id("react-burger-menu-btn");
        public By AllItemsLink = By.id("inventory_sidebar_link");
        public By AboutLink = By.id("about_sidebar_link");
        public By ResetAppState = By.id("reset_sidebar_link");
        public By LogoutLink = By.id("logout_sidebar_link");
        public By ShoppingCart = By.xpath("//a[contains(@class,'shopping_cart_link')]");


    }