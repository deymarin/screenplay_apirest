package models.requests;

import com.google.gson.annotations.Expose;

public class PostRequest {
    @Expose
    private String body;
    @Expose
    private String title;
    @Expose
    private Integer userId;

    public PostRequest(String body, String name, Integer userId) {
        this.body = body;
        this.title = name;
        this.userId = userId;
    }

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }

    public Integer getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "PostRequest{" +
                "body='" + body + '\'' +
                ", title='" + title + '\'' +
                ", userId=" + userId +
                '}';
    }
}
