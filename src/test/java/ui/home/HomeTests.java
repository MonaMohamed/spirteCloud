package ui.home;

import org.testng.annotations.Test;
import pages.*;
import ui.base.BaseTests;

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

    @Test(priority=2, dependsOnMethods={"testSuccessfulLogin"})
    public void testSuccessfulCheckOut() {
        int index = randomDigits.generateRandomNumber();
        HomePage.FigureProduct productDetailsBox = homePage.hoverOverItem(index);
        assertTrue(productDetailsBox.isProductBoxDisplayed(), "Product details not displayed");
        ProductDetailsPages productDetailsPage = productDetailsBox.clickMore();
        productDetailsPage.clickAddToCart();
        assertTrue(productDetailsPage.isCartBoxDisplayed(), "Add to Cart Button doesn't work");
        assertTrue(productDetailsPage.CheckSuccessfullyAddedItem()
                        .contains("Product successfully added"),
                "Product not added to the cart, something went wrong");
        CheckOutPage checkOutPage = productDetailsPage.clickCheckOut();
        checkOutPage.proceedCheckOut();
        if (checkOutPage.getPageHeader().contains("ADDRESSES")) {
            checkOutPage.confirmAddress();
        }
        if (checkOutPage.getPageHeader().contains("SHIPPING")) {
            checkOutPage.acceptAgreements();
            checkOutPage.confirmCourier();
        }
        checkOutPage.doPayment();
        checkOutPage.confirmPurchase();
        assertTrue(checkOutPage.getPageHeader().contains("ORDER CONFIRMATION"), "Order not confirmed!");
    }
}
