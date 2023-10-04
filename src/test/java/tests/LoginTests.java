package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTests extends BaseTest{
	WebDriver driver;
	LoginPage login;
	
	@BeforeMethod
	public void setup() {
		driver = initialization();
	}
	
	
	@Test
	public void verifyLoginWithValidCredentials() {
		login = new LoginPage(driver);
		login.enterUsername("validUsername");
		login.enterPassword("validPassword");
		login.clickLogin();
		
		boolean isDashboardTitleDisplayed = login.isOnDashboardPage();
		
		Assert.assertTrue(isDashboardTitleDisplayed, "Login failed with valid credentials!");
	}
	
	@Test
	public void verifyLoginWithValidUsernameAndInvalidPassword() {
		login = new LoginPage(driver);
		
		login.enterUsername("validUsername");
		login.enterPassword("invalidPassword");
		login.clickLogin();
		
		boolean isErrMessageDisplayed = login.isErrorMessageDispayed();
		
		Assert.assertTrue(isErrMessageDisplayed, "Logged-in successfully with invalid password!");
	}
	
	@Test
	public void verifyLoginWithInvalidUsernameAndValidPassword() {
		login = new LoginPage(driver);
		
		login.enterUsername("invalidUsername");
		login.enterPassword("validPassword");
		login.clickLogin();
		
		boolean isErrMessageDisplayed = login.isErrorMessageDispayed();
		
		Assert.assertTrue(isErrMessageDisplayed, "Logged-in successfully with invalid username!");
	}
	
	@Test
	public void verifyLoginWithInvalidCredentials() {
		login = new LoginPage(driver);
		
		login.enterUsername("invalidUsername");
		login.enterPassword("invalidPassword");
		login.clickLogin();
		
		boolean isErrMessageDisplayed = login.isErrorMessageDispayed();
		
		Assert.assertTrue(isErrMessageDisplayed, "Logged-in successfully with invalid credentials!");
	}
	
	@AfterMethod
	public void closeDown(){
		tearDown();
	}
}
