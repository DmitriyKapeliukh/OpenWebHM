package openweb.pageobject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RcManualPage extends BasePage {

    public static final String COMMENT_CONTAINER = "[class='spcv_editor-wrapper']";

    @FindBy(css = "[data-spot-im-module-default-area='conversation'] [data-spot-im-shadow-host*='conversation conversation-survey']")
    private WebElementFacade root;

    private JoinUsPopup joinUsPopup;

    public RcManualPage(final WebDriver driver) {
        super(driver);
    }

    public String getUserRole() {
        WebElement element = getRootElement();
        return element.findElement(By.cssSelector("[class='spcv_conversation'] [class*='username-wrapper'] [class*='bold']")).getText();
    }

    public void fillComment(final String comment) {
        WebElement element = getRootElement();
        element.findElement(By.cssSelector(COMMENT_CONTAINER)).click();
        element.findElement(By.cssSelector(COMMENT_CONTAINER + " [contenteditable='true'][data-placeholder='What do you think?']")).sendKeys(comment);
    }

    public void fillUsername(final String userName) {
        WebElement element = getRootElement();
        element.findElement(By.cssSelector(COMMENT_CONTAINER + " [placeholder='Your Username']")).sendKeys(userName);
    }

    public void clickSendButton() {
        WebElement element = getRootElement();
        element(element.findElement(By.cssSelector(COMMENT_CONTAINER + " [data-spot-im-class='rich-editor-send-button']"))).click();
    }

    public void clickJoinUs() {
        joinUsPopup.acceptPopup(getRootElement());
    }

    private WebElement getRootElement() {
        return (WebElement) getJavascriptExecutorFacade().executeScript("return arguments[0].shadowRoot", root);
    }
}
