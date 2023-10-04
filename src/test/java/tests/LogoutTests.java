package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.LogoutPage;

public class LogoutTests extends BaseTest {
	WebDriver driver;
	LoginPage login;
	LogoutPage logout;

	@BeforeMethod()
	public void setup() {
		driver = initialization();
	}
	
	@Test
	public void verifyLogout() {
		login = new LoginPage(driver);
		logout = new LogoutPage(driver);
		
		login.enterUsername("validUsername");
		login.enterPassword("validPassword");
		login.clickLogin();
		
		try {
			logout.logout();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean isOnLoginPage = login.isLoginButtonDisplayed();
		
		Assert.assertTrue(isOnLoginPage, "Logout failed");
		
	}
	
	@AfterMethod
	public void closeDown() {
		tearDown();
	}
}
