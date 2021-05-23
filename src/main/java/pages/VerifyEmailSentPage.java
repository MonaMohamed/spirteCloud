package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerifyEmailSentPage {
    private WebDriver driver;
    private By verifyText = By.cssSelector("#center_column > div > p");

    public VerifyEmailSentPage(WebDriver driver){
        this.driver = driver;
    }

    public String getVerificationText(){
       return driver.findElement(verifyText).getText();
    }
}
