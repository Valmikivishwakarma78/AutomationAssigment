package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage {

	public WebDriver driver;

	public YourCartPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div.inventory_item_name")
	private WebElement _itemNameLabel;

	@FindBy(css = ".item_pricebar")
	private WebElement _priceLabel;

	@FindBy(id = "checkout")
	private WebElement _checkOutLink;

	@FindBy(css = "a.shopping_cart_link")
	private WebElement _shoppingCartLink;

	public WebElement getShoppingCartLink() {
		return _shoppingCartLink;
	}

	public WebElement getItemName() {
		return _itemNameLabel;
	}

	public WebElement getPrice() {
		return _priceLabel;
	}

	public WebElement getCheckOut() {
		return _checkOutLink;
	}

}
