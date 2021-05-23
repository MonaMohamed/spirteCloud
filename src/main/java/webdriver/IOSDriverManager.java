package webdriver;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.net.URL;

public class IOSDriverManager extends DriverManager {
	
	@Override
	public void createWebDriver() {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("PlatformName", "IOS");
//		this.driver = new EventFiringWebDriver(getRemoteUrl(),capabilities);
	}

	private URL getRemoteUrl() {
		// TODO Auto-generated method stub
		return null;
	}

}
