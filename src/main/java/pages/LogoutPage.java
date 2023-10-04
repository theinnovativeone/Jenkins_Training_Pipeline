package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class LogoutPage extends BasePage{

protected final WebDriver driver;
	
	By mainMenu = By.xpath("//header/div[1]/div[2]/ul[1]/li[1]/span[1]");
	By logoutOption = By.xpath("//a[contains(text(),'Logout')]");
	
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
	}

	public void logout() throws InterruptedException {
		clickElement(driver, mainMenu);
		clickElement(driver, logoutOption);
	}
}
