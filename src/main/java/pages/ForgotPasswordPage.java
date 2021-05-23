package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;
    private By emailField = By.id("email");
    private By retrivePasswordButton = By.xpath("//*[@id=\"form_forgotpassword\"]/fieldset/p/button");
    private By BackLoginButton = By.xpath("//*[@id=\"center_column\"]/ul");

    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public VerifyEmailSentPage clickRetrievePassword(){
        driver.findElement(retrivePasswordButton).click();
        return new VerifyEmailSentPage(driver);
    }
    
    public LoginPage clickBackToLogin(){
        driver.findElement(BackLoginButton).click();
        return new LoginPage(driver);
    }
}
