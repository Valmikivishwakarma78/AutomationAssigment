package testcases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import constants.AppConstants;
import pages.HomePage;
import pages.LoginPage;
import utilities.CoreFunctions;

public class VerifyAscendingOrderProductPriceTest extends TestBase {

	private HomePage homePage;
	private LoginPage loginPage;
	
	@BeforeClass
	public void beforeClass() {
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
	}

	@Test(priority=0)
	public void verifyLoginTest() {
		loginPage.doLogin(AppConstants.USERNAME, AppConstants.PASSWORD);
		Assert.assertTrue(homePage.verifyLogoDisplayed());
	}

	@Test(priority = 1)
	public void verifyPriceTest() throws InterruptedException {
		List<WebElement> priceList = homePage.getPriceList();
		List<Double> beforeSortingPriceList = new ArrayList<>();
		for (WebElement price : priceList) {
			beforeSortingPriceList.add(Double.valueOf(price.getText().replace("$", "")));
		}
		CoreFunctions.doSelectDropDownByVisibleText(homePage.getDropdown(), AppConstants.FILTER_LOW_HIGH);
		//After applying the filter capture the prices
		List<WebElement> filteredPriceList = homePage.getPriceList();
		List<Double> afterSortingPriceList = new ArrayList<>();
		for (WebElement price : filteredPriceList) {
			afterSortingPriceList.add(Double.valueOf(price.getText().replace("$", "")));
		}
		Collections.sort(beforeSortingPriceList);
		Assert.assertEquals(beforeSortingPriceList, afterSortingPriceList);
	}
	
	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
