package interactions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static utils.Constants.LAST_RESPONSE;

public class GetApi implements Task {

    private String baseURL, resource;

    public GetApi(String baseURL, String resource) {
        this.baseURL = baseURL;
        this.resource = resource;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.whoCan(CallAnApi.at(baseURL));
        actor.attemptsTo(Get.resource(resource));
        actor.remember(LAST_RESPONSE, SerenityRest.lastResponse());
    }

    public static GetApi with(String baseURL, String resource) {
        return Tasks.instrumented(GetApi.class, baseURL, resource);
    }
}
