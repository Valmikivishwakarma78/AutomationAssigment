package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.TestBase;
import constants.AppConstants;
import pages.LoginPage;

public class InvalidLoginTest extends TestBase {

	private LoginPage loginPage;

	@BeforeClass
	public void beforeClass() {
		loginPage = new LoginPage(driver);
	}

	@Test(priority = 0)
	public void verifyLoginTestInvalidData() {
		int rows = excel.getRowCount(AppConstants.SHEET_NAME);
		int columns = excel.getColumnCount(AppConstants.SHEET_NAME);
		for (int i = 2; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				String username = excel.getCellData(AppConstants.SHEET_NAME, "UserName", i);
				String password = excel.getCellData(AppConstants.SHEET_NAME, "Password", i);
				String errorMessage = excel.getCellData(AppConstants.SHEET_NAME, "ErrorMessage", i);
				loginPage.doLogin(username, password);
				Assert.assertEquals(loginPage.getErrorMessageDisplayed(), errorMessage);
			}
		}
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
