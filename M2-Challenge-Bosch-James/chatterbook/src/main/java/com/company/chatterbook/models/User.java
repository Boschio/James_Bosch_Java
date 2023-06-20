package com.company.chatterbook.models;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Objects;

public class User {

    @NotEmpty(message = "You must supply a value for name.")
    private String name;

    @NotEmpty(message = "You must supply a value for chatterPosts.")
    private List<ChatterPost> chatterPosts;

    public User(String name) {
        this.name = name;
    }

    public List<ChatterPost> getChatterPosts() {
        if (chatterPosts != null) {
            return chatterPosts;
        }
        return null;
    }

    public void setChatterPosts(List<ChatterPost> chatterPosts) {
        this.chatterPosts = chatterPosts;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(chatterPosts, user.chatterPosts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, chatterPosts);
    }
}
