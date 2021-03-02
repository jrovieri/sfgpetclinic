package io.jrovieri.sfgpetclinic.services.map;

import io.jrovieri.sfgpetclinic.model.Specialty;
import io.jrovieri.sfgpetclinic.services.SpecialtyService;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class SpecialtyMapService extends AbstractMapService<Specialty, Long>
    implements SpecialtyService {

  @Override
  public Set<Specialty> findAll() {
    return super.findAll();
  }

  @Override
  public Specialty findById(Long id) {
    return super.findById(id);
  }

  @Override
  public Specialty save(Specialty object) {
    return super.save(object);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public void delete(Specialty object) {
    super.delete(object);
  }
}
