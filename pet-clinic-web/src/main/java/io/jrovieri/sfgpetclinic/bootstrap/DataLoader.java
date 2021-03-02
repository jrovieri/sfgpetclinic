package io.jrovieri.sfgpetclinic.bootstrap;

import io.jrovieri.sfgpetclinic.model.Owner;
import io.jrovieri.sfgpetclinic.model.Pet;
import io.jrovieri.sfgpetclinic.model.PetType;
import io.jrovieri.sfgpetclinic.model.Specialty;
import io.jrovieri.sfgpetclinic.model.Vet;
import io.jrovieri.sfgpetclinic.model.Visit;
import io.jrovieri.sfgpetclinic.services.OwnerService;
import io.jrovieri.sfgpetclinic.services.PetTypeService;
import io.jrovieri.sfgpetclinic.services.SpecialtyService;
import io.jrovieri.sfgpetclinic.services.VetService;
import io.jrovieri.sfgpetclinic.services.VisitService;
import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;
  private final PetTypeService petTypeService;
  private final SpecialtyService specialtyService;
  private final VisitService visitService;

  public DataLoader(
      OwnerService ownerService,
      VetService vetService,
      PetTypeService petTypeService,
      SpecialtyService specialtyService,
      VisitService visitService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
    this.petTypeService = petTypeService;
    this.specialtyService = specialtyService;
    this.visitService = visitService;
  }

  @Override
  public void run(String... args) throws Exception {
    int count = petTypeService.findAll().size();

    if (count == 0) {
      PetType dog = new PetType();
      dog.setName("Dog");
      PetType savedDogPetType = petTypeService.save(dog);

      PetType cat = new PetType();
      cat.setName("Cat");
      PetType savedCatPetType = petTypeService.save(cat);

      Specialty radiology = new Specialty();
      radiology.setDescription("Radiology");
      Specialty savedRadiology = specialtyService.save(radiology);

      Specialty surgery = new Specialty();
      surgery.setDescription("Surgery");
      Specialty savedSurgery = specialtyService.save(surgery);

      Specialty dentistry = new Specialty();
      dentistry.setDescription("dentistry");
      Specialty savedDentistry = specialtyService.save(dentistry);

      Owner owner1 = new Owner();
      owner1.setFirstName("Michael");
      owner1.setLastName("Weston");
      owner1.setAddress("123 Brickerel");
      owner1.setCity("Miami");
      owner1.setTelephone("1231231234");

      Pet mikesPet = new Pet();
      mikesPet.setPetType(savedDogPetType);
      mikesPet.setOwner(owner1);
      mikesPet.setBirthDate(LocalDate.now());
      mikesPet.setName("Rosco");
      owner1.getPets().add(mikesPet);

      ownerService.save(owner1);

      Owner owner2 = new Owner();
      owner2.setFirstName("Fiona");
      owner2.setLastName("Glenanne");
      owner2.setAddress("123 Brickerel");
      owner2.setCity("Miami");
      owner2.setTelephone("1231231234");

      Pet fionasCat = new Pet();
      fionasCat.setName("Just Cat");
      fionasCat.setOwner(owner2);
      fionasCat.setBirthDate(LocalDate.now());
      fionasCat.setPetType(savedCatPetType);
      owner2.getPets().add(fionasCat);

      ownerService.save(owner2);

      Visit catVisit = new Visit();
      catVisit.setPet(fionasCat);
      catVisit.setDate(LocalDate.now());
      catVisit.setDescription("Sneezy Kitty");

      visitService.save(catVisit);

      System.out.println("Loaded Owners....");

      Vet vet1 = new Vet();
      vet1.setFirstName("Sam");
      vet1.setLastName("Axe");
      vet1.getSpecialties().add(savedRadiology);

      vetService.save(vet1);

      Vet vet2 = new Vet();
      vet2.setFirstName("Jessie");
      vet2.setLastName("Porter");

      vet2.getSpecialties().add(savedSurgery);

      vetService.save(vet2);

      System.out.println("Loaded Vets....");
    }
  }
}
