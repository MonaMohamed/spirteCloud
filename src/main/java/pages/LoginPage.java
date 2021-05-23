package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By pageHeading = By.className("page-heading");
    private By emailField = By.id("email");
    private By passwordField = By.id("passwd");
    private By loginButton = By.id("SubmitLogin");
    private By forgetPasswordLink = By.linkText("Forgot your password?");
    private By newEmailField = By.id("email_create");
    private By createAccountButton = By.id("SubmitCreate");


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void setNewEmail(String email) {driver.findElement(newEmailField).sendKeys(email);}

    public SecureAreaPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new SecureAreaPage(driver);
    }

    public ForgotPasswordPage clickForgotPassword(){
        driver.findElement(forgetPasswordLink).click();
        return new ForgotPasswordPage(driver);
    }

    public CreateNewAccountPage clickCreateAccount(){
        driver.findElement(createAccountButton).click();
        return new CreateNewAccountPage(driver);
    }

    public String getPageHeader() { return driver.findElement(pageHeading).getText(); }
}
