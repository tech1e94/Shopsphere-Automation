package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static utilities.ActionUtility.sendKeys;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class SignUpPage extends BasePage {
    private By nameField = By.id("auth-name");
    private By emailField = By.id("auth-email");
    private By passwordField = By.id("auth-password");
    private By createAccountButton = By.xpath("//form//button");
    private By signInButton = By.xpath("//p//a[text()='Sign in']");
    private By errorMessage = By.xpath("//p[@role='alert']");

    public void setName(String name) {
        sendKeys(find(nameField), Keys.chord(name));
    }

    public void setEmail(String email) {
        sendKeys(find(emailField), Keys.chord(email));
    }

    public void setPassword(String password) {
        sendKeys(find(passwordField), Keys.chord(password));
    }

    public ShoppingPage clickCreateAccount() {
        scrollToElementJS(createAccountButton);
        click(createAccountButton);
        return new ShoppingPage();
    }

    public SignUpPage clickCreateAccountExpectError() {
        scrollToElementJS(createAccountButton);
        click(createAccountButton);
        return this;
    }

    public SignInPage clickSignIn() {
        scrollToElementJS(signInButton);
        click(signInButton);
        return new SignInPage();
    }

    public String getError() {
        scrollToElementJS(errorMessage);
        return find(errorMessage).getText();
    }
}
