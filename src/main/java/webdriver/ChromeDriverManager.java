package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ChromeDriverManager extends DriverManager {
	
	@Override
	public void createWebDriver() {
		
		System.setProperty("webdriver.chrome.driver", "/"+ System.getProperty("user.dir")+"/src/main/resources/chromeDriver/chromedriver.exe");
		this.driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
	}

	private static ChromeOptions getChromeOptions(){
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		//options.setHeadless(true);
//		options.setBinary("C:\\Users\\%USERNAME%\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
		options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");

		return options;
	}
}
