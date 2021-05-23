package ui.login;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.SecureAreaPage;
import pages.VerifyEmailSentPage;
import ui.base.BaseTests;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfulForgetPassword(){
        LoginPage loginPage = homePage.clickSignin();
        ForgotPasswordPage forgotPasswordPage = loginPage.clickForgotPassword();
        forgotPasswordPage.setEmail("testtesttest@test.com");
        VerifyEmailSentPage verifyEmailSentPage = forgotPasswordPage.clickRetrievePassword();
        assertTrue(verifyEmailSentPage.getVerificationText()
                .contains("A confirmation email has been sent to your address"),
                "Incorrect Email");
    }
}
