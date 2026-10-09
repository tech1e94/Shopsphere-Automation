package signInTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;

public class InvalidSignInTest extends BaseTest {
    @Test
    public void testInvalidSignIn() {
        var signInPage = shoppingPage.clickAccountButton().clickSignInButton();
        String mailID = ConfigReader.get("user.email");
        String password = ConfigReader.get("user.password");

        String invalidEmailID = "invalid@gmail.com";

        signInPage.setEmail(invalidEmailID);
        signInPage.setPassword(password);

        signInPage.clickSignIn();

        String errorMessage = signInPage.getError();
        String expectedMessage = "We could not complete that request. Check your details and try again.";

        Assert.assertTrue(errorMessage.contentEquals(expectedMessage), "Got invalid response");
    }
}
