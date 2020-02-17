package tseringer.boris.sfgpetclinicpetproject.services;

import tseringer.boris.sfgpetclinicpetproject.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findById(Long id);
    Owner findBySecondName(String secondName);
    Owner save(Owner owner);
    Set<Owner> findAll();

}
