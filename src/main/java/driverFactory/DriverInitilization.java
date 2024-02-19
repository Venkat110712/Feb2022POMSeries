package driverFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;



import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInitilization {
	
	
	 WebDriver driver;
	Properties prop;
	OptionsManager optionsManager;
	//public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	//public static Logger log = Logger.getLogger(DriverInitilization.class);
	
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
 
//	private void init_remoteDriver(String browserName) {
//
//		System.out.println("Running tests on remote grid server: " + browserName);
//
//		if (browserName.equalsIgnoreCase("chrome")) {
//			try {
//				tlDriver.set(
//						new RemoteWebDriver(new URL(prop.getProperty("huburl")), optionsManager.getChromeOptions()));
//			} catch (MalformedURLException e) {
//				e.printStackTrace();
//			}
//		} else if (browserName.equalsIgnoreCase("firefox")) {
//			try {
//				tlDriver.set(
//						new RemoteWebDriver(new URL(prop.getProperty("huburl")), optionsManager.getFirefoxOptions()));
//			} catch (MalformedURLException e) {
//				e.printStackTrace();
//			}
//		}
//
//	}

//	public static WebDriver getDriver() {
//		return tlDriver.get();
//	}
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
 
 public String getScreenshot() {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
 

}
