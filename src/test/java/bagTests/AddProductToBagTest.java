package bagTests;

import base.BaseTest;
import loginTests.SignInTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BagPage;
import pages.ShoppingPage;

import static base.BasePage.delay;
import static utilities.WaitUtility.fluentWaitUntilVisible;

public class AddProductToBagTest extends BaseTest {
    @Test
    public void testAddProduct() {
        var signInPage = shoppingPage.clickAccountButton().clickSignInButton();
        String mailID = "mohammedtahirshaikh94@gmail.com";
        String password = "takken123";

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

        Assert.assertEquals(actualCount, expectedCount, "Actual and expected count do not match");
    }
}
