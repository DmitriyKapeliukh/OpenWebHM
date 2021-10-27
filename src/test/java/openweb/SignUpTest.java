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
    private CommentSteps user;
    @Steps
    private CreateAccountSteps userAccount;
    @Steps
    private ProfileSteps userProfile;

    @Test
    public void signUpUser() {
        TestData testData = TestData.getTestData("rcManual.json");
        user.getPage();
        user.verifyUserIsGuest();
        user.submitComment(testData);
        userAccount.createAccount(testData);
        userAccount.completeProfile(testData);
        user.verifyComment(testData);
        userAccount.verifyProfile();
        userProfile.verifyUserDataOnProfilePage(testData);
        user.deleteLastComment();
        user.verifyCommentNotExist(testData.getComment());
        user.logout();
        user.verifyUserIsGuest();
    }
}
