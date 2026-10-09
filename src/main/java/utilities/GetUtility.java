package utilities;

import org.openqa.selenium.By;

import java.util.Set;

import static drivers.DriverManager.getDriver;

public class GetUtility {
    public static String getWindowHandle() {
        return getDriver().getWindowHandle();
    }

    public static Set<String> getWindowHandles() {
        return getDriver().getWindowHandles();
    }

    public static String getText(By locator) {
        return getDriver().findElement(locator).getText();
    }

    public static String getAttribute(By locator, String attribute) {
        return getDriver().findElement(locator).getAttribute(attribute);
    }

    public static String getURL() {
        return getDriver().getCurrentUrl();
    }
}
