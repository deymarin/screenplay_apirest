package models.responses.pokeapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Ability {
    @Expose
    @SerializedName("ability")
    private NameUrl abilityValue;
    @Expose
    @SerializedName("is_hidden")
    private Boolean isHidden;
    @Expose
    private String slot;

    public NameUrl getAbilityValue() {
        return abilityValue;
    }

    public Boolean getHidden() {
        return isHidden;
    }

    public String getSlot() {
        return slot;
    }

    @Override
    public String toString() {
        return "Ability{" +
                "ability=" + abilityValue +
                ", isHidden=" + isHidden +
                ", slot='" + slot + '\'' +
                '}';
    }
}
