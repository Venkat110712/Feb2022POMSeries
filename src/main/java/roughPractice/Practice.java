package roughPractice;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		
		
		driver.get("https://www.bigbasket.com");
		
		
		Actions act = new Actions(driver);
		
		By shopbyCat = By.xpath("//*[@id=\"headlessui-menu-button-:R5bab6:\"]/div");
		
		Thread.sleep(5000);
		act.moveToElement(driver.findElement(shopbyCat)).click().perform();
		By beverage = 
By.xpath("//*[@id=\"headlessui-menu-button-:R5bab6:\"]/following-sibling::div/nav/ul/li/a[text() =\"Beverages\"]");
		
		Thread.sleep(5000);
		act.moveToElement(driver.findElement(shopbyCat))
		   .clickAndHold()
		     .perform();
		Thread.sleep(3000);	
		act.moveToElement(driver.findElement(beverage))
		 .clickAndHold().perform();
		Thread.sleep(8000);
		By secondlvl = 
				By.xpath("//*[@id=\"headlessui-menu-items-:R1769b6:\"]/nav/ul[2]/li/a[text() ='Health Drink, Supplement']");
					
					Thread.sleep(5000);	
					
					act.moveToElement(driver.findElement(secondlvl))
					   .clickAndHold()
					     .perform();
		
	
		
		

	}

}
