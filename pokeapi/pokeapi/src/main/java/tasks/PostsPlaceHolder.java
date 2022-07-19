package tasks;

import models.requests.PostRequest;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.jline.utils.Log;
import utils.Constants;

import static utils.Constants.POST_REQUEST;
import static utils.Constants.STATUS;

public class PostsPlaceHolder implements Task {

    private String body, name;
    private Integer userId;

    public PostsPlaceHolder(String body, String name, Integer userId) {
        this.body = body;
        this.name = name;
        this.userId = userId;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        PostRequest postRequest = new PostRequest(body,name,userId);
        Log.info("POST REQUEST: " + postRequest);
        actor.attemptsTo(PostApi.with(Constants.PLACE_URI,"posts",postRequest));
        actor.remember(STATUS,SerenityRest.lastResponse().statusCode());
        actor.remember(POST_REQUEST,postRequest);
    }

    public static PostsPlaceHolder with(String body, String name, Integer userId){
        return Tasks.instrumented(PostsPlaceHolder.class,body, name, userId);
    }
}
