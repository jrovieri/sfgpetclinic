package io.jrovieri.sfgpetclinic.services.jpa;

import io.jrovieri.sfgpetclinic.model.Specialty;
import io.jrovieri.sfgpetclinic.repositories.SpecialtyRepository;
import io.jrovieri.sfgpetclinic.services.SpecialtyService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class SpecialtyServiceJPA implements SpecialtyService {

  private final SpecialtyRepository specialtyRepository;

  public SpecialtyServiceJPA(SpecialtyRepository specialtyRepository) {
    this.specialtyRepository = specialtyRepository;
  }

  @Override
  public Set<Specialty> findAll() {
    Set<Specialty> specialties = new HashSet<>();
    specialtyRepository.findAll().forEach(specialties::add);
    return specialties;
  }

  @Override
  public Specialty findById(Long id) {
    return specialtyRepository.findById(id).orElse(null);
  }

  @Override
  public Specialty save(Specialty object) {
    return specialtyRepository.save(object);
  }

  @Override
  public void delete(Specialty object) {
    specialtyRepository.delete(object);
  }

  @Override
  public void deleteById(Long id) {
    specialtyRepository.deleteById(id);
  }
}
