package com.greenfoxacademy.programmerfoxclub.repositories;

import com.greenfoxacademy.programmerfoxclub.models.Pet;

import java.util.List;

public interface PetRepository {
    public List<Pet> findAll();
    public Pet findByName(String name);
    public Pet add(Pet pet);
    public Pet addByName(String name);
    public Pet updateByName(String name, Pet updatedPet);
    public boolean exists(String name);
}
