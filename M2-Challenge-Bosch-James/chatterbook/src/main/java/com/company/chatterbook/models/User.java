package com.company.chatterbook.models;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class User {

    @NotEmpty(message = "You must supply a value for name.")
    private String name;

    @NotEmpty(message = "You must supply a value for chatterPosts.")
    private List<ChatterPost> chatterPosts;

    public User(String name) {
        this.name = name;
    }

    public void setChatterPosts(List<ChatterPost> chatterPosts) {
        this.chatterPosts = chatterPosts;
    }

}
