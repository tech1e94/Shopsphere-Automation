package loginTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ShoppingPage;
import utilities.ConfigReader;

import static base.BasePage.delay;

public class SignInTest extends BaseTest {
    @Test
    public void testSignIn() {
        var signInPage = shoppingPage.clickAccountButton().clickSignInButton();
        String mailID = ConfigReader.get("user.email");
        String password = ConfigReader.get("user.password");

        signInPage.setEmail(mailID);
        signInPage.setPassword(password);

        var profilePage = signInPage.clickSignIn().clickAccountButton();

        String actualMailID = profilePage.getUserMailID();

        profilePage.clickCloseButton();

        Assert.assertEquals(actualMailID, mailID, "Actual mail id is different from the expected mail id");
    }
}
