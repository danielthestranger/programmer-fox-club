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
        return petRepository.findByName(name);
    }

    @Override
    public boolean exists(String name) {
        return petRepository.exists(name);
    }
}
