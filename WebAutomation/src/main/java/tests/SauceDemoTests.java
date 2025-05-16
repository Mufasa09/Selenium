package tests;

import pages.SauceDemoPage;

public class SauceDemoTests extends BaseTestClass{
	
	
	public SauceDemoTests() {
		sauceDemoPage = new SauceDemoPage();
	}
	/* Variables */
	SauceDemoPage sauceDemoPage;
	
	/*Methods*/
	public void EnterUserCredSauceDemo(String user) {
		Enter(sauceDemoPage.UserNameTextBox,"");
		Enter(sauceDemoPage.UserNameTextBox,"");
	}
	
	public void VerifyLoginError() {

		
	}
	
}