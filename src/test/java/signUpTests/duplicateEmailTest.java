package signUpTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;

public class duplicateEmailTest extends BaseTest {
    @Test
    public void testDuplicateEmail() {
        var signUpPage = shoppingPage.clickAccountButton().clickSignInButton().clickCreateOneButton();

        String name = ConfigReader.get("user.name");
        String mailID = ConfigReader.get("user.email");
        String password = ConfigReader.get("user.password");

        signUpPage.setName(name);
        signUpPage.setEmail(mailID);
        signUpPage.setPassword(password);

        signUpPage.clickCreateAccountExpectError();

        String errorMessage = signUpPage.getError();

        Assert.assertTrue(errorMessage.contains("email already exists"), "Wrong error message / duplicate logic fails");
    }
}
