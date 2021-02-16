package io.jrovieri.sfgpetclinic.services;

import io.jrovieri.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

	Owner findByLastname(String lastName);

}
