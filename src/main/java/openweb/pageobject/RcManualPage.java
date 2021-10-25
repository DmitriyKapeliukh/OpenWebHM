package openweb.pageobject;

import io.github.sukgu.support.FindElementBy;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RcManualPage extends BasePage {

    public static final String COMMENT_CONTAINER = "[class='spcv_editor-wrapper']";

    @FindBy(css = "[data-spot-im-module-default-area='conversation'] [data-spot-im-shadow-host*='conversation conversation-survey']")
    private WebElementFacade root;

    @FindElementBy(css = "[id='spotim-sort-by']")
    private WebElement sortBy;

    @FindElementBy(css = "data-spot-im-class='message-username'")

    private WebElement rcRoot;

    private JoinUsPopup joinUsPopup;

    public RcManualPage(final WebDriver driver) {
        super(driver);
    }

    public void sortByNewest() {
        sortBy.click();
    }

    public String getUserRole() {
        WebElement element = getRcManualRoot();
        return element.findElement(By.cssSelector("[class='spcv_conversation'] [class*='username-wrapper'] [class*='bold']")).getText();
    }

    public void fillComment(final String comment) {
        WebElement element = getRcManualRoot();
        element.findElement(By.cssSelector(COMMENT_CONTAINER)).click();
        element.findElement(By.cssSelector(COMMENT_CONTAINER + " [contenteditable='true'][data-placeholder='What do you think?']")).sendKeys(comment);
    }

    public void fillUsername(final String userName) {
        WebElement element = getRcManualRoot();
        element.findElement(By.cssSelector(COMMENT_CONTAINER + " [placeholder='Your Username']")).sendKeys(userName);
    }

    public void clickSendButton() {
        WebElement element = getRcManualRoot();
        element(element.findElement(By.cssSelector(COMMENT_CONTAINER + " [data-spot-im-class='rich-editor-send-button']"))).click();
    }

    public void clickJoinUs() {
        joinUsPopup.acceptPopup(getRcManualRoot());
    }

    private WebElement getRcManualRoot() {
        return getRootElement(root);
    }
}
