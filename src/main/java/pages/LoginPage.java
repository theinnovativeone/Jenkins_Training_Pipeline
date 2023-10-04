package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;
import utils.PropertyFileReader;

public class LoginPage extends BasePage {

	protected final WebDriver driver;

	By usernameField = By.name("username");
	By passwordField = By.name("password");
	By loginButton = By.cssSelector("div.orangehrm-login-layout div.orangehrm-login-layout-blob div.orangehrm-login-container div.orangehrm-login-slot-wrapper div.orangehrm-login-slot div.orangehrm-login-form form.oxd-form:nth-child(2) div.oxd-form-actions.orangehrm-login-action:nth-child(4) > button.oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button");
	By errorMessage = By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]");
	By dashboard = By.xpath("//header/div[1]/div[1]/span[1]/h6[1]");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUsername(String name) {
		String tempUsername = PropertyFileReader.getTestData(name);
		enterText(driver, usernameField, tempUsername);
	}

	public void enterPassword(String password) {
		String tempPassword = PropertyFileReader.getTestData(password);
		enterText(driver, passwordField, tempPassword);
	}

	public void clickLogin() {
		clickElement(driver, loginButton);
	}

	public boolean isOnDashboardPage() {
		return isElementDisplayed(driver, dashboard);
	}
	
	public boolean isLoginButtonDisplayed() {
		return isElementDisplayed(driver, loginButton);
	}
	
	public boolean isErrorMessageDispayed() {
		return isElementDisplayed(driver, errorMessage);
	}
}
