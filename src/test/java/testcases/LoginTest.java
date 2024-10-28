package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.TestBase;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends TestBase {

	private LoginPage loginPage;
	private HomePage homePage;

	@BeforeClass
	public void beforeClass() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}

	@Test(priority = 0, dataProvider = "LoginDataProvider")
	public void verifyLoginTest(String username, String password) {
		loginPage.doLogin(username, password);
		Assert.assertTrue(homePage.verifyLogoDisplayed());
		homePage.doLogOut();
	}

	@Test(priority = 1, dependsOnMethods = "verifyLoginTest")
	public void verifySauceLabLogoTest() {
		Assert.assertTrue(loginPage.isLogoDisplayed());
	}

	@DataProvider(name = "LoginDataProvider")
	public Object[][] LoginData() {
		return new Object[][] { { "standard_user", "secret_sauce" }, { "problem_user", "secret_sauce" },
				{ "performance_glitch_user", "secret_sauce" }, { "error_user", "secret_sauce" },
				{ "visual_user", "secret_sauce" } };
	}

	@AfterClass
	public void afterClass() {
		driver.close();

	}
}
