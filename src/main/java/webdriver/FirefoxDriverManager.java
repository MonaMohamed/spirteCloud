package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class FirefoxDriverManager extends DriverManager{
	
	@Override
	public void createWebDriver(){
		
		FirefoxOptions options = new FirefoxOptions();
		this.driver = new EventFiringWebDriver((WebDriver) options);


	}
}
