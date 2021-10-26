package openweb.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import openweb.POJO.TestData;
import openweb.pageobject.RcManualPage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CommentSteps extends ScenarioSteps {

    private RcManualPage manualPage;
    private String actor;

    @Step("#actor delete his own comment")
    public void deleteComment(final String userName) {
        manualPage.deleteComment(userName);
    }

    @Step("#actor open the page")
    public void getPage() {
        manualPage.open();
    }

    @Step("#actor submit comment")
    public void submitComment(final TestData testData) {
        manualPage.fillComment(testData.getComment());
        manualPage.fillUsername(testData.getCommentUserName());
        manualPage.clickSendButton();
        manualPage.clickJoinUs();
    }

    @Step("#actor verify he is a 'Guest'")
    public void verifyUserIsGuest() {
        assertThat("User log in as not a Guest", manualPage.getUserRole(), equalTo("Guest"));
    }

    @Step("#actor sort by Newest")
    public void sortCommentByNewest() {
        manualPage.sortByNewest();
    }

    @Step("#actor verify his own comment")
    public void verifyComment(final TestData data) {
        sortCommentByNewest();
        List<String> names = manualPage.getUserNames();
        List<String> comments = manualPage.getComments();

        assertThat("User name does not displays on comments section ",
                names.stream().anyMatch(s -> s.equals(data.getName())));

        assertThat("Comment does not displays on comments section ",
                comments.stream().anyMatch(s -> s.equals(data.getComment())));
    }
}
