package com.example.musicp3.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;



public class CreateMusicForm {
    @NotNull
    @NotEmpty
    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
