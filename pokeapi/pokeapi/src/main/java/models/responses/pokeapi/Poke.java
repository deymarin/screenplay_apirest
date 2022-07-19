package models.responses.pokeapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class Poke {
    @Expose
    private List<Ability> abilities;

    @Expose
    @SerializedName("base_experience")
    private String baseExperience;

    @Expose
    private Integer height;

    @Expose
    @SerializedName("held_items")
    private List<HeldItem> heldItems;

    public List<Ability> getAbilities() {
        return abilities;
    }

    public String getBaseExperience() {
        return baseExperience;
    }

    public Integer getHeight() {
        return height;
    }

    public List<HeldItem> getHeldItems() {
        return heldItems;
    }

    @Override
    public String toString() {
        return "Poke{" +
                "abilities=" + abilities +
                ", baseExperience='" + baseExperience + '\'' +
                ", height=" + height +
                ", heldItems=" + heldItems +
                '}';
    }
}
