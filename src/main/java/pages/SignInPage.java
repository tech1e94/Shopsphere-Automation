package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static utilities.ActionUtility.sendKeys;
import static utilities.JavaScriptUtility.scrollToElementJS;
import static utilities.WaitUtility.fluentWaitUntilVisible;

public class SignInPage extends BasePage {
    private By emailField = By.id("auth-email");
    private By passwordField = By.id("auth-password");
    private By signInButton = By.xpath("//form//button");
    private By createOneButton = By.xpath("//p//a[text()='Create one']");
    private By errorMessage = By.xpath("//p[@role='alert']");

    public void setEmail(String email) {
        fluentWaitUntilVisible(2, emailField);
        sendKeys(find(emailField), Keys.chord(email));
    }

    public void setPassword(String password) {
        sendKeys(find(passwordField), Keys.chord(password));
    }

    public ShoppingPage clickSignIn() {
        scrollToElementJS(signInButton);
        click(signInButton);
        return new ShoppingPage();
    }

    public SignUpPage clickCreateOneButton() {
        scrollToElementJS(createOneButton);
        click(createOneButton);
        return new SignUpPage();
    }

    public String getError() {
        scrollToElementJS(errorMessage);
        return find(errorMessage).getText();
    }
}
