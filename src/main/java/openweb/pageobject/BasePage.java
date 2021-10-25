package openweb.pageobject;

import io.github.sukgu.support.ElementFieldDecorator;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class BasePage extends PageObject {

    public BasePage(final WebDriver driver) {
        super(driver);
/*        ElementFieldDecorator decorator = new ElementFieldDecorator(new DefaultElementLocatorFactory(driver));
        // need to use decorator if you want to use @FindElementBy in your PageFactory model.
        PageFactory.initElements(decorator, this);*/
    }

    protected WebElement getRootElement(final WebElement root) {
        return (WebElement) getJavascriptExecutorFacade().executeScript("return arguments[0].shadowRoot", root);
    }

    protected void refreshPage() {
        getDriver().navigate().refresh();
    }
}
