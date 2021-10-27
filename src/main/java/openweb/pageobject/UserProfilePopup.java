package openweb.pageobject;

import io.github.sukgu.support.FindElementBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserProfilePopup extends BasePage {

    @FindElementBy(css = "[data-spot-im-class='user-info-username']")
    private WebElement userName;

    @FindElementBy(css = "[class*='livesInText'] [class*='DetailText']")
    private WebElement userLive;

    @FindElementBy(css = "[class*='src-components-FeedItem'] [class*='TextWrapper']")
    private WebElement comment;

    @FindElementBy(css = "button[title='Close dialog box']")
    private WebElement closePopup;

    public UserProfilePopup(final WebDriver driver) {
        super(driver);
    }

    public void closePopup() {
        closePopup.click();
    }

    public String getUserName() {
        getWait().until(ExpectedConditions.visibilityOf(userName));
        return userName.getText();
    }

    public String getUserLLive() {
        return userLive.getText();
    }

    public String getUserComment() {
        return comment.getText();
    }
}
