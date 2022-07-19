package models.responses;

import com.google.gson.annotations.Expose;

public class PostResponse {
    @Expose
    private String body;
    @Expose
    private String title;
    @Expose
    private Integer userId;
    @Expose
    private Integer id;

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PostResponse{" +
                "body='" + body + '\'' +
                ", title='" + title + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}
