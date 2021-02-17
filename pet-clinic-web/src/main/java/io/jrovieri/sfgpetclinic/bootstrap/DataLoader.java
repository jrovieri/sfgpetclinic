package io.jrovieri.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.jrovieri.sfgpetclinic.model.Owner;
import io.jrovieri.sfgpetclinic.model.Vet;
import io.jrovieri.sfgpetclinic.services.OwnerService;
import io.jrovieri.sfgpetclinic.services.VetService;
import io.jrovieri.sfgpetclinic.services.map.OwnerServiceMap;
import io.jrovieri.sfgpetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	
	public DataLoader() {
		ownerService = new OwnerServiceMap();
		vetService = new VetServiceMap();
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setId(2L);
		owner2.setFirstName("Jessie");
		owner2.setLastName("Porter");
		ownerService.save(owner2);
		
		System.out.println("Loading Owners...");
		
		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setId(2L);
		vet2.setFirstName("John");
		vet2.setLastName("Wilkes");
		vetService.save(vet2);
		
		System.out.println("Loading Vets....");
	}

}
