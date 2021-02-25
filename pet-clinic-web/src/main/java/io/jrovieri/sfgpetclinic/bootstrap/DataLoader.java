package io.jrovieri.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.jrovieri.sfgpetclinic.model.Owner;
import io.jrovieri.sfgpetclinic.model.Pet;
import io.jrovieri.sfgpetclinic.model.PetType;
import io.jrovieri.sfgpetclinic.model.Specialty;
import io.jrovieri.sfgpetclinic.model.Vet;
import io.jrovieri.sfgpetclinic.services.OwnerService;
import io.jrovieri.sfgpetclinic.services.PetTypeService;
import io.jrovieri.sfgpetclinic.services.SpecialtyService;
import io.jrovieri.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialtyService specialtyService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialtyService specialtyService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtyService = specialtyService;
	}

	@Override
	public void run(String... args) throws Exception {
		int count = petTypeService.findAll().size();

		if (count == 0) {
			/*
			 * PetType
			 */
			PetType dog = new PetType();
			dog.setName("Dog");
			PetType dogType = this.petTypeService.save(dog);

			PetType cat = new PetType();
			cat.setName("Cat");
			PetType catType = this.petTypeService.save(cat);

			/*
			 * Specialty
			 */
			Specialty radiology = new Specialty();
			radiology.setDescription("Radiology");
			Specialty savedRadiology = specialtyService.save(radiology);

			Specialty surgery = new Specialty();
			surgery.setDescription("Surgery");
			Specialty savedSurgery = specialtyService.save(surgery);

			Specialty dentistry = new Specialty();
			dentistry.setDescription("Dentistry");
			Specialty savedDentistry = specialtyService.save(dentistry);

			/*
			 * Owner 1: Michael
			 */
			Owner owner1 = new Owner();
			owner1.setFirstName("Michael");
			owner1.setLastName("Weston");
			owner1.setAddress("123 Brickerel");
			owner1.setCity("Miami");
			owner1.setTelephone("(555) 555-1234");

			Pet mikesPet = new Pet();
			mikesPet.setPetType(dogType);
			mikesPet.setOwner(owner1);
			mikesPet.setBirthDate(LocalDate.now());
			mikesPet.setName("Rosco");
			owner1.getPets().add(mikesPet);
			ownerService.save(owner1);

			/*
			 * Owner 2: Jessie
			 */
			Owner owner2 = new Owner();
			owner2.setFirstName("Jessie");
			owner2.setLastName("Porter");
			owner2.setAddress("123 Brickerel");
			owner2.setCity("Miami");
			owner2.setTelephone("(555) 555-1234");

			Pet jessiesPet = new Pet();
			jessiesPet.setName("Archimeds");
			jessiesPet.setOwner(owner2);
			jessiesPet.setBirthDate(LocalDate.now());
			jessiesPet.setPetType(catType);
			owner2.getPets().add(jessiesPet);
			ownerService.save(owner2);

			System.out.println("Loading Owners...");

			/*
			 * Vets
			 */
			Vet vet1 = new Vet();
			vet1.setFirstName("Sam");
			vet1.setLastName("Axe");
			vet1.getSpecialties().add(savedRadiology);
			vet1.getSpecialties().add(savedDentistry);
			vetService.save(vet1);

			Vet vet2 = new Vet();
			vet2.setFirstName("John");
			vet2.setLastName("Wilkes");
			vet2.getSpecialties().add(savedSurgery);
			vetService.save(vet2);

			System.out.println("Loading Vets....");
		}
	}
}
