package util;

import java.io.IOException;
import java.util.Properties;

/*
 * Class that extracts properties from the prop file.
 * @author Raaghav A S, Automation Tester
 * Cognizant Technology Solutions 
 * Assoicate ID : 286440
 */

public class PropertyLoader {

	private static final String PROP_FILE = "/application.properties";

	private PropertyLoader() {
	}

	public static String loadProperty(String name) {
		Properties props = new Properties();
		try {
			props.load(PropertyLoader.class.getResourceAsStream(PROP_FILE));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String value = "";

		if (name != null) {
			value = props.getProperty(name);
		}
		return value;
	}
}