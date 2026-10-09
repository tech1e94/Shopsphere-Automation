package bagTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BagPage;
import pages.ShoppingPage;
import utilities.ConfigReader;

public class AddProductToBagTest extends BaseTest {
    @Test
    public void testAddProduct() {
        var signInPage = shoppingPage.clickAccountButton().clickSignInButton();
        String mailID = ConfigReader.get("user.email");
        String password = ConfigReader.get("user.password");

        signInPage.setEmail(mailID);
        signInPage.setPassword(password);

        var profilePage = signInPage.clickSignIn().clickAccountButton();

        String actualMailID = profilePage.getUserMailID();
        String expectedMailID = mailID;

        //fluentWaitUntilVisible(2, );
        ShoppingPage shoppingPage1 = profilePage.clickCloseButton();

        BagPage bagPage = shoppingPage1.addProductToBag();
        //delay(2000);
        String actualCount = bagPage.getProduct1Count();
        String expectedCount = "1";

        Assert.assertEquals(actualMailID, expectedMailID, "Logged-in email mismatch");
        Assert.assertEquals(actualCount, expectedCount, "Actual and expected count do not match");
    }
}
