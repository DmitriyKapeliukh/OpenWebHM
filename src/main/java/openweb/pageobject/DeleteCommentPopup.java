package openweb.pageobject;

import io.github.sukgu.support.FindElementBy;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DeleteCommentPopup extends BasePage {

    @FindElementBy(css = "button[class*='primary Button']")
    private WebElement confirmDelete;

    public DeleteCommentPopup(final WebDriver driver) {
        super(driver);
    }

    public void confirmDeleteComment() {
        ListOfWebElementFacades element = findAll(By.cssSelector("[data-spot-im-shadow-host*='standalone-ui-kit']"));
        getRootElement(element.get(0)).findElement(By.cssSelector("button[class*='primary Button']")).click();
    }

/*    public void confirmDeleteComment() {
        getWait().until(ExpectedConditions.elementToBeClickable(confirmDelete)).click();
    }*/
}
