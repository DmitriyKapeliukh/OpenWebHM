package openweb;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import openweb.POJO.TestData;
import openweb.steps.CommentSteps;
import openweb.steps.CreateAccountSteps;
import openweb.steps.ProfileSteps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class SignUpTest extends BaseTest {

    @Steps
    private CommentSteps commentSteps;
    @Steps
    private CreateAccountSteps createAccountSteps;
    @Steps
    private ProfileSteps profileSteps;

    @Test
    public void signUpUser() {
        TestData testData = TestData.getTestData("rcManual.json");
        commentSteps.getPage();
        commentSteps.verifyUserIsGuest();
        commentSteps.submitComment(testData);
        createAccountSteps.createAccount(testData);
        createAccountSteps.completeProfile(testData);
        commentSteps.verifyComment(testData);
        createAccountSteps.verifyProfile();
        profileSteps.verifyUserDataOnProfilePage(testData);
        commentSteps.deleteLastComment();
        commentSteps.verifyCommentNotExist(testData.getComment());
        commentSteps.logout();
        commentSteps.verifyUserIsGuest();
    }
}
