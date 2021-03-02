package io.jrovieri.sfgpetclinic.repositories;

import io.jrovieri.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {}
