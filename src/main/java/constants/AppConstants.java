package constants;

import utilities.PropertiesFileReader;
import utilities.StringUtils;

public class AppConstants {

	// Order Product details
	public static final String CUSTOMER_FIRST_NAME = "Automation User" + StringUtils.getRandomNumber();
	public static final String CUSTOMER_LAST_NAME = "Tester";
	public static final String ZIP_CODE = "132009";
	public static final String CARD_INFO = "SauceCard #31337";
	public static final String FINAL_PRICE = "Total: $32.39";
	public static final String THANK_YOUR_MESSAGE = "Thank you for your order!";
	public static final String ORDER_CONFIRMATION_SUCCESS_MESSAGE = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";

	// *******************default time out values************//
	public static final long IMPLICIT_WAIT = 10;
	public static final int SHORT_TIME_OUT = 5;
	public static final int MEDIUM_TIME_OUT = 10;
	public static final int LONG_TIME_OUT = 15;

	// ********************Excel Sheet Names *********************//
	public static final String SHEET_NAME = "TestData";

	// App Credentials
	public static final String USERNAME = PropertiesFileReader.readValue("username");
	public static final String PASSWORD = PropertiesFileReader.readValue("password");
	
	//Filter Sorting criteria
	public static final String FILTER_HIGH_LOW="Price (high to low)";
	public static final String FILTER_LOW_HIGH="Price (low to high)";
	
	//Test App URL
	public static final String APP_URL = "https://www.saucedemo.com/";

}
