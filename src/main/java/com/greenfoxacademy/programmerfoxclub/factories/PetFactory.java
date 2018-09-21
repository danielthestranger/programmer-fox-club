package com.greenfoxacademy.programmerfoxclub.factories;

import com.greenfoxacademy.programmerfoxclub.models.Fox;
import com.greenfoxacademy.programmerfoxclub.models.Pet;

public class PetFactory {
    public static Pet createDefault(String petName) {
        Pet newPet = createDefaultType();
        newPet.setName(petName);
        return newPet;
    }

    public static Pet createDefault(String petName, String[] trickDescriptions) {
        Pet newPet = createDefault(petName);
        newPet.setTricks(trickDescriptions);
        return newPet;
    }

    private static Pet createDefaultType() {
        return new Fox();
    }
}
