package com.greenfoxacademy.programmerfoxclub.models;

public class Trick {
    private String description;

    public Trick() {
    }

    public Trick(String description) {
        this();
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
