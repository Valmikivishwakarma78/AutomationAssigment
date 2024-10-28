package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutOverViewPage {

	public WebDriver driver;

	public CheckOutOverViewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "div.summary_value_label")
	private WebElement _getCardInfo;

	@FindBy(xpath = "(//div[@class='summary_value_label'])[2]")
	private WebElement _getShippingInfo;

	@FindBy(css = "div.summary_subtotal_label")
	private WebElement _getTotalPrice;

	@FindBy(css = "div.summary_total_label")
	private WebElement _getFinalPrice;

	@FindBy(id = "finish")
	private WebElement _getFinishButton;

	public WebElement getShippingInfo() {
		return _getShippingInfo;
	}

	public WebElement getTotalPrice() {
		return _getTotalPrice;
	}

	public WebElement getCardInfo() {
		return _getCardInfo;
	}

	public WebElement getFinalPrice() {
		return _getFinalPrice;
	}

	public WebElement getFinishButton() {
		return _getFinishButton;
	}

}
