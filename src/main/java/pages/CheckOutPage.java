package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

	public WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first-name")
	private WebElement _firstName;

	@FindBy(id = "last-name")
	private WebElement _lastName;

	@FindBy(id = "postal-code")
	private WebElement _postalCode;

	@FindBy(id = "continue")
	private WebElement _continueButton;

	public void addCheckOutInfo(String fName, String lName, String pCode) {
		_firstName.sendKeys(fName);
		_lastName.sendKeys(lName);
		_postalCode.sendKeys(pCode);
	}

	public void continueCheckOut() {
		_continueButton.click();
	}

}
