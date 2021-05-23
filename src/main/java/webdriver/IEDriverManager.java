package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class IEDriverManager extends DriverManager {
	
	@Override
	public void createWebDriver() {
		InternetExplorerOptions options = new InternetExplorerOptions();
		this.driver = new EventFiringWebDriver((WebDriver) options);
	}

}
