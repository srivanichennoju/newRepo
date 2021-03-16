package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	static WebDriver driver;
	static Properties prop;

public BaseTest() {
		
	prop = new Properties();
	FileInputStream inputStream;
	try {
		inputStream = new FileInputStream(".\\src\\main\\resources\\config.properties");
		try {
			prop.load(inputStream);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {

		e.printStackTrace();
	}
	
}

public void initializeChromeBrowser() {
	
	String Browsername = prop.getProperty("Browser");
	
	if(Browsername.equals("Chrome")) {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	}
	
	String Url = prop.getProperty("Url");
	System.out.println(Url);
	driver.get(Url);
	driver.manage().window().maximize();

}

public void closeBrowser() {
	
	driver.quit();
}

}
