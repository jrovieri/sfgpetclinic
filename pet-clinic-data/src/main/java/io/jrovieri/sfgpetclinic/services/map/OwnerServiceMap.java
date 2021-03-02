package io.jrovieri.sfgpetclinic.services.map;

import io.jrovieri.sfgpetclinic.model.Owner;
import io.jrovieri.sfgpetclinic.model.Pet;
import io.jrovieri.sfgpetclinic.services.OwnerService;
import io.jrovieri.sfgpetclinic.services.PetService;
import io.jrovieri.sfgpetclinic.services.PetTypeService;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

  private final PetTypeService petTypeService;
  private final PetService petService;

  public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
    super();
    this.petTypeService = petTypeService;
    this.petService = petService;
  }

  @Override
  public Set<Owner> findAll() {
    return super.findAll();
  }

  @Override
  public Owner findById(Long id) {
    return super.findById(id);
  }

  @Override
  public Owner save(Owner owner) {
    if (owner != null) {
      if (owner.getPets() != null) {
        owner
            .getPets()
            .forEach(
                pet -> {
                  if (pet.getPetType() != null) {
                    if (pet.getPetType().getId() == null) {
                      pet.setPetType(petTypeService.save(pet.getPetType()));
                    }
                  } else {
                    throw new RuntimeException("Pet Type is required");
                  }

                  if (pet.getId() == null) {
                    Pet savedPet = petService.save(pet);
                    pet.setId(savedPet.getId());
                  }
                });
      }
      return super.save(owner);
    } else {
      return null;
    }
  }

  @Override
  public void delete(Owner owner) {
    super.delete(owner);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public Owner findByLastname(String lastName) {
    return null;
  }
}
