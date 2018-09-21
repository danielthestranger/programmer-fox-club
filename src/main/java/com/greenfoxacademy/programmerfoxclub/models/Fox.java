package com.greenfoxacademy.programmerfoxclub.models;

import java.util.ArrayList;
import java.util.List;

public class Fox {
    private String name;
    private List<Trick> tricks;

    public Fox() {
    }

    public Fox(String name, List<Trick> tricks) {
        this();
        this.name = name;
        this.tricks = tricks;
    }

    public Fox(String name, String[] trickDescriptions) {
        this();
        this.name = name;
        List<Trick> tricks = new ArrayList<>();
        for (String trickDescription : trickDescriptions) {
            tricks.add(new Trick(trickDescription));
        }
        this.tricks = tricks;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Trick> getTricks() {
        return tricks;
    }

    public void setTricks(List<Trick> tricks) {
        this.tricks = tricks;
    }
}
