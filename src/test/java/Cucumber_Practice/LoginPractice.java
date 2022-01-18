package Cucumber_Practice;

import io.cucumber.java.en.*;

public class LoginPractice {

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        /* Here goes some stuff */
    }

    @When("user enters <login> and <password>")
    public void userEntersCredentials(String login, String password) {
        /* Here goes some stuff */
    }

    @And("clicks on login button")
    public void userClickLoginButton() {
        /* Here goes some stuff */
    }

    @Then("the user is logged in")
    public void userIsLoggedIn() {
        /* Here goes some stuff */
    }

}
