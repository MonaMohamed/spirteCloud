package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage {
    private WebDriver driver;
    private By proceedShoppingBtn = By.xpath("//*[@id='center_column']/p[2]/a[1]");
    private By confirmAddressBtn  = By.xpath("//*[@id='center_column']/form/p/button");
    private By confirmCourierBtn = By.xpath("//*[@id='form']/p/button");
    private By continueBtn = By.xpath("//*[contains(text(),'Continue shopping')]");
    private By pageHeading = By.className("page-heading");
    private By acceptAgreementsBox = By.id("uniform-cgv");
    private By paymentCheck = By.className("cheque");
    private By confirmPurchaseBtn = By.xpath("//*[@id='cart_navigation']/button");
    private By successMsg = By.xpath("//*[@id='center_column']/div/p");
    public CheckOutPage(WebDriver driver){ this.driver = driver; }

    public void proceedCheckOut(){
        driver.findElement(proceedShoppingBtn);
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedShoppingBtn));
        driver.findElement(proceedShoppingBtn).click();
    }
    public String getPageHeader() { return driver.findElement(pageHeading).getText(); }
    public void continueShopping() { driver.findElement(continueBtn).click(); }
    public void acceptAgreements(){ driver.findElement(acceptAgreementsBox).click(); }
    public void doPayment(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentCheck));
        driver.findElement(paymentCheck).click();
    }
    public void confirmPurchase(){ driver.findElement(confirmPurchaseBtn).click(); }
    public void confirmAddress(){ driver.findElement(confirmAddressBtn).click(); }
    public void confirmCourier(){ driver.findElement(confirmCourierBtn).click(); }
    public String getSuccessMsg(){ return driver.findElement(successMsg).getText(); }
}
