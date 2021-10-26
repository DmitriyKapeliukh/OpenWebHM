package openweb.pageobject;

import io.github.sukgu.support.FindElementBy;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class RcManualPage extends BasePage {

    public static final String COMMENT_CONTAINER = "[class='spcv_editor-wrapper']";

    @FindBy(css = "[data-spot-im-module-default-area='conversation'] [data-spot-im-shadow-host*='conversation conversation-survey']")
    private WebElementFacade commentRoot;

    @FindBy(css = "[class='content'] [data-spot-im-shadow-host*='conversation conversation-survey']")
    private WebElement bottomRoot;

    @FindElementBy(css = "[id='spotim-sort-by']")
    private WebElement sortBy;

    @FindElementBy(css = "[data-testid='newest']")
    private WebElement newestComment;

    @FindElementBy(css = "button[aria-label='User Menu']")
    private WebElement settingsButton;

    @FindElementBy(css = "button[data-spot-im-class='profile-item']")
    private WebElement profileButton;

    @FindElementBy(css = "button[data-spot-im-class='logout-item']")
    private WebElement logoutButton;

    @FindElementBy(css = "button[data-spot-im-class='context-menu-item-delete']")
    private WebElement deleteComment;

    @FindBy(css = "[data-spot-im-shadow-host*='standalone-ui-kit']")
    List<WebElement> listShadow;

    private JoinUsPopup joinUsPopup;

    private DeleteCommentPopup deleteCommentPopup;

    public RcManualPage(final WebDriver driver) {
        super(driver);
    }

    public void deleteLastComment() {
        WebElement element = getRcManualRoot();
        element.findElement(By.cssSelector("[data-spot-im-class='messages-list']>li [aria-label='Menu']")).click();
        getWait().until(ExpectedConditions.elementToBeClickable(deleteComment)).click();
        deleteCommentPopup.confirmDeleteComment();
        deleteCommentPopup.refreshPage();
    }

    public void logout() {
        settingsButton.click();
        logoutButton.click();
    }

    public void goToSettings() {
        settingsButton.click();
        profileButton.click();
    }

    public List<String> getUserNames() {
        WebElement element = getRcManualRoot();
        return element.findElements(By.cssSelector("[data-spot-im-class='message-username']")).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getComments() {
        WebElement element = getRcManualRoot();
        return element.findElements(By.cssSelector("[data-spot-im-class='message-text']")).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void sortByNewest() {
        WebDriverWait wait = getWait();
        wait.until(ExpectedConditions.elementToBeClickable(sortBy)).click();
        wait.until(ExpectedConditions.elementToBeClickable(newestComment)).click();
    }

    public String getUserRole() {
        WebElement element = getRcManualRoot();
        element(element.findElement(By.cssSelector("[class*='username']"))).waitUntilVisible();
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
        return getRootElement(commentRoot);
    }
}
