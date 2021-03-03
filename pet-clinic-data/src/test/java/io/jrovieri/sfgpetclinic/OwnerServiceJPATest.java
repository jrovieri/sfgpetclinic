package io.jrovieri.sfgpetclinic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.jrovieri.sfgpetclinic.model.Owner;
import io.jrovieri.sfgpetclinic.repositories.OwnerRepository;
import io.jrovieri.sfgpetclinic.repositories.PetRepository;
import io.jrovieri.sfgpetclinic.repositories.PetTypeRepository;
import io.jrovieri.sfgpetclinic.services.jpa.OwnerServiceJPA;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class OwnerServiceJPATest {

  @Mock OwnerRepository ownerRepository;

  @Mock PetRepository petRepository;

  @Mock PetTypeRepository petTypeRepository;

  @InjectMocks OwnerServiceJPA service;

  Owner returnOwner;

  @BeforeEach
  void setUp() {
    returnOwner = Owner.builder().id(1L).lastName("Smith").build();
  }

  @Test
  void findByLastName() {
    Owner returnedOwner = Owner.builder().id(1L).lastName("Smith").build();

    when(ownerRepository.findByLastName(any())).thenReturn(returnedOwner);

    Owner smith = service.findByLastname("smith");

    assertEquals("Smith", smith.getLastName());

    verify(ownerRepository).findByLastName(any());
  }

  @Test
  void findAll() {
    Set<Owner> ownerSet = new HashSet<>();
    ownerSet.add(Owner.builder().id(1L).build());
    ownerSet.add(Owner.builder().id(2L).build());

    when(ownerRepository.findAll()).thenReturn(ownerSet);

    Set<Owner> owners = service.findAll();

    assertNotNull(owners);
    assertEquals(2, owners.size());
  }

  @Test
  void findById() {
    when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

    Owner owner = service.findById(1L);
    assertNotNull(owner);
  }

  @Test
  void findByIdNotFound() {
    when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

    Owner owner = service.findById(1L);
    assertNull(owner);
  }

  @Test
  void save() {
    Owner ownerToSave = Owner.builder().id(1L).build();

    when(ownerRepository.save(any())).thenReturn(returnOwner);

    Owner savedOwner = service.save(ownerToSave);

    assertNotNull(savedOwner);

    verify(ownerRepository).save(any());
  }

  @Test
  void delete() {
    service.delete(returnOwner);
    verify(ownerRepository).delete(any());
  }

  @Test
  void deleteById() {
    service.deleteById(1L);
    verify(ownerRepository).deleteById(anyLong());
  }
}
