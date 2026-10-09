package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.ConfigReader;

public final class DriverManager {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private DriverManager() {}

    public static void initDriver() {
        ChromeOptions options = new ChromeOptions();
        if (Boolean.parseBoolean(ConfigReader.get("headless"))) {
            options.addArguments("--headless=new", "--window-size=1920,1080");
        }
        WebDriver driver = new ChromeDriver(options);
        if (!Boolean.parseBoolean(ConfigReader.get("headless"))) {
            driver.manage().window().maximize();
        }
        DRIVER.set(driver);
    }

    public static WebDriver getDriver() {
        WebDriver driver = DRIVER.get();
        if (driver == null) {
            throw new IllegalStateException("Driver not initialised. Call DriverManager.initDriver() first.");
        }
        return driver;
    }

    public static void quitDriver() {
        WebDriver driver = DRIVER.get();
        if (driver != null) {
            driver.quit();
            DRIVER.remove();
        }
    }
}
