package openweb.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import openweb.POJO.TestData;
import openweb.pageobject.UserProfilePopup;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ProfileSteps extends ScenarioSteps {

    private String actor;
    private UserProfilePopup userProfilePopup;

    @Step("#actor verify data {0} on the profile page")
    public void verifyUserDataOnProfilePage(final TestData data) {
        String userName = userProfilePopup.getUserName();
        String userLive = userProfilePopup.getUserLLive();
        String userComment = userProfilePopup.getUserComment();

        assertThat("Wrong user name on profile page",
                userName, equalTo(data.getName()));
        assertThat("Wrong user live on profile page",
                userLive.replace("Lives in ", ""), equalTo(data.getLive()));
        assertThat("Wrong user comment on profile page",
                userComment, equalTo(data.getComment()));
        userProfilePopup.closePopup();
    }
}
