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
	
	
	 static WebDriver driver;
	Properties prop;
	OptionsManager optionsManager;
	//public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	//public static Logger log = Logger.getLogger(DriverInitilization.class);
	
	/**
	 * 
	 * @param browser
	 * @return
	 */
	
 public WebDriver driver_int(Properties prop) {
	 
	 String browser = prop.getProperty("browser").trim();
	 String browser123 = prop.getProperty("huburl").trim();
	 System.out.println(browser);
	 System.out.println(browser123);
System.out.println("Hi venki" + browser);
if (browser.equalsIgnoreCase("chrome")) { 
	//String browser = "chrome";
 if (Boolean.parseBoolean(prop.getProperty("remote"))) { 
	
	 init_remoteDriver(browser); 
	
 }
 else {
		 WebDriverManager.chromedriver().setup();
          ChromeOptions co = new ChromeOptions();
          co.setHeadless(Boolean.parseBoolean(prop.getProperty("headless")));
		// co.addArguments("--remote-allow-origins=*");
		 driver = new ChromeDriver(co);
	 } }
 
 
	 else  if (browser.equalsIgnoreCase("firefox")) {
		 
		 if (Boolean.parseBoolean(prop.getProperty("remote"))) { 
				
			 init_remoteDriver(browser); 
		 
		 }
		 else {
			 System.out.println("remote true");
			 WebDriverManager.firefoxdriver().setup();
			 FirefoxOptions fo = new FirefoxOptions();
			 fo.setHeadless(Boolean.parseBoolean(prop.getProperty("headless")));
			// fo.addArguments("--remote-allow-origins=*");
			 driver = new FirefoxDriver(fo);
			 System.out.println("remote true1");
			 } }	
	 
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
 
	private void init_remoteDriver(String browserName) {

		System.out.println("Running tests on remote grid server: " + browserName);

		if (browserName.equalsIgnoreCase("chrome")) {
			try {
				driver =
						new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), optionsManager.getChromeOptions());
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		} else if (browserName.equalsIgnoreCase("firefox")) {
		
			try {
				driver =
						new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), optionsManager.getFirefoxOptions());
				System.out.println("Hi venki hub firefox-venki");
				String ulr = prop.getProperty("huburl");
				System.out.println(ulr+ 123 );
				System.out.println("hi ulr 123" );
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}

	}

	public static WebDriver getDriver() {
		return driver ;
	}
 /**
  * 
  * @return
  */
 public Properties props_init() {
	 
	 try {
		FileInputStream ip = new FileInputStream("./src/test/resources/config.properties");
		//\src\test\resources\config.properties
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
