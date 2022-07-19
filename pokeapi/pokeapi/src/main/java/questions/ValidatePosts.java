package questions;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.requests.PostRequest;
import models.responses.PostResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.jline.utils.Log;

import static utils.Constants.*;

public class ValidatePosts implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        Response response = actor.recall(LAST_RESPONSE_POST);
        PostResponse postResponse = response.as(PostResponse.class, ObjectMapperType.GSON);
        Log.info("POST RESPONSE: " + postResponse);
        PostRequest postRequestResponseExpected = actor.recall(POST_REQUEST);
        Integer statusS = actor.recall(STATUS);

        boolean result = postResponse.getTitle().equals(postRequestResponseExpected.getTitle()) &&
                postResponse.getBody().equals(postRequestResponseExpected.getBody()) &&
                postResponse.getUserId().equals(postRequestResponseExpected.getUserId());
        boolean status = statusS.equals(201);
        return result && status;
    }

    public static ValidatePosts with(){
        return new ValidatePosts();
    }


}
