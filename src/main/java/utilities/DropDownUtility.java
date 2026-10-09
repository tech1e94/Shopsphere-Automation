package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

import static drivers.DriverManager.getDriver;

public class DropDownUtility {
    private static Select findDropDown(By locator) {
        return new Select(getDriver().findElement(locator));
    }

    public static void selectByVisibleText(By locator, String text) {
        findDropDown(locator).selectByVisibleText(text);
    }

    public static void selectByValue(By locator, String value) {
        findDropDown(locator).selectByValue(value);
    }

    public static void selectByIndex(By locator, int index) {
        findDropDown(locator).selectByIndex(index);
    }

    public static void deselectByValue(By locator, String text) {
        findDropDown(locator).deselectByValue(text);
    }

    public static List<String> getAllSelectedOptions(By locator) {
        List<WebElement> allSelectedOptions = findDropDown(locator).getAllSelectedOptions();
        return allSelectedOptions.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
