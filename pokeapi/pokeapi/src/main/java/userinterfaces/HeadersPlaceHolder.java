package userinterfaces;

import java.util.HashMap;
import java.util.Map;

public class HeadersPlaceHolder {

    private HeadersPlaceHolder(){
    }

    public static Map<String, String> getHeaders(){
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        return headers;
    }
}
