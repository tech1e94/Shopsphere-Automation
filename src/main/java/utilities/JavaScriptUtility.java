package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.DriverManager.getDriver;

public class JavaScriptUtility {
    public static void scrollToElementJS(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(locator)
        );

        String jsScript = "arguments[0].scrollIntoView({block: 'center', inline: 'center'});";

        ((JavascriptExecutor) getDriver()).executeScript(jsScript, element);
    }

    public static void clickJS(By locator) {
        WebElement element = getDriver().findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click()", element);
    }
}
