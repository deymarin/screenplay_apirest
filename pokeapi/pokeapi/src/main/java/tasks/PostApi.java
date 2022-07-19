package tasks;

import io.restassured.mapper.ObjectMapperType;
import models.requests.PostRequest;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.jline.utils.Log;

import static utils.Constants.LAST_RESPONSE;
import static utils.Constants.LAST_RESPONSE_POST;

public class PostApi implements Task {
    private String baseURL, resource;
    private Object requestPosts;

    public PostApi(String baseURL, String resource, Object requestPosts) {
        this.baseURL = baseURL;
        this.resource = resource;
        this.requestPosts = requestPosts;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.whoCan(CallAnApi.at(baseURL));
        actor.attemptsTo(Post.to(resource)
                .with(request -> request.body(requestPosts, ObjectMapperType.GSON)));
        Log.info("LAST RESPONSE: " +SerenityRest.lastResponse().as(PostRequest.class).toString());
        actor.remember(LAST_RESPONSE_POST, SerenityRest.lastResponse());
    }

    public static PostApi with(String baseURL, String resource, Object requestPosts) {
        return Tasks.instrumented(PostApi.class, baseURL, resource, requestPosts);
    }
}
