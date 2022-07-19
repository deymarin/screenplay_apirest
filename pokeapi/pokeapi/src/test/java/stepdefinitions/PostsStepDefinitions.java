package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import questions.ValidatePosts;
import tasks.PostsPlaceHolder;

public class PostsStepDefinitions {

    @When("^i send the post information (.*), (.*) and (.*)$")
    public void iSendThePostInformation(String title, String body, Integer userId) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                PostsPlaceHolder.with(body, title, userId));
    }
    @Then("i should create the post successfully")
    public void iShouldCreateThePostSuccessfully() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(
                ValidatePosts.with()));
    }
}
