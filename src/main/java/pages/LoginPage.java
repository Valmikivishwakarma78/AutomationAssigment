package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CoreFunctions;
import utilities.WaitUtils;

public class LoginPage {

	private WaitUtils waitUtils;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		waitUtils = new WaitUtils(driver);
	}

	@FindBy(id = "user-name")
	private WebElement _txtUsername;

	@FindBy(id = "password")
	private WebElement _txtPassword;

	@FindBy(id = "login-button")
	private WebElement _btnLogin;

	@FindBy(css = "div.error-message-container")
	private WebElement _loginErrorMessage;

	@FindBy(css = "div.login_logo")
	private WebElement _loginHeaderLogo;

	public void doLogin(String username, String password) {
		CoreFunctions.clearTextBox(_txtUsername);
		CoreFunctions.enterText(_txtUsername, username);
		CoreFunctions.clearTextBox(_txtPassword);
		CoreFunctions.enterText(_txtPassword, password);
		CoreFunctions.clickElement(_btnLogin);
	}

	public String getErrorMessageDisplayed() {
		waitUtils.waitForElementVisibility(_loginErrorMessage, 5);
		String loginErrorMessage = CoreFunctions.getElementText(_loginErrorMessage);
		return loginErrorMessage;
	}
	
	public boolean isLogoDisplayed() {
		boolean logoDisplayed=CoreFunctions.checkElementIsDisplayed(_loginHeaderLogo);
		return logoDisplayed;
	}
}
