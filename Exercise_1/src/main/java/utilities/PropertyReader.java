package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	
	
	public static Properties properties = new Properties();
	
	public static void getPropertyValues() throws IOException { 
		
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(".\\src\\main\\resources\\config.properties");
			properties.load(inputStream);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	
	}
	
	public static String getProperty(String propertyKey) {

		return properties.getProperty(propertyKey);
	}

}
