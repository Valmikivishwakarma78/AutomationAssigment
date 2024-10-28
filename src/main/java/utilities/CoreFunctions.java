package utilities;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CoreFunctions {

	private static WebDriver driver;
	private static Actions act;

	public CoreFunctions(WebDriver driver) {
		this.driver = driver;
		act = new Actions(driver);
	}

	public static void enterText(WebElement locator, String value) {
		if (value != null) {
			locator.sendKeys(value);
		}
		else {
			System.out.println("value can not be null while using sendKeys method");
		}
	}

	public static void clearTextBox(WebElement locator) {
		locator.clear();
	}

	public static void clickElement(WebElement elementToClick) {
		elementToClick.click();
	}

	public static String getElementText(WebElement locator) {
		String eleText = getElement(locator).getText();
		return eleText;
	}

	public static String doElementGetText(WebDriver driver, WebElement element) {
		String eleText = element.getText();
		return eleText;
	}

	public static WebElement getLinkEleByText(String linkText) {
		return driver.findElement(By.linkText(linkText));
	}

	public static boolean checkElementIsDisplayed(WebElement locator) {
		return getElement(locator).isDisplayed();
	}

	public static String getElementAttribute(WebElement locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}

	public static boolean checkElementIsDisabled(WebElement locator) {
		String disabledValue = getElement(locator).getAttribute("disabled");
		if (disabledValue.equals("true")) {
			return true;
		}
		return false;
	}

	public static WebElement getElement(WebElement element) {
		if (element == null)
			return element;
		else
			return element;
	}

	public int getElementsCount(By locator) {
		return getElements(locator).size();
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public List<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();// pc=0
		for (WebElement e : eleList) {
			String text = e.getText();
			if (!text.isEmpty()) {
				eleTextList.add(text);
			}
		}
		return eleTextList;
	}

	public static void clickOnElement(By locator, String linkText) {
		List<WebElement> linksList = getElements(locator);
		System.out.println("total number of links = " + linksList.size());

		for (WebElement e : linksList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(linkText)) {
				e.click();
				break;
			}
		}
	}

	public static void doSearch(By searchLocator, By searchSuggLocator, String searchKey, String suggName)
			throws InterruptedException {
	    // doSendKeys(searchLocator, searchKey);
		List<WebElement> suggList = getElements(searchSuggLocator);
		for (WebElement e : suggList) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains(suggName)) {
				e.click();
				break;
			}
		}
	}

	// ****************************Drop Down Utils************************//
	public static void doSelectDropDownByIndex(WebElement locator, int index) {
		if (index < 0) {
			System.out.println("please pass the right (+ve) index");
			return;
		}
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public static void doSelectDropDownByVisibleText(WebElement locator, String visibleText) {
		if (visibleText == null) {
			System.out.println("please pass the right visible text and it can not be null");
			return;
		}
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(visibleText);
	}

	public static void doSelectDropDownByValue(WebElement locator, String value) {
		if (value == null) {
			System.out.println("please pass the right visible text and it can not be null");
			return;
		}
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	public static int getDropDownOptionsCount(WebElement locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions().size();
	}

	public static List<String> getDropDownTextList(WebElement locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		List<String> optionsTextList = new ArrayList<String>();
		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			optionsTextList.add(text);
		}
		return optionsTextList;
	}

	public static void doSelectDropDownValue(WebElement locator, String dropDownValue) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();

		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(dropDownValue)) {
				e.click();
				break;
			}
		}
	}

	public static void doSelectDropDownValueUsingLocator(By locator, String dropDownValue) {
		List<WebElement> optionsList = getElements(locator);
		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(dropDownValue)) {
				e.click();
				break;
			}
		}
	}

	// ****************Actions utils********************//

	public static void doActionsClick(WebElement locator) {
		act.click(getElement(locator)).perform();
	}

	public static void doActionsSendKeys(WebElement locator, String value) {
		act.sendKeys(getElement(locator), value).perform();
	}

	public static void selectRightClickOption(WebElement contextMenuLocator, String optionValue) {
		act.contextClick(getElement(contextMenuLocator)).perform();
		By optionLocator = By.xpath("//*[text()='" + optionValue + "']");
		//clickElement(optionLocator);
	}

	/**
	 * this method will handle the menu upto two levels
	 * 
	 * @param level1MenuLocator
	 * @param level2MenuLocator
	 * @throws InterruptedException
	 */
	public void multiLevelMenuHandling(WebElement level1MenuLocator, By level2MenuLocator) throws InterruptedException {
		act.moveToElement(getElement(level1MenuLocator)).perform();
		// doClick(level2MenuLocator);
	}

	public static void multiLevelMenuHandling(WebElement level1Locator, String level2, String level3, String level4)
			throws InterruptedException {
		act.moveToElement(getElement(level1Locator)).perform();
		act.moveToElement(getLinkEleByText(level2)).perform();
		act.moveToElement(getLinkEleByText(level3)).perform();
		getLinkEleByText(level4).click();

	}

	public static void multiLevelMenuHandling(WebElement level1Locator, String level2, String level3)
			throws InterruptedException {
		act.moveToElement(getElement(level1Locator)).perform();
		act.moveToElement(getLinkEleByText(level2)).perform();
		getLinkEleByText(level3).click();
	}

}
