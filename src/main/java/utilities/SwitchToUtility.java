package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SwitchToUtility extends utility {
    private static WebDriver.TargetLocator switchTo() {
        return driver.switchTo();
    }

    public static String getAlertText() {
        return switchTo().alert().getText();
    }

    public static void acceptAlert() {
        switchTo().alert().accept();
    }

    public static void dismissAlert() {
        switchTo().alert().dismiss();
    }

    public static void setAlertText(String text) {
        switchTo().alert().sendKeys(text);
    }

    public static void switchToFrameString(String text) {
        switchTo().frame(text);
    }

    public static void switchToFrameIndex(int i) {
        switchTo().frame(i);
    }

    public static void switchToFrameWebElement(WebElement webElement) {
        switchTo().frame(webElement);
    }

    public static void switchToDefaultContent() {
        switchTo().defaultContent();
    }

    public static void switchToWindow(String handle) {
        switchTo().window(handle);
    }


}
