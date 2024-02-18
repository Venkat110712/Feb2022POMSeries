package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GooglePage {
	private WebDriver driver;
	
	public GooglePage(WebDriver driver) {		
		this.driver = driver; 
	}
	
	private By SearchBar = By.id("APjFqb");
	private By googlesearchBtn = By.className("gNO89b");
	private By luckyBtn = By.className("RNmpXc");
	
	public boolean getenterSerachContext() {
	return	driver.findElement(SearchBar).isEnabled();
	}
	
	public boolean getsearchbuttonenable() {
		return	driver.findElement(googlesearchBtn).isEnabled();
		}
	
	public String getsearchbuttonlabel() {
			String labelname = driver.findElement(googlesearchBtn).getAttribute("value");
		return labelname;
		}


}
