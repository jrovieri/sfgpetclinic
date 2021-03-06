package io.jrovieri.sfgpetclinic.services.jpa;

import io.jrovieri.sfgpetclinic.model.Vet;
import io.jrovieri.sfgpetclinic.repositories.VetRepository;
import io.jrovieri.sfgpetclinic.services.VetService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class VetServiceJPA implements VetService {

  private final VetRepository vetRepository;

  public VetServiceJPA(VetRepository vetRepository) {
    this.vetRepository = vetRepository;
  }

  @Override
  public Set<Vet> findAll() {
    Set<Vet> vets = new HashSet<>();
    vetRepository.findAll().forEach(vets::add);

    return vets;
  }

  @Override
  public Vet findById(Long id) {
    return vetRepository.findById(id).orElse(null);
  }

  @Override
  public Vet save(Vet object) {
    return vetRepository.save(object);
  }

  @Override
  public void delete(Vet object) {
    vetRepository.delete(object);
  }

  @Override
  public void deleteById(Long id) {
    vetRepository.deleteById(id);
  }
}
