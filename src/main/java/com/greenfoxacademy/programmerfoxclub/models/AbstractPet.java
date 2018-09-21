package com.greenfoxacademy.programmerfoxclub.models;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPet implements Pet {
    protected String name;
    protected List<Trick> tricks;
    protected String petType;

    public AbstractPet() {
        this.petType = this.getClass().getSimpleName();
        this.tricks = new ArrayList<>();
    }

    public AbstractPet(String name) {
        this();
        this.name = name;
    }

    public AbstractPet(String name, List<Trick> tricks) {
        this();
        this.name = name;
        this.tricks = tricks;
    }

    public AbstractPet(String name, String[] trickDescriptions) {
        this();
        this.name = name;
        List<Trick> tricks = trickListFromDescriptions(trickDescriptions);
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


    public void setTricks(String[] trickDescriptions) {
        this.tricks = trickListFromDescriptions(trickDescriptions);
    }

    // TODO behaviours to be extracted to keep the object purely a data structure

    private List<Trick> trickListFromDescriptions(String[] trickDescriptions) {
        List<Trick> tricks = new ArrayList<>();
        for (String trickDescription : trickDescriptions) {
            tricks.add(new Trick(trickDescription));
        }
        return tricks;
    }

    public String getSummary() {
        return "This is " + name + " currently living on ? and ?. He knows " + tricks.size() + " tricks.";
    }
}
