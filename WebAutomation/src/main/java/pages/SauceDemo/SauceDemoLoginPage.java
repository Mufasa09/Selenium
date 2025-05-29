package pages.SauceDemo;

import org.openqa.selenium.By;

public class SauceDemoLoginPage
    {
        public String title = "Swag Labs";

        public String AccountUserName = "";
        public String AccountPassword = "";
        public int RandomIndex = 0;
        public By UserNameTextBox = By.id("user-name");
        public By PasswordTextBox = By.id("password");
        public By LoginButton = By.id("login-button");
        public By LoginUserCredentialsText = By.id("login_credentials");
        public By LoginPasswordCredentialsText = By.xpath("//div[contains(@class,'login_password')]");
        public By LoginFailureText = By.xpath("//*[contains(@text,'Epic sadface: Sorry, this user has been locked out.')]");
        public By LoginErrorContainer = By.xpath("//h3[contains(@data-test,'error')]");
    }