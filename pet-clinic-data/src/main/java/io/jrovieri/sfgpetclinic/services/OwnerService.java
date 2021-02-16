package io.jrovieri.sfgpetclinic.services;

import java.util.Set;

import io.jrovieri.sfgpetclinic.model.Owner;

public interface OwnerService {

	Owner findById(Long id);
	
	Owner findByLastname(String lastName);
	
	Owner save(Owner owner);
	
	Set<Owner> findAll();
}
