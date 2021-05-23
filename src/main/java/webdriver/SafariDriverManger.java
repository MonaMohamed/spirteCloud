package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class SafariDriverManger extends DriverManager {
	
	@Override
	public void createWebDriver() {
		SafariOptions options = new SafariOptions();
		this.driver = new EventFiringWebDriver((WebDriver) options);
	}

}
