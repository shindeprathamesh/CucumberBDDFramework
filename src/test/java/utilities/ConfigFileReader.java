package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	public Properties config = new Properties();
	public static FileInputStream fis;

	public String propertyReader(String value) {

		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\config\\Config.properties");
		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		}
		try {
			config.load(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}

		return config.getProperty(value);

	}
	
	//URL
	public String getURL() {
		
		return propertyReader("url");
	}

	// DriverPath
	public String getDriverPath() {

		return propertyReader("driverpath");

	}

	// ImplicitWait
	public String getImplicitWait() {

		return propertyReader("implicitWait");

	}
	
	//SystemPropertyBrowser
	public String getSystemPropertyBrowser(){
		
		return propertyReader("setpropertyBrowser");
	}
	
	//Extent Config Path
	public String getExtentConfigPath() {
		
		return propertyReader("reportConfigPath");
	}
}
