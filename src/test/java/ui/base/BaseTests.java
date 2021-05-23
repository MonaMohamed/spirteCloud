package ui.base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.CookieManager;
import utils.EventReporter;
import utils.RandomDigits;
import utils.WindowManager;
import webdriver.DriverManager;
import webdriver.DriverManager.DriverType;
import webdriver.DriverManagerFactory;

import java.io.File;
import java.io.IOException;

public class BaseTests {

    private static EventFiringWebDriver driver;
    public static HomePage homePage; // provide a handle to homepage
    public static WindowManager windowManager;
    public RandomDigits randomDigits = new RandomDigits();


    @BeforeClass
    public static void setUp() {
        DriverManager driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getWebDriver();
        driver.register(new EventReporter());
        goHome();
        windowManager = new WindowManager(driver);
        windowManager.maximizeWindow();
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public static void goHome(){
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();        // it is close the session but driver.close() only close the current ui.window but not necessarily the entire session
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("src/test/resources/screenshots/"+result.getName()+".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    public CookieManager getCookieManager(){
        return new CookieManager(driver);
    }

}
