package questions;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.responses.pokeapi.Poke;
import models.responses.pokeapi.VersionDetails;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.jline.utils.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static utils.Constants.LAST_RESPONSE;

public class ValidateHeldItems implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        Response response = actor.recall(LAST_RESPONSE);
        Poke pokeResponse = response.as(Poke.class, ObjectMapperType.GSON);
        Log.info("HELD ITEMS: " + pokeResponse.getHeldItems());
        List<String> heldItemList = new ArrayList<>();
        List<String> heldItemExpected = new ArrayList<>(
                Arrays.asList("ruby","emerald","diamond")
        );
        for(VersionDetails versionDetails: pokeResponse.getHeldItems().get(0).getVersionDetails()){
            heldItemList.add(versionDetails.getVersion().getName());
        }
        Collections.sort(heldItemList);
        Collections.sort(heldItemExpected);
        Log.info("LIST GET: " + heldItemList);
        Log.info("LIST EXPECTED: " + heldItemExpected);
        return heldItemList.contains(heldItemExpected.get(0)) &&
                heldItemList.contains(heldItemExpected.get(1)) &&
                heldItemList.contains(heldItemExpected.get(2));
    }

    public static ValidateHeldItems with(){
        return new ValidateHeldItems();
    }


}
