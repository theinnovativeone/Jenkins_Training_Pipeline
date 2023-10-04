package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.PropertyFileReader;

public class BaseTest {
	
	public static WebDriver driver;
	public static String browserName = null;
	public static String url = null;
	protected static ChromeOptions chromeOptions;
	
	
	protected static WebDriver initialization() {
		browserName = PropertyFileReader.getConfigData("browser");
		driver = getDriver(browserName);
		driver.manage().window().maximize();
		BaseTest.navigateToUrl(driver);
		return driver; 
	}
	
	
	private static WebDriver getDriver(String browserName) {
	
		if (browserName.equalsIgnoreCase("chrome")) {
			chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--start-maximized");
			return new ChromeDriver(chromeOptions);
			
		} else if (browserName.equalsIgnoreCase("firefox")) {
			return new FirefoxDriver();
			
		} else if (browserName.equalsIgnoreCase("edge")) {
			return new EdgeDriver();
		}
		
		return null;
	}

	
	public static void navigateToUrl(WebDriver driver) {
		url = PropertyFileReader.getConfigData("url");
		driver.get(url);
	}


	public static void tearDown() {
		if (null != driver) {
			driver.quit();
		}
	}
}
