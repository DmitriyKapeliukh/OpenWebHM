package openweb.pageobject;

import com.google.common.base.Predicate;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.github.sukgu.Shadow;
import io.github.sukgu.support.ElementFieldDecorator;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends PageObject {

    public BasePage(final WebDriver driver) {
        super(driver, new Predicate<PageObject>() {
            @Override
            public boolean apply(final PageObject page) {
                ElementFieldDecorator decorator = new ElementFieldDecorator(new DefaultElementLocatorFactory(driver));
                PageFactory.initElements(decorator, this);
                return true;
            }
        });
    }

    protected Shadow getShadowDriver() {
        Shadow shadow = new Shadow(getDriver());
        shadow.setImplicitWait(10);
        try {
            shadow.setExplicitWait(10, 1);
        } catch (Exception e) {
            e.printStackTrace();
        } return shadow;
    }

    protected WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), 20);
    }

    protected WebElement getRootElement(final WebElement root) {
        return (WebElement) getJavascriptExecutorFacade().executeScript("return arguments[0].shadowRoot", root);
    }

    protected void refreshPage() {
        getDriver().navigate().refresh();
    }
}
