package driverFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInitilization {
	
	
	 WebDriver driver;
	Properties prop;
	
	/**
	 * 
	 * @param browser
	 * @return
	 */
	
 public WebDriver driver_int(String browser) {
	//String browser = "chrome";
	 if (browser.equalsIgnoreCase("chrome")) {
		 WebDriverManager.chromedriver().setup();
          ChromeOptions co = new ChromeOptions();
          co.setHeadless(true);
		// co.addArguments("--remote-allow-origins=*");
		 driver = new ChromeDriver(co);
	 }
	 else  if (browser.equalsIgnoreCase("firefox")) {
		 WebDriverManager.firefoxdriver().setup();
		 FirefoxOptions fo = new FirefoxOptions();
		 fo.setHeadless(true);
		// fo.addArguments("--remote-allow-origins=*");
		 driver = new FirefoxDriver(fo);
	 }
	 else  if (browser.equalsIgnoreCase("edge")) {
		 WebDriverManager.edgedriver().setup();
		// EdgeOptions eo = new EdgeOptions();
		// eo.setHeadless(true);
		 driver = new EdgeDriver();
	 }
	 else { System.out.println("Please pass the correct browser");}
	 
	 driver.manage().deleteAllCookies();
	 driver.manage().window().maximize();
	 //driver.get(prop.getProperty("www.google.com"));
	 driver.get("https://www.google.com");
	 return driver;
 }
 
 /**
  * 
  * @return
  */
 public Properties props_init() {
	 
	 try {
		FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
		prop = new Properties();
		prop.load(ip);
		
	} catch (FileNotFoundException e) {
				e.printStackTrace();
	} catch (IOException e) {
			e.printStackTrace();
	}
	 return prop;
 }
 

}
