package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static utilities.ActionUtility.moveToTarget;
import static utilities.WaitUtility.fluentWaitUntilVisible;

public class ShoppingPage extends BasePage {
    private By accountButton = By.id("account-button");

    private By product1 = By.id("product-1");
    private By productAddButton = By.xpath("//article[@id='product-1']//button[text()='Add to bag']");

    public ProfilePage clickAccountButton(){
        click(accountButton);
        return new ProfilePage();
    }

    public BagPage addProductToBag() {
        moveToTarget(product1);

        //fluentWaitUntilVisible(2, productAddButton);
        click(productAddButton);

        return new BagPage();
    }
}
