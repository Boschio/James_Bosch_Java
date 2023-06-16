package com.company.chatterbook.models;

import javax.validation.constraints.NotEmpty;

public class ChatterPost {

    @NotEmpty(message = "You must supply a value for text.")
    private String text;

    public ChatterPost(String text) {
        this.text = text;
    }

}
