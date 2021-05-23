package ui.Home;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import ui.base.BaseTests;
import utils.RandomDigits;

import static org.testng.Assert.assertTrue;

public class HomeTests extends BaseTests {

    @Test(priority=1)
    public void testSuccessfulLogin(){
        LoginPage loginPage = homePage.clickSignin();
        loginPage.setEmail("testtesttest@test.com");
        loginPage.setPassword("123456");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        assertTrue(secureAreaPage.getPageHeader()
                        .contains("MY ACCOUNT"),
                "Authentication Failed");
        secureAreaPage.clickHomeBtn();
    }

    @Test
    public void testSuccessfulAddToCart(){
        int index = randomDigits.generateRandomNumber();
        HomePage.FigureProduct productDetailsBox = homePage.hoverOverItem(index);
        assertTrue(productDetailsBox.isProductBoxDisplayed(),"Product details not displayed");
        ProductDetailsPages productDetailsPage = productDetailsBox.clickMore();
        productDetailsPage.clickAddToCart();
        assertTrue(productDetailsPage.isCartBoxDisplayed(),"Add to Cart Button doesn't work");
        assertTrue(productDetailsPage.CheckSuccessfullyAddedItem()
                        .contains("Product successfully added"),
                "Product not added to the cart, something went wrong");
    }

    @Test(priority=2, dependsOnMethods={"testSuccessfulLogin"})
    public void testSuccessfulCheckOut(){
        int index = randomDigits.generateRandomNumber();
        HomePage.FigureProduct productDetailsBox = homePage.hoverOverItem(index);
        assertTrue(productDetailsBox.isProductBoxDisplayed(),"Product details not displayed");
        ProductDetailsPages productDetailsPage = productDetailsBox.clickMore();
        productDetailsPage.clickAddToCart();
        assertTrue(productDetailsPage.isCartBoxDisplayed(),"Add to Cart Button doesn't work");
        assertTrue(productDetailsPage.CheckSuccessfullyAddedItem()
                        .contains("Product successfully added"),
                "Product not added to the cart, something went wrong");
        CheckOutPage checkOutPage = productDetailsPage.clickCheckOut();
        while(!(checkOutPage.getPageHeader().contains("Shipping"))){
            checkOutPage.proceedCheckOut();
        }
        checkOutPage.AcceptAgreements();
        checkOutPage.proceedCheckOut();
        checkOutPage.DoPayment();
        checkOutPage.ConfirmPurchase();
        assertTrue(checkOutPage.getPageHeader().contains("Order confirmation"),"Order not confirmed!");
        assertTrue(checkOutPage.getSuccessMsg()
                .contains("Your order on My Store is complete."),
                "Order is not completed!");
    }

}
