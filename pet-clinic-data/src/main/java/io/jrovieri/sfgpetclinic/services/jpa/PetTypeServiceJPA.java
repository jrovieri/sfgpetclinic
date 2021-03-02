package io.jrovieri.sfgpetclinic.services.jpa;

import io.jrovieri.sfgpetclinic.model.PetType;
import io.jrovieri.sfgpetclinic.repositories.PetTypeRepository;
import io.jrovieri.sfgpetclinic.services.PetTypeService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class PetTypeServiceJPA implements PetTypeService {

  private final PetTypeRepository petTypeRepository;

  public PetTypeServiceJPA(PetTypeRepository petTypeRepository) {
    this.petTypeRepository = petTypeRepository;
  }

  @Override
  public Set<PetType> findAll() {
    Set<PetType> petTypes = new HashSet<>();
    petTypeRepository.findAll().forEach(petTypes::add);

    return petTypes;
  }

  @Override
  public PetType findById(Long id) {
    return petTypeRepository.findById(id).orElse(null);
  }

  @Override
  public PetType save(PetType object) {
    return petTypeRepository.save(object);
  }

  @Override
  public void delete(PetType object) {
    petTypeRepository.delete(object);
  }

  @Override
  public void deleteById(Long id) {
    petTypeRepository.deleteById(id);
  }
}
