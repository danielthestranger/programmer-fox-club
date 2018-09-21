package com.greenfoxacademy.programmerfoxclub.services;

import com.greenfoxacademy.programmerfoxclub.models.Pet;
import com.greenfoxacademy.programmerfoxclub.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImpl implements PetService {

    private PetRepository petRepository;

    @Autowired
    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Pet getByName(String name) {
        if (petRepository.exists(name))
            return petRepository.findByName(name);
        else
            return petRepository.addNewByName(name);
    }

    @Override
    public boolean exists(String name) {
        return petRepository.exists(name);
    }

    @Override
    public Pet updateByName(String name, Pet updatedPet) {
        return petRepository.updateByName(name, updatedPet);
    }
}
