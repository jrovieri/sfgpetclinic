package io.jrovieri.sfgpetclinic.services.map;

import io.jrovieri.sfgpetclinic.model.Specialty;
import io.jrovieri.sfgpetclinic.model.Vet;
import io.jrovieri.sfgpetclinic.services.SpecialtyService;
import io.jrovieri.sfgpetclinic.services.VetService;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

  private final SpecialtyService specialtyService;

  public VetMapService(SpecialtyService specialtyService) {
    this.specialtyService = specialtyService;
  }

  @Override
  public Set<Vet> findAll() {
    return super.findAll();
  }

  @Override
  public Vet findById(Long id) {
    return super.findById(id);
  }

  @Override
  public Vet save(Vet vet) {
    if (vet.getSpecialties().size() > 0) {
      vet.getSpecialties()
          .forEach(
              specialty -> {
                if (specialty.getId() == null) {
                  Specialty savedSpecialty = this.specialtyService.save(specialty);
                  specialty.setId(savedSpecialty.getId());
                }
              });
    }
    return super.save(vet);
  }

  @Override
  public void delete(Vet vet) {
    super.delete(vet);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }
}
