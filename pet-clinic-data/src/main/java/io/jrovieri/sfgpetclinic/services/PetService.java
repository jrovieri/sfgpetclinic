package io.jrovieri.sfgpetclinic.services;

import java.util.Set;

import io.jrovieri.sfgpetclinic.model.Pet;

public interface PetService {

	Pet findById(Long id);
	
	Pet save(Pet pet);
	
	Set<Pet> findAll();
}
