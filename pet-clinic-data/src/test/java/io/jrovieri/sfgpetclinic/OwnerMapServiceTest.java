package io.jrovieri.sfgpetclinic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import io.jrovieri.sfgpetclinic.model.Owner;
import io.jrovieri.sfgpetclinic.services.map.OwnerMapService;
import io.jrovieri.sfgpetclinic.services.map.PetMapService;
import io.jrovieri.sfgpetclinic.services.map.PetTypeMapService;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OwnerMapServiceTest {

  OwnerMapService ownerMapService;

  final Long ownerID = 1L;
  final String lastName = "Smith";

  @BeforeEach
  void setUp() {
    ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
    ownerMapService.save(Owner.builder().id(ownerID).lastName(lastName).build());
  }

  @Test
  void findAll() {
    Set<Owner> ownerSet = ownerMapService.findAll();
    assertEquals(1, ownerSet.size());
  }

  @Test
  void findById() {
    Owner owner = ownerMapService.findById(ownerID);
    assertEquals(ownerID, owner.getId());
  }

  @Test
  void saveExistingID() {
    Long ownerID = 2L;
    Owner owner = Owner.builder().id(ownerID).build();
    Owner savedOwner = ownerMapService.save(owner);
    assertEquals(ownerID, savedOwner.getId());
  }

  @Test
  void saveNoID() {
    Owner savedOwner = ownerMapService.save(Owner.builder().build());
    assertNotNull(savedOwner);
    assertNotNull(savedOwner.getId());
  }

  @Test
  void delete() {
    ownerMapService.delete(ownerMapService.findById(ownerID));
    assertEquals(0, ownerMapService.findAll().size());
  }

  @Test
  void deleteById() {
    ownerMapService.deleteById(ownerID);
    assertEquals(0, ownerMapService.findAll().size());
  }

  @Test
  void findByLastName() {
    Owner smith = ownerMapService.findByLastname(lastName);
    assertNotNull(smith);
    assertEquals(ownerID, smith.getId());
  }

  @Test
  void findByLastNameNotFound() {
    Owner smith = ownerMapService.findByLastname("miller");
    assertNull(smith);
  }
}
