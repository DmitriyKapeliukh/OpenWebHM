package openweb.steps;

import net.serenitybdd.core.steps.ScenarioActor;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import openweb.POJO.TestData;
import openweb.pageobject.CompleteProfilePopup;
import openweb.pageobject.CreateAccountPage;
import openweb.pageobject.RcManualPage;

public class CreateAccountSteps extends ScenarioSteps {

    private String actor;
    private CreateAccountPage createAccountPage;
    private CompleteProfilePopup completeProfilePopup;
    private RcManualPage manualPage;

    @Step("#actor verify his own profile")
    public void verifyProfile() {
        manualPage.goToSettings();
    }

    @Step("#actor create account")
    public void createAccount(final TestData testData) {
        createAccountPage.fillName(testData.getName());
        createAccountPage.fillEmail(testData.getEmail());
        createAccountPage.fillPassword(testData.getPassword());
        createAccountPage.clickCreateAccount();
    }

    @Step("#actor complete profile")
    public void completeProfile(final TestData testData) {
        completeProfilePopup.fillProfile(testData);

    }
}
