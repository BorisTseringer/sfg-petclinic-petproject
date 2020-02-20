package tseringer.boris.sfgpetclinicpetproject.services;

import tseringer.boris.sfgpetclinicpetproject.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findBySecondName(String secondName);

}
