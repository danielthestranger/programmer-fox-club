package com.greenfoxacademy.programmerfoxclub.models;

import java.util.List;

public interface Pet {
    public String getName();
    public void setName(String name);
    public List<Trick> getTricks();
    public void setTricks(List<Trick> tricks);
    public String getSummary();
}
