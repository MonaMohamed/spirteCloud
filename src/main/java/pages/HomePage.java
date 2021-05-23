package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.event.MouseEvent;

public class HomePage {
    private WebDriver driver;
    private By clothesItemField = By.xpath("//*[@id='homefeatured']/li");
    private By productBox = By.className("product-container");



    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickSignin(){
        clickLink("Sign in");
        return new LoginPage(driver);
    }

    /**
     *
     * @param index starts at 1
     */
    public FigureProduct hoverOverItem(int index){
        WebElement figure = driver.findElements(clothesItemField).get(index - 1);
        Actions actions = new Actions(driver);
        actions.moveToElement(figure).clickAndHold(figure).perform();
        return new FigureProduct(figure);
    }

    public class FigureProduct{
        private WebElement productBox ;
        private By moreBtn = By.linkText("More");
        private By quickViewBtn = By.linkText("Quick view");
        private By price = By.className(".price.product-price");

        public FigureProduct(WebElement productBox){ this.productBox = productBox; }

        public boolean isProductBoxDisplayed(){
            WebDriverWait wait = new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.visibilityOf(productBox));
            return productBox.isDisplayed();
        }

        public String getPrice(){
            return productBox.findElement(price).getText();
        }

        public void clickQuickView(){ productBox.findElement(quickViewBtn).click(); }

        public ProductDetailsPages clickMore(){
            productBox.findElement(moreBtn).click();
            return new ProductDetailsPages(driver);
        }

    }


    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

}
