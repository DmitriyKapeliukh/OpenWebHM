package openweb.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JoinUsPopup extends BasePage {

    public JoinUsPopup(final WebDriver driver) {
        super(driver);
    }

    public void acceptPopup(final WebElement root) {
        element(root.findElement(By.cssSelector("[id='spotim-woohoo-action-btn']"))).click();
    }
}
