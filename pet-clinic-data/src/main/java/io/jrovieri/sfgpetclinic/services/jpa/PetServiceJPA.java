package io.jrovieri.sfgpetclinic.services.jpa;

import io.jrovieri.sfgpetclinic.model.Pet;
import io.jrovieri.sfgpetclinic.repositories.PetRepository;
import io.jrovieri.sfgpetclinic.services.PetService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class PetServiceJPA implements PetService {

  private final PetRepository petRepository;

  public PetServiceJPA(PetRepository petRepository) {
    this.petRepository = petRepository;
  }

  @Override
  public Set<Pet> findAll() {
    Set<Pet> pets = new HashSet<>();
    petRepository.findAll().forEach(pets::add);
    return pets;
  }

  @Override
  public Pet findById(Long id) {
    return petRepository.findById(id).orElse(null);
  }

  @Override
  public Pet save(Pet object) {
    return petRepository.save(object);
  }

  @Override
  public void delete(Pet object) {
    petRepository.delete(object);
  }

  @Override
  public void deleteById(Long id) {
    petRepository.deleteById(id);
  }
}
