package serenity_practice;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class TestLogin {

    @Steps
    TestLoginPageSteps steps;

    @Managed(driver = "chrome")
    WebDriver driver;

    @Test
    public void loginTest(){
        steps.openPage();
        steps.userClickLoginButton();
        steps.userInsertEmail("test@test.com");
        steps.userInsertPassword("12345678AB");
        steps.userSubmitLogin();
    }

}
