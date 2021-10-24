package openweb;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import openweb.POJO.TestData;
import openweb.steps.CommentSteps;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collection;

@RunWith(SerenityRunner.class)
public class SignUpTest extends BaseTest {

    @Steps
    private CommentSteps commentSteps;

    @Test
    public void signUpUser() {
        TestData testData = TestData.getTestData("rcManual.json");
        commentSteps.getPage();
        commentSteps.verifyUserIsGuest();
        commentSteps.submitComment(testData);
    }
}
