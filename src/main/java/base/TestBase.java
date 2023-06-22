package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import objects.HomePage;
import utils.Configuration;
import utils.Key;
import static utils.Key.*;
import static utils.Browsers.*;


public class TestBase {

	protected WebDriver driver;
	protected HomePage homepage;
	Configuration config = new Configuration();

	@BeforeMethod
	public void BeforeEachTest() {
		String browserName=config.readProp(getValueOfKey(browser));
		initiateDriver(browserName);
		initObject();
		driver.manage().window().maximize();
		int pageLoadTime=config.readPropNum(getValueOfKey(pageLoad));
		int implicitLoadTime=config.readPropNum(getValueOfKey(implicitLoad));	
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTime));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitLoadTime));
		String urlName=config.readProp(getValueOfKey(url));
		driver.get(urlName);

	}

	public void initiateDriver(String browserName) {
		switch (browserName) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case SAFARI:
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;

		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	private String getValueOfKey(Key k) {
		return k.name();
	}
	
	
	public void initObject() {
		homepage=new HomePage(driver);
	}
	
	

}
