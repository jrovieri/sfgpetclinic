package io.jrovieri.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import io.jrovieri.sfgpetclinic.model.Owner;
import io.jrovieri.sfgpetclinic.services.OwnerService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

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
		return super.save(owner.getId(), owner);
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
		// TODO Auto-generated method stub
		return null;
	}
}
