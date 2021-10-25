package openweb.pageobject;

import io.github.sukgu.support.FindElementBy;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CreateAccountPage extends BasePage {

    @FindElementBy(css = "[data-testid='username']")
    private WebElement nameField;

    @FindElementBy(css = "[data-testid='email']")
    private WebElement emailField;

    @FindElementBy(css = "[data-testid='password']")
    private WebElement passwordField;

    @FindElementBy(css = "[data-testid='submit']")
    private WebElement createAccountButton;

    public CreateAccountPage(final WebDriver driver) {
        super(driver);
    }

    public void fillName(final String name) {
        nameField.sendKeys(name);
    }

    public void fillEmail(final String email) {
        emailField.sendKeys(email);
    }

    public void fillPassword(final String password) {
        passwordField.sendKeys(password);
    }

    public void clickCreateAccount() {
        createAccountButton.click();
    }

}
