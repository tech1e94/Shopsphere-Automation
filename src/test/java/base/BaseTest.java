package base;

import drivers.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.ShoppingPage;
import utilities.ConfigReader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class BaseTest {
    protected ShoppingPage shoppingPage;

    @BeforeMethod
    public void setUp() {
        DriverManager.initDriver();
        DriverManager.getDriver().get(ConfigReader.get("base.url"));
        shoppingPage = new ShoppingPage();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.FAILURE) {
                takeScreenshot(result.getName());
            }
        } finally {
            DriverManager.quitDriver();
        }
    }

    private void takeScreenshot(String testName) {
        File source = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        Path destination = Paths.get("screenshots", testName + "_" + System.currentTimeMillis() + ".png");
        try {
            Files.createDirectories(destination.getParent());
            Files.copy(source.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved: " + destination.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Could not save screenshot: " + e.getMessage());
        }
    }
}