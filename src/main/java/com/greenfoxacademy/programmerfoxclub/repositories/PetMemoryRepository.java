package com.greenfoxacademy.programmerfoxclub.repositories;

import com.greenfoxacademy.programmerfoxclub.models.Fox;
import com.greenfoxacademy.programmerfoxclub.models.Pet;
import org.springframework.stereotype.Repository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

@Repository
public class PetMemoryRepository implements PetRepository {

    private Map<String, Pet> pets;

    public PetMemoryRepository() {
        pets = getDummyData();
    }

    @Override
    public List<Pet> findAll() {
        Collection<Pet> values = pets.values();
        return new ArrayList<Pet>(values);
    }

    @Override
    public Pet findByName(String name) {
        return pets.get(name);
    }

    @Override
    public Pet add(Pet pet) {
        throw new NotImplementedException();
    }

    @Override
    public Pet updateByName(String name, Pet updatedPet) {
        throw new NotImplementedException();
    }

    @Override
    public boolean exists(String name) {
        return pets.containsKey(name);
    }

    private Map<String, Pet> getDummyData() {
        Map<String, Pet> dummyData = new TreeMap<String, Pet>(String.CASE_INSENSITIVE_ORDER);
        String[] names = {"Karak", "Vuk"};
        String[] trickDescriptions = {"hányni", "szarni"};
        for (String name : names) {
            dummyData.put(name, new Fox(name, trickDescriptions));
        }

        return dummyData;
    }
}