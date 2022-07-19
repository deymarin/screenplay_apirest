package models.responses.pokeapi;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class NameUrl {
    @Expose
    private String name;
    @Expose
    private String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "NameUrl{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
