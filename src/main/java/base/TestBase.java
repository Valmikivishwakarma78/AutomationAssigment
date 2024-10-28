package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import constants.AppConstants;
import utilities.ExcelReader;
import utilities.PropertiesFileReader;

public class TestBase {

	public static WebDriver driver;
	public static String browserName = PropertiesFileReader.readValue("browser");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"/src/test/resources/TestData/TestData.xlsx");

	@BeforeTest
	public void setUp() {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.err.println("Invalid browser name is passed in config.properties file");
		}
		driver.get(AppConstants.APP_URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(AppConstants.IMPLICIT_WAIT));
		driver.manage().deleteAllCookies();
	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
