package Cucumber_Practice;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LeaveComment {
    @Given("<user page> where user would like to leave a comment")
    public void userPageWhereUserWouldLikeToLeaveAComment() {
    }

    @When("user chooses a <post>")
    public void userChoosesAPost() {
    }

    @And("send <keys> in comment section")
    public void leaveComment() {
    }

    @Then("the comment is posted")
    public void commentIsPosted() {
        Assert.assertTrue(true);
    }
}
