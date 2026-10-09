package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.DriverManager.getDriver;

public class WaitUtility {
    public static void explicitWaitUntilVisible(int seconds, By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void fluentWaitUntilVisible(int seconds, By locator) {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(seconds))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private static int defaultTimeout() {
        return Integer.parseInt(ConfigReader.get("timeout.seconds"));
    }

    public static WebElement waitForVisible(By locator) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(defaultTimeout()))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickable(By locator) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(defaultTimeout()))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForInvisible(By locator) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(defaultTimeout()))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}
