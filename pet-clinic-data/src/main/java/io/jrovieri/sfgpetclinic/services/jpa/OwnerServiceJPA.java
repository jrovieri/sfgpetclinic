package io.jrovieri.sfgpetclinic.services.jpa;

import io.jrovieri.sfgpetclinic.model.Owner;
import io.jrovieri.sfgpetclinic.repositories.OwnerRepository;
import io.jrovieri.sfgpetclinic.repositories.PetRepository;
import io.jrovieri.sfgpetclinic.repositories.PetTypeRepository;
import io.jrovieri.sfgpetclinic.services.OwnerService;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class OwnerServiceJPA implements OwnerService {

  private final OwnerRepository ownerRepository;
  private final PetRepository petRepository;
  private final PetTypeRepository petTypeRepository;

  public OwnerServiceJPA(
      OwnerRepository ownerRepository,
      PetRepository petRepository,
      PetTypeRepository petTypeRepository) {
    this.ownerRepository = ownerRepository;
    this.petRepository = petRepository;
    this.petTypeRepository = petTypeRepository;
  }

  @Override
  public Set<Owner> findAll() {
    Set<Owner> owners = new HashSet<>();
    ownerRepository.findAll().forEach(owners::add);

    return owners;
  }

  @Override
  public Owner findById(Long id) {
    Optional<Owner> owner = ownerRepository.findById(id);
    return owner.orElse(null);
  }

  @Override
  public Owner save(Owner object) {
    return ownerRepository.save(object);
  }

  @Override
  public void delete(Owner object) {
    ownerRepository.delete(object);
  }

  @Override
  public void deleteById(Long id) {
    ownerRepository.deleteById(id);
  }

  @Override
  public Owner findByLastname(String lastName) {
    return ownerRepository.findByLastName(lastName);
  }
}
