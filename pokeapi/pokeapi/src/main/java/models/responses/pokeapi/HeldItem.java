package models.responses.pokeapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;
@Data
public class HeldItem {
    @Expose
    private NameUrl item;
    @Expose
    @SerializedName("version_details")
    private List<VersionDetails> versionDetails;

    public NameUrl getItem() {
        return item;
    }

    public List<VersionDetails> getVersionDetails() {
        return versionDetails;
    }

    @Override
    public String toString() {
        return "HeldItem{" +
                "item=" + item +
                ", versionDetails=" + versionDetails +
                '}';
    }
}
