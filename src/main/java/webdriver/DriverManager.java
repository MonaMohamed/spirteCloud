package webdriver;

import org.openqa.selenium.support.events.EventFiringWebDriver;

public abstract class DriverManager {

	public enum DriverType{
		CHROME, FIREFOX, IE ,SAFARI;
	}
	protected EventFiringWebDriver driver;
	protected abstract void createWebDriver();
	
	public void quitWebDriver() {
		if (null != driver) {
			driver.quit();
			driver = null;
		}
	}
	
	
	public EventFiringWebDriver getWebDriver() {
		if(null == driver) {
			createWebDriver();
		}
		return driver;
	}
}
