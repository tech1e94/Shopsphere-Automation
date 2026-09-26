package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class BagPage extends BasePage {
    private By closeButton = By.xpath("//button[@aria-label='Close cart']");

    private By product1 = By.xpath("//aside//div//h3[text()='Arc Lounge Chair']");
    private By product1Count = By.xpath("//aside//div//h3[text()='Arc Lounge Chair']//following::div//span");

    public ShoppingPage clickClose() {
        click(closeButton);
        return new ShoppingPage();
    }

    public String getProduct1Count() {
        return find(product1Count).getText();
    }
}
