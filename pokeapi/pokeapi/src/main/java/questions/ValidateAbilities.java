package questions;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.responses.pokeapi.Ability;
import models.responses.pokeapi.Poke;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.jline.utils.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static utils.Constants.LAST_RESPONSE;

public class ValidateAbilities implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        Response response = actor.recall(LAST_RESPONSE);
        Poke pokeResponse = response.as(Poke.class, ObjectMapperType.GSON);
        Log.info("ABILITIES: " + pokeResponse.getAbilities());
        List<String> abilitiesList = new ArrayList<>();
        List<String> abilitiesExpected = new ArrayList<>(
                Arrays.asList("limber","imposter")
        );
        for(Ability ability: pokeResponse.getAbilities()){
            abilitiesList.add(ability.getAbilityValue().getName());
        }
        Collections.sort(abilitiesList);
        Collections.sort(abilitiesExpected);
        Log.info("LIST GET: " + abilitiesList);
        Log.info("LIST EXPECTED: " + abilitiesExpected);
        return abilitiesExpected.equals(abilitiesList);
    }

    public static  ValidateAbilities with(){
        return new ValidateAbilities();
    }


}
