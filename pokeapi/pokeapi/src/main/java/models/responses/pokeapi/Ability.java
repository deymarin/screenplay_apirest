package models.responses.pokeapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Ability {
    @Expose
    private NameUrl ability;
    @Expose
    @SerializedName("is_hidden")
    private Boolean isHidden;
    @Expose
    private String slot;

    public NameUrl getAbility() {
        return ability;
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
                "ability=" + ability +
                ", isHidden=" + isHidden +
                ", slot='" + slot + '\'' +
                '}';
    }
}
