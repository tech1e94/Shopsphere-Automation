package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static drivers.DriverManager.getDriver;
import static utilities.JavaScriptUtility.scrollToElementJS;
import static utilities.WaitUtility.fluentWaitUntilVisible;

public class ActionUtility {
    private static Actions act() {
        return new Actions(getDriver());
    }

    public static void dragAndDropBy(WebElement webElement, int x, int y) {
        act().dragAndDropBy(webElement, x, y).perform();
    }

    public static void sendKeys(WebElement source, CharSequence keys) {
        act().sendKeys(source, keys).perform();
    }

    public static void moveToTarget(By target) {
        scrollToElementJS(target);
        act().moveToElement(getDriver().findElement(target)).perform();
    }
}
