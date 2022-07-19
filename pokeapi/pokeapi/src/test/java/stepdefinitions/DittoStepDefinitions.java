package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.Matchers;
import questions.ValidateAbilities;
import questions.ValidateHeldItems;
import interactions.GetApi;
import utils.Constants;

public class DittoStepDefinitions {

    @Before
    public void setUp() {
        OnStage.setTheStage(Cast.whereEveryoneCan(CallAnApi.at(Constants.POKE_URI)));
        OnStage.theActorCalled("Deyli");
        SerenityRest.useRelaxedHTTPSValidation();
    }

    @When("^get the information of (.*)$")
    public void getTheInformationOfDitto(String name) {
        OnStage.theActorInTheSpotlight().attemptsTo(GetApi.with(Constants.POKE_URI, name));
    }

    @Then("i should get the abilities limber and imposter")
    public void iShouldGetTheAbilitiesLimberAndImposter() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateAbilities.with(),
                Matchers.equalTo(true)).orComplainWith(Error.class,
                "The abilities of ditto are invalid."));

    }

    @Then("i should get the held items ruby emerald and diamond")
    public void iShouldGetTheHeldItemsRubyEmeraldAndDiamond() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateHeldItems.with()));
    }


}
