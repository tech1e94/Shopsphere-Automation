package pages;

import base.BasePage;
import org.openqa.selenium.By;

import static utilities.WaitUtility.fluentWaitUntilVisible;

public class ProfilePage extends BasePage {
    private By signInButton = By.id("profile-sign-in-button");
    private By closeButton = By.xpath("//button[@aria-label='Close profile']");

    private By userMailID = By.xpath("//aside//div[contains(@class, 'py-8')]/p[2]");

    public SignInPage clickSignInButton() {
        click(signInButton);
        return new SignInPage();
    }

    public ShoppingPage clickCloseButton() {
        click(closeButton);
        return new ShoppingPage();
    }

    public String getUserMailID() {
        return find(userMailID).getText();
    }
}
