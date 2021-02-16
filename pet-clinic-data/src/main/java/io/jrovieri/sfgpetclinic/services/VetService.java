package io.jrovieri.sfgpetclinic.services;

import java.util.Set;

import io.jrovieri.sfgpetclinic.model.Vet;

public interface VetService {

	Vet findById(Long id);
	
	Vet save(Vet pet);
	
	Set<Vet> findAll();
}