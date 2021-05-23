package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPages {
    private WebDriver driver;
    private By addToCartBtn = By.id("add_to_cart");
    private By cartBox = By.id("layer_cart");
    private By successMessage = By.xpath("//*[@id='layer_cart']/div[1]/div[1]/h2");
    private By continueBtn = By.xpath("//*[contains(text(),'Continue shopping')]");
    private By checkOutBtn = By.xpath("//*[contains(text(),'Proceed to checkout')]");

    public ProductDetailsPages(WebDriver driver){ this.driver = driver; }

    public void clickAddToCart(){
        driver.findElement(addToCartBtn).click();
    }

    public boolean isCartBoxDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartBox));
        return driver.findElement(cartBox).isDisplayed();
    }

    public String CheckSuccessfullyAddedItem(){ return driver.findElement(successMessage).getText(); }

    public HomePage clickContinueShopping(){
        driver.findElement(continueBtn).click();
        return new HomePage(driver);
    }

    public CheckOutPage clickCheckOut(){
        driver.findElement(checkOutBtn).click();
        return new CheckOutPage(driver);
    }
}
