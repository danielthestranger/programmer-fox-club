package com.greenfoxacademy.programmerfoxclub.models;

import java.util.List;

public interface Pet {
    public String getName();
    public void setName(String name);
    public List<Trick> getTricks();
    public void setTricks(List<Trick> tricks);
    public Food getFood();
    public void setFood(Food food);
    public Drink getDrink();
    public void setDrink(Drink drink);

    public int countTricks();
    public void setTricks(String[] trickDescriptions);
    public String getSummary();
}
