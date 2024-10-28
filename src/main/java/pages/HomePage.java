package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CoreFunctions;
import utilities.WaitUtils;

public class HomePage {

	private WaitUtils waitUtils;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		waitUtils = new WaitUtils(driver);
	}

	@FindBy(css = "div.app_logo")
	private WebElement _swagLabsLogo;

	@FindBy(css = "span.title")
	private WebElement _labelHeaderProduct;

	@FindBy(id = "react-burger-menu-btn")
	private WebElement _btnMenuOptions;

	@FindBy(id = "logout_sidebar_link")
	private WebElement _btnLogOut;

	@FindBy(css = "div.inventory_item_price")
	private List<WebElement> _productPrices;

	@FindBy(css = ".product_sort_container")
	private WebElement _filterDropdown;

	@FindBy(css = "div.app_logo")
	private WebElement _swagLabsHeaderLogo;

	@FindBy(xpath = "//span[contains(text(),'Products')]")
	private WebElement _productLabel;

	@FindBy(name = "add-to-cart-sauce-labs-backpack")
	private WebElement _btnAddToCart;

	@FindBy(css = "a.shopping_cart_link")
	private WebElement _getCartLink;

	public boolean verifyLogoDisplayed() {
		try {
			return CoreFunctions.checkElementIsDisplayed(_swagLabsLogo);
		} catch (Exception e) {
			return false;
		}
	}

	public void doLogOut() {
		CoreFunctions.clickElement(_btnMenuOptions);
		waitUtils.waitForElementVisibility(_btnLogOut, 10);
		CoreFunctions.clickElement(_btnLogOut);
	}

	public List<WebElement> getPriceList() {
		return _productPrices;
	}

	public WebElement getDropdown() {
		return _filterDropdown;
	}

	public WebElement getLogoHeader() {
		return _swagLabsHeaderLogo;
	}

	public WebElement getShoppingLink() {
		return _getCartLink;
	}

	public WebElement getProductLabel() {
		return _productLabel;
	}

	public void addToCart() {
		_btnAddToCart.click();
	}

}
