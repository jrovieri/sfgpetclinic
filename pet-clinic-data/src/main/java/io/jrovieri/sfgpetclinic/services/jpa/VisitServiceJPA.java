package io.jrovieri.sfgpetclinic.services.jpa;

import io.jrovieri.sfgpetclinic.model.Visit;
import io.jrovieri.sfgpetclinic.repositories.VisitRepository;
import io.jrovieri.sfgpetclinic.services.VisitService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class VisitServiceJPA implements VisitService {

  private final VisitRepository visitRepository;

  public VisitServiceJPA(VisitRepository visitRepository) {
    this.visitRepository = visitRepository;
  }

  @Override
  public Set<Visit> findAll() {
    Set<Visit> visits = new HashSet<>();
    visitRepository.findAll().forEach(visits::add);
    return visits;
  }

  @Override
  public Visit findById(Long id) {
    return visitRepository.findById(id).orElse(null);
  }

  @Override
  public Visit save(Visit object) {
    return visitRepository.save(object);
  }

  @Override
  public void delete(Visit object) {
    visitRepository.delete(object);
  }

  @Override
  public void deleteById(Long id) {
    visitRepository.deleteById(id);
  }
}
