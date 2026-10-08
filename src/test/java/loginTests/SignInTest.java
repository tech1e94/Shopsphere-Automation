package loginTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ShoppingPage;

import static base.BasePage.delay;

public class SignInTest extends BaseTest {
    @Test
    public void testSignIn() {
        var signInPage = shoppingPage.clickAccountButton().clickSignInButton();
        String mailID = "mohammedtahirshaikh94@gmail.com";
        String password = "takken123";

        signInPage.setEmail(mailID);
        signInPage.setPassword(password);

        var profilePage = signInPage.clickSignIn().clickAccountButton();

        String actualMailID = profilePage.getUserMailID();
        String expectedMailID = mailID;

        delay(1000);
        profilePage.clickCloseButton();

        Assert.assertEquals(actualMailID, expectedMailID, "Actual mail id is different from the expected mail id");
    }
}
