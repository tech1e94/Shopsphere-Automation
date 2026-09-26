package pages;

import base.BasePage;
import org.openqa.selenium.By;

import static utilities.WaitUtility.fluentWaitUntilVisible;

public class ProfilePage extends BasePage {
    private By signInButton = By.id("profile-sign-in-button");
    private By closeButton = By.xpath("//button[@aria-label='Close profile']");

    private By userMailID = By.xpath("//aside//div[contains(@class, 'py-8')]/p[2]");

    public SignInPage clickSignInButton() {
        fluentWaitUntilVisible(2, signInButton);
        click(signInButton);
        return new SignInPage();
    }

    public ShoppingPage clickCloseButton() {
        fluentWaitUntilVisible(2, closeButton);
        click(closeButton);
        return new ShoppingPage();
    }

    public String getUserMailID() {
        fluentWaitUntilVisible(2, userMailID);
        return find(userMailID).getText();
    }
}
