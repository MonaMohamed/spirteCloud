package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {
    private WebDriver driver;
    private By pageHeading = By.className("page-heading");
    private By homeBtn = By.xpath("//*[@id='center_column']/ul/li/a");

    public SecureAreaPage(WebDriver driver){
        this.driver = driver;
    }

    public String getPageHeader(){
        return driver.findElement(pageHeading).getText();
    }

    public HomePage clickHomeBtn() {
        driver.findElement(homeBtn).click();
        return new HomePage(driver);
    }
}
