package base;

import drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static utilities.WaitUtility.waitForClickable;
import static utilities.WaitUtility.waitForVisible;

public class BasePage {
    protected WebDriver driver() {
        return DriverManager.getDriver();
    }

    public WebElement find(By locator) {
        return waitForVisible(locator);
    }

    public void set(By locator, String text) {
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void click(By locator) {
        waitForClickable(locator).click();
    }

    // Temporary: remove once every delay() call is replaced with a proper wait
    @Deprecated
    public static void delay(int millisec) {
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException exc) {
            Thread.currentThread().interrupt();
        }
    }
}