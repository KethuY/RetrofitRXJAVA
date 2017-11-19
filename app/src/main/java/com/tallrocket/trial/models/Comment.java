package com.tallrocket.trial.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 11/16/17.
 */

public class Comment {

    @SerializedName("id")
    private String id;

    @SerializedName("body")
    private String body;

    @SerializedName("email")
    private String email;

    @SerializedName("name")
    private String name;

    @SerializedName("postId")
    private String postId;

    public String getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public String getEmail() {
        return email;
    }


    public String getName() {
        return name;
    }


    public String getPostId() {
        return postId;
    }

}

