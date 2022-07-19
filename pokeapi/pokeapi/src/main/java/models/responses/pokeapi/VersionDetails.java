package models.responses.pokeapi;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class VersionDetails {
    @Expose
    private Integer rarity;
    @Expose
    private NameUrl version;

    public Integer getRarity() {
        return rarity;
    }

    public NameUrl getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "VersionDetails{" +
                "rarity=" + rarity +
                ", version=" + version +
                '}';
    }
}
