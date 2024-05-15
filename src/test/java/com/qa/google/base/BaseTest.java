package com.qa.google.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import driverFactory.DriverInitilization;
import google.listener.TestAllureListener;
import pages.GooglePage;

public class BaseTest {
	DriverInitilization df;
	public WebDriver driver;
 protected Properties prop;
	protected GooglePage gglpg;
	//protected TestAllureListener tl;
	
@BeforeTest
public void setup() {
	
	df = new DriverInitilization();
	prop = df.props_init();
	driver = df.driver_int(prop);
//tl = new TestAllureListener(driver);
	 gglpg = new GooglePage(driver);
	
	
	
}
@AfterTest
public void teardown() {
driver.quit();
}
	
}
