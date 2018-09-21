package com.greenfoxacademy.programmerfoxclub.services;

import com.greenfoxacademy.programmerfoxclub.models.Pet;

public interface PetService {
    public Pet getByName(String name);
    public boolean exists(String name);
}
