package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.TestBase;
import constants.AppConstants;
import pages.CheckOutOverViewPage;
import pages.CheckOutPage;
import pages.ConfirmationPage;
import pages.HomePage;
import pages.LoginPage;
import pages.YourCartPage;

public class VerifyEndtoEndTest extends TestBase {

	private LoginPage loginPage;
	private HomePage homePage;
	private ConfirmationPage confirmation;
	private CheckOutPage checkOut;
	private CheckOutOverViewPage overView;
	private YourCartPage yourCart;

	@BeforeClass
	public void setUpClass() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		confirmation = new ConfirmationPage(driver);
		checkOut = new CheckOutPage(driver);
		overView = new CheckOutOverViewPage(driver);
		yourCart = new YourCartPage(driver);
	}

	@Test(priority = 0)
	public void verifyLoginTest() {
		loginPage.doLogin("standard_user", "secret_sauce");
		Assert.assertTrue(homePage.verifyLogoDisplayed());
	}

	@Test(priority = 1, dependsOnMethods = "verifyLoginTest")
	public void addItemToCartTest() {
		homePage.addToCart();
		homePage.getShoppingLink().click();
	}

	@Test(priority = 2, dependsOnMethods = "addItemToCartTest")
	public void verifyCartDetailsTest() {
		 String actualPrice = yourCart.getPrice().getText();
		yourCart.getCheckOut().click();
		homePage.getShoppingLink().click();

	}

	@Test(priority = 3, dependsOnMethods = "verifyCartDetailsTest")
	public void enterCheckOutInfoTest() {
		yourCart.getCheckOut().click();
		checkOut.addCheckOutInfo(AppConstants.CUSTOMER_FIRST_NAME, AppConstants.CUSTOMER_LAST_NAME, AppConstants.ZIP_CODE);
		checkOut.continueCheckOut();
	}

	@Test(priority = 4, dependsOnMethods = "enterCheckOutInfoTest")
	public void verifyCheckOutOverviewTest() {
		Assert.assertEquals(overView.getCardInfo().getText(), AppConstants.CARD_INFO);
		Assert.assertEquals(overView.getFinalPrice().getText(), AppConstants.FINAL_PRICE);
		overView.getFinishButton().click();
	}

	@Test(priority = 5, dependsOnMethods = "verifyCheckOutOverviewTest")
	public void checkOutConfirmationTest() {
		Assert.assertEquals(confirmation.getthankYouMessage().getText(), AppConstants.THANK_YOUR_MESSAGE);
		Assert.assertEquals(confirmation.getCompleteText().getText(),AppConstants.ORDER_CONFIRMATION_SUCCESS_MESSAGE);
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
