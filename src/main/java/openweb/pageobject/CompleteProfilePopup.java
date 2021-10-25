package openweb.pageobject;

import io.github.sukgu.Shadow;
import io.github.sukgu.support.FindElementBy;
import openweb.POJO.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CompleteProfilePopup extends BasePage {

    @FindElementBy(css = "[class*='onBoardingForm'] [class*='searchInput'] [class*='container']>input")
    private WebElement liveField;
    @FindElementBy(css = "[class*='onBoardingForm'] [class*='bioDescription'] [data-testid='bio']")
    private WebElement aboutYouField;
    @FindElementBy(css = "[data-testid='submit']")
    private WebElement doneButton;

    public CompleteProfilePopup(final WebDriver driver) {
        super(driver);
    }

    public void fillProfile(final TestData testData) {
        getWait().until(ExpectedConditions.elementToBeClickable(liveField));
        liveField.sendKeys(testData.getLive());
        aboutYouField.sendKeys(testData.getAboutYou());
        doneButton.click();
        refreshPage();
    }
}
