package com.qa.google.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import driverFactory.DriverInitilization;
import pages.GooglePage;

public class BaseTest {
	DriverInitilization df;
	WebDriver driver;
 //Properties prop;
	protected GooglePage gglpg;
	
@BeforeTest
public void setup() {
	
	df = new DriverInitilization();
	//prop = df.props_init();
	driver = df.driver_int("firefox");
	 gglpg = new GooglePage(driver);
	
	
	
}
@AfterTest
public void teardown() {
driver.quit();
}
	
}
