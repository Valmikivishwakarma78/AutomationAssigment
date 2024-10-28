package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {

	/**
	 * 
	 * @param key
	 * @return value of the given key
	 */
	public static String readValue(String key) {
		Properties prop = new Properties();
		FileInputStream fis = null;
		if (key == null) {
			return null;
		}
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config/config.properties");
		} catch (FileNotFoundException e) {
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
		}
		return prop.getProperty(key);
	}
}
