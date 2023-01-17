package serenity_practice;

import net.thucydides.core.annotations.Step;

public class TestLoginPageSteps {

    TestLoginPage testLoginPage;

    @Step
    public void openPage() {
        testLoginPage.open();
    }

    @Step
    public void userClickLoginButton() {
        testLoginPage.userClickLoginButton();
    }

    @Step
    public void userInsertEmail(String email) {
        testLoginPage.userInsertEmail(email);
    }

    @Step
    public void userInsertPassword(String password) {
        testLoginPage.userInsertPassword(password);
    }

    @Step
    public void userSubmitLogin() {
        testLoginPage.userSubmitLogin();
    }

}
