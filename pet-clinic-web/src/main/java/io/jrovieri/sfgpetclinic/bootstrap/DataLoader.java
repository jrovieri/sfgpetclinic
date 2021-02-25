package io.jrovieri.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.jrovieri.sfgpetclinic.model.Owner;
import io.jrovieri.sfgpetclinic.model.Pet;
import io.jrovieri.sfgpetclinic.model.PetType;
import io.jrovieri.sfgpetclinic.model.Vet;
import io.jrovieri.sfgpetclinic.services.OwnerService;
import io.jrovieri.sfgpetclinic.services.PetTypeService;
import io.jrovieri.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}

	@Override
	public void run(String... args) throws Exception {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType dogType = this.petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType catType = this.petTypeService.save(cat);
		
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
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("John");
		vet2.setLastName("Wilkes");
		vetService.save(vet2);
		
		System.out.println("Loading Vets....");
	}

}
